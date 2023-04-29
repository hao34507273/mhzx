/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RoleExpUpdateRet
/*    */ {
/*  7 */   SUCCESS(0, "ok"), 
/*  8 */   EXP_NUM_SIGN_ERROR(64536, "value not equal 0"), 
/*  9 */   ROLE_LEVEL_HAS_REACH_TOP_LIMIT_ERROR(64535, "role level reach top limit"), 
/* 10 */   EXP_NUM_CUT_NOT_ENOUGH_ERROR(64534, "role exp not enough"), 
/* 11 */   EXP_NUM_CLEAR_AQIDIP_ERROR(64533, "role exp clear for aqidip");
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
/*    */   private RoleExpUpdateRet(int ret, String retMsg)
/*    */   {
/* 25 */     this.ret = ret;
/* 26 */     this.retMsg = retMsg;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleExpUpdateRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */