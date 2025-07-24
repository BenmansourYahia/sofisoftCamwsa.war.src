package ma.sofisoft.cam2020ws.DAO;

import ma.sofisoft.cam2020ws.entity.CfgUtilisateur;
import ma.sofisoft.cam2020ws.entity.CfgUtilisateurId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CfgUtilisateurDAO extends JpaRepository<CfgUtilisateur, CfgUtilisateurId> {
  CfgUtilisateur findByNomAndMotPasse(String paramString1, String paramString2);
}

