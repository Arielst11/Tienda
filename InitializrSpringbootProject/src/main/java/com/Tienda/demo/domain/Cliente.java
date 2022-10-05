/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tienda.demo.domain;
import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author asanc
 */

@Data 
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
 
    private static final long serialVersionUID = 1L;
  
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idCliente;  
 String nombre;
 String apellidos;
 String correo;
 String telefono;
 
    public Cliente(){
        
    }
    
    public Cliente(String nombre, String apellidos , String correo, String telefono){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
}
