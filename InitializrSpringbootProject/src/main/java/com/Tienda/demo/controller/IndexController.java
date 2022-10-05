/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tienda.demo.controller;

import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.Tienda.demo.domain.Cliente;
import java.util.Arrays;
import com.Tienda.demo.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j

public class IndexController {
    
@Autowired
private ClienteDao clienteDao;
    
@GetMapping("/")    
public String inicio(Model model){
    var texto = "estamos en semana 4";
    model.addAttribute("mensaje", texto);
  
    
/*
    Cliente cliente1 = new Cliente("pedro","gomez","pcontreras@gmail.com","7878-8787");
    //model.addAttribute("cliente",cliente);
    
    Cliente cliente2 = new Cliente("Ariel","Sanchez","asanchez@sdfasd","6090-3404");
    //model.addAttribute("cliente",cliente);
    
    var clientes = Arrays.asList(cliente1, cliente2);
 */   

    var clientes = clienteDao.findAll();
    
    model.addAttribute("clientes",clientes);
    return "index";
    
}









}
