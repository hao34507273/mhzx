/*     */ package mzm.gsp.memorycompetition.romanticdance;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg;
/*     */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*     */ import mzm.gsp.memorycompetition.SAttendRomanticDanceFail;
/*     */ import mzm.gsp.memorycompetition.SCloseRomanticDanceRulePanel;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCloseRomanticDanceRulePanel
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCloseRomanticDanceRulePanel(long teamLeaderRoleId)
/*     */   {
/*  26 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     int activityCfgId = SRomanticDanceConsts.getInstance().activity_cfg_id;
/*  33 */     SMemoryCompetitionActivityCfg sMemoryCompetitionActivityCfg = SMemoryCompetitionActivityCfg.get(activityCfgId);
/*  34 */     if (sMemoryCompetitionActivityCfg == null)
/*     */     {
/*  36 */       onCloseRomanticDanceRulePanelFail(8);
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     int npcId = sMemoryCompetitionActivityCfg.npc_id;
/*  41 */     int npcServiceId = sMemoryCompetitionActivityCfg.npc_service_id;
/*     */     
/*  43 */     if (!MemoryCompetitionManager.isRomanticDanceFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(npcId, npcServiceId, this.teamLeaderRoleId))
/*     */     {
/*  55 */       onCloseRomanticDanceRulePanelFail(9);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  60 */     if (teamId == null)
/*     */     {
/*  62 */       onCloseRomanticDanceRulePanelFail(1);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  67 */     if (teamRoleIdList.size() != 2)
/*     */     {
/*  69 */       onCloseRomanticDanceRulePanelFail(3);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.teamLeaderRoleId)
/*     */     {
/*  75 */       onCloseRomanticDanceRulePanelFail(2);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     this.teamMemberRoleId = ((Long)teamRoleIdList.get(1)).longValue();
/*     */     
/*  81 */     SCloseRomanticDanceRulePanel sCloseRomanticDanceRulePanel = new SCloseRomanticDanceRulePanel();
/*  82 */     OnlineManager.getInstance().send(this.teamMemberRoleId, sCloseRomanticDanceRulePanel);
/*     */     
/*  84 */     GameServer.logger().info(String.format("[romanticdance]PCOpenRomanticDanceRulePanel.processImp@handle open romantic dance rule panel success|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   private void onCloseRomanticDanceRulePanelFail(int ret)
/*     */   {
/*  94 */     onPCloseRomanticDanceRulePanelFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onPCloseRomanticDanceRulePanelFail(int ret, Map<String, ?> extraMap)
/*     */   {
/*  99 */     StringBuilder sbLog = new StringBuilder();
/* 100 */     sbLog.append("[romanticdance]PCloseRomanticDanceRulePanel.processImp@handle close romantic dance rule panel failed");
/* 101 */     sbLog.append("|ret=").append(ret);
/* 102 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 103 */     sbLog.append("|taem_member_role_id=").append(this.teamMemberRoleId);
/*     */     
/* 105 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 107 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 109 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 112 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 114 */     SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 115 */     sAttendRomanticDanceFail.result = ret;
/*     */     
/* 117 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\PCloseRomanticDanceRulePanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */