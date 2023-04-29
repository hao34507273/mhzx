/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagFightBackDamageRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int fightbackdamagerate;
/*    */   
/*    */   public ModifyMagFightBackDamageRate(int fightbackdamagerate)
/*    */   {
/* 11 */     this.fightbackdamagerate = fightbackdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMagFightBackDamageRate(this.fightbackdamagerate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMagFightBackDamageRate(-this.fightbackdamagerate);
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagFightBackDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */