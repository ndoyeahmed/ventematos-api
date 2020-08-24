package com.senbusiness.ventematos.web.controllers.sales;

import com.senbusiness.ventematos.entities.sales.Categorie;
import com.senbusiness.ventematos.entities.sales.Produit;
import com.senbusiness.ventematos.services.sales.ProduitService;
import com.senbusiness.ventematos.web.exceptions.BadRequestException;
import com.senbusiness.ventematos.web.exceptions.EntityNotFoundException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales/")
@Log
public class ProduitController {
    private ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("categories")
    public ResponseEntity<?> saveCategorie(@RequestBody Categorie categorie) {
        if (categorie == null) throw new BadRequestException("categorie cannot be null");

        if (categorie.getLibelle() == null || categorie.getLibelle().trim().equals(""))
            throw new BadRequestException("Le libellé est obligatoire");

        if (produitService.findCategorieByLibelle(categorie.getLibelle()) != null)
            throw new BadRequestException("Cette catégorie existe déja");

        return ResponseEntity.status(HttpStatus.CREATED).body(produitService.saveCategorie(categorie));
    }

    @GetMapping("categories")
    public ResponseEntity<?> categorieList() {
        return ResponseEntity.ok(produitService.categorieList());
    }

    @PostMapping("produits")
    public ResponseEntity<?> saveProduit(@RequestBody Produit produit) {
        if (produit == null) throw new BadRequestException("produit cannot be null");
        if (produit.getLibelle() == null || produit.getLibelle().trim().equals(""))
            throw new BadRequestException("libelle required");
        if (produit.getPrixMinimal() == null || produit.getPrixMinimal() <= 0)
            throw new BadRequestException("prix minimal required");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produitService.saveProduit(produit));
    }

    @GetMapping("produits/categorie/{categorieId}")
    public ResponseEntity<?> produitListByCategorie(@PathVariable Long categorieId) {
        if (categorieId == null) throw new BadRequestException("categorie id cannot be null");

        Categorie categorie = produitService.findCategorieById(categorieId);
        if (categorie == null) throw new EntityNotFoundException("categorie not found");

        return ResponseEntity.ok(produitService.produitListByCategorie(categorie));
    }

    @GetMapping("produits/archive/{archive}")
    public ResponseEntity<?> produitList(@PathVariable Boolean archive) {
        if (archive == null) throw new BadRequestException("archive cannot be null");

        return ResponseEntity.ok(produitService.produitList(archive));
    }
}
