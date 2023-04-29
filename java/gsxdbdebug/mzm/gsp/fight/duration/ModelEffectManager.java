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
/*    */ class ModelEffectManager
/*    */ {
/* 16 */   private static Map<Integer, Map<Integer, ModelEffect>> durationCfgs = new HashMap();
/*    */   ArrayList<ModelEffect> records;
/*    */   
/*    */   public static void init()
/*    */   {
/* 21 */     ModelEffectManager manager = (ModelEffectManager)ConfManager.getInstance().getconf("mzm.gsp.fight.duration.ModelEffectManager");
/* 22 */     if (manager == null) {
/* 23 */       throw new RuntimeException("模型特效的持续时间配置没有！");
/*    */     }
/*    */     
/* 26 */     for (ModelEffect durationCfg : manager.records) {
/* 27 */       Map<Integer, ModelEffect> effect2Cfg = (Map)durationCfgs.get(Integer.valueOf(durationCfg.modelid));
/* 28 */       if (effect2Cfg == null) {
/* 29 */         effect2Cfg = new HashMap();
/* 30 */         durationCfgs.put(Integer.valueOf(durationCfg.modelid), effect2Cfg);
/*    */       }
/* 32 */       effect2Cfg.put(Integer.valueOf(durationCfg.effectid), durationCfg);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getModelEffectDuration(int modelid, int effectid)
/*    */   {
/* 43 */     Map<Integer, ModelEffect> effect2Cfg = (Map)durationCfgs.get(Integer.valueOf(modelid));
/* 44 */     if (effect2Cfg == null) {
/* 45 */       return 0;
/*    */     }
/* 47 */     ModelEffect durationCfg = (ModelEffect)effect2Cfg.get(Integer.valueOf(effectid));
/* 48 */     if (durationCfg == null) {
/* 49 */       return 0;
/*    */     }
/* 51 */     return durationCfg.duration;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\duration\ModelEffectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */