/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class StrengInvisible extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter paramFighter) {
/*  8 */     paramFighter.addBuffState(1005);
/*  9 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter) {
/* 13 */     paramFighter.remBuffState(1005);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\StrengInvisible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */