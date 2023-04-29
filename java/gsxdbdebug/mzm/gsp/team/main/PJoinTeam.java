/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TeamApplicant;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PJoinTeam
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long teamId;
/*     */   
/*     */   public PJoinTeam(long roleId, long teamId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.teamId = teamId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     Long teamId_temp = Role2team.select(Long.valueOf(this.roleId));
/*  36 */     if (teamId_temp != null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(this.teamId));
/*  43 */     if (xTeam == null)
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (xTeam.getMembers().size() >= TeamInterface.getTeamCapacity())
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     Set<Long> lockRoles = new HashSet();
/*  55 */     lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*     */     
/*  57 */     if (lockRoles.contains(Long.valueOf(this.roleId)))
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     lockRoles.add(Long.valueOf(this.roleId));
/*     */     
/*     */ 
/*  64 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*  66 */     xTeam = xtable.Team.get(Long.valueOf(this.teamId));
/*     */     
/*  68 */     if (!OnlineManager.getInstance().isOnline(this.roleId))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     List<Long> membersNow = TeamManager.getMemberListByXTeam(xTeam);
/*  73 */     if ((lockRoles.size() != membersNow.size() + 1) || (!lockRoles.containsAll(membersNow)))
/*     */     {
/*  75 */       GameServer.logger().info(String.format("[team]PJoinTeam.processImp@team members changed, return!|roleId=%d|teamId=%d|lockRoles=%s|membersNow=%s|", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.teamId), lockRoles.toString(), membersNow.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     if (TeamInterface.isRoleInTeam(this.roleId, true))
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     if (!TeamManager.onRoleJoinTeam(this.teamId, xTeam, this.roleId, JoinTeamType.JOIN_TEAM__PLATFORM))
/*     */     {
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     boolean find = false;
/*  96 */     Iterator<TeamApplicant> it = xTeam.getApplicants().iterator();
/*  97 */     while (it.hasNext())
/*     */     {
/*  99 */       TeamApplicant teamApplicant = (TeamApplicant)it.next();
/* 100 */       if (teamApplicant.getRoleid() == this.roleId)
/*     */       {
/* 102 */         it.remove();
/* 103 */         find = true;
/* 104 */         break;
/*     */       }
/*     */     }
/*     */     
/* 108 */     if (find)
/*     */     {
/*     */ 
/* 111 */       NoneRealTimeTaskManager.getInstance().addTask(new PSyncApplicantsToAll(this.teamId));
/*     */     }
/* 113 */     xTeam.setIsfromplatform(true);
/*     */     
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */