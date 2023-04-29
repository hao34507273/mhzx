/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fight.event.PVPFightEnd;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightStart;
/*     */ import mzm.gsp.fight.event.PVPFightStartArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PVPFight
/*     */   extends Fight
/*     */ {
/*     */   PVPFight(long fightid, xbean.Fight xFight)
/*     */   {
/*  25 */     super(fightid, xFight);
/*     */   }
/*     */   
/*     */   protected void onFightStart()
/*     */   {
/*  30 */     super.onFightStart();
/*     */     
/*  32 */     PVPFightStartArg startArg = new PVPFightStartArg(this.fightid, getRecordid(), getFightContext());
/*  33 */     startArg.activeRoles.addAll(getActiveTeam().getTeamRoleids());
/*  34 */     startArg.passiveRoles.addAll(getPassiveTeam().getTeamRoleids());
/*  35 */     TriggerEventsManger.getInstance().triggerEvent(new PVPFightStart(), startArg, FightOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.fightid)));
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
/*  46 */     PVPFightEndArg endArg = new PVPFightEndArg(this.fightid, getCfgType(), getFightReason(), getFightContext(), activiteWin, (int)(curTime - startTime), getActiveTeam().getDeadTimes(), getPassiveTeam().getDeadTimes(), getRound(), startTime, reason, getActionTotalCount(), getActionMaxCurRound(), isForceEnd, getRecordid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  51 */     Set<Fighter> activeFighters = new HashSet();
/*     */     
/*  53 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/*  54 */       activeFighters.addAll(fightGroup.getLeaveFightFighters());
/*  55 */       activeFighters.addAll(fightGroup.getFighters());
/*     */     }
/*  57 */     for (Fighter fighter : activeFighters) {
/*  58 */       if ((fighter instanceof FighterRole)) {
/*  59 */         FighterRole fighterRole = (FighterRole)fighter;
/*  60 */         if (fighterRole.isEscaped()) {
/*  61 */           endArg.activeEscapedRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*  62 */         } else if (fighterRole.isAlive()) {
/*  63 */           endArg.activeAlivedRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*  64 */         } else if ((fighterRole.isDead()) || (fighterRole.isFakeDead())) {
/*  65 */           endArg.activeDeadRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*     */         }
/*     */         
/*  68 */         endArg.setRoleCountInfo(fighterRole);
/*  69 */       } else if ((fighter instanceof FighterPet)) {
/*  70 */         FighterPet pet = (FighterPet)fighter;
/*  71 */         long roleid = pet.getOwnerid();
/*  72 */         List<Long> petids = (List)endArg.rolePetMap.get(Long.valueOf(roleid));
/*  73 */         if (petids == null) {
/*  74 */           petids = new ArrayList();
/*  75 */           endArg.rolePetMap.put(Long.valueOf(roleid), petids);
/*     */         }
/*  77 */         petids.add(Long.valueOf(pet.getUuid()));
/*  78 */       } else if ((fighter instanceof FighterFellow)) {
/*  79 */         FighterFellow fellow = (FighterFellow)fighter;
/*  80 */         long roleid = fellow.getOwnerid();
/*  81 */         List<Integer> fellowers = (List)endArg.fellowers.get(Long.valueOf(roleid));
/*  82 */         if (fellowers == null) {
/*  83 */           fellowers = new ArrayList();
/*  84 */           endArg.fellowers.put(Long.valueOf(roleid), fellowers);
/*     */         }
/*  86 */         fellowers.add(Integer.valueOf(fellow.getPartnerid()));
/*  87 */       } else if ((fighter instanceof FighterChild)) {
/*  88 */         FighterChild child = (FighterChild)fighter;
/*  89 */         long roleid = child.getOwnerid();
/*  90 */         List<Long> children = (List)endArg.roleChildrenMap.get(Long.valueOf(roleid));
/*  91 */         if (children == null) {
/*  92 */           children = new ArrayList();
/*  93 */           endArg.roleChildrenMap.put(Long.valueOf(roleid), children);
/*     */         }
/*  95 */         long childid = child.getUuid();
/*  96 */         children.add(Long.valueOf(childid));
/*  97 */         if ((child.isDead()) || (child.isFakeDead())) {
/*  98 */           endArg.deadChildrens.add(Long.valueOf(childid));
/*     */         }
/*     */       }
/*     */     }
/* 102 */     endArg.activeRoleList.addAll(getActiveTeam().getTeamRoleids());
/*     */     
/* 104 */     Set<Fighter> passiveFighters = new HashSet();
/*     */     
/* 106 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/* 107 */       passiveFighters.addAll(fightGroup.getLeaveFightFighters());
/* 108 */       passiveFighters.addAll(fightGroup.getFighters());
/*     */     }
/* 110 */     for (Fighter fighter : passiveFighters) {
/* 111 */       if ((fighter instanceof FighterRole)) {
/* 112 */         FighterRole fighterRole = (FighterRole)fighter;
/* 113 */         if (fighterRole.isEscaped()) {
/* 114 */           endArg.passiveEscapedRoles.add(Long.valueOf(fighterRole.getRoleid()));
/* 115 */         } else if (fighterRole.isAlive()) {
/* 116 */           endArg.passiveAlivedRoles.add(Long.valueOf(fighterRole.getRoleid()));
/* 117 */         } else if ((fighterRole.isDead()) || (fighterRole.isFakeDead())) {
/* 118 */           endArg.passiveDeadRoles.add(Long.valueOf(fighterRole.getRoleid()));
/*     */         }
/* 120 */         endArg.setRoleCountInfo(fighterRole);
/* 121 */       } else if ((fighter instanceof FighterPet)) {
/* 122 */         FighterPet pet = (FighterPet)fighter;
/* 123 */         long roleid = pet.getOwnerid();
/* 124 */         List<Long> petids = (List)endArg.rolePetMap.get(Long.valueOf(roleid));
/* 125 */         if (petids == null) {
/* 126 */           petids = new ArrayList();
/* 127 */           endArg.rolePetMap.put(Long.valueOf(roleid), petids);
/*     */         }
/* 129 */         petids.add(Long.valueOf(pet.getUuid()));
/* 130 */       } else if ((fighter instanceof FighterFellow)) {
/* 131 */         FighterFellow fellow = (FighterFellow)fighter;
/* 132 */         long roleid = fellow.getOwnerid();
/* 133 */         List<Integer> fellowers = (List)endArg.fellowers.get(Long.valueOf(roleid));
/* 134 */         if (fellowers == null) {
/* 135 */           fellowers = new ArrayList();
/* 136 */           endArg.fellowers.put(Long.valueOf(roleid), fellowers);
/*     */         }
/* 138 */         fellowers.add(Integer.valueOf(fellow.getPartnerid()));
/* 139 */       } else if ((fighter instanceof FighterChild)) {
/* 140 */         FighterChild child = (FighterChild)fighter;
/* 141 */         long roleid = child.getOwnerid();
/* 142 */         List<Long> children = (List)endArg.roleChildrenMap.get(Long.valueOf(roleid));
/* 143 */         if (children == null) {
/* 144 */           children = new ArrayList();
/* 145 */           endArg.roleChildrenMap.put(Long.valueOf(roleid), children);
/*     */         }
/* 147 */         long childid = child.getUuid();
/* 148 */         children.add(Long.valueOf(childid));
/* 149 */         if ((child.isDead()) || (child.isFakeDead())) {
/* 150 */           endArg.deadChildrens.add(Long.valueOf(childid));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 155 */     PVPFightEnd pvpFightEnd = new PVPFightEnd();
/* 156 */     pvpFightEnd.setSequential(true);
/* 157 */     endArg.passiveRoleList.addAll(getPassiveTeam().getTeamRoleids());
/* 158 */     TriggerEventsManger.getInstance().triggerEvent(pvpFightEnd, endArg, FightOneByOneManager.getInstance().remTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */   void fightEndOnTeamWin(boolean activeWin)
/*     */   {
/* 164 */     super.onFightEnd(activeWin, 101);
/*     */   }
/*     */   
/*     */   boolean isActiveWinWhenForceEnd() {
/* 168 */     Set<Fighter> activeFighters = new HashSet();
/* 169 */     Set<Fighter> passiveFighters = new HashSet();
/* 170 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/* 171 */       activeFighters.addAll(fightGroup.getAliveRoleOrFellowFighters());
/*     */     }
/* 173 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/* 174 */       passiveFighters.addAll(fightGroup.getAliveRoleOrFellowFighters());
/*     */     }
/* 176 */     boolean activeWin = false;
/*     */     
/* 178 */     int activeSize = activeFighters.size();
/* 179 */     int passiveSize = passiveFighters.size();
/* 180 */     if (activeSize > passiveSize) {
/* 181 */       activeWin = true;
/* 182 */     } else if (activeSize == passiveSize)
/*     */     {
/* 184 */       int activeHp = 0;
/* 185 */       int passiveHp = 0;
/* 186 */       for (Fighter fighter : activeFighters) {
/* 187 */         activeHp += fighter.getHp();
/*     */       }
/* 189 */       for (Fighter fighter : passiveFighters) {
/* 190 */         passiveHp += fighter.getHp();
/*     */       }
/*     */       
/* 193 */       if (activeHp > passiveHp) {
/* 194 */         activeWin = true;
/* 195 */       } else if (activeHp == passiveHp) {
/* 196 */         activeWin = Xdb.random().nextBoolean();
/*     */       }
/*     */     }
/*     */     
/* 200 */     return activeWin;
/*     */   }
/*     */   
/*     */   void fightEndOnForceEnd(int reason)
/*     */   {
/* 205 */     boolean isActiveWin = isActiveWinWhenForceEnd();
/* 206 */     super.onFightEnd(isActiveWin, reason);
/*     */   }
/*     */   
/*     */   protected int getFightCfgid()
/*     */   {
/* 211 */     return 0;
/*     */   }
/*     */   
/*     */   protected boolean childCanSeeOppsiteHpProp()
/*     */   {
/* 216 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PVPFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */