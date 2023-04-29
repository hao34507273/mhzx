/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SSyncRecallFriendsBigGiftAwardInfo;
/*     */ import mzm.gsp.grc.SSyncRecallFriendsCountAwardInfo;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.BeRecalledBackGameInfo;
/*     */ import xbean.RecallFriendBackGame;
/*     */ 
/*     */ public class PRecallFriendOnRoleProtectLogin extends PlayerLoginProtectProcedure
/*     */ {
/*  26 */   private long roleId = 0L;
/*  27 */   private String userId = null;
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.roleId, false))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     this.roleId = ((Long)this.arg).longValue();
/*  43 */     this.userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  44 */     if (this.userId == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     xbean.User xUser = xtable.User.get(this.userId);
/*  50 */     if (xUser == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*     */     
/*  57 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  58 */     int todayRecallFriendNum = xRecallFriendBackGame.getRecall_friend_times_today();
/*  59 */     if (!DateTimeUtils.isInSameDay(currentTimeMillis, xRecallFriendBackGame.getLast_recall_friend_time()))
/*     */     {
/*  61 */       todayRecallFriendNum = 0;
/*     */     }
/*  63 */     int recallFriendCount = xRecallFriendBackGame.getRecall_friend_num();
/*     */     
/*     */ 
/*  66 */     SSyncRecallFriendsCountAwardInfo recallFriendsCountAwardInfo = new SSyncRecallFriendsCountAwardInfo();
/*  67 */     recallFriendsCountAwardInfo.award_serial_no = xRecallFriendBackGame.getRecall_friend_num_award_serial_no();
/*  68 */     recallFriendsCountAwardInfo.today_recall_friends_count = todayRecallFriendNum;
/*  69 */     recallFriendsCountAwardInfo.recall_friends_count = recallFriendCount;
/*     */     
/*  71 */     OnlineManager.getInstance().send(this.roleId, recallFriendsCountAwardInfo);
/*     */     
/*     */ 
/*  74 */     BeRecalledBackGameInfo xBeRecalledBackGameInfo = xRecallFriendBackGame.getBe_recalled_back_game();
/*  75 */     long xBackGameTime = xBeRecalledBackGameInfo.getBack_game_time();
/*     */     
/*  77 */     xBackGameTime = xBeRecalledBackGameInfo.getBack_game_time();
/*  78 */     long deltaDay = (currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(xBackGameTime)) / 86400000L;
/*     */     
/*     */ 
/*  81 */     Set<String> xRecallUserSet = xBeRecalledBackGameInfo.getRecall_user_set();
/*  82 */     for (String xActiveUserId : xRecallUserSet)
/*     */     {
/*     */ 
/*  85 */       new PNotifyRecallUser(xActiveUserId, this.userId, this.roleId).execute();
/*     */       
/*  87 */       GameServer.logger().info(String.format("[recall]POnRoleLoginForRecallFriend.processImp@trigger recall|user_id=%s|role_id=%d|active_recall_user_set=%s", new Object[] { this.userId, Long.valueOf(this.roleId), xRecallUserSet.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  93 */     if (deltaDay >= SRecallFriendSignAwardCfg.getAll().size())
/*     */     {
/*  95 */       if ((!xBeRecalledBackGameInfo.getBig_gift_awarded_state()) && (xBeRecalledBackGameInfo.getBack_game_reason() != 0))
/*     */       {
/*     */ 
/*  98 */         mzm.gsp.award.main.AwardModel awardModel = AwardInterface.getRoleFixAwardModel(SRecallFriendConsts.getInstance().BIG_GIFT_RECALL_AWARD_ID, this.roleId, new AwardReason(LogReason.RECALL_FRIEND_BIG_GIFT_AWARD));
/*     */         
/*     */ 
/*     */ 
/* 102 */         MailAttachment mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*     */         
/* 104 */         MailInterface.synBuildAndSendMail(this.roleId, SRecallFriendConsts.getInstance().RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL));
/*     */         
/*     */ 
/*     */ 
/* 108 */         xBeRecalledBackGameInfo.setBig_gift_awarded_state(true);
/*     */       }
/*     */       
/* 111 */       if (xBeRecalledBackGameInfo.getBack_game_reason() != 0)
/*     */       {
/* 113 */         xBeRecalledBackGameInfo.setBack_game_reason(0);
/*     */       }
/* 115 */       return true;
/*     */     }
/*     */     
/* 118 */     SSyncRecallFriendsBigGiftAwardInfo recallBigGiftAwardInfo = new SSyncRecallFriendsBigGiftAwardInfo();
/* 119 */     int bigGiftAwardState = xBeRecalledBackGameInfo.getBig_gift_awarded_state() ? 1 : 0;
/*     */     
/* 121 */     recallBigGiftAwardInfo.big_gift_awarded_state = bigGiftAwardState;
/*     */     
/* 123 */     OnlineManager.getInstance().send(this.roleId, recallBigGiftAwardInfo);
/*     */     
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PRecallFriendOnRoleProtectLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */