/*    */ package mzm.gsp.fight.fighter.selector;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExistedFighterSelector
/*    */   implements FighterSelector
/*    */ {
/*    */   public boolean isSelected(Fighter fighter)
/*    */   {
/* 14 */     return fighter.isExisted();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\selector\ExistedFighterSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */