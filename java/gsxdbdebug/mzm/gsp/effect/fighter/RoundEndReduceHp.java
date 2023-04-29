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
/*    */ public class RoundEndReduceHp extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.RoundEndHandle
/*    */ {
/*    */   private int roundendreducehp;
/*    */   
/*    */   public RoundEndReduceHp(int roundendreducehp)
/*    */   {
/* 18 */     this.roundendreducehp = roundendreducehp;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addRoundEndHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remRoundEndHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter fighter)
/*    */   {
/* 35 */     if (!fighter.isAlive()) {
/* 36 */       return;
/*    */     }
/* 38 */     int reducehp = this.roundendreducehp;
/* 39 */     if (getGroup() != null) {
/* 40 */       if (getGroup().getEffectGroupType() == 16)
/*    */       {
/* 42 */         Fighter releaser = getGroup().getReleaser(fighter);
/* 43 */         BeforePoisonHandle.InputObj inputObj = new BeforePoisonHandle.InputObj(releaser, fighter, getGroup().getSkill());
/*    */         
/* 45 */         BeforePoisonHandle.OutputObj outputObj = fighter.handleonBeforePoison(inputObj);
/* 46 */         reducehp = (int)(reducehp * (1.0D + outputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */       }
/*    */       
/* 49 */       Fighter releserFighter = getGroup().getReleaser(fighter);
/* 50 */       if ((releserFighter != null) && (reducehp > 0)) {
/* 51 */         releserFighter.addDamageToFighter(fighter, reducehp);
/*    */       }
/*    */     }
/* 54 */     fighter.addHp(-reducehp);
/* 55 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 56 */     fighterStatus.hpchange -= reducehp;
/* 57 */     if ((fighter.isGhost()) && 
/* 58 */       (fighter.isDead())) {
/* 59 */       fighter.setFakeDead();
/*    */     }
/*    */     
/* 62 */     fighter.fillFighterStatus(fighterStatus);
/* 63 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 64 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new mzm.gsp.fight.handle.BeKilledHandle.InputObj(null, fighter, null, reducehp));
/*    */       
/* 66 */       if (fighter.isAlive()) {
/* 67 */         fighterStatus.status_set.remove(Integer.valueOf(1));
/* 68 */         fighterStatus.status_set.add(Integer.valueOf(3));
/* 69 */         FighterStatus reliveStatus = fighter.getAndAddRoundStatus();
/* 70 */         fighter.fillBuffStatus(reliveStatus);
/* 71 */         reliveStatus.hpchange += fighter.getHp();
/* 72 */         reliveStatus.status_set.add(Integer.valueOf(23));
/* 73 */         reliveStatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundEndReduceHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */