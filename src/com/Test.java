package com;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ivms6.core.util.XMLUtils;

/**
 * 测试
 * @date   2018年5月8日
 */
public class Test {
	
	private static final String webServiceNameSpace = "http://ws.vms.ivms6.hikvision.com";
	private static final String endpointAddress = "http://ip/vms/services/VmsSdkWebService?wsdl";
	private static final String loginAccount = "";
	private static final String password = "";
	private static final String serviceIp = "";

	public static void main(String[] args) {
		
		String tgt = sdkLogin();
		System.out.println(tgt);
	}
	
	/**
	 * 调用平台webservice登录方法
	 * @return tgt 用户登录票据
	 */
	public static String sdkLogin() {
		String result = "";
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setSOAPActionURI(webServiceNameSpace + "/sdkLogin");
			call.setTargetEndpointAddress(endpointAddress);
			call.setOperationName(new QName(webServiceNameSpace, "sdkLogin"));
			call.addParameter("loginAccount",org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.addParameter("password",org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.addParameter("serviceIp",org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
			result = (String) call.invoke(new Object[] { loginAccount, password, serviceIp });
			
			Document doc = DocumentHelper.parseText(result); // 将字符串转为XML
			List<Element> rows = XMLUtils.getElementsByXPath(doc, "/table/rows/row");
			Element element = rows.get(0);
			result = element.attributeValue("tgt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
