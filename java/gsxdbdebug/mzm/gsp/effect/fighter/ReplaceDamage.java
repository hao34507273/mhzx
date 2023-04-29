/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.MainSoulDamageHandle;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReplaceDamage
/*    */   extends FighterEffect
/*    */   implements MainSoulDamageHandle
/*    */ {
/*    */   private final int rate;
/*    */   private final int times;
/*    */   private int triggeredTimes;
/*    */   
/*    */   public ReplaceDamage(int rate, int times)
/*    */   {
/* 27 */     this.rate = rate;
/* 28 */     this.times = times;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 33 */     fighter.addBeDamageHandle(this);
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 39 */     fighter.remBeDamageHandle(this);
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 45 */     if (this.triggeredTimes >= this.times) {
/* 46 */       return;
/*    */     }
/* 48 */     if (getGroup() == null) {
/* 49 */       return;
/*    */     }
/* 51 */     Fighter releaser = inputObj.getReleser();
/* 52 */     if (releaser == null) {
/* 53 */       return;
/*    */     }
/* 55 */     Fighter buffReleaser = getGroup().getReleaser(releaser);
/* 56 */     if ((buffReleaser == null) || (buffReleaser.isDead()) || (buffReleaser.isFakeDead())) {
/* 57 */       return;
/*    */     }
/* 59 */     if (!outputObj.shareDamageFighters.contains(buffReleaser)) {
/* 60 */       outputObj.shareDamageFighters.add(buffReleaser);
/*    */     }
/*    */     
/*    */ 
/* 64 */     int sharedDamage = (int)(outputObj.nowDamage * (this.rate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 65 */     sharedDamage = Math.max(sharedDamage, 1);
/* 66 */     outputObj.shareDamage += sharedDamage;
/*    */     
/*    */ 
/* 69 */     outputObj.nowDamage = 0;
/*    */     
/*    */ 
/* 72 */     this.triggeredTimes += 1;
/* 73 */     if (this.triggeredTimes >= this.times) {
/* 74 */       setLeftRound(0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ReplaceDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */