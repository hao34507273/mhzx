/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MallRefreshTime;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Malltype2refreshtime;
/*     */ 
/*     */ public class MallMerger implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  20 */     List<Table> tables = new ArrayList();
/*  21 */     tables.add(Malltype2refreshtime.getTable());
/*  22 */     tables.add(xtable.Role2jifen.getTable());
/*  23 */     tables.add(xtable.Role2itembuycount.getTable());
/*  24 */     tables.add(xtable.Role2limitshops.getTable());
/*  25 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  31 */     new Merge_Malltype2refreshtime_Pro(null).call();
/*  32 */     return new Merge_CurrentLimitMalltype2refreshtime_Pro(null).call();
/*     */   }
/*     */   
/*     */   private static class Merge_Malltype2refreshtime_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  41 */       long mainZoneId = MergeMain.getMainZoneid();
/*  42 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  44 */       long mainKey = GameServerInfoManager.toGlobalId(2L, mainZoneId);
/*  45 */       long viceKey = GameServerInfoManager.toGlobalId(2L, viceZoneId);
/*     */       
/*  47 */       lock(Malltype2refreshtime.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*  48 */       MallRefreshTime xMain = Malltype2refreshtime.get(Long.valueOf(mainKey));
/*  49 */       MallRefreshTime xVice = Malltype2refreshtime.get(Long.valueOf(viceKey));
/*     */       
/*  51 */       if (xVice == null)
/*     */       {
/*  53 */         return true;
/*     */       }
/*  55 */       if (xMain == null)
/*     */       {
/*  57 */         xMain = Pod.newMallRefreshTime();
/*  58 */         xMain.setRefreshtime(xVice.getRefreshtime());
/*  59 */         Malltype2refreshtime.insert(Long.valueOf(mainKey), xMain);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  64 */       else if (xMain.getRefreshtime() < xVice.getRefreshtime())
/*     */       {
/*  66 */         xMain.setRefreshtime(xVice.getRefreshtime());
/*     */       }
/*     */       
/*     */ 
/*  70 */       Malltype2refreshtime.remove(Long.valueOf(viceKey));
/*  71 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class Merge_CurrentLimitMalltype2refreshtime_Pro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  89 */       for (Map.Entry<Integer, CurrentLimitShopRelation> entry : MallManager.CURRENT_LIMIT_SHOP.entrySet())
/*     */       {
/*  91 */         int shopType = ((Integer)entry.getKey()).intValue();
/*     */         
/*  93 */         long mainZoneId = MergeMain.getMainZoneid();
/*  94 */         long viceZoneId = MergeMain.getViceZoneid();
/*     */         
/*  96 */         long mainKey = GameServerInfoManager.toGlobalId(shopType, mainZoneId);
/*  97 */         long viceKey = GameServerInfoManager.toGlobalId(shopType, viceZoneId);
/*     */         
/*  99 */         lock(Malltype2refreshtime.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 100 */         MallRefreshTime xMain = Malltype2refreshtime.get(Long.valueOf(mainKey));
/* 101 */         MallRefreshTime xVice = Malltype2refreshtime.get(Long.valueOf(viceKey));
/*     */         
/* 103 */         if (xVice != null)
/*     */         {
/*     */ 
/*     */ 
/* 107 */           if (xMain == null)
/*     */           {
/* 109 */             xMain = Pod.newMallRefreshTime();
/* 110 */             xMain.setRefreshtime(xVice.getRefreshtime());
/* 111 */             Malltype2refreshtime.insert(Long.valueOf(mainKey), xMain);
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/* 116 */           else if (xMain.getRefreshtime() < xVice.getRefreshtime())
/*     */           {
/* 118 */             xMain.setRefreshtime(xVice.getRefreshtime());
/*     */           }
/*     */           
/*     */ 
/* 122 */           Malltype2refreshtime.remove(Long.valueOf(viceKey));
/*     */         } }
/* 124 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\MallMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */