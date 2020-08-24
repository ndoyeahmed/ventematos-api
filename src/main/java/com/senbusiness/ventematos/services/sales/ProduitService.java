package com.senbusiness.ventematos.services.sales;

import com.senbusiness.ventematos.entities.sales.Categorie;
import com.senbusiness.ventematos.entities.sales.Produit;
import com.senbusiness.ventematos.repositories.sales.CategorieRepository;
import com.senbusiness.ventematos.repositories.sales.ProduitRepository;
import com.senbusiness.ventematos.utils.Utils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log
public class ProduitService {
    private ProduitRepository produitRepository;
    private CategorieRepository categorieRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository, CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
        this.produitRepository = produitRepository;
    }

    public Categorie saveCategorie(Categorie categorie) {
        try {
            categorieRepository.save(categorie);
            return categorie;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<Categorie> categorieList() {
        return categorieRepository.findAll();
    }

    public Categorie findCategorieByLibelle(String libelle) {
        try {
            return categorieRepository.findByLibelle(libelle).orElse(null);
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public Categorie findCategorieById(Long id) {
        return categorieRepository.findById(id)
                .orElse(null);
    }

    public Produit saveProduit(Produit produit) {
        try {
            produit.setArchive(false);
            produit.setCode(Utils.genereCode(produit.getCategorie().getLibelle(), "P",
                    produitRepository.getMaxId().orElse(null)));
            produitRepository.save(produit);
            return produit;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<Produit> produitList(boolean archive) {
        return produitRepository.findAllByArchive(archive)
                .orElse(new ArrayList<>());
    }

    public List<Produit> produitListByCategorie(Categorie categorie) {
        return produitRepository.findAllByArchiveFalseAndCategorie(categorie)
                .orElse(new ArrayList<>());
    }
}
