package hello;

public class Content {
    protected final long id;
    protected final String content;

    protected Content(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
