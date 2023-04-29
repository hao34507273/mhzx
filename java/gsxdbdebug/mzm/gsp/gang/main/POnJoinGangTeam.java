/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.JoinGangTeamArg;
/*    */ import mzm.gsp.gang.event.JoinGangTeamProcedure;
/*    */ 
/*    */ public class POnJoinGangTeam
/*    */   extends JoinGangTeamProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     return new PCheckInstallGangTeamBuff(((JoinGangTeamArg)this.arg).newMemberid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnJoinGangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */