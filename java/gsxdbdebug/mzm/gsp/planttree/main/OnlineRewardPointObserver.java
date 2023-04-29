/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnlineRewardPointObserver
/*    */   extends Observer
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public OnlineRewardPointObserver(long intervalSeconds, long roleid, int activityCfgid)
/*    */   {
/* 18 */     super(intervalSeconds);
/* 19 */     this.roleid = roleid;
/* 20 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 26 */     PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new POnlineRewardPoint(this.roleid, this.activityCfgid));
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\OnlineRewardPointObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */