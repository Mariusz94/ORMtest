package pl.mariuszlyszczarz.AORMtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mariuszlyszczarz.AORMtest.models.UserService;
import pl.mariuszlyszczarz.AORMtest.models.repositories.UserRepository;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        Model model) {
        //UserModel someUserModel = userRepository.exists();
        //boolean exist = userRepository.findByLoginAndPassword(login, password).isPresent();
        boolean exist = userRepository.existsByLoginAndPassword(login, password);
        if (exist) {
            userService.setLogeIn(true);
            return "redirect:/main";
        }//redirect:/main
        model.addAttribute("exist", exist);
        return "login";
    }
}
