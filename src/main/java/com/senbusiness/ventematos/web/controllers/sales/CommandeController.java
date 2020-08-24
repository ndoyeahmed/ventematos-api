package com.senbusiness.ventematos.web.controllers.sales;

import com.senbusiness.ventematos.entities.sales.Commande;
import com.senbusiness.ventematos.entities.sales.LineCommande;
import com.senbusiness.ventematos.services.sales.CommandeService;
import com.senbusiness.ventematos.web.exceptions.BadRequestException;
import com.senbusiness.ventematos.web.exceptions.EntityNotFoundException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales/")
@Log
public class CommandeController {
    private CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("clients/archive/{archive}")
    public ResponseEntity<?> clientListByArchive(@PathVariable Boolean archive) {
        if (archive == null) throw new BadRequestException("archive cannot be null");

        return ResponseEntity.ok(commandeService.clientListByArchive(archive));
    }

    @PostMapping("commandes")
    public ResponseEntity<?> addCommande(@RequestBody List<LineCommande> lineCommandes) {
        try {
            return ResponseEntity.ok(commandeService.addLineCommande(lineCommandes));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("error");
        }
    }

    @GetMapping("commandes/archive/{archive}/statut/{statut}")
    public ResponseEntity<?> commandeListByArchiveAndStatut(@PathVariable Boolean archive, @PathVariable Integer statut) {
        if (archive == null) throw new BadRequestException("archive cannot be null");
        if (statut == null) throw new BadRequestException("statut cannot be null");

        return ResponseEntity.ok(commandeService.commandeListByArchiveAndStatut(archive, statut));
    }

    @GetMapping("commandes/linecommande/{commandeId}")
    public ResponseEntity<?> lineCommandeListByCommande(@PathVariable Long commandeId) {
        if (commandeId == null) throw new BadRequestException("commandeId cannot be null");

        Commande commande = commandeService.findCommandeById(commandeId);
        if (commande == null) throw new EntityNotFoundException("commande not found");

        return ResponseEntity.ok(commandeService.lineCommandeListByCommande(commande));
    }
}
