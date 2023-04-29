/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagFightBackRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int fightbackrate;
/*    */   
/*    */   public ModifyMagFightBackRate(int fightbackrate)
/*    */   {
/* 11 */     this.fightbackrate = fightbackrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGFIGHTBACK(this.fightbackrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGFIGHTBACK(-this.fightbackrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagFightBackRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */