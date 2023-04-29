/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.RoundStartHandle;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RoundStartPro extends FighterEffect implements RoundStartHandle
/*    */ {
/*    */   private int type;
/*    */   private int value;
/*    */   private static final int HP_MAX = 1;
/*    */   private static final int PHY_ATK = 2;
/*    */   private static final int MAG_ATK = 4;
/*    */   private static final int PHY_DEF = 8;
/*    */   private static final int MAG_DEF = 16;
/*    */   
/*    */   public RoundStartPro(int type, int value)
/*    */   {
/* 19 */     this.type = type;
/* 20 */     this.value = value;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     fighter.addRoundStartHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 31 */     fighter.remRoundStartHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 37 */     if (!fighter.isAlive()) {
/* 38 */       return;
/*    */     }
/* 40 */     if ((this.type & 0x1) > 0) {
/* 41 */       fighter.addMaxFixHp(this.value);
/*    */     }
/* 43 */     if ((this.type & 0x2) > 0) {
/* 44 */       fighter.addPHYATK(this.value);
/*    */     }
/* 46 */     if ((this.type & 0x4) > 0) {
/* 47 */       fighter.addMAGATK(this.value);
/*    */     }
/* 49 */     if ((this.type & 0x8) > 0) {
/* 50 */       fighter.addPHYDEF(this.value);
/*    */     }
/* 52 */     if ((this.type & 0x10) > 0) {
/* 53 */       fighter.addMAGDEF(this.value);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */