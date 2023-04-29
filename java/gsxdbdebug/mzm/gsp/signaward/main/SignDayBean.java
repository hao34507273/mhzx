/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ 
/*    */ public class SignDayBean
/*    */ {
/*    */   private final int day;
/*    */   private final int month;
/*    */   private final int year;
/*    */   
/*    */   public SignDayBean(int signDay)
/*    */   {
/* 12 */     this.year = (signDay / 10000);
/* 13 */     this.month = (signDay % 10000 / 100 - 1);
/* 14 */     this.day = (signDay % 100);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getDay()
/*    */   {
/* 20 */     return this.day;
/*    */   }
/*    */   
/*    */   public int getMonth()
/*    */   {
/* 25 */     return this.month;
/*    */   }
/*    */   
/*    */   public int getYear()
/*    */   {
/* 30 */     return this.year;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\SignDayBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */