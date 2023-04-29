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
/*     */ import mzm.gsp.memorycompetition.SOpenRomanticDanceSelectPanel;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCOpenRomanticDanceSelectPanel extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCOpenRomanticDanceSelectPanel(long teamLeaderRoleId)
/*     */   {
/*  30 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     int activityCfgId = SRomanticDanceConsts.getInstance().activity_cfg_id;
/*  37 */     SMemoryCompetitionActivityCfg sMemoryCompetitionActivityCfg = SMemoryCompetitionActivityCfg.get(activityCfgId);
/*  38 */     if (sMemoryCompetitionActivityCfg == null)
/*     */     {
/*  40 */       onOpenRomanticDanceSelectPanelFail(8);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     int npcId = sMemoryCompetitionActivityCfg.npc_id;
/*  45 */     int npcServiceId = sMemoryCompetitionActivityCfg.npc_service_id;
/*     */     
/*  47 */     if (!MemoryCompetitionManager.isRomanticDanceFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(npcId, npcServiceId, this.teamLeaderRoleId))
/*     */     {
/*  59 */       onOpenRomanticDanceSelectPanelFail(9);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  64 */     if (teamId == null)
/*     */     {
/*  66 */       onOpenRomanticDanceSelectPanelFail(1);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  71 */     if (teamRoleIdList.size() != 2)
/*     */     {
/*  73 */       onOpenRomanticDanceSelectPanelFail(3);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.teamLeaderRoleId)
/*     */     {
/*  79 */       onOpenRomanticDanceSelectPanelFail(2);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     this.teamMemberRoleId = ((Long)teamRoleIdList.get(1)).longValue();
/*     */     
/*  85 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/*  86 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/*     */     
/*  88 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, teamMemberUserId }));
/*  89 */     lock(xtable.Role2properties.getTable(), teamRoleIdList);
/*     */     
/*  91 */     Map<Long, String> roleId2UserIdMap = new HashMap();
/*  92 */     roleId2UserIdMap.put(Long.valueOf(this.teamLeaderRoleId), teamLeaderUserId);
/*  93 */     roleId2UserIdMap.put(Long.valueOf(this.teamMemberRoleId), teamMemberUserId);
/*     */     
/*  95 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2UserIdMap, teamRoleIdList, activityCfgId);
/*     */     
/*  97 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  99 */       Map<String, Object> extraMap = new HashMap();
/* 100 */       extraMap.put("ret", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/* 102 */       onOpenRomanticDanceSelectPanelFail(11, extraMap);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     SOpenRomanticDanceSelectPanel sOpenRomanticDanceSelectPanel = new SOpenRomanticDanceSelectPanel();
/* 107 */     OnlineManager.getInstance().sendMulti(sOpenRomanticDanceSelectPanel, teamRoleIdList);
/*     */     
/* 109 */     GameServer.logger().info(String.format("[romanticdance]PCOpenRomanticDanceSelectPanel.processImp@handle open romantic dance select panel success|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   private void onOpenRomanticDanceSelectPanelFail(int ret)
/*     */   {
/* 118 */     onOpenRomanticDanceSelectPanelFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onOpenRomanticDanceSelectPanelFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 123 */     StringBuilder sbLog = new StringBuilder();
/* 124 */     sbLog.append("[romanticdance]PCOpenRomanticDanceSelectPanel.processImp@handle open romantic dance select panel failed");
/* 125 */     sbLog.append("|ret=").append(ret);
/* 126 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 127 */     sbLog.append("|taem_member_role_id=").append(this.teamMemberRoleId);
/*     */     
/* 129 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 131 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 133 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 136 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 138 */     SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 139 */     sAttendRomanticDanceFail.result = ret;
/*     */     
/* 141 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\PCOpenRomanticDanceSelectPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */