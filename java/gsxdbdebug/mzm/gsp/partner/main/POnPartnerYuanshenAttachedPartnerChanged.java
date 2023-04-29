/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import mzm.gsp.partneryuanshen.event.AttachedPartnerChangedArg;
/*    */ import mzm.gsp.partneryuanshen.event.AttachedPartnerChangedProcedure;
/*    */ 
/*    */ public class POnPartnerYuanshenAttachedPartnerChanged
/*    */   extends AttachedPartnerChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     RolePartner rolePartner = PartnerManager.getRolePartner(((AttachedPartnerChangedArg)this.arg).roleId, true);
/* 13 */     if (((AttachedPartnerChangedArg)this.arg).oldPartnerId != 0)
/*    */     {
/* 15 */       Partner xPartner = rolePartner.getXPartner(((AttachedPartnerChangedArg)this.arg).oldPartnerId);
/* 16 */       if (xPartner == null)
/*    */       {
/* 18 */         return false;
/*    */       }
/* 20 */       PartnerManager.onSinglePartnerProChange(((AttachedPartnerChangedArg)this.arg).roleId, xPartner);
/*    */     }
/* 22 */     if (((AttachedPartnerChangedArg)this.arg).newPartnerId != 0)
/*    */     {
/* 24 */       Partner xPartner = rolePartner.getXPartner(((AttachedPartnerChangedArg)this.arg).newPartnerId);
/* 25 */       if (xPartner == null)
/*    */       {
/* 27 */         return false;
/*    */       }
/* 29 */       PartnerManager.onSinglePartnerProChange(((AttachedPartnerChangedArg)this.arg).roleId, xPartner);
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnPartnerYuanshenAttachedPartnerChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */