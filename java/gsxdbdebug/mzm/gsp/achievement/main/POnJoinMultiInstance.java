/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractJoinEventTimes.Context;
/*    */ import mzm.gsp.instance.event.JoinMultiInstanceArg;
/*    */ import mzm.gsp.instance.event.JoinMultiInstanceEventProcedure;
/*    */ 
/*    */ public class POnJoinMultiInstance extends JoinMultiInstanceEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     AchievementManager.collectLocks(((JoinMultiInstanceArg)this.arg).joinRoles);
/*    */     
/*    */ 
/* 16 */     AbstractJoinEventTimes.Context context = new AbstractJoinEventTimes.Context(((JoinMultiInstanceArg)this.arg).endTime, ((JoinMultiInstanceArg)this.arg).instanceid);
/* 17 */     for (Iterator i$ = ((JoinMultiInstanceArg)this.arg).joinRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 19 */       AchievementManager.updateGoalTypeState(roleId, 5003, context, "POnJoinMultiInstance.processImp@handle PARTICIPATE_MULTI_INSTANCE success");
/*    */     }
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJoinMultiInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */