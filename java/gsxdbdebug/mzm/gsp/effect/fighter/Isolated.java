/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Isolated extends FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 10 */     paramFighter.addBuffState(1006);
/* 11 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 16 */     paramFighter.remBuffState(1006);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Isolated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */