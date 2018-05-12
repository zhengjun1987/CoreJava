package chapter04networks;

import utils.MyUtils;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/5/12 16:36
 * Project:CoreJava
 */
public class URITest {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://img5.imgtn.bdimg.com/it/u=2240684325,947793188&fm=27&gp=0.jpg");
            System.out.println(MyUtils.getCurrentTime() + "uri.getScheme() = " + uri.getScheme());
            System.out.println(MyUtils.getCurrentTime() + "uri.getSchemeSpecificPart() = " + uri.getSchemeSpecificPart());
            System.out.println(MyUtils.getCurrentTime() + "uri.getAuthority() = " + uri.getAuthority());
            System.out.println(MyUtils.getCurrentTime() + "uri.getUserInfo() = " + uri.getUserInfo());
            System.out.println(MyUtils.getCurrentTime() + "uri.getHost() = " + uri.getHost());
            System.out.println(MyUtils.getCurrentTime() + "uri.getRawPath() = " + uri.getRawPath());
            System.out.println(MyUtils.getCurrentTime() + "uri.getPath() = " + uri.getPath());
            System.out.println(MyUtils.getCurrentTime() + "uri.getPort() = " + uri.getPort());
            System.out.println(MyUtils.getCurrentTime() + "uri.getQuery() = " + uri.getQuery());
            System.out.println(MyUtils.getCurrentTime() + "uri.getFragment() = " + uri.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
//        2018-05-12 16:42:10:263  uri.getScheme() = http
//        2018-05-12 16:42:10:313  uri.getSchemeSpecificPart() = //img5.imgtn.bdimg.com/it/u=2240684325,947793188&fm=27&gp=0.jpg
//        2018-05-12 16:42:10:313  uri.getAuthority() = img5.imgtn.bdimg.com
//        2018-05-12 16:42:10:313  uri.getUserInfo() = null
//        2018-05-12 16:42:10:313  uri.getHost() = img5.imgtn.bdimg.com
//        2018-05-12 16:42:10:314  uri.getRawPath() = /it/u=2240684325,947793188&fm=27&gp=0.jpg
//        2018-05-12 16:42:10:314  uri.getPath() = /it/u=2240684325,947793188&fm=27&gp=0.jpg
//        2018-05-12 16:42:10:314  uri.getPort() = -1
//        2018-05-12 16:42:10:314  uri.getQuery() = null
//        2018-05-12 16:42:10:314  uri.getFragment() = null
