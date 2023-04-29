/*     */ package mzm.gsp.coupledaily.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.coupledaily.SCoupleDailyNormalResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.paraselene.event.JigsawFinishArg;
/*     */ import mzm.gsp.paraselene.event.JigsawFinishProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnJigsawFinished extends JigsawFinishProcedure
/*     */ {
/*     */   private long leaderRoleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  33 */     if (!(((JigsawFinishArg)this.arg).getContext() instanceof CoupleDailyJigsawContext))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     CoupleDailyJigsawContext jigsawContext = (CoupleDailyJigsawContext)((JigsawFinishArg)this.arg).getContext();
/*     */     
/*  39 */     this.leaderRoleId = jigsawContext.leaderRoleId;
/*  40 */     this.partnerRoleId = jigsawContext.partnerRoleId;
/*     */     
/*  42 */     List<Long> roleIdList = Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) });
/*     */     
/*     */ 
/*  45 */     new PUnSetCoupleDailyStatus(roleIdList).execute();
/*  46 */     new PUnSetCoupleDailyPinTuStatus(roleIdList).execute();
/*     */     
/*  48 */     List<Long> sucroleids = ((JigsawFinishArg)this.arg).getSucroleids();
/*     */     
/*  50 */     if ((!sucroleids.contains(Long.valueOf(this.leaderRoleId))) || (!sucroleids.contains(Long.valueOf(this.partnerRoleId))))
/*     */     {
/*  52 */       SCoupleDailyNormalResult pinTuFailNormalResult = new SCoupleDailyNormalResult();
/*  53 */       pinTuFailNormalResult.result = 2;
/*  54 */       OnlineManager.getInstance().sendMultiAtOnce(pinTuFailNormalResult, Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*  56 */       CoupleDailyManager.tlogCoupleDailyTaskResult(this.leaderRoleId, this.partnerRoleId, jigsawContext.pinTuTaskCfgId, CoupleDailyTaskResultEnum.FAIL);
/*     */       
/*     */ 
/*  59 */       GameServer.logger().info(String.format("[coupledaily]POnJigsawFinished.processImp@couple daily pin tu failed|leader_role_id=%d|partner_role_id=%d|success_role_ids=%s", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), sucroleids.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  63 */       return true;
/*     */     }
/*     */     
/*  66 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  67 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  70 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  73 */     lock(xtable.Role2properties.getTable(), roleIdList);
/*     */     
/*     */ 
/*  76 */     long partnerMarriageRoleId = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.partnerRoleId, true);
/*  77 */     if (partnerMarriageRoleId != this.leaderRoleId)
/*     */     {
/*  79 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|partner_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(partnerMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/*  87 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/*  88 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/*     */     
/*  90 */     List<Long> memberList = Arrays.asList(new Long[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) });
/*     */     
/*  92 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/*  94 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  96 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 106 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 117 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 119 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 127 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 129 */     SCoupleDailyActivityCfg sCoupleDailyActivityCfg = SCoupleDailyActivityCfg.get(jigsawContext.pinTuTaskCfgId);
/* 130 */     int awardId = sCoupleDailyActivityCfg.successAwardId;
/*     */     
/*     */ 
/* 133 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 135 */       AwardModel leaderAwardModel = AwardInterface.award(awardId, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FIGHT_AWARD));
/*     */       
/* 137 */       if (leaderAwardModel == null)
/*     */       {
/* 139 */         GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@award leader error,AwardModel is null,happen in two days|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(awardId) }));
/*     */         
/*     */ 
/*     */ 
/* 143 */         return false;
/*     */       }
/*     */       
/* 146 */       AwardModel partnerAwardModel = AwardInterface.award(awardId, partnerUserId, this.partnerRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_PINTU_AWARD));
/*     */       
/* 148 */       if (partnerAwardModel == null)
/*     */       {
/* 150 */         GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@award partner error,AwardModel is null,,happen in two days|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(awardId) }));
/*     */         
/*     */ 
/*     */ 
/* 154 */         return false;
/*     */       }
/*     */       
/* 157 */       GameServer.logger().info(String.format("[coupledaily]POnJigsawFinished.processImp@award leader and partner success,happen in two days|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 161 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 165 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 167 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     List<TaskInfo> leaderTaskInfos = xLeaderCoupleDailyInfo.getTasklist();
/* 175 */     TaskInfo xLeaderPinTuTaskInfo = null;
/* 176 */     for (TaskInfo taskInfo : leaderTaskInfos)
/*     */     {
/* 178 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 1)
/*     */       {
/* 180 */         xLeaderPinTuTaskInfo = taskInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 185 */     if (xLeaderPinTuTaskInfo == null)
/*     */     {
/* 187 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@leader has no fight task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     List<TaskInfo> partnerTaskInfos = xPartnerCoupleDailyInfo.getTasklist();
/* 195 */     TaskInfo xPartnerPinTuTaskInfo = null;
/* 196 */     for (TaskInfo taskInfo : partnerTaskInfos)
/*     */     {
/* 198 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 1)
/*     */       {
/* 200 */         xPartnerPinTuTaskInfo = taskInfo;
/*     */       }
/*     */     }
/*     */     
/* 204 */     if (xPartnerPinTuTaskInfo == null)
/*     */     {
/* 206 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@partner has no pin tu task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 210 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 214 */     if ((xLeaderPinTuTaskInfo.getIs_finish() == 1) || (xPartnerPinTuTaskInfo.getIs_finish() == 1))
/*     */     {
/*     */ 
/* 217 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@pin tu task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|leader_task_state=%d|partner_task_state=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderPinTuTaskInfo.getCfg_id()), Integer.valueOf(xLeaderPinTuTaskInfo.getIs_finish()), Integer.valueOf(xPartnerPinTuTaskInfo.getIs_finish()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     xLeaderPinTuTaskInfo.setIs_finish(1);
/* 226 */     xPartnerPinTuTaskInfo.setIs_finish(1);
/*     */     
/* 228 */     AwardModel leaderAwardModel = AwardInterface.award(awardId, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FIGHT_AWARD));
/*     */     
/* 230 */     if (leaderAwardModel == null)
/*     */     {
/* 232 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@award leader error,AwardModel is null|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/*     */ 
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     AwardModel partnerAwardModel = AwardInterface.award(awardId, partnerUserId, this.partnerRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_PINTU_AWARD));
/*     */     
/* 241 */     if (partnerAwardModel == null)
/*     */     {
/* 243 */       GameServer.logger().error(String.format("[coupledaily]POnJigsawFinished.processImp@award partner error,AwardModel is null|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/*     */ 
/* 247 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 251 */     CoupleDailyManager.sSyncCoupleDailyInfo(xLeaderCoupleDailyInfo, memberList);
/*     */     
/* 253 */     CoupleDailyManager.tlogCoupleDailyTaskResult(this.leaderRoleId, this.partnerRoleId, jigsawContext.pinTuTaskCfgId, CoupleDailyTaskResultEnum.SUCCESS);
/*     */     
/*     */ 
/* 256 */     GameServer.logger().info(String.format("[coupledaily]POnJigsawFinished.processImp@couple daily pin tu end|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 260 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\POnJigsawFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */