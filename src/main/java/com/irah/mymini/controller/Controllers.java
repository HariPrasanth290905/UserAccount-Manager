package com.irah.mymini.controller;

import com.irah.mymini.model.Users;
import com.irah.mymini.serivice.UserServiceImple;
import com.irah.mymini.userrepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controllers {

    @Autowired
    UserServiceImple usi;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add-user")
    public String submit(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("button", "Submit");
        return "createorupdate";
    }

    @PostMapping("/save-user")
    public String s(@ModelAttribute Users users) {
        System.out.println(users.getId());
        usi.createOrUpdateUser(users);
        return "redirect:/view-all-user";
    }

    @GetMapping("/view-all-user")
    public String viewUser(Model model) {
        model.addAttribute("users", usi.getAllUsers());
        return "display";
    }

    @GetMapping("/edit-user/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Users user = usi.getUser(id);
        model.addAttribute("users", user);
        model.addAttribute("button", "Update");
        return "createorupdate";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes model) {
        usi.deleteUser(id);
        model.addFlashAttribute("msg", "User deleted successfully!");
        return "redirect:/view-all-user";
    }

    @GetMapping("/change-status")
    public String changeStatus(@RequestParam("id") Integer id, @RequestParam("active") String status, Model model) {

        usi.updateStatus(status, id);
        if (status.equals("Y")) {
            model.addAttribute("msg", "Activated");
        } else {
            model.addAttribute("msg", "Deactivated");
        }
        return "forward:/view-all-user";
    }
}
