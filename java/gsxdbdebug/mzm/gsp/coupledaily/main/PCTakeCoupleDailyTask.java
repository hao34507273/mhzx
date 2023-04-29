/*     */ package mzm.gsp.coupledaily.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.coupledaily.SCoupleDailyPinTuStart;
/*     */ import mzm.gsp.coupledaily.SXinYouLingXiStart;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CoupleQuestionInfo;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCTakeCoupleDailyTask extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long leaderRoleId;
/*     */   private final int index;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCTakeCoupleDailyTask(long leaderRoleId, int index)
/*     */   {
/*  38 */     this.leaderRoleId = leaderRoleId;
/*  39 */     this.index = (index - 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((this.index < 0) || (this.index >= CoupleDailyActivityConst.getInstance().RANDOM_TASK_NUM))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(CoupleDailyActivityConst.getInstance().NPC_ID, CoupleDailyActivityConst.getInstance().NPC_SERVER_ID, this.leaderRoleId))
/*     */     {
/*     */ 
/*  53 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyInfo.processImp@npc service is not useable|npc_id=%d|service_id=%d|leader_role_id=%d", new Object[] { Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_ID), Integer.valueOf(CoupleDailyActivityConst.getInstance().NPC_SERVER_ID), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.leaderRoleId, "PCTakeCoupleDailyTask.processImp"))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Long teamId = TeamInterface.getTeamidByRoleid(this.leaderRoleId, false);
/*  67 */     if (teamId == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@not exist team id|leader_role_id=%d|index=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  76 */     if (selectMembers.size() != 2)
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@select team size not equal 2|leader_role_id=%d|team_id=%d|team_size=%d", new Object[] { Long.valueOf(this.leaderRoleId), teamId, Integer.valueOf(selectMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (this.leaderRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@leader role id note match|team_id=%d|leader_role_id=%d|team_0_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), selectMembers.get(0) }));
/*     */       
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     this.partnerRoleId = ((Long)selectMembers.get(1)).longValue();
/*  95 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  96 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  99 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/* 102 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/* 104 */     if (!RoleStatusInterface.checkCanSetStatus(this.leaderRoleId, 557, true, true))
/*     */     {
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 111 */     if (teamInfo == null)
/*     */     {
/* 113 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 121 */     if (memberList.size() != 2)
/*     */     {
/* 123 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 132 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 136 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 140 */     long leaderMarriageRoleId = MarriageInterface.getMarriedRoleid(this.leaderRoleId, true);
/* 141 */     if (leaderMarriageRoleId != this.partnerRoleId)
/*     */     {
/* 143 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|leader_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(leaderMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 151 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 152 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 153 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 155 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 157 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 168 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 170 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 174 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 178 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 179 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 181 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 189 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 191 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 193 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 197 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 201 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 203 */       GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 207 */       return false;
/*     */     }
/*     */     
/* 210 */     List<TaskInfo> xLeaderTaskList = xLeaderCoupleDailyInfo.getTasklist();
/* 211 */     if ((this.index < 0) || (this.index >= xLeaderTaskList.size()))
/*     */     {
/* 213 */       GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@index not exist in leader task|index=%d|task_size=%d", new Object[] { Integer.valueOf(this.index), Integer.valueOf(xLeaderTaskList.size()) }));
/*     */       
/*     */ 
/*     */ 
/* 217 */       return false;
/*     */     }
/*     */     
/* 220 */     TaskInfo xLeaderTaskInfo = (TaskInfo)xLeaderTaskList.get(this.index);
/*     */     
/* 222 */     if (xLeaderTaskInfo.getIs_finish() == 1)
/*     */     {
/* 224 */       GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@leader task aleardy done|leader_role_id=%d|partner_role_id=%d|index=%d|task_size=%d|cfg_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.index), Integer.valueOf(xLeaderTaskList.size()), Integer.valueOf(xLeaderTaskInfo.getCfg_id()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 229 */       return false;
/*     */     }
/*     */     
/* 232 */     SCoupleDailyActivityCfg sCoupleDailyActivityCfg = SCoupleDailyActivityCfg.get(xLeaderTaskInfo.getCfg_id());
/* 233 */     switch (sCoupleDailyActivityCfg.taskType)
/*     */     {
/*     */ 
/*     */     case 0: 
/* 237 */       doHandleXinYouLingXiTask(xLeaderCoupleDailyInfo.getCouplequestioninfo(), memberList);
/* 238 */       break;
/*     */     
/*     */ 
/*     */     case 1: 
/* 242 */       doHandlePinTuTask(memberList);
/* 243 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 247 */       doHandleFightTask(xLeaderTaskInfo.getCfg_id());
/* 248 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 254 */     GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@handle take couple daily task success|leader_role_id=%d|partner_role_id=%d|index=%d|task_size=%d|cfg_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.index), Integer.valueOf(xLeaderTaskList.size()), Integer.valueOf(xLeaderTaskInfo.getCfg_id()) }));
/*     */     
/*     */ 
/*     */ 
/* 258 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void doHandleXinYouLingXiTask(CoupleQuestionInfo xCoupleQuestionInfo, List<Long> memberList)
/*     */   {
/* 270 */     if (xCoupleQuestionInfo.getCurrentquestionidx() >= xCoupleQuestionInfo.getQuestionlist().size() - 1)
/*     */     {
/* 272 */       GameServer.logger().error(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@question has answered all|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 276 */       return;
/*     */     }
/*     */     
/*     */ 
/* 280 */     long sessinonId = new XinYouLingXiPrepareSession(CoupleDailyActivityConst.getInstance().WAIT_COUPLE_QUESTION_CONFIRM_TIME, this.leaderRoleId, this.partnerRoleId).getSessionId();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 285 */     SXinYouLingXiStart sXinYouLingXiStart = new SXinYouLingXiStart();
/* 286 */     sXinYouLingXiStart.sessionid = sessinonId;
/*     */     
/* 288 */     OnlineManager.getInstance().sendMulti(sXinYouLingXiStart, memberList);
/*     */     
/* 290 */     GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.processImp@handle xin you ling xi task success|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void doHandlePinTuTask(List<Long> memberList)
/*     */   {
/* 303 */     long sessionId = new PinTuPrepareSession(CoupleDailyActivityConst.getInstance().WAIT_COUPLE_PINTU_CONFIRM_TIME, this.leaderRoleId, this.partnerRoleId).getSessionId();
/*     */     
/*     */ 
/*     */ 
/* 307 */     SCoupleDailyPinTuStart sCoupleDailyPinTuStart = new SCoupleDailyPinTuStart();
/* 308 */     sCoupleDailyPinTuStart.sessionid = sessionId;
/* 309 */     OnlineManager.getInstance().sendMulti(sCoupleDailyPinTuStart, memberList);
/*     */     
/* 311 */     GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.doHandlePinTuTask@handle pin tu task success|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void doHandleFightTask(int fightCfgId)
/*     */   {
/* 322 */     int randomFightId = CoupleDailyManager.getRandomCoupleFightFightId();
/*     */     
/* 324 */     RoleStatusInterface.setStatus(Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }), 558, true);
/*     */     
/*     */ 
/* 327 */     FightInterface.startPVEFight(this.leaderRoleId, randomFightId, new CoupleDailyFightContext(this.leaderRoleId, this.partnerRoleId, fightCfgId), 12, FightReason.COUPLE_DAILY_FIGHT);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 332 */     GameServer.logger().info(String.format("[coupledaily]PCTakeCoupleDailyTask.doHandleFightTask@handle fight task success|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCTakeCoupleDailyTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */