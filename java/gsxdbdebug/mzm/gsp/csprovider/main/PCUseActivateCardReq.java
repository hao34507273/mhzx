/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import gnet.link.Dispatch;
/*    */ import gnet.link.Onlines;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.csprovider.CUseActivateCardReq;
/*    */ import mzm.gsp.csprovider.SUseActivateCardFailed;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCUseActivateCardReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private xio.Protocol protocol;
/*    */   private final String userId;
/*    */   private final String cardNumber;
/*    */   
/*    */   public PCUseActivateCardReq(CUseActivateCardReq protocol)
/*    */   {
/* 21 */     this.protocol = protocol;
/* 22 */     this.userId = ((Dispatch)protocol.getContext()).userid.getString("UTF-8");
/* 23 */     this.cardNumber = protocol.cardnumber;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if ((this.userId == null) || (this.userId.isEmpty()) || (this.cardNumber == null) || (this.cardNumber.length() != 13) || (!this.cardNumber.matches("[a-hj-np-zA-HJ-NP-Z]{13}")))
/*    */     {
/*    */ 
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     if (!CSProviderInterface.getRequireActivateUser())
/*    */     {
/* 41 */       int reason = 0;
/* 42 */       SUseActivateCardFailed res = new SUseActivateCardFailed();
/* 43 */       res.reason = 0;
/* 44 */       Onlines.getInstance().sendResponse(this.protocol, res);
/*    */       
/* 46 */       GameServer.logger().info(String.format("PCUseActivateCardReq@not require activate user:userid=%s|cardnumber=%s|reason=%d", new Object[] { this.userId, this.cardNumber, Integer.valueOf(0) }));
/*    */       
/*    */ 
/*    */ 
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     xbean.User xUser = xtable.User.get(this.userId);
/* 54 */     if ((xUser != null) && (xUser.getActivated()))
/*    */     {
/* 56 */       int reason = 4;
/* 57 */       SUseActivateCardFailed res = new SUseActivateCardFailed();
/* 58 */       res.reason = 4;
/* 59 */       Onlines.getInstance().sendResponse(this.protocol, res);
/*    */       
/* 61 */       GameServer.logger().info(String.format("PCUseActivateCardReq@use activate card failed:userid=%s|cardnumber=%s|reason=%d", new Object[] { this.userId, this.cardNumber, Integer.valueOf(4) }));
/*    */       
/*    */ 
/*    */ 
/* 65 */       return false;
/*    */     }
/*    */     
/* 68 */     UseActivateCardContextManager.getInstance().addContext(this.userId, this.protocol);
/*    */     
/* 70 */     Integer ip = Integer.valueOf(Onlines.getInstance().findip(this.userId));
/* 71 */     if (!CSProviderInterface.useActivateCard(this.userId, this.cardNumber, ip == null ? 0 : ip.intValue()))
/*    */     {
/* 73 */       GameServer.logger().error(String.format("PCUseActivateCardReq@send rpc to csp failure|userid=%d|card_number=%s", new Object[] { this.userId, this.cardNumber }));
/*    */       
/*    */ 
/* 76 */       return false;
/*    */     }
/*    */     
/* 79 */     GameServer.logger().info(String.format("PCUseActivateCardReq@send rpc to csp success|userid=%s|card_number=%s", new Object[] { this.userId, this.cardNumber }));
/*    */     
/*    */ 
/* 82 */     logBI();
/* 83 */     return true;
/*    */   }
/*    */   
/*    */   private void logBI()
/*    */   {
/* 88 */     int platform = OnlineManager.getInstance().getPlatform(this.userId);
/* 89 */     String channel = mzm.gsp.role.main.RoleInterface.getChannel(this.userId);
/* 90 */     String mac = OnlineManager.getInstance().getMac(this.userId);
/* 91 */     String logStr = String.format("%d|%s|%s|%s|%s", new Object[] { Integer.valueOf(platform), channel, mac, this.userId, this.cardNumber });
/* 92 */     LogManager.getInstance().addLog("useractive", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCUseActivateCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */