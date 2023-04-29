/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Fly
/*    */   extends FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 15 */     fighter.addBuffState(116);
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 21 */     fighter.remBuffState(116);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Fly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */