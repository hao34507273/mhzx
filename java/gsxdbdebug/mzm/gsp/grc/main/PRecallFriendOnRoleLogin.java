/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SSyncRecallFriendsBigGiftAwardInfo;
/*     */ import mzm.gsp.grc.SSyncRecallFriendsCountAwardInfo;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendSignAwardCfg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BeRecalledBackGameInfo;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class PRecallFriendOnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*  33 */   private long roleId = 0L;
/*  34 */   private String userId = null;
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.roleId, false))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     this.roleId = ((Long)this.arg).longValue();
/*  50 */     this.userId = RoleInterface.getUserId(this.roleId);
/*  51 */     if (this.userId == null)
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     lock(Lockeys.get(xtable.User.getTable(), this.userId));
/*     */     
/*  58 */     xbean.User xUser = xtable.User.get(this.userId);
/*  59 */     if (xUser == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     List<Long> xRoleIdList = xUser.getRoleids();
/*  65 */     lock(Role2properties.getTable(), xRoleIdList);
/*     */     
/*  67 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*     */     
/*  69 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  70 */     int todayRecallFriendNum = xRecallFriendBackGame.getRecall_friend_times_today();
/*  71 */     if (!DateTimeUtils.isInSameDay(currentTimeMillis, xRecallFriendBackGame.getLast_recall_friend_time()))
/*     */     {
/*  73 */       todayRecallFriendNum = 0;
/*     */     }
/*  75 */     int recallFriendCount = xRecallFriendBackGame.getRecall_friend_num();
/*     */     
/*     */ 
/*  78 */     SSyncRecallFriendsCountAwardInfo recallFriendsCountAwardInfo = new SSyncRecallFriendsCountAwardInfo();
/*  79 */     recallFriendsCountAwardInfo.award_serial_no = xRecallFriendBackGame.getRecall_friend_num_award_serial_no();
/*  80 */     recallFriendsCountAwardInfo.today_recall_friends_count = todayRecallFriendNum;
/*  81 */     recallFriendsCountAwardInfo.recall_friends_count = recallFriendCount;
/*     */     
/*  83 */     OnlineManager.getInstance().send(this.roleId, recallFriendsCountAwardInfo);
/*     */     
/*  85 */     BeRecalledBackGameInfo xBeRecalledBackGameInfo = xRecallFriendBackGame.getBe_recalled_back_game();
/*  86 */     Set<String> xRecallUserSet = xBeRecalledBackGameInfo.getRecall_user_set();
/*  87 */     long xBackGameTime = xBeRecalledBackGameInfo.getBack_game_time();
/*     */     
/*  89 */     long deltaDay = (currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(xBeRecalledBackGameInfo.getBack_game_time())) / 86400000L;
/*     */     
/*  91 */     if (deltaDay >= SRecallFriendSignAwardCfg.getAll().size())
/*     */     {
/*  93 */       if ((!xBeRecalledBackGameInfo.getBig_gift_awarded_state()) && (xBeRecalledBackGameInfo.getBack_game_reason() != 0))
/*     */       {
/*     */ 
/*  96 */         AwardModel awardModel = AwardInterface.getRoleFixAwardModel(SRecallFriendConsts.getInstance().BIG_GIFT_RECALL_AWARD_ID, this.roleId, new AwardReason(LogReason.RECALL_FRIEND_BIG_GIFT_AWARD));
/*     */         
/*     */ 
/*     */ 
/* 100 */         MailAttachment mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*     */         
/* 102 */         MailInterface.synBuildAndSendMail(this.roleId, SRecallFriendConsts.getInstance().RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL_ID, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.RECALL_FRIEND_BIG_GIFT_COMPENSATE_MAIL));
/*     */         
/*     */ 
/*     */ 
/* 106 */         xBeRecalledBackGameInfo.setBig_gift_awarded_state(true);
/*     */       }
/*     */       
/* 109 */       if (xBeRecalledBackGameInfo.getBack_game_reason() != 0)
/*     */       {
/* 111 */         xBeRecalledBackGameInfo.setBack_game_reason(0);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 116 */     if ((xBackGameTime == 0L) && (!xRecallUserSet.isEmpty()))
/*     */     {
/* 118 */       xBeRecalledBackGameInfo.setBack_game_time(currentTimeMillis);
/* 119 */       xBeRecalledBackGameInfo.setBack_game_reason(1);
/*     */       
/* 121 */       deltaDay = (currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(xBeRecalledBackGameInfo.getBack_game_time())) / 86400000L;
/*     */       
/*     */ 
/* 124 */       RecallFriendManager.tlogRecallFriendBackGame(this.userId, this.roleId, 1);
/*     */     }
/*     */     
/*     */ 
/* 128 */     if (xBeRecalledBackGameInfo.getBack_game_reason() == 0)
/*     */     {
/* 130 */       boolean checkRecallCondtion = RecallFriendManager.checkRecallCondition(xUser, false);
/* 131 */       if (checkRecallCondtion)
/*     */       {
/* 133 */         xBeRecalledBackGameInfo.setBack_game_time(currentTimeMillis);
/* 134 */         xBeRecalledBackGameInfo.setBack_game_reason(2);
/* 135 */         xBeRecalledBackGameInfo.setBig_gift_awarded_state(false);
/* 136 */         xBeRecalledBackGameInfo.getSign_awarded_day_set().clear();
/* 137 */         deltaDay = (currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(xBeRecalledBackGameInfo.getBack_game_time())) / 86400000L;
/*     */         
/*     */ 
/* 140 */         RecallFriendManager.tlogRecallFriendBackGame(this.userId, this.roleId, 2);
/*     */       }
/*     */     }
/*     */     
/* 144 */     for (String xActiveUserId : xRecallUserSet)
/*     */     {
/*     */ 
/* 147 */       new PNotifyRecallUser(xActiveUserId, this.userId, this.roleId).execute();
/*     */       
/* 149 */       GameServer.logger().info(String.format("[recall]POnRoleLoginForRecallFriend.processImp@trigger recall|user_id=%s|role_id=%d|active_recall_user_set=%s", new Object[] { this.userId, Long.valueOf(this.roleId), xRecallUserSet.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 155 */     if (deltaDay >= SRecallFriendSignAwardCfg.getAll().size())
/*     */     {
/* 157 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 161 */     SSyncRecallFriendsBigGiftAwardInfo recallBigGiftAwardInfo = new SSyncRecallFriendsBigGiftAwardInfo();
/* 162 */     int bigGiftAwardState = xBeRecalledBackGameInfo.getBig_gift_awarded_state() ? 1 : 0;
/*     */     
/* 164 */     recallBigGiftAwardInfo.big_gift_awarded_state = bigGiftAwardState;
/*     */     
/* 166 */     OnlineManager.getInstance().send(this.roleId, recallBigGiftAwardInfo);
/*     */     
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PRecallFriendOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */