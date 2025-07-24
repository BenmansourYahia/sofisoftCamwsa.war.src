 package ma.sofisoft.cam2020ws;
 import com.google.gson.Gson;
 import com.google.gson.GsonBuilder;
 import com.google.gson.reflect.TypeToken;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.InputStream;
 import java.lang.reflect.Type;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Base64;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import ma.sofisoft.cam2020ws.DAO.CfgUtilisateurDAO;
 import ma.sofisoft.cam2020ws.DAO.DspMagasinDAO;
 import ma.sofisoft.cam2020ws.DAO.LineVenteDirectDAO;
 import ma.sofisoft.cam2020ws.DAO.ParametresDAO;
 import ma.sofisoft.cam2020ws.DAO.StkPrdDimDAO;
 import ma.sofisoft.cam2020ws.DAO.StkProdGenDAO;
 import ma.sofisoft.cam2020ws.DAO.StkVenteDirectDAO;
 import ma.sofisoft.cam2020ws.DAO.VueCaMagJourObjDAO;
 import ma.sofisoft.cam2020ws.DAO.VuePrdsVendusParDateDAO;
 import ma.sofisoft.cam2020ws.entity.CfgUtilisateur;
 import ma.sofisoft.cam2020ws.entity.DspMagasin;
 import ma.sofisoft.cam2020ws.entity.LineVenteDirect;
 import ma.sofisoft.cam2020ws.entity.Parametres;
 import ma.sofisoft.cam2020ws.entity.StkPrdDim;
 import ma.sofisoft.cam2020ws.entity.StkProduitsGenerique;
 import ma.sofisoft.cam2020ws.entity.StkVenteDirecte;
 import ma.sofisoft.cam2020ws.entity.VueCaMagJourObj;
 import ma.sofisoft.cam2020ws.entity.VuePrdsVendusParDate;
 import ma.sofisoft.cam2020ws.model.BestSalePrdModel;
 import ma.sofisoft.cam2020ws.model.MagasinModel;
 import ma.sofisoft.cam2020ws.model.MyResponse;
 import ma.sofisoft.cam2020ws.model.StockModel;
 import ma.sofisoft.cam2020ws.model.UserModel;
 import ma.sofisoft.cam2020ws.model.VenteModel;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.jdbc.core.RowMapper;
 import org.springframework.util.StreamUtils;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;
 
 
 
 

 
 
 @RestController
 @RequestMapping({"/*"})
 public class CamController
 {
   Logger logger = LoggerFactory.getLogger(ma.sofisoft.cam2020ws.CamController.class);
   
   public static final int TAG_STOCK_DIFF_ZERO = 1;
   
   public static final int TAG_STOCK_AVEC_ZERO = 2;
   
   public static final int TAG_STOCK_EQAL_ZERO = 3;
   
   public static final int TAG_STOCK_INF_ZERO = 4;
   
   public static final int TAG_STOCK_SUP_ZERO = 5;
   
   public static final int TAG_STOCK_FORMULA_ZERO = 6;
   
   public static final int TAG_STOCK_TOUS_PRODUITS = 7;
   
   @Autowired
   StkVenteDirectDAO venteDao;
   
   @Autowired
   LineVenteDirectDAO lineVenteDao;
   
   @Autowired
   StkProdGenDAO genDao;
   
   @Autowired
   StkPrdDimDAO dimDao;
   
   @Autowired
   ParametresDAO paramDao;
   
   @Autowired
   DspMagasinDAO magasinDao;
   
   @Autowired
   VueCaMagJourObjDAO vueCaMagJourDAO;
   @Autowired
   VuePrdsVendusParDateDAO vuePrdsDao;
   @Autowired
   CfgUtilisateurDAO cfgUserDao;
   @Autowired
   JdbcTemplate jdbcTemplate;
  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
   
   @RequestMapping({"/"})
   public String racine() {
    return "welcome to cam web Service ^_^ ";
   }
   
   public Gson getGson() {
     String DATE_FORMAT = "MM-dd-yyyy'T'HH:mm:ssZ";
    return (new GsonBuilder())
      .setDateFormat(DATE_FORMAT)
       .enableComplexMapKeySerialization()
     .create();
   }
   
   @RequestMapping(value = {"/bestSalesPrds"}, method = {RequestMethod.POST})
   public MyResponse bestSales(@RequestBody HashMap<String, Object> map) {
    MyResponse myResponse = new MyResponse();
     List<BestSalePrdModel> listBestSale = new ArrayList<>();
     try {
      int numMagasin = ((Integer)map.get("numMagasin")).intValue();
       Date debut = this.sdf.parse((String)map.get("debut"));
       Date fin = this.sdf.parse((String)map.get("fin"));
      this.logger.info("map : " + map);
      List<LineVenteDirect> listLineVente = new ArrayList<>();
      List<StkVenteDirecte> listVente = this.venteDao.getByDateMvtAndNumMagasin(debut, fin, Long.valueOf(numMagasin).longValue());
     this.logger.info("listVente : " + listVente.size());
      for (StkVenteDirecte vente : listVente) {
         listLineVente.addAll(this.lineVenteDao.getByNUmMvtAndNumMagasin(vente.getId().getNumMvt(), (int)vente.getId().getNumMagasin()));
       }
      this.logger.info("listLineVente : " + listLineVente.size());
       for (LineVenteDirect lineVente : listLineVente) {
         if (listBestSale.size() == 0) {
          BestSalePrdModel bestSale = new BestSalePrdModel();
          bestSale.setNumProduit(lineVente.getNumProduit());
        bestSale.setQuantite(lineVente.getQuantite().intValue());
         bestSale.setPrixVente(lineVente.getPrixVente().doubleValue());
           
         StkProduitsGenerique gen = this.genDao.findByNumProduit(bestSale.getNumProduit());
          bestSale.setCodeProduit(gen.getCodeProduit());
          bestSale.setDesignation(gen.getDesignation());
          listBestSale.add(bestSale);
           continue;
         } 
      boolean isExist = false;
      for (BestSalePrdModel bestSale : listBestSale) {
         if (bestSale.getNumProduit() == lineVente.getNumProduit()) {
            isExist = true;
             break;
           } 
         } 
         if (!isExist) {
          BestSalePrdModel bestSale = new BestSalePrdModel();
          bestSale.setNumProduit(lineVente.getNumProduit());
          bestSale.setQuantite(lineVente.getQuantite().intValue());
         bestSale.setPrixVente(lineVente.getPrixVente().doubleValue());
           
         StkProduitsGenerique gen = this.genDao.findByNumProduit(bestSale.getNumProduit());
          bestSale.setCodeProduit(gen.getCodeProduit());
           bestSale.setDesignation(gen.getDesignation());
           listBestSale.add(bestSale); continue;
         } 
        for (BestSalePrdModel bestSale : listBestSale) {
           if (bestSale.getNumProduit() == lineVente.getNumProduit()) {
             bestSale.setQuantite(bestSale.getQuantite() + lineVente.getQuantite().intValue());
           }
         } 
       } 
 
       
       Type typeOf = new TypeToken<List<BestSalePrdModel>>(){}.getType();
       String data = getGson().toJson(listBestSale, typeOf);
       myResponse.setData(data);
       myResponse.setSuccess(true);
     } catch (Exception e) {
       e.printStackTrace();
       this.logger.error(e.getMessage(), e);
      myResponse.setSuccess(false);
       myResponse.setException(e);
       myResponse.setMessage(e.getMessage());
     } 
     
    return myResponse;
   }
   
   @RequestMapping(value = {"/getLineVentes"}, method = {RequestMethod.POST})
   public List<LineVenteDirect> Linevente(@RequestBody HashMap<String, Object> map) {
     try {
      int numMvt = ((Integer)map.get("numMvt")).intValue();
       int numMagasin = ((Integer)map.get("numMagasin")).intValue();
       this.logger.info("numMvt : " + numMvt + " numMagasin : " + numMagasin);
       
       return this.lineVenteDao.getByNUmMvtAndNumMagasin(numMvt, numMagasin);
     } catch (Exception e) {
       e.printStackTrace();
      this.logger.error(e.getMessage(), e);
 
       
       return null;
     } 
   }
   @RequestMapping(value = {"/getLineVentes2"}, method = {RequestMethod.GET})
   public ResponseEntity<?> getLinesvente(@RequestBody HashMap<String, Object> map) {
     List<StkVenteDirecte> list = null;
     try {
       int numMvt = 1;
     int numMagasin = 2;
       this.logger.info("numMvt : " + numMvt + " numMagasin : " + numMagasin);
       list = this.venteDao.findByNumMvtAndNumMagasin(numMvt, numMagasin);
       return new ResponseEntity(list, HttpStatus.OK);
     }
     catch (Exception e) {
       e.printStackTrace();
       this.logger.error(e.getMessage(), e);
       return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
     } 
   }
 
   
   @RequestMapping(value = {"/getPrdsVendus"}, method = {RequestMethod.POST})
   public MyResponse getPrdsVendus(@RequestBody HashMap<String, Object> map) {
     MyResponse myResponse = new MyResponse();
     try {
       this.logger.info("map : " + map);
       
       int numMagasin = ((Integer)map.get("numMagasin")).intValue();
      Date debut = this.sdf.parse((String)map.get("debut"));
      Date fin = this.sdf.parse((String)map.get("fin"));
      List<VuePrdsVendusParDate> list = this.vuePrdsDao.getPrdsWithDimsByDateAndMagasin(debut, fin, numMagasin);
       Type typeOf = new TypeToken<List<VuePrdsVendusParDate>>(){}.getType();
       String data = getGson().toJson(list, typeOf);
       myResponse.setData(data);
      myResponse.setSuccess(true);
     }
   catch (Exception e) {
       e.printStackTrace();
      this.logger.error(e.getMessage(), e);
      myResponse.setSuccess(false);
       myResponse.setException(e);
       myResponse.setMessage(e.getMessage());
     } 
     
     return myResponse;
   }
   
   @RequestMapping(value = {"/getDimsPrdVendus"}, method = {RequestMethod.POST})
   public MyResponse getDimsPrdVendus(@RequestBody HashMap<String, Object> map) {
    MyResponse myResponse = new MyResponse();
     try {
       this.logger.info("map : " + map);
       
      int numMagasin = ((Integer)map.get("numMagasin")).intValue();
       int numProduit = ((Integer)map.get("numProduit")).intValue();
      Date debut = this.sdf.parse((String)map.get("debut"));
      Date fin = this.sdf.parse((String)map.get("fin"));
       this.logger.info("numProduit : " + numProduit);
       List<VuePrdsVendusParDate> list = this.vuePrdsDao.getByDateAndMagasinAndNumProduit(debut, fin, numMagasin, Long.valueOf(numProduit).longValue());
      Type typeOf = new TypeToken<List<VuePrdsVendusParDate>>(){}.getType();
       String data = getGson().toJson(list, typeOf);
       myResponse.setData(data);
      myResponse.setSuccess(true);
     }
    catch (Exception e) {
       e.printStackTrace();
      this.logger.error(e.getMessage(), e);
       myResponse.setSuccess(false);
      myResponse.setException(e);
      myResponse.setMessage(e.getMessage());
     } 
     
    return myResponse;
   }
   
   @RequestMapping(value = {"/getParam"}, method = {RequestMethod.POST})
   public MyResponse param() {
MyResponse response = new MyResponse();
     response.setDataObject(this.paramDao.findByModule("ANDROID_UPDATE_APP"));
return response;
   }
   
   @RequestMapping(value = {"/getMagasins"}, method = {RequestMethod.POST})
   public MyResponse Magasins() {
     MyResponse response = new MyResponse();
     try {
      Gson gson = new Gson();
      Type listType = new TypeToken<List<MagasinModel>>(){}.getType();
      String data = gson.toJson(this.magasinDao.findAll(), listType);
      response.setData(data);
      response.setSuccess(true);
     }
   catch (Exception e) {
       e.printStackTrace();
       this.logger.error(e.getMessage(), e);
      response.setSuccess(false);
      response.setException(e);
     } 
     
    return response;
   }
   
   @RequestMapping(value = {"/getMagasinsInfoByDate"}, method = {RequestMethod.POST})
   public MyResponse getMagasinsInfoByDate(@RequestBody HashMap map) {
     MyResponse reponse = new MyResponse();
     
     try {
      this.logger.info("map : " + map);
      boolean withDate = ((Boolean)map.get("withDate")).booleanValue();
       if (withDate) {
        Date debut = this.sdf.parse((String)map.get("debut"));
        Date fin = this.sdf.parse((String)map.get("fin"));
         
       Type typeOf = new TypeToken<List<VueCaMagJourObj>>(){}.getType();
        String data = getGson().toJson(this.vueCaMagJourDAO.getInfosByDateGroupedByMagasin(debut, fin), typeOf);
        reponse.setData(data);
         reponse.setSuccess(true);
       } else {
        Type typeOf = new TypeToken<List<VueCaMagJourObj>>(){}.getType();
        String data = getGson().toJson(this.vueCaMagJourDAO.getMagasinsInfos(), typeOf);
        reponse.setData(data);
         reponse.setSuccess(true);
       }
     
     } catch (Exception ex) {
      ex.printStackTrace();
       this.logger.error(ex.getMessage(), ex);
       reponse.setSuccess(false);
       reponse.setException(ex);
     } 
    return reponse;
   }
   
   @RequestMapping(value = {"/getMagasinsInfos"}, method = {RequestMethod.POST})
   public List<VueCaMagJourObj> getMagasinsInfos(@RequestBody HashMap map) {
     this.logger.info("map : " + map);
     boolean withDate = ((Boolean)map.get("withDate")).booleanValue();
     if (withDate) {
       try {
         Date debut = this.sdf.parse((String)map.get("debut"));
       Date fin = this.sdf.parse((String)map.get("fin"));
         return this.vueCaMagJourDAO.getInfosByDateGroupedByMagasin(debut, fin);
      } catch (Exception e) {
       e.printStackTrace();
        return new ArrayList<>();
       } 
     }
     
     return new ArrayList<>();
   }
   
   @RequestMapping(value = {"/getComparePeriode"}, method = {RequestMethod.POST})
   public MyResponse getComparePeriode(@RequestBody HashMap map) {
    MyResponse reponse = new MyResponse();
     
     try {
       this.logger.info("map : " + map);
       Date dateDebut_1 = this.sdf.parse((String)map.get("dateDebut_1"));
    Date dateFin_1 = this.sdf.parse((String)map.get("dateFin_1"));
      Date dateDebut_2 = this.sdf.parse((String)map.get("dateDebut_2"));
       Date dateFin_2 = this.sdf.parse((String)map.get("dateFin_2"));
       String codeMagasin = (String)map.get("codeMagasin");
       
      List<VueCaMagJourObj> listVues = new ArrayList<>();
     listVues.add(this.vueCaMagJourDAO.getInfosByDateAndMagasin(dateDebut_1, dateFin_1, codeMagasin));
       listVues.add(this.vueCaMagJourDAO.getInfosByDateAndMagasin(dateDebut_2, dateFin_2, codeMagasin));
       this.logger.info("listVueCompart: " + listVues);
       Type typeOf = new TypeToken<List<VueCaMagJourObj>>(){}.getType();
String data = getGson().toJson(listVues, typeOf);
      reponse.setData(data);
      reponse.setSuccess(true);
     } catch (Exception ex) {
       ex.printStackTrace();
       reponse.setSuccess(false);
       reponse.setException(ex);
       reponse.setMessage(ex.getMessage());
     } 
     
     return reponse;
   }
   
   @RequestMapping(value = {"/getInfosByDate"}, method = {RequestMethod.POST})
   public MyResponse getInfosByDate(@RequestBody HashMap map) {
     MyResponse response = new MyResponse();
     
     try {
      this.logger.info("map : " + map);
      Date debut = this.sdf.parse((String)map.get("debut"));
      Date fin = this.sdf.parse((String)map.get("fin"));
      this.logger.info("debut : " + debut + " fin : " + fin);
       
      Calendar cStart = Calendar.getInstance();
       Calendar cEnd = Calendar.getInstance();
       Calendar cal = Calendar.getInstance();
      if (fin.getTime() - debut.getTime() < 604800000L) {
         
        cal.setTime(debut);
         cStart.setTime(debut);
         cStart.add(1, -1);
         cStart.set(3, cal.get(3));
        cStart.setFirstDayOfWeek(2);
         
      cEnd.setTime(cStart.getTime());
        cEnd.add(7, 6);
        cEnd.set(11, 23);
        cEnd.set(12, 59);
        cEnd.set(13, 59);
        this.logger.info("is week periode ! " + cal.get(3));
        this.logger.info("date debut Prec : " + this.sdf.format(cStart.getTime()) + " date fin Prec : " + this.sdf.format(cEnd.getTime()));
       } else {
         
         this.logger.info("is not a week periode !");
        cStart = Calendar.getInstance();
       cEnd = Calendar.getInstance();
        cStart.setTime(debut);
       cEnd.setTime(fin);
        cStart.add(1, -1);
        cEnd.add(1, -1);
        this.logger.info("date debut Prec : " + this.sdf.format(cStart.getTime()) + " date fin Prec : " + this.sdf.format(cEnd.getTime()));
       } 
       
       VueCaMagJourObj vueCaCompare = this.vueCaMagJourDAO.getInfosByDateNotGrouped(cStart.getTime(), cEnd.getTime());
       
      List<VueCaMagJourObj> listVueVentes = this.vueCaMagJourDAO.getInfosByDateGroupedByVenteDay(debut, fin);
       Type typeOf = new TypeToken<List<VueCaMagJourObj>>(){}.getType();
       String data = getGson().toJson(listVueVentes, typeOf);
       HashMap<String, String> obj = new HashMap<>();
       obj.put("data", data);
      obj.put("objCompare", getGson().toJson(vueCaCompare));
     response.setData(obj.toString());
       response.setSuccess(true);
     }
    catch (Exception e) {
      e.printStackTrace();
       this.logger.error(e.getMessage(), e);
       response.setSuccess(false);
      response.setException(e);
     } 
    return response;
   }
   
   @RequestMapping(value = {"/getInfosDay"}, method = {RequestMethod.POST})
   public MyResponse getInfosDay(@RequestBody HashMap map) {
    MyResponse response = new MyResponse();
     
     try {
       this.logger.info("map : " + map);
       Date debut = this.sdf.parse((String)map.get("debut"));
      Date fin = this.sdf.parse((String)map.get("fin"));
       
     List<StkVenteDirecte> listVentes = this.venteDao.getVentesByDate(debut, fin);
       List<VenteModel> listVenteModel = new ArrayList<>();
       for (StkVenteDirecte vente : listVentes) {
         VenteModel v = new VenteModel();
        v.setDateMvt(vente.getDateMvt());
        v.setMontantTtc(vente.getMontantTtc());
        v.setHour(vente.getHour());
        listVenteModel.add(v);
       } 
       
      Calendar cStart = Calendar.getInstance();
       Calendar cEnd = Calendar.getInstance();
       Calendar cal = Calendar.getInstance();
      cal.setTime(debut);
       cStart.setTime(debut);
       cStart.add(1, -1);
      cStart.set(3, cal.get(3));
      cStart.set(7, cal.get(7));
       
       cEnd.setTime(cStart.getTime());
      cEnd.set(11, 23);
      cEnd.set(12, 59);
       cEnd.set(13, 59);
      this.logger.info("date debut Prec : " + this.sdf.format(cStart.getTime()) + " date fin Prec : " + this.sdf.format(cEnd.getTime()));
       
       List<VueCaMagJourObj> vueList = this.vueCaMagJourDAO.getInfosByDateGroupedByMagasin(debut, fin);
       VueCaMagJourObj vueCaCompare = this.vueCaMagJourDAO.getInfosByDateNotGrouped(cStart.getTime(), cEnd.getTime());
       
      Type typeOf = new TypeToken<List<VenteModel>>(){}.getType();
      Type typeOf2 = new TypeToken<List<VueCaMagJourObj>>(){}.getType();
      String data = getGson().toJson(listVenteModel, typeOf);
      HashMap<String, String> obj = new HashMap<>();
      obj.put("data", data);
       obj.put("objCompare", getGson().toJson(vueCaCompare));
       obj.put("vueInfos", getGson().toJson(vueList, typeOf2));
      response.setData(obj.toString());
     response.setSuccess(true);
     
     }
    catch (Exception e) {
     e.printStackTrace();
       this.logger.error(e.getMessage(), e);
      response.setSuccess(false);
      response.setException(e);
     } 
    return response;
   }
   
   @RequestMapping(value = {"/getDims"}, method = {RequestMethod.POST})
   public StkPrdDim getDims(@RequestBody HashMap mapRequest) {
     String barCode = (String)mapRequest.get("barCode");
    this.logger.info("barCode : " + barCode);
     return this.dimDao.findByCodeBarre(barCode);
   }
   
   public HashMap<String, Object> isHadDims(HashMap mapRequest) {
     HashMap<String, Object> map = new HashMap<>();
    StkProduitsGenerique gen = null;
    this.logger.info("mapRequest : " + mapRequest);
   boolean isByBarcode = ((Boolean)mapRequest.get("isByBarcode")).booleanValue();
    if (isByBarcode) {
      String barCode = (String)mapRequest.get("barecode");
      this.logger.info("codeProduit : " + barCode);
     StkPrdDim dim = this.dimDao.findByCodeBarre(barCode);
     if (dim != null) gen = this.genDao.findByNumProduit(dim.getNumProduit());
     
     } else {
      String codeProduit = (String)mapRequest.get("codeProduit");
       this.logger.info("codeProduit : " + codeProduit);
       StkPrdDim dim = this.dimDao.findByCodeProduit(codeProduit);
       if (dim != null) gen = this.genDao.findByNumProduit(dim.getNumProduit());
     
     } 
     if (gen == null) {
      this.logger.info("gen is null");
      map.put("isHadDims", Boolean.valueOf(false));
       return map;
     } 
     
    List<StkPrdDim> listDims = this.dimDao.findByNumProduit(gen.getNumProduit());
     if (listDims != null) this.logger.info("listDims size : " + listDims.size());
     if (listDims != null && listDims.size() == 1 && gen.getCodeProduit().equals(((StkPrdDim)listDims.get(0)).getCodeProduit())) {
     map.put("isHadDims", Boolean.valueOf(false));
     } else {
      map.put("isHadDims", Boolean.valueOf(true));
       map.put("listDims", listDims);
       map.put("numProduit", Integer.valueOf(gen.getNumProduit()));
     } 
     
    map.put("designation", gen.getDesignation());
    return map;
   }
   
   @RequestMapping(value = {"/StockByProduct"}, method = {RequestMethod.POST})
   public MyResponse searchProductStock(@RequestBody HashMap map) {
     MyResponse response = new MyResponse();
     
     HashMap<String, Object> isHadDimsMap = isHadDims(map);
     boolean isHadDims = ((Boolean)isHadDimsMap.get("isHadDims")).booleanValue();
     if (isHadDims) {
       int numProduit = ((Integer)isHadDimsMap.get("numProduit")).intValue();
       String designation = (String)isHadDimsMap.get("designation");
       response = getProductStockForDims(numProduit, designation);
     } else {
       boolean isByBarcode = ((Boolean)map.get("isByBarcode")).booleanValue();
       if (isByBarcode) {
         String barCode = (String)map.get("barecode");
         response = getProductStockByBarcode(barCode);
       } else {
       String codeProduit = (String)map.get("codeProduit");
        String designation = (String)isHadDimsMap.get("designation");
        response = getProductStockForGen(codeProduit, designation);
       } 
     } 
    return response;
   }
   
   public MyResponse getProductStockForGen(String codeProduit, String designation) {
     MyResponse response = new MyResponse();
     
    Object object = new Object(); // TODO: Vérifier la logique métier

          String query = "select depot.designation,isnull(PRD_DIM_DEPOT.QUANTITE,0) as quantite, stk_produits_generique.designation nomProduit from   depot, PRD_DIM_DEPOT,stk_prd_dim,stk_produits_generique where depot.CODE_DEPOT = PRD_DIM_DEPOT.CODE_DEPOT and stk_produits_generique.num_produit = stk_prd_dim.num_produit and stk_prd_dim.num_dims = prd_dim_depot.num_dims and (STK_PRD_DIM.code_produit = ? or stk_produits_generique.designation = ?)";

     
   this.logger.info("query : " + query);
     
     List<StockModel> stockModel = this.jdbcTemplate.query(query, new Object[] { codeProduit, codeProduit }, (RowMapper)object);
    Type typeOf = new TypeToken<List<StockModel>>(){}.getType();
     String data = getGson().toJson(stockModel, typeOf);
     HashMap<String, Object> map = new HashMap<>();
     map.put("data", data);
     map.put("isHadDims", Boolean.valueOf(false));
     map.put("designation", designation);
    typeOf = new TypeToken<HashMap<String, Object>>(){}.getType();
     response.setData(getGson().toJson(map, typeOf));
    response.setSuccess(true);
    return response;
   }
   
   public MyResponse getProductStockForDims(int numProduit, String designation) {
    MyResponse response = new MyResponse();
     Object object = new Object(); // TODO: Vérifier la logique métier

     
     String query = "select stk_prd_dim.num_produit numProduit, \t   code_produit CODE_PRODUIT, \t   stk_dim1.NUM_DIM1, \t   stk_dim2.NUM_DIM2, \t   stk_dim1.libelle Couleur, \t   stk_dim2.libelle Taille, \t   designation DESIGNATION,\t    depot.CODE_DEPOT,\t   isnull(prd_dim_depot.quantite,0) Quantite from   stk_prd_dim, stk_dim1, \t\tstk_dim2, prd_dim_depot, \t\tdepot where stk_prd_dim.num_dim1 *= stk_dim1.num_dim1 and\t\tstk_prd_dim.num_dim2 *= stk_dim2.num_dim2 and\t\tstk_prd_dim.num_dims *= prd_dim_depot.num_dims and \t\tdepot.code_depot *= prd_dim_depot.code_depot and \t\tstk_prd_dim.num_produit = ? order by 3,4,6";

     
     this.logger.info("numProduit : " + numProduit + " -- query : " + query);
     
    List<StockModel> stockModel = this.jdbcTemplate.query(query, new Object[] { Integer.valueOf(numProduit) }, (RowMapper)object);
     Type typeOf = new TypeToken<List<StockModel>>(){}.getType();
     String data = getGson().toJson(stockModel, typeOf);
     HashMap<String, Object> map = new HashMap<>();
    map.put("data", data);
     map.put("isHadDims", Boolean.valueOf(true));
     map.put("designation", designation);
     typeOf = new TypeToken<HashMap<String, Object>>(){}.getType();
     response.setData(getGson().toJson(map, typeOf));
    response.setSuccess(true);
     return response;
   }
   
   public MyResponse getProductStockByBarcode(String barcode) {
     MyResponse response = new MyResponse();
     Object object = new Object(); // TODO: Vérifier la logique métier
 

     
     String query = "select depot.designation,isnull(PRD_DIM_DEPOT.QUANTITE,0) as quantite, stk_produits_generique.designation nomProduit from   depot, PRD_DIM_DEPOT,stk_prd_dim,stk_produits_generique where depot.CODE_DEPOT = PRD_DIM_DEPOT.CODE_DEPOT and stk_produits_generique.num_produit = stk_prd_dim.num_produit and stk_prd_dim.num_dims = prd_dim_depot.num_dims and STK_PRD_DIM.CODE_BARRE = ?";
 

     
    this.logger.info("query : " + query);
     
    List<StockModel> stockModel = this.jdbcTemplate.query(query, new Object[] { barcode }, (RowMapper)object);
    Type typeOf = new TypeToken<List<StockModel>>(){}.getType();
     String data = getGson().toJson(stockModel, typeOf);
     HashMap<String, Object> map = new HashMap<>();
     map.put("data", data);
     map.put("isHadDims", Boolean.valueOf(false));
     typeOf = new TypeToken<HashMap<String, Object>>(){}.getType();
    response.setData(getGson().toJson(map, typeOf));
     response.setSuccess(true);
     return response;
   }

 

   @RequestMapping(value = {"/GlobalStock"}, method = {RequestMethod.POST})
   public MyResponse globalStock(@RequestBody HashMap map) {
     Object object = new Object();


     MyResponse response = new MyResponse();
     this.logger.info("map " + map);
    int from = ((Integer)map.get("from")).intValue();
    int to = ((Integer)map.get("to")).intValue();
    int stockBy = ((Integer)map.get("stockBy")).intValue();
     String chaine = "";
     switch (stockBy) {
       case 2:
         this.logger.info("TAG_STOCK_AVEC_ZERO");
         chaine = "";
         break;
       case 1:
        this.logger.info("TAG_STOCK_DIFF_ZERO");
         chaine = " having sum(p_depot.QUANTITE) != 0 ";
         break;
       case 3:
         this.logger.info("TAG_STOCK_EQA_ZERO");
         chaine = " having sum(p_depot.QUANTITE) = 0 ";
         break;
       case 4:
         this.logger.info("TAG_STOCK_INF_ZERO");
         chaine = " having sum(p_depot.QUANTITE) < 0 ";
         break;
       case 5:
         this.logger.info("TAG_STOCK_SUP_ZERO");
         chaine = " having sum(p_depot.QUANTITE) > 0 ";
         break;
       case 7:
         chaine = "";
         break;
       case 6:
         this.logger.info("TAG_STOCK_FORMULA_ZERO");
         chaine = (String)map.get("chaine");
         break;
       default:
         this.logger.info("default");
        chaine = "";
         break;
     } 
     
    String query = "select MyDerivedTable.DESIGNATION ,MyDerivedTable.CODE_PRODUIT ,MyDerivedTable.QUANTITE from (select gen.DESIGNATION,dims.CODE_PRODUIT,sum(p_depot.QUANTITE) QUANTITE,ROW_NUMBER() OVER(ORDER BY gen.DESIGNATION ) AS ROW from PRD_DIM_DEPOT p_depot,STK_PRD_DIM dims,STK_PRODUITS_GENERIQUE gen where p_depot.NUM_DIMS = dims.NUM_DIMS and gen.NUM_PRODUIT = p_depot.NUM_PRODUIT group by dims.CODE_PRODUIT,gen.DESIGNATION,dims.num_dims " + chaine + " ) AS MyDerivedTable " + " WHERE MyDerivedTable.Row BETWEEN ? AND ?";
     
     this.logger.info("query : " + query);
     List<StockModel> stockModel = this.jdbcTemplate.query(query, new Object[] { Integer.valueOf(from), Integer.valueOf(to) }, (RowMapper)object);
    Type typeOf = new TypeToken<List<StockModel>>(){}.getType();
     String data = getGson().toJson(stockModel, typeOf);
     response.setData(data);
     response.setSuccess(true);
     return response;
   }
 
   
   @RequestMapping(value = {"/Login"}, method = {RequestMethod.POST})
   public MyResponse Login(@RequestBody HashMap map) {
/* 855 */     MyResponse response = new MyResponse();
     
     try {
      this.logger.info("map : " + map);
      String nom = (String)map.get("nom");
      String motPasse = (String)map.get("motPasse");
       
      CfgUtilisateur cfg = this.cfgUserDao.findByNomAndMotPasse(nom, motPasse);
      if (cfg != null) {
        List<DspMagasin> listDspMag = this.magasinDao.getMagasins();
        List<MagasinModel> listModelMag = new ArrayList<>();
        for (DspMagasin mag : listDspMag) {
           MagasinModel magModel = new MagasinModel(mag.getNumMagasin(), mag.getCodeMagasin(), mag.getNomMagasin());
          listModelMag.add(magModel);
         } 
         UserModel user = new UserModel(cfg.getId().getNumUtilisateur(),
           cfg.getId().getNumMagasin(),
          cfg.getNom(),
            cfg.getMotPasse(),
             cfg.getNumVendeur());
         List<Parametres> listParam = this.paramDao.findByModule("ANDROID_APP");
         for (Parametres param : listParam) {
           if (param.getId().getParametre() != null && param.getId().getParametre().trim().equals("IMAGE_LOGO")) {
             try {
              String imagePath = param.getValeur();
              File f = new File(imagePath);
              InputStream targetStream = new FileInputStream(f);
               byte[] bytes = StreamUtils.copyToByteArray(targetStream);
             String imageBase64 = new String(Base64.getEncoder().encode(bytes), "UTF-8");
            this.logger.info("imageBase64 " + imageBase64);
              param.setValeur(imageBase64);
             } catch (FileNotFoundException ex) {
               this.logger.error(ex.getMessage(), ex);
               
               param.setValeur(null);
             } 
           }
         } 
         
        HashMap<String, Object> data = new HashMap<>();
         data.put("user", user);
        data.put("mags", listModelMag);
         data.put("param", listParam);
       response.setData(getGson().toJson(data));
         response.setSuccess(true);
       } else {
        response.setSuccess(false);
        response.setMessage("nom utilisateur ou mot de passe est incorrect !");
       } 
     } catch (Exception ex) {
      ex.printStackTrace();
     response.setSuccess(false);
      response.setMessage(ex.getMessage());
      response.setException(ex);
     } 
     
     return response;
   }
   
   @RequestMapping(value = {"/Magasins"}, method = {RequestMethod.POST})
   public MyResponse getMagasins() {
    MyResponse response = new MyResponse();
     try {
      List<DspMagasin> listDspMag = this.magasinDao.getMagasins();
      this.logger.info("listSize : " + listDspMag.size());
     List<MagasinModel> listModelMag = new ArrayList<>();
      for (DspMagasin mag : listDspMag) {
         MagasinModel magModel = new MagasinModel(mag.getNumMagasin(), mag.getCodeMagasin(), mag.getNomMagasin());
       listModelMag.add(magModel);
       } 
       HashMap<String, Object> data = new HashMap<>();
      data.put("mags", listModelMag);
      response.setData(getGson().toJson(data));
       response.setSuccess(true);
     }
    catch (Exception ex) {
    this.logger.error(ex.getMessage(), ex);
     response.setSuccess(false);
      response.setMessage(ex.getMessage());
      response.setException(ex);
     } 
     
    return response;
   }
   @RequestMapping(value = {"/checkServer"}, method = {RequestMethod.POST})
   public Integer checkServer(@RequestBody Integer number) {
    this.logger.info("checkServer " + (number.intValue() * 2));
     return Integer.valueOf(number.intValue() * 2);
   }
 }
