/*    */ package mzm.gsp.fight.fighter.selector;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OperableFighterSelector
/*    */   implements FighterSelector
/*    */ {
/*    */   public boolean isSelected(Fighter fighter)
/*    */   {
/* 14 */     return fighter.isOperable();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\selector\OperableFighterSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */