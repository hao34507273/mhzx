/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Defense
/*    */   extends FighterEffect
/*    */ {
/*    */   private int cutbedamageRate;
/*    */   
/*    */   public Defense(int cutbedamageRate)
/*    */   {
/* 13 */     this.cutbedamageRate = cutbedamageRate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addBuffState(109);
/* 19 */     fighter.addBEPHYDAMAGERate(-this.cutbedamageRate);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remBuffState(109);
/* 26 */     fighter.addBEPHYDAMAGERate(this.cutbedamageRate);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Defense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */