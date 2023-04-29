/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DataBetweenAuanyAndOthersReqType
/*    */ {
/*  8 */   REQ_UPDAE_LOGIN_STATE(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   REQ_NOIFY_RECHARGE(50), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   REQ_GET_BALANCE_CONFIRM(90), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   REQ_COST(100), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   REQ_COST_CONFIRM(102), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 33 */   REQ_PRESENT(105), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 38 */   REQ_PRESENT_CONFIRM(106), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 43 */   REQ_GO_ON(110), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 48 */   REQ_TRY_CHECK_NEXT_ORDER(112), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 53 */   REQ_RECHARGE_SIMULATOR(115);
/*    */   
/*    */   public final int reqType;
/*    */   
/*    */   private DataBetweenAuanyAndOthersReqType(int reqType)
/*    */   {
/* 59 */     this.reqType = reqType;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\DataBetweenAuanyAndOthersReqType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */