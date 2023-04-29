/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.partner.confbean.PartnerConstants;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCRecoveryYuanShen
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int partnerId;
/*     */   
/*     */   public PCRecoveryYuanShen(long roleId, int partnerId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.partnerId = partnerId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/*  38 */     RolePartner rolePartner = PartnerManager.getRolePartner(this.roleId, true);
/*  39 */     Partner xPartner = rolePartner.getXPartner(this.partnerId);
/*  40 */     if (xPartner == null)
/*     */     {
/*  42 */       GameServer.logger().error(String.format("[partner]PCRecoveryYuanShen.processImp@ not own this partner!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.partnerId) }));
/*     */       
/*     */ 
/*  45 */       return false;
/*     */     }
/*  47 */     if (!offerDiscountItem(xPartner))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     clearYuanLv(xPartner);
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   private boolean offerDiscountItem(Partner xPartner)
/*     */   {
/*  57 */     int alPayPrice = PartnerManager.getItemNumToLevel(xPartner.getPartnerCfg().getCostId(), xPartner.getSubYuanLevel());
/*  58 */     if (alPayPrice <= 0)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[partner]PCRecoveryYuanShen.processImp@ get alPayPrice error!|roleId=%d|partnerId=%d|alPayPrice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.partnerId), Integer.valueOf(alPayPrice) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*  66 */     int disCount = alPayPrice * getDisCountRet() / 10000;
/*  67 */     int itemId = xPartner.getPartnerCfg().getCostItemId();
/*     */     
/*  69 */     if (disCount <= 0)
/*     */     {
/*  71 */       return true;
/*     */     }
/*     */     
/*  74 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*  75 */     mailAttachment.addItem(itemId, disCount);
/*  76 */     TLogArg logArg = new TLogArg(LogReason.PARTNER_YUANSHEN_CLEAR_ADD);
/*     */     
/*  78 */     List<String> contentArgs = new ArrayList();
/*  79 */     contentArgs.add(xPartner.getPartnerCfg().getName());
/*  80 */     SendMailRet res = MailInterface.synBuildAndSendMail(this.roleId, getMailId(), new ArrayList(), contentArgs, mailAttachment, logArg);
/*     */     
/*  82 */     if (!res.isOK())
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[partner]PCRecoveryYuanShen.processImp@ get alPayPrice error!|roleId=%d|partnerId=%d|alPayPrice=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.partnerId), Integer.valueOf(alPayPrice), Integer.valueOf(itemId) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*  90 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void clearYuanLv(Partner xPartner)
/*     */   {
/* 100 */     xPartner.clearYuanLv();
/* 101 */     PartnerManager.noticSubYuanLvChange(this.roleId, xPartner);
/* 102 */     xPartner.onYuanLevelChange(false);
/* 103 */     PartnerManager.onSinglePartnerProChange(this.roleId, xPartner);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getDisCountRet()
/*     */   {
/* 113 */     return 8000;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMailId()
/*     */   {
/* 123 */     return PartnerConstants.getInstance().RECOVERY_MAIL_ID;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PCRecoveryYuanShen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */