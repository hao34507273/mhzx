/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.RoundStartHandle;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FixMagAtkWithEnergy
/*    */   extends FighterEffect
/*    */   implements RoundStartHandle
/*    */ {
/*    */   private int addmagatkrate;
/*    */   private int lastAddMagAtkRate;
/*    */   
/*    */   public FixMagAtkWithEnergy(int paramInt)
/*    */   {
/* 18 */     this.addmagatkrate = paramInt;
/* 19 */     this.lastAddMagAtkRate = 0;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter paramFighter)
/*    */   {
/* 24 */     if (!paramFighter.isAlive()) {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     int i = paramFighter.getEnergy();
/* 29 */     int j = i * this.addmagatkrate;
/* 30 */     int k = j - this.lastAddMagAtkRate;
/*    */     
/* 32 */     paramFighter.addMAGATKRate(k);
/* 33 */     this.lastAddMagAtkRate = j;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 38 */     paramFighter.addRoundStartHandle(this);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 44 */     paramFighter.remRoundStartHandle(this);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\FixMagAtkWithEnergy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */