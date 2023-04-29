/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class DamageBigger extends FighterEffect implements mzm.gsp.fight.handle.DamageDeep
/*    */ {
/*    */   private int targethprate;
/*    */   private int bedamagerate;
/*    */   
/*    */   public DamageBigger(int targethprate, int bedamagerate)
/*    */   {
/* 16 */     this.targethprate = targethprate;
/* 17 */     this.bedamagerate = bedamagerate;
/* 18 */     if (targethprate <= 0) {
/* 19 */       throw new RuntimeException("DamageBigger目标每减少的血量万分比不能小于等于0");
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     fighter.addDamageHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 31 */     fighter.remDamageHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public void onDamage(DamageHandle.InputObj inputObj, DamageHandle.OutputObj outputObj)
/*    */   {
/* 37 */     int damage = outputObj.damage;
/* 38 */     Fighter target = inputObj.getTarget();
/* 39 */     if (target == null) {
/* 40 */       return;
/*    */     }
/* 42 */     int cutHpRate = (int)(FightArgs.getInstance().getDefaultRate() - target.getCurHpRateValue());
/* 43 */     int count = Math.max(0, cutHpRate / this.targethprate);
/* 44 */     outputObj.damage = ((int)(damage + count * damage * (this.bedamagerate * 1.0D / FightArgs.getInstance().getDefaultRate())));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DamageBigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */