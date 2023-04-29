/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamLeaderChanged
/*    */   extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     CorpsManager.afterTeamChange(((TeamLeaderChangedArg)this.arg).oldLeader);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */