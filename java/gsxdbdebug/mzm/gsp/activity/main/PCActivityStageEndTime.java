/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.activity.SActivityStageEndTimeRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PCActivityStageEndTime extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int activityid;
/*    */   private int stage;
/*    */   
/*    */   public PCActivityStageEndTime(long roleid, int activityid, int stage)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.activityid = activityid;
/* 16 */     this.stage = stage;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long endTime = ActivityInterface.getActivityStageEndTime(this.activityid, this.stage);
/* 22 */     SActivityStageEndTimeRes activityStageEndTimeRes = new SActivityStageEndTimeRes();
/* 23 */     activityStageEndTimeRes.activityid = this.activityid;
/* 24 */     activityStageEndTimeRes.stage = this.stage;
/* 25 */     activityStageEndTimeRes.endtime = ((int)(endTime / 1000L));
/* 26 */     OnlineManager.getInstance().send(this.roleid, activityStageEndTimeRes);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PCActivityStageEndTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */