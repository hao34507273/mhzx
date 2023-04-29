/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.awardpool.confbean.SAwardTypeId2PreciousItemSubId;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*     */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.IdCounter;
/*     */ import xtable.Itemsubid2count;
/*     */ 
/*     */ 
/*     */ public class AwardPoolModule
/*     */   implements Module, PostModuleInitListner
/*     */ {
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  24 */     initFromXdb();
/*  25 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  31 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/*  37 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/*  43 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void postInit()
/*     */   {
/*  49 */     AwardPoolManager.init();
/*  50 */     DateObserver.MyDate dayDate = new DateObserver.MyDate(-1, -1, -1, 0);
/*  51 */     new DayObserver(dayDate);
/*     */     
/*  53 */     DateObserver.MyDate weekDate = new DateObserver.MyDate(2, 0);
/*  54 */     new WeekObserver(weekDate);
/*     */     
/*     */ 
/*  57 */     DateObserver.MyDate monthDate = new DateObserver.MyDate(-1, -1, 1, 0, 0, 0);
/*  58 */     new MonthObserver(monthDate);
/*     */   }
/*     */   
/*     */ 
/*     */   static void initFromXdb()
/*     */   {
/*  64 */     for (SAwardTypeId2PreciousItemSubId cfg : SAwardTypeId2PreciousItemSubId.getAll().values())
/*     */     {
/*  66 */       for (i$ = cfg.itemSubIds.iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*     */         
/*  68 */         new InitItemSubidObjectFromXdb(itemSubId).execute();
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator i$;
/*  73 */     for (SRandomTextTableCfg randomTextTableCfg : SRandomTextTableCfg.getAll().values())
/*     */     {
/*     */ 
/*  76 */       SPreciousDropCfg preciousDropCfg = SPreciousDropCfg.get(randomTextTableCfg.preciousCfgId);
/*  77 */       if (preciousDropCfg != null)
/*     */       {
/*  79 */         new InitItemSubidObjectFromXdb(randomTextTableCfg.id).execute();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class InitItemSubidObjectFromXdb
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int itemSubId;
/*     */     
/*     */ 
/*     */     public InitItemSubidObjectFromXdb(int itemSubId)
/*     */     {
/*  93 */       this.itemSubId = itemSubId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 100 */       long key = GameServerInfoManager.toGlobalId(this.itemSubId);
/*     */       
/* 102 */       IdCounter xCounter = Itemsubid2count.get(Long.valueOf(key));
/* 103 */       if (xCounter == null)
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */       
/* 108 */       int preciousCfgId = AwardPoolManager.getPreciousCfgId(this.itemSubId);
/*     */       
/* 110 */       SPreciousDropCfg peCfg = SPreciousDropCfg.get(preciousCfgId);
/* 111 */       if (peCfg == null)
/*     */       {
/* 113 */         return false;
/*     */       }
/* 115 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 116 */       if (peCfg.serverClearTypeEnum2 == 1)
/*     */       {
/*     */ 
/* 119 */         if ((xCounter.getHistorydropcount() >= peCfg.serverMaxDropCount1) && (!DateTimeUtils.isInSameDay(now, xCounter.getModifytime())))
/*     */         {
/*     */ 
/*     */ 
/* 123 */           xCounter.setDropcount(0);
/* 124 */           xCounter.setModifytime(now);
/* 125 */           xCounter.setUnhitcount(0);
/*     */         }
/*     */         
/*     */       }
/* 129 */       else if (peCfg.serverClearTypeEnum2 == 2)
/*     */       {
/* 131 */         if ((xCounter.getHistorydropcount() >= peCfg.serverMaxDropCount1) && (!DateTimeUtils.isInSameWeek(now, xCounter.getModifytime())))
/*     */         {
/*     */ 
/* 134 */           xCounter.setDropcount(0);
/* 135 */           xCounter.setModifytime(now);
/* 136 */           xCounter.setUnhitcount(0);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 141 */       else if (peCfg.serverClearTypeEnum2 == 3)
/*     */       {
/* 143 */         if ((xCounter.getHistorydropcount() >= peCfg.serverMaxDropCount1) && (!DateTimeUtils.isInSameMonth(now, xCounter.getModifytime())))
/*     */         {
/*     */ 
/* 146 */           xCounter.setDropcount(0);
/* 147 */           xCounter.setModifytime(now);
/* 148 */           xCounter.setUnhitcount(0);
/*     */         }
/*     */       }
/* 151 */       ItemSubIdDropcCounter.getInstance().initItemSubidObject(this.itemSubId, xCounter.getUnhitcount(), xCounter.getDropcount(), xCounter.getHistorydropcount());
/*     */       
/*     */ 
/* 154 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\AwardPoolModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */