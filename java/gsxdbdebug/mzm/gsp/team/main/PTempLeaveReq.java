/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PTempLeaveReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PTempLeaveReq(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     Long teamid = Role2team.select(Long.valueOf(this.roleid));
/*  32 */     if (teamid == null)
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     xbean.Team xTeam = xtable.Team.select(teamid);
/*  37 */     if (xTeam == null)
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     Set<Long> lockRoles = new HashSet();
/*  43 */     lockRoles.addAll(TeamManager.getMemberListByXTeam(xTeam));
/*     */     
/*     */ 
/*  46 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*  48 */     xTeam = xtable.Team.get(teamid);
/*     */     
/*     */ 
/*  51 */     checkLock(xTeam, lockRoles);
/*     */     
/*     */ 
/*  54 */     if (!canActiveTemLeaveTeamInStatus(this.roleid))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     return TeamManager.tempLeaveTeam(this.roleid, teamid.longValue(), xTeam);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkLock(xbean.Team xTeam, Set<Long> lockRoles)
/*     */   {
/*  71 */     if (xTeam == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     List<Long> members = TeamManager.getMemberListByXTeam(xTeam);
/*  76 */     if ((members.size() != lockRoles.size()) || (!members.containsAll(lockRoles)))
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     return true;
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
/*     */   private boolean canActiveTemLeaveTeamInStatus(long roleId)
/*     */   {
/*  94 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 48, true))
/*     */     {
/*  96 */       GameServer.logger().error(String.format("[team]PTempLeaveReq.canActiveTemLeaveTeamInStatus@ active tmp leave team is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 100 */       return false;
/*     */     }
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PTempLeaveReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */