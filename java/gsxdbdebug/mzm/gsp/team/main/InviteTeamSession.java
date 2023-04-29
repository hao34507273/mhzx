/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.confbean.TeamConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class InviteTeamSession
/*    */   extends Session
/*    */ {
/*    */   private final long invitee;
/*    */   private final long teamid;
/*    */   
/*    */   InviteTeamSession(long inviter, long invitee)
/*    */   {
/* 25 */     this(inviter, invitee, -1L);
/*    */   }
/*    */   
/*    */   InviteTeamSession(long inviter, long invitee, long teamid)
/*    */   {
/* 30 */     super(TeamConsts.getInstance().INVITE_SECONDS, inviter);
/* 31 */     this.invitee = invitee;
/* 32 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */   long getInviter()
/*    */   {
/* 37 */     return getOwerId();
/*    */   }
/*    */   
/*    */   long getInvitee()
/*    */   {
/* 42 */     return this.invitee;
/*    */   }
/*    */   
/*    */   long getTeamid()
/*    */   {
/* 47 */     return this.teamid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 53 */     NoneRealTimeTaskManager.getInstance().addTask(new RemoveInvitee());
/*    */   }
/*    */   
/*    */   class RemoveInvitee
/*    */     extends LogicProcedure
/*    */   {
/*    */     RemoveInvitee() {}
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 64 */       xbean.Team xTeam = xtable.Team.select(Long.valueOf(InviteTeamSession.this.teamid));
/* 65 */       if (xTeam == null)
/*    */       {
/* 67 */         return false;
/*    */       }
/* 69 */       List<Long> lockRoles = new ArrayList();
/* 70 */       lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/* 71 */       lockRoles.add(Long.valueOf(InviteTeamSession.this.invitee));
/*    */       
/*    */ 
/* 74 */       lock(Basic.getTable(), lockRoles);
/* 75 */       xTeam = xtable.Team.get(Long.valueOf(InviteTeamSession.this.teamid));
/*    */       
/*    */ 
/* 78 */       if (!TeamManager.isInTeam(InviteTeamSession.this.getOwerId(), xTeam))
/*    */       {
/* 80 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 84 */       TeamMember xMember = TeamManager.getXMember(xTeam, InviteTeamSession.this.getOwerId());
/* 85 */       TeamManager.removeInvitee(InviteTeamSession.this.invitee, xMember);
/*    */       
/* 87 */       TeamLogManager.logReplyInvite(InviteTeamSession.this.invitee, InviteTeamSession.this.getInviter(), 3);
/*    */       
/* 89 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\InviteTeamSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */