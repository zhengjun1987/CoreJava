package chapter04networks;

import utils.MyUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/12 19:06
 * Project:CoreJava
 */
public class PostTest {
    public static void main(String[] args) {
        String propsFileName = "post.properties";
        Properties properties = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(propsFileName));
            properties.load(inputStream);
            String url = properties.remove("url").toString();
            System.out.println(MyUtils.getCurrentTime() + "url = " + url);
            Object userAgent = properties.remove("User-Agent");
            System.out.println(MyUtils.getCurrentTime() + "userAgent = " + userAgent);
            Object redirects = properties.remove("redirects");
            System.out.println(MyUtils.getCurrentTime() + "redirects = " + redirects);
            CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
            String result = doPost(new URL(url), properties,
                    userAgent == null ? null : userAgent.toString(),
                    redirects == null ? -1 : Integer.parseInt(redirects.toString()));
            System.out.println(MyUtils.getCurrentTime() + "result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String doPost(URL url, Map<Object, Object> properties, String userAgent, int redirects) throws IOException {
        HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
        if (userAgent != null) {
            httpURLConnection.setRequestProperty("User-Agents", userAgent);
        }
        if (redirects > 0) {
            httpURLConnection.setInstanceFollowRedirects(false);
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream(),true);
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append('&');
            }
            String key = entry.getKey().toString();
            System.out.println(MyUtils.getCurrentTime() + "key = " + key);
            String value = entry.getValue().toString();
            stringBuilder.append(key);
            stringBuilder.append("=");
            String encode = URLEncoder.encode(value, "UTF-8");
            System.out.println(MyUtils.getCurrentTime() + "value = " + encode);
            stringBuilder.append(encode);
        }
        String toString = stringBuilder.toString();
        System.out.println(MyUtils.getCurrentTime() + "toString = " + toString);
        printWriter.print(toString);
        String contentEncoding = "UTF-8";
//        System.out.println(MyUtils.getCurrentTime() + "contentEncoding = " + contentEncoding);
//        if (contentEncoding == null) {
//            contentEncoding = "UTF-8";
//        }

        if (redirects > 0) {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
                String location = httpURLConnection.getHeaderField("Location");
                if (location != null) {
                    URL base = httpURLConnection.getURL();
                    httpURLConnection.disconnect();
                    return doPost(base, properties, userAgent, redirects);
                }
            }
        } else if (redirects == 0) {
            throw new IOException("Too many redirects!");
        }

        StringBuilder stringBuffer = new StringBuilder();
        try {
            Scanner scanner = new Scanner(httpURLConnection.getInputStream());
            while (scanner.hasNextLine()) {
                stringBuffer.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            System.out.println(MyUtils.getCurrentTime() + "errorStream = " + errorStream);
            if (errorStream == null) {
                throw e;
            }
            Scanner scanner = new Scanner(errorStream);
            while (scanner.hasNextLine()) {
                stringBuffer.append(scanner.nextLine()).append("\n");
            }
        }
        return stringBuffer.toString();
    }
}
