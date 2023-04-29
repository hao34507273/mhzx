/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.JoinGangProcedure;
/*    */ 
/*    */ public class POnJoinGang
/*    */   extends JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((GangArg)this.arg).roleId, 900, Integer.valueOf(1), "GangJoin.updateGoalState@handle GANG_JOIN success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */