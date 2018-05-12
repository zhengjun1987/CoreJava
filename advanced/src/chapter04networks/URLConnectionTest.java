package chapter04networks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/12 16:48
 * Project:CoreJava
 */
public class URLConnectionTest {
    public static void main(String[] args) {
        String urlName;
        if (args.length > 0) {
            urlName = args[0];
        } else {
            urlName = "http://horstman.com";
        }

        try {
            URL url = new URL(urlName);
            URLConnection urlConnection = url.openConnection();
            if (args.length > 2) {
                String username = args[1];
                String password = args[2];
                String input = username + ":" + password;
                String encodeToString = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
                System.out.println("encodeToString = " + encodeToString);
//                        encodeToString = emhlbmdqdW46MTIzNDU2

                urlConnection.setRequestProperty("Authorization", encodeToString);
            }
            urlConnection.connect();

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> stringListEntry : headerFields.entrySet()) {
                String key = stringListEntry.getKey();
                for (String value : stringListEntry.getValue()) {
                    System.out.println(key + " = " + value);
                }
            }
//                    Status = 200 OK
//                    Transfer-Encoding = chunked
//                    null = HTTP/1.1 200 OK
//                    Server = nginx/1.6.2 + Phusion Passenger 4.0.53
//                    X-Request-Id = b14b4614-4ab6-4b6d-a3fd-7bf306e3fd6b
//                    X-Runtime = 0.015597
//                    X-Content-Type-Options = nosniff
//                    Connection = close
//                    P3P = CP="IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT"
//                    Date = Sat, 12 May 2018 10:49:53 GMT
//                    X-Frame-Options = SAMEORIGIN
//                    Cache-Control = max-age=0, private, must-revalidate
//                    ETag = W/"2e53993b514a504d7f379a5c19452863"
//                    Vary = Accept-Encoding
//                    X-XSS-Protection = 1; mode=block
//                    X-Powered-By = Phusion Passenger 4.0.53
//                    Content-Type = text/html; charset=utf-8

            System.out.println("urlConnection.getContentType() = " + urlConnection.getContentType());
            System.out.println("urlConnection.getContentLength() = " + urlConnection.getContentLength());
            String contentEncoding = urlConnection.getContentEncoding();
            System.out.println("urlConnection.getContentEncoding() = " + contentEncoding);
            System.out.println("urlConnection.getDate() = " + urlConnection.getDate());
            System.out.println("urlConnection.getExpiration() = " + urlConnection.getExpiration());
            System.out.println("urlConnection.getLastModified() = " + urlConnection.getLastModified());
            System.out.println("===================================================");
//                    urlConnection.getContentType() = text/html
//                    urlConnection.getContentLength() = 2443
//                    urlConnection.getContentEncoding() = null
//                    urlConnection.getDate() = 1526120194000
//                    urlConnection.getExpiration() = 0
//                    urlConnection.getLastModified() = 1485177897000

            if (contentEncoding == null) {
                contentEncoding = "UTF-8";
            }
            Scanner scanner = new Scanner(urlConnection.getInputStream(), contentEncoding);
            for (int i = 0; i < 10 && scanner.hasNextLine(); i++) {
                System.out.println(scanner.nextLine());
            }
//                    <!DOCTYPE html>
//        <!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div clwrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn" autofocus></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=https.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tiebidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === "" ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');
//                        </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.blass=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>

            if (scanner.hasNextLine()) {
                System.out.println("...");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
