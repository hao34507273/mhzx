/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import mzm.gsp.team.SDispositionChanged;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.TeamApplicant;
/*     */ import xbean.TeamDispositionMember;
/*     */ import xdb.Lockeys;
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
/*     */ public class TeamManagerForInterSerVice
/*     */ {
/*     */   static boolean appointLeader(long teamId, long roleId)
/*     */   {
/*  32 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamId));
/*  33 */     if (xTeam == null)
/*     */     {
/*  35 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@ team not exist!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  38 */       return false;
/*     */     }
/*  40 */     List<Long> memberIds = TeamManager.getMemberListByXTeam(xTeam);
/*  41 */     if (!memberIds.contains(Long.valueOf(roleId)))
/*     */     {
/*  43 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@ role not in team!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     Lockeys.lock(Basic.getTable(), memberIds);
/*     */     
/*  52 */     xTeam = xtable.Team.get(Long.valueOf(teamId));
/*  53 */     if (!reCheckAfterLock_appointLeader(xTeam, memberIds, teamId, roleId))
/*     */     {
/*  55 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@ reCheckAfterLock err!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  58 */       return false;
/*     */     }
/*  60 */     long oldLeaderId = TeamManager.getLearder(xTeam);
/*  61 */     if (oldLeaderId == roleId)
/*     */     {
/*  63 */       GameServer.logger().info(String.format("[team]TeamManagerForInterSerVice.processImp@ already leader!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  66 */       return true;
/*     */     }
/*     */     
/*  69 */     return TeamManager.appointLeader(teamId, xTeam, roleId, oldLeaderId);
/*     */   }
/*     */   
/*     */   private static boolean reCheckAfterLock_appointLeader(xbean.Team xTeam, List<Long> memberIds, long teamId, long roleId)
/*     */   {
/*  74 */     if (xTeam == null)
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ team not exist!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  79 */       return false;
/*     */     }
/*  81 */     List<Long> memberIds_0 = TeamManager.getMemberListByXTeam(xTeam);
/*  82 */     if ((memberIds_0.size() != memberIds.size()) || (!memberIds_0.containsAll(memberIds)))
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ lock err!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*  89 */     if (!memberIds_0.contains(Long.valueOf(roleId)))
/*     */     {
/*  91 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ role not in team!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  94 */       return false;
/*     */     }
/*  96 */     return true;
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
/*     */ 
/*     */ 
/*     */   static boolean designTeam(long teamId, List<Long> templetMembers)
/*     */   {
/* 112 */     if ((templetMembers == null) || (templetMembers.size() == 0) || (templetMembers.size() > TeamConsts.getInstance().TEAM_CAPACITY))
/*     */     {
/*     */ 
/* 115 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@ param illegal!|teamId=%d|templetMembers=%s", new Object[] { Long.valueOf(teamId), templetMembers == null ? "" : templetMembers.toString() }));
/*     */       
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamId));
/* 123 */     if (xTeam == null)
/*     */     {
/* 125 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@team not exist!|teamId=%d|members=%s", new Object[] { Long.valueOf(teamId), templetMembers.toString() }));
/*     */       
/*     */ 
/* 128 */       return false;
/*     */     }
/* 130 */     List<Long> normalMembers = TeamManager.getNormalMemberListByXTeam(xTeam);
/* 131 */     if ((normalMembers.size() != templetMembers.size()) || (!normalMembers.containsAll(templetMembers)))
/*     */     {
/* 133 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@not all templetMembers is normal state, or in this team!|teamId=%d|members=%s|normalMembers=%s", new Object[] { Long.valueOf(teamId), templetMembers.toString(), normalMembers.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     Lockeys.lock(Basic.getTable(), TeamManager.getMemberListByXTeam(xTeam));
/*     */     
/* 143 */     xTeam = xtable.Team.get(Long.valueOf(teamId));
/*     */     
/* 145 */     if (!reCheckAfterLock_designTeam(xTeam, templetMembers, teamId))
/*     */     {
/* 147 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.processImp@reCheckAfterLock err!|teamId=%d|members=%s", new Object[] { Long.valueOf(teamId), templetMembers.toString() }));
/*     */       
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (!checkAndChangeLeader(xTeam, templetMembers, teamId))
/*     */     {
/* 155 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.checkAndChangeLeader@appointLeader err!|teamId=%d|members=%s", new Object[] { Long.valueOf(teamId), templetMembers.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 161 */     adjustTeamDisposition(xTeam, templetMembers);
/* 162 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkAndChangeLeader(xbean.Team xTeam, List<Long> templetMembers, long teamId)
/*     */   {
/* 174 */     long oldLeaderId = TeamManager.getLearder(xTeam);
/* 175 */     long newLeaderId = ((Long)templetMembers.get(0)).longValue();
/* 176 */     if (oldLeaderId == newLeaderId)
/*     */     {
/* 178 */       return true;
/*     */     }
/* 180 */     if (!TeamManager.appointLeader(teamId, xTeam, newLeaderId, oldLeaderId))
/*     */     {
/* 182 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.checkAndChangeLeader@appointLeader err!|teamId=%d|members=%s|newLeaderId=%d|oldLeaderId=%d", new Object[] { Long.valueOf(teamId), templetMembers.toString(), Long.valueOf(newLeaderId), Long.valueOf(oldLeaderId) }));
/*     */       
/*     */ 
/*     */ 
/* 186 */       return false;
/*     */     }
/* 188 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void adjustTeamDisposition(xbean.Team xTeam, List<Long> templetMembers)
/*     */   {
/* 199 */     xTeam.getDisposition().clear();
/*     */     
/* 201 */     for (int index = 0; index < templetMembers.size(); index++)
/*     */     {
/* 203 */       TeamDispositionMember xTDMember = Pod.newTeamDispositionMember();
/* 204 */       xTDMember.setDispositionmemberid(((Long)templetMembers.get(index)).longValue());
/* 205 */       xTDMember.setDispositionmembertype(0);
/* 206 */       xTeam.getDisposition().put(Integer.valueOf(index), xTDMember);
/*     */     }
/*     */     
/* 209 */     Map<Integer, Integer> leaderPartnerMap = PartnerInterface.getFightPartnerListWithoutRole(TeamManager.getLearder(xTeam), false);
/*     */     
/* 211 */     TeamManager.fillDispositionByLeaderPartners(leaderPartnerMap, xTeam);
/*     */     
/* 213 */     SDispositionChanged brd = TeamManager.fillPositionChangePro(xTeam);
/* 214 */     TeamManager.broadcast(xTeam, brd);
/*     */   }
/*     */   
/*     */   private static boolean reCheckAfterLock_designTeam(xbean.Team xTeam, List<Long> templetMembers, long teamId)
/*     */   {
/* 219 */     if (xTeam == null)
/*     */     {
/* 221 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@team not exist!|teamId=%d|members=%s", new Object[] { Long.valueOf(teamId), templetMembers.toString() }));
/*     */       
/*     */ 
/* 224 */       return false;
/*     */     }
/* 226 */     List<Long> normalMembers = TeamManager.getNormalMemberListByXTeam(xTeam);
/* 227 */     if ((normalMembers.size() != templetMembers.size()) || (!normalMembers.containsAll(templetMembers)))
/*     */     {
/* 229 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@not all templetMembers is normal state, or in this team!|teamId=%d|members=%s|normalMembers=%s", new Object[] { Long.valueOf(teamId), templetMembers.toString(), normalMembers.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 233 */       return false;
/*     */     }
/* 235 */     return true;
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
/*     */ 
/*     */ 
/*     */   static boolean joinTeamByTeamId(long teamId, long roleId, JoinTeamType joinTeamType)
/*     */   {
/* 251 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(teamId));
/* 252 */     if (xTeam == null)
/*     */     {
/* 254 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.joinTeamByTeamId@ team not exist!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 257 */       return false;
/*     */     }
/* 259 */     List<Long> memberIds = TeamManager.getMemberListByXTeam(xTeam);
/* 260 */     if (memberIds.contains(Long.valueOf(roleId)))
/*     */     {
/* 262 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.joinTeamByTeamId@ role in this team already!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 266 */       return false;
/*     */     }
/*     */     
/* 269 */     if (Role2team.get(Long.valueOf(roleId)) != null)
/*     */     {
/* 271 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.joinTeamByTeamId@ role in other team already!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 275 */       return false;
/*     */     }
/*     */     
/* 278 */     Set<Long> lockRoleIds = new HashSet();
/* 279 */     lockRoleIds.addAll(memberIds);
/* 280 */     lockRoleIds.add(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 283 */     Lockeys.lock(Basic.getTable(), lockRoleIds);
/*     */     
/* 285 */     xTeam = xtable.Team.get(Long.valueOf(teamId));
/* 286 */     if (!reCheckAfterLock_joinTeam(xTeam, memberIds, teamId, roleId))
/*     */     {
/* 288 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.joinTeamByTeamId@ reCheckAfterLock err!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 292 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 296 */     if (!TeamManager.onRoleJoinTeam(teamId, xTeam, roleId, joinTeamType))
/*     */     {
/* 298 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.joinTeamByTeamId@ join team failed!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 301 */       return false;
/*     */     }
/*     */     
/* 304 */     rmFromTeamApplyList(Long.valueOf(teamId), xTeam, roleId);
/* 305 */     return true;
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
/*     */   private static void rmFromTeamApplyList(Long teamid, xbean.Team xTeam, long roleId)
/*     */   {
/* 318 */     boolean find = false;
/* 319 */     Iterator<TeamApplicant> it = xTeam.getApplicants().iterator();
/* 320 */     while (it.hasNext())
/*     */     {
/* 322 */       TeamApplicant teamApplicant = (TeamApplicant)it.next();
/* 323 */       if (teamApplicant.getRoleid() == roleId)
/*     */       {
/* 325 */         it.remove();
/* 326 */         find = true;
/* 327 */         break;
/*     */       }
/*     */     }
/*     */     
/* 331 */     if (find)
/*     */     {
/*     */ 
/* 334 */       NoneRealTimeTaskManager.getInstance().addTask(new PSyncApplicantsToAll(teamid.longValue()));
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean reCheckAfterLock_joinTeam(xbean.Team xTeam, List<Long> memberIds, long teamId, long roleId)
/*     */   {
/* 340 */     if (xTeam == null)
/*     */     {
/* 342 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ team not exist!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 345 */       return false;
/*     */     }
/* 347 */     List<Long> memberIds_0 = TeamManager.getMemberListByXTeam(xTeam);
/* 348 */     if ((memberIds_0.size() != memberIds.size()) || (!memberIds_0.containsAll(memberIds)))
/*     */     {
/* 350 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ lock err!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 353 */       return false;
/*     */     }
/* 355 */     if (memberIds_0.contains(Long.valueOf(roleId)))
/*     */     {
/* 357 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ role in this team already!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 361 */       return false;
/*     */     }
/* 363 */     if (Role2team.get(Long.valueOf(roleId)) != null)
/*     */     {
/* 365 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ role in other team already!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 369 */       return false;
/*     */     }
/*     */     
/* 372 */     if (xTeam.getMembers().size() >= TeamInterface.getTeamCapacity())
/*     */     {
/* 374 */       GameServer.logger().error(String.format("[team]TeamManagerForInterSerVice.reCheckAfterLock@ team full!|teamId=%d|roleId=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 377 */       return false;
/*     */     }
/* 379 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamManagerForInterSerVice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */