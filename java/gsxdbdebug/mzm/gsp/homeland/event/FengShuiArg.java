/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ 
/*    */ public class FengShuiArg
/*    */ {
/*    */   public final long ownerRoleId;
/*    */   
/*    */   public final long partnerRoleId;
/*    */   
/*    */   public final int oldFengshui;
/*    */   public final int newFengshui;
/*    */   
/*    */   public FengShuiArg(long ownerRoleId, long partnerRoleid, int oldFengshui, int newFengshui)
/*    */   {
/* 15 */     this.ownerRoleId = ownerRoleId;
/* 16 */     this.partnerRoleId = partnerRoleid;
/* 17 */     this.oldFengshui = oldFengshui;
/* 18 */     this.newFengshui = newFengshui;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\FengShuiArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */