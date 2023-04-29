/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.AddAngerHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Irritability extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.AddAngerHandle
/*    */ {
/*    */   private int exangerrate;
/*    */   private int rate;
/*    */   
/*    */   public Irritability(int exangerrate, int rate)
/*    */   {
/* 14 */     this.exangerrate = exangerrate;
/* 15 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addAddAngerHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remAddAngerHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void onAddAnger(AddAngerHandle.OutputObj outputObj)
/*    */   {
/* 32 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 33 */     if (random < this.rate) {
/* 34 */       outputObj.finalAddAnger *= (1.0D + this.exangerrate * 1.0D / FightArgs.getInstance().getDefaultRate());
/*    */       
/* 36 */       int passiveSkill = getPassiveSkillid();
/* 37 */       if (passiveSkill > 0) {
/* 38 */         outputObj.passiveSkills.add(Integer.valueOf(passiveSkill));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Irritability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */