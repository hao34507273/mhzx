/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.activity.SActivityEndTimeRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PCActivityEndTime extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int activityid;
/*    */   
/*    */   public PCActivityEndTime(long roleid, int activityid)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long endTime = ActivityInterface.getActivityEndTime(this.activityid);
/* 20 */     if (endTime < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()) {
/* 21 */       endTime = -1L;
/*    */     } else {
/* 23 */       endTime /= 1000L;
/*    */     }
/* 25 */     SActivityEndTimeRes activityEndTimeRes = new SActivityEndTimeRes();
/* 26 */     activityEndTimeRes.endtime = ((int)endTime);
/* 27 */     activityEndTimeRes.activityid = this.activityid;
/* 28 */     OnlineManager.getInstance().send(this.roleid, activityEndTimeRes);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PCActivityEndTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */