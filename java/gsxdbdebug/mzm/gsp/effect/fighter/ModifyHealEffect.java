/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyHealEffect extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int healvalue;
/*    */   
/*    */   public ModifyHealEffect(int healvalue)
/*    */   {
/* 11 */     this.healvalue = healvalue;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addHealEffectValue(this.healvalue);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addHealEffectValue(-this.healvalue);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyHealEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */