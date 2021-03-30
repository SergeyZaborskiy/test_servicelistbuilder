package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.testing.servicelistbuilder.entity.operation.Operation;
import ru.spring.testing.servicelistbuilder.entity.operation.SubOperation;
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

    @PutMapping("/{id}")
    public String findOperationById(@PathVariable long id, Model model) {
        Operation returnedOperation = operationService.findOperationById(id);
        model.addAttribute("operation", returnedOperation);
        return "operations/form";
    }

    @DeleteMapping("/{id}")
    public String deleteOperationById(@PathVariable long id, Model model) {
        operationService.deleteOperationById(id);
        return "redirect:/operations";
    }

    @PutMapping("/{id}/subs")
    public String showSubOperationsInOperationById(@PathVariable long id, Model model) {
        SubOperation subOperation = new SubOperation();
        Operation returnedOperation = operationService.findOperationById(id);
        model.addAttribute("linkID", id);
        model.addAttribute("newSubOperation", subOperation);
        model.addAttribute("operation", returnedOperation);
        return "operations/subs/form";
    }

    @PostMapping("/{id}/subs")
    public String addSubOperationInOperationById(@PathVariable long id,
                                                 @ModelAttribute("subOperation") SubOperation subOperation,
                                                 Model model) {
        Operation returnedOperation = operationService.findOperationById(id);
        returnedOperation.addSubOperationToOperation(subOperation);
        operationService.saveOrUpdate(returnedOperation);
        return "redirect:/operations";
    }

}
