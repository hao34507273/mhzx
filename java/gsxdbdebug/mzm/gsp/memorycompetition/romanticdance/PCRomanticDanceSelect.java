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
/*     */ import mzm.gsp.memorycompetition.SRomanticDanceSelect;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRomanticDanceSelect extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private final int rankNum;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCRomanticDanceSelect(long teamLeaderRoleId, int rankNum)
/*     */   {
/*  32 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*  33 */     this.rankNum = rankNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     int activityCfgId = SRomanticDanceConsts.getInstance().activity_cfg_id;
/*  40 */     SMemoryCompetitionActivityCfg sMemoryCompetitionActivityCfg = SMemoryCompetitionActivityCfg.get(activityCfgId);
/*  41 */     if (sMemoryCompetitionActivityCfg == null)
/*     */     {
/*  43 */       onRomanticDanceSelectFail(8);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     int npcId = sMemoryCompetitionActivityCfg.npc_id;
/*  48 */     int npcServiceId = sMemoryCompetitionActivityCfg.npc_service_id;
/*     */     
/*  50 */     if (this.rankNum >= sMemoryCompetitionActivityCfg.memory_competition_cfg_id_list.size())
/*     */     {
/*  52 */       onRomanticDanceSelectFail(12);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int memoryCompetitionCfgId = ((Integer)sMemoryCompetitionActivityCfg.memory_competition_cfg_id_list.get(this.rankNum)).intValue();
/*     */     
/*  58 */     if (!MemoryCompetitionManager.isRomanticDanceFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(npcId, npcServiceId, this.teamLeaderRoleId))
/*     */     {
/*  70 */       onRomanticDanceSelectFail(9);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     SMemoryCompetitionCfg sMemoryCompetitionCfg = SMemoryCompetitionCfg.get(memoryCompetitionCfgId);
/*  75 */     if (sMemoryCompetitionCfg == null)
/*     */     {
/*  77 */       Map<String, Object> extraMap = new HashMap();
/*  78 */       extraMap.put("memory_competition_cfg_id", Integer.valueOf(memoryCompetitionCfgId));
/*     */       
/*  80 */       onRomanticDanceSelectFail(9, extraMap);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  85 */     if (teamId == null)
/*     */     {
/*  87 */       onRomanticDanceSelectFail(1);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  92 */     if (teamRoleIdList.size() != 2)
/*     */     {
/*  94 */       onRomanticDanceSelectFail(3);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.teamLeaderRoleId)
/*     */     {
/* 100 */       onRomanticDanceSelectFail(2);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     this.teamMemberRoleId = ((Long)teamRoleIdList.get(1)).longValue();
/*     */     
/* 106 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/* 107 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*     */     
/* 109 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/* 110 */     lock(xtable.Role2properties.getTable(), teamRoleIdList);
/*     */     
/* 112 */     Map<Long, String> roleId2UserIdMap = new HashMap();
/* 113 */     roleId2UserIdMap.put(Long.valueOf(this.teamLeaderRoleId), teamLeaderUserId);
/* 114 */     roleId2UserIdMap.put(Long.valueOf(this.teamMemberRoleId), teamMemberUserId);
/*     */     
/* 116 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2UserIdMap, teamRoleIdList, activityCfgId);
/*     */     
/* 118 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 120 */       Map<String, Object> extraMap = new HashMap();
/* 121 */       extraMap.put("ret", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/* 123 */       onRomanticDanceSelectFail(11, extraMap);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     SRomanticDanceSelect sRomanticDanceSelect = new SRomanticDanceSelect();
/* 128 */     sRomanticDanceSelect.rank_num = this.rankNum;
/* 129 */     OnlineManager.getInstance().send(this.teamMemberRoleId, sRomanticDanceSelect);
/*     */     
/* 131 */     GameServer.logger().info(String.format("[romanticdance]PCRomanticDanceSelect.processImp@handle open romantic dance select panel success|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void onRomanticDanceSelectFail(int ret)
/*     */   {
/* 140 */     onRomanticDanceSelectFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onRomanticDanceSelectFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 145 */     StringBuilder sbLog = new StringBuilder();
/* 146 */     sbLog.append("[romanticdance]PCRomanticDanceSelect.processImp@handle open romantic dance select panel failed");
/* 147 */     sbLog.append("|ret=").append(ret);
/* 148 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 149 */     sbLog.append("|taem_member_role_id=").append(this.teamMemberRoleId);
/*     */     
/* 151 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 153 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 155 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 158 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 160 */     SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 161 */     sAttendRomanticDanceFail.result = ret;
/*     */     
/* 163 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\PCRomanticDanceSelect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */