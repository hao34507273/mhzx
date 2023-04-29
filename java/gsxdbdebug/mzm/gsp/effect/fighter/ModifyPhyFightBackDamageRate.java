/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyFightBackDamageRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int fightbackdamagerate;
/*    */   
/*    */   public ModifyPhyFightBackDamageRate(int fightbackdamagerate)
/*    */   {
/* 11 */     this.fightbackdamagerate = fightbackdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPhyFightBackDamageRate(this.fightbackdamagerate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPhyFightBackDamageRate(-this.fightbackdamagerate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyFightBackDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */