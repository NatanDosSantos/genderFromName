package com.example.demo.service;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;

@Service
public class MaleOrFemaleService {

    public String getGender(String name) throws Exception{
        RConnection c = new RConnection();
        if(c.isConnected()) {
            c.eval("library(genderBR)");
            REXP x = c.eval("get_gender('" + name + "')");
            if(x.asString().equalsIgnoreCase("Male")){
                return "Masculino";
            }
            return "Feminino";
        }else{
            throw new Exception("Servidor não conectado");
        }


    }
}
