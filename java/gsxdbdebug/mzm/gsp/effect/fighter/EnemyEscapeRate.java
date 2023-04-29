/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.EnterFightHandle;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnemyEscapeRate
/*    */   extends FighterEffect
/*    */   implements EnterFightHandle
/*    */ {
/*    */   private int rate;
/*    */   
/*    */   public EnemyEscapeRate(int rate)
/*    */   {
/* 18 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addEnterFightHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remEnterFightHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void onEnterFight(Fighter fighter)
/*    */   {
/* 35 */     if (fighter.isRoleRowMiddlePos(fighter.getPos())) {
/* 36 */       for (Fighter enermyFighter : fighter.getEnermyFighters()) {
/* 37 */         enermyFighter.addEscapeRate(this.rate);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\EnemyEscapeRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */