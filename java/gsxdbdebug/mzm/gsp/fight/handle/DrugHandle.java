/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface DrugHandle
/*    */ {
/*    */   public abstract void onAfterDrug(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private Fighter target;
/*    */     private int drugValue;
/*    */     
/*    */     public InputObj(Fighter releser, Fighter target, int drugValue)
/*    */     {
/* 18 */       this.releser = releser;
/* 19 */       this.target = target;
/* 20 */       this.drugValue = drugValue;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 24 */       return this.releser;
/*    */     }
/*    */     
/*    */     public Fighter getTarget() {
/* 28 */       return this.target;
/*    */     }
/*    */     
/*    */     public int getDrugValue() {
/* 32 */       return this.drugValue;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public static class OutputObj
/*    */   {
/*    */     public int drugSelfValue;
/* 40 */     public Set<Integer> passiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\DrugHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */