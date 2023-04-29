/*    */ package mzm.gsp.feisheng.qingyunzhi;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengQingYunZhiActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingYunZhiActivityManager
/*    */ {
/*    */   public static void init()
/*    */   {
/* 16 */     ActivityInterface.registerActivityByLogicType(85, new FeiShengQingYunZhiActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFeiShengQingYunZhiActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*    */   {
/* 28 */     SFeiShengQingYunZhiActivityCfg cfg = SFeiShengQingYunZhiActivityCfg.get(activityCfgid);
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\qingyunzhi\QingYunZhiActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */