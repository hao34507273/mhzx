/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.mail.main.SendMailRet;
/*    */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BeRecalledBackGameInfo;
/*    */ import xbean.RecallFriendBackGame;
/*    */ import xbean.RecallUserInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PNotifyRecallUser
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final String activeUserId;
/*    */   private final String beRecalledUserId;
/*    */   private final long beRecalledroleId;
/*    */   
/*    */   public PNotifyRecallUser(String userId, String beRecallUserId, long beRecalledroleId)
/*    */   {
/* 37 */     this.activeUserId = userId;
/* 38 */     this.beRecalledUserId = beRecallUserId;
/* 39 */     this.beRecalledroleId = beRecalledroleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 45 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { this.activeUserId, this.beRecalledUserId }));
/*    */     
/* 47 */     xbean.User xUser = xtable.User.get(this.activeUserId);
/* 48 */     xbean.User xBeRecalledUser = xtable.User.get(this.beRecalledUserId);
/* 49 */     if ((xUser == null) || (xBeRecalledUser == null))
/*    */     {
/* 51 */       GameServer.logger().info(String.format("[recall]PNotifyRecallUser.processImp@notify recall user failed,active user info is null|active_user_id=%s|be_recalled_user_id=%s|x_user=b%|x_be_recall_user=%b", new Object[] { this.activeUserId, this.beRecalledUserId, Boolean.valueOf(xUser == null ? 1 : false), Boolean.valueOf(xBeRecalledUser == null ? 1 : false) }));
/*    */       
/*    */ 
/*    */ 
/* 55 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 59 */     xBeRecalledUser.getRecall_friend_back_game().getBe_recalled_back_game().getRecall_user_set().remove(this.activeUserId);
/*    */     
/* 61 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/* 62 */     List<RecallUserInfo> xRecallUserInfoList = xRecallFriendBackGame.getRecall_friend_list();
/*    */     
/* 64 */     Iterator<RecallUserInfo> iterator = xRecallUserInfoList.iterator();
/* 65 */     long activeRoleId = 0L;
/* 66 */     while (iterator.hasNext())
/*    */     {
/* 68 */       RecallUserInfo xRecallUserInfo = (RecallUserInfo)iterator.next();
/* 69 */       if (xRecallUserInfo.getUser_id().equals(this.beRecalledUserId))
/*    */       {
/* 71 */         activeRoleId = xRecallUserInfo.getRecall_role_id();
/* 72 */         iterator.remove();
/* 73 */         break;
/*    */       }
/*    */     }
/*    */     
/* 77 */     String roleName = RoleInterface.getName(this.beRecalledroleId);
/*    */     
/* 79 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(activeRoleId, SRecallFriendConsts.getInstance().RECALL_FRIEND_BACK_NOTIFY_MAIL_ID, new ArrayList(), Arrays.asList(new String[] { roleName }), new MailAttachment(), new TLogArg(LogReason.RECALL_FRIEND_NOTIFY_MAIL));
/*    */     
/*    */ 
/* 82 */     if (!sendMailRet.isOK())
/*    */     {
/* 84 */       GameServer.logger().error(String.format("[recall]PNotifyRecallUser.processImp@notify recall user failed,send mail failed|active_user_id=%s|be_recalled_user_id=%s|ret=%d|ret_msg=%s", new Object[] { this.activeUserId, this.beRecalledUserId, Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 89 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 93 */     RecallFriendManager.tlogRecallFriendBackGameNum(this.activeUserId, activeRoleId, this.beRecalledUserId);
/*    */     
/* 95 */     GameServer.logger().info(String.format("[recall]PNotifyRecallUser.processImp@notify recall user success|active_user_id=%s|be_recalled_user_id=%s", new Object[] { this.activeUserId, this.beRecalledUserId }));
/*    */     
/*    */ 
/*    */ 
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PNotifyRecallUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */