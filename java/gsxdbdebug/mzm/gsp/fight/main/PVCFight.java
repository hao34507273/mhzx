/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fight.event.PVCFightEnd;
/*     */ import mzm.gsp.fight.event.PVCFightEndArg;
/*     */ import mzm.gsp.fight.event.PVCFightStart;
/*     */ import mzm.gsp.fight.event.PVCFightStartArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PVCFight
/*     */   extends Fight
/*     */ {
/*     */   PVCFight(long fightid, xbean.Fight xFight)
/*     */   {
/*  25 */     super(fightid, xFight);
/*     */   }
/*     */   
/*     */   protected void onFightStart()
/*     */   {
/*  30 */     super.onFightStart();
/*     */     
/*  32 */     PVCFightStartArg startArg = new PVCFightStartArg(this.fightid, getFightContext());
/*  33 */     startArg.activeRoles.addAll(getActiveTeam().getTeamRoleids());
/*  34 */     startArg.passiveRoles.addAll(getPassiveTeam().getTeamRoleids());
/*  35 */     TriggerEventsManger.getInstance().triggerEvent(new PVCFightStart(), startArg, FightOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void sendEndEvent(boolean activiteWin, int reason)
/*     */   {
/*  42 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  44 */     boolean isForceEnd = reason == 104;
/*  45 */     long startTime = getFightStartTime();
/*  46 */     PVCFightEndArg endArg = new PVCFightEndArg(this.fightid, getFightContext(), getFightReason(), activiteWin, curTime - startTime, getRound(), startTime, reason, getActionTotalCount(), getActionMaxCurRound(), isForceEnd, getRecordid());
/*     */     
/*     */ 
/*     */ 
/*  50 */     Set<Fighter> activeFighters = new HashSet();
/*     */     
/*  52 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/*  53 */       activeFighters.addAll(fightGroup.getLeaveFightFighters());
/*  54 */       activeFighters.addAll(fightGroup.getFighters());
/*     */     }
/*  56 */     for (Fighter fighter : activeFighters) {
/*  57 */       if ((fighter instanceof FighterRole)) {
/*  58 */         FighterRole fighterRole = (FighterRole)fighter;
/*  59 */         if (fighterRole.isEscaped()) {
/*  60 */           endArg.activeEscapedRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*  61 */         } else if (fighterRole.isAlive()) {
/*  62 */           endArg.activeAlivedRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*  63 */         } else if ((fighterRole.isDead()) || (fighterRole.isFakeDead())) {
/*  64 */           endArg.activeDeadRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*     */         }
/*  66 */         endArg.setRoleCountInfo(fighterRole);
/*  67 */       } else if ((fighter instanceof FighterPet)) {
/*  68 */         FighterPet pet = (FighterPet)fighter;
/*  69 */         long roleid = pet.getOwnerid();
/*  70 */         List<Long> petids = (List)endArg.activePetids.get(Long.valueOf(roleid));
/*  71 */         if (petids == null) {
/*  72 */           petids = new ArrayList();
/*  73 */           endArg.activePetids.put(Long.valueOf(roleid), petids);
/*     */         }
/*  75 */         petids.add(Long.valueOf(pet.getUuid()));
/*  76 */       } else if ((fighter instanceof FighterFellow)) {
/*  77 */         FighterFellow fellow = (FighterFellow)fighter;
/*  78 */         long roleid = fellow.getOwnerid();
/*  79 */         List<Integer> fellowers = (List)endArg.activeFellowers.get(Long.valueOf(roleid));
/*  80 */         if (fellowers == null) {
/*  81 */           fellowers = new ArrayList();
/*  82 */           endArg.activeFellowers.put(Long.valueOf(roleid), fellowers);
/*     */         }
/*  84 */         fellowers.add(Integer.valueOf(fellow.getPartnerid()));
/*     */       }
/*     */     }
/*     */     
/*  88 */     endArg.activeRoleList.addAll(getActiveTeam().getTeamRoleids());
/*     */     
/*  90 */     Set<Fighter> passiveFighters = new HashSet();
/*     */     
/*  92 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/*  93 */       passiveFighters.addAll(fightGroup.getLeaveFightFighters());
/*  94 */       passiveFighters.addAll(fightGroup.getFighters());
/*     */     }
/*  96 */     for (Fighter fighter : passiveFighters) {
/*  97 */       if ((fighter instanceof CloneFighterRole)) {
/*  98 */         endArg.passiveRoleList.add(Long.valueOf(fighter.fightGroup.getRoleid()));
/*     */       }
/*     */     }
/* 101 */     TriggerEventsManger.getInstance().triggerEvent(new PVCFightEnd(), endArg, FightOneByOneManager.getInstance().remTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */   void fightEndOnTeamWin(boolean activeWin)
/*     */   {
/* 107 */     super.onFightEnd(activeWin, 101);
/*     */   }
/*     */   
/*     */   boolean isActiveWinWhenForceEnd() {
/* 111 */     Set<Fighter> activeFighters = new HashSet();
/* 112 */     Set<Fighter> passiveFighters = new HashSet();
/* 113 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/* 114 */       activeFighters.addAll(fightGroup.getAliveRoleOrFellowFighters());
/*     */     }
/* 116 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/* 117 */       passiveFighters.addAll(fightGroup.getAliveRoleOrFellowFighters());
/*     */     }
/* 119 */     boolean activeWin = false;
/*     */     
/* 121 */     int activeSize = activeFighters.size();
/* 122 */     int passiveSize = passiveFighters.size();
/* 123 */     if (activeSize > passiveSize) {
/* 124 */       activeWin = true;
/* 125 */     } else if (activeSize == passiveSize)
/*     */     {
/* 127 */       int activeHp = 0;
/* 128 */       int passiveHp = 0;
/* 129 */       for (Fighter fighter : activeFighters) {
/* 130 */         activeHp += fighter.getHp();
/*     */       }
/* 132 */       for (Fighter fighter : passiveFighters) {
/* 133 */         passiveHp += fighter.getHp();
/*     */       }
/*     */       
/* 136 */       if (activeHp > passiveHp) {
/* 137 */         activeWin = true;
/* 138 */       } else if (activeHp == passiveHp) {
/* 139 */         activeWin = Xdb.random().nextBoolean();
/*     */       }
/*     */     }
/*     */     
/* 143 */     return activeWin;
/*     */   }
/*     */   
/*     */   void fightEndOnForceEnd(int reason)
/*     */   {
/* 148 */     boolean activeWin = isActiveWinWhenForceEnd();
/* 149 */     super.onFightEnd(activeWin, reason);
/*     */   }
/*     */   
/*     */   protected int getFightCfgid()
/*     */   {
/* 154 */     return 0;
/*     */   }
/*     */   
/*     */   protected boolean childCanSeeOppsiteHpProp()
/*     */   {
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PVCFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */