/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class ROnOpenChange extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 13 */     if (type != 174)
/*    */     {
/*    */ 
/* 16 */       return;
/*    */     }
/*    */     
/* 19 */     int activityCfgid = SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID;
/* 20 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 21 */     long startTime = ActivityInterface.getActivityStartTime(activityCfgid);
/* 22 */     long endTime = ActivityInterface.getActivityEndTime(activityCfgid);
/* 23 */     if ((startTime > now) || (now > endTime))
/*    */     {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 29 */     if (isOpen)
/*    */     {
/* 31 */       LuckyBagManager.initActivity(activityCfgid, Reason.FUN_OPEN);
/*    */     }
/*    */     else
/*    */     {
/* 35 */       LuckyBagManager.stopActivity(activityCfgid, Reason.FUN_CLOSE);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */