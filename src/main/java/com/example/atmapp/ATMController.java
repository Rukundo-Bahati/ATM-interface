package com.example.atmapp;

import com.example.atmapp.model.PiggyBank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ATMController {

    private PiggyBank piggyBank = new PiggyBank(); // Mocked instance, ideally managed via Spring's Dependency Injection

    @PostMapping("/deposit")
    public String deposit(@RequestParam("amount") double amount, Model model) {
        piggyBank.deposit(amount);
        model.addAttribute("balance", piggyBank.getBalance());
        model.addAttribute("message", "Deposited $" + amount);
        return "index";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("amount") double amount, Model model) {
        if (amount > piggyBank.getBalance()) {
            model.addAttribute("error", "Insufficient funds.");
        } else {
            piggyBank.withdraw(amount);
            model.addAttribute("message", "Withdrew $" + amount);
        }
        model.addAttribute("balance", piggyBank.getBalance());
        return "index";
    }

    @PostMapping("/balance")
    public String checkBalance(Model model) {
        model.addAttribute("balance", piggyBank.getBalance());
        model.addAttribute("message", "Checked balance.");
        return "index";
    }
}
