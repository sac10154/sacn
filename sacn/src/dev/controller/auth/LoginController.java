package dev.controller.auth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

@SuppressWarnings("serial")
public class LoginController extends Controller {

    private static final String GOOGLE_URL = "https://www.google.com/accounts/o8/id";
    private static final String YAHOO_URL = "yahoo.co.jp";
    private static final String MIXI_URL = "https://mixi.jp";
    
    
    @Override
    public Navigation run() throws Exception {
        String continuePage = createServerStringBuffer(request.getScheme(),
            request.getServerName(),request.getServerPort()).append("/auth/index").toString();
        request.setAttribute("google", createOpenIdUrl(continuePage, GOOGLE_URL));
        request.setAttribute("yahoo", createOpenIdUrl(continuePage, YAHOO_URL));
        request.setAttribute("mixi", createOpenIdUrl(continuePage, MIXI_URL));
        
        return forward("login.jsp");
    }

    private StringBuffer createServerStringBuffer(String scheme, String server, int port){
        StringBuffer url = new StringBuffer();
        if(port < 0){
            port = 80; 
        }
        url.append(scheme);
        url.append("://");
        url.append(server);
        if((scheme.equals("http") && (port != 80))
                || (scheme.equals("https") && (port != 443))){
            url.append(":");
            url.append(port);
        }
        return url;
    }

    private String createOpenIdUrl(String continuePage, String openIdentifier)
            throws UnsupportedEncodingException{
        return "LoginHandler?continue="
                + URLEncoder.encode(continuePage, "UTF-8")
                + "&openid_identifier="
                + URLEncoder.encode(openIdentifier, "UTF-8");
    }

}
