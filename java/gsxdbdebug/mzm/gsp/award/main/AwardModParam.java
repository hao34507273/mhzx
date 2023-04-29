/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class AwardModParam
/*    */ {
/*    */   private double allModParam;
/*  9 */   private Map<Integer, Double> modType2Num = new HashMap();
/*    */   
/*    */   public AwardModParam()
/*    */   {
/* 13 */     this.allModParam = 1.0D;
/* 14 */     this.modType2Num = new HashMap();
/*    */   }
/*    */   
/*    */   public double getAllModParam()
/*    */   {
/* 19 */     return this.allModParam;
/*    */   }
/*    */   
/*    */   public void setAllModParam(double allModParam)
/*    */   {
/* 24 */     this.allModParam = allModParam;
/*    */   }
/*    */   
/*    */   public Map<Integer, Double> getModType2Num()
/*    */   {
/* 29 */     return this.modType2Num;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardModParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */