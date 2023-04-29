/*    */ package mzm.gsp.role.moneywatchdog;
/*    */ 
/*    */ 
/*    */ public class MoneyGainTouchLineArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   private final int occId;
/*    */   
/*    */   private final int curLevel;
/*    */   
/*    */   private final int currencyType;
/*    */   
/*    */   private final long totalValue;
/*    */   
/*    */   private final TouchLineContext context;
/*    */   
/*    */   public MoneyGainTouchLineArg(long roleId, int occId, int curLevel, int currencyType, long totalValue, TouchLineContext context)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.occId = occId;
/* 22 */     this.curLevel = curLevel;
/* 23 */     this.currencyType = currencyType;
/* 24 */     this.totalValue = totalValue;
/* 25 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 35 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getOccId()
/*    */   {
/* 45 */     return this.occId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCurLevel()
/*    */   {
/* 55 */     return this.curLevel;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCurrencyType()
/*    */   {
/* 66 */     return this.currencyType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getTotalValue()
/*    */   {
/* 76 */     return this.totalValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public TouchLineContext getContext()
/*    */   {
/* 86 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\MoneyGainTouchLineArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */