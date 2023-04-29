/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.STeamMemberInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class PCheckTeamInfo extends LogicProcedure
/*    */ {
/*    */   private final long inviter;
/*    */   private final long invitee;
/*    */   
/*    */   public PCheckTeamInfo(long inviter, long invitee)
/*    */   {
/* 18 */     this.inviter = inviter;
/* 19 */     this.invitee = invitee;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (TeamInterface.isRoleInTeam(this.invitee, false))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     Long teamid = Role2team.select(Long.valueOf(this.inviter));
/* 34 */     if (teamid == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 40 */     if (xTeam == null)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     Set<Long> lockRoles = new HashSet();
/* 47 */     java.util.List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/* 48 */     lockRoles.addAll(members);
/* 49 */     lockRoles.add(Long.valueOf(this.inviter));
/* 50 */     lock(Basic.getTable(), lockRoles);
/*    */     
/* 52 */     xTeam = xtable.Team.get(teamid);
/*    */     
/* 54 */     STeamMemberInfo steamMemberInfo = new STeamMemberInfo();
/* 55 */     TeamManager.fillTeamMemberInfo(steamMemberInfo, members);
/* 56 */     OnlineManager.getInstance().send(this.invitee, steamMemberInfo);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PCheckTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */