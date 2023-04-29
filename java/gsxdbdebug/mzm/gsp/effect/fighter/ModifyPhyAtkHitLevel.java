/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyAtkHitLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phyhitlevel;
/*    */   
/*    */   public ModifyPhyAtkHitLevel(int phyhitlevel)
/*    */   {
/* 11 */     this.phyhitlevel = phyhitlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYHITLevel(this.phyhitlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYHITLevel(-this.phyhitlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyAtkHitLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */