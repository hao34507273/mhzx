/*     */ package mzm.gsp.memorycompetition.romanticdance;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*     */ import mzm.gsp.memorycompetition.SAttendRomanticDanceFail;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2memorycompetition;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendRomanticDance extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private final int hardRank;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCAttendRomanticDance(long teamLeaderRoleId, int hardRank)
/*     */   {
/*  33 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*  34 */     this.hardRank = hardRank;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (this.hardRank < 0)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     int activityCfgId = SRomanticDanceConsts.getInstance().activity_cfg_id;
/*  46 */     SMemoryCompetitionActivityCfg sMemoryCompetitionActivityCfg = SMemoryCompetitionActivityCfg.get(activityCfgId);
/*  47 */     if (sMemoryCompetitionActivityCfg == null)
/*     */     {
/*  49 */       onAttendRomanticDanceFail(8);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     int npcId = sMemoryCompetitionActivityCfg.npc_id;
/*  54 */     int npcServiceId = sMemoryCompetitionActivityCfg.npc_service_id;
/*  55 */     if (this.hardRank >= sMemoryCompetitionActivityCfg.memory_competition_cfg_id_list.size())
/*     */     {
/*  57 */       onAttendRomanticDanceFail(12);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     int memoryCompetitionCfgId = ((Integer)sMemoryCompetitionActivityCfg.memory_competition_cfg_id_list.get(this.hardRank)).intValue();
/*     */     
/*  63 */     if (!MemoryCompetitionManager.isRomanticDanceFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(npcId, npcServiceId, this.teamLeaderRoleId))
/*     */     {
/*  75 */       onAttendRomanticDanceFail(9);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     SMemoryCompetitionCfg sMemoryCompetitionCfg = SMemoryCompetitionCfg.get(memoryCompetitionCfgId);
/*  80 */     if (sMemoryCompetitionCfg == null)
/*     */     {
/*  82 */       Map<String, Object> extraMap = new HashMap();
/*  83 */       extraMap.put("memory_competition_cfg_id", Integer.valueOf(memoryCompetitionCfgId));
/*     */       
/*  85 */       onAttendRomanticDanceFail(9, extraMap);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  90 */     if (teamId == null)
/*     */     {
/*  92 */       onAttendRomanticDanceFail(1);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  97 */     if (teamRoleIdList.size() != 2)
/*     */     {
/*  99 */       onAttendRomanticDanceFail(3);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.teamLeaderRoleId)
/*     */     {
/* 105 */       onAttendRomanticDanceFail(2);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     this.teamMemberRoleId = ((Long)teamRoleIdList.get(1)).longValue();
/*     */     
/* 111 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/* 112 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*     */     
/* 114 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/* 115 */     lock(xtable.Role2properties.getTable(), teamRoleIdList);
/*     */     
/*     */ 
/* 118 */     if (!RoleStatusInterface.checkCansetStatus(teamRoleIdList, 925, true, teamRoleIdList, true))
/*     */     {
/*     */ 
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     if (RoleStatusInterface.containsStatus(this.teamLeaderRoleId, 921, true))
/*     */     {
/* 127 */       onAttendRomanticDanceFail(13);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     if (RoleStatusInterface.containsStatus(this.teamMemberRoleId, 921, true))
/*     */     {
/* 133 */       onAttendRomanticDanceFail(14);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     RoleStatusInterface.setStatus(teamRoleIdList, 921, true);
/*     */     
/*     */ 
/* 141 */     boolean isAllTeamMemberNormal = TeamInterface.isAllTeamMemberNormal(teamId.longValue(), true);
/* 142 */     if (!isAllTeamMemberNormal)
/*     */     {
/* 144 */       onAttendRomanticDanceFail(4);
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     Map<Long, String> roleId2UserIdMap = new HashMap();
/* 149 */     roleId2UserIdMap.put(Long.valueOf(this.teamLeaderRoleId), teamLeaderUserId);
/* 150 */     roleId2UserIdMap.put(Long.valueOf(this.teamMemberRoleId), teamMemberUserId);
/*     */     
/* 152 */     if (Role2memorycompetition.get(Long.valueOf(this.teamLeaderRoleId)) != null)
/*     */     {
/* 154 */       onAttendRomanticDanceFail(5);
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     if (Role2memorycompetition.get(Long.valueOf(this.teamMemberRoleId)) != null)
/*     */     {
/* 160 */       onAttendRomanticDanceFail(6);
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2UserIdMap, teamRoleIdList, activityCfgId);
/*     */     
/* 166 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 168 */       Map<String, Object> extraMap = new HashMap();
/* 169 */       extraMap.put("ret", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/* 171 */       onAttendRomanticDanceFail(11, extraMap);
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     int limitAwardTimes = SRomanticDanceConsts.getInstance().every_day_award_times;
/* 176 */     int teamLeaderActivityTimes = ActivityInterface.getActivityCount(teamLeaderUserId, this.teamLeaderRoleId, activityCfgId, true);
/*     */     
/* 178 */     if (teamLeaderActivityTimes >= limitAwardTimes)
/*     */     {
/* 180 */       SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 181 */       sAttendRomanticDanceFail.result = 7;
/* 182 */       OnlineManager.getInstance().send(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */     }
/*     */     
/* 185 */     int teamMemberActivityTimes = ActivityInterface.getActivityCount(teamMemberUserId, this.teamMemberRoleId, activityCfgId, true);
/*     */     
/* 187 */     if (teamMemberActivityTimes >= limitAwardTimes)
/*     */     {
/* 189 */       SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 190 */       sAttendRomanticDanceFail.result = 7;
/* 191 */       OnlineManager.getInstance().send(this.teamMemberRoleId, sAttendRomanticDanceFail);
/*     */     }
/*     */     
/* 194 */     boolean startResult = MemoryCompetitionManager.startMemoryCompetitinGame(activityCfgId, teamRoleIdList, memoryCompetitionCfgId, 0, false);
/*     */     
/* 196 */     if (!startResult)
/*     */     {
/* 198 */       return false;
/*     */     }
/*     */     
/* 201 */     MemoryCompetitionManager.tlogAttendRomantciDance(this.teamLeaderRoleId, this.teamMemberRoleId, this.hardRank);
/*     */     
/* 203 */     GameServer.logger().info(String.format("[romanticdance]PCAttendRomanticDance.processImp@handle attend romantic dance success|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 207 */     return true;
/*     */   }
/*     */   
/*     */   private void onAttendRomanticDanceFail(int ret)
/*     */   {
/* 212 */     onAttendRomanticDanceFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onAttendRomanticDanceFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 217 */     StringBuilder sbLog = new StringBuilder();
/* 218 */     sbLog.append("[romanticdance]PCAttendRomanticDance.processImp@attend romantic dance failed");
/* 219 */     sbLog.append("|ret=").append(ret);
/* 220 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 221 */     sbLog.append("|taem_member_role_id=").append(this.teamMemberRoleId);
/* 222 */     sbLog.append("|hard_rank=").append(this.hardRank);
/*     */     
/* 224 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 226 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 228 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 231 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 233 */     SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 234 */     sAttendRomanticDanceFail.result = ret;
/*     */     
/* 236 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\PCAttendRomanticDance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */