/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.chart.main.NoneRoleKeyRankManagerNew;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.NoneRealTimePetYaoliBean;
/*     */ import xbean.NoneRealTimePetYaoliRank;
/*     */ import xbean.PetYaoliBean;
/*     */ import xbean.PetYaoliRank;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Nonerealtimepetyaolirank;
/*     */ import xtable.Petyaolirank;
/*     */ 
/*     */ 
/*     */ public class PetYaoliRankMerge
/*     */   implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  26 */     List<Table> tables = new ArrayList();
/*  27 */     tables.add(Petyaolirank.getTable());
/*  28 */     tables.add(Nonerealtimepetyaolirank.getTable());
/*  29 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  35 */     boolean ret = new Merger_Petyaolirank_Pro(null).call();
/*  36 */     if (!ret)
/*     */     {
/*  38 */       MergeMain.formatLogError("PetYaoliRankMerge.handleMerge@Petyaolirank table delete server data fail！", new Object[0]);
/*  39 */       return false;
/*     */     }
/*  41 */     ret = new Merger_Nonerealtimepetyaolirank_Pro(null).call();
/*  42 */     if (!ret)
/*     */     {
/*  44 */       MergeMain.formatLogError("PetYaoliRankMerge.handleMerge@Nonerealtimepetyaolirank table delete server data fail！", new Object[0]);
/*  45 */       return false;
/*     */     }
/*  47 */     return ret;
/*     */   }
/*     */   
/*     */   private static class Merger_Petyaolirank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  55 */       long mainKey = MergeMain.getMainZoneid();
/*  56 */       long viceKey = MergeMain.getViceZoneid();
/*  57 */       PetYaoliRankMerge.PetYaoliRankManagerForMerge petYaoliRankManagerForMerge = new PetYaoliRankMerge.PetYaoliRankManagerForMerge(1);
/*     */       
/*  59 */       lock(Petyaolirank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  60 */       PetYaoliRank xMainPetYaoliRank = Petyaolirank.get(Long.valueOf(mainKey));
/*  61 */       PetYaoliRank xVicePetYaoliRank = Petyaolirank.get(Long.valueOf(viceKey));
/*  62 */       if (xMainPetYaoliRank == null)
/*     */       {
/*  64 */         xMainPetYaoliRank = Pod.newPetYaoliRank();
/*  65 */         Petyaolirank.insert(Long.valueOf(mainKey), xMainPetYaoliRank);
/*     */       }
/*     */       
/*  68 */       for (PetYaoliBean xPetYaoliBean : xMainPetYaoliRank.getRolerankdatas()) {
/*  69 */         int yaolinum = PetInterface.getPetYaoli(xPetYaoliBean.getRoleid(), xPetYaoliBean.getPetid());
/*  70 */         long changeTime = PetInterface.getPetYaoliChangeTime(xPetYaoliBean.getRoleid(), xPetYaoliBean.getPetid());
/*  71 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xPetYaoliBean.getPetid(), xPetYaoliBean.getRoleid(), yaolinum, changeTime);
/*  72 */         petYaoliRankManagerForMerge.rank(petYaoLiChart);
/*     */       }
/*     */       
/*  75 */       if (xVicePetYaoliRank != null)
/*     */       {
/*     */ 
/*  78 */         for (PetYaoliBean xPetYaoliBean : xVicePetYaoliRank.getRolerankdatas()) {
/*  79 */           int yaolinum = PetInterface.getPetYaoli(xPetYaoliBean.getRoleid(), xPetYaoliBean.getPetid());
/*  80 */           long changeTime = PetInterface.getPetYaoliChangeTime(xPetYaoliBean.getRoleid(), xPetYaoliBean.getPetid());
/*  81 */           PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xPetYaoliBean.getPetid(), xPetYaoliBean.getRoleid(), yaolinum, changeTime);
/*  82 */           petYaoliRankManagerForMerge.rank(petYaoLiChart);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  87 */       xMainPetYaoliRank.getRolerankdatas().clear();
/*     */       
/*  89 */       for (PetYaoLiChart petYaoLiChart : petYaoliRankManagerForMerge.getAllChartObjs()) {
/*  90 */         PetYaoliBean xPetYaoliBean = Pod.newPetYaoliBean();
/*  91 */         xPetYaoliBean.setPetid(petYaoLiChart.getKey().longValue());
/*  92 */         xPetYaoliBean.setRoleid(petYaoLiChart.getRoleId());
/*  93 */         xMainPetYaoliRank.getRolerankdatas().add(xPetYaoliBean);
/*     */       }
/*     */       
/*  96 */       Petyaolirank.remove(Long.valueOf(viceKey));
/*     */       
/*  98 */       petYaoliRankManagerForMerge.clear();
/*  99 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Merger_Nonerealtimepetyaolirank_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 108 */       long mainKey = MergeMain.getMainZoneid();
/* 109 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 111 */       PetYaoliRankMerge.PetYaoliRankManagerForMerge petYaoliRankManagerForMerge = new PetYaoliRankMerge.PetYaoliRankManagerForMerge(1);
/*     */       
/* 113 */       lock(Nonerealtimepetyaolirank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 114 */       NoneRealTimePetYaoliRank xMainNoneRealTimePetYaoliRank = Nonerealtimepetyaolirank.get(Long.valueOf(mainKey));
/* 115 */       NoneRealTimePetYaoliRank xViceNoneRealTimePetYaoliRank = Nonerealtimepetyaolirank.get(Long.valueOf(viceKey));
/* 116 */       if (xMainNoneRealTimePetYaoliRank == null)
/*     */       {
/* 118 */         xMainNoneRealTimePetYaoliRank = Pod.newNoneRealTimePetYaoliRank();
/* 119 */         Nonerealtimepetyaolirank.insert(Long.valueOf(mainKey), xMainNoneRealTimePetYaoliRank);
/*     */       }
/*     */       
/*     */ 
/* 123 */       for (NoneRealTimePetYaoliBean xNoneRealTimePetYaoliBean : xMainNoneRealTimePetYaoliRank.getRankdatas()) {
/* 124 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xNoneRealTimePetYaoliBean.getPetid(), xNoneRealTimePetYaoliBean.getRoleid(), xNoneRealTimePetYaoliBean.getPetyaoli(), xNoneRealTimePetYaoliBean.getChangeyaolitime());
/* 125 */         petYaoliRankManagerForMerge.rank(petYaoLiChart);
/*     */       }
/*     */       
/* 128 */       xMainNoneRealTimePetYaoliRank.getKeytorankchange().clear();
/* 129 */       xMainNoneRealTimePetYaoliRank.getRankdatas().clear();
/*     */       
/* 131 */       if (xViceNoneRealTimePetYaoliRank != null)
/*     */       {
/*     */ 
/* 134 */         for (NoneRealTimePetYaoliBean xNoneRealTimePetYaoliBean : xViceNoneRealTimePetYaoliRank.getRankdatas()) {
/* 135 */           PetYaoLiChart petYaoLiChart = new PetYaoLiChart(xNoneRealTimePetYaoliBean.getPetid(), xNoneRealTimePetYaoliBean.getRoleid(), xNoneRealTimePetYaoliBean.getPetyaoli(), xNoneRealTimePetYaoliBean.getChangeyaolitime());
/* 136 */           petYaoliRankManagerForMerge.rank(petYaoLiChart);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */       for (PetYaoLiChart petYaoLiChart : petYaoliRankManagerForMerge.getAllChartObjs()) {
/* 145 */         NoneRealTimePetYaoliBean xNoneRealTimePetYaoliBean = Pod.newNoneRealTimePetYaoliBean();
/* 146 */         xNoneRealTimePetYaoliBean.setPetid(petYaoLiChart.getKey().longValue());
/* 147 */         xNoneRealTimePetYaoliBean.setRoleid(petYaoLiChart.getRoleId());
/* 148 */         xNoneRealTimePetYaoliBean.setPetyaoli(petYaoLiChart.getYaoLiValue());
/* 149 */         xNoneRealTimePetYaoliBean.setChangeyaolitime(petYaoLiChart.getYaoLiTime());
/* 150 */         xMainNoneRealTimePetYaoliRank.getRankdatas().add(xNoneRealTimePetYaoliBean);
/*     */       }
/*     */       
/* 153 */       Nonerealtimepetyaolirank.remove(Long.valueOf(viceKey));
/*     */       
/* 155 */       petYaoliRankManagerForMerge.clear();
/*     */       
/* 157 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PetYaoliRankManagerForMerge extends NoneRoleKeyRankManagerNew<Long, PetYaoLiChart>
/*     */   {
/*     */     public PetYaoliRankManagerForMerge(int capacity)
/*     */     {
/* 165 */       super();
/*     */     }
/*     */     
/*     */     public void addRankRoleForIDIP(long roleid) {}
/*     */     
/*     */     public void clearRoleRankData(long roleid) {}
/*     */     
/*     */     public void saveToDB() {}
/*     */     
/*     */     public void rankDataFromDB() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetYaoliRankMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */