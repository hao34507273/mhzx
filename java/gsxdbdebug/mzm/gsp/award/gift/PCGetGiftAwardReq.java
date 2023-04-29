/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.SGetGiftAwardRep;
/*    */ import mzm.gsp.giftaward.confbean.SNewClientBagGiftCfg;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.mail.main.SendMailRet;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetGiftAwardReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int giftId;
/*    */   
/*    */   public PCGetGiftAwardReq(long roleId, int giftId)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.giftId = giftId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     boolean res = doAward();
/* 34 */     OnlineManager.getInstance().send(this.roleId, new SGetGiftAwardRep(this.giftId, (byte)(res ? 1 : 0)));
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   private boolean doAward()
/*    */   {
/* 40 */     GameServer.logger().info(String.format("[gift]PCGetGiftAwardReq.doAward@ client ask to get award!|roleId=%d|giftId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.giftId) }));
/*    */     
/* 42 */     if (!GiftManager.isNewClientOpen(this.roleId, false))
/*    */     {
/* 44 */       GameServer.logger().info(String.format("[gift]PCGetGiftAwardReq.doAward@ module close!|roleId=%d|giftId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.giftId) }));
/*    */       
/* 46 */       return false;
/*    */     }
/* 48 */     RoleGiftInfo roleGiftInfo = new RoleGiftInfo(this.roleId, true);
/* 49 */     int alGetCount = roleGiftInfo.getAwardXIdNum(RoleGiftInfo.COMPLETE_CLIENT_AWARD, this.giftId);
/* 50 */     if (alGetCount < 0)
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     if (alGetCount >= canGetAwardCount(RoleGiftInfo.COMPLETE_CLIENT_AWARD, this.giftId))
/*    */     {
/* 56 */       GameServer.logger().error(String.format("[gift]PCGetGiftAwardReq.doAward@ already awarded!|roleId=%d|alGetCount=%d|giftId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alGetCount), Integer.valueOf(this.giftId) }));
/*    */       
/*    */ 
/* 59 */       return false;
/*    */     }
/* 61 */     SNewClientBagGiftCfg cfg = SNewClientBagGiftCfg.get(this.giftId);
/* 62 */     if (cfg == null)
/*    */     {
/* 64 */       GameServer.logger().error(String.format("[gift]PCGetGiftAwardReq.doAward@ already awarded!|roleId=%d|alGetCount=%d|giftId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alGetCount), Integer.valueOf(this.giftId) }));
/*    */       
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     SendMailRet sendRes = MailInterface.synBuildAndSendMail(this.roleId, cfg.awardMailId, null, null, new TLogArg(LogReason.COMPLETE_CLIENT_AWARD));
/*    */     
/* 72 */     if (!sendRes.isOK())
/*    */     {
/* 74 */       GameServer.logger().error(String.format("[gift]PCGetGiftAwardReq.doAward@ send mail fail!|roleId=%d|alGetCount=%d|giftId=%d|mailId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alGetCount), Integer.valueOf(this.giftId), Integer.valueOf(cfg.awardMailId) }));
/*    */       
/*    */ 
/*    */ 
/* 78 */       return false;
/*    */     }
/* 80 */     int addRes = roleGiftInfo.addAwardXIdNum(RoleGiftInfo.COMPLETE_CLIENT_AWARD, this.giftId, 1);
/* 81 */     if (addRes != 1)
/*    */     {
/* 83 */       GameServer.logger().error(String.format("[gift]PCGetGiftAwardReq.doAward@ add count fail!|roleId=%d|alGetCount=%d|giftId=%d|mailId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alGetCount), Integer.valueOf(this.giftId), Integer.valueOf(cfg.awardMailId) }));
/*    */       
/*    */ 
/*    */ 
/* 87 */       return false;
/*    */     }
/* 89 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   int canGetAwardCount(int type, int awardXId)
/*    */   {
/* 95 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\PCGetGiftAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */