/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReleaseSkillAndDead
/*    */   extends FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 14 */     fighter.addBuffState(132);
/* 15 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 20 */     fighter.remBuffState(132);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ReleaseSkillAndDead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */