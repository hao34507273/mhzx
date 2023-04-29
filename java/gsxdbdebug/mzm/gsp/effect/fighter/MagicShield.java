/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class MagicShield extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.Damagereduction
/*    */ {
/*    */   private int mask;
/*    */   private int damagerate;
/*    */   private int magicrate;
/*    */   
/*    */   public MagicShield(int mask, int damagerate, int magicrate)
/*    */   {
/* 15 */     this.mask = mask;
/* 16 */     this.damagerate = damagerate;
/* 17 */     this.magicrate = magicrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeDamageHandle(this);
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 28 */     fighter.remBeDamageHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(mzm.gsp.fight.handle.BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 34 */     int damageType = inputObj.getDamageType();
/* 35 */     Fighter target = inputObj.getTarget();
/* 36 */     if (target == null) {
/* 37 */       return;
/*    */     }
/* 39 */     if ((damageType & this.mask) > 0) {
/* 40 */       int cutDamage = (int)(outputObj.nowDamage * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 41 */       double transferRate = this.magicrate * 1.0D / FightArgs.getInstance().getDefaultRate();
/* 42 */       int canCutDamage = (int)(target.getMp() * transferRate);
/* 43 */       if (cutDamage >= canCutDamage) {
/* 44 */         target.addMp(-target.getMp());
/* 45 */         outputObj.nowDamage -= canCutDamage;
/*    */       }
/* 47 */       else if (transferRate > 0.0D) {
/* 48 */         int cutMp = (int)(cutDamage * 1.0D / transferRate);
/* 49 */         target.addMp(-cutMp);
/* 50 */         outputObj.nowDamage -= cutDamage;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MagicShield.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */