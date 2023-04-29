/*    */ package mzm.gsp.task.enterFight;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends mzm.gsp.team.event.TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long oldLeaderId = ((TeamLeaderChangedArg)this.arg).oldLeader;
/*    */     
/* 11 */     xbean.TaskConfBean xTaskConfBean = xtable.Role2taskconf.get(Long.valueOf(oldLeaderId));
/* 12 */     if (xTaskConfBean == null)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     JoinFightManager.cancelInvite(oldLeaderId, xTaskConfBean);
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */