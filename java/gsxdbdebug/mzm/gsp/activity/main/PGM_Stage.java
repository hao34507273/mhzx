/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGM_Stage extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int activityid;
/*    */   private long roleid;
/*    */   
/*    */   public PGM_Stage(int activityid, long roleid)
/*    */   {
/* 13 */     this.activityid = activityid;
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int stage = ActivityInterface.getActivityStage(this.activityid);
/* 20 */     SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 21 */     gmMessageTipRes.result = 4;
/* 22 */     gmMessageTipRes.args.add(stage + "");
/* 23 */     OnlineManager.getInstance().send(this.roleid, gmMessageTipRes);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PGM_Stage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */