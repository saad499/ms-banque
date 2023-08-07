package com.example.msbanque.web;

import com.example.msbanque.entities.Compte;
import com.example.msbanque.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestService {
    @Autowired
    public CompteRepository compteRepository;

    @Path("/compte")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }

    @Path("/compte/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne (@PathParam(value="id") Long id){
        return compteRepository.findById(id).get();
    }

    @Path("/compte")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save (Compte compte){
        return compteRepository.save(compte);
    }
}
