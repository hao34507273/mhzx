/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.ReceiverGiftInfo;
/*     */ import mzm.gsp.qingfu.SGiftError;
/*     */ import mzm.gsp.qingfu.SGiftRsp;
/*     */ import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;
/*     */ import mzm.gsp.qingfu.confbean.TimeLimitGiftBagConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.main.WantedManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TimeLimitGiftInfo;
/*     */ import xbean.TimeLimitGiftP2PInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGiftReq extends LogicProcedure
/*     */ {
/*     */   final long senderRoleId;
/*     */   final int activityId;
/*     */   final int giftBagCfgId;
/*     */   final long receiverRoleId;
/*     */   
/*     */   public PCGiftReq(long roleId, int activityId, int giftBagCfgId, long receiverId)
/*     */   {
/*  45 */     this.senderRoleId = roleId;
/*  46 */     this.activityId = activityId;
/*  47 */     this.giftBagCfgId = giftBagCfgId;
/*  48 */     this.receiverRoleId = receiverId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     if ((this.activityId <= 0) || (this.giftBagCfgId <= 0) || (this.receiverRoleId <= 0L) || (this.senderRoleId == this.receiverRoleId))
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     if (!OpenInterface.getOpenStatus(585))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.senderRoleId, 2202, true))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     STimeLimitGiftBagCfg sTimeLimitGiftBagCfg = STimeLimitGiftBagCfg.get(this.giftBagCfgId);
/*  73 */     if (sTimeLimitGiftBagCfg == null)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@cfg null|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId) }));
/*     */       
/*     */ 
/*  78 */       return false;
/*     */     }
/*  80 */     if (sTimeLimitGiftBagCfg.activityId != this.activityId)
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@activityId wrong|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId) }));
/*     */       
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (sTimeLimitGiftBagCfg.canGift == 0)
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     Map<Long, String> roleId2userId = new HashMap();
/*  94 */     String senderUserId = RoleInterface.getUserId(this.senderRoleId);
/*  95 */     String receiverUserId = RoleInterface.getUserId(this.receiverRoleId);
/*  96 */     roleId2userId.put(Long.valueOf(this.senderRoleId), senderUserId);
/*  97 */     roleId2userId.put(Long.valueOf(this.receiverRoleId), receiverUserId);
/*     */     
/*     */ 
/* 100 */     lock(User.getTable(), roleId2userId.values());
/* 101 */     lock(Basic.getTable(), roleId2userId.keySet());
/*     */     
/* 103 */     SGiftError sGiftError = new SGiftError();
/* 104 */     sGiftError.activity_id = this.activityId;
/* 105 */     sGiftError.gift_bag_cfg_id = this.giftBagCfgId;
/* 106 */     sGiftError.receiver_id = this.receiverRoleId;
/*     */     
/*     */ 
/* 109 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(senderUserId, this.senderRoleId, this.activityId);
/*     */     
/* 111 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 113 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@role cannot join activity|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d|reasonValue=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 117 */       return false;
/*     */     }
/* 119 */     activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(receiverUserId, this.receiverRoleId, this.activityId);
/*     */     
/* 121 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 123 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@role cannot join activity|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d|reasonValue=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     TimeLimitGiftInfo xSenderTimeLimitGiftInfo = TimeLimitGiftActivityManager.getTimeLimitGiftInfoCreateIfNotExist(this.senderRoleId, this.activityId, this.giftBagCfgId);
/*     */     
/* 132 */     TimeLimitGiftInfo xReceiverTimeLimitGiftInfo = TimeLimitGiftActivityManager.getTimeLimitGiftInfoCreateIfNotExist(this.receiverRoleId, this.activityId, this.giftBagCfgId);
/*     */     
/*     */ 
/*     */ 
/* 136 */     TimeLimitGiftP2PInfo xTimeLimitGiftP2PInfo = (TimeLimitGiftP2PInfo)xSenderTimeLimitGiftInfo.getReceiver_info().get(Long.valueOf(this.receiverRoleId));
/* 137 */     if (xTimeLimitGiftP2PInfo == null)
/*     */     {
/* 139 */       xTimeLimitGiftP2PInfo = xbean.Pod.newTimeLimitGiftP2PInfo();
/* 140 */       xSenderTimeLimitGiftInfo.getReceiver_info().put(Long.valueOf(this.receiverRoleId), xTimeLimitGiftP2PInfo);
/*     */     }
/* 142 */     if (xTimeLimitGiftP2PInfo.getGift_count() >= sTimeLimitGiftBagCfg.p2pCountMax)
/*     */     {
/* 144 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 3, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 146 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 147 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@p2p count reach max|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d|giftCount=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId), Integer.valueOf(xTimeLimitGiftP2PInfo.getGift_count()) }));
/*     */       
/*     */ 
/*     */ 
/* 151 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 155 */     if (xSenderTimeLimitGiftInfo.getSend_count() >= sTimeLimitGiftBagCfg.sendCountMax)
/*     */     {
/* 157 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 2, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 159 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 160 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@sender send count reach max|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d|sendCount=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId), Integer.valueOf(xSenderTimeLimitGiftInfo.getSend_count()) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 168 */     if (xReceiverTimeLimitGiftInfo.getReceive_count() >= sTimeLimitGiftBagCfg.receiveCountMax)
/*     */     {
/* 170 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 1, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 172 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 173 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@receiver receive count reach max|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d|receiveCount=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId), Integer.valueOf(xReceiverTimeLimitGiftInfo.getReceive_count()) }));
/*     */       
/*     */ 
/*     */ 
/* 177 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 181 */     int intimacy = FriendInterface.getRelationValue(this.senderRoleId, this.receiverRoleId, true);
/* 182 */     if (intimacy < sTimeLimitGiftBagCfg.friendIntimacyMin)
/*     */     {
/* 184 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 4, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 186 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 187 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@intimacy too low|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d|intimacy=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId), Integer.valueOf(intimacy) }));
/*     */       
/*     */ 
/* 190 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 194 */     boolean ret = WantedManager.cutMoney(senderUserId, this.senderRoleId, LogReason.TIME_LIMIT_GIFT_ACTIVITY_GIFT_TO_FRIEND, sTimeLimitGiftBagCfg.id, sTimeLimitGiftBagCfg.giftMoneyType, sTimeLimitGiftBagCfg.giftPrice, CostType.COST_UN_BIND_TIME_LIMIT_GIFT_BAG_GIFT_TO_FRIEND);
/*     */     
/*     */ 
/* 197 */     if (!ret)
/*     */     {
/* 199 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 6, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 201 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 202 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@cut money fail|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId) }));
/*     */       
/*     */ 
/* 205 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 209 */     AwardReason awardReason = new AwardReason(LogReason.TIME_LIMIT_GIFT_ACTIVITY_GIFT_TO_FRIEND, sTimeLimitGiftBagCfg.id);
/*     */     
/* 211 */     awardReason.setAwardItemBind(sTimeLimitGiftBagCfg.isReceiveGiftBind == 1);
/* 212 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.getRoleFixAwardModel(sTimeLimitGiftBagCfg.rewardId, this.receiverRoleId, awardReason);
/*     */     
/* 214 */     MailAttachment mailAttachment = AwardInterface.getMailAttachmentBy(awardModel, sTimeLimitGiftBagCfg.isReceiveGiftBind == 1);
/*     */     
/* 216 */     if (mailAttachment == null)
/*     */     {
/* 218 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 5, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 220 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 221 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@mail attachment is null|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId) }));
/*     */       
/*     */ 
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     List<String> mailContentArgList = new ArrayList();
/* 228 */     mailContentArgList.add(RoleInterface.getName(this.senderRoleId));
/* 229 */     mailContentArgList.add(String.valueOf(sTimeLimitGiftBagCfg.originalPrice));
/* 230 */     mailContentArgList.add(getMoneyNameFromMoneyType(sTimeLimitGiftBagCfg.giftMoneyType));
/* 231 */     mailContentArgList.add(sTimeLimitGiftBagCfg.desc);
/*     */     
/* 233 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.receiverRoleId, TimeLimitGiftBagConsts.getInstance().GIFT_MAIL_ID, new ArrayList(), mailContentArgList, mailAttachment, new TLogArg(LogReason.TIME_LIMIT_GIFT_ACTIVITY_GIFT_TO_FRIEND, sTimeLimitGiftBagCfg.id));
/*     */     
/*     */ 
/* 236 */     if (!sendMailRet.isOK())
/*     */     {
/* 238 */       fillGiftError(sTimeLimitGiftBagCfg, sGiftError, 5, xSenderTimeLimitGiftInfo, xReceiverTimeLimitGiftInfo, xTimeLimitGiftP2PInfo);
/*     */       
/* 240 */       OnlineManager.getInstance().sendAtOnce(this.senderRoleId, sGiftError);
/* 241 */       GameServer.logger().error(String.format("[time_limit_gift_to_friend]PCGiftReq.processImp@send mail fail|senderRoleId=%d|receiverRoleId=%d|activityId=%d|giftBagCfgId=%d", new Object[] { Long.valueOf(this.senderRoleId), Long.valueOf(this.receiverRoleId), Integer.valueOf(this.activityId), Integer.valueOf(this.giftBagCfgId) }));
/*     */       
/*     */ 
/* 244 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 248 */     xSenderTimeLimitGiftInfo.setSend_count(xSenderTimeLimitGiftInfo.getSend_count() + 1);
/* 249 */     xTimeLimitGiftP2PInfo.setGift_count(xTimeLimitGiftP2PInfo.getGift_count() + 1);
/* 250 */     xReceiverTimeLimitGiftInfo.setReceive_count(xReceiverTimeLimitGiftInfo.getReceive_count() + 1);
/*     */     
/* 252 */     SGiftRsp sGiftRsp = new SGiftRsp();
/* 253 */     sGiftRsp.activity_id = this.activityId;
/* 254 */     sGiftRsp.gift_bag_cfg_id = this.giftBagCfgId;
/* 255 */     sGiftRsp.receiver_id = this.receiverRoleId;
/*     */     
/* 257 */     sGiftRsp.send_available = (sTimeLimitGiftBagCfg.sendCountMax - xSenderTimeLimitGiftInfo.getSend_count());
/* 258 */     sGiftRsp.send_available = (sGiftRsp.send_available < 0 ? 0 : sGiftRsp.send_available);
/* 259 */     sGiftRsp.receiver_gift_info.receive_available = (sTimeLimitGiftBagCfg.receiveCountMax - xReceiverTimeLimitGiftInfo.getReceive_count());
/*     */     
/* 261 */     sGiftRsp.receiver_gift_info.receive_available = (sGiftRsp.receiver_gift_info.receive_available < 0 ? 0 : sGiftRsp.receiver_gift_info.receive_available);
/*     */     
/* 263 */     sGiftRsp.receiver_gift_info.sender2receiver_count = xTimeLimitGiftP2PInfo.getGift_count();
/*     */     
/* 265 */     OnlineManager.getInstance().send(this.senderRoleId, sGiftRsp);
/*     */     
/*     */ 
/* 268 */     tLogGift(senderUserId, xSenderTimeLimitGiftInfo.getSend_count(), xReceiverTimeLimitGiftInfo.getReceive_count(), xTimeLimitGiftP2PInfo.getGift_count());
/*     */     
/*     */ 
/* 271 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void fillGiftError(STimeLimitGiftBagCfg sTimeLimitGiftBagCfg, SGiftError sGiftError, int errorCode, TimeLimitGiftInfo xSenderTimeLimitGiftInfo, TimeLimitGiftInfo xReceiverTimeLimitGiftInfo, TimeLimitGiftP2PInfo xTimeLimitGiftP2PInfo)
/*     */   {
/* 278 */     sGiftError.code = errorCode;
/* 279 */     sGiftError.send_available = (sTimeLimitGiftBagCfg.sendCountMax - xSenderTimeLimitGiftInfo.getSend_count());
/* 280 */     sGiftError.send_available = (sGiftError.send_available < 0 ? 0 : sGiftError.send_available);
/* 281 */     sGiftError.receiver_gift_info.receive_available = (sTimeLimitGiftBagCfg.receiveCountMax - xReceiverTimeLimitGiftInfo.getReceive_count());
/*     */     
/* 283 */     sGiftError.receiver_gift_info.receive_available = (sGiftError.receiver_gift_info.receive_available < 0 ? 0 : sGiftError.receiver_gift_info.receive_available);
/*     */     
/* 285 */     sGiftError.receiver_gift_info.sender2receiver_count = xTimeLimitGiftP2PInfo.getGift_count();
/*     */   }
/*     */   
/*     */   private static String getMoneyNameFromMoneyType(int moneyType)
/*     */   {
/* 290 */     switch (moneyType)
/*     */     {
/*     */     case 1: 
/* 293 */       return "元宝";
/*     */     case 2: 
/* 295 */       return "金币";
/*     */     case 3: 
/* 297 */       return "银币";
/*     */     case 4: 
/* 299 */       return "帮贡";
/*     */     case 5: 
/* 301 */       return "金锭";
/*     */     }
/* 303 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */   private void tLogGift(String userId, int senderSendCount, int receiverReceiveCount, int p2pCount)
/*     */   {
/* 309 */     List<Object> logColumns = new ArrayList();
/*     */     
/* 311 */     logColumns.add(GameServerInfoManager.getHostIP());
/* 312 */     logColumns.add(userId);
/* 313 */     logColumns.add(Long.valueOf(this.senderRoleId));
/* 314 */     logColumns.add(Integer.valueOf(RoleInterface.getLevel(this.senderRoleId)));
/*     */     
/* 316 */     logColumns.add(Integer.valueOf(this.activityId));
/* 317 */     logColumns.add(Integer.valueOf(this.giftBagCfgId));
/* 318 */     logColumns.add(Long.valueOf(this.receiverRoleId));
/* 319 */     logColumns.add(Integer.valueOf(senderSendCount));
/* 320 */     logColumns.add(Integer.valueOf(receiverReceiveCount));
/* 321 */     logColumns.add(Integer.valueOf(p2pCount));
/*     */     
/* 323 */     TLogManager.getInstance().addLog(userId, "TimeLimitGiftBagToFriendLog", logColumns.toArray());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */