package apps.everythingforward.com.mvpsamplereal.events;

import java.util.List;

import apps.everythingforward.com.mvpsamplereal.model.PostsModel;

/**
 * Created by santh on 4/14/2017.
 */

public class PostsEvent {
    List<PostsModel> posts;

    public PostsEvent(List<PostsModel> posts) {
        this.posts = posts;
    }

    public List<PostsModel> getPosts() {
        return posts;
    }
}
