/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyDef extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phydef;
/*    */   
/*    */   public ModifyPhyDef(int phydef)
/*    */   {
/* 11 */     this.phydef = phydef;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYDEF(this.phydef);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYDEF(-this.phydef);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */