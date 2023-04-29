/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class BeDrugHeal extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeHealHandle
/*    */ {
/*    */   private int exbedrughealrate;
/*    */   private int rate;
/*    */   
/*    */   public BeDrugHeal(int exbedrughealrate, int rate)
/*    */   {
/* 15 */     this.exbedrughealrate = exbedrughealrate;
/* 16 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 21 */     fighter.addBeforeHealHandle(this);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 27 */     fighter.remBeforeHealHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeHeal(BeforeHealHandle.InputObj inputObj, BeforeHealHandle.OutputObj outputObj)
/*    */   {
/* 33 */     mzm.gsp.effect.main.FighterEffectGroup fighterEffectGroup = inputObj.getFighterEffectGroup();
/* 34 */     if ((fighterEffectGroup == null) || (!fighterEffectGroup.isFromDrag())) {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 39 */     if (this.rate > random) {
/* 40 */       outputObj.beHealEffectrate += this.exbedrughealrate;
/* 41 */       int passiveSkillid = getPassiveSkillid();
/* 42 */       if (passiveSkillid > 0) {
/* 43 */         outputObj.targetPassiveSkills.add(Integer.valueOf(passiveSkillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BeDrugHeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */