/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.teamplatform.match.RoleActivityCfg;
/*     */ import mzm.gsp.teamplatform.match.TeamMatchInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.TeamApplicant;
/*     */ import xbean.TeamMember;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PJoinTeamByLeaderId
/*     */   extends LogicProcedure
/*     */ {
/*     */   public static final int JOIN_ERROR__ALREADY_IN_TEAM = 0;
/*     */   public static final int JOIN_ERROR__NO_TEAM = 1;
/*     */   public static final int JOIN_ERROR__NOT_LEADER = 2;
/*     */   public static final int JOIN_ERROR__FULL_BEFOR = 3;
/*     */   public static final int JOIN_ERROR__ALREADY_IN_THIS_TEAM = 4;
/*     */   public static final int JOIN_SUC__FULL = 5;
/*     */   public static final int JOIN_SUC__NEW_ENOUGH = 6;
/*     */   private final long roleId;
/*     */   private final long leaderId;
/*     */   private JoinTeamByMatchHandler handler;
/*  38 */   public int result = -1;
/*  39 */   public int teamMemberNum = 0;
/*     */   
/*     */   public PJoinTeamByLeaderId(long roleId, long leaderId)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.leaderId = leaderId;
/*     */   }
/*     */   
/*     */   public PJoinTeamByLeaderId(long roleId, long leaderId, JoinTeamByMatchHandler handler)
/*     */   {
/*  49 */     this.roleId = roleId;
/*  50 */     this.leaderId = leaderId;
/*  51 */     this.handler = handler;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  58 */     Long teamid = Role2team.select(Long.valueOf(this.leaderId));
/*  59 */     if (teamid == null)
/*     */     {
/*  61 */       this.result = 1;
/*  62 */       return false;
/*     */     }
/*  64 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*  65 */     if (xTeam == null)
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     Set<Long> lockRoles = new HashSet();
/*  71 */     List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/*  72 */     lockRoles.addAll(members);
/*     */     
/*  74 */     if (lockRoles.contains(Long.valueOf(this.roleId)))
/*     */     {
/*  76 */       this.result = 4;
/*  77 */       return false;
/*     */     }
/*  79 */     lockRoles.add(Long.valueOf(this.roleId));
/*     */     
/*     */ 
/*  82 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*  84 */     xTeam = xtable.Team.get(teamid);
/*     */     
/*  86 */     if (xTeam == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (!OnlineManager.getInstance().isOnline(this.roleId))
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     List<Long> members_now = TeamManager.getMemberListByXTeam(xTeam);
/*     */     
/*  98 */     if ((members_now.size() != members.size()) || (!members_now.containsAll(members)))
/*     */     {
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     Long teamId_temp = Role2team.select(Long.valueOf(this.roleId));
/* 105 */     if (teamId_temp != null)
/*     */     {
/* 107 */       this.result = 0;
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     long teamLeaderId = ((TeamMember)xTeam.getMembers().get(0)).getRoleid();
/* 113 */     if (teamLeaderId != this.leaderId)
/*     */     {
/* 115 */       this.result = 2;
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     if (xTeam.getMembers().size() >= TeamInterface.getTeamCapacity())
/*     */     {
/* 122 */       this.result = 3;
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     List<RoleActivityCfg> activitys = TeamMatchInterface.getRoleMatchActivtys(teamLeaderId);
/* 127 */     if ((activitys == null) || (activitys.size() != 1))
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     if (this.handler != null)
/*     */     {
/* 135 */       if (!this.handler.canJoinTeam(this.roleId, new TeamInfo(teamid.longValue(), xTeam)))
/*     */       {
/* 137 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 142 */     if (!TeamManager.onRoleJoinTeam(teamid.longValue(), xTeam, this.roleId, JoinTeamType.JOIN_TEAM__PLATFORM))
/*     */     {
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 148 */     rmFromTeamApplyList(teamid, xTeam);
/*     */     
/* 150 */     this.teamMemberNum = xTeam.getMembers().size();
/* 151 */     if (this.teamMemberNum == TeamConsts.getInstance().TEAM_CAPACITY)
/*     */     {
/* 153 */       this.result = 5;
/*     */     }
/*     */     
/* 156 */     xTeam.setIsfromplatform(true);
/*     */     
/* 158 */     return true;
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
/*     */   void rmFromTeamApplyList(Long teamid, xbean.Team xTeam)
/*     */   {
/* 171 */     boolean find = false;
/* 172 */     Iterator<TeamApplicant> it = xTeam.getApplicants().iterator();
/* 173 */     while (it.hasNext())
/*     */     {
/* 175 */       TeamApplicant teamApplicant = (TeamApplicant)it.next();
/* 176 */       if (teamApplicant.getRoleid() == this.roleId)
/*     */       {
/* 178 */         it.remove();
/* 179 */         find = true;
/* 180 */         break;
/*     */       }
/*     */     }
/*     */     
/* 184 */     if (find)
/*     */     {
/*     */ 
/* 187 */       NoneRealTimeTaskManager.getInstance().addTask(new PSyncApplicantsToAll(teamid.longValue()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PJoinTeamByLeaderId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */