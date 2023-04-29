/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.team.confbean.TeamConsts;
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
/*    */ public class PClearMembersProtectState
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamId;
/*    */   private final long oldLeaderId;
/*    */   
/*    */   public PClearMembersProtectState(long teamId, long oldLeaderId)
/*    */   {
/* 28 */     this.teamId = teamId;
/* 29 */     this.oldLeaderId = oldLeaderId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     TeamInfo teaminfo = TeamInterface.getTeamInfo(this.teamId, false);
/* 37 */     if (teaminfo == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     Set<Long> lockRoles = getLockRoles(teaminfo);
/* 43 */     if (lockRoles.size() == 0)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     lock(Basic.getTable(), lockRoles);
/* 49 */     teaminfo = TeamInterface.getTeamInfo(this.teamId, true);
/* 50 */     if (teaminfo == null)
/*    */     {
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     boolean isContiansProtectRole = false;
/* 56 */     for (Iterator i$ = lockRoles.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*    */       
/* 58 */       if (BuffInterface.isContainBuff(member, TeamConsts.getInstance().ROLE_MATCH_TEAM_BUF))
/*    */       {
/*    */ 
/*    */ 
/* 62 */         if (teaminfo.getMemberStatus(member) == 0)
/*    */         {
/* 64 */           isContiansProtectRole = true;
/*    */         }
/* 66 */         BuffInterface.uninstallBuf(member, TeamConsts.getInstance().ROLE_MATCH_TEAM_BUF);
/*    */       } }
/* 68 */     if (isContiansProtectRole)
/*    */     {
/* 70 */       TeamMatchMananger.cutRoleProperty(this.oldLeaderId, true);
/*    */     }
/* 72 */     return true;
/*    */   }
/*    */   
/*    */   private Set<Long> getLockRoles(TeamInfo teaminfo)
/*    */   {
/* 77 */     Set<Long> lockRoles = new HashSet();
/* 78 */     List<Long> members = teaminfo.getTeamMemberList();
/* 79 */     lockRoles.addAll(members);
/* 80 */     if (!lockRoles.contains(Long.valueOf(this.oldLeaderId)))
/*    */     {
/* 82 */       lockRoles.add(Long.valueOf(this.oldLeaderId));
/*    */     }
/* 84 */     return lockRoles;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PClearMembersProtectState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */