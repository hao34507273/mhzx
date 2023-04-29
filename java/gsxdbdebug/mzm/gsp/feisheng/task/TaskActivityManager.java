/*    */ package mzm.gsp.feisheng.task;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengTaskActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskActivityManager
/*    */ {
/*    */   public static void init()
/*    */   {
/* 16 */     ActivityInterface.registerActivityByLogicType(84, new FeiShengTaskActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFeiShengTaskActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*    */   {
/* 27 */     SFeiShengTaskActivityCfg cfg = SFeiShengTaskActivityCfg.get(activityCfgid);
/* 28 */     if (cfg == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 38 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 39 */       return false;
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\task\TaskActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */