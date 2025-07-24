package ma.sofisoft.cam2020ws.DAO;

import java.util.Date;
import java.util.List;
import ma.sofisoft.cam2020ws.entity.StkVenteDirecte;
import ma.sofisoft.cam2020ws.entity.StkVenteDirecteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StkVenteDirectDAO extends JpaRepository<StkVenteDirecte, StkVenteDirecteId> {
  @Query("select new StkVenteDirecte(cast(v.dateMvt as date), SUM(v.montantTtc), hour(v.dateMvt)) from StkVenteDirecte v where v.dateMvt between ?1 and ?2 group by cast(v.dateMvt as date),hour(v.dateMvt) order by hour(v.dateMvt)")
  List<StkVenteDirecte> getVentesByDate(Date paramDate1, Date paramDate2);
  
  @Query("select new StkVenteDirecte(v.id, v.dateMvt, v.numVente, v.montantTtc, v.tauxRemise, v.sensStk) from StkVenteDirecte v where v.id.numMvt = ?1 and v.id.numMagasin = ?2")
  List<StkVenteDirecte> findByNUmMvtAndNumMagasin(int paramInt, long paramLong);
  
  List<StkVenteDirecte> findByNumMvtAndNumMagasin(int paramInt, long paramLong);
  
  @Query("select new StkVenteDirecte(v.id, v.dateMvt, v.numVente, v.montantTtc, v.tauxRemise, v.sensStk) from StkVenteDirecte v where v.dateMvt between ?1 and ?2 and v.id.numMagasin = ?3")
  List<StkVenteDirecte> getByDateMvtAndNumMagasin(Date paramDate1, Date paramDate2, long paramLong);
}

