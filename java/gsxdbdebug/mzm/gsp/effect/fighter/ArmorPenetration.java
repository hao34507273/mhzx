/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ArmorPenetration extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int penetration;
/*    */   private int penetrationrate;
/*    */   
/*    */   public ArmorPenetration(int penetration, int penetrationrate)
/*    */   {
/* 13 */     this.penetration = penetration;
/* 14 */     this.penetrationrate = penetrationrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 19 */     fighter.addBeforeAttackHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remBeforeAttackHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(mzm.gsp.fight.handle.BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 31 */     outputObj.phyPenetration += this.penetration;
/* 32 */     outputObj.phyPenetrationrate += this.penetrationrate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ArmorPenetration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */