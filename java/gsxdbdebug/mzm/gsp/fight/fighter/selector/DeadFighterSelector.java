/*    */ package mzm.gsp.fight.fighter.selector;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeadFighterSelector
/*    */   implements FighterSelector
/*    */ {
/*    */   public boolean isSelected(Fighter fighter)
/*    */   {
/* 15 */     return fighter.isDead();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\selector\DeadFighterSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */