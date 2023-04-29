/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ public enum ReasonEnum
/*    */ {
/*  5 */   ACTIVITY_START(1),  GAME_SERVER_START(2),  MODULE_OPEN(3),  ACTIVITY_END(4),  MODULE_CLOSE(5);
/*    */   
/*    */   public final int value;
/*    */   
/*    */   private ReasonEnum(int value) {
/* 10 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\ReasonEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */