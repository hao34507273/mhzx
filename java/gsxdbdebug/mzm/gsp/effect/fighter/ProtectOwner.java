/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class ProtectOwner extends FighterEffect implements mzm.gsp.fight.handle.ProtectHandle
/*    */ {
/*    */   private int protectrate;
/*    */   private int times;
/*    */   private int curRound;
/*    */   private int protectTimes;
/*    */   
/*    */   public ProtectOwner(int protectrate, int times)
/*    */   {
/* 17 */     this.protectrate = protectrate;
/* 18 */     this.times = times;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addProtectHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remProtectHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean triggerProtect(Fighter beProtected, Fighter protecter)
/*    */   {
/* 35 */     int round = protecter.getRound();
/* 36 */     boolean triggered = false;
/* 37 */     if (this.curRound == round) {
/* 38 */       if (this.protectTimes < this.times) {
/* 39 */         triggered = isTriggered(beProtected, protecter);
/*    */       }
/*    */     } else {
/* 42 */       triggered = isTriggered(beProtected, protecter);
/*    */     }
/* 44 */     if (triggered) {
/* 45 */       this.curRound = round;
/* 46 */       this.protectTimes += 1;
/*    */     }
/* 48 */     return triggered;
/*    */   }
/*    */   
/*    */   private boolean isTriggered(Fighter beProtected, Fighter protecter) {
/* 52 */     if (protecter.isMyOwner(beProtected)) {
/* 53 */       return this.protectrate > Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ProtectOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */