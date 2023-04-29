/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ 
/*    */ class Operator_Defense extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   
/*    */   Operator_Defense(int fid) {
/* 10 */     super(true);
/* 11 */     this.fid = fid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 16 */     if (fight.hasFightCmd(this.fid)) {
/* 17 */       return;
/*    */     }
/* 19 */     Op_UseSkill opUseSkill = Fighter.getOp_UseSkill(SFightConsts.getInstance().DEFENCE_SKILL, 1);
/* 20 */     opUseSkill.main_target = this.fid;
/* 21 */     fight.addFightCmd(this.fid, 0, opUseSkill);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_Defense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */