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
package org.ofbiz.zxing;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilHttp;
import org.ofbiz.base.util.UtilValidate;
import org.ofbiz.entity.GenericDelegator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Events for QRCode.
 */
public class QRCodeEvents {

    public static final String module = QRCodeEvents.class.getName();
    
    /** Streams QR Code to the output. */
    public static String serveQRCodeImage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        GenericDelegator delegator = (GenericDelegator) request.getAttribute("delegator");
        Map<String, Object> parameters = UtilHttp.getParameterMap(request);
        String text = (String) parameters.get("text");
        if (UtilValidate.isEmpty(text)) {
        	text = "Error get text parameter.";
        }
        String mimeType = "application/octet-stream";
        String format = (String) parameters.get("format");
        if (UtilValidate.isEmpty(format)) {
        	format = "png";
        }
        String widthString = (String) parameters.get("width");
        String heightString = (String) parameters.get("height");

        int width = 100;
        if (UtilValidate.isEmpty(widthString)) {
        	widthString = "100";
        }
        try {
            width = Integer.parseInt(widthString);
        } catch(NumberFormatException e) {
        	// do nothing
        }

        int height = 100;
        if (UtilValidate.isEmpty(heightString)) {
        	heightString = "100";
        }
        try {
            height = Integer.parseInt(heightString);
        } catch(NumberFormatException e) {
        	// do nothing
        }

        try {
            // hack for IE and mime types
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.indexOf("MSIE") > -1) {
                Debug.log("Found MSIE changing mime type from - " + mimeType, module);
                mimeType = "application/octet-stream";
            }

            if (mimeType != null) {
                response.setContentType(mimeType);
            }
            OutputStream os = response.getOutputStream();
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(bitMatrix, format, os);
            os.flush();
        } catch (IOException e) {
            String errMsg = "Error generating qr code: " + e.toString();
            Debug.logError(e, errMsg, module);
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
        } catch (WriterException e) {
            String errMsg = "Error generating qr code: " + e.toString();
            Debug.logError(e, errMsg, module);
            request.setAttribute("_ERROR_MESSAGE_", errMsg);
            return "error";
		}

        return "success";
    }

}
