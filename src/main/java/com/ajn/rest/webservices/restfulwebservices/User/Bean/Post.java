package com.ajn.rest.webservices.restfulwebservices.User.Bean;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String content;
    private Date timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
