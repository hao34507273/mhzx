/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.RebirthHandle;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class ForbidRebirth
/*    */   extends FighterEffect implements RebirthHandle
/*    */ {
/*    */   private int round;
/*    */   
/*    */   public ForbidRebirth(int round)
/*    */   {
/* 15 */     this.round = round;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addBuffState(106);
/* 21 */     fighter.addRebirthHandle(this);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 27 */     fighter.remBuffState(106);
/* 28 */     fighter.remRebirthHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void handleRebirth(Fighter fighter)
/*    */   {
/* 34 */     FighterBuff fighterBuff = getGroup();
/* 35 */     if (fighterBuff != null) {
/* 36 */       getGroup().setLeftRound(fighterBuff.getLeftRound() - this.round);
/* 37 */       if (getGroup().getLeftRound() <= 0) {
/* 38 */         fighter.removeBuff(getGroup());
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ForbidRebirth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */