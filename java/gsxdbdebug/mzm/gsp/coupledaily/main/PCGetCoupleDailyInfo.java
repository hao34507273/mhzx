/*     */ package mzm.gsp.coupledaily.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult.Reason;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.coupledaily.SCoupleDailyNormalResult;
/*     */ import mzm.gsp.coupledaily.SGetCoupleDailyInfo;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CoupleQuestionInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetCoupleDailyInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long leaderRoleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCGetCoupleDailyInfo(long leaderRoleId)
/*     */   {
/*  38 */     this.leaderRoleId = leaderRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(CoupleDailyActivityConst.getInstance().NPC_ID, CoupleDailyActivityConst.getInstance().NPC_SERVER_ID, this.leaderRoleId))
/*     */     {
/*     */ 
/*  47 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@npc service is not useable|npc_id=%d|service_id=%d|leader_role_id=%d", new Object[] { Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_ID), Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_SERVER_ID), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.leaderRoleId, "PCGetCoupleDailyInfo.processImp"))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Long teamId = TeamInterface.getTeamidByRoleid(this.leaderRoleId, false);
/*  61 */     if (teamId == null)
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@not exist team id|leader_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  70 */     if (selectMembers.size() != 2)
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@select team size not equal 2|leader_role_id=%d|team_id=%d|team_size=%d", new Object[] { Long.valueOf(this.leaderRoleId), teamId, Integer.valueOf(selectMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (this.leaderRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@leader role id note match|team_id=%d|leader_role_id=%d|team_0_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), selectMembers.get(0) }));
/*     */       
/*     */ 
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     this.partnerRoleId = ((Long)selectMembers.get(1)).longValue();
/*     */     
/*  90 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  91 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  94 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  97 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*  99 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.leaderRoleId, 556, true, true))
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 105 */     if (teamInfo == null)
/*     */     {
/* 107 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 115 */     if (memberList.size() != 2)
/*     */     {
/* 117 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 126 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     long leaderMarriageRoleId = MarriageInterface.getMarriedRoleid(this.leaderRoleId, true);
/* 135 */     if (leaderMarriageRoleId != this.partnerRoleId)
/*     */     {
/* 137 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|leader_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(leaderMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 145 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 146 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 147 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 149 */     if ((!activityJoinResult.isCanJoin()) && (activityJoinResult.getReasonValue() != ActivityJoinResult.Reason.ActivityCountToMax.ordinal()))
/*     */     {
/*     */ 
/* 152 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 163 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 165 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@leader couple daily info is null|leader_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 174 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 176 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@partner couple daily info is null|partner_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/*     */     
/*     */ 
/* 186 */     if ((xLeaderCoupleDailyPartnerId != 0L) && (xLeaderCoupleDailyPartnerId != this.partnerRoleId))
/*     */     {
/* 188 */       GameServer.logger().info(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@leader has take part in before with other partner|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 193 */       SCoupleDailyNormalResult sCoupleDailyNormalResult = new SCoupleDailyNormalResult();
/* 194 */       sCoupleDailyNormalResult.result = 0;
/*     */       
/* 196 */       OnlineManager.getInstance().send(this.leaderRoleId, sCoupleDailyNormalResult);
/* 197 */       OnlineManager.getInstance().send(this.partnerRoleId, sCoupleDailyNormalResult);
/* 198 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 202 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/* 203 */     if ((xPartnerCoupleDailyPartnerId != 0L) && (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 205 */       GameServer.logger().info(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@partner has take part in before with other partner|partner_role_id=%d|partner_partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 210 */       SCoupleDailyNormalResult sCoupleDailyNormalResult = new SCoupleDailyNormalResult();
/* 211 */       sCoupleDailyNormalResult.result = 0;
/*     */       
/* 213 */       OnlineManager.getInstance().send(this.leaderRoleId, sCoupleDailyNormalResult);
/* 214 */       OnlineManager.getInstance().send(this.partnerRoleId, sCoupleDailyNormalResult);
/*     */       
/* 216 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 220 */     if ((xPartnerCoupleDailyPartnerId == 0L) && (xLeaderCoupleDailyPartnerId == 0L))
/*     */     {
/* 222 */       fillRole2CoupleDailyInfo(xLeaderCoupleDailyInfo, xPartnerCoupleDailyInfo);
/*     */     }
/*     */     
/*     */ 
/* 226 */     SGetCoupleDailyInfo sGetCoupleDailyInfo = new SGetCoupleDailyInfo();
/* 227 */     for (TaskInfo xTaskInfo : xLeaderCoupleDailyInfo.getTasklist())
/*     */     {
/* 229 */       sGetCoupleDailyInfo.tasklist.add(Integer.valueOf(xTaskInfo.getCfg_id()));
/* 230 */       if (xTaskInfo.getIs_finish() == 1)
/*     */       {
/* 232 */         sGetCoupleDailyInfo.finishtasklist.add(Integer.valueOf(xTaskInfo.getCfg_id()));
/*     */       }
/*     */     }
/*     */     
/* 236 */     boolean isAward = xLeaderCoupleDailyInfo.getIsawarded() == 1;
/* 237 */     sGetCoupleDailyInfo.isaward = (isAward ? 1 : 0);
/*     */     
/* 239 */     OnlineManager.getInstance().sendMulti(sGetCoupleDailyInfo, memberList);
/*     */     
/* 241 */     GameServer.logger().info(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@handle get couple daily info success|leader_role_id=%d|partner_role_id=%d|task_list=%s|finish_list=%s", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), sGetCoupleDailyInfo.tasklist.toString(), sGetCoupleDailyInfo.finishtasklist.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 246 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void fillRole2CoupleDailyInfo(Role2CoupleDailyInfo xLeaderCoupleDailyInfo, Role2CoupleDailyInfo xPartnerCoupleDailyInfo)
/*     */   {
/* 252 */     xLeaderCoupleDailyInfo.setPartnerroleid(this.partnerRoleId);
/* 253 */     xPartnerCoupleDailyInfo.setPartnerroleid(this.leaderRoleId);
/*     */     
/* 255 */     xPartnerCoupleDailyInfo.setIsawarded(0);
/* 256 */     xLeaderCoupleDailyInfo.setIsawarded(0);
/*     */     
/* 258 */     List<TaskInfo> xLeaderTaskList = xLeaderCoupleDailyInfo.getTasklist();
/* 259 */     List<TaskInfo> xPartnerTaskList = xPartnerCoupleDailyInfo.getTasklist();
/*     */     
/* 261 */     List<Integer> taskList = CoupleDailyManager.getRandomTaskList();
/* 262 */     for (int index = 0; index < CoupleDailyActivityConst.getInstance().RANDOM_TASK_NUM; index++)
/*     */     {
/*     */ 
/* 265 */       TaskInfo xleaderTaskInfo = Pod.newTaskInfo();
/* 266 */       xleaderTaskInfo.setCfg_id(((Integer)taskList.get(index)).intValue());
/* 267 */       xleaderTaskInfo.setIs_finish(0);
/* 268 */       xLeaderTaskList.add(xleaderTaskInfo);
/*     */       
/* 270 */       TaskInfo xPartnerTaskInfo = Pod.newTaskInfo();
/* 271 */       xPartnerTaskInfo.setCfg_id(((Integer)taskList.get(index)).intValue());
/* 272 */       xPartnerTaskInfo.setIs_finish(0);
/* 273 */       xPartnerTaskList.add(xPartnerTaskInfo);
/*     */       
/* 275 */       if (SCoupleDailyActivityCfg.get(xleaderTaskInfo.getCfg_id()).taskType == 0)
/*     */       {
/* 277 */         List<Integer> questionList = CoupleDailyManager.getRandomXinYouLIngXiQuestionList();
/*     */         
/* 279 */         CoupleQuestionInfo xLeaderCoupleQuestionInfo = xLeaderCoupleDailyInfo.getCouplequestioninfo();
/* 280 */         xLeaderCoupleQuestionInfo.getQuestionlist().addAll(questionList);
/*     */         
/*     */ 
/* 283 */         CoupleQuestionInfo xPartnerCoupleQuestionInfo = xPartnerCoupleDailyInfo.getCouplequestioninfo();
/* 284 */         xPartnerCoupleQuestionInfo.getQuestionlist().addAll(questionList);
/*     */       }
/*     */     }
/*     */     
/* 288 */     GameServer.logger().info(String.format("[coupledaily]PCGetCoupleDailyInfo.fillRole2CoupleDailyInfo@init get couple daily info success|leader_role_id=%d|partner_role_id=%d|task_list_leader=%d|task_list_leader=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderCoupleDailyInfo.getTasklist().size()), Integer.valueOf(xPartnerCoupleDailyInfo.getTasklist().size()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 295 */     ActivityInterface.logActivity(this.leaderRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*     */     
/* 297 */     ActivityInterface.tlogActivity(this.leaderRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*     */     
/*     */ 
/*     */ 
/* 301 */     ActivityInterface.logActivity(this.partnerRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*     */     
/* 303 */     ActivityInterface.tlogActivity(this.partnerRoleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCGetCoupleDailyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */