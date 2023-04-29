/*    */ package mzm.gsp.fight.fighter.selector;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AliveRoleOrFellowFighterSelector
/*    */   implements FighterSelector
/*    */ {
/*    */   public boolean isSelected(Fighter fighter)
/*    */   {
/* 14 */     if (!fighter.isAlive())
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     int fighterType = fighter.getType();
/* 20 */     return (fighterType == 1) || (fighterType == 2);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\selector\AliveRoleOrFellowFighterSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */