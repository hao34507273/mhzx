/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ public enum GoalStateTlogEnum
/*    */ {
/*  5 */   FINISH(1),  AWARDED(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 10 */   SUPPLY(3);
/*    */   
/*    */   private final int operator;
/*    */   
/*    */   private GoalStateTlogEnum(int operator)
/*    */   {
/* 16 */     this.operator = operator;
/*    */   }
/*    */   
/*    */   public int getOperator()
/*    */   {
/* 21 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\GoalStateTlogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */