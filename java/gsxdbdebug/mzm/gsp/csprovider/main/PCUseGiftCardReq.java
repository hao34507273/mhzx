/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCUseGiftCardReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private String cardNumber;
/*    */   
/*    */   public PCUseGiftCardReq(long roleId, String cardNumber)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.cardNumber = cardNumber;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 350, true))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if ((this.roleId < 1L) || (this.cardNumber == null) || (7 > this.cardNumber.length()) || (this.cardNumber.length() > 15))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!this.cardNumber.matches("[a-hj-np-zA-HJ-NP-Z]{7,15}"))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     this.cardNumber = this.cardNumber.toUpperCase();
/*    */     
/* 39 */     Role role = RoleInterface.getRole(this.roleId, false);
/* 40 */     if (role == null)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     String userId = role.getUserId();
/* 46 */     Integer ip = Integer.valueOf(Onlines.getInstance().findip(userId));
/* 47 */     if (!CSProviderInterface.useGiftCard(this.roleId, userId, this.cardNumber, ip == null ? 0 : ip.intValue()))
/*    */     {
/* 49 */       GameServer.logger().error(String.format("PCUseGiftCardReq@send rpc to csp failure|roleid=%d|card_number=%s", new Object[] { Long.valueOf(this.roleId), this.cardNumber }));
/*    */       
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     GameServer.logger().info(String.format("PCUseGiftCardReq@send use rpc to csp success|roleid=%d|card_number=%s", new Object[] { Long.valueOf(this.roleId), this.cardNumber }));
/*    */     
/*    */ 
/*    */ 
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\PCUseGiftCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */