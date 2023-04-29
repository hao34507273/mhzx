/*     */ package mzm.gsp.coupledaily.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult.Reason;
/*     */ import mzm.gsp.coupledaily.SCloseCoupleDailyPanel;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCloseCoupleDailyPanel extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long leaderRoleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCCloseCoupleDailyPanel(long leaderRoleId)
/*     */   {
/*  30 */     this.leaderRoleId = leaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(CoupleDailyActivityConst.getInstance().NPC_ID, CoupleDailyActivityConst.getInstance().NPC_SERVER_ID, this.leaderRoleId))
/*     */     {
/*     */ 
/*  39 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@npc service is not useable|npc_id=%d|service_id=%d|leader_role_id=%d", new Object[] { Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_ID), Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_SERVER_ID), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  44 */       return false;
/*     */     }
/*  46 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.leaderRoleId, "PCCloseCoupleDailyPanel.processImp"))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     Long teamId = TeamInterface.getTeamidByRoleid(this.leaderRoleId, false);
/*  52 */     if (teamId == null)
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@not exist team id|leader_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  61 */     if (selectMembers.size() != 2)
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@select team size not equal 2|leader_role_id=%d|team_id=%d|team_size=%d", new Object[] { Long.valueOf(this.leaderRoleId), teamId, Integer.valueOf(selectMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (this.leaderRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@leader role id not match|team_id=%d|leader_role_id=%d|team_0_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), selectMembers.get(0) }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     this.partnerRoleId = ((Long)selectMembers.get(1)).longValue();
/*  80 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  81 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  84 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  87 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*  89 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.leaderRoleId, 554, true, true))
/*     */     {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*  95 */     if (teamInfo == null)
/*     */     {
/*  97 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 105 */     if (memberList.size() != 2)
/*     */     {
/* 107 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 116 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 120 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 124 */     long leaderMarriageRoleId = MarriageInterface.getMarriedRoleid(this.leaderRoleId, true);
/* 125 */     if (leaderMarriageRoleId != this.partnerRoleId)
/*     */     {
/* 127 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|leader_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(leaderMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 135 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 136 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 137 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 139 */     if ((!activityJoinResult.isCanJoin()) && (activityJoinResult.getReasonValue() != ActivityJoinResult.Reason.ActivityCountToMax.ordinal()))
/*     */     {
/*     */ 
/* 142 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 153 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 155 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 159 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 163 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 164 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 166 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 174 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 176 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 178 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 182 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 186 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 188 */       GameServer.logger().error(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 192 */       return false;
/*     */     }
/*     */     
/* 195 */     SCloseCoupleDailyPanel sCloseCoupleDailyPanel = new SCloseCoupleDailyPanel();
/*     */     
/* 197 */     OnlineManager.getInstance().send(this.partnerRoleId, sCloseCoupleDailyPanel);
/*     */     
/* 199 */     GameServer.logger().info(String.format("[coupledaily]PCCloseCoupleDailyPanel.processImp@handle close couple daily panel success|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 203 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCCloseCoupleDailyPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */