/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnJoinTeam
/*    */   extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     CorpsManager.afterTeamChange(((JoinTeamArg)this.arg).leaderid);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */