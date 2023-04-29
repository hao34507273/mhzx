/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AwardAddParam
/*    */ {
/*    */   private double allAddParam;
/* 15 */   private Map<Integer, Double> addType2Num = new HashMap();
/*    */   
/*    */   public Map<Integer, Double> getAddType2Num()
/*    */   {
/* 19 */     return this.addType2Num;
/*    */   }
/*    */   
/*    */   public void setAddType2Num(Map<Integer, Double> addType2Num)
/*    */   {
/* 24 */     this.addType2Num = addType2Num;
/*    */   }
/*    */   
/*    */   public double getAllAddParam()
/*    */   {
/* 29 */     return this.allAddParam;
/*    */   }
/*    */   
/*    */   public void setAllAddParam(double allAddParam)
/*    */   {
/* 34 */     this.allAddParam = allAddParam;
/*    */   }
/*    */   
/*    */   public void addAllAddParam(double addValue)
/*    */   {
/* 39 */     this.allAddParam += addValue;
/*    */   }
/*    */   
/*    */   public void setAddType2Num(int type, double value)
/*    */   {
/* 44 */     this.addType2Num.put(Integer.valueOf(type), Double.valueOf(value));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addAddType2Num(int type, double value)
/*    */   {
/* 55 */     Double oldValue = (Double)this.addType2Num.get(Integer.valueOf(type));
/* 56 */     if (oldValue == null)
/*    */     {
/* 58 */       this.addType2Num.put(Integer.valueOf(type), Double.valueOf(value));
/* 59 */       return;
/*    */     }
/* 61 */     this.addType2Num.put(Integer.valueOf(type), Double.valueOf(oldValue.doubleValue() + value));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardAddParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */