/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ class Operator_Escape extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private boolean immediately;
/*    */   private boolean mustSuc;
/*    */   
/*    */   Operator_Escape(int fid, boolean mustSuc, boolean immediately) {
/* 10 */     super(!mustSuc);
/* 11 */     this.fid = fid;
/* 12 */     this.mustSuc = mustSuc;
/* 13 */     this.immediately = immediately;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 18 */     if ((this.immediately) || (this.mustSuc)) {
/* 19 */       Fighter fighter = fight.getFighter(this.fid);
/* 20 */       if (fighter != null) {
/* 21 */         ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 22 */         fighter.escape(excuteCmdResult);
/* 23 */         fight.addCmdResult(excuteCmdResult);
/*    */       }
/* 25 */       return;
/*    */     }
/* 27 */     if (fight.hasFightCmd(this.fid)) {
/* 28 */       return;
/*    */     }
/* 30 */     fight.addFightCmd(this.fid, 4, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_Escape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */