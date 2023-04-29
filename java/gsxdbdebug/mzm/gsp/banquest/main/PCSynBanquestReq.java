/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCSynBanquestReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCSynBanquestReq(long roleId)
/*    */   {
/* 17 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     return new PSynBanquestInfo(this.roleId).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PCSynBanquestReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */