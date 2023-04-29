/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.MainSoulDamageHandle;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SubSoulBonds
/*    */   extends FighterEffect
/*    */   implements MainSoulDamageHandle
/*    */ {
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 15 */     fighter.addBeDamageHandle(this);
/* 16 */     fighter.addBuffState(131);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.remBeDamageHandle(this);
/* 23 */     fighter.remBuffState(131);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SubSoulBonds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */