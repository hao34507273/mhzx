/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class MainSoulBonds extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.MainSoulDamageHandle
/*    */ {
/*    */   private int damagerate;
/*    */   
/*    */   public MainSoulBonds(int damagerate)
/*    */   {
/* 15 */     this.damagerate = damagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addBeDamageHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remBeDamageHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 32 */     if ((inputObj.isCounterAttack()) || (inputObj.isProtect())) {
/* 33 */       return;
/*    */     }
/* 35 */     Fighter target = inputObj.getTarget();
/* 36 */     if (target == null) {
/* 37 */       return;
/*    */     }
/* 39 */     java.util.Set<Fighter> fighters = target.getFriendLiveFighters();
/* 40 */     for (Fighter fighter : fighters) {
/* 41 */       if ((fighter.isSubSoulBond()) && (fighter.getid() != target.getid())) {
/* 42 */         outputObj.shareDamageFighters.add(fighter);
/*    */       }
/*    */     }
/* 45 */     if (outputObj.shareDamageFighters.size() <= 0) {
/* 46 */       return;
/*    */     }
/* 48 */     int nowdamage = (int)(outputObj.nowDamage * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 49 */     nowdamage = Math.max(nowdamage, 1);
/* 50 */     outputObj.shareDamage = (outputObj.nowDamage - nowdamage);
/* 51 */     outputObj.nowDamage = nowdamage;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MainSoulBonds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */