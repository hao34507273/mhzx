/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PartnerEventArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   private final int partnerCfgId;
/*    */   
/*    */ 
/*    */   public PartnerEventArg(long roleId, int partnerId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.partnerCfgId = partnerId;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 19 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getPartnerCfgId() {
/* 23 */     return this.partnerCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\PartnerEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */