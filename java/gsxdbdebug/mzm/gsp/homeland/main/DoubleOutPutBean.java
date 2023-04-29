/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ 
/*    */ public class DoubleOutPutBean
/*    */ {
/*    */   private boolean isDoubleOutPut;
/*    */   private boolean isAtHome;
/*    */   private int needCutVigor;
/*    */   
/*    */   public DoubleOutPutBean(boolean isDoubleOutPut, boolean isAtHome, int needCutVigor)
/*    */   {
/* 12 */     this.isDoubleOutPut = isDoubleOutPut;
/* 13 */     this.isAtHome = isAtHome;
/* 14 */     this.needCutVigor = needCutVigor;
/*    */   }
/*    */   
/*    */   public boolean isDoubleOutPut()
/*    */   {
/* 19 */     return this.isDoubleOutPut;
/*    */   }
/*    */   
/*    */   void setDoubleOutPut(boolean isDoubleOutPut)
/*    */   {
/* 24 */     this.isDoubleOutPut = isDoubleOutPut;
/*    */   }
/*    */   
/*    */   public int getNeedCutVigor()
/*    */   {
/* 29 */     return this.needCutVigor;
/*    */   }
/*    */   
/*    */   void setNeedCutVigor(int needCutVigor)
/*    */   {
/* 34 */     this.needCutVigor = needCutVigor;
/*    */   }
/*    */   
/*    */   public boolean isAtHome()
/*    */   {
/* 39 */     return this.isAtHome;
/*    */   }
/*    */   
/*    */   void setAtHome(boolean isAtHome)
/*    */   {
/* 44 */     this.isAtHome = isAtHome;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\DoubleOutPutBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */