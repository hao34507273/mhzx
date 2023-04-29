/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Barriers
/*    */   extends FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 15 */     fighter.addBuffState(122);
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 21 */     fighter.remBuffState(122);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Barriers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */