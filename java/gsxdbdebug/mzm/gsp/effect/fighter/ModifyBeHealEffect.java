/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBeHealEffect extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int behealvalue;
/*    */   
/*    */   public ModifyBeHealEffect(int behealvalue)
/*    */   {
/* 11 */     this.behealvalue = behealvalue;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBeHealEffectValue(this.behealvalue);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeHealEffectValue(-this.behealvalue);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBeHealEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */