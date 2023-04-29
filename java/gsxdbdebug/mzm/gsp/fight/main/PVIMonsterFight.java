/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fight.event.PVIMonsterFightEnd;
/*     */ import mzm.gsp.fight.event.PVIMonsterFightEndArg;
/*     */ import mzm.gsp.fight.event.PVIMonsterFightStart;
/*     */ import mzm.gsp.fight.event.PVIMonsterFightStartArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PVIMonsterFight
/*     */   extends Fight
/*     */ {
/*     */   PVIMonsterFight(long fightid, xbean.Fight xFight)
/*     */   {
/*  24 */     super(fightid, xFight);
/*     */   }
/*     */   
/*     */   protected void onFightStart()
/*     */   {
/*  29 */     super.onFightStart();
/*     */     
/*  31 */     PVIMonsterFightStartArg monsterFightStartArg = new PVIMonsterFightStartArg(this.fightid, getFightCfgid(), getFightContext());
/*     */     
/*  33 */     monsterFightStartArg.roles.addAll(getActiveTeam().getTeamRoleids());
/*  34 */     monsterFightStartArg.monsters.addAll(getAllMonsters());
/*  35 */     TriggerEventsManger.getInstance().triggerEvent(new PVIMonsterFightStart(), monsterFightStartArg, FightOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void sendEndEvent(boolean playerWin, int reason)
/*     */   {
/*  42 */     boolean isForceEnd = reason == 104;
/*  43 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  45 */     long startTime = getFightStartTime();
/*  46 */     PVIMonsterFightEndArg endArg = new PVIMonsterFightEndArg(this.fightid, playerWin, getFightCfgid(), curTime - startTime, getRound(), getActiveTeam().getDeadTimes(), getFightReason(), getFightContext(), startTime, reason, getActionTotalCount(), getActionMaxCurRound(), isForceEnd, getRecordid());
/*     */     
/*     */ 
/*     */ 
/*  50 */     Set<Fighter> fighters = new HashSet();
/*     */     
/*  52 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/*  53 */       fighters.addAll(fightGroup.getLeaveFightFighters());
/*  54 */       fighters.addAll(fightGroup.getFighters());
/*  55 */       long roleid = fightGroup.getRoleid();
/*  56 */       if (roleid > 0L) {
/*  57 */         if (endArg.roleDamageMap.containsKey(Long.valueOf(roleid))) {
/*  58 */           int damage = ((Integer)endArg.roleDamageMap.get(Long.valueOf(roleid))).intValue();
/*  59 */           endArg.roleDamageMap.put(Long.valueOf(roleid), Integer.valueOf(damage + fightGroup.getExtra(FightGroupExtra.Group_Damage)));
/*     */         } else {
/*  61 */           endArg.roleDamageMap.put(Long.valueOf(roleid), Integer.valueOf(fightGroup.getExtra(FightGroupExtra.Group_Damage)));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  66 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/*  67 */       fighters.addAll(fightGroup.getLeaveFightFighters());
/*  68 */       fighters.addAll(fightGroup.getFighters());
/*     */     }
/*     */     
/*     */ 
/*  72 */     endArg.roleList.addAll(getActiveTeam().getTeamRoleids());
/*     */     
/*  74 */     for (Fighter fighter : fighters) {
/*  75 */       if (fighter.isMonster()) {
/*  76 */         FighterMonster fighterMonster = (FighterMonster)fighter;
/*  77 */         int monsterid = fighterMonster.getMonsterid();
/*  78 */         if (fighter.isAlive()) {
/*  79 */           endArg.alivedMonsters.add(Integer.valueOf(monsterid));
/*  80 */         } else if (fighter.isEscaped()) {
/*  81 */           endArg.escapedMonsters.add(Integer.valueOf(monsterid));
/*     */         }
/*  83 */         endArg.monsteridToLevel.put(Integer.valueOf(monsterid), Integer.valueOf(fighterMonster.getLevel()));
/*  84 */       } else if (fighter.isRole()) {
/*  85 */         long roleid = ((FighterRole)fighter).getRoleid();
/*  86 */         if (fighter.isAlive()) {
/*  87 */           endArg.alivedRoles.add(Long.valueOf(roleid));
/*  88 */         } else if (fighter.isEscaped()) {
/*  89 */           endArg.escapedRoles.add(Long.valueOf(roleid));
/*     */         } else {
/*  91 */           endArg.diedRoles.add(Long.valueOf(roleid));
/*     */         }
/*  93 */         endArg.setRoleCountInfo((FighterRole)fighter);
/*  94 */       } else if ((fighter instanceof FighterPet)) {
/*  95 */         FighterPet pet = (FighterPet)fighter;
/*  96 */         long roleid = pet.getOwnerid();
/*  97 */         List<Long> petids = (List)endArg.petids.get(Long.valueOf(roleid));
/*  98 */         if (petids == null) {
/*  99 */           petids = new ArrayList();
/* 100 */           endArg.petids.put(Long.valueOf(roleid), petids);
/*     */         }
/* 102 */         petids.add(Long.valueOf(pet.getUuid()));
/* 103 */       } else if ((fighter instanceof FighterFellow)) {
/* 104 */         FighterFellow fellow = (FighterFellow)fighter;
/* 105 */         long roleid = fellow.getOwnerid();
/* 106 */         List<Integer> fellowers = (List)endArg.fellowers.get(Long.valueOf(roleid));
/* 107 */         if (fellowers == null) {
/* 108 */           fellowers = new ArrayList();
/* 109 */           endArg.fellowers.put(Long.valueOf(roleid), fellowers);
/*     */         }
/* 111 */         fellowers.add(Integer.valueOf(fellow.getPartnerid()));
/*     */       }
/*     */     }
/* 114 */     PVIMonsterFightEnd pviMonsterFightEnd = new PVIMonsterFightEnd();
/* 115 */     TriggerEventsManger.getInstance().triggerEvent(pviMonsterFightEnd, endArg, FightOneByOneManager.getInstance().remTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */   protected int getFightCfgid()
/*     */   {
/* 120 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/* 121 */       if ((fightGroup instanceof FightGroupMonster)) {
/* 122 */         return ((FightGroupMonster)fightGroup).getCfgID();
/*     */       }
/*     */     }
/* 125 */     return 0;
/*     */   }
/*     */   
/*     */   void fightEndOnTeamWin(boolean activeWin)
/*     */   {
/* 130 */     super.onFightEnd(activeWin, 101);
/*     */   }
/*     */   
/*     */   void fightEndOnForceEnd(int reason)
/*     */   {
/* 135 */     super.onFightEnd(false, reason);
/*     */   }
/*     */   
/*     */   protected boolean childCanSeeOppsiteHpProp()
/*     */   {
/* 140 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PVIMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */