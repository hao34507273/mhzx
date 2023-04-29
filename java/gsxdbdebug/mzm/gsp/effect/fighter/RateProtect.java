/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class RateProtect extends FighterEffect implements mzm.gsp.fight.handle.ProtectHandle
/*    */ {
/*    */   private int mask;
/*    */   private int protectrate;
/*    */   private int times;
/*    */   private int curRound;
/*    */   private int protectTimes;
/*    */   
/*    */   public RateProtect(int mask, int protectrate, int times)
/*    */   {
/* 18 */     this.mask = mask;
/* 19 */     this.protectrate = protectrate;
/* 20 */     this.times = times;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     fighter.addProtectHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 31 */     fighter.remProtectHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean triggerProtect(Fighter beProtected, Fighter protecter)
/*    */   {
/* 37 */     int round = protecter.getRound();
/* 38 */     boolean triggered = false;
/* 39 */     if (this.curRound == round) {
/* 40 */       if (this.protectTimes < this.times) {
/* 41 */         triggered = isTriggered(beProtected);
/*    */       }
/*    */     } else {
/* 44 */       triggered = isTriggered(beProtected);
/*    */     }
/* 46 */     if (triggered) {
/* 47 */       this.curRound = round;
/* 48 */       this.protectTimes += 1;
/*    */     }
/* 50 */     return triggered;
/*    */   }
/*    */   
/*    */   private boolean isTriggered(Fighter beProtected) {
/* 54 */     int type = beProtected.getType();
/* 55 */     if ((type & this.mask) > 0) {
/* 56 */       return this.protectrate > Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RateProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */