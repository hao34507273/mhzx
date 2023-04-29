/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetActivityState
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PGM_GetActivityState(long roleid, int activityCfgid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     boolean ret = ActivityInterface.isActivityOpen(this.activityCfgid);
/* 22 */     GmManager.getInstance().sendResultToGM(this.roleid, 40, new Object[] { Integer.valueOf(this.activityCfgid), Boolean.valueOf(ret) });
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PGM_GetActivityState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */