/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ public class RoamRoleDataTransferReqXidWrapper extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final RoamContext context;
/*    */   
/*    */   public RoamRoleDataTransferReqXidWrapper(DataTransferReq proto, RoamContext context)
/*    */   {
/* 12 */     super(proto);
/* 13 */     this.context = context;
/*    */   }
/*    */   
/*    */   public final RoamContext getContext()
/*    */   {
/* 18 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamRoleDataTransferReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */