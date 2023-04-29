/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class WoundDeeper extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.DamageDeep
/*    */ {
/*    */   private int hprate;
/*    */   private int bedamagerate;
/*    */   
/*    */   public WoundDeeper(int hprate, int bedamagerate)
/*    */   {
/* 14 */     this.hprate = hprate;
/* 15 */     this.bedamagerate = bedamagerate;
/* 16 */     if (hprate <= 0) {
/* 17 */       throw new RuntimeException("WoundDeeper自身血量万分比不能小于等于0");
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addDamageHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remDamageHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void onDamage(mzm.gsp.fight.handle.DamageHandle.InputObj inputObj, DamageHandle.OutputObj outputObj)
/*    */   {
/* 35 */     Fighter releser = inputObj.getReleser();
/* 36 */     if (releser == null) {
/* 37 */       return;
/*    */     }
/* 39 */     int cutHpRate = (int)(FightArgs.getInstance().getDefaultRate() - releser.getCurHpRateValue());
/* 40 */     int count = Math.max(0, cutHpRate / this.hprate);
/* 41 */     int damage = outputObj.damage;
/* 42 */     outputObj.damage = ((int)(damage + count * damage * (this.bedamagerate * 1.0D / FightArgs.getInstance().getDefaultRate())));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\WoundDeeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */