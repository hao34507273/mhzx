/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.ChartObj;
/*    */ 
/*    */ public class MassWeddingSignUpChart extends ChartObj<Long, MassWeddingSignUpChart>
/*    */ {
/*    */   public final long roleidA;
/*    */   public final int roleAPrice;
/*    */   public final long roleidB;
/*    */   public final int roleBPrice;
/*    */   
/*    */   public MassWeddingSignUpChart(long roleidA, int roleAPrice, long roleidB, int roleBPrice) {
/* 13 */     this.roleidA = roleidA;
/* 14 */     this.roleidB = roleidB;
/* 15 */     this.roleAPrice = roleAPrice;
/* 16 */     this.roleBPrice = roleBPrice;
/*    */   }
/*    */   
/*    */   public boolean isAvailable()
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isTopThan(MassWeddingSignUpChart rankObj)
/*    */   {
/* 26 */     return Long.valueOf(this.roleAPrice).longValue() + Long.valueOf(this.roleBPrice).longValue() > Long.valueOf(rankObj.roleAPrice).longValue() + Long.valueOf(rankObj.roleBPrice).longValue();
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 32 */     return Long.valueOf(this.roleidA);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingSignUpChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */