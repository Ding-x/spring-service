package com.dustyding.restful.restfulservice.user;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();

    private static int userCount = 3;
    static{
        users.add(new User(1,"xiao",new Date()));
        users.add(new User(2,"peng",new Date()));
        users.add(new User(3,"ding",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getID()== null){
            user.setID(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: users)
            if (user.getID()==id)
                return user;



            return null;
    }
}
