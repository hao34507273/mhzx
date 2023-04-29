/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BanggongOperateEnum
/*    */ {
/*  8 */   SUCCESS(0, "ok"), 
/*  9 */   NO_GANG(64466, "role not in any bang"), 
/* 10 */   GANG_ERROR(64465, "bang not exist or role not in the bang"), 
/* 11 */   NUM_ERROR(64464, "value not equal  to 0"), 
/* 12 */   NUM_NOT_ENOUGH(64463, "bang gong not enough"), 
/* 13 */   ERROR_CLEAR_FOR_AQIDIP(64462, "bang gong clear for aqidip");
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
/*    */   private BanggongOperateEnum(int ret, String retMsg)
/*    */   {
/* 27 */     this.ret = ret;
/* 28 */     this.retMsg = retMsg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\BanggongOperateEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */