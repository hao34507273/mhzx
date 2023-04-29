/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ 
/*    */ class Operator_ChangeFighter extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private int monsterid;
/*    */   private int level;
/*    */   private int hprate;
/*    */   
/*    */   Operator_ChangeFighter(int fid, int monsterid, int level) {
/* 13 */     super(false);
/* 14 */     this.monsterid = monsterid;
/* 15 */     this.level = level;
/* 16 */     this.fid = fid;
/*    */   }
/*    */   
/*    */   Operator_ChangeFighter(int fid2, int monsterid, int level, int hprate) {
/* 20 */     this(fid2, monsterid, level);
/* 21 */     this.hprate = hprate;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 26 */     Fighter fighter = fight.getFighter(this.fid);
/* 27 */     if ((fighter == null) || (fighter.isDead()) || (fighter.isFakeDead())) {
/* 28 */       return;
/*    */     }
/* 30 */     ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 31 */     fighter.fightGroup.changeFighter(fighter, this.monsterid, this.level, excuteCmdResult, this.hprate);
/* 32 */     excuteCmdResult.addPlayTime(SFightConsts.getInstance().CHANGE_FIGHTER_ACTION_TIME);
/* 33 */     fight.addCmdResult(excuteCmdResult);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_ChangeFighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */