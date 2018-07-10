package ar.com.wolox.android.example.model;

/**
 * News post model that contains a title and a body.
 */
public class Post {

    private String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
