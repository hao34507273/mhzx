/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginOfferSystemAward
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     return ItemInterface.offerSystemAwards(((Long)this.arg).longValue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginOfferSystemAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */