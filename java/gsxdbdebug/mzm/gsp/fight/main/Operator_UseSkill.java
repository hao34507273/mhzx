/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ class Operator_UseSkill extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private int skillid;
/*    */   private int skillLV;
/*    */   private int tfid;
/*    */   
/*    */   Operator_UseSkill(int fid, int skillid, int skillLV, int tfid) {
/* 11 */     super(true);
/* 12 */     this.fid = fid;
/* 13 */     this.skillid = skillid;
/* 14 */     this.skillLV = skillLV;
/* 15 */     this.tfid = tfid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 20 */     if (fight.hasFightCmd(this.fid)) {
/* 21 */       return;
/*    */     }
/* 23 */     Op_UseSkill opUseSkill = Fighter.getOp_UseSkill(this.skillid, this.skillLV);
/* 24 */     opUseSkill.main_target = this.tfid;
/* 25 */     fight.addFightCmd(this.fid, 0, opUseSkill);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_UseSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */