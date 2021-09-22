package com.g7.webserviceprojekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/accounts")
public class AccountController {

    @Autowired
    AccountsService accountsService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewPerson (@RequestParam String name
            , @RequestParam String email, @RequestParam String password, @RequestParam String image) {
        accountsService.addNewPerson(name,email,password, image);

        return "Add complete!";
    }

    @GetMapping(path="/allXml", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Iterable<Accounts> getAllPersons() {
        // This returns a JSON or XML with the users
        return accountsService.getAllPersons();
    }

    @GetMapping(path="/id")
    public @ResponseBody Accounts getById(int id) {
        return accountsService.findAccountById(id);
    }

    @PutMapping(path="/update")
    public @ResponseBody Accounts updateAccountByName(int id, String name, String email, String password) {
        return accountsService.updateAccount(id, name, email, password);
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteById(int id) {
        return accountsService.deleteById(id);
    }

    @GetMapping(path="/name")
    public @ResponseBody List<Accounts> findByName(String name) {
        return accountsService.findByName(name);
    }

    @GetMapping(path="/email")
    public @ResponseBody List<Accounts> findByEmail(String email) {
        return accountsService.findByEmail(email);
    }


}