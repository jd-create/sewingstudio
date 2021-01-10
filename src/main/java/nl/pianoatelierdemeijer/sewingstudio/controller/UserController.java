package nl.pianoatelierdemeijer.sewingstudio.controller;

import nl.pianoatelierdemeijer.sewingstudio.model.User;
import nl.pianoatelierdemeijer.sewingstudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping(value = "/users")
        public ResponseEntity<Object> getUsers() {
            List<User> users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }


        @GetMapping(value = "/users/{id}")
        public ResponseEntity<Object> getUser(@PathVariable("id") long id) {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @DeleteMapping(value = "/users/{id}")
        public ResponseEntity<Object> deleteUser(@PathVariable("id") long id) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PostMapping(value = "/users")
        public ResponseEntity<Object> saveUser(@RequestBody User user) {
            long newId = userService.saveUser(user);
            return new ResponseEntity<>(newId, HttpStatus.CREATED);
        }

        @PutMapping(value = "/users/{id}")
        public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody User user) {
            userService.updateUser(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping(value = "/users/lastname/{lastname}")
        public ResponseEntity<Object> getUserByLastName(@PathVariable("lastname") String lastName) {
            User user = userService.getUserByLastName(lastName);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }


}
