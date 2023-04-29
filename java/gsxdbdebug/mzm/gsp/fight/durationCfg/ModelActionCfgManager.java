/*    */ package mzm.gsp.fight.durationCfg;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.skill.confbean.ActionData;
/*    */ import mzm.gsp.skill.confbean.SActionMap;
/*    */ 
/*    */ class ModelActionCfgManager
/*    */ {
/*    */   static int getActionDuration(int modelid, int actionid)
/*    */   {
/* 12 */     ActionData actionData = getAction(modelid, actionid);
/* 13 */     if (actionData == null) {
/* 14 */       return -1;
/*    */     }
/* 16 */     return actionData.duration;
/*    */   }
/*    */   
/*    */   static java.util.List<Integer> getEffectLateTime(int modelid, int actionid)
/*    */   {
/* 21 */     ActionData sAction = getAction(modelid, actionid);
/* 22 */     if (sAction == null)
/* 23 */       return new ArrayList();
/* 24 */     return sAction.effectlateTimes;
/*    */   }
/*    */   
/*    */   static ActionData getAction(int modelid, int actionid) {
/* 28 */     ActionData sAction = _getAction(modelid, actionid);
/* 29 */     if (sAction == null) {
/* 30 */       sAction = _getAction(0, actionid);
/*    */     }
/* 32 */     return sAction;
/*    */   }
/*    */   
/*    */   private static ActionData _getAction(int modelid, int actionid) {
/* 36 */     SActionMap actionMap = SActionMap.get(modelid);
/* 37 */     if (actionMap != null) {
/* 38 */       return (ActionData)actionMap.actionid2Action.get(Integer.valueOf(actionid));
/*    */     }
/* 40 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\durationCfg\ModelActionCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */