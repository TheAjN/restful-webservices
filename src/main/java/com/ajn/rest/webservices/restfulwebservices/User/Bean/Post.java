package com.ajn.rest.webservices.restfulwebservices.User.Bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    private Integer id;
    private String title;
    private String content;
    private Date timeStamp;

}
