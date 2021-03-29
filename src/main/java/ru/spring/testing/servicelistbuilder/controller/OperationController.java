package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.testing.servicelistbuilder.entity.operation.Operation;
import ru.spring.testing.servicelistbuilder.service.OperationService;

import java.util.List;

@Controller
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    OperationService operationService;

    @GetMapping
    public String showOperationList(Model model) {
        List<Operation> operations = operationService.showAllOperationList();
        model.addAttribute("operations", operations);
        return "operations/index";
    }

    @GetMapping("/new")
    public String showOperationForm(@ModelAttribute("operation") Operation operation, Model model) {
        return "operations/form";
    }

    @PostMapping
    public String addNewOperation(@ModelAttribute("operation") Operation operation, Model model) {
        operationService.saveOrUpdate(operation);
        return "redirect:/operations";
    }
}
