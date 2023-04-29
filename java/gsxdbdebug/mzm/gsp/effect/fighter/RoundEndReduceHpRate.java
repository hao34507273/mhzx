/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.RoundEndHandle;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class RoundEndReduceHpRate extends mzm.gsp.effect.main.FighterEffect implements RoundEndHandle
/*    */ {
/*    */   private int roundendreducehprate;
/*    */   private int max;
/*    */   
/*    */   public RoundEndReduceHpRate(int roundendreducehprate, int max)
/*    */   {
/* 20 */     this.roundendreducehprate = roundendreducehprate;
/* 21 */     this.max = max;
/* 22 */     if (roundendreducehprate > max) {
/* 23 */       this.roundendreducehprate = max;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 29 */     fighter.addRoundEndHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 35 */     fighter.remRoundEndHandle(this);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter fighter)
/*    */   {
/* 41 */     if (!fighter.isAlive()) {
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     int reducehp = (int)(fighter.getHp() * (this.roundendreducehprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 46 */     if (getGroup() != null) {
/* 47 */       if (getGroup().getEffectGroupType() == 16) {
/* 48 */         Fighter releaser = getGroup().getReleaser(fighter);
/* 49 */         BeforePoisonHandle.InputObj inputObj = new BeforePoisonHandle.InputObj(releaser, fighter, getGroup().getSkill());
/*    */         
/* 51 */         BeforePoisonHandle.OutputObj outputObj = fighter.handleonBeforePoison(inputObj);
/* 52 */         reducehp = (int)(reducehp * (1.0D + outputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */       }
/*    */       
/* 55 */       Fighter releserFighter = getGroup().getReleaser(fighter);
/* 56 */       if ((releserFighter != null) && (reducehp > 0)) {
/* 57 */         releserFighter.addDamageToFighter(fighter, reducehp);
/*    */       }
/*    */     }
/* 60 */     fighter.addHp(-reducehp);
/* 61 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 62 */     fighterStatus.hpchange -= reducehp;
/* 63 */     if ((fighter.isGhost()) && 
/* 64 */       (fighter.isDead())) {
/* 65 */       fighter.setFakeDead();
/*    */     }
/*    */     
/* 68 */     fighter.fillFighterStatus(fighterStatus);
/* 69 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 70 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new mzm.gsp.fight.handle.BeKilledHandle.InputObj(null, fighter, null, reducehp));
/*    */       
/* 72 */       if (fighter.isAlive()) {
/* 73 */         fighterStatus.status_set.remove(Integer.valueOf(1));
/* 74 */         fighterStatus.status_set.add(Integer.valueOf(3));
/* 75 */         FighterStatus reliveStatus = fighter.getAndAddRoundStatus();
/* 76 */         fighter.fillBuffStatus(reliveStatus);
/* 77 */         reliveStatus.hpchange += fighter.getHp();
/* 78 */         reliveStatus.status_set.add(Integer.valueOf(23));
/* 79 */         reliveStatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundEndReduceHpRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */