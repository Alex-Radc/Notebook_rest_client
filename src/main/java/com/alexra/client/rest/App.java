package com.alexra.client.rest;

import com.alexra.client.rest.configuration.MyConfig;
import com.alexra.client.rest.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<User> allUsers = communication.getAllUsers();
        System.out.println(allUsers);

//        User userByID = communication.getUser(10);
//        System.out.println(userByID);

//        User user = new User("Alex", "Sokol", "Madrid");
//        user.setId(27);
//        communication.saveuser(user);

//          communication.deleteUser(27);

    }
}
