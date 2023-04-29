/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.LoseHpHandle;
/*    */ import mzm.gsp.fight.handle.LoseHpHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.LoseHpHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Endure extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle, LoseHpHandle
/*    */ {
/*    */   private int hprate;
/*    */   private int exdamagerate;
/*    */   private int damagerate;
/* 18 */   Map<Integer, Integer> round2HpMap = new HashMap();
/*    */   
/* 20 */   Map<Integer, Integer> cacheRound2Multi = new HashMap();
/*    */   private int maxHp;
/*    */   
/*    */   public Endure(int hprate, int exdamagerate, int damagerate)
/*    */   {
/* 25 */     this.hprate = hprate;
/* 26 */     this.exdamagerate = exdamagerate;
/* 27 */     this.damagerate = damagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 32 */     fighter.addBeforeAttackHandle(this);
/* 33 */     fighter.addLoseHpHandle(this);
/* 34 */     this.maxHp = ((int)fighter.getMaxHp());
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 40 */     fighter.remBeforeAttackHandle(this);
/* 41 */     fighter.remLoseHpHandle(this);
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void handleOnLoseHp(LoseHpHandle.InputObj inputObj, LoseHpHandle.OutputObj outputObj)
/*    */   {
/* 48 */     int losehp = inputObj.getLoseHp();
/* 49 */     Fighter fighter = inputObj.getFighter();
/* 50 */     if (fighter == null) {
/* 51 */       return;
/*    */     }
/* 53 */     int curRound = fighter.getRound();
/* 54 */     Integer nowLoseHp = (Integer)this.round2HpMap.get(Integer.valueOf(curRound));
/* 55 */     if (nowLoseHp == null) {
/* 56 */       nowLoseHp = Integer.valueOf(0);
/*    */     }
/* 58 */     nowLoseHp = Integer.valueOf(nowLoseHp.intValue() + losehp);
/* 59 */     this.round2HpMap.put(Integer.valueOf(curRound), nowLoseHp);
/*    */   }
/*    */   
/*    */ 
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 65 */     Fighter target = inputObj.getTarget();
/* 66 */     if (target == null) {
/* 67 */       return;
/*    */     }
/* 69 */     int curRound = target.getRound();
/* 70 */     Integer cacheValue = (Integer)this.cacheRound2Multi.get(Integer.valueOf(curRound));
/* 71 */     if (cacheValue != null) {
/* 72 */       outputObj.bedamagerate += cacheValue.intValue() * this.exdamagerate;
/* 73 */       outputObj.damageRate += cacheValue.intValue() * this.damagerate;
/* 74 */       return;
/*    */     }
/* 76 */     Integer loseHp = (Integer)this.round2HpMap.get(Integer.valueOf(curRound - 1));
/* 77 */     if (loseHp == null) {
/* 78 */       return;
/*    */     }
/* 80 */     int cacheMultiValue = (int)(loseHp.intValue() * 1.0D / this.maxHp * FightArgs.getInstance().getDefaultRate() / this.hprate);
/* 81 */     outputObj.bedamagerate += cacheMultiValue * this.exdamagerate;
/* 82 */     outputObj.damageRate += cacheMultiValue * this.damagerate;
/* 83 */     this.cacheRound2Multi.put(Integer.valueOf(curRound), Integer.valueOf(cacheMultiValue));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Endure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */