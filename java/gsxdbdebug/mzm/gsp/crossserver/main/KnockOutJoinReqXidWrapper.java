/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ public class KnockOutJoinReqXidWrapper extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final KnockOutContext context;
/*    */   
/*    */   public KnockOutJoinReqXidWrapper(DataTransferReq proto, KnockOutContext context)
/*    */   {
/* 12 */     super(proto);
/*    */     
/* 14 */     this.context = context;
/*    */   }
/*    */   
/*    */   public final KnockOutContext getContext()
/*    */   {
/* 19 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutJoinReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */