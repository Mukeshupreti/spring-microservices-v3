package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TesingDelete {
    @Autowired
    private UserDaoService userDaoService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userDaoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/users/{id}")
    public  ResponseEntity<User> getUser(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userDaoService.findOne(id));
    }
    // POST /users/
    @PostMapping("/users")
    public ResponseEntity<User> createUser( @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userDaoService.save(user));
    }

    //update record
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
      return ResponseEntity.status(HttpStatus.OK).body(userDaoService.updateById(id,user));
    }

    // delete record
    // DELETE /users/{id}
    //
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id){
      return ResponseEntity.status(HttpStatus.OK).body(userDaoService.deleteRecordById(id));
    }

}
