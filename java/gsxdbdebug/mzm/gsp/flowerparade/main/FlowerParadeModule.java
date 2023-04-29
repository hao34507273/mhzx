/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FlowerParadeHistory;
/*     */ import xdb.Table;
/*     */ import xtable.Flowerparadehistory;
/*     */ import xtable.Role2flowerparaderecord;
/*     */ 
/*     */ public class FlowerParadeModule implements Module, PostModuleInitListner, MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  21 */     List<Table> tables = new ArrayList();
/*  22 */     tables.add(Role2flowerparaderecord.getTable());
/*  23 */     tables.add(Flowerparadehistory.getTable());
/*  24 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  30 */     new PFlowerParadeMerge().call();
/*  31 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class PFlowerParadeMerge
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  46 */       long mainZoneId = MergeMain.getMainZoneid();
/*  47 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  49 */       lock(Flowerparadehistory.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*  50 */       FlowerParadeHistory xMainHistory = Flowerparadehistory.get(Long.valueOf(mainZoneId));
/*  51 */       FlowerParadeHistory xViceHistory = Flowerparadehistory.get(Long.valueOf(viceZoneId));
/*     */       
/*  53 */       if (xViceHistory == null)
/*     */       {
/*  55 */         return true;
/*     */       }
/*     */       
/*  58 */       if (xMainHistory == null)
/*     */       {
/*  60 */         xMainHistory = xbean.Pod.newFlowerParadeHistory();
/*  61 */         Flowerparadehistory.add(Long.valueOf(mainZoneId), xMainHistory);
/*     */       }
/*     */       
/*  64 */       xMainHistory.getHistoryroles().addAll(xViceHistory.getHistoryroles());
/*     */       
/*     */ 
/*     */ 
/*  68 */       List<Integer> ocpList = new ArrayList();
/*  69 */       List<Integer> xMainOcpList = xMainHistory.getHistoryocpids();
/*  70 */       List<Integer> xViceOcpList = xViceHistory.getHistoryocpids();
/*  71 */       int mainOcpSize = xMainOcpList.size();
/*  72 */       int viceOcpSize = xViceOcpList.size();
/*  73 */       int size = mainOcpSize > viceOcpSize ? mainOcpSize : viceOcpSize;
/*  74 */       for (int i = 0; i < size; i++)
/*     */       {
/*  76 */         if (i < mainOcpSize)
/*     */         {
/*  78 */           ocpList.add(xMainOcpList.get(i));
/*     */         }
/*     */         
/*  81 */         if (i < viceOcpSize)
/*     */         {
/*  83 */           ocpList.add(xViceOcpList.get(i));
/*     */         }
/*     */       }
/*  86 */       xMainHistory.getHistoryocpids().clear();
/*  87 */       xMainHistory.getHistoryocpids().addAll(ocpList);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  92 */       List<Integer> mapList = new ArrayList();
/*  93 */       List<Integer> xMainList = xMainHistory.getHistorymapids();
/*  94 */       List<Integer> xViceList = xViceHistory.getHistorymapids();
/*  95 */       int mainSize = xMainList.size();
/*  96 */       int viceSize = xViceList.size();
/*  97 */       int size = mainSize > viceSize ? mainSize : viceSize;
/*  98 */       for (int i = 0; i < size; i++)
/*     */       {
/* 100 */         if (i < mainSize)
/*     */         {
/* 102 */           mapList.add(xMainList.get(i));
/*     */         }
/*     */         
/* 105 */         if (i < viceSize)
/*     */         {
/* 107 */           mapList.add(xViceList.get(i));
/*     */         }
/*     */       }
/* 110 */       xMainHistory.getHistorymapids().clear();
/* 111 */       xMainHistory.getHistorymapids().addAll(mapList);
/*     */       
/*     */ 
/* 114 */       Flowerparadehistory.remove(Long.valueOf(viceZoneId));
/* 115 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/* 123 */     FlowerParadeConfig.init(envs);
/* 124 */     FlowerParadeManager.init();
/*     */     
/* 126 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/* 132 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/* 138 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 144 */     return 0;
/*     */   }
/*     */   
/*     */   public void postInit() {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */