/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.OpSummonMonster;
/*    */ 
/*    */ class Operator_SummonMonster extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private boolean sameSide;
/*    */   private int level;
/*    */   private int[] monsterids;
/*    */   private boolean immidiately;
/*    */   
/*    */   Operator_SummonMonster(int fid, boolean sameSide, int level, int[] monsterids, boolean immidiately) {
/* 14 */     super(!immidiately);
/* 15 */     this.fid = fid;
/* 16 */     this.sameSide = sameSide;
/* 17 */     this.level = level;
/* 18 */     this.monsterids = monsterids;
/* 19 */     this.immidiately = immidiately;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 24 */     Fighter fighter = fight.getFighter(this.fid);
/* 25 */     if ((fighter == null) || (fighter.isFakeDead()) || (fighter.isDead())) {
/* 26 */       return;
/*    */     }
/* 28 */     if ((this.monsterids == null) || (this.monsterids.length <= 0)) {
/* 29 */       return;
/*    */     }
/* 31 */     OpSummonMonster opSummonMonster = new OpSummonMonster();
/* 32 */     if (this.sameSide) {
/* 33 */       opSummonMonster.sameteam = 0;
/*    */     } else {
/* 35 */       opSummonMonster.sameteam = 1;
/*    */     }
/* 37 */     opSummonMonster.level = this.level;
/* 38 */     for (int monster : this.monsterids) {
/* 39 */       opSummonMonster.monsterids.add(Integer.valueOf(monster));
/*    */     }
/* 41 */     if (this.immidiately) {
/* 42 */       ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 43 */       fighter.excuteOpSummonMonster(opSummonMonster, excuteCmdResult);
/* 44 */       fight.addCmdResult(excuteCmdResult);
/*    */     } else {
/* 46 */       fight.addFightCmd(this.fid, 7, opSummonMonster);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_SummonMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */