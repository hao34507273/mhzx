/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum MoneyOperResult
/*    */ {
/*  8 */   SUCCESS(0, "ok"), 
/*  9 */   MONEY_NUM_ERROR(64516, "money not equal to 0"), 
/* 10 */   MONEY_NUM_RM_NOT_ENOUGH(64515, "money not enough"), 
/* 11 */   MONEY_NUM_ADD_MAX(64514, "money has reach the top limit"), 
/* 12 */   MONEY_NUM_REACH_MAX_FOR_AQIDIP(64513, "money has reach the top limit for aqidip"), 
/*    */   
/* 14 */   MONEY_NUM_CLEAR_FOR_AQIDIP(64512, "money clear for aqidip"), 
/* 15 */   MONEY_TYPE_NOT_EXIST(64511, "money type not exit");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int ret;
/*    */   
/*    */ 
/*    */   public String retMsg;
/*    */   
/*    */ 
/*    */ 
/*    */   private MoneyOperResult(int ret, String retMsg)
/*    */   {
/* 29 */     this.ret = ret;
/* 30 */     this.retMsg = retMsg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\MoneyOperResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */