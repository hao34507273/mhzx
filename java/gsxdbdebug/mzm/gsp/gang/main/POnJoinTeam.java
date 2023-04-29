/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.event.JoinTeamProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ 
/*    */ 
/*    */ public class POnJoinTeam
/*    */   extends JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     long roleid = ((JoinTeamArg)this.arg).member.roleid;
/* 15 */     if (((JoinTeamArg)this.arg).member.status == 0) {
/* 16 */       new PCheckInstallGangTeamBuff(roleid).call();
/*    */     }
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */