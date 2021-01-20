package com.yh.testone;//package com.yanghui.testone;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//
//import javax.net.ssl.SSLContext;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class HttpUtil {
//
//    /**
//     * HttpClient用法demo
//     */
//
//    @Test
//    public  void getOne() {
//        HttpResponse httpResponse;
//        String resultDate;
//        int resultCode;
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://127.0.0.1:6375/yh/test/one?name=yyhh&&age=20");
//        try {
//            httpResponse = httpClient.execute(httpGet);
//            //解析httpResponse
//            //返回数据 并转成utf-8
//            HttpEntity httpEntity = httpResponse.getEntity();
//            resultDate = EntityUtils.toString(httpEntity, "utf-8");
//            resultCode = httpResponse.getStatusLine().getStatusCode();
//            System.out.println(resultDate);
//            System.out.println(resultCode);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public  void getOneYh(int age) {
//        HttpResponse httpResponse;
//        String resultDate;
//        int resultCode;
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://127.0.0.1:6375/yh/test/one?name=yyhh&&age="+age);
//        try {
//            httpResponse = httpClient.execute(httpGet);
//            //解析httpResponse
//            //返回数据 并转成utf-8
//            HttpEntity httpEntity = httpResponse.getEntity();
//            resultDate = EntityUtils.toString(httpEntity, "utf-8");
//            resultCode = httpResponse.getStatusLine().getStatusCode();
//            System.out.println(resultDate);
//            System.out.println(resultCode);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void HttpMore(){
//        ExecutorService executorService =Executors.newFixedThreadPool(5);
//        Set<Callable<Integer>> callableSet =new HashSet<>();
//        for(int i=0;i<5000;i++){
//            callableSet.add(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    getOne();
//                    return 2;
//                }
//            });
//        }
//        try {
//            executorService.invokeAll(callableSet);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
////    @Test
////    public void getTwo() {
////        CloseableHttpClient httpClient = HttpClients.createDefault();
////        HttpResponse httpResponse;
////        String url = "http://10.1.200.204/store/openapi/v2/models/metrics/get?apikey=e10adc3949ba59abbe56e057f2gg88dd&code=tomcat.servlet.error_count";
////        if (url.startsWith("https")) {
////            httpClient = createSSLInsecureClient();
////        }
////        HttpGet httpGet = new HttpGet(url);
////        try {
////            httpResponse = httpClient.execute(httpGet);
////            HttpEntity httpEntity = httpResponse.getEntity();
////            System.out.println(EntityUtils.toString(httpEntity, "utf-8"));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////    }
////
////    //Https开头的特殊请求
////    private static CloseableHttpClient createSSLInsecureClient() {
////        try {
////            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> {
////                return true; //信任所有
////            }).build();
////            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
////            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
////        } catch (Exception e) {
////
////        }
////        return HttpClients.createDefault();
////    }
//
//    @Test
/*//    public void postOne() {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpResponse response;
//        HttpPost httpPost = new HttpPost("http://10.1.200.204/network/v2/frontapi/mos/agenyamlconfig/createorupdate");
//        StringEntity stringEntity = new StringEntity("{\"agentYamlConfigList\":[{\"filename\":\"111.txt\",\"content\":\"22222222222222\"}]}", "utf-8");
//        httpPost.setEntity(stringEntity);
//        // httpPost.setHeader("apikey","e10adc3949ba59abbe56e057f2gg88dd");
//        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setHeader("Cookie", "language=zh_CN; DISCONF=327fbb27-a6d2-4890-8be8-b8d6183a7391; Hm_lvt_c4578bda90040ec19ded56112b82246f=1585029094; Hm_lpvt_c4578bda90040ec19ded56112b82246f=1585029205; skin=blue; omp_token=80a327ad534a03a4fe299ff798d371df425c6b6f322920b2c0fbf6ae21ad93ba; JSESSIONID=B8E930BAA958A657D3A46621995A1016; token=8da932832df56b7f6fd62ee6e8acf849e68329cc9d87a6e41d0cf1b5600434c3; omp_rand=TuykZSEzDHNxwzGNYmcthuHSyRmZilNRyiJMuyzbfkJRdxTWVhpfbHvgZtNMBkaM");
//        try {
//            response = httpClient.execute(httpPost);
//            System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
//            System.out.println(response.getStatusLine().getStatusCode());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }*/
//
//    public static void main(String[] args) {
//
//    }
//
//    public void speak(String ss) {
//        System.out.println(ss);
//    }
//
//    @Test
//    public  void speakTest() {
//        speak("666");
//    }
//}
//
//
