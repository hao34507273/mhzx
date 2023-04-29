/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.OpSummonChild;
/*    */ 
/*    */ class Operator_SummonChild extends FighterAIOperator {
/*    */   private final int fid;
/*    */   private final long childUUID;
/*    */   
/*    */   Operator_SummonChild(int fid, long childUUID) {
/* 10 */     super(true);
/*    */     
/* 12 */     this.fid = fid;
/* 13 */     this.childUUID = childUUID;
/*    */   }
/*    */   
/*    */ 
/*    */   public void excute(Fight fight)
/*    */   {
/* 19 */     Fighter fighter = fight.getFighter(this.fid);
/* 20 */     if ((fighter == null) || (fighter.isDead()))
/*    */     {
/* 22 */       return;
/*    */     }
/*    */     
/* 25 */     OpSummonChild opSummonChild = new OpSummonChild();
/* 26 */     opSummonChild.child_uuid = this.childUUID;
/* 27 */     fight.addFightCmd(this.fid, 6, opSummonChild);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_SummonChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */