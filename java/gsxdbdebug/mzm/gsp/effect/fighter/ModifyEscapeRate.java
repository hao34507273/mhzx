/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyEscapeRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int escaperate;
/*    */   
/*    */   public ModifyEscapeRate(int escaperate)
/*    */   {
/* 11 */     this.escaperate = escaperate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addEscapeRate(this.escaperate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYCRTVALUE(-this.escaperate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyEscapeRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */