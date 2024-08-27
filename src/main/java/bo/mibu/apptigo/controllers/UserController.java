package bo.mibu.apptigo.controllers;

import bo.mibu.apptigo.services.IUserService;
import bo.mibu.apptigo.services.dto.UserRequestDto;
import bo.mibu.apptigo.services.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<UserResponseDto> getUsers() {
        return this.userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto user) {
        return ResponseEntity.ok(this.userService.saveUser(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto user, @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.updateUser(user, id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "OK";
        } else {
            return ":(";
        }
    }
}
