/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagCrtValue extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magcrtvalue;
/*    */   
/*    */   public ModifyMagCrtValue(int mgccrtvalue)
/*    */   {
/* 11 */     this.magcrtvalue = mgccrtvalue;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGCRTVALUE(this.magcrtvalue);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGCRTVALUE(-this.magcrtvalue);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagCrtValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */