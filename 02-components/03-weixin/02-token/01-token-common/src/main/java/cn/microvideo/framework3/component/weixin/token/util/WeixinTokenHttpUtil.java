package cn.microvideo.framework3.component.weixin.token.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class WeixinTokenHttpUtil {
    protected static CloseableHttpClient httpClient;

    static {
        httpClient = HttpClients.createDefault();
    }

    public static String sendHttpGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                EntityUtils.consume(entity);
            }
            String responseContent = entity == null ? null : EntityUtils.toString(entity, Consts.UTF_8);
            return responseContent;
        } catch (IOException ex) {
            log.error("get 请求异常 ", ex);
        }
        return null;
    }
}

