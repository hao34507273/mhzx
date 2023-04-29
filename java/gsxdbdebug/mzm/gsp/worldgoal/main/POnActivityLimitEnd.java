/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeEndArg;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeEndProcedure;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ public class POnActivityLimitEnd
/*    */   extends ActivityLimitTimeEndProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     int activityCfgid = ((ActivityLimitTimeEndArg)this.arg).activityid;
/* 16 */     if (!SWorldGoalCfg.getAll().containsKey(Integer.valueOf(activityCfgid)))
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     if (!WorldGoalManager.isWorldGoalSwitchOpen(activityCfgid))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     WorldGoalManager.stopActivity(activityCfgid, ReasonEnum.ACTIVITY_END);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\POnActivityLimitEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */