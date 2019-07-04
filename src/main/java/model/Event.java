package model;

import java.time.LocalDate;
import java.util.List;

public class Event {
    private long id;
    private String name;
    private LocalDate date;
    private String contact_number;
    private Long id_category;
    private String description;
    private String urlImage;
    private String category;
    private List<HashTag> tags;


    public Event() {
    }

    public Event(long id, String name, LocalDate date, String contact_number, Long id_category, String description, String urlImage) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.contact_number = contact_number;
        this.id_category = id_category;
        this.description = description;
        this.urlImage = urlImage;
    }

    public Event(long id, String name, LocalDate date, String contact_number, Long id_category, String description, String urlImage, String category, List<HashTag> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.contact_number = contact_number;
        this.id_category = id_category;
        this.description = description;
        this.urlImage = urlImage;
        this.category = category;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContactTelNum() {
        return contact_number;
    }

    public void setContactTelNum(String contact_number) {
        this.contact_number = contact_number;
    }

    public Long getIdCategory() {
        return id_category;
    }

    public void setIdCategory(Long id_category) {
        this.id_category = id_category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<HashTag> getTags() {
        return tags;
    }

    public void setTags(List<HashTag> tags) {
        this.tags = tags;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}