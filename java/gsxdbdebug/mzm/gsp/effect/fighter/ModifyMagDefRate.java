/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagDefRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magdefrate;
/*    */   
/*    */   public ModifyMagDefRate(int mgcdefrate)
/*    */   {
/* 11 */     this.magdefrate = mgcdefrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGDEFRate(this.magdefrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGDEFRate(-this.magdefrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagDefRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */