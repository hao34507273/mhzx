/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     MatchNRTimeTaskManager.getInstance().addTask(new PTeamMatchMemberLogin(((Long)this.arg).longValue()));
/*    */     
/* 24 */     if (!TeamMatchMananger.onRoleLogin(((Long)this.arg).longValue()))
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   class PTeamMatchMemberLogin
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public PTeamMatchMemberLogin(long roleId)
/*    */     {
/* 44 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 50 */       TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 51 */       if (teamInfo == null)
/*    */       {
/* 53 */         return false;
/*    */       }
/* 55 */       long teamId = teamInfo.getTeamId();
/* 56 */       List<Long> members = teamInfo.getTeamMemberList();
/*    */       
/* 58 */       lock(Basic.getTable(), members);
/* 59 */       teamInfo = TeamInterface.getTeamInfo(teamId, true);
/* 60 */       if (!checkLock(teamInfo))
/*    */       {
/* 62 */         return false;
/*    */       }
/*    */       
/* 65 */       TeamMatchMananger.checkMembersProtectState(members, this.roleId);
/* 66 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     private boolean checkLock(TeamInfo teamInfo)
/*    */     {
/* 77 */       if (teamInfo == null)
/*    */       {
/* 79 */         return false;
/*    */       }
/* 81 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */