/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ 
/*    */ class Operator_AddBuff extends FighterAIOperator
/*    */ {
/*    */   private int fid;
/*    */   private int effectGroupid;
/*    */   
/*    */   Operator_AddBuff(int fid, int effectGroupid)
/*    */   {
/* 12 */     super(false);
/* 13 */     this.fid = fid;
/* 14 */     this.effectGroupid = effectGroupid;
/*    */   }
/*    */   
/*    */   public void excute(Fight fight)
/*    */   {
/* 19 */     Fighter fighter = fight.getFighter(this.fid);
/* 20 */     if (fighter == null) {
/* 21 */       return;
/*    */     }
/* 23 */     FighterEffectGroup fighterEffectGroup = mzm.gsp.effect.main.EffectInterface.getEffectGroup(this.effectGroupid);
/* 24 */     if (fighterEffectGroup == null) {
/* 25 */       return;
/*    */     }
/* 27 */     fighterEffectGroup.run(fighter.getLevel(), fighter, fighter, fighter.fighterid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Operator_AddBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */