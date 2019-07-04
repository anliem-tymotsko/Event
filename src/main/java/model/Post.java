package model;

import java.util.List;

public class Post {
    private Event event;
    private List<String> hashTags;
    private String category;

    public Post() {
    }

    public Post(Event event, List<String> hashTags, String category) {
        this.event = event;
        this.hashTags = hashTags;
        this.category = category;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
