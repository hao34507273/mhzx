/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBePhyDamageRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int bephydamagerate;
/*    */   
/*    */   public ModifyBePhyDamageRate(int bephydamagerate)
/*    */   {
/* 11 */     this.bephydamagerate = bephydamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBEPHYDAMAGERate(this.bephydamagerate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBEPHYDAMAGERate(-this.bephydamagerate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBePhyDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */