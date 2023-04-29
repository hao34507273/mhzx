/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifySealResistLevel extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int sealresistlevel;
/*    */   
/*    */   public ModifySealResistLevel(int sealresistlevel)
/*    */   {
/* 11 */     this.sealresistlevel = sealresistlevel;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addSealResist(this.sealresistlevel);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addSealResist(-this.sealresistlevel);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifySealResistLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */