/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.mail.main.SendMailRet;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AwardMail extends GiftAwardType
/*    */ {
/*    */   public AwardMail(String userId, long roleId, int usetType)
/*    */   {
/* 14 */     super(userId, roleId, usetType);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   boolean doAward()
/*    */   {
/* 21 */     SendMailRet sendRes = MailInterface.synBuildAndSendMail(getRoleId(), getGiftId(), null, null, new TLogArg(LogReason.COMPLETE_CLIENT_AWARD, getUseType()));
/*    */     
/* 23 */     if (!sendRes.isOK())
/*    */     {
/* 25 */       GameServer.logger().error(String.format("[gift]AwardMail.doAward@ send mail fail!|roleId=%d|usetType=%d|mailId=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(getUseType()), Integer.valueOf(getGiftId()) }));
/*    */       
/*    */ 
/* 28 */       return false;
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   int getAwardType()
/*    */   {
/* 36 */     return 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\AwardMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */