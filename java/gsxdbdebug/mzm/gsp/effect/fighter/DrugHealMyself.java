/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.DrugHandle.InputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class DrugHealMyself extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.DrugHandle
/*    */ {
/*    */   private int drughealrate;
/*    */   private int rate;
/*    */   
/*    */   public DrugHealMyself(int drughealrate, int rate)
/*    */   {
/* 14 */     this.drughealrate = drughealrate;
/* 15 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addDrugHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remDrugHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void onAfterDrug(DrugHandle.InputObj inputObj, mzm.gsp.fight.handle.DrugHandle.OutputObj outputObj)
/*    */   {
/* 32 */     Fighter reFighter = inputObj.getReleser();
/* 33 */     Fighter taFighter = inputObj.getTarget();
/* 34 */     if ((reFighter == null) || (taFighter == null)) {
/* 35 */       return;
/*    */     }
/* 37 */     if (reFighter.getid() == taFighter.getid()) {
/* 38 */       return;
/*    */     }
/* 40 */     int randdom = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 41 */     if (this.rate > randdom) {
/* 42 */       outputObj.drugSelfValue = ((int)(inputObj.getDrugValue() * (this.drughealrate * 1.0D / FightArgs.getInstance().getDefaultRate())));
/*    */       
/* 44 */       int passiveSkillid = getPassiveSkillid();
/* 45 */       if (passiveSkillid > 0) {
/* 46 */         outputObj.passiveSkills.add(Integer.valueOf(passiveSkillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DrugHealMyself.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */