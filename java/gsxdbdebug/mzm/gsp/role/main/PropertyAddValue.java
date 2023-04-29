/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PropertyAddValue
/*    */ {
/*    */   int propertyType;
/*    */   
/*    */ 
/*    */ 
/*    */   volatile int finalAddValue;
/*    */   
/*    */ 
/*    */ 
/* 16 */   volatile int finalAddRate = 1;
/*    */   
/*    */   public PropertyAddValue(int proptype)
/*    */   {
/* 20 */     this.propertyType = proptype;
/*    */   }
/*    */   
/*    */   public int getPropertyType()
/*    */   {
/* 25 */     return this.propertyType;
/*    */   }
/*    */   
/*    */   public int getFinalAddValue()
/*    */   {
/* 30 */     return this.finalAddValue;
/*    */   }
/*    */   
/*    */   public int getFinalAddRate()
/*    */   {
/* 35 */     return this.finalAddRate;
/*    */   }
/*    */   
/*    */   public void addValue(int value)
/*    */   {
/* 40 */     this.finalAddValue += value;
/*    */   }
/*    */   
/*    */   public void addRate(int rate)
/*    */   {
/* 45 */     this.finalAddRate += rate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PropertyAddValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */