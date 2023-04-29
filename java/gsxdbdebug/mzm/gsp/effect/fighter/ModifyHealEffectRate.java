/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyHealEffectRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int healeffectrate;
/*    */   
/*    */   public ModifyHealEffectRate(int healeffectrate)
/*    */   {
/* 11 */     this.healeffectrate = healeffectrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addHealEffectRate(this.healeffectrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addHealEffectRate(-this.healeffectrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyHealEffectRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */