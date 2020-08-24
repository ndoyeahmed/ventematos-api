package com.senbusiness.ventematos.utils;

import com.senbusiness.ventematos.repositories.sales.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {

    public static String getLogin(String nom, String prenom) {

        // initialize a Random object somewhere; you should only need one
        Random random = new Random();

        // generate a random integer from 0 to 899, then add 100
        int x = random.nextInt(900);

        return prenom.substring(0, 2).concat(nom + x);
    }

    public static String createCode(String libelle) {

        // initialize a Random object somewhere; you should only need one
        Random random = new Random();

        // generate a random integer from 0 to 899, then add 100
        int x = random.nextInt(900);

        return libelle.trim().concat("" + x);
    }

    public static String generateMatricule(String nom, String prenom, Timestamp date) {

        // initialize a Random object somewhere; you should only need one
        Random random = new Random();

        // generate a random integer from 0 to 899, then add 100
        int x = random.nextInt(900);

        return prenom.substring(0, 2).concat(nom + date.toString().trim() + x);
    }

    public static String genereCode(String libelle, String prefix, Integer lastId){

        if (lastId == null){
            return prefix + "-" + libelle.trim().substring(0, 3) + "00001";

        }else {
            return prefix + "-" + libelle.trim().substring(0, 3) + new DecimalFormat("00000").format(lastId+1) ;
        }

    }
}
