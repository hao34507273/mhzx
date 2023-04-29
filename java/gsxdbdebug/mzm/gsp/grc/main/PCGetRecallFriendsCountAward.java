/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SGetRecallFriendsCountAwardSuccess;
/*     */ import mzm.gsp.grc.SRecallFriendNormalFail;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendNumAwardCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class PCGetRecallFriendsCountAward extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int awardSerialNo;
/*     */   
/*     */   public PCGetRecallFriendsCountAward(long roleId, int awardSerialNo)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.awardSerialNo = awardSerialNo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.awardSerialNo <= 0)
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!RecallFriendManager.checkMutexStatus(this.roleId))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.roleId, true))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userId = RoleInterface.getUserId(this.roleId);
/*  50 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  52 */     xbean.User xUser = xtable.User.get(userId);
/*     */     
/*  54 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*  55 */     int xRecallFriendNum = xRecallFriendBackGame.getRecall_friend_num();
/*     */     
/*     */ 
/*  58 */     int xRecallFriendNumAwardSerial = xRecallFriendBackGame.getRecall_friend_num_award_serial_no();
/*     */     
/*  60 */     if (this.awardSerialNo != xRecallFriendNumAwardSerial + 1)
/*     */     {
/*  62 */       Map<String, Object> extraMap = new HashMap();
/*  63 */       extraMap.put("x_recall_friend_num_award_serial", Integer.valueOf(xRecallFriendNumAwardSerial));
/*     */       
/*  65 */       onSendRecallFriendReqFailed(6, extraMap);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     SRecallFriendNumAwardCfg sRecallFriendNumAwardCfg = SRecallFriendNumAwardCfg.get(xRecallFriendNumAwardSerial + 1);
/*  70 */     if (sRecallFriendNumAwardCfg == null)
/*     */     {
/*  72 */       Map<String, Object> extraMap = new HashMap();
/*  73 */       extraMap.put("x_recall_friend_num_award_serial", Integer.valueOf(xRecallFriendNumAwardSerial));
/*     */       
/*  75 */       onSendRecallFriendReqFailed(5, extraMap);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     int needRecallFriendNum = sRecallFriendNumAwardCfg.recallFriendNum;
/*     */     
/*  81 */     if (needRecallFriendNum > xRecallFriendNum)
/*     */     {
/*  83 */       Map<String, Object> extraMap = new HashMap();
/*  84 */       extraMap.put("x_recall_friend_num_award_serial", Integer.valueOf(xRecallFriendNumAwardSerial));
/*  85 */       extraMap.put("need_recall_friend_num", Integer.valueOf(needRecallFriendNum));
/*  86 */       extraMap.put("x_recall_friend_num", Integer.valueOf(xRecallFriendNum));
/*     */       
/*  88 */       onSendRecallFriendReqFailed(4, extraMap);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     AwardReason awardReason = new AwardReason(LogReason.RECALL_FRIEND_NUM_AWARD);
/*     */     
/*  94 */     int awardId = sRecallFriendNumAwardCfg.awardId;
/*  95 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, awardReason);
/*  96 */     if (awardModel == null)
/*     */     {
/*  98 */       Map<String, Object> extraMap = new HashMap();
/*  99 */       extraMap.put("award_id", Integer.valueOf(awardId));
/*     */       
/* 101 */       onSendRecallFriendReqFailed(7, extraMap);
/*     */       
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     xRecallFriendBackGame.setRecall_friend_num_award_serial_no(this.awardSerialNo);
/*     */     
/* 108 */     RecallFriendManager.tlogRecallFriendNumAward(userId, this.roleId, this.awardSerialNo, xRecallFriendNum, awardId);
/*     */     
/* 110 */     SGetRecallFriendsCountAwardSuccess sGetRecallFriendsCountAwardSuccess = new SGetRecallFriendsCountAwardSuccess();
/* 111 */     sGetRecallFriendsCountAwardSuccess.award_serial_no = this.awardSerialNo;
/*     */     
/* 113 */     OnlineManager.getInstance().send(this.roleId, sGetRecallFriendsCountAwardSuccess);
/*     */     
/* 115 */     GameServer.logger().info(String.format("[recall]PCGetRecallFriendCountAward.processImp@handle get recall friend num award success|role_id=%d|user_id=%s|award_serial_no=%d", new Object[] { Long.valueOf(this.roleId), userId, Integer.valueOf(this.awardSerialNo) }));
/*     */     
/*     */ 
/*     */ 
/* 119 */     return true;
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
/*     */   private void onSendRecallFriendReqFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 132 */     StringBuilder sbLog = new StringBuilder();
/* 133 */     sbLog.append("[recall]PCGetRecallFriendsCountAward.processImp@get recall friend count award failed");
/* 134 */     sbLog.append("|ret=").append(ret);
/* 135 */     sbLog.append("|award_serial_no=").append(this.awardSerialNo);
/* 136 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 138 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 140 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 143 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 145 */     SRecallFriendNormalFail sRecallFriendNormalFail = new SRecallFriendNormalFail();
/* 146 */     sRecallFriendNormalFail.result = ret;
/*     */     
/* 148 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sRecallFriendNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetRecallFriendsCountAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */