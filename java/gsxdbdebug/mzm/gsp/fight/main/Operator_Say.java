/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ 
/*    */ class Operator_Say extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private int strid;
/*    */   private String[] args;
/*    */   
/*    */   Operator_Say(int fid, int strid, String[] args) {
/* 12 */     super(false);
/* 13 */     this.fid = fid;
/* 14 */     this.strid = strid;
/* 15 */     this.args = args;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 20 */     Fighter fighter = fight.getFighter(this.fid);
/* 21 */     if (fighter == null) {
/* 22 */       return;
/*    */     }
/* 24 */     ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 25 */     mzm.gsp.fight.Play play = new mzm.gsp.fight.Play();
/* 26 */     fighter.fillPlayTalkResult(play, this.strid, this.args);
/* 27 */     excuteCmdResult.addPlay(play, false);
/* 28 */     excuteCmdResult.addPlay(play, true);
/* 29 */     if (fight.isRecordEnable()) {
/* 30 */       excuteCmdResult.addPlay(play);
/*    */     }
/* 32 */     excuteCmdResult.addPlayTime(SFightConsts.getInstance().WORDS_ROUND_TIME);
/* 33 */     fight.addCmdResult(excuteCmdResult);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_Say.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */