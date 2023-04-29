/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Technique
/*    */   extends FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 11 */     fighter.addBuffState(111);
/* 12 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 17 */     fighter.remBuffState(111);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Technique.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */