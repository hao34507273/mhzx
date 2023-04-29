/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagAtk extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magatk;
/*    */   
/*    */   public ModifyMagAtk(int mgcatk)
/*    */   {
/* 11 */     this.magatk = mgcatk;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGATK(this.magatk);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGATK(-this.magatk);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagAtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */