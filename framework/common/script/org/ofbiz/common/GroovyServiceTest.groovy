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

Debug.logInfo("-=-=-=- TEST GROOVY SERVICE -=-=-=-", "");
result = ServiceUtil.returnSuccess();

GenericEntity orderheader = delegator.makeValue("OrderHeader");
orderheader.set("orderTypeId","SALES_ORDER");
orderheader.set("orderName", "test POS proto");
orderheader.set("salesChannelEnumId", "WEB_SALES_CHANNEL");
orderheader.set("statusId", "ORDER_APPROVED");
orderheader.set("createdBy", "admin");
orderheader.set("currencyUom", "USA");
orderheader.set("productStoreId", "9000");

try {
    delegator.createSetNextSeqId(orderheader);
	Debug.logInfo("-----  Complet is --------------------------------------------------", "");
} catch (GenericEntityException e) {
	 Debug.logInfo("----- Not Complet is --------------------------------------------------", "");
}

//Debug.logInfo("-=-=-=- TEST GROOVY SERVICE -=-=-=-", "");
//result = ServiceUtil.returnSuccess();
//if (context.message) {
//    message = context.message;
//    result.successMessage = "Got message [$message] and finished fine";
//    result.result = message;
//    Debug.logInfo("----- Message is: $message -----", "");
//} else {
//    result.successMessage = "Got no message but finished fine anyway";
//    result.result = "[no message received]";
//}
////SalesOrderTest.testCreateSalesOrder();
//// Debug.logInfo("----- Save Complet is --------------------------------------------------", "");
result.successMessage = " finished fine anyway";
result.result = "[yes received]";
return result;
