package com.ajn.rest.webservices.restfulwebservices.User.dao;


import com.ajn.rest.webservices.restfulwebservices.User.Bean.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostDAO {

    private final List<Post> posts;

    private static int count=0;

    public PostDAO() {
        posts = new ArrayList<>();
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts);
    }

    public Post getPost(int id) {
        return posts.get(id);
    }

    public Post savePost(Post post) {
        if (post.getId() == null) {
            post.setId(++count);
        }
        posts.add(post);
        return post;
    }

    public Post findPost(int id) {
        for (Post p : posts) {
            if (p.equals(posts.get(id))) {
                return p;
            }
        }
        return null;
    }

    public boolean deletePost(int id) {

        if (findPost(id) != null) {
            posts.remove(id);
            return true;
        }

        return false;
    }
}
