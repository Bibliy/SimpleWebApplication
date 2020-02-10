package com.controller;

import com.Entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//ДЛЯ ТОГО ЧТОБЫ вернули наш вид hello.ftl
@Controller
@RequestMapping("/") //мапить будет начинать со слэша
public class UserController {

    @Autowired  //11
    public UserService userService;

     @GetMapping("/")
     public  String index(){
         return "index";
     }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }//метод будет обрабатывать гет запрос и будет возвращать hello.ftl

     @GetMapping("/users")  //12  model эта мапа которая передаем всех юзеров с базы в template
     public  String getAllUsers(Model model){
         model.addAttribute("users",userService.findAll ());
         return "usersList";
     }
     // наша задача обработать атрибут "users" обработать в template "usersList"
     // 13   create fail "usersList" in field views

   @GetMapping("/user/{id}")
     public String getById(@PathVariable("id") int id,Model model){
         model.addAttribute("user",userService.getById (id));
         return "showUser";
   }


   @GetMapping("/addUser")    //для  просмотра созданного юзера
   public  String createUserPage(){
         return "createUser";
   }
   @PostMapping("/addUser") //данные передаються не через url а через requast body
    public  String addUser(@ModelAttribute("user")User user){
         userService.save(user);
         return "redirect:/users";
   }

   @GetMapping("/delete/{id}")
    public  String deleteUser(@PathVariable("id")int id){
         userService.delete(id);
         return "redirect:/users";
   }

    @GetMapping("/update/{id}")
    public  String update(@PathVariable("id")int id,Model model){//var model передает в template our id
      model.addAttribute("user",userService.getById (id));
        return "editUser"; //create new template
    }
    @PostMapping("/updateUser") //данные передаються не через url а через requast body
    public  String updateUser(@ModelAttribute("user")User user){
        userService.update(user);
        return "redirect:/user/" + user.getId ();
    }
}
