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
/*    */ class ActionManager
/*    */ {
/* 16 */   private static Map<Integer, Map<Integer, Action>> durationCfgs = new HashMap();
/*    */   ArrayList<Action> records;
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     ActionManager manager = (ActionManager)ConfManager.getInstance().getconf("mzm.gsp.fight.duration.ActionManager");
/* 22 */     if (manager == null) {
/* 23 */       throw new RuntimeException("模型动作的持续时间配置没有！");
/*    */     }
/*    */     
/* 26 */     for (Action durationCfg : manager.records) {
/* 27 */       Map<Integer, Action> action2Cfg = (Map)durationCfgs.get(Integer.valueOf(durationCfg.modelid));
/* 28 */       if (action2Cfg == null) {
/* 29 */         action2Cfg = new HashMap();
/* 30 */         durationCfgs.put(Integer.valueOf(durationCfg.modelid), action2Cfg);
/*    */       }
/* 32 */       action2Cfg.put(Integer.valueOf(durationCfg.actionid), durationCfg);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getActionDuration(int modelid, int actionid)
/*    */   {
/* 43 */     Map<Integer, Action> action2Cfg = (Map)durationCfgs.get(Integer.valueOf(modelid));
/* 44 */     if (action2Cfg == null) {
/* 45 */       return -1;
/*    */     }
/* 47 */     Action durationCfg = (Action)action2Cfg.get(Integer.valueOf(actionid));
/* 48 */     if (durationCfg == null) {
/* 49 */       return -1;
/*    */     }
/* 51 */     return durationCfg.duration;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\duration\ActionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */