/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class RoundStartAddFixHp extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle
/*    */ {
/*    */   private int roundstartaddhp;
/*    */   
/*    */   public RoundStartAddFixHp(int roundstartaddhp)
/*    */   {
/* 18 */     this.roundstartaddhp = roundstartaddhp;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addRoundStartHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remRoundStartHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 35 */     if (!fighter.isAlive()) {
/* 36 */       return;
/*    */     }
/* 38 */     int addhp = this.roundstartaddhp;
/* 39 */     if (getGroup() != null) {
/* 40 */       if (getGroup().getEffectGroupType() == 16) {
/* 41 */         Fighter releaser = getGroup().getReleaser(fighter);
/* 42 */         BeforePoisonHandle.InputObj inputObj = new BeforePoisonHandle.InputObj(releaser, fighter, getGroup().getSkill());
/*    */         
/* 44 */         BeforePoisonHandle.OutputObj outputObj = fighter.handleonBeforePoison(inputObj);
/* 45 */         addhp = (int)(addhp * (1.0D + outputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */       }
/* 47 */       Fighter releserFighter = getGroup().getReleaser(fighter);
/* 48 */       if ((releserFighter != null) && (addhp < 0)) {
/* 49 */         releserFighter.addDamageToFighter(fighter, -addhp);
/*    */       }
/*    */     }
/* 52 */     fighter.addHp(addhp);
/* 53 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 54 */     fighterStatus.hpchange += addhp;
/* 55 */     if ((fighter.isGhost()) && 
/* 56 */       (fighter.isDead())) {
/* 57 */       fighter.setFakeDead();
/*    */     }
/*    */     
/* 60 */     fighter.fillFighterStatus(fighterStatus);
/* 61 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 62 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new mzm.gsp.fight.handle.BeKilledHandle.InputObj(null, fighter, null, -addhp));
/*    */       
/* 64 */       if (fighter.isAlive()) {
/* 65 */         fighterStatus.status_set.remove(Integer.valueOf(1));
/* 66 */         fighterStatus.status_set.add(Integer.valueOf(3));
/* 67 */         FighterStatus reliveStatus = fighter.getAndAddRoundStatus();
/* 68 */         fighter.fillBuffStatus(reliveStatus);
/* 69 */         reliveStatus.hpchange += fighter.getHp();
/* 70 */         reliveStatus.status_set.add(Integer.valueOf(23));
/* 71 */         reliveStatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAddFixHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */