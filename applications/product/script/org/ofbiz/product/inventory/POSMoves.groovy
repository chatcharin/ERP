/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import org.ofbiz.base.util.*;
import org.ofbiz.entity.*;
import org.ofbiz.order.shoppingcart.*;
import org.ofbiz.service.ServiceUtil;
import org.ofbiz.base.util.Debug;
import org.ofbiz.entity.Delegator;
import org.ofbiz.entity.GenericEntityException;
import org.ofbiz.entity.condition.*;

Debug.logInfo("-=-=-=- TEST GROOVY SERVICE -=-=-=- "+facilityId, "");
result = ServiceUtil.returnSuccess();

activeOnly = true;
completeRequested = true;
// get the 'to' this facility transfers
//if (activeOnly) {
//    exprsTo = [EntityCondition.makeCondition("inventoryCode", EntityOperator.EQUALS, facilityId),
//               EntityCondition.makeCondition("statusId", EntityOperator.NOT_EQUAL, "IXF_COMPLETE"),
//               EntityCondition.makeCondition("statusId", EntityOperator.NOT_EQUAL, "IXF_CANCELLED")];
//} else {
//    exprsTo = [EntityCondition.makeCondition("inventoryCode", EntityOperator.EQUALS, facilityId)];
//}
if (completeRequested) {
    exprsTo = [EntityCondition.makeCondition("inventoryCode", EntityOperator.EQUALS, facilityId),
               EntityCondition.makeCondition("statusId", EntityOperator.EQUALS, "IXF_REQUESTED")];
}
ecl = EntityCondition.makeCondition(exprsTo, EntityOperator.AND);
toTransfers = delegator.findList("InventoryTransfer", ecl, null, ['sendDate'], null, false);
data = [];

//delegator.store(newBarcode);
index_number = 0;
for(item in toTransfers){
	map = [number:1, productcode:"",productname:"",unitprice:"0.0",unit:0.0,totalprice:0.0];
	index_number++;
	map.number = index_number;
	//   taxAuthorityGlAccount = delegator.findByPrimaryKey("TaxAuthorityGlAccount", [taxAuthGeoId : taxAuthority.taxAuthGeoId, taxAuthPartyId : taxAuthority.taxAuthPartyId, organizationPartyId : organizationPartyId]);
	inventoryItem = null;
	inventoryItem = delegator.findByPrimaryKey("InventoryItem",[inventoryItemId:item.inventoryItemId]);
	if(inventoryItem){
		//item.availableToPromiseTotal = inventoryItem.availableToPromiseTotal;
		map.unit = String.valueOf(inventoryItem.quantityOnHandTotal);
		Debug.logInfo("-=-=-=-=-=-=-=-=-=-=-=- feild : item.availableToPromiseTotal value : "+map.name+" -=-=-=-=-==-=-=-=-=-=-", "");
		product = null;
		product = delegator.findByPrimaryKey("Product",[productId:inventoryItem.productId]);
		if(product){
			map.productcode = inventoryItem.productId;
			map.productname = product.internalName;
		}
	}
	data.add(map);
	item.statusId = "IXF_COMPLETE";
}
delegator.storeAll(toTransfers);
if(toTransfers.get(0).inventoryCode==null){
	// new Barcode 
	newBarcode = delegator.makeValue("InventoryDO");
	delegator.setNextSubSeqId(newBarcode,"inventoryDOId",5,1);
	newBarcode.inventoryCode = "1DO-"+newBarcode.inventoryDOId;
	barcodeId = newBarcode.inventoryCode;
	delegator.createOrStore(newBarcode);
	for(item in toTransfers){
		item.inventoryCode = newBarcode.inventoryCode;
	}
	delegator.storeAll(toTransfers);
	
	Debug.logInfo("-=-=-=-=-=-=-=-=-=-=-=- feild : InventoryID value : "+newBarcode.inventoryDOId+" -=-=-=-=-==-=-=-=-=-=-", "");
	}else{
   barcodeId = toTransfers.get(0).inventoryCode;
}
	Debug.logInfo("-=-=-=-=-=-=-=-=-=-=-=- feild : InventoryID value : "+barcodeId+" -=-=-=-=-==-=-=-=-=-=-", "");

//result.successMessage = data
result.result = "[yes received]";
result.data = data;
return result;
