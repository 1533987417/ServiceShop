package com.example.demo2.tools;

import com.example.demo2.Wxcontroller.testController;
import com.example.demo2.tools.WxEntity.CreateOrderRequest;
import com.example.demo2.tools.WxEntity.CreateOrderResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
@Service
public class WeiXinUtil {
    @Autowired
    LoggerClient loggerClient;
    private Logger logger = Logger.getLogger(WeiXinUtil.class);
    /**
     * 微信统一下单
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public CreateOrderResponse createOrder(CreateOrderRequest request,String logId) {

        HttpClient client=new HttpClient();
        loggerClient.info("微信统一下单请求参数="+JsonParse.getInstance().toJson(request),request.getAppid(),logId);
        String result= null;
        try {
            result = client.post("https://api.mch.weixin.qq.com/pay/unifiedorder", XMLUtil.convertToXml(request));
            loggerClient.info("微信统一下单请求参数返回"+result,request.getAppid(),logId);
            if(result==null||result.equals("")){
                loggerClient.error("微信统一下单请求参数返回为空"+result,request.getAppid(),logId);
              return null;
            }
        } catch (UnsupportedEncodingException e) {
            loggerClient.error("微信统一下单请求异常",e,request.getAppid(),logId);
            return null;
        }
        return  (CreateOrderResponse)XMLUtil.convertXmlStrToObject(CreateOrderResponse.class,result);
    }



}
