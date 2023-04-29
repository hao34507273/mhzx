/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fight.event.PVEFightEnd;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightStart;
/*     */ import mzm.gsp.fight.event.PVEFightStartArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PVEFight
/*     */   extends Fight
/*     */ {
/*     */   PVEFight(long fightid, xbean.Fight xFight)
/*     */   {
/*  24 */     super(fightid, xFight);
/*     */   }
/*     */   
/*     */   protected void onFightStart()
/*     */   {
/*  29 */     super.onFightStart();
/*     */     
/*  31 */     PVEFightStartArg startArg = new PVEFightStartArg(this.fightid, getFightCfgid(), getFightContext(), getFightReason());
/*  32 */     startArg.roles.addAll(getActiveTeam().getTeamRoleids());
/*  33 */     startArg.monsters.addAll(getAllMonsters());
/*  34 */     TriggerEventsManger.getInstance().triggerEvent(new PVEFightStart(), startArg, FightOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void sendEndEvent(boolean playerWin, int reason)
/*     */   {
/*  41 */     boolean isForceEnd = reason == 104;
/*  42 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  44 */     PVEFightEndArg endArg = new PVEFightEndArg(this.fightid, playerWin, getFightCfgid(), curTime - getFightStartTime(), getRound(), getActiveTeam().getDeadTimes(), getFightReason(), getFightContext(), getFightStartTime(), reason, getActionTotalCount(), getActionMaxCurRound(), isForceEnd, getRecordid());
/*     */     
/*     */ 
/*     */ 
/*  48 */     Set<Fighter> fighters = new HashSet();
/*     */     
/*  50 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/*  51 */       fighters.addAll(fightGroup.getLeaveFightFighters());
/*  52 */       fighters.addAll(fightGroup.getFighters());
/*     */     }
/*     */     
/*  55 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/*  56 */       fighters.addAll(fightGroup.getLeaveFightFighters());
/*  57 */       fighters.addAll(fightGroup.getFighters());
/*     */     }
/*     */     
/*     */ 
/*  61 */     endArg.roleList.addAll(getActiveTeam().getTeamRoleids());
/*     */     
/*  63 */     for (Fighter fighter : fighters) {
/*  64 */       if (fighter.isMonster()) {
/*  65 */         FighterMonster fighterMonster = (FighterMonster)fighter;
/*  66 */         int monsterid = fighterMonster.getMonsterid();
/*  67 */         if (fighter.isAlive()) {
/*  68 */           endArg.alivedMonsters.add(Integer.valueOf(monsterid));
/*  69 */         } else if (fighter.isEscaped()) {
/*  70 */           endArg.escapedMonsters.add(Integer.valueOf(monsterid));
/*     */         } else {
/*  72 */           endArg.diedMonsters.add(Integer.valueOf(monsterid));
/*     */         }
/*  74 */         endArg.monsteridToLevel.put(Integer.valueOf(monsterid), Integer.valueOf(fighterMonster.getLevel()));
/*  75 */         if (!fighter.isActive())
/*     */         {
/*  77 */           endArg.passiveMonsterReliveCount += fighter.getReliveCount();
/*     */           
/*     */ 
/*  80 */           List<Integer> set = (List)endArg.monsterDeadInRound.get(Integer.valueOf(monsterid));
/*  81 */           if (set == null) {
/*  82 */             set = new ArrayList();
/*  83 */             endArg.monsterDeadInRound.put(Integer.valueOf(monsterid), set);
/*     */           }
/*  85 */           set.addAll(fighter.getDeadRounds());
/*     */         }
/*  87 */       } else if (fighter.isRole()) {
/*  88 */         long roleid = ((FighterRole)fighter).getRoleid();
/*  89 */         if (fighter.isAlive()) {
/*  90 */           endArg.alivedRoles.add(Long.valueOf(roleid));
/*  91 */         } else if (fighter.isEscaped()) {
/*  92 */           endArg.escapedRoles.add(Long.valueOf(roleid));
/*     */         } else {
/*  94 */           endArg.diedRoles.add(Long.valueOf(roleid));
/*     */         }
/*     */         
/*  97 */         endArg.setRoleCountInfo((FighterRole)fighter);
/*  98 */       } else if ((fighter instanceof FighterPet)) {
/*  99 */         FighterPet pet = (FighterPet)fighter;
/* 100 */         long roleid = pet.getOwnerid();
/* 101 */         List<Long> petids = (List)endArg.petids.get(Long.valueOf(roleid));
/* 102 */         if (petids == null) {
/* 103 */           petids = new ArrayList();
/* 104 */           endArg.petids.put(Long.valueOf(roleid), petids);
/*     */         }
/* 106 */         petids.add(Long.valueOf(pet.getUuid()));
/* 107 */       } else if ((fighter instanceof FighterFellow)) {
/* 108 */         FighterFellow fellow = (FighterFellow)fighter;
/* 109 */         long roleid = fellow.getOwnerid();
/* 110 */         List<Integer> fellowers = (List)endArg.fellowers.get(Long.valueOf(roleid));
/* 111 */         if (fellowers == null) {
/* 112 */           fellowers = new ArrayList();
/* 113 */           endArg.fellowers.put(Long.valueOf(roleid), fellowers);
/*     */         }
/* 115 */         fellowers.add(Integer.valueOf(fellow.getPartnerid()));
/*     */       }
/*     */       
/*     */ 
/* 119 */       if (fighter.isActive()) {
/* 120 */         endArg.passiveMonsterKillCount += fighter.getDeadCount();
/*     */       }
/*     */     }
/*     */     
/* 124 */     PVEFightEnd pveFightEnd = new PVEFightEnd();
/* 125 */     pveFightEnd.setSequential(true);
/* 126 */     TriggerEventsManger.getInstance().triggerEvent(pveFightEnd, endArg, FightOneByOneManager.getInstance().remTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */   protected int getFightCfgid()
/*     */   {
/* 132 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/* 133 */       if ((fightGroup instanceof FightGroupMonster)) {
/* 134 */         int fightCfgid = ((FightGroupMonster)fightGroup).getCfgID();
/* 135 */         if (fightCfgid > 0) {
/* 136 */           return fightCfgid;
/*     */         }
/*     */       }
/*     */     }
/* 140 */     return 0;
/*     */   }
/*     */   
/*     */   void fightEndOnTeamWin(boolean activeWin)
/*     */   {
/* 145 */     super.onFightEnd(activeWin, 101);
/*     */   }
/*     */   
/*     */   void fightEndOnForceEnd(int reason)
/*     */   {
/* 150 */     super.onFightEnd(false, reason);
/*     */   }
/*     */   
/*     */   protected boolean childCanSeeOppsiteHpProp()
/*     */   {
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PVEFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */