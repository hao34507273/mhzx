/*    */ package mzm.gsp.fight.durationCfg;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.skill.confbean.ActionData;
/*    */ import mzm.gsp.skill.confbean.EffectPlayData;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DurationCfgManager
/*    */ {
/* 13 */   private static Logger logger = Logger.getLogger("fight");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getActionDuration(int modelid, int actionid)
/*    */   {
/* 25 */     int duration = ModelActionCfgManager.getActionDuration(modelid, actionid);
/* 26 */     if (duration >= 0) {
/* 27 */       return duration;
/*    */     }
/* 29 */     logger.error("No action duration: modelid=" + modelid + ", actionid=" + actionid);
/* 30 */     return SFightConsts.getInstance().DEFAULT_ACTION_DURATION;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ActionData getAction(int modelid, int actionid)
/*    */   {
/* 41 */     ActionData action = ModelActionCfgManager.getAction(modelid, actionid);
/* 42 */     if (action == null) {
/* 43 */       logger.error("No action duration: modelid=" + modelid + ", actionid=" + actionid);
/*    */     }
/* 45 */     return action;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getEffectDuration(int modelid, int effectid)
/*    */   {
/* 59 */     int duration = ModelEffectCfgManager.getModelEffectDuration(modelid, effectid);
/* 60 */     if (duration >= 0) {
/* 61 */       return duration;
/*    */     }
/* 63 */     logger.error("No effect duration: modelid=" + modelid + ", effectid=" + effectid);
/* 64 */     return SFightConsts.getInstance().DEFAULT_EFFECT_DURATION;
/*    */   }
/*    */   
/*    */   public static EffectPlayData getEffectPlayCfg(int modelid, int effectid) {
/* 68 */     EffectPlayData effectPlayCfg = ModelEffectCfgManager.getEffectPlayCfg(modelid, effectid);
/* 69 */     if (effectPlayCfg == null) {
/* 70 */       logger.error("No effect duration: modelid=" + modelid + ", effectid=" + effectid);
/*    */     }
/* 72 */     return effectPlayCfg;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Integer> getEffectLateTimes(int modelid, int actionid)
/*    */   {
/* 85 */     return ModelActionCfgManager.getEffectLateTime(modelid, actionid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\durationCfg\DurationCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */