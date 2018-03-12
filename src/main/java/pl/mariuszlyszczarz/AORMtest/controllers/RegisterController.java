package pl.mariuszlyszczarz.AORMtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mariuszlyszczarz.AORMtest.models.CreateUser;
import pl.mariuszlyszczarz.AORMtest.models.UserModel;
import pl.mariuszlyszczarz.AORMtest.models.UserService;
import pl.mariuszlyszczarz.AORMtest.models.repositories.UserRepository;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("createUser", new CreateUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("createUser") CreateUser createUser,
                               Model model) {

        if(!createUser.getPassword().equals(createUser.getRepeatPassword())){
            model.addAttribute("notSamePassword", true);
            return "register";
        }

        UserModel userModel = new UserModel();

        userModel.setLogin(createUser.getLogin());
        userModel.setPassword(createUser.getPassword());
        userModel.setAge(createUser.getAge());

        userRepository.save(userModel);

        System.out.println("Zapisałem");
        return "redirect:/login";
    }
}
