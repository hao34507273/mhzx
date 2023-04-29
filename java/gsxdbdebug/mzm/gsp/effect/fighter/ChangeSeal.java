/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class ChangeSeal extends FighterEffect implements mzm.gsp.fight.handle.SealedHandle
/*    */ {
/*    */   private int times;
/*    */   
/*    */   public ChangeSeal(int times)
/*    */   {
/* 13 */     this.times = times;
/*    */   }
/*    */   
/*    */   public void onSealed(Fighter attacker, Fighter target, FighterBuff fighterBuff)
/*    */   {
/* 18 */     int leftRound = Math.max(0, fighterBuff.getLeftRound() + this.times);
/* 19 */     fighterBuff.setLeftRound(leftRound);
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 24 */     fighter.addSealedHandle(this);
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 30 */     fighter.remSealedHandle(this);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public void onSealOthers(Fighter attacker, Fighter target, FighterBuff fighterBuff) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ChangeSeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */