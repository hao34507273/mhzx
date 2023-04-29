/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyAtkDodgeLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phydodgelevel;
/*    */   
/*    */   public ModifyPhyAtkDodgeLevel(int phydodgelevel)
/*    */   {
/* 11 */     this.phydodgelevel = phydodgelevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYDODGElevel(this.phydodgelevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYDODGElevel(-this.phydodgelevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyAtkDodgeLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */