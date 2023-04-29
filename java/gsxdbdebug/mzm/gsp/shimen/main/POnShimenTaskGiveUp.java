/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.DayPerfectRingCout;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2dayperfectringcount;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnShimenTaskGiveUp
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (((TaskEventArg)this.arg).taskState != 9)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     if (!ShimenManager.isShimenActivity(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     TaskInterface.ranOneCanAcceptTask(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId);
/* 29 */     DayPerfectRingCout dayPerfectRingCout = Role2dayperfectringcount.get(Long.valueOf(((TaskEventArg)this.arg).roleId));
/* 30 */     if (dayPerfectRingCout == null)
/*    */     {
/* 32 */       dayPerfectRingCout = Pod.newDayPerfectRingCout();
/* 33 */       dayPerfectRingCout.setHasgiveup(true);
/* 34 */       dayPerfectRingCout.setCurrentring(1);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 39 */       dayPerfectRingCout.setHasgiveup(true);
/* 40 */       dayPerfectRingCout.setCurrentring(dayPerfectRingCout.getCurrentring() + 1);
/*    */     }
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\POnShimenTaskGiveUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */