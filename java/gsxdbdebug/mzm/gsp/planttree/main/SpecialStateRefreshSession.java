/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpecialStateRefreshSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public SpecialStateRefreshSession(long interval, long roleid, int activityCfgid)
/*    */   {
/* 17 */     super(interval, roleid);
/* 18 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PRefreshSpecialState(getOwerId(), this.activityCfgid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\SpecialStateRefreshSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */