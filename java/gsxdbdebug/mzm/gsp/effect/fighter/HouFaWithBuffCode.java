/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class HouFaWithBuffCode extends HouFa implements mzm.gsp.effect.fighter.Interface.Validate, mzm.gsp.fight.handle.DamageHandle
/*    */ {
/*    */   private int buffstate;
/*    */   
/*    */   public HouFaWithBuffCode(int addatkrate, int addphydefrate, int addmagdefrate, int skillid, int buffstate)
/*    */   {
/* 12 */     super(addatkrate, addphydefrate, addmagdefrate, skillid);
/* 13 */     this.buffstate = buffstate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     super.attach(fighter);
/* 19 */     fighter.addBuffState(this.buffstate);
/* 20 */     fighter.addDamageHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     super.detach(fighter);
/* 27 */     fighter.remBuffState(this.buffstate);
/* 28 */     fighter.remDamageHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void onDamage(DamageHandle.InputObj inputObj, mzm.gsp.fight.handle.DamageHandle.OutputObj outputObj)
/*    */   {
/* 34 */     Fighter damageFighter = inputObj.getReleser();
/* 35 */     if (damageFighter == null) {
/* 36 */       return;
/*    */     }
/* 38 */     Fighter houfaFighter = getGroup().getReleaser(damageFighter);
/* 39 */     if (houfaFighter == null) {
/* 40 */       return;
/*    */     }
/* 42 */     if (damageFighter.getid() != houfaFighter.getid()) {
/* 43 */       return;
/*    */     }
/* 45 */     int damageSkillId = inputObj.getSkill().getID();
/* 46 */     if (damageSkillId != getskillid()) {
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     houfaFighter.remBuffState(this.buffstate);
/* 51 */     houfaFighter.removeBuff(getGroup());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HouFaWithBuffCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */