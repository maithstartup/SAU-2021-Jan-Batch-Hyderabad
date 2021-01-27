package com.accolite.restapi_au.controllers;

import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody Map<String, String> userDetails) {
        System.out.println(userDetails);
        String emailId = userDetails.get("emailId");
        String password = userDetails.get("password");
        User user = new User();
        user.setEmailId(emailId);
        user.setPassword(password);

        //Send it to service
        userService.addUser(user);

        return user;
    }
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Integer id,@RequestHeader("password") String password){
        User user=userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok("Invalid login");

    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email,@RequestHeader("password") String password){
        User user=userService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok("Invalid login");

    }


    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody Map<String,String> user, @PathVariable Integer id){
        User newUser = userService.getUserById(id);

        System.out.println(user.get("emailId"));
        newUser.setEmailId(user.get("emailId"));
        newUser.setPassword(user.get("password"));
        return userService.updateUser(newUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Object> updateUser(@RequestBody User user){
//        User temp_user=userService.getUserById(user.getId());
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        if(bCryptPasswordEncoder.matches(user.getPassword(), temp_user.getPassword())) {
//            temp_user.setEmailId(user.getEmailId());
//            temp_user.setPassword(user.getPassword());
//            userService.updateUser(temp_user);
//            return ResponseEntity.ok(temp_user);
//        }
//        return ResponseEntity.ok("Invalid login");

//    }





}
