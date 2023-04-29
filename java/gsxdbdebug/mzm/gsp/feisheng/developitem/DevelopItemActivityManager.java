/*    */ package mzm.gsp.feisheng.developitem;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DevelopItemActivityManager
/*    */ {
/*    */   public static void init()
/*    */   {
/* 16 */     ActivityInterface.registerActivityByLogicType(83, new FeiShengDevelopItemActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFeiShengDevelopItemActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*    */   {
/* 28 */     SFeiShengDevelopItemActivityCfg cfg = SFeiShengDevelopItemActivityCfg.get(activityCfgid);
/* 29 */     if (cfg == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 39 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\developitem\DevelopItemActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */