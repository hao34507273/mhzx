/*     */ package mzm.gsp.memorycompetition.romanticdance;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg;
/*     */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*     */ import mzm.gsp.memorycompetition.SAttendRomanticDanceFail;
/*     */ import mzm.gsp.memorycompetition.SCloseRomanticDanceSelectPanel;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCCloseRomanticDanceSelectPanel extends LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private long teamMemberRoleId;
/*     */   
/*     */   public PCCloseRomanticDanceSelectPanel(long teamLeaderRoleId)
/*     */   {
/*  25 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     int activityCfgId = SRomanticDanceConsts.getInstance().activity_cfg_id;
/*  32 */     SMemoryCompetitionActivityCfg sMemoryCompetitionActivityCfg = SMemoryCompetitionActivityCfg.get(activityCfgId);
/*  33 */     if (sMemoryCompetitionActivityCfg == null)
/*     */     {
/*  35 */       onCloseRomanticDanceSelectPanelFail(8);
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     int npcId = sMemoryCompetitionActivityCfg.npc_id;
/*  40 */     int npcServiceId = sMemoryCompetitionActivityCfg.npc_service_id;
/*     */     
/*  42 */     if (!MemoryCompetitionManager.isRomanticDanceFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(npcId, npcServiceId, this.teamLeaderRoleId))
/*     */     {
/*  54 */       onCloseRomanticDanceSelectPanelFail(9);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  59 */     if (teamId == null)
/*     */     {
/*  61 */       onCloseRomanticDanceSelectPanelFail(1);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  66 */     if (teamRoleIdList.size() != 2)
/*     */     {
/*  68 */       onCloseRomanticDanceSelectPanelFail(3);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.teamLeaderRoleId)
/*     */     {
/*  74 */       onCloseRomanticDanceSelectPanelFail(2);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     this.teamMemberRoleId = ((Long)teamRoleIdList.get(1)).longValue();
/*     */     
/*  80 */     SCloseRomanticDanceSelectPanel sCloseRomanticDanceSelectPanel = new SCloseRomanticDanceSelectPanel();
/*  81 */     OnlineManager.getInstance().send(this.teamMemberRoleId, sCloseRomanticDanceSelectPanel);
/*     */     
/*  83 */     GameServer.logger().info(String.format("[romanticdance]PCloseRomanticDanceSelectPanel.processImp@handle close romantic dance select panel success|team_leader_role_id=%d|team_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/*     */ 
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   private void onCloseRomanticDanceSelectPanelFail(int ret)
/*     */   {
/*  92 */     onCloseRomanticDanceSelectPanelFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCloseRomanticDanceSelectPanelFail(int ret, Map<String, ?> extraMap)
/*     */   {
/*  97 */     StringBuilder sbLog = new StringBuilder();
/*  98 */     sbLog.append("[romanticdance]PCloseRomanticDanceSelectPanel.processImp@handle close romantic dance select panel failed");
/*  99 */     sbLog.append("|ret=").append(ret);
/* 100 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 101 */     sbLog.append("|taem_member_role_id=").append(this.teamMemberRoleId);
/*     */     
/* 103 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 105 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 107 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 110 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 112 */     SAttendRomanticDanceFail sAttendRomanticDanceFail = new SAttendRomanticDanceFail();
/* 113 */     sAttendRomanticDanceFail.result = ret;
/*     */     
/* 115 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sAttendRomanticDanceFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\PCCloseRomanticDanceSelectPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */