/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ public class RoamMatchContextTransferReqXidWrapper
/*    */   extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final MatchContext context;
/*    */   private final MatchContext opponentContext;
/*    */   
/*    */   public RoamMatchContextTransferReqXidWrapper(DataTransferReq proto, MatchContext context, MatchContext opponentContext)
/*    */   {
/* 14 */     super(proto);
/*    */     
/* 16 */     this.context = context;
/* 17 */     this.opponentContext = opponentContext;
/*    */   }
/*    */   
/*    */   public final MatchContext getContext()
/*    */   {
/* 22 */     return this.context;
/*    */   }
/*    */   
/*    */   public final MatchContext getOpponentContext()
/*    */   {
/* 27 */     return this.opponentContext;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamMatchContextTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */