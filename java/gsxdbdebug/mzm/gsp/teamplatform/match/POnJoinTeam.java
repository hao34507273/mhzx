/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.team.event.JoinTeamArg;
/*     */ import mzm.gsp.team.event.JoinTeamProcedure;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.MatchKey;
/*     */ import xbean.MatchQueue;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnJoinTeam
/*     */   extends JoinTeamProcedure
/*     */ {
/*  25 */   private static final Logger logger = Logger.getLogger(POnJoinTeam.class);
/*     */   
/*  27 */   public POnJoinTeam() { this.joinByMatch = false;
/*     */     
/*  29 */     this.isMatching = false;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(((JoinTeamArg)this.arg).teamid, false);
/*  36 */     long memberId = ((JoinTeamArg)this.arg).getNewGuyRoleId();
/*  37 */     Set<Long> lockRoles = new HashSet();
/*  38 */     lockRoles.add(Long.valueOf(leaderId));
/*  39 */     lockRoles.add(Long.valueOf(((JoinTeamArg)this.arg).getNewGuyRoleId()));
/*     */     
/*  41 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*  43 */     lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(((JoinTeamArg)this.arg).teamid) }));
/*     */     
/*  45 */     MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(true);
/*  46 */     if (matchQueue == null)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int teamMemberNum = TeamInterface.getTeamMemberCount(((JoinTeamArg)this.arg).teamid, false);
/*     */     
/*  53 */     if (!checkNewGuyMatch(leaderId, memberId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!checkLeaderMatch(leaderId, memberId, this.isMatching, teamMemberNum))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     Procedure.execute(new CheckNewEnough(memberId));
/*  64 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkNewGuyMatch(long leaderId, long memberId)
/*     */   {
/*  76 */     if (!tryCancelMatch(leaderId, memberId))
/*     */     {
/*  78 */       TeamMatchMananger.logger.error(String.format("[teamMatch]POnJoinTeam.checkNewGuyMatch@tryCancelMatch failed!|roleId=%d", new Object[] { Long.valueOf(memberId) }));
/*     */       
/*  80 */       return false;
/*     */     }
/*  82 */     if (!((JoinTeamArg)this.arg).isComeFromPlatform())
/*     */     {
/*  84 */       return true;
/*     */     }
/*  86 */     this.joinByMatch = true;
/*  87 */     if (((JoinTeamArg)this.arg).getNewGuyStatus() == 0)
/*     */     {
/*  89 */       addRoleBuff(memberId, TeamMatchMananger.getMemberBuffId());
/*     */     }
/*  91 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean joinByMatch;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean tryCancelMatch(long leaderId, long memberId)
/*     */   {
/* 105 */     if (!TeamMatchMananger.isRoleInMatchQueue(memberId))
/*     */     {
/* 107 */       return true;
/*     */     }
/* 109 */     if (!beforeMemberCancelMatch(memberId, leaderId))
/*     */     {
/* 111 */       return false;
/*     */     }
/* 113 */     this.isMatching = true;
/* 114 */     if (!RoleQueueManager.cancelMatch(memberId, !((JoinTeamArg)this.arg).isComeFromPlatform(), CancelMatchType.JOIN_TEAM_SUC_CANCEL))
/*     */     {
/* 116 */       return false;
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkLeaderMatch(long leaderId, long memberId, boolean isMatchIng, int teamMemberNum)
/*     */   {
/* 132 */     MatchActivityCfg roleMatchInfo = TeamMatchMananger.getRoleActivity(leaderId, false);
/* 133 */     if (roleMatchInfo == null)
/*     */     {
/* 135 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 141 */     TeamMatchMananger.synTeamInfo(leaderId, ((JoinTeamArg)this.arg).teamid, false);
/*     */     
/* 143 */     TeamMatchMananger.synLeaderMatchInfo(leaderId, Arrays.asList(new Long[] { Long.valueOf(memberId) }), 1);
/*     */     
/* 145 */     checkRmTeam(leaderId);
/*     */     
/* 147 */     logGetMatch(leaderId, isMatchIng, teamMemberNum, roleMatchInfo);
/* 148 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void logGetMatch(long leaderId, boolean isMatchIng, int teamMemberNum, MatchActivityCfg roleMatchInfo)
/*     */   {
/* 161 */     if (!isMatchIng)
/*     */     {
/* 163 */       return;
/*     */     }
/* 165 */     int matchId = roleMatchInfo.getActivity().getActivityid();
/* 166 */     int index = roleMatchInfo.getActivity().getIndex();
/* 167 */     TeamMatchLogManager.logGetMatch(((JoinTeamArg)this.arg).getNewGuyRoleId(), matchId, index, leaderId, 2, teamMemberNum);
/*     */     
/* 169 */     TeamMatchLogManager.logGetMatch(leaderId, matchId, index, ((JoinTeamArg)this.arg).getNewGuyRoleId(), 1, teamMemberNum);
/*     */   }
/*     */   
/*     */ 
/*     */   public static enum AddBuffResEnum
/*     */   {
/* 175 */     SUCCESS,  FALSE,  MEMBER_NOT_FROM_MATCH,  LEADER_CONTAINS_BUFF;
/*     */     
/*     */ 
/*     */ 
/*     */     private AddBuffResEnum() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   AddBuffResEnum addLeaderBuff(long leaderId)
/*     */   {
/* 186 */     if (!this.joinByMatch)
/*     */     {
/* 188 */       return AddBuffResEnum.MEMBER_NOT_FROM_MATCH;
/*     */     }
/* 190 */     int buffId = TeamMatchMananger.getLeaderBuffId();
/* 191 */     if (BuffInterface.isContainBuff(leaderId, buffId))
/*     */     {
/* 193 */       return AddBuffResEnum.LEADER_CONTAINS_BUFF;
/*     */     }
/* 195 */     BuffInterface.installBuff(leaderId, buffId);
/* 196 */     return AddBuffResEnum.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean beforeMemberCancelMatch(long roleId, long leaderId)
/*     */   {
/* 208 */     TeamMatchInterface.sendRoleMatchSucPro(roleId, leaderId);
/* 209 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkRmTeam(long leaderId)
/*     */   {
/* 219 */     int num = TeamInterface.getTeamMemberCount(((JoinTeamArg)this.arg).teamid, false);
/* 220 */     if (num >= TeamInterface.getTeamCapacity())
/*     */     {
/* 222 */       if (!TeamQueueManager.cancelMatch(leaderId, CancelMatchType.TEAM_FULL_SUC_CANCEL))
/*     */       {
/* 224 */         TeamMatchMananger.logger.error(String.format("[teamMatch]POnJoinTeam.checkRmTeam@team full, leader tryCancelMatch failed!|leaderId=%d", new Object[] { Long.valueOf(leaderId) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isMatching;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean addRoleBuff(long roleId, int buffId)
/*     */   {
/* 243 */     if (BuffInterface.isContainBuff(roleId, buffId))
/*     */     {
/* 245 */       logger.error("POnJoinTeam.addRoleBuff desc= 玩家身上已有该buffId@ roleId=" + roleId + ", buffId=" + buffId);
/* 246 */       return false;
/*     */     }
/* 248 */     BuffInterface.installBuff(roleId, buffId);
/* 249 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */