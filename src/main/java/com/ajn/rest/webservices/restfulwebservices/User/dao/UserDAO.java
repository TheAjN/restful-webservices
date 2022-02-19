package com.ajn.rest.webservices.restfulwebservices.User.dao;

import com.ajn.rest.webservices.restfulwebservices.User.Bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository //or @Component
public class UserDAO {

    private static List<User> userList;

    private static int count = 3;

    public UserDAO() {

        userList = new ArrayList<>();

        userList.add(new User(1, "Adam", new Date()));
        userList.add(new User(2, "Jacob", new Date()));
        userList.add(new User(3, "Jessica", new Date()));
    }

    //OR can be added via static block -

   /* static{
        userList.add(new User(1,"Adam",new Date()));
        userList.add(new User(2,"Jacob",new Date()));
        userList.add(new User(3,"Jessica",new Date()));
    }*/

    public List<User> findAll() {
        return userList;
    }

    public User save(User user) {

        if (user.getId() == null) {
            user.setId(++count);
        }
        userList.add(user);
        return user;
    }

    public User find(int id) {

        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    public User deleteById(int id) {
        Iterator<User> userIterator = userList.listIterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == id) {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
