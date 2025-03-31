package com.ptithcm.quanlytrasua.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptithcm.quanlytrasua.Config.Config;
import com.ptithcm.quanlytrasua.DTO.PaymentResDTO;
import com.ptithcm.quanlytrasua.momo.MomoModel;
import com.ptithcm.quanlytrasua.momo.ResultMoMo;
import com.ptithcm.quanlytrasua.momo.utils.Constant;
import com.ptithcm.quanlytrasua.momo.utils.Decode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/thanh-toan")
public class PaymentController {
    @GetMapping("create-payment")
    public ResponseEntity<?> createPayment(@RequestParam("amount") long amount) throws UnsupportedEncodingException {

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount*100));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "[Thanh toan don hang");
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        PaymentResDTO paymentResDTO = new PaymentResDTO();
        paymentResDTO.setStatus("OK");
        paymentResDTO.setMessage("Success!");
        paymentResDTO.setUrl(paymentUrl);
        return ResponseEntity.status(HttpStatus.OK).body(paymentResDTO);
//        com.google.gson.JsonObject job = new JsonObject();
//        job.addProperty("code", "00");
//        job.addProperty("message", "success");
//        job.addProperty("data", paymentUrl);
//        Gson gson = new Gson();
//        resp.getWriter().write(gson.toJson(job));
    }
    @GetMapping(path = "/momo-payment")
    public ResponseEntity<?> createMomoPayment(@RequestParam("amount") int amount,@RequestParam("orderId") int orderID, HttpServletRequest request) {

        String orderIdString = Integer.toString(orderID);
        MomoModel jsonRequest = new MomoModel();
        jsonRequest.setPartnerCode(Constant.IDMOMO);
        jsonRequest.setOrderId(orderIdString);
        jsonRequest.setStoreId(orderIdString);
        jsonRequest.setRedirectUrl(Constant.redirectUrl);
        jsonRequest.setIpnUrl(Constant.ipnUrl);

        String amountString = String.valueOf(amount);
        jsonRequest.setAmount(amountString);
        jsonRequest.setOrderInfo("Thanh toán trà sữa cửa hàng Luân's MilkTea");
        jsonRequest.setRequestId(orderIdString);
        jsonRequest.setOrderType(Constant.orderType);
        jsonRequest.setRequestType(Constant.requestType);
        jsonRequest.setTransId("1");
        jsonRequest.setResultCode("200");
        jsonRequest.setMessage("");
        jsonRequest.setPayType(Constant.payType);
        jsonRequest.setResponseTime("300000");
        jsonRequest.setExtraData("");
        String decode = "accessKey=" + Constant.accessKey + "&amount=" + jsonRequest.getAmount() + "&extraData=" +
                jsonRequest.getExtraData() + "&ipnUrl=" + Constant.ipnUrl + "&orderId=" + jsonRequest.getOrderId() + "&orderInfo=" +
                jsonRequest.getOrderInfo() + "&partnerCode=" + jsonRequest.getPartnerCode() + "&redirectUrl=" +
                Constant.redirectUrl + "&requestId=" + jsonRequest.getRequestId() + "&requestType=" +
                Constant.requestType;
        String signature = Decode.encode(Constant.serectkey, decode);
        jsonRequest.setSignature(signature);

        // Convert the request to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(jsonRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", "Failed to create payment request JSON"));
        }

        // Send the request to Momo
        HttpClient client = HttpClient.newHttpClient();
        ResultMoMo res;
        try {
            HttpRequest requestMomo = HttpRequest.newBuilder()
                    .uri(new URI(Constant.Url))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .headers("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = client.send(requestMomo, HttpResponse.BodyHandlers.ofString());
            res = mapper.readValue(response.body(), ResultMoMo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", "Failed to communicate with Momo"));
        }
        if (res == null || res.getPayUrl() == null) {
            return ResponseEntity.status(500).body(Map.of("error", "Payment failed"));
        }
        System.out.println(res.getDeeplink());
        System.out.println(res.getQrCodeUrl());
//        Map<String, String> responseMap = new HashMap<>();
//        responseMap.put("code", res.getDeeplink());
//        System.out.println(res.getDeeplink());
//        responseMap.put("payUrl", res.getPayUrl());

//        return ResponseEntity.ok(responseMap);
        //        responseMap.put("code", "<QRCode \r\n"
//        		+ "  value=\"https://www.example.com/payment?orderId=1234567890&userId=0987654321&transactionId=abcdefghij&amount=100000&currency=VND&description=This+is+a+very+long+description+to+generate+a+complex+QR+code+with+many+modules+to+see+how+version+40+looks+like\" \r\n"
//        		+ "  version={40} \r\n"
//        		+ "  size={200} \r\n"
//        		+ "/>\r\n"
//        		+ "");
        PaymentResDTO paymentResDTO = new PaymentResDTO();
        paymentResDTO.setStatus("OK");
        paymentResDTO.setMessage("Success!");
        paymentResDTO.setUrl(res.getPayUrl());
        paymentResDTO.setDeeplink(res.getDeeplink());
        System.out.println(res.getPayUrl());
        return ResponseEntity.status(HttpStatus.OK).body(paymentResDTO);
    }
}
