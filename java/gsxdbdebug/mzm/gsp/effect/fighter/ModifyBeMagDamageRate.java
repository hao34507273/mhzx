/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBeMagDamageRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int bemagdamagerate;
/*    */   
/*    */   public ModifyBeMagDamageRate(int bemagdamagerate)
/*    */   {
/* 11 */     this.bemagdamagerate = bemagdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBEMAGDAMAGERate(this.bemagdamagerate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBEMAGDAMAGERate(-this.bemagdamagerate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBeMagDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */