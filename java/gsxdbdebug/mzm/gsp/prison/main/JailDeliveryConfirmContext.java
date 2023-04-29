/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailDeliveryConfirmContext
/*    */   implements TeamConfirmContext
/*    */ {
/*    */   final long liberatorId;
/*    */   final long savedId;
/*    */   final Octets savedName;
/*    */   
/*    */   public JailDeliveryConfirmContext(long liberatorId, long savedId, Octets savedName)
/*    */   {
/* 17 */     this.liberatorId = liberatorId;
/* 18 */     this.savedId = savedId;
/* 19 */     this.savedName = savedName;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailDeliveryConfirmContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */