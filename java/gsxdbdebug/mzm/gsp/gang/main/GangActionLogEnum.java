/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum GangActionLogEnum
/*    */ {
/*  7 */   CREATE(1), 
/*  8 */   JIONIN(2), 
/*  9 */   SIGN_OUT(3), 
/* 10 */   MERGE(4), 
/* 11 */   KICKED(5);
/*    */   
/*    */   public final int value;
/*    */   
/* 15 */   private GangActionLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangActionLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */