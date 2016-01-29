package com.jb.statistics.thirtinte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.jb.statistics.rpc.util.Constants;

public class InvokeApi {

	protected static final int IS_HIT = 1, ADD = 0;

	protected Logger logger = Logger.getLogger(InvokeApi.class);

	// public static final String IP =
	// "http://testing.gz.1251114078.cee.myqcloud.com/";

	public static final String INVOKE_URL = Constants.INVOKE_URL;

	// private Constants thirdinteConstants;

	// protected interface BuildFormParams {
	// void set(List<NameValuePair> formParams);
	// }

	public static void main(String[] args) {
		InvokeApi b = new InvokeApi();
		System.out.println(b.getMobileAndProjectId("314092257"));
	}

	private static String post(String subUrl, String userId) {

		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(INVOKE_URL + subUrl);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setReadTimeout(5000);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);

			conn.setRequestProperty("Content-Type", "application/json");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream());
			// 发送请求参数
			out.write("{\"contactId\":\"" + userId + "\"}");
			// out.write("{\"token\":\"RERFSWdRQWdsckNLUDBIOHdFSzF3NThoUi9iNk05cnRqZ242cVRzMlJ2akZVRlNiQ2Y4Tm42U2tK%0AVmpHandySVZUZTJPcGxFMlY1YwpPNUdNTEwzL3JYQi9NckhVN1VtaUlmTDA2WUc3cVpnPT9hcHBJ%0AZD0xJmtleUlkPTE%3D\"}");
			// result:{"token":"RERFSWdRQWdsckNLUDBIOHdFSzF3NjZId0NrN2dYdUNha1ZXME4vTVVGL0ZVRlNiQ2Y4Tm53VHNO%0ATk9BRFp1MWF6am9tSFJXcWtkYwpPNUdNTEwzL3JYQi9NckhVN1VtaVZ3NjB0SzUreDVVPT9hcHBJ%0AZD0xJmtleUlkPTE%3D","code":null,"msg":null}

			// private String username;
			// private String password;
			// private String ticket;
			// private String appId;

			// flush输出流的缓冲
			out.flush();

			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = in.readLine()) != null) {
				result += line;
			}

			System.out.println("result:" + result);
			return result;
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "调用失败";
	}

	public static Map<String, String> getMobileAndProjectId(String userId) {
		try {
			if ("oldVersion".equalsIgnoreCase(userId)) {
				return null;
			}

			String r = post("/xt/app/getContactInfoById.app", userId);

			JSONObject jsonObj = JSONObject.fromObject(r);
			int code = jsonObj.getInt("r");
			Map<String, String> map = null;
			if (code == 0) {
				JSONArray jsonArray = jsonObj.getJSONArray("data");
				if (jsonArray != null && jsonArray.size() > 0) {
					JSONObject jsonObject = (JSONObject) jsonArray.get(0);
					if (jsonObject != null) {
						String mobile = jsonObject.getString("mobile");
						String projectId = jsonObject.getString("projectId");
						map = new HashMap<String, String>();
						map.put("mobile", mobile);
						map.put("projectId", projectId);
						return map;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// public String post(String url, BuildFormParams bfp) {
	// // 创建默认的httpClient实例.
	// CloseableHttpClient httpClient = HttpClients.createDefault();
	//
	// // 创建httppost
	// String u = getUrl(url);
	// logger.debug("post method request:" + u);
	//
	// HttpPost httpPost = new HttpPost(u);
	// RequestConfig requestConfig =
	// RequestConfig.custom().setSocketTimeout(4000).setConnectTimeout(4000).build();//
	// 设置请求和传输超时时间
	// httpPost.setConfig(requestConfig);
	//
	// // 创建参数队列
	// List<NameValuePair> formParams = new ArrayList<NameValuePair>();
	// bfp.set(formParams);
	// // formParams.add(new BasicNameValuePair("type", "house"));
	// UrlEncodedFormEntity uefEntity;
	// try {
	// uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
	// httpPost.setEntity(uefEntity);
	// // System.out.println("executing request " + httpPost.getURI());
	// CloseableHttpResponse response = httpClient.execute(httpPost);
	// try {
	// HttpEntity entity = response.getEntity();
	// if (entity != null) {
	// // System.out.println("--------------------------------------");
	// // // System.out.println("Response content: " +
	// // EntityUtils.toString(entity, "UTF-8"));
	// // System.out.println("--------------------------------------");
	//
	// String r = EntityUtils.toString(entity, "UTF-8");
	// logger.debug("post method response:" + r);
	// // System.out.println("executing response:" + r);
	// return r;
	// }
	// } finally {
	// response.close();
	// }
	// } catch (ClientProtocolException e) {
	// e.printStackTrace();
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// // 关闭连接,释放资源
	// try {
	// httpClient.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// return null;
	// }

	// public String get(String url) {
	// CloseableHttpClient httpclient = HttpClients.createDefault();
	// try {
	// // 创建httpget.
	// String u = getUrl(url);
	// HttpGet httpGet = new HttpGet(u);
	// RequestConfig requestConfig =
	// RequestConfig.custom().setSocketTimeout(4000).setConnectTimeout(4000).build();//
	// 设置请求和传输超时时间
	// httpGet.setConfig(requestConfig);
	// logger.debug("get method request:" + u);
	// // 执行get请求.
	// CloseableHttpResponse response = httpclient.execute(httpGet);
	// try {
	// // 获取响应实体
	// HttpEntity entity = response.getEntity();
	// // System.out.println("--------------------------------------");
	// // 打印响应状态
	// // System.out.println(response.getStatusLine());
	// if (entity != null) {
	// // 打印响应内容长度
	// // System.out.println("Response content length: " +
	// // entity.getContentLength());
	// // 打印响应内容
	// // System.out.println("Response content: " +
	// // EntityUtils.toString(entity));
	//
	// String r = EntityUtils.toString(entity);
	// logger.debug("get method response:" + r);
	// return r;
	// }
	// // System.out.println("------------------------------------");
	// } finally {
	// response.close();
	// }
	// } catch (ClientProtocolException e) {
	// e.printStackTrace();
	// } catch (ParseException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// // 关闭连接,释放资源
	// try {
	// httpclient.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// return null;
	// }

	// private String getUrl(String url) {
	// String s = thirdinteConstants.getInvokeUrl() + url;
	// return s;
	// }
	//
	// // @Deprecated
	// // protected CodeAndMessage praiseCodeAndMessage_OLD(String s) {
	// // ObjectMapper mapper = new ObjectMapper();
	// // try {
	// // CodeAndMessage cm = mapper.readValue(s, CodeAndMessage.class);
	// // return cm;
	// // } catch (JsonParseException e) {
	// // e.printStackTrace();
	// // } catch (JsonMappingException e) {
	// // e.printStackTrace();
	// // } catch (IOException e) {
	// // e.printStackTrace();
	// // }
	// // return null;
	// // }
	//
	// protected CodeAndMessage praiseCodeAndMessage(String s) {
	// JSONObject jsonObj = JSONObject.fromObject(s);
	// if (jsonObj.containsKey("code")) {
	// CodeAndMessage cam = new CodeAndMessage();
	// int code = jsonObj.getInt("code");
	// cam.setCode(code);
	// if (code == 0) {
	// if (jsonObj.containsKey("response")) {
	// JSONObject jsonResponse = null;
	// try {
	// jsonResponse = jsonObj.getJSONObject("response");
	// if (jsonResponse != null) {
	// Response resp = new Response();
	// resp.setDuration(this.getStr(jsonResponse, "duration"));
	// resp.setIsHit(this.getInt(jsonResponse, "isHit"));
	// resp.setReason(this.getStr(jsonResponse, "reason"));
	// cam.setResponse(resp);
	// }
	// } catch (Exception e) {
	// }
	// }
	// }
	// return cam;
	// }
	// return null;
	// }
	//
	// protected boolean isSuccessAdd(String s) {
	// // System.out.println("s:" + s);
	// CodeAndMessage cm = this.praiseCodeAndMessage(s);
	// return cm == null ? false : cm.getCode() == 0 ? true : false;
	// }
	//
	// protected boolean isSuccessHit(String s) {
	// CodeAndMessage cm = this.praiseCodeAndMessage(s);
	// return cm == null ? false : cm.getCode() == 0 ?
	// cm.getResponse().getIsHit() == 1 : false;
	// }
	//
	// public boolean invoke(Requ requ) {
	// String re = getUrl() + requ.getUserId();
	// // System.out.println("requ:" + re);
	// String resp = this.get(re);
	// // System.out.println("resp:" + resp);
	// if (this.selfType() == IS_HIT) {
	// return this.isSuccessHit(resp);
	// } else {
	// return isSuccessAdd(resp);
	// }
	// }
	//
	// protected abstract String getUrl();
	//
	// protected abstract int selfType();
	//
	// protected String getStr(JSONObject jsonObject, String name) {
	// String val = "";
	// if (jsonObject.containsKey(name)) {
	// val = jsonObject.getString(name);
	// if (StringUtils.isBlank(val)) {
	// val = "";
	// }
	// }
	// return val;
	// }
	//
	// protected Integer getInt(JSONObject jsonObject, String name) {
	// String strId = getStr(jsonObject, name);
	// if (StringUtils.isNotBlank(strId)) {
	// return Integer.valueOf(strId);
	// }
	// return null;
	// }
	//
	// protected Long getLong(JSONObject jsonObject, String name) {
	// String strId = getStr(jsonObject, name);
	// if (StringUtils.isNotBlank(strId)) {
	// return Long.valueOf(strId);
	// }
	// return null;
	// }

}
