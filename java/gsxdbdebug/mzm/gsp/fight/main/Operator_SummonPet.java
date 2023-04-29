/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.OpSummonPet;
/*    */ 
/*    */ class Operator_SummonPet extends FighterAIOperator {
/*    */   private int fid;
/*    */   private long petUUId;
/*    */   
/*  9 */   Operator_SummonPet(int fid, long petUUid) { super(true);
/* 10 */     this.fid = fid;
/* 11 */     this.petUUId = petUUid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 16 */     Fighter fighter = fight.getFighter(this.fid);
/* 17 */     if ((fighter == null) || (fighter.isDead())) {
/* 18 */       return;
/*    */     }
/* 20 */     OpSummonPet opSummonPet = new OpSummonPet();
/* 21 */     opSummonPet.pet_uuid = this.petUUId;
/* 22 */     fight.addFightCmd(this.fid, 5, opSummonPet);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_SummonPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */