/*    */ package mzm.gsp.fight.durationCfg;
/*    */ 
/*    */ import mzm.gsp.skill.confbean.EffectPlayData;
/*    */ 
/*    */ class ModelEffectCfgManager
/*    */ {
/*    */   static int getModelEffectDuration(int modelid, int effectid)
/*    */   {
/*  9 */     EffectPlayData effectPlayCfg = getEffectPlayCfg(modelid, effectid);
/* 10 */     if (effectPlayCfg == null) {
/* 11 */       return -1;
/*    */     }
/* 13 */     return effectPlayCfg.lastTime;
/*    */   }
/*    */   
/*    */   static EffectPlayData getEffectPlayCfg(int modelid, int effectid) {
/* 17 */     EffectPlayData effectPlayCfg = _getEffectPlayCfg(modelid, effectid);
/* 18 */     if (effectPlayCfg == null)
/*    */     {
/* 20 */       effectPlayCfg = _getEffectPlayCfg(0, effectid);
/*    */     }
/* 22 */     return effectPlayCfg;
/*    */   }
/*    */   
/*    */   private static EffectPlayData _getEffectPlayCfg(int modelid, int effectid) {
/* 26 */     mzm.gsp.skill.confbean.SEffectPlayMapCfg effectPlayMapCfg = mzm.gsp.skill.confbean.SEffectPlayMapCfg.get(modelid);
/* 27 */     if (effectPlayMapCfg != null) {
/* 28 */       return (EffectPlayData)effectPlayMapCfg.effectMap.get(Integer.valueOf(effectid));
/*    */     }
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\durationCfg\ModelEffectCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */