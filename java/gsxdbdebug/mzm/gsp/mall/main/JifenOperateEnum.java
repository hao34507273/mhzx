/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum JifenOperateEnum
/*    */ {
/*  8 */   SUCCESS(0, "ok"), 
/*  9 */   JIFEN_NUM_ERROR(64526, "value not equal to 0"), 
/* 10 */   JIFEN_TYPE_ERROR(64525, "jifen type not exist"), 
/* 11 */   JIFEN_NUM_NOT_ENOUGH(64524, "jifen not enouth"), 
/* 12 */   JIFEN_NUM_CLEAR_FOR_AQIDIP(64523, "jifen clear for aqidip");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int ret;
/*    */   
/*    */ 
/*    */   public final String retMsg;
/*    */   
/*    */ 
/*    */ 
/*    */   private JifenOperateEnum(int ret, String retMsg)
/*    */   {
/* 26 */     this.ret = ret;
/* 27 */     this.retMsg = retMsg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\JifenOperateEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */