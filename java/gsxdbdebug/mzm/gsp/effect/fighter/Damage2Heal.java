/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class Damage2Heal
/*    */   extends FighterEffect
/*    */   implements mzm.gsp.fight.handle.Damage2Heal
/*    */ {
/*    */   private int rate;
/*    */   private int timestype;
/*    */   private int times;
/*    */   private static final int TYPE_ROUND_ONCE = 1;
/*    */   private static final int TYPE_MUL_TIMES = 2;
/* 20 */   private int round = -1;
/* 21 */   private int nowTimes = 0;
/*    */   
/*    */   public Damage2Heal(int rate, int timestype, int times) {
/* 24 */     this.rate = rate;
/* 25 */     this.timestype = timestype;
/* 26 */     this.times = times;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 31 */     fighter.addBeDamageHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 37 */     fighter.remBeDamageHandle(this);
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private int calMulDamage2Heal(Fighter fighter, int damage) {
/* 42 */     if (this.nowTimes >= this.times) {
/* 43 */       return damage;
/*    */     }
/* 45 */     this.nowTimes += 1;
/* 46 */     int hp = (int)(this.rate * 1.0D / FightArgs.getInstance().getDefaultRate() * damage);
/*    */     
/* 48 */     if (this.nowTimes >= this.times) {
/* 49 */       setLeftRound(0);
/*    */     }
/* 51 */     return -hp;
/*    */   }
/*    */   
/*    */   private int calOnceDamage2Heal(Fighter fighter, int damage) {
/* 55 */     int roundNow = fighter.getRound();
/* 56 */     if ((this.nowTimes >= 1) && (roundNow == this.round)) {
/* 57 */       return damage;
/*    */     }
/* 59 */     this.round = roundNow;
/* 60 */     if (getLeftRound() == 1) {
/* 61 */       setLeftRound(0);
/*    */     }
/* 63 */     this.nowTimes += 1;
/* 64 */     int hp = (int)(this.rate * 1.0D / FightArgs.getInstance().getDefaultRate() * damage);
/*    */     
/* 66 */     return -hp;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 72 */     Fighter fighter = inputObj.getTarget();
/* 73 */     if (fighter == null) {
/* 74 */       return;
/*    */     }
/* 76 */     int damage = 0;
/* 77 */     if (this.timestype == 1) {
/* 78 */       damage = calOnceDamage2Heal(fighter, outputObj.nowDamage);
/* 79 */       outputObj.nowDamage = Math.max(0, damage);
/* 80 */     } else if (this.timestype == 2) {
/* 81 */       damage = calMulDamage2Heal(fighter, outputObj.nowDamage);
/* 82 */       outputObj.nowDamage = Math.max(0, damage);
/*    */     } else {
/* 84 */       GameServer.logger().error("Damage2Heal效果的timestype配置错误:" + this.timestype);
/*    */     }
/* 86 */     outputObj.damage2heal -= damage;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Damage2Heal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */