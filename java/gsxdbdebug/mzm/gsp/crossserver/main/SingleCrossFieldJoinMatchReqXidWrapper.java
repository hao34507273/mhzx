/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldJoinMatchReqXidWrapper
/*    */   extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final SingleCrossFieldContext context;
/*    */   
/*    */   public SingleCrossFieldJoinMatchReqXidWrapper(DataTransferReq proto, SingleCrossFieldContext context)
/*    */   {
/* 16 */     super(proto);
/* 17 */     this.context = context;
/*    */   }
/*    */   
/*    */   public final SingleCrossFieldContext getContext()
/*    */   {
/* 22 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldJoinMatchReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */