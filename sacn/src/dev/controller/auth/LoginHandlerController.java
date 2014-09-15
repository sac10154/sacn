package dev.controller.auth;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import java.util.HashSet;
import java.util.Set;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LoginHandlerController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String continuePage = request.getParameter("continue");
        String openidIdentifier = request.getParameter("openid_identifier");

        String authDomain = continuePage.substring(0, continuePage.lastIndexOf("/"));
        Set<String> attributesRequest = new HashSet<String>();

        UserService userService = UserServiceFactory.getUserService();
        String createdUrl = userService.createLoginURL(continuePage, authDomain,
            openidIdentifier, attributesRequest);
        
        return redirect(createdUrl);
    }
}
