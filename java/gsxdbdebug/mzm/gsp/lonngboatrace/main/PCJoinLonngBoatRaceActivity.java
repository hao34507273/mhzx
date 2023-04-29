/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.lonngboatrace.SPreview;
/*     */ import mzm.gsp.lonngboatrace.SRejectJoin;
/*     */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceActivityCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.PhaseNo2phase;
/*     */ import mzm.gsp.lonngboatrace.confbean.STLonngBoatRacePhaseCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCJoinLonngBoatRaceActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int raceId;
/*     */   
/*     */   public PCJoinLonngBoatRaceActivity(long roleId, int activityId, int raceid)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.activityId = activityId;
/*  36 */     this.raceId = raceid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     LonngBoatRaceActivityCfg activityCfg = LonngBoatRaceActivityCfg.get(this.activityId);
/*  44 */     ArrayList<String> params = new ArrayList();
/*  45 */     if ((activityCfg == null) || (activityCfg.raceId != this.raceId))
/*     */     {
/*  47 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace activityId or raceId not exist in activity conf|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/*  50 */       GameServer.logger().error(logStr);
/*  51 */       params.add(String.valueOf(this.raceId));
/*  52 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(2, params));
/*  53 */       return false;
/*     */     }
/*  55 */     STLonngBoatRacePhaseCfg phaseCfg = (STLonngBoatRacePhaseCfg)((Map.Entry)STLonngBoatRacePhaseCfg.getAll().entrySet().iterator().next()).getValue();
/*  56 */     if ((phaseCfg == null) || (phaseCfg.raceId2phaseNos == null) || (phaseCfg.raceId2phaseNos.get(Integer.valueOf(this.raceId)) == null) || (((PhaseNo2phase)phaseCfg.raceId2phaseNos.get(Integer.valueOf(this.raceId))).phaseNo2phase.get(Integer.valueOf(1)) == null))
/*     */     {
/*     */ 
/*  59 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace activityId or raceId not exist in phase conf|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/*  62 */       GameServer.logger().error(logStr);
/*  63 */       params.add(String.valueOf(this.raceId));
/*  64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(2, params));
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     if (!LonngBoatRaceManager.isLonngBoatRaceOpenForRole(this.roleId, this.activityId))
/*     */     {
/*  71 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace activity switch closed|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/*  74 */       GameServer.logger().error(logStr);
/*  75 */       params.add(String.valueOf(this.activityId));
/*  76 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(3, params));
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!LonngBoatRaceManager.checkNpcService(this.roleId, this.activityId))
/*     */     {
/*  82 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace npcservice not available|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/*  85 */       GameServer.logger().error(logStr);
/*  86 */       params.add(String.valueOf(this.activityId));
/*  87 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(4, params));
/*  88 */       return false;
/*     */     }
/*  90 */     if (!MapInterface.isNearByNPC(this.roleId, activityCfg.npcId))
/*     */     {
/*  92 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace role is not near by npc|roleid=%d|activityid=%d|raceid=%d|npcid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId), Integer.valueOf(activityCfg.npcId) });
/*     */       
/*     */ 
/*  95 */       GameServer.logger().error(logStr);
/*  96 */       params.add(String.valueOf(activityCfg.npcId));
/*  97 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(5, params));
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 102 */     if (teamInfo == null)
/*     */     {
/* 104 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace team not exist|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 107 */       GameServer.logger().error(logStr);
/* 108 */       params.add(String.valueOf(this.activityId));
/* 109 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(6, params));
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/* 115 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace role is not leader|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 118 */       GameServer.logger().error(logStr);
/* 119 */       params.add(String.valueOf(this.activityId));
/* 120 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(7, params));
/* 121 */       return false;
/*     */     }
/* 123 */     if (!teamInfo.isAllTeamMemberNormal())
/*     */     {
/* 125 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace team member not normal|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 128 */       GameServer.logger().error(logStr);
/* 129 */       params.add(String.valueOf(this.activityId));
/* 130 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(8, params));
/* 131 */       return false;
/*     */     }
/* 133 */     long teamId = teamInfo.getTeamId();
/* 134 */     List<Long> lockMembers = teamInfo.getTeamNormalList();
/*     */     
/* 136 */     Map<Long, String> roleId2UserId = new HashMap(lockMembers.size());
/* 137 */     for (Long roleId : lockMembers)
/*     */     {
/* 139 */       roleId2UserId.put(roleId, mzm.gsp.role.main.RoleInterface.getUserId(roleId.longValue()));
/*     */     }
/*     */     
/*     */ 
/* 143 */     lock(User.getTable(), roleId2UserId.values());
/*     */     
/* 145 */     lock(Basic.getTable(), lockMembers);
/*     */     
/* 147 */     lock(Team.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(teamId) }));
/*     */     
/*     */ 
/* 150 */     TeamInfo teamInfoTmp = TeamInterface.getTeamInfo(teamId, true);
/* 151 */     if (teamInfoTmp == null)
/*     */     {
/* 153 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace team not exist after lock|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 156 */       GameServer.logger().error(logStr);
/* 157 */       params.add(String.valueOf(this.activityId));
/* 158 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(6, params));
/* 159 */       return false;
/*     */     }
/* 161 */     if (!teamInfoTmp.isLeader(this.roleId))
/*     */     {
/* 163 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace role is not leader after lock|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 166 */       GameServer.logger().error(logStr);
/* 167 */       params.add(String.valueOf(this.activityId));
/* 168 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(7, params));
/* 169 */       return false;
/*     */     }
/* 171 */     if (!teamInfoTmp.isAllTeamMemberNormal())
/*     */     {
/* 173 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace team member not normal after lock|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 176 */       GameServer.logger().error(logStr);
/* 177 */       params.add(String.valueOf(this.activityId));
/* 178 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(8, params));
/* 179 */       return false;
/*     */     }
/* 181 */     List<Long> normalMembersTmp = teamInfoTmp.getTeamNormalList();
/* 182 */     if ((lockMembers.size() != normalMembersTmp.size()) || (!lockMembers.containsAll(normalMembersTmp)))
/*     */     {
/* 184 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace team member changed after lock|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) });
/*     */       
/*     */ 
/* 187 */       GameServer.logger().error(logStr);
/* 188 */       params.add(String.valueOf(this.activityId));
/* 189 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(9, params));
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2UserId, lockMembers, this.activityId);
/*     */     
/* 195 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 197 */       String logStr = String.format("[lonngboatrace]PCJoinLonngBoatRaceActivity.processImp@lonngboatrace activity can not join|roleid=%d|activityid=%d|raceid=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId), Integer.valueOf(activityJoinResult.getReasonValue()) });
/*     */       
/*     */ 
/* 200 */       GameServer.logger().error(logStr);
/* 201 */       LonngBoatRaceManager.sendCantJoinReason(this.roleId, this.activityId, lockMembers, activityJoinResult);
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     return doAction(teamId, lockMembers);
/*     */   }
/*     */   
/*     */ 
/*     */   boolean doAction(long teamId, List<Long> memberList)
/*     */   {
/* 211 */     return OnlineManager.getInstance().sendMulti(new SPreview(this.activityId, this.raceId), memberList);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\PCJoinLonngBoatRaceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */