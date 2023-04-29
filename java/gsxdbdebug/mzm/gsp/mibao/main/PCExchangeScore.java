/*     */ package mzm.gsp.mibao.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mibao.SExchangeScoreFail;
/*     */ import mzm.gsp.mibao.SExchangeScoreSuccess;
/*     */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*     */ import mzm.gsp.mibao.confbean.SMiBaoScoreCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2MiBaoInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mibao;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCExchangeScore extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int exchangeScoreCfgId;
/*     */   private final int currentScoreNum;
/*     */   private final int exchangeTimes;
/*     */   
/*     */   public PCExchangeScore(long roleId, int exchangeScoreCfgId, int currentScoreNum, int exchangeTimes)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.exchangeScoreCfgId = exchangeScoreCfgId;
/*  36 */     this.currentScoreNum = currentScoreNum;
/*  37 */     this.exchangeTimes = exchangeTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (this.exchangeTimes <= 0)
/*     */     {
/*  45 */       onFail(2);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!MiBaoManager.isMiBaoSwitchOpen(this.roleId, "PCExchangeScore.processImp"))
/*     */     {
/*  51 */       onFail(3);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  59 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, BaoKuConsts.getInstance().miBaoActivityId);
/*     */     
/*  61 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  63 */       Map<String, Object> extraMap = new HashMap();
/*  64 */       extraMap.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/*  66 */       onFail(1, extraMap);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     long activityLimitEndTime = ActivityInterface.getActivityLimitTimeEnd(BaoKuConsts.getInstance().miBaoActivityId);
/*  71 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  72 */     if (currentTimeMillis > activityLimitEndTime)
/*     */     {
/*  74 */       Map<String, Object> extraMap = new HashMap();
/*  75 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/*  76 */       extraMap.put("end_time", Long.valueOf(activityLimitEndTime));
/*     */       
/*  78 */       onFail(4, extraMap);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 81, true, true))
/*     */     {
/*  84 */       onFail(5);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     Role2MiBaoInfo xRole2MiBaoInfo = Role2mibao.get(Long.valueOf(this.roleId));
/*  89 */     if (xRole2MiBaoInfo == null)
/*     */     {
/*  91 */       onFail(6);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     int xCurrentScore = xRole2MiBaoInfo.getCurrent_score();
/*  96 */     if (xCurrentScore != this.currentScoreNum)
/*     */     {
/*  98 */       onFail(8);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     SMiBaoScoreCfg sMiBaoScoreCfg = SMiBaoScoreCfg.get(this.exchangeScoreCfgId);
/* 103 */     if (sMiBaoScoreCfg == null)
/*     */     {
/* 105 */       onFail(7);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     int needScore = sMiBaoScoreCfg.scoreValue * this.exchangeTimes;
/* 110 */     if ((xCurrentScore < needScore) || (needScore < 0))
/*     */     {
/* 112 */       Map<String, Object> extraMap = new HashMap();
/* 113 */       extraMap.put("current_score", Integer.valueOf(xCurrentScore));
/* 114 */       extraMap.put("need_score", Integer.valueOf(needScore));
/*     */       
/* 116 */       onFail(9, extraMap);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     xRole2MiBaoInfo.setCurrent_score(xCurrentScore - needScore);
/* 121 */     AwardReason awardReason = new AwardReason(LogReason.YI_XIAN_MI_BAO_ADD_EXCHANGE_SCORE_AWARD);
/* 122 */     awardReason.setAwardItemBind(true);
/* 123 */     mzm.gsp.award.main.AwardModel awardModule = AwardInterface.awardFixAwardNTime(sMiBaoScoreCfg.awardId, this.exchangeTimes, userId, this.roleId, true, true, awardReason);
/*     */     
/* 125 */     if (awardModule == null)
/*     */     {
/* 127 */       onFail(10);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     SExchangeScoreSuccess sExchangeScoreSuccess = new SExchangeScoreSuccess();
/* 132 */     sExchangeScoreSuccess.current_score_num = xRole2MiBaoInfo.getCurrent_score();
/* 133 */     OnlineManager.getInstance().send(this.roleId, sExchangeScoreSuccess);
/*     */     
/* 135 */     MiBaoManager.tlogScoreExchangeAwarded(userId, this.roleId, needScore, sMiBaoScoreCfg.awardId, xRole2MiBaoInfo.getCurrent_score(), this.exchangeTimes);
/*     */     
/*     */ 
/* 138 */     MiBaoManager.tlogScoreChange(userId, this.roleId, xRole2MiBaoInfo.getCurrent_score());
/*     */     
/* 140 */     GameServer.logger().info(String.format("[mibao]PCExchangeScore.processImp@exchange score success|role_id=%d|exchange_score_cfg_id=%d|current_score=%d|now_score=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.exchangeScoreCfgId), Integer.valueOf(this.currentScoreNum), Integer.valueOf(xRole2MiBaoInfo.getCurrent_score()), Integer.valueOf(this.exchangeTimes) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 145 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int ret)
/*     */   {
/* 153 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 158 */     StringBuilder sbLog = new StringBuilder();
/* 159 */     sbLog.append("[mibao]PCExchangeScore.processImp@exchange mi bao score failed");
/* 160 */     sbLog.append("|ret=").append(ret);
/* 161 */     sbLog.append("|role_id=").append(this.roleId);
/* 162 */     sbLog.append("|exchange_times=").append(this.exchangeTimes);
/* 163 */     sbLog.append("|exchange_score_cfg_id=").append(this.exchangeScoreCfgId);
/* 164 */     sbLog.append("|current_score_num=").append(this.currentScoreNum);
/* 165 */     sbLog.append("|exchange_n_times=").append(this.exchangeTimes);
/*     */     
/* 167 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 169 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 171 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 174 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 176 */     SExchangeScoreFail sExchangeScoreFail = new SExchangeScoreFail();
/* 177 */     sExchangeScoreFail.result = ret;
/* 178 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sExchangeScoreFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\PCExchangeScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */