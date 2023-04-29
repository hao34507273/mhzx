/*    */ package csprovider;
/*    */ 
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.csprovider.main.POnUseGiftCardAck;
/*    */ import mzm.gsp.csprovider.main.POnUseGiftCardTimeout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GiftCardUse
/*    */   extends __GiftCardUse__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 19 */     long roleId = ((GiftCardUseArg)getArgument()).roleid;
/* 20 */     Role.addRoleProcedure(roleId, new POnUseGiftCardAck((GiftCardUseArg)getArgument(), (GiftCardUseRes)getResult()));
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 26 */     long roleId = ((GiftCardUseArg)getArgument()).roleid;
/* 27 */     Role.addRoleProcedure(roleId, new POnUseGiftCardTimeout((GiftCardUseArg)getArgument()));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 10012;
/*    */   }
/*    */   
/*    */   public GiftCardUse() {
/* 37 */     super.setArgument(new GiftCardUseArg());
/* 38 */     super.setResult(new GiftCardUseRes());
/*    */   }
/*    */   
/*    */   public GiftCardUse(GiftCardUseArg argument) {
/* 42 */     super.setArgument(argument);
/* 43 */     super.setResult(new GiftCardUseRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 47 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\GiftCardUse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */