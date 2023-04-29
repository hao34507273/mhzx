/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_ResetLuckyBag extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_ResetLuckyBag(long gmRoleid, int num)
/*    */   {
/* 15 */     this.gmRoleid = gmRoleid;
/* 16 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (this.num < -1)
/*    */     {
/* 24 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, " 参数错误");
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     int activityCfgid = SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID;
/* 29 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 30 */     long startTime = ActivityInterface.getActivityStartTime(activityCfgid);
/* 31 */     long endTime = ActivityInterface.getActivityEndTime(activityCfgid);
/* 32 */     if ((startTime > now) || (now > endTime))
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "活动未开启");
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!LuckyBagManager.gmReset(this.num))
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "系统错误");
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PGM_ResetLuckyBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */