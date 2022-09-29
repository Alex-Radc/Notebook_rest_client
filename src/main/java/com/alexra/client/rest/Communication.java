package com.alexra.client.rest;

import com.alexra.client.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL ="http://localhost:8081/Notebook_rest/api/users/";

    public List<User> getAllUsers(){
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        List<User> getAllUsers = responseEntity.getBody();
        return getAllUsers;
    }

    public User getUser(int id){
        User user = restTemplate.getForObject(URL+"/"+id, User.class);
        return user;
    }

    public void saveuser(User user){
        int id = user.getId();
        if(id == 0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL,user, String.class);
            System.out.println("New user was added to Database ");
            System.out.println(responseEntity.getBody());
        }
        else{
            restTemplate.put(URL,user);
            System.out.println("User with ID = "+ id + " was updated");
        }

    }

    public void deleteUser (int id){
        restTemplate.delete(URL+"/"+id);
        System.out.println("User with ID = "+id+" was deleted from Database");
    }
}
