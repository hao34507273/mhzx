/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyCrtResistLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private final int phycrtresistlevel;
/*    */   
/*    */   public ModifyPhyCrtResistLevel(int phycrtresistlevel)
/*    */   {
/* 11 */     this.phycrtresistlevel = phycrtresistlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYCRTDEFLevel(this.phycrtresistlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYCRTDEFLevel(-this.phycrtresistlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyCrtResistLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */