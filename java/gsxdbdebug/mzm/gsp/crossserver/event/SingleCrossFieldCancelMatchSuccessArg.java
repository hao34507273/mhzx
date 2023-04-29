/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ 
/*    */ public class SingleCrossFieldCancelMatchSuccessArg
/*    */ {
/*    */   private final SingleCrossFieldContext context;
/*    */   
/*    */   public SingleCrossFieldCancelMatchSuccessArg(SingleCrossFieldContext context)
/*    */   {
/* 11 */     this.context = context;
/*    */   }
/*    */   
/*    */   public SingleCrossFieldContext getContext()
/*    */   {
/* 16 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldCancelMatchSuccessArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */