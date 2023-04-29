/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum GangSystemChangeDutyActionLogEnum
/*    */ {
/*  8 */   XUETU_AUTO_BANGZHONG(-1), 
/*  9 */   LEVELDOWN_BANGZHONG(-2), 
/* 10 */   XUETU_LEVELUP_BANGZHONG(-3);
/*    */   
/*    */   public final int value;
/*    */   
/* 14 */   private GangSystemChangeDutyActionLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 19 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangSystemChangeDutyActionLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */