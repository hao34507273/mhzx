/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface AfterSummonHandle
/*    */ {
/*    */   public abstract void aftUseSummon(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter exeSummonFighter;
/*    */     private Fighter beSummonedFighter;
/*    */     private mzm.gsp.fight.main.ExcuteCmdResult excuteCmdResult;
/*    */     
/*    */     public InputObj(Fighter exeSummonFighter, Fighter beSummonedFighter, mzm.gsp.fight.main.ExcuteCmdResult cmdResult)
/*    */     {
/* 17 */       this.exeSummonFighter = exeSummonFighter;
/* 18 */       this.beSummonedFighter = beSummonedFighter;
/* 19 */       this.excuteCmdResult = cmdResult;
/*    */     }
/*    */     
/*    */     public Fighter getExeSummonFighter() {
/* 23 */       return this.exeSummonFighter;
/*    */     }
/*    */     
/*    */     public Fighter getBeSummonedFighter() {
/* 27 */       return this.beSummonedFighter;
/*    */     }
/*    */     
/*    */     public mzm.gsp.fight.main.ExcuteCmdResult getExcuteCmdResult() {
/* 31 */       return this.excuteCmdResult;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj {
/* 36 */     public java.util.Set<Integer> releaserPassiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\AfterSummonHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */