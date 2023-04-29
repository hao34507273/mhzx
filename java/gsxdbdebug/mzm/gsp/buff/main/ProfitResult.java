/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class ProfitResult
/*    */ {
/*  8 */   private boolean isZeroProfit = false;
/*    */   
/* 10 */   private Set<ProfitArg> addList = new HashSet();
/*    */   
/* 12 */   private Set<ProfitArg> rateList = new HashSet();
/*    */   
/*    */ 
/*    */   public boolean isZeroProfit()
/*    */   {
/* 17 */     return this.isZeroProfit;
/*    */   }
/*    */   
/* 20 */   public void setZeroProfit(boolean isZeroProfit) { this.isZeroProfit = isZeroProfit; }
/*    */   
/*    */   public Set<ProfitArg> getAddList() {
/* 23 */     return this.addList;
/*    */   }
/*    */   
/* 26 */   public void setAddList(Set<ProfitArg> addList) { this.addList = addList; }
/*    */   
/*    */   public Set<ProfitArg> getRateList() {
/* 29 */     return this.rateList;
/*    */   }
/*    */   
/* 32 */   public void setRateList(Set<ProfitArg> rateList) { this.rateList = rateList; }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\ProfitResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */