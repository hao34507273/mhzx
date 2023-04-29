/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyAtk extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phyatk;
/*    */   
/*    */   public ModifyPhyAtk(int phyatk)
/*    */   {
/* 11 */     this.phyatk = phyatk;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYATK(this.phyatk);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYATK(-this.phyatk);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyAtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */