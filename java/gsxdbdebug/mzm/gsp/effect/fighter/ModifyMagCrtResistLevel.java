/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagCrtResistLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private final int magcrtresistlevel;
/*    */   
/*    */   public ModifyMagCrtResistLevel(int magcrtresistlevel)
/*    */   {
/* 11 */     this.magcrtresistlevel = magcrtresistlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGCRTDEFLevel(this.magcrtresistlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGCRTDEFLevel(-this.magcrtresistlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagCrtResistLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */