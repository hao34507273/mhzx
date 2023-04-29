/*    */ package mzm.gsp.common;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.common.confbean.PropertyType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PropertyFormula
/*    */ {
/*    */   private static final double WAN = 10000.0D;
/* 19 */   public static List<Integer> PROP_LIST = new ArrayList();
/*    */   
/*    */   public static void init() throws IllegalAccessException
/*    */   {
/* 23 */     Class<PropertyType> cls = PropertyType.class;
/* 24 */     Field[] fs = cls.getFields();
/* 25 */     for (Field f : fs) {
/* 26 */       PROP_LIST.add(Integer.valueOf(f.getInt(null)));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static double roleFormulaFinalProperty(double selfFixValue, double otherFixValue, int addRate)
/*    */   {
/* 39 */     return selfFixValue * ((10000.0D + addRate) / 10000.0D) + otherFixValue;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static double petFormulaFinalProperty(double selfFixValue, double otherFixValue, int addRate)
/*    */   {
/* 50 */     return (selfFixValue + otherFixValue) * ((10000.0D + addRate * 1L) / 10000.0D);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\PropertyFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */