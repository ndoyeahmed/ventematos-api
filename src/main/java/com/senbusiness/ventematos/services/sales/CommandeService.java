package com.senbusiness.ventematos.services.sales;

import com.senbusiness.ventematos.entities.sales.Client;
import com.senbusiness.ventematos.entities.sales.Commande;
import com.senbusiness.ventematos.entities.sales.LineCommande;
import com.senbusiness.ventematos.repositories.sales.*;
import com.senbusiness.ventematos.utils.Utils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log
public class CommandeService {
    private ClientRepository clientRepository;
    private CommandeRepository commandeRepository;
    private FactureRepository factureRepository;
    private LineCommandeRepository lineCommandeRepository;
    private PaiementRepository paiementRepository;
    private ProduitService produitService;

    @Autowired
    public CommandeService(ClientRepository clientRepository, CommandeRepository commandeRepository,
                           FactureRepository factureRepository, LineCommandeRepository lineCommandeRepository,
                           PaiementRepository paiementRepository, ProduitService produitService) {
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
        this.factureRepository = factureRepository;
        this.lineCommandeRepository = lineCommandeRepository;
        this.paiementRepository = paiementRepository;
        this.produitService = produitService;
    }

    public List<Client> clientListByArchive(boolean archive) {
        return clientRepository.findAllByArchive(archive)
                .orElse(new ArrayList<>());
    }

    public Commande addCommande(Commande commande) {
        try {
            commande.setArchive(false);
            commande.setCode(Utils.genereCode("commande", "C", commandeRepository.getMaxId().orElse(null)));
            commande.setStatut(0);
            commande.setDateCommande(Timestamp.valueOf(LocalDateTime.now()));
            commandeRepository.save(commande);
            return commande;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<LineCommande> addLineCommande(List<LineCommande> lineCommandes) {
        try {
            Commande commande = addCommande(lineCommandes.get(0).getCommande());
            lineCommandes.forEach(lc -> lc.setCommande(commande));
            lineCommandeRepository.saveAll(lineCommandes);
            return lineCommandes;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Commande> commandeListByArchiveAndStatut(boolean archive, int statut) {
        return commandeRepository.findAllByArchiveAndStatut(archive, statut)
                .orElse(new ArrayList<>());
    }

    public Commande findCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElse(null);
    }

    public List<LineCommande> lineCommandeListByCommande(Commande commande) {
        return lineCommandeRepository.findAllByCommande(commande)
                .orElse(new ArrayList<>());
    }
}
