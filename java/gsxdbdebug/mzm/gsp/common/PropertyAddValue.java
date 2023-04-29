/*    */ package mzm.gsp.common;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PropertyAddValue
/*    */ {
/*    */   int propertyType;
/*    */   
/*    */ 
/*    */   volatile int finalAddValue;
/*    */   
/*    */ 
/*    */   volatile int finalAddRate;
/*    */   
/*    */ 
/*    */   public PropertyAddValue(int proptype)
/*    */   {
/* 18 */     this.propertyType = proptype;
/*    */   }
/*    */   
/*    */   public int getPropertyType() {
/* 22 */     return this.propertyType;
/*    */   }
/*    */   
/* 25 */   public int getFinalAddValue() { return this.finalAddValue; }
/*    */   
/*    */   public int getFinalAddRate() {
/* 28 */     return this.finalAddRate;
/*    */   }
/*    */   
/*    */   public void addValue(int value) {
/* 32 */     this.finalAddValue += value;
/*    */   }
/*    */   
/*    */   public void addRate(int rate) {
/* 36 */     this.finalAddRate += rate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\PropertyAddValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */