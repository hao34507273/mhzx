/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import mzm.gsp.partneryuanshen.event.PartnerYuanshenImprovedArg;
/*    */ import mzm.gsp.partneryuanshen.event.PartnerYuanshenImprovedProcedure;
/*    */ 
/*    */ public class POnPartnerYuanshenImproved
/*    */   extends PartnerYuanshenImprovedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (((PartnerYuanshenImprovedArg)this.arg).attachedPartnerId == 0)
/*    */     {
/* 13 */       return false;
/*    */     }
/* 15 */     RolePartner rolePartner = PartnerManager.getRolePartner(((PartnerYuanshenImprovedArg)this.arg).roleId, true);
/* 16 */     Partner xPartner = rolePartner.getXPartner(((PartnerYuanshenImprovedArg)this.arg).attachedPartnerId);
/* 17 */     if (xPartner == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     PartnerManager.onSinglePartnerProChange(((PartnerYuanshenImprovedArg)this.arg).roleId, xPartner);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnPartnerYuanshenImproved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */