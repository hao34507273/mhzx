/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SGetRecallFriendSignAwardSuccess;
/*     */ import mzm.gsp.grc.SRecallFriendNormalFail;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BeRecalledBackGameInfo;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class PCGetRecallFriendSignAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int signDay;
/*     */   
/*     */   public PCGetRecallFriendSignAward(long roleId, int signDay)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.signDay = signDay;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if ((this.signDay <= 0) || (this.signDay > SRecallFriendSignAwardCfg.getAll().size()))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!RecallFriendManager.checkMutexStatus(this.roleId))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.roleId, true))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userId = RoleInterface.getUserId(this.roleId);
/*  52 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  54 */     xbean.User xUser = xtable.User.get(userId);
/*     */     
/*  56 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*  57 */     BeRecalledBackGameInfo xBeRecalledBackGameInfo = xRecallFriendBackGame.getBe_recalled_back_game();
/*  58 */     Set<Integer> xAwardedSignDaySet = xBeRecalledBackGameInfo.getSign_awarded_day_set();
/*  59 */     if (xAwardedSignDaySet.contains(Integer.valueOf(this.signDay)))
/*     */     {
/*  61 */       Map<String, Object> extraMap = new HashMap();
/*  62 */       extraMap.put("awarded_sign_day_set", xAwardedSignDaySet.toString());
/*     */       
/*  64 */       onGetRecallFriendSignAwardFailed(13, extraMap);
/*     */       
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     long xBackGameTime = xBeRecalledBackGameInfo.getBack_game_time();
/*     */     
/*  71 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  73 */     long deltaDay = (currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(xBackGameTime)) / 86400000L;
/*     */     
/*  75 */     if (deltaDay >= SRecallFriendSignAwardCfg.getAll().size())
/*     */     {
/*  77 */       Map<String, Object> extraMap = new HashMap();
/*  78 */       extraMap.put("delta_day", Long.valueOf(deltaDay));
/*     */       
/*  80 */       onGetRecallFriendSignAwardFailed(8, extraMap);
/*     */       
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     if (deltaDay + 1L != this.signDay)
/*     */     {
/*  88 */       Map<String, Object> extraMap = new HashMap();
/*  89 */       extraMap.put("delta_day", Long.valueOf(deltaDay));
/*     */       
/*  91 */       onGetRecallFriendSignAwardFailed(16, extraMap);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     SRecallFriendSignAwardCfg sRecallFriendSignAwardCfg = SRecallFriendSignAwardCfg.get(this.signDay);
/*  96 */     if (sRecallFriendSignAwardCfg == null)
/*     */     {
/*  98 */       onGetRecallFriendSignAwardFailed(14);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     AwardReason awardReason = new AwardReason(LogReason.RECALL_FRIEND_NUM_AWARD);
/*     */     
/* 104 */     int awardId = sRecallFriendSignAwardCfg.awardId;
/* 105 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, awardReason);
/* 106 */     if (awardModel == null)
/*     */     {
/* 108 */       Map<String, Object> extraMap = new HashMap();
/* 109 */       extraMap.put("award_id", Integer.valueOf(sRecallFriendSignAwardCfg.awardId));
/*     */       
/* 111 */       onGetRecallFriendSignAwardFailed(15, extraMap);
/*     */       
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     xAwardedSignDaySet.add(Integer.valueOf(this.signDay));
/*     */     
/* 118 */     RecallFriendManager.tlogRecallFriendSignAward(userId, this.roleId, this.signDay, awardId, xBeRecalledBackGameInfo.getBack_game_reason());
/*     */     
/*     */ 
/* 121 */     SGetRecallFriendSignAwardSuccess sGetRecallFriendSignAwardSuccess = new SGetRecallFriendSignAwardSuccess();
/* 122 */     sGetRecallFriendSignAwardSuccess.sign_day = this.signDay;
/*     */     
/* 124 */     OnlineManager.getInstance().send(this.roleId, sGetRecallFriendSignAwardSuccess);
/*     */     
/* 126 */     GameServer.logger().info(String.format("[recall]PCGetRecallFriendSignAward.processImp@handle get recall friend sign award success|role_id=%d|sign_day=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.signDay) }));
/*     */     
/*     */ 
/*     */ 
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onGetRecallFriendSignAwardFailed(int ret)
/*     */   {
/* 141 */     onGetRecallFriendSignAwardFailed(ret, null);
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
/*     */   private void onGetRecallFriendSignAwardFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 154 */     StringBuilder sbLog = new StringBuilder();
/* 155 */     sbLog.append("[recall]PCGetRecallFriendSignAward.processImp@get recall friend sign award failed");
/* 156 */     sbLog.append("|ret=").append(ret);
/* 157 */     sbLog.append("|sign_day=").append(this.signDay);
/* 158 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 160 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 162 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 165 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 167 */     SRecallFriendNormalFail sRecallFriendNormalFail = new SRecallFriendNormalFail();
/* 168 */     sRecallFriendNormalFail.result = ret;
/*     */     
/* 170 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sRecallFriendNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetRecallFriendSignAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */