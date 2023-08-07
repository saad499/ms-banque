package com.example.msbanque.web;

import com.example.msbanque.entities.Compte;
import com.example.msbanque.repositories.CompteRepository;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/banque")
public class CompteRestControllerAPI {
    //@Autowired
    public CompteRepository compteRepository;

    @GetMapping(path = "/compte",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @GetMapping(path = "/compte/{id}",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getOne (@PathVariable(value="id") Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping(path = "/compte",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte save (@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping(path = "/compte/{id}",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte update (@RequestBody Compte compte, @PathVariable("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/compte/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void delete (@PathParam("id") Long id){
        compteRepository.deleteById(id);
    }
}
