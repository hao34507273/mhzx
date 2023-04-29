/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import xbean.CrossbattleDrawLots;
/*     */ import xbean.CrossbattlePoint;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xbean.DrawLotsZoneInfo;
/*     */ import xbean.PointRaceInfo;
/*     */ import xtable.Crossbattledrawlots;
/*     */ import xtable.Crossbattlepoint;
/*     */ 
/*     */ public class CrossBattlePointMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  21 */     List<xdb.Table> tables = new java.util.ArrayList();
/*  22 */     tables.add(Crossbattledrawlots.getTable());
/*  23 */     tables.add(Crossbattlepoint.getTable());
/*  24 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  30 */     for (Iterator i$ = mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  32 */       if (!new PMerge(activityCfgid).call())
/*     */       {
/*  34 */         return false;
/*     */       }
/*     */     }
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   private static class PMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public PMerge(int activityCfgid)
/*     */     {
/*  46 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  52 */       long mainZoneid = MergeMain.getMainZoneid();
/*  53 */       long viceZoneid = MergeMain.getViceZoneid();
/*  54 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  55 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*     */       
/*  57 */       lock(xdb.Lockeys.get(Crossbattledrawlots.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*     */ 
/*  60 */       CrossbattleDrawLots xMainCrossbattleDrawLots = Crossbattledrawlots.get(Long.valueOf(mainKey));
/*  61 */       CrossbattleDrawLots xViceCrossbattleDrawLots = Crossbattledrawlots.get(Long.valueOf(viceKey));
/*  62 */       if (xViceCrossbattleDrawLots != null)
/*     */       {
/*  64 */         if (xMainCrossbattleDrawLots == null)
/*     */         {
/*  66 */           Crossbattledrawlots.insert(Long.valueOf(mainKey), xViceCrossbattleDrawLots.copy());
/*     */         }
/*     */         else
/*     */         {
/*  70 */           for (Map.Entry<Long, DrawLotsZoneInfo> xEntry : xViceCrossbattleDrawLots.getCorps().entrySet())
/*     */           {
/*  72 */             xMainCrossbattleDrawLots.getCorps().put(xEntry.getKey(), ((DrawLotsZoneInfo)xEntry.getValue()).copy());
/*     */           }
/*  74 */           if (!xViceCrossbattleDrawLots.getReported())
/*     */           {
/*  76 */             xMainCrossbattleDrawLots.setReported(false);
/*     */           }
/*     */         }
/*     */       }
/*  80 */       Crossbattledrawlots.remove(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  83 */       CrossbattlePoint xMainCrossbattlePoint = Crossbattlepoint.get(Long.valueOf(mainKey));
/*  84 */       CrossbattlePoint xViceCrossbattlePoint = Crossbattlepoint.get(Long.valueOf(viceKey));
/*  85 */       if (xViceCrossbattlePoint != null)
/*     */       {
/*  87 */         if (xMainCrossbattlePoint == null)
/*     */         {
/*  89 */           Crossbattlepoint.insert(Long.valueOf(mainKey), xViceCrossbattlePoint.copy());
/*     */         }
/*     */         else
/*     */         {
/*  93 */           for (Map.Entry<Long, Integer> xEntry : xViceCrossbattlePoint.getCorps_result().entrySet())
/*     */           {
/*  95 */             xMainCrossbattlePoint.getCorps_result().put(xEntry.getKey(), xEntry.getValue());
/*     */           }
/*     */           
/*  98 */           for (Map.Entry<Integer, CrossbattlePointRaceInfo> xEntry : xViceCrossbattlePoint.getPoint_races().entrySet())
/*     */           {
/* 100 */             CrossbattlePointRaceInfo xViceCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xEntry.getValue();
/* 101 */             Integer key = (Integer)xEntry.getKey();
/* 102 */             CrossbattlePointRaceInfo xMainCrossbattlePointRaceInfo = (CrossbattlePointRaceInfo)xMainCrossbattlePoint.getPoint_races().get(key);
/*     */             
/* 104 */             if (xMainCrossbattlePointRaceInfo == null)
/*     */             {
/* 106 */               xMainCrossbattlePoint.getPoint_races().put(key, xViceCrossbattlePointRaceInfo.copy());
/*     */             }
/*     */             else
/*     */             {
/* 110 */               for (Map.Entry<Long, PointRaceInfo> xPointRaceEntry : xViceCrossbattlePointRaceInfo.getCorps().entrySet())
/*     */               {
/* 112 */                 PointRaceInfo xVicePointRaceInfo = (PointRaceInfo)xPointRaceEntry.getValue();
/* 113 */                 xMainCrossbattlePointRaceInfo.getCorps().put(xPointRaceEntry.getKey(), xVicePointRaceInfo.copy());
/*     */               }
/*     */               
/*     */ 
/* 117 */               for (Map.Entry<Long, Boolean> xNextMailedEntry : xViceCrossbattlePointRaceInfo.getNext_mailed().entrySet())
/*     */               {
/* 119 */                 xMainCrossbattlePointRaceInfo.getNext_mailed().put(xNextMailedEntry.getKey(), xNextMailedEntry.getValue());
/*     */               }
/*     */               
/*     */ 
/* 123 */               xMainCrossbattlePointRaceInfo.getBackup_zones().addAll(xViceCrossbattlePointRaceInfo.getBackup_zones());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 129 */       Crossbattlepoint.remove(Long.valueOf(viceKey));
/*     */       
/* 131 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\CrossBattlePointMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */