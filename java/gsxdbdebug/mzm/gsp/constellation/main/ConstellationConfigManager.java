/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.constellation.confbean.SCardStarCfg;
/*    */ import mzm.gsp.constellation.confbean.SConstellationCfg;
/*    */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ class ConstellationConfigManager
/*    */ {
/*    */   static List<Integer> getRandomCardStars()
/*    */   {
/* 20 */     List<Integer> stars = new ArrayList();
/*    */     
/* 22 */     for (int i = 0; i < SConstellationConsts.getInstance().CardCountPerTurn; i++) {
/* 23 */       int p = Xdb.random().nextInt(10000);
/*    */       
/* 25 */       Iterator<SCardStarCfg> iter = SCardStarCfg.getAll().values().iterator();
/* 26 */       while (iter.hasNext()) {
/* 27 */         SCardStarCfg cfg = (SCardStarCfg)iter.next();
/* 28 */         if (p < cfg.sumProb) {
/* 29 */           stars.add(Integer.valueOf(cfg.star));
/* 30 */           break;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 35 */     return stars;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getNextConstellationSeconds(int index)
/*    */   {
/* 46 */     if ((index >= SConstellationCfg.getAll().size()) || (index < 0)) {
/* 47 */       return 0;
/*    */     }
/* 49 */     if (index == SConstellationCfg.getAll().size() - 1) {
/* 50 */       return SConstellationConsts.getInstance().PerTurnLastSeconds;
/*    */     }
/* 52 */     return SConstellationConsts.getInstance().PerTurnLastSeconds + SConstellationConsts.getInstance().CloseSeconds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static List<Integer> getConstellations()
/*    */   {
/* 62 */     return new ArrayList(SConstellationCfg.getAll().keySet());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isConstellationValid(int constellation)
/*    */   {
/* 72 */     return SConstellationCfg.get(constellation) != null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int randomFortune(int constellation)
/*    */   {
/* 81 */     SConstellationCfg cfg = SConstellationCfg.get(constellation);
/* 82 */     if (cfg == null) {
/* 83 */       return -1;
/*    */     }
/* 85 */     if (cfg.fortunes.isEmpty()) {
/* 86 */       return -2;
/*    */     }
/* 88 */     return Xdb.random().nextInt(cfg.fortunes.size());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\ConstellationConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */