/*     */ package mzm.gsp.npcreward.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.npcreward.SGetRewardFailed;
/*     */ import mzm.gsp.npcreward.SGetRewardSuccess;
/*     */ import mzm.gsp.npcreward.confbean.SNPCRewardCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.main.WantedManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetReward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetReward(long roleid, int activityCfgid)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (this.activityCfgid <= 0)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  57 */     SNPCRewardCfg sNPCRewardCfg = SNPCRewardCfg.get(this.activityCfgid);
/*  58 */     if (sNPCRewardCfg == null)
/*     */     {
/*  60 */       onFailed(-3);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  67 */     if (!NPCRewardManager.isFunOpen(this.roleid, this.activityCfgid))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*  73 */     if (userid == null)
/*     */     {
/*  75 */       onFailed(-2);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  81 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1181, true, true))
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  97 */     if (!result.isCanJoin())
/*     */     {
/*  99 */       Map<String, Object> extras = new HashMap();
/* 100 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 101 */       onFailed(-6, extras);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 109 */     int count = ActivityInterface.getActivityCount(userid, this.roleid, this.activityCfgid, true);
/* 110 */     if (count >= ActivityInterface.getActivityCfg(this.activityCfgid).count)
/*     */     {
/* 112 */       Map<String, Object> extras = new HashMap();
/* 113 */       extras.put("count", Integer.valueOf(count));
/* 114 */       extras.put("maxCount", Integer.valueOf(ActivityInterface.getActivityCfg(this.activityCfgid).count));
/* 115 */       onFailed(-5, extras);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     LogReason logReason = LogReason.GET_NPC_REWARD;
/*     */     
/* 121 */     int awardCfgid = sNPCRewardCfg.awardCfgid;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 126 */     if (sNPCRewardCfg.awardType == 3)
/*     */     {
/* 128 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(awardCfgid, this.roleid, RoleInterface.getLevel(this.roleid));
/*     */       
/* 130 */       if (awardPoolResultData == null)
/*     */       {
/*     */ 
/* 133 */         Map<String, Object> extras = new HashMap();
/* 134 */         extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 135 */         onFailed(-3, extras);
/* 136 */         return false;
/*     */       }
/*     */       
/* 139 */       if (awardPoolResultData.getGold() > 0)
/*     */       {
/* 141 */         long roleMoneyCount = WantedManager.getMoneyForRole(userid, this.roleid, 2);
/* 142 */         int goldMaxCount = AwardInterface.getMoneyOwnMax(2);
/* 143 */         if (roleMoneyCount + awardPoolResultData.getGold() > goldMaxCount)
/*     */         {
/* 145 */           onFailed(-7);
/* 146 */           return false;
/*     */         }
/*     */       }
/* 149 */       AwardPoolInterface.doAward(userid, this.roleid, awardPoolResultData, new TLogArg(logReason, awardCfgid));
/*     */       
/* 151 */       SSendDefaultAwardInfo sendDefaultAwardInfo = new SSendDefaultAwardInfo();
/* 152 */       AwardInterface.fillAwardBean(sendDefaultAwardInfo.awardinfo, AwardModel.getAwardModel(awardPoolResultData));
/* 153 */       OnlineManager.getInstance().send(this.roleid, sendDefaultAwardInfo);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*     */ 
/* 162 */       if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */       {
/* 164 */         onFailed(-4);
/* 165 */         return false;
/*     */       }
/*     */       
/* 168 */       AwardReason awardReason = new AwardReason(logReason, awardCfgid);
/* 169 */       awardReason.setAwardItemBind(true);
/*     */       
/* 171 */       AwardModel awardModel = null;
/* 172 */       if (sNPCRewardCfg.awardType == 1)
/*     */       {
/* 174 */         awardModel = AwardInterface.award(awardCfgid, userid, this.roleid, true, true, awardReason);
/*     */       }
/* 176 */       else if (sNPCRewardCfg.awardType == 2)
/*     */       {
/* 178 */         awardModel = AwardInterface.awardFixAward(awardCfgid, userid, this.roleid, true, true, awardReason);
/*     */       }
/* 180 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 183 */         Map<String, Object> extras = new HashMap();
/* 184 */         extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 185 */         onFailed(-3, extras);
/* 186 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 195 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */     
/*     */ 
/* 198 */     ActivityInterface.logActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 200 */     ActivityInterface.tlogActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 203 */     SGetRewardSuccess sGetRewardSuccess = new SGetRewardSuccess();
/* 204 */     sGetRewardSuccess.activity_cfgid = this.activityCfgid;
/* 205 */     OnlineManager.getInstance().send(this.roleid, sGetRewardSuccess);
/*     */     
/* 207 */     GameServer.logger().info(String.format("[npcreward]PCGetReward.processImp@getReward success|roleid=%d|activity_cfgid=%d|awardCfgid=%d|times=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(awardCfgid), Integer.valueOf(ActivityInterface.getActivityCount(userid, this.roleid, this.activityCfgid, false)) }));
/*     */     
/*     */ 
/*     */ 
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 216 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 226 */     SGetRewardFailed rsp = new SGetRewardFailed();
/* 227 */     rsp.activity_cfgid = this.activityCfgid;
/* 228 */     rsp.retcode = retcode;
/* 229 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 231 */     StringBuffer logBuilder = new StringBuffer();
/* 232 */     logBuilder.append("[npcreward]PCGetReward.onFailed@getReward failed");
/* 233 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 234 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 235 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 237 */     if (extraParams != null)
/*     */     {
/* 239 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 241 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 245 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npcreward\main\PCGetReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */