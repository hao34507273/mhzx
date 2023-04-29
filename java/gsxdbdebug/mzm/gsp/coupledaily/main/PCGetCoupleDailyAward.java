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
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.coupledaily.SGetCoupleDailyAward;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetCoupleDailyAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long leaderRoleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCGetCoupleDailyAward(long leaderRoleId)
/*     */   {
/*  35 */     this.leaderRoleId = leaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(CoupleDailyActivityConst.getInstance().NPC_ID, CoupleDailyActivityConst.getInstance().NPC_SERVER_ID, this.leaderRoleId))
/*     */     {
/*     */ 
/*  44 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@npc service is not useable|npc_id=%d|service_id=%d|leader_role_id=%d", new Object[] { Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_ID), Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_SERVER_ID), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.leaderRoleId, "PCGetCoupleDailyAward.processImp"))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     Long teamId = TeamInterface.getTeamidByRoleid(this.leaderRoleId, false);
/*  58 */     if (teamId == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@not exist team id|leader_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  67 */     if (selectMembers.size() != 2)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@select team size not equal 2|leader_role_id=%d|team_id=%d|team_size=%d", new Object[] { Long.valueOf(this.leaderRoleId), teamId, Integer.valueOf(selectMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (this.leaderRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@leader role id note match|team_id=%d|leader_role_id=%d|team_0_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), selectMembers.get(0) }));
/*     */       
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     this.partnerRoleId = ((Long)selectMembers.get(1)).longValue();
/*  86 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  87 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  90 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  93 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*  95 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.leaderRoleId, 555, true, true))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 101 */     if (teamInfo == null)
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 111 */     if (memberList.size() != 2)
/*     */     {
/* 113 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 122 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     long leaderMarriageRoleId = MarriageInterface.getMarriedRoleid(this.leaderRoleId, true);
/* 131 */     if (leaderMarriageRoleId != this.partnerRoleId)
/*     */     {
/* 133 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|leader_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(leaderMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 141 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 142 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 143 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 145 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 147 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 158 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 160 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 168 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 169 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 171 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 179 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 181 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 183 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 187 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 191 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 193 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     for (TaskInfo xTaskInfo : xLeaderCoupleDailyInfo.getTasklist())
/*     */     {
/* 202 */       if (xTaskInfo.getIs_finish() == 0)
/*     */       {
/* 204 */         GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@task not finished|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|is_finish=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xTaskInfo.getCfg_id()), Integer.valueOf(xTaskInfo.getIs_finish()) }));
/*     */         
/*     */ 
/*     */ 
/* 208 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 212 */     if ((xLeaderCoupleDailyInfo.getIsawarded() == 1) || (xPartnerCoupleDailyInfo.getIsawarded() == 1))
/*     */     {
/*     */ 
/* 215 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@award has awarded|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 219 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 223 */     mzm.gsp.award.main.AwardModel awardModule = AwardInterface.award(CoupleDailyActivityConst.getInstance().FINISH_ALL_TASK_AWARD_ID, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FINAL_AWARD));
/*     */     
/* 225 */     if (awardModule == null)
/*     */     {
/* 227 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@award leader error,AwardModel is null|leader_role_id=%d|partner_role_id=%d|award_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(CoupleDailyActivityConst.getInstance().FINISH_ALL_TASK_AWARD_ID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 232 */       return false;
/*     */     }
/* 234 */     xLeaderCoupleDailyInfo.setIsawarded(1);
/* 235 */     xPartnerCoupleDailyInfo.setIsawarded(1);
/*     */     
/* 237 */     SGetCoupleDailyAward sGetCoupleDailyAward = new SGetCoupleDailyAward();
/* 238 */     OnlineManager.getInstance().sendMulti(sGetCoupleDailyAward, memberList);
/*     */     
/*     */ 
/* 241 */     ActivityInterface.addActivityCount(leaderUserId, this.leaderRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 243 */     ActivityInterface.addActivityCount(partnerUserId, this.partnerRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/*     */ 
/*     */ 
/* 247 */     ActivityInterface.logActivity(this.leaderRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     
/* 249 */     ActivityInterface.tlogActivity(this.leaderRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/*     */ 
/* 253 */     ActivityInterface.logActivity(this.partnerRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     
/* 255 */     ActivityInterface.tlogActivity(this.partnerRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 258 */     GameServer.logger().info(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@handle get couple daily award success|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 263 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCGetCoupleDailyAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */