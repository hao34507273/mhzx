/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifySealHitLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int sealhitlevel;
/*    */   
/*    */   public ModifySealHitLevel(int sealhitlevel)
/*    */   {
/* 11 */     this.sealhitlevel = sealhitlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addSealHit(this.sealhitlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addSealHit(-this.sealhitlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifySealHitLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */