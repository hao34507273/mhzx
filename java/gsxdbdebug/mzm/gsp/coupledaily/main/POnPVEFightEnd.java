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
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   private long leaderRoleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  33 */     if (!(((PVEFightEndArg)this.arg).context instanceof CoupleDailyFightContext))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     CoupleDailyFightContext coupleDailyFightContext = (CoupleDailyFightContext)((PVEFightEndArg)this.arg).context;
/*  38 */     this.leaderRoleId = coupleDailyFightContext.leaderRoleId;
/*  39 */     this.partnerRoleId = coupleDailyFightContext.partnerRoleId;
/*     */     
/*  41 */     List<Long> memberRoleIdList = Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) });
/*     */     
/*     */ 
/*  44 */     new PUnSetCoupleDailyStatus(memberRoleIdList).execute();
/*     */     
/*     */ 
/*  47 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/*  49 */       SCoupleDailyNormalResult fightFailNormalResult = new SCoupleDailyNormalResult();
/*  50 */       fightFailNormalResult.result = 3;
/*  51 */       OnlineManager.getInstance().sendMultiAtOnce(fightFailNormalResult, Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*  53 */       GameServer.logger().info(String.format("[coupledaily]POnPVEFightEnd.processImp@couple daily fight failed|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  57 */       CoupleDailyManager.tlogCoupleDailyTaskResult(this.leaderRoleId, this.partnerRoleId, coupleDailyFightContext.fightCfgId, CoupleDailyTaskResultEnum.FAIL);
/*     */       
/*  59 */       return true;
/*     */     }
/*     */     
/*  62 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  63 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  66 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  69 */     lock(xtable.Role2properties.getTable(), memberRoleIdList);
/*     */     
/*  71 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/*  73 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/*  84 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     long partnerMarriageRoleId = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.partnerRoleId, true);
/*  95 */     if (partnerMarriageRoleId != this.leaderRoleId)
/*     */     {
/*  97 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|partner_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(partnerMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 106 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 107 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/*     */     
/* 109 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberRoleIdList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 111 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 113 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 122 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 124 */     SCoupleDailyActivityCfg sCoupleDailyActivityCfg = SCoupleDailyActivityCfg.get(coupleDailyFightContext.fightCfgId);
/* 125 */     int awardId = sCoupleDailyActivityCfg.successAwardId;
/*     */     
/* 127 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 129 */       AwardModel leaderAwardModel = AwardInterface.award(awardId, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FIGHT_AWARD));
/*     */       
/* 131 */       if (leaderAwardModel == null)
/*     */       {
/* 133 */         GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@award leader error,AwardModel is null,happen in two days|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(awardId) }));
/*     */         
/*     */ 
/*     */ 
/* 137 */         return false;
/*     */       }
/*     */       
/* 140 */       AwardModel partnerAwardModel = AwardInterface.award(awardId, partnerUserId, this.partnerRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FIGHT_AWARD));
/*     */       
/* 142 */       if (partnerAwardModel == null)
/*     */       {
/* 144 */         GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@award partner error,AwardModel is null,happen in two days|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(awardId) }));
/*     */         
/*     */ 
/*     */ 
/* 148 */         return false;
/*     */       }
/* 150 */       GameServer.logger().info(String.format("[coupledaily]POnPVEFightEnd.processImp@leader and partner award success,happen in two days|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 154 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 158 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 160 */       GameServer.logger().info(String.format("[coupledaily]POnPVEFightEnd.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     List<TaskInfo> xleaderTaskList = xLeaderCoupleDailyInfo.getTasklist();
/* 168 */     TaskInfo xLeaderFightTaskInfo = null;
/* 169 */     for (TaskInfo taskInfo : xleaderTaskList)
/*     */     {
/* 171 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 2)
/*     */       {
/* 173 */         xLeaderFightTaskInfo = taskInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 178 */     if (xLeaderFightTaskInfo == null)
/*     */     {
/* 180 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@leader has no fight task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     List<TaskInfo> partnerTaskInfos = xPartnerCoupleDailyInfo.getTasklist();
/* 188 */     TaskInfo xPartnerFightTaskInfo = null;
/* 189 */     for (TaskInfo taskInfo : partnerTaskInfos)
/*     */     {
/* 191 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 2)
/*     */       {
/* 193 */         xPartnerFightTaskInfo = taskInfo;
/*     */       }
/*     */     }
/*     */     
/* 197 */     if (xPartnerFightTaskInfo == null)
/*     */     {
/* 199 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@partner has no fight task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 203 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 207 */     if ((xLeaderFightTaskInfo.getIs_finish() == 1) || (xPartnerFightTaskInfo.getIs_finish() == 1))
/*     */     {
/*     */ 
/* 210 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@fight task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|leader_state=%d|partener_state=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderFightTaskInfo.getCfg_id()), Integer.valueOf(xLeaderFightTaskInfo.getIs_finish()), Integer.valueOf(xPartnerFightTaskInfo.getIs_finish()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 215 */       return false;
/*     */     }
/*     */     
/* 218 */     xLeaderFightTaskInfo.setIs_finish(1);
/* 219 */     xPartnerFightTaskInfo.setIs_finish(1);
/*     */     
/* 221 */     AwardModel leaderAwardModel = AwardInterface.award(awardId, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FIGHT_AWARD));
/*     */     
/* 223 */     if (leaderAwardModel == null)
/*     */     {
/* 225 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@award leader error,AwardModel is null|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(sCoupleDailyActivityCfg.failAwardId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     AwardModel partnerAwardModel = AwardInterface.award(awardId, partnerUserId, this.partnerRoleId, false, true, new AwardReason(LogReason.COUPLE_DAILY_FIGHT_AWARD));
/*     */     
/* 235 */     if (partnerAwardModel == null)
/*     */     {
/* 237 */       GameServer.logger().error(String.format("[coupledaily]POnPVEFightEnd.processImp@award partner error,AwardModel is null|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(sCoupleDailyActivityCfg.failAwardId) }));
/*     */       
/*     */ 
/*     */ 
/* 241 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 245 */     CoupleDailyManager.sSyncCoupleDailyInfo(xLeaderCoupleDailyInfo, memberRoleIdList);
/*     */     
/* 247 */     CoupleDailyManager.tlogCoupleDailyTaskResult(this.leaderRoleId, this.partnerRoleId, coupleDailyFightContext.fightCfgId, CoupleDailyTaskResultEnum.SUCCESS);
/*     */     
/*     */ 
/* 250 */     GameServer.logger().info(String.format("[coupledaily]POnPVEFightEnd.processImp@couple daily fight end|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 254 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */