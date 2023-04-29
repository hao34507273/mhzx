/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.event.LeaveTeamArg;
/*     */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*     */ import mzm.gsp.teamplatform.SChangeTryMatchAgain;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.TeamMember;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnLeaveTeam
/*     */   extends LeaveTeamProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (((LeaveTeamArg)this.arg).leaderChange)
/*     */     {
/*  29 */       MatchNRTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  35 */           return POnTeamLeaderChanged.onLeaderChange(((LeaveTeamArg)POnLeaveTeam.this.arg).getOldLeaderId(), ((LeaveTeamArg)POnLeaveTeam.this.arg).teamid);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*  40 */     MatchNRTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  46 */         return POnLeaveTeam.this.onLeaveTeam();
/*     */       }
/*     */       
/*  49 */     });
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   private boolean onLeaveTeam()
/*     */   {
/*  55 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(((LeaveTeamArg)this.arg).teamid));
/*  56 */     if (xTeam != null)
/*     */     {
/*  58 */       long leaderId = ((TeamMember)xTeam.getMembers().get(0)).getRoleid();
/*  59 */       checkAndCutRoleProperty((LeaveTeamArg)this.arg, leaderId);
/*     */       
/*  61 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid), Long.valueOf(leaderId) }));
/*  62 */       xTeam = xtable.Team.get(Long.valueOf(((LeaveTeamArg)this.arg).teamid));
/*  63 */       if (!reCheckLock(xTeam, leaderId))
/*     */       {
/*  65 */         return false;
/*     */       }
/*  67 */       boolean isLeaderInQueue = TeamMatchMananger.isRoleInMatchQueue(leaderId);
/*     */       
/*  69 */       if ((xTeam.getIsfromplatform()) && (!isLeaderInQueue))
/*     */       {
/*  71 */         OnlineManager.getInstance().send(leaderId, new SChangeTryMatchAgain());
/*  72 */         xTeam.setIsfromplatform(false);
/*     */       }
/*  74 */       if (isLeaderInQueue)
/*     */       {
/*  76 */         TeamMatchMananger.synTeamInfo(leaderId, ((LeaveTeamArg)this.arg).teamid, false);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  81 */       checkAndCutRoleProperty((LeaveTeamArg)this.arg, -1L);
/*     */       
/*  83 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid) }));
/*  84 */       MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(((LeaveTeamArg)this.arg).roleid, true);
/*  85 */       if (matchData != null)
/*     */       {
/*  87 */         if (!TeamMatchMananger.cancelMatch(((LeaveTeamArg)this.arg).roleid, CancelMatchType.LEAVE_TEAM_CANCEL))
/*     */         {
/*  89 */           TeamMatchMananger.logger.error(String.format("[teamMatch]POnLeaveTeam.processImp@队长离队，匹配没有取消|leaderId=%d", new Object[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid) }));
/*     */           
/*  91 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean reCheckLock(xbean.Team xTeam, long leaderId)
/*     */   {
/* 107 */     if (xTeam == null)
/*     */     {
/* 109 */       return false;
/*     */     }
/* 111 */     if (((TeamMember)xTeam.getMembers().get(0)).getRoleid() != leaderId)
/*     */     {
/* 113 */       return false;
/*     */     }
/* 115 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkAndRmBuff(long roleId)
/*     */   {
/* 125 */     boolean isOwnMatchBuff = false;
/* 126 */     if (BuffInterface.isContainBuff(roleId, TeamMatchMananger.getMemberBuffId()))
/*     */     {
/* 128 */       BuffInterface.uninstallBuf(roleId, TeamMatchMananger.getMemberBuffId());
/* 129 */       isOwnMatchBuff = true;
/*     */     }
/* 131 */     if (BuffInterface.isContainBuff(roleId, TeamMatchMananger.getLeaderBuffId()))
/*     */     {
/* 133 */       BuffInterface.uninstallBuf(roleId, TeamMatchMananger.getLeaderBuffId());
/* 134 */       isOwnMatchBuff = true;
/*     */     }
/* 136 */     return isOwnMatchBuff;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAndCutRoleProperty(final LeaveTeamArg arg, final long leaderId)
/*     */   {
/* 147 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 153 */         Set<Long> lockRoles = new HashSet();
/* 154 */         lockRoles.add(Long.valueOf(arg.roleid));
/* 155 */         if (leaderId > 0L)
/*     */         {
/* 157 */           lockRoles.add(Long.valueOf(leaderId));
/*     */         }
/* 159 */         lock(Basic.getTable(), lockRoles);
/* 160 */         boolean isOwnMatchBuff = POnLeaveTeam.this.checkAndRmBuff(arg.roleid);
/* 161 */         if (!isOwnMatchBuff)
/*     */         {
/* 163 */           return true;
/*     */         }
/* 165 */         long roleId = arg.roleid;
/* 166 */         switch (POnLeaveTeam.4.$SwitchMap$mzm$gsp$team$event$LeaveTeamArg$LeaveTeamReason[arg.reason.ordinal()])
/*     */         {
/*     */         case 1: 
/* 169 */           TeamMatchMananger.cutRoleProperty(roleId, false);
/* 170 */           break;
/*     */         case 2: 
/* 172 */           if (leaderId < 0L)
/*     */           {
/* 174 */             return false;
/*     */           }
/* 176 */           if (arg.status == 0)
/*     */           {
/* 178 */             TeamMatchMananger.cutRoleProperty(leaderId, true);
/*     */           }
/*     */           
/*     */           break;
/*     */         }
/*     */         
/*     */         
/* 185 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */