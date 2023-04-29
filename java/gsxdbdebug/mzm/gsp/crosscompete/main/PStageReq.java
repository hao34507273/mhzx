/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.SStageBrd;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStageReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PStageReq(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/* 26 */     SStageBrd brd = new SStageBrd();
/* 27 */     brd.stage = stage;
/*    */     
/* 29 */     OnlineManager.getInstance().send(this.roleid, brd);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PStageReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */