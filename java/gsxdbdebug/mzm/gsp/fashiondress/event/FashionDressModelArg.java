/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.gsp.fashiondress.main.FashionDressChangeReasonEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FashionDressModelArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final FashionDressChangeReasonEnum changeReason;
/*    */   
/*    */   public FashionDressModelArg(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.changeReason = FashionDressChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public FashionDressModelArg(long roleId, FashionDressChangeReasonEnum changeReason)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.changeReason = changeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\FashionDressModelArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */