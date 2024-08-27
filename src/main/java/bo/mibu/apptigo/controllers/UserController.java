package bo.mibu.apptigo.controllers;

import bo.mibu.apptigo.models.UserModel;
import bo.mibu.apptigo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.getById(id)) ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user){
        return  ResponseEntity.ok(this.userService.saveUser(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user, @PathVariable Long id){
        return  ResponseEntity.ok(this.userService.updateUser(user, id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){return "OK";}
        else{ return ":(";}
    }
}
