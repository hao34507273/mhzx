/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SGetRecallFriendsBigGiftAwardSuccess;
/*     */ import mzm.gsp.grc.SRecallFriendNormalFail;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BeRecalledBackGameInfo;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class PCGetRecallFriendsBigGiftAward extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetRecallFriendsBigGiftAward(long roleId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!RecallFriendManager.checkMutexStatus(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.roleId, true))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     String userId = RoleInterface.getUserId(this.roleId);
/*  45 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  47 */     xbean.User xUser = xtable.User.get(userId);
/*  48 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*     */     
/*  50 */     BeRecalledBackGameInfo xBeRecalledBackGameInfo = xRecallFriendBackGame.getBe_recalled_back_game();
/*     */     
/*  52 */     if (xBeRecalledBackGameInfo.getBack_game_time() == 0L)
/*     */     {
/*  54 */       onGetRecallFriendsBigGiftAwardFailed(1);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (xBeRecalledBackGameInfo.getBig_gift_awarded_state())
/*     */     {
/*  60 */       onGetRecallFriendsBigGiftAwardFailed(2);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     AwardReason awardReason = new AwardReason(LogReason.RECALL_FRIEND_BIG_GIFT_AWARD);
/*     */     
/*  66 */     int awardId = SRecallFriendConsts.getInstance().BIG_GIFT_RECALL_AWARD_ID;
/*  67 */     AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, awardReason);
/*  68 */     if (awardModel == null)
/*     */     {
/*  70 */       Map<String, Object> extraMap = new HashMap();
/*  71 */       extraMap.put("award_id", Integer.valueOf(awardId));
/*     */       
/*  73 */       onGetRecallFriendsBigGiftAwardFailed(3, extraMap);
/*  74 */       return false;
/*     */     }
/*  76 */     xBeRecalledBackGameInfo.setBig_gift_awarded_state(true);
/*     */     
/*  78 */     RecallFriendManager.tlogRecallFriendBigGiftAward(userId, this.roleId, awardId, xBeRecalledBackGameInfo.getBack_game_reason());
/*     */     
/*     */ 
/*  81 */     SGetRecallFriendsBigGiftAwardSuccess getBigGiftAwardSuccess = new SGetRecallFriendsBigGiftAwardSuccess();
/*  82 */     OnlineManager.getInstance().send(this.roleId, getBigGiftAwardSuccess);
/*     */     
/*  84 */     GameServer.logger().info(String.format("[recall]PCGetRecallFriendsBigGiftAward.processImp@handle get recall friend big gift award success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/*     */ 
/*  88 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onGetRecallFriendsBigGiftAwardFailed(int ret)
/*     */   {
/*  99 */     onGetRecallFriendsBigGiftAwardFailed(ret, null);
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
/*     */   private void onGetRecallFriendsBigGiftAwardFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 112 */     StringBuilder sbLog = new StringBuilder();
/* 113 */     sbLog.append("[recall]PCGetRecallFriendsBigGiftAward.processImp@get recall friend big gift failed");
/* 114 */     sbLog.append("|ret=").append(ret);
/* 115 */     sbLog.append("|role_id=").append(this.roleId);
/* 116 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 118 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 120 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 123 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 125 */     SRecallFriendNormalFail sRecallFriendNormalFail = new SRecallFriendNormalFail();
/* 126 */     sRecallFriendNormalFail.result = ret;
/*     */     
/* 128 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sRecallFriendNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetRecallFriendsBigGiftAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */