/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompetitionPickUpTreasure
/*    */   extends AbstractConditionalDoneOneEventTimes
/*    */ {
/*    */   public static enum TreasureType
/*    */   {
/* 12 */     GOLD(3),  SILVER(2),  COPPER(1);
/*    */     
/*    */     public final int value;
/*    */     
/*    */     private TreasureType(int value)
/*    */     {
/* 18 */       this.value = value;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 25 */     return 909;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\CompetitionPickUpTreasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */