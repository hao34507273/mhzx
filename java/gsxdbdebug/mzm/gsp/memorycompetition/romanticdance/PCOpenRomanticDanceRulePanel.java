/*     */ package mzm.gsp.memorycompetition.romanticdance;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg;
/*     */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*     */ import mzm.gsp.memorycompetition.SAttendRomanticDanceFail;
/*     */ import mzm.gsp.memorycompetition.SOpenRomanticDanceRulePanel;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCOpenRomanticDanceRulePanel extends LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCOpenRomanticDanceRulePanel(long teamLeaderRoleId)
/*     */   {
/*  31 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     int activityCfgId = SRomanticDanceConsts.getInstance().activity_cfg_id;
/*  38 */     SMemoryCompetitionActivityCfg sMemoryCompetitionActivityCfg = SMemoryCompetitionActivityCfg.get(activityCfgId);
/*  39 */     if (sMemoryCompetitionActivityCfg == null)
/*     */     {
/*  41 */       onOpenRomanticDanceRulePanelFail(8);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     int npcId = sMemoryCompetitionActivityCfg.npc_id;
/*  46 */     int npcServiceId = sMemoryCompetitionActivityCfg.npc_service_id;
/*     */     
/*  48 */     if (!MemoryCompetitionManager.isRomanticDanceFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(npcId, npcServiceId, this.teamLeaderRoleId))
/*     */     {
/*  60 */       onOpenRomanticDanceRulePanelFail(9);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  65 */     if (teamId == null)
/*     */     {
/*  67 */       onOpenRomanticDanceRulePanelFail(1);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  72 */     if (teamRoleIdList.size() != 2)
/*     */     {
/*  74 */       onOpenRomanticDanceRulePanelFail(3);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.teamLeaderRoleId)
/*     */     {
/*  80 */       onOpenRomanticDanceRulePanelFail(2);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     this.teamMemberRoleId = ((Long)teamRoleIdList.get(1)).longValue();
/*     */     
/*  86 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/*  87 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*     */     
/*  89 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/*  90 */     lock(xtable.Role2properties.getTable(), teamRoleIdList);
/*     */     
/*  92 */     Map<Long, String> roleId2UserIdMap = new HashMap();
/*  93 */     roleId2UserIdMap.put(Long.valueOf(this.teamLeaderRoleId), teamLeaderUserId);
/*  94 */     roleId2UserIdMap.put(Long.valueOf(this.teamMemberRoleId), teamMemberUserId);
/*     */     
/*  96 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2UserIdMap, teamRoleIdList, activityCfgId);
/*     */     
/*  98 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 100 */       Map<String, Object> extraMap = new HashMap();
/* 101 */       extraMap.put("ret", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/* 103 */       onOpenRomanticDanceRulePanelFail(11, extraMap);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     SOpenRomanticDanceRulePanel sOpenRomanticDanceRulePanel = new SOpenRomanticDanceRulePanel();
/* 108 */     OnlineManager.getInstance().sendMulti(sOpenRomanticDanceRulePanel, teamRoleIdList);
/*     */     
/* 110 */     GameServer.logger().info(String.format("[romanticdance]PCOpenRomanticDanceRulePanel.processImp@handle open romantic dance rule panel success|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 115 */     return true;
/*     */   }
/*     */   
/*     */   private void onOpenRomanticDanceRulePanelFail(int ret)
/*     */   {
/* 120 */     onOpenRomanticDanceRulePanelFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onOpenRomanticDanceRulePanelFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 125 */     StringBuilder sbLog = new StringBuilder();
/* 126 */     sbLog.append("[romanticdance]PCAttendRomanticDance.processImp@handle open romantic dance rule panel failed");
/* 127 */     sbLog.append("|ret=").append(ret);
/* 128 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 129 */     sbLog.append("|taem_member_role_id=").append(this.teamMemberRoleId);
/*     */     
/* 131 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 133 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 135 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 138 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 140 */     SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 141 */     sAttendRomanticDanceFail.result = ret;
/*     */     
/* 143 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\PCOpenRomanticDanceRulePanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */