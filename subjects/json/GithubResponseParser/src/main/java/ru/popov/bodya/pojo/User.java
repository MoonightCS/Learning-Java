package ru.popov.bodya.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("login")
    private String username;

    @JsonProperty("url")
    private String url;

    @JsonProperty("score")
    private double score;


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", score=" + score +
                '}';
    }
}
