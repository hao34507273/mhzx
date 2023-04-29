/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.confbean.SFightCfg;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightStorage;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2fightstorage;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPvEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     final List<Long> logRoleList = new ArrayList(((PVEFightEndArg)this.arg).roleList);
/*  30 */     Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  34 */         int monsterlevel = 0;
/*  35 */         Iterator i$ = ((PVEFightEndArg)POnPvEFightEnd.this.arg).monsteridToLevel.values().iterator(); if (i$.hasNext()) { int level = ((Integer)i$.next()).intValue();
/*  36 */           monsterlevel = level;
/*     */         }
/*     */         
/*  39 */         int size = logRoleList.size();
/*  40 */         for (Iterator i$ = logRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  41 */           FightManager.logPveFight(roleid, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightReason, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightid, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightCfgID, monsterlevel, size, ((PVEFightEndArg)POnPvEFightEnd.this.arg).isPlayerWin, ((PVEFightEndArg)POnPvEFightEnd.this.arg).round, ((PVEFightEndArg)POnPvEFightEnd.this.arg).deadTimes);
/*     */           
/*  43 */           FightManager.tlogRoundFlow(roleid, 0, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightCfgID, ((PVEFightEndArg)POnPvEFightEnd.this.arg).isPlayerWin, (int)((PVEFightEndArg)POnPvEFightEnd.this.arg).timeMills / 1000, ((PVEFightEndArg)POnPvEFightEnd.this.arg).round);
/*     */           
/*  45 */           FightManager.logRoundFlow(roleid, 0, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightCfgID, ((PVEFightEndArg)POnPvEFightEnd.this.arg).isPlayerWin, (int)((PVEFightEndArg)POnPvEFightEnd.this.arg).timeMills / 1000, ((PVEFightEndArg)POnPvEFightEnd.this.arg).round);
/*     */           
/*  47 */           FightManager.tLogPveFight(roleid, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightReason, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightid, ((PVEFightEndArg)POnPvEFightEnd.this.arg).fightCfgID, monsterlevel, size, ((PVEFightEndArg)POnPvEFightEnd.this.arg).isPlayerWin, ((PVEFightEndArg)POnPvEFightEnd.this.arg).round, ((PVEFightEndArg)POnPvEFightEnd.this.arg).deadTimes);
/*     */         }
/*     */         
/*     */ 
/*  51 */         return true;
/*     */       }
/*     */       
/*  54 */     });
/*  55 */     Map<Long, String> allUsers = new HashMap();
/*  56 */     List<Long> allRoleList = new ArrayList();
/*  57 */     allRoleList.addAll(((PVEFightEndArg)this.arg).roleList);
/*  58 */     for (Long roleid : allRoleList) {
/*  59 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid.longValue());
/*  60 */       allUsers.put(roleid, userid);
/*     */     }
/*     */     
/*  63 */     lock(User.getTable(), allUsers.values());
/*     */     
/*  65 */     lock(xtable.Role2properties.getTable(), allRoleList);
/*     */     
/*  67 */     List<Long> notEscaperoleList = new ArrayList();
/*  68 */     notEscaperoleList.addAll(((PVEFightEndArg)this.arg).roleList);
/*  69 */     notEscaperoleList.removeAll(((PVEFightEndArg)this.arg).escapedRoles);
/*     */     
/*  71 */     Map<Long, mzm.gsp.award.main.AwardModel> awards = null;
/*     */     
/*  73 */     if (((PVEFightEndArg)this.arg).isPlayerWin) {
/*  74 */       List<Integer> awardList = new ArrayList();
/*  75 */       int battleid = ((PVEFightEndArg)this.arg).fightCfgID;
/*  76 */       SFightCfg fightCfg = FightInterface.getFightCfg(battleid);
/*  77 */       if (fightCfg.rewardId > 0) {
/*  78 */         awardList.add(Integer.valueOf(fightCfg.rewardId));
/*     */       }
/*  80 */       for (Iterator i$ = ((PVEFightEndArg)this.arg).diedMonsters.iterator(); i$.hasNext();) { int monsterid = ((Integer)i$.next()).intValue();
/*  81 */         int rewardid = MonsterInterface.getRewardId(monsterid);
/*  82 */         if (rewardid > 0) {
/*  83 */           awardList.add(Integer.valueOf(rewardid));
/*     */         }
/*     */       }
/*     */       
/*  87 */       List<String> userList = new ArrayList();
/*  88 */       for (Long roleId : notEscaperoleList) {
/*  89 */         userList.add(allUsers.get(roleId));
/*     */       }
/*  91 */       AwardReason awardReason = new AwardReason(LogReason.FIGHT_END_AWARD_ADD, ((PVEFightEndArg)this.arg).fightCfgID);
/*  92 */       awards = mzm.gsp.award.main.AwardInterface.award(awardList, userList, notEscaperoleList, allRoleList, false, true, awardReason);
/*     */     }
/*     */     
/*     */ 
/*  96 */     for (int i = 0; i < notEscaperoleList.size(); i++) {
/*  97 */       long roleid = ((Long)notEscaperoleList.get(i)).longValue();
/*  98 */       String userid = (String)allUsers.get(Long.valueOf(roleid));
/*     */       
/* 100 */       List<Integer> partnerList = (List)((PVEFightEndArg)this.arg).fellowers.get(Long.valueOf(roleid));
/* 101 */       int partnerCount = 0;
/* 102 */       int partnerBattlePoint = 0;
/* 103 */       Iterator i$; if (partnerList != null) {
/* 104 */         partnerCount = partnerList.size();
/* 105 */         for (i$ = partnerList.iterator(); i$.hasNext();) { int partnerid = ((Integer)i$.next()).intValue();
/* 106 */           PartnerOutFightObj partnerOutFightObj = mzm.gsp.partner.main.PartnerInterface.getPartnerOutFightObjById(roleid, partnerid);
/*     */           
/* 108 */           if (partnerOutFightObj == null) {
/* 109 */             GameServer.logger().error(String.format("[Fight]POnPvEFightEnd.processImp@not exist partner|roleid=%d|partnerid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(partnerid) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 114 */             partnerBattlePoint += partnerOutFightObj.getFightValue();
/*     */           }
/*     */         }
/*     */       }
/* 118 */       List<Long> petList = (List)((PVEFightEndArg)this.arg).petids.get(Long.valueOf(roleid));
/* 119 */       int petLevel = 0;
/* 120 */       int petBattlePoint = 0;
/* 121 */       if ((petList != null) && (petList.size() > 0)) {
/* 122 */         long petid = ((Long)petList.get(0)).longValue();
/* 123 */         Pet pet = PetInterface.getPetById(roleid, petid);
/* 124 */         if (pet != null) {
/* 125 */           petLevel = pet.getLevel();
/* 126 */           petBattlePoint = pet.getPetYaoli();
/*     */         }
/*     */       }
/*     */       
/* 130 */       int fightEndReason = ((PVEFightEndArg)this.arg).fightEndReason;
/* 131 */       if (((PVEFightEndArg)this.arg).fightEndReason == 101) {
/* 132 */         if (((PVEFightEndArg)this.arg).isPlayerWin) {
/* 133 */           fightEndReason = 1;
/*     */         } else {
/* 135 */           fightEndReason = 0;
/*     */         }
/*     */       }
/*     */       
/* 139 */       FightStorage xFightStorage = Role2fightstorage.get(Long.valueOf(roleid));
/* 140 */       if (xFightStorage == null) {
/* 141 */         xFightStorage = xbean.Pod.newFightStorage();
/* 142 */         Role2fightstorage.insert(Long.valueOf(roleid), xFightStorage);
/*     */       }
/* 144 */       long befroeBattleMills = xFightStorage.getLastestendtime();
/* 145 */       xFightStorage.setLastestendtime(((PVEFightEndArg)this.arg).timeMills + ((PVEFightEndArg)this.arg).startTime);
/*     */       
/* 147 */       int battleCDMil = Integer.MAX_VALUE;
/* 148 */       if (befroeBattleMills > 0L) {
/* 149 */         battleCDMil = (int)(((PVEFightEndArg)this.arg).startTime - befroeBattleMills);
/*     */       }
/* 151 */       FightManager.tlogFightSecurity(userid, roleid, partnerCount, partnerBattlePoint, petLevel, petBattlePoint, ((PVEFightEndArg)this.arg).fightReason, fightEndReason, ((PVEFightEndArg)this.arg).fightCfgID, (int)((PVEFightEndArg)this.arg).timeMills, battleCDMil, ((PVEFightEndArg)this.arg).round, ((PVEFightEndArg)this.arg).actionMaxCountRound, ((PVEFightEndArg)this.arg).actionTotalCount, ((PVEFightEndArg)this.arg).startTime, awards);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 157 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */