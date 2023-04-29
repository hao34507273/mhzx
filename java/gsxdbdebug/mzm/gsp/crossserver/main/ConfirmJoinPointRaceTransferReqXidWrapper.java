/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ public class ConfirmJoinPointRaceTransferReqXidWrapper extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final PointRaceContext context;
/*    */   
/*    */   public ConfirmJoinPointRaceTransferReqXidWrapper(DataTransferReq proto, PointRaceContext context)
/*    */   {
/* 12 */     super(proto);
/*    */     
/* 14 */     this.context = context;
/*    */   }
/*    */   
/*    */   public final PointRaceContext getContext()
/*    */   {
/* 19 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\ConfirmJoinPointRaceTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */