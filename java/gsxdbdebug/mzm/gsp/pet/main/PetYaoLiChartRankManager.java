/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.Pet;
/*    */ import xbean.PetYaoliBean;
/*    */ import xbean.PetYaoliRank;
/*    */ 
/*    */ public class PetYaoLiChartRankManager extends mzm.gsp.chart.main.NoneRoleKeyRankManagerNew<Long, PetYaoLiChart>
/*    */ {
/*    */   private static PetYaoLiChartRankManager instance;
/*    */   
/*    */   public static PetYaoLiChartRankManager getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */   private PetYaoLiChartRankManager(int capacity)
/*    */   {
/* 20 */     super(capacity);
/*    */   }
/*    */   
/*    */   static void init() {
/* 24 */     if (instance != null) {
/* 25 */       return;
/*    */     }
/* 27 */     instance = new PetYaoLiChartRankManager(1);
/*    */   }
/*    */   
/*    */   public void saveToDB()
/*    */   {
/* 32 */     List<PetYaoLiChart> allObjs = getAllChartObjs();
/* 33 */     PetYaoliRank petYaoliRank = xtable.Petyaolirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 34 */     if (petYaoliRank == null) {
/* 35 */       petYaoliRank = xbean.Pod.newPetYaoliRank();
/* 36 */       xtable.Petyaolirank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), petYaoliRank);
/*    */     }
/* 38 */     petYaoliRank.getRolerankdatas().clear();
/* 39 */     for (PetYaoLiChart petYaoLiChart : allObjs)
/*    */     {
/* 41 */       PetYaoliBean petYaoliBean = xbean.Pod.newPetYaoliBean();
/* 42 */       petYaoliBean.setPetid(petYaoLiChart.getKey().longValue());
/* 43 */       petYaoliBean.setRoleid(petYaoLiChart.getRoleId());
/* 44 */       petYaoliRank.getRolerankdatas().add(petYaoliBean);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 51 */     PetYaoliRank petYaoliRank = xtable.Petyaolirank.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 52 */     if (null != petYaoliRank) {
/* 53 */       for (PetYaoliBean petYaoliBean : petYaoliRank.getRolerankdatas()) {
/* 54 */         int yaolinum = PetInterface.getPetYaoli(petYaoliBean.getRoleid(), petYaoliBean.getPetid());
/* 55 */         long changeTime = PetInterface.getPetYaoliChangeTime(petYaoliBean.getRoleid(), petYaoliBean.getPetid());
/* 56 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(petYaoliBean.getPetid(), petYaoliBean.getRoleid(), yaolinum, changeTime);
/* 57 */         rank(petYaoLiChart);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void deletRealTimeRank(long petID) {
/* 63 */     PetYaoliRank petYaoliRank = xtable.Petyaolirank.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 64 */     if (null != petYaoliRank) {
/* 65 */       for (PetYaoliBean petYaoliBean : petYaoliRank.getRolerankdatas()) {
/* 66 */         if (petYaoliBean.getPetid() == petID) {
/* 67 */           petYaoliRank.getRolerankdatas().remove(petYaoliBean);
/* 68 */           delete(new PetYaoLiChart(petID, petYaoliBean.getRoleid(), 0, 0L));
/* 69 */           break;
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 77 */     PetBag petBag = PetInterface.getPetBag(roleid, false);
/* 78 */     if (petBag == null) {
/* 79 */       return;
/*    */     }
/* 81 */     for (Pet xPet : petBag.getAllPets().values()) {
/* 82 */       if (xPet != null) {
/* 83 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xPet.getId(), roleid, xPet.getYaoli(), xPet.getChangeyaolitime());
/* 84 */         rank(petYaoLiChart);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid)
/*    */   {
/* 91 */     PetBag petBag = PetInterface.getPetBag(roleid, false);
/* 92 */     if (petBag == null) {
/* 93 */       return;
/*    */     }
/* 95 */     for (Pet xPet : petBag.getAllPets().values()) {
/* 96 */       if (xPet != null) {
/* 97 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xPet.getId(), roleid, xPet.getYaoli(), xPet.getChangeyaolitime());
/* 98 */         delete(petYaoLiChart);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetYaoLiChartRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */