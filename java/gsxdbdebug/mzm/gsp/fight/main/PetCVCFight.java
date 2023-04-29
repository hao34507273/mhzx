/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PetFightCVCEnd;
/*     */ import mzm.gsp.fight.event.PetFightCVCEndArg;
/*     */ import mzm.gsp.fight.event.PetFightCVCStartArg;
/*     */ 
/*     */ public class PetCVCFight extends Fight
/*     */ {
/*     */   public PetCVCFight(long fightid, xbean.Fight xFight)
/*     */   {
/*  19 */     super(fightid, xFight);
/*     */   }
/*     */   
/*     */   protected void onFightStart()
/*     */   {
/*  24 */     super.onFightStart();
/*     */     
/*  26 */     PetFightCVCStartArg startArg = new PetFightCVCStartArg(this.fightid, getFightContext());
/*  27 */     startArg.activeRoles.addAll(getActiveTeam().getTeamRoleids());
/*  28 */     startArg.passiveRoles.addAll(getPassiveTeam().getTeamRoleids());
/*     */     
/*  30 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fight.event.PetFightCVCStart(), startArg, FightOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */   void fightEndOnForceEnd(int reason)
/*     */   {
/*  36 */     onFightEnd(false, reason);
/*     */   }
/*     */   
/*     */   void fightEndOnTeamWin(boolean activeWin)
/*     */   {
/*  41 */     onFightEnd(activeWin, 101);
/*     */   }
/*     */   
/*     */   protected void onFightEnd(boolean activeWin, int reason)
/*     */   {
/*  46 */     roleFightEnd();
/*  47 */     super.onFightEnd(activeWin, reason);
/*     */   }
/*     */   
/*     */   protected void sendEndEvent(boolean activiteWin, int reason)
/*     */   {
/*  52 */     PetFightCVCEnd fightEnd = new PetFightCVCEnd();
/*  53 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  55 */     boolean isForceEnd = reason == 104;
/*  56 */     long startTime = getFightStartTime();
/*  57 */     PetFightCVCEndArg endArg = new PetFightCVCEndArg(this.fightid, getCfgType(), getFightReason(), getFightContext(), activiteWin, (int)(curTime - startTime), getActiveTeam().getDeadTimes(), getPassiveTeam().getDeadTimes(), getRound(), startTime, reason, getActionTotalCount(), getActionMaxCurRound(), isForceEnd, getRecordid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     Set<Fighter> activeFighters = new HashSet();
/*     */     
/*  64 */     for (FightGroup fightGroup : getActiveTeam().getGroups()) {
/*  65 */       activeFighters.addAll(fightGroup.getLeaveFightFighters());
/*  66 */       activeFighters.addAll(fightGroup.getFighters());
/*     */     }
/*  68 */     for (Fighter fighter : activeFighters) {
/*  69 */       if ((fighter instanceof CloneFighterPet)) {
/*  70 */         CloneFighterPet pet = (CloneFighterPet)fighter;
/*  71 */         long roleid = pet.getOwnerid();
/*  72 */         List<Long> petids = (List)endArg.rolePetMap.get(Long.valueOf(roleid));
/*  73 */         if (petids == null) {
/*  74 */           petids = new ArrayList();
/*  75 */           endArg.rolePetMap.put(Long.valueOf(roleid), petids);
/*     */         }
/*  77 */         petids.add(Long.valueOf(pet.getUuid()));
/*     */         
/*  79 */         endArg.petDamages.put(Long.valueOf(pet.getUuid()), Integer.valueOf(fighter.getDamage()));
/*     */       }
/*     */     }
/*  82 */     endArg.activeRoleList.addAll(getActiveTeam().getTeamRoleids());
/*     */     
/*  84 */     Set<Fighter> passiveFighters = new HashSet();
/*     */     
/*  86 */     for (FightGroup fightGroup : getPassiveTeam().getGroups()) {
/*  87 */       passiveFighters.addAll(fightGroup.getLeaveFightFighters());
/*  88 */       passiveFighters.addAll(fightGroup.getFighters());
/*     */     }
/*  90 */     for (Fighter fighter : passiveFighters) {
/*  91 */       if ((fighter instanceof CloneFighterPet)) {
/*  92 */         CloneFighterPet pet = (CloneFighterPet)fighter;
/*  93 */         long roleid = pet.getOwnerid();
/*  94 */         List<Long> petids = (List)endArg.rolePetMap.get(Long.valueOf(roleid));
/*  95 */         if (petids == null) {
/*  96 */           petids = new ArrayList();
/*  97 */           endArg.rolePetMap.put(Long.valueOf(roleid), petids);
/*     */         }
/*  99 */         petids.add(Long.valueOf(pet.getUuid()));
/*     */         
/* 101 */         endArg.petDamages.put(Long.valueOf(pet.getUuid()), Integer.valueOf(fighter.getDamage()));
/* 102 */       } else if (fighter.isMonster()) {
/* 103 */         FighterMonster monster = (FighterMonster)fighter;
/* 104 */         endArg.petDamages.put(Long.valueOf(monster.getUuid()), Integer.valueOf(fighter.getDamage()));
/*     */       }
/*     */     }
/* 107 */     TriggerEventsManger.getInstance().triggerEvent(fightEnd, endArg, FightOneByOneManager.getInstance().remTaskOneByOne(Long.valueOf(this.fightid)));
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean childCanSeeOppsiteHpProp()
/*     */   {
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   protected int getFightCfgid()
/*     */   {
/* 118 */     return 0;
/*     */   }
/*     */   
/*     */   public Set<Long> getRoleId(FightTeam team) {
/* 122 */     return team.getLockRoles();
/*     */   }
/*     */   
/*     */   protected void roleFightEnd() {
/* 126 */     Set<Long> roles = new HashSet();
/* 127 */     roles.addAll(getRoleId(getActiveTeam()));
/* 128 */     roles.addAll(getRoleId(getPassiveTeam()));
/*     */     
/* 130 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long role = ((Long)i$.next()).longValue();
/* 131 */       Long fightIdLong = xtable.Role2fight.get(Long.valueOf(role));
/* 132 */       GameServer.logger().info(String.format("[fight]PetFight.roleFightEnd@role fight end|roleid=%d|fightid=%d", new Object[] { Long.valueOf(role), Long.valueOf(fightIdLong == null ? 0L : fightIdLong.longValue()) }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PetCVCFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */