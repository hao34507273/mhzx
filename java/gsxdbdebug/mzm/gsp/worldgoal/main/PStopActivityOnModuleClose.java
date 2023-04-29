/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStopActivityOnModuleClose
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PStopActivityOnModuleClose(int activityCfgid)
/*    */   {
/* 15 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     WorldGoalManager.stopActivity(this.activityCfgid, ReasonEnum.MODULE_CLOSE);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PStopActivityOnModuleClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */