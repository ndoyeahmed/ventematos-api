package com.senbusiness.ventematos.repositories.admin;

import com.senbusiness.ventematos.entities.admin.Profil;
import com.senbusiness.ventematos.entities.admin.ProfilUtilisateur;
import com.senbusiness.ventematos.entities.admin.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilUtilisateurRepository extends JpaRepository<ProfilUtilisateur, Long> {
    Optional<ProfilUtilisateur> findByUtilisateurAndProfil(Utilisateur utilisateur, Profil profil);
}
