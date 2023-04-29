/*    */ package mzm.gsp.fight.duration;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GeneralEffectManager
/*    */ {
/* 16 */   private static Map<Integer, Integer> effectid2Duration = new HashMap();
/*    */   ArrayList<GeneralEffect> records;
/*    */   
/*    */   public static void init()
/*    */   {
/* 21 */     GeneralEffectManager manager = (GeneralEffectManager)ConfManager.getInstance().getconf("mzm.gsp.fight.duration.GeneralEffectManager");
/* 22 */     if (manager == null) {
/* 23 */       throw new RuntimeException("通用特效的持续时间配置没有！");
/*    */     }
/*    */     
/* 26 */     for (GeneralEffect durationCfg : manager.records) {
/* 27 */       effectid2Duration.put(Integer.valueOf(durationCfg.effectid), Integer.valueOf(durationCfg.duration));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getGeneralEffectDuration(int effectid)
/*    */   {
/* 37 */     Integer duration = (Integer)effectid2Duration.get(Integer.valueOf(effectid));
/* 38 */     if (duration != null) {
/* 39 */       return duration.intValue();
/*    */     }
/* 41 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\duration\GeneralEffectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */