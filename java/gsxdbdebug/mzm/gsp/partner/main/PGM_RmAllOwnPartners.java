/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.PartnerBag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RmAllOwnPartners
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_RmAllOwnPartners(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     RolePartner rolePartner = PartnerManager.getRolePartner(this.roleId, true);
/* 25 */     PartnerBag partnerBag = rolePartner.getPartnerBag();
/* 26 */     if (partnerBag == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     partnerBag.setDefaultlineupnum(0);
/* 33 */     partnerBag.getOwnpartnerids().clear();
/* 34 */     partnerBag.getLineups().clear();
/* 35 */     partnerBag.getPartner2property().clear();
/*    */     
/*    */ 
/* 38 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 44 */         return PartnerManager.onRoleLoggin(PGM_RmAllOwnPartners.this.roleId);
/*    */       }
/*    */       
/* 47 */     }.execute();
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PGM_RmAllOwnPartners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */