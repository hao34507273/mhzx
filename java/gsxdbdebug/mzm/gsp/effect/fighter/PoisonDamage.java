/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class PoisonDamage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforePoisonHandle
/*    */ {
/*    */   private int expoisonrate;
/*    */   
/*    */   public PoisonDamage(int expoisonrate)
/*    */   {
/* 12 */     this.expoisonrate = expoisonrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 17 */     fighter.addBeforePoisonHandle(this);
/* 18 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 23 */     fighter.remBeforePoisonHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public void beforePoison(mzm.gsp.fight.handle.BeforePoisonHandle.InputObj inputObj, BeforePoisonHandle.OutputObj outputObj)
/*    */   {
/* 29 */     outputObj.expoisonrate += this.expoisonrate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\PoisonDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */