/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyCrtLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private final int phycrtlevel;
/*    */   
/*    */   public ModifyPhyCrtLevel(int phycrtlevel)
/*    */   {
/* 11 */     this.phycrtlevel = phycrtlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYCRTLevel(this.phycrtlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYCRTLevel(-this.phycrtlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyCrtLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */