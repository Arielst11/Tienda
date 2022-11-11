package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
        
       @GetMapping("/cliente/buscarNombre")   /// posible a buscar
    public String buscarPorNombre(Model model) {
        var clientes=clienteService.buscarPorNombre("Ana");
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    } 
    
    
       @GetMapping("/cliente/buscarApellido/{apellido}")   /// posible a buscar
    public String buscarPorApellido(Model model , String apellido) {
        var clientes=clienteService.buscarPorApellido(apellido);
        model.addAttribute("clientes",clientes);
        return "/cliente/modificar";
    } 
    
    
    
      @GetMapping("/cliente/listado")
    public String listado(Model model) {
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modificar";
    }
    
    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "/cliente/modificar";
    }
    
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
       clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    
    
}
