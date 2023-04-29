/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagAtkHitLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int maghitlevel;
/*    */   
/*    */   public ModifyMagAtkHitLevel(int maghitlevel)
/*    */   {
/* 11 */     this.maghitlevel = maghitlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGHITlevel(this.maghitlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGHITlevel(-this.maghitlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagAtkHitLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */