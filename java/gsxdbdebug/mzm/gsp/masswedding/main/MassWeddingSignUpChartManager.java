/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RankManagerNew;
/*    */ 
/*    */ public class MassWeddingSignUpChartManager
/*    */   extends RankManagerNew<Long, MassWeddingSignUpChart>
/*    */ {
/*    */   private static MassWeddingSignUpChartManager instance;
/*  9 */   private static Object lockObject = new Object();
/*    */   
/*    */   static MassWeddingSignUpChartManager getInstance() {
/* 12 */     if (instance == null) {
/* 13 */       synchronized (lockObject) {
/* 14 */         if (instance == null) {
/* 15 */           instance = new MassWeddingSignUpChartManager(Integer.MAX_VALUE, 0);
/*    */         }
/*    */         else {
/* 18 */           return instance;
/*    */         }
/*    */       }
/*    */     }
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   public MassWeddingSignUpChartManager(int capacity, int extraSize) {
/* 26 */     super(capacity, extraSize);
/*    */   }
/*    */   
/*    */   public void rankDataFromDB() {}
/*    */   
/*    */   public void saveToDB() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingSignUpChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */