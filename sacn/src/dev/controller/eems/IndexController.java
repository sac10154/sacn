package dev.controller.eems;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import dev.model.Tweet;
import dev.service.TwitterService;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private TwitterService service = new TwitterService();

    @Override
    public Navigation run() throws Exception {
        List<Tweet> tweetList = service.getTweetList();
        requestScope("tweetList", tweetList);
        return forward("index.jsp");
    }
}
