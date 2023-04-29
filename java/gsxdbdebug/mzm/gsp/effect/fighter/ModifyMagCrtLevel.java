/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagCrtLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private final int magcrtlevel;
/*    */   
/*    */   public ModifyMagCrtLevel(int magcrtlevel)
/*    */   {
/* 11 */     this.magcrtlevel = magcrtlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGCRTLevel(this.magcrtlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGCRTLevel(-this.magcrtlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagCrtLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */