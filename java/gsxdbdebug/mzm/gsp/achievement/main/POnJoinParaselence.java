/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.paraselene.event.JoinParaseleneArg;
/*    */ import mzm.gsp.paraselene.event.JoinParaseleneProcedure;
/*    */ 
/*    */ public class POnJoinParaselence extends JoinParaseleneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AchievementManager.collectLocks(((JoinParaseleneArg)this.arg).roleList);
/*    */     
/* 14 */     int activityId = SParaseleneCfgConsts.getInstance().ActivityId;
/* 15 */     for (Iterator i$ = ((JoinParaseleneArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 18 */       AchievementManager.updateGoalTypeState(roleId, 2401, Integer.valueOf(activityId), "POnJoinParaselence.processImp@handle ACTIVITY_JOIN_ONLY success");
/*    */     }
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJoinParaselence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */