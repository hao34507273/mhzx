/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ public class ConfirmJoinMatchTransferReqXidWrapper extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final MatchContext context;
/*    */   
/*    */   public ConfirmJoinMatchTransferReqXidWrapper(DataTransferReq proto, MatchContext context)
/*    */   {
/* 12 */     super(proto);
/*    */     
/* 14 */     this.context = context;
/*    */   }
/*    */   
/*    */   public final MatchContext getContext()
/*    */   {
/* 19 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ConfirmJoinMatchTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */