package model;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;

public class User {
    @NotNull
    private long id;
    @Size(min=3, max = 10)
    private String name;
    private String password;
    private String email;

    public User() {
    }

    public User(long id, String name, String password,  String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}