package com.example.soap

import groovy.xml.XmlUtil
import org.apache.log4j.LogManager
import org.slf4j.Logger
import wslite.soap.SOAPClient
import wslite.soap.SOAPVersion

import java.beans.XMLEncoder

public class AppPushServiceClient {
    private static logger = LogManager.getLogger(AppPushServiceClient.class)

    public def SendAdSync(AppAdMessage appAdMessage) {
        /* request example:
        HTTP/1.1 100 Continue

        POST /AppPushService.svc HTTP/1.1
        Content-Type: application/soap+xml; charset=utf-8
        Host: hzbs.huazhu.com:7511
        Content-Length: 1161
        Expect: 100-continue
        Accept-Encoding: gzip, deflate
        Connection: Keep-Alive

        <s:Envelope xmlns:s="http://www.w3.org/2003/05/soap-envelope" xmlns:a="http://www.w3.org/2005/08/addressing">
          <s:Header>
            <a:Action s:mustUnderstand="1">http://tempuri.org/IAppPushService/SendAdSync</a:Action>
            <a:MessageID>urn:uuid:afb5a785-0528-4eb7-8097-4dd6353a75e3</a:MessageID>
            <a:ReplyTo>
              <a:Address>http://www.w3.org/2005/08/addressing/anonymous</a:Address>
            </a:ReplyTo>
            <a:To s:mustUnderstand="1">http://hzbs.huazhu.com:7511/AppPushService.svc</a:To>
          </s:Header>
          <s:Body>
            <SendAdSync xmlns="http://tempuri.org/">
              <message xmlns:b="http://schemas.datacontract.org/2004/07/HuaZhu.BlueSky.MessageChannel.Contract" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                <b:AppID i:nil="true" />
                <b:BusinessCode>Rbs</b:BusinessCode>
                <b:ClientCode i:nil="true" />
                <b:HotelId>2000014</b:HotelId>
                <b:IsAsync>false</b:IsAsync>
                <b:Language i:nil="true" />
                <b:MemberID>059606324</b:MemberID>
                <b:Message>test 04 message</b:Message>
                <b:PushDate i:nil="true" />
                <b:PushInstanceKey>43fa37b6-c622-4665-8400-4f3d7fa4c7ec</b:PushInstanceKey>
                <b:TimeStamp i:nil="true" />
                <b:TimeZoneID i:nil="true" />
                <b:Title>test 04</b:Title>
                <b:URL>http://cnbeta.com</b:URL>
              </message>
            </SendAdSync>
          </s:Body>
        </s:Envelope>
        */




        def content = """<s:Envelope xmlns:s="http://www.w3.org/2003/05/soap-envelope" xmlns:a="http://www.w3.org/2005/08/addressing">
  <s:Header>
    <a:Action s:mustUnderstand="1">http://tempuri.org/IAppPushService/SendAdSync</a:Action>
    <a:MessageID>urn:uuid:afb5a785-0528-4eb7-8097-4dd6353a75e3</a:MessageID>
    <a:ReplyTo>
      <a:Address>http://www.w3.org/2005/08/addressing/anonymous</a:Address>
    </a:ReplyTo>
    <a:To s:mustUnderstand="1">http://hzbs.huazhu.com:7511/AppPushService.svc</a:To>
  </s:Header>
  <s:Body>
    <SendAdSync xmlns="http://tempuri.org/">
      <message xmlns:b="http://schemas.datacontract.org/2004/07/HuaZhu.BlueSky.MessageChannel.Contract" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
        <b:AppID>${XmlUtil.escapeXml(appAdMessage.appId)}</b:AppID>
        <b:BusinessCode>${XmlUtil.escapeXml(appAdMessage.businessCode)}</b:BusinessCode>
        <b:ClientCode i:nil="true" />
        <b:HotelId>${XmlUtil.escapeXml(appAdMessage.hotelId)}</b:HotelId>
        <b:IsAsync>false</b:IsAsync>
        <b:Language i:nil="true" />
        <b:MemberID>${XmlUtil.escapeXml(appAdMessage.memberId)}</b:MemberID>
        <b:Message>${XmlUtil.escapeXml(appAdMessage.message)}</b:Message>
        <b:PushDate i:nil="true" />
        <b:PushInstanceKey>43fa37b6-c622-4665-8400-4f3d7fa4c7ec</b:PushInstanceKey>
        <b:TimeStamp i:nil="true" />
        <b:TimeZoneID i:nil="true" />
        <b:Title>${XmlUtil.escapeXml(appAdMessage.title)}</b:Title>
        <b:URL>${XmlUtil.escapeXml(appAdMessage.businessCode)}</b:URL>
      </message>
    </SendAdSync>
  </s:Body>
</s:Envelope>
"""
        def client = new SOAPClient("http://hzbs.huazhu.com:7511/AppPushService.svc")
        def response = client.send(SOAPAction: 'http://tempuri.org/IAppPushService/SendAdSync', content)

        logger.info(response.body.SendAdSyncResponse.SendAdSyncResult.ResultCode)
        logger.info(response.body.SendAdSyncResponse.SendAdSyncResult.ResultDesc)

        return response




//        def client = new SOAPClient("http://hzbs.huazhu.com:7511/AppPushService.svc")
//        def response = client.send(SOAPAction: 'http://tempuri.org/IAppPushService/SendAdSync') {
//            version SOAPVersion.V1_2        // SOAPVersion.V1_1 is default
//            encoding "UTF-8"           // "UTF-8" is default encoding for xml
//            envelopeAttributes "xmlns:a": "http://wwwA.w3.org/2005/08/addressing"
//            header {
//                'a:Action'(mustUnderstand:1, "http://tempuri.org/IAppPushService/SendAdSync")
//            }
//            body {
//                SendAdSync (xmlns:'http://tempuri.org/') {
//                    //message('xmlns': 'http://schemas.datacontract.org/2004/07/HuaZhu.BlueSky.MessageChannel.Contract') {
//                    message('xmlns':'http://tempuri.org/') {
//                        AppID("RbsMms")
//                        BusinessCode("RbsMmsInform")
//                        ClientCode(null)
//                        HotelId("2000014")
//                        IsAsync(false)
//                        Language(null)
//                        MemberID("059606324")
//                        Message("test 04 message")
//                        PushDate(null)
//                        PushInstanceKey("43fa37b6-c622-4665-8400-4f3d7fa4c7ec")
//                        TimeStamp(null)
//                        TimeZoneID(null)
//                        Title("test 04")
//                        URL("https://github.com/")
//                    }
//                }
//            }
//        }
//        return response
    }
}

public class AppAdMessage {
    String title
    String url
    String appId
    String businessCode
    String hotelId
    String memberId
    String message
}
