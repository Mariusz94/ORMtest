package pl.mariuszlyszczarz.AORMtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mariuszlyszczarz.AORMtest.models.CreateUser;
import pl.mariuszlyszczarz.AORMtest.models.UserModel;
import pl.mariuszlyszczarz.AORMtest.models.UserService;
import pl.mariuszlyszczarz.AORMtest.models.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")

    public String index() {
        //List<UserModel> users = userRepository.findAll();

        //Iterable<UserModel> users = userRepository.findAll();
        //return users.toString();

        //UserModel someUserModel = userRepository.findOne(2);
        //return someUserModel.toString();
        //UserModel userModel = new UserModel();
        //userModel.setAge(30);
        //userModel.setLogin("Pyko");
        //userModel.setPassword("hello");

        //userRepository.save(userModel);
        //return "Zapisałem";

        //List<UserModel> userModels = userRepository.findByAgeGreaterThan(20);
        //return userModels.toString();

        //List<UserModel> userModels = userRepository.findByAgeGreaterThanAndLoginLike(20, "%a%");
        return "redirect:/login";//userModels.toString();
    }

    @GetMapping("/main")
    public String main() {
        if (userService.isLogeIn()) {
            return "main";
        }

        return "redirect:/login";
    }

    StringBuilder stringBuilder = new StringBuilder();
    @PostMapping("/main")
    public String mainPost(//@RequestParam("coment")String string, Model model
    ) {
       // if (!string.isEmpty()){
         //   stringBuilder.append(string);
           // System.out.println(stringBuilder + "\r\n");
            //return "main";
        //}
        userService.setLogeIn(false);
        return "redirect:/login";
    }
}
