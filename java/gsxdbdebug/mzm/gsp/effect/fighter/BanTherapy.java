/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class BanTherapy extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int behealrate;
/*    */   
/*    */   public BanTherapy(int behealrate)
/*    */   {
/* 11 */     this.behealrate = behealrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBeHealEffectRate(this.behealrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeHealEffectRate(-this.behealrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BanTherapy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */