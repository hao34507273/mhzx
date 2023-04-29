/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractJoinEventTimes.Context;
/*    */ import mzm.gsp.instance.event.JoinSingleInstanceArg;
/*    */ import mzm.gsp.instance.event.JoinSingleInstanceEventProcedure;
/*    */ 
/*    */ public class POnJoinSingleInstance
/*    */   extends JoinSingleInstanceEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AbstractJoinEventTimes.Context context = new AbstractJoinEventTimes.Context(((JoinSingleInstanceArg)this.arg).endTime, ((JoinSingleInstanceArg)this.arg).instanceid);
/* 14 */     AchievementManager.updateGoalTypeState(((JoinSingleInstanceArg)this.arg).roleid, 5002, context, "POnJoinSingleInstance.processImp@handle PARTICIPATE_SINGLE_INSTANCE success");
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJoinSingleInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */