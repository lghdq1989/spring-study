//package com.midea.ccs.core.utils.http;
//
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//
///**
// * 使用pooling管理的HttpClient
// * @author: yangjun.ou
// * @date: 2019-03-13
// */
//public class PoolingHttpClient {
//    // 最大pooling 连接数量
//    int maxTotalConnections = 1000 ;
//    // 每个route 的最大pooling连接数量
//    int maxConnectionsPerRoute = 500;
//    // 连接超时，单位毫秒
//    int connectTimeout = 50*1000 ;
//    // socket timeout，单位毫秒
//    int socketTimeout = 50*1000 ;
//    // 从connection manager中获取连接的超时时间，单位毫秒
//    int connectionRequestTimeout = 30*1000 ;
//    // user agent
//    String userAgent ;
//    // HttpClient
//    CloseableHttpClient hc ;
//    // HttpClientUtil
//    HttpClientUtil hcu ;
//    // pooling connection manager
//    PoolingHttpClientConnectionManager conmgr ;
//
//    public void setMaxTotalConnections(int maxTotalConnections) {
//        this.maxTotalConnections = maxTotalConnections;
//    }
//
//    public void setMaxConnectionsPerRoute(int maxConnectionsPerRoute) {
//        this.maxConnectionsPerRoute = maxConnectionsPerRoute;
//    }
//
//    public void setConnectTimeout(int connectTimeout) {
//        this.connectTimeout = connectTimeout;
//    }
//
//    public void setSocketTimeout(int socketTimeout) {
//        this.socketTimeout = socketTimeout;
//    }
//
//    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
//        this.connectionRequestTimeout = connectionRequestTimeout;
//    }
//
//    public void setUserAgent(String userAgent) {
//        this.userAgent = userAgent;
//    }
//
//    public CloseableHttpClient getHc() {
//        return hc;
//    }
//
//    public HttpClientUtil getHcu() {
//        return hcu;
//    }
//
//    public void init() {
//        // 创建 PoolingClientConnectionManager
//        conmgr=new PoolingHttpClientConnectionManager();
//        conmgr.setDefaultMaxPerRoute(maxConnectionsPerRoute);
//        conmgr.setMaxTotal(maxTotalConnections);
//
//        // 创建缺省的 RequestConfig
//        RequestConfig reqcfg = RequestConfig.custom()
//                .setConnectTimeout(connectTimeout)
//                .setSocketTimeout(socketTimeout)
//                .setConnectionRequestTimeout(connectionRequestTimeout)
//                .build();
//
//        // 创建 CloseableClient
//        HttpClientBuilder hcb = HttpClients.custom()
//                .setConnectionManager(conmgr)
//                .setDefaultRequestConfig(reqcfg);
//        if (userAgent != null) {hcb.setUserAgent(userAgent);}
//
//        // 初始化 HttpClient 及相关参数
//        hc = hcb.build();
//
//        // 创建 HttpClientUtil
//        hcu = new HttpClientUtil(hc);
//    }
//
//    public void destroy() {
//        conmgr.shutdown();
//    }
//}
