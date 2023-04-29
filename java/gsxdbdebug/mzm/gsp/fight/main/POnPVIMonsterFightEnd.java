/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PVIMonsterFightEndArg;
/*     */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import xbean.FightStorage;
/*     */ import xtable.Role2fightstorage;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVIMonsterFightEnd extends mzm.gsp.fight.event.PVIMonsterFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     int monsterlevel = 0;
/*  22 */     Iterator i$ = ((PVIMonsterFightEndArg)this.arg).monsteridToLevel.values().iterator(); if (i$.hasNext()) { int level = ((Integer)i$.next()).intValue();
/*  23 */       monsterlevel = level;
/*     */     }
/*     */     
/*  26 */     int size = ((PVIMonsterFightEndArg)this.arg).roleList.size();
/*  27 */     for (Iterator i$ = ((PVIMonsterFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  28 */       FightManager.logPveFight(roleid, ((PVIMonsterFightEndArg)this.arg).fightReason, ((PVIMonsterFightEndArg)this.arg).fightid, ((PVIMonsterFightEndArg)this.arg).fightCfgID, monsterlevel, size, ((PVIMonsterFightEndArg)this.arg).isPlayerWin, ((PVIMonsterFightEndArg)this.arg).round, ((PVIMonsterFightEndArg)this.arg).deadTimes);
/*     */       
/*  30 */       FightManager.tlogRoundFlow(roleid, 0, ((PVIMonsterFightEndArg)this.arg).fightCfgID, ((PVIMonsterFightEndArg)this.arg).isPlayerWin, (int)((PVIMonsterFightEndArg)this.arg).timeMills / 1000, ((PVIMonsterFightEndArg)this.arg).round);
/*     */       
/*  32 */       FightManager.logRoundFlow(roleid, 0, ((PVIMonsterFightEndArg)this.arg).fightCfgID, ((PVIMonsterFightEndArg)this.arg).isPlayerWin, (int)((PVIMonsterFightEndArg)this.arg).timeMills / 1000, ((PVIMonsterFightEndArg)this.arg).round);
/*     */       
/*  34 */       FightManager.tLogPveFight(roleid, ((PVIMonsterFightEndArg)this.arg).fightReason, ((PVIMonsterFightEndArg)this.arg).fightid, ((PVIMonsterFightEndArg)this.arg).fightCfgID, monsterlevel, size, ((PVIMonsterFightEndArg)this.arg).isPlayerWin, ((PVIMonsterFightEndArg)this.arg).round, ((PVIMonsterFightEndArg)this.arg).deadTimes);
/*     */     }
/*     */     
/*     */ 
/*  38 */     Map<Long, String> allUsers = new HashMap();
/*  39 */     List<Long> allRoleList = new ArrayList();
/*  40 */     allRoleList.addAll(((PVIMonsterFightEndArg)this.arg).roleList);
/*  41 */     for (Long roleid : allRoleList) {
/*  42 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid.longValue());
/*  43 */       allUsers.put(roleid, userid);
/*     */     }
/*     */     
/*  46 */     lock(User.getTable(), allUsers.values());
/*     */     
/*  48 */     lock(xtable.Role2properties.getTable(), allRoleList);
/*     */     
/*  50 */     List<Long> notEscaperoleList = new ArrayList();
/*  51 */     notEscaperoleList.addAll(((PVIMonsterFightEndArg)this.arg).roleList);
/*  52 */     notEscaperoleList.removeAll(((PVIMonsterFightEndArg)this.arg).escapedRoles);
/*     */     
/*  54 */     for (int i = 0; i < notEscaperoleList.size(); i++) {
/*  55 */       long roleid = ((Long)notEscaperoleList.get(i)).longValue();
/*  56 */       String userid = (String)allUsers.get(Long.valueOf(roleid));
/*     */       
/*  58 */       List<Integer> partnerList = (List)((PVIMonsterFightEndArg)this.arg).fellowers.get(Long.valueOf(roleid));
/*  59 */       int partnerCount = 0;
/*  60 */       int partnerBattlePoint = 0;
/*  61 */       Iterator i$; if (partnerList != null) {
/*  62 */         partnerCount = partnerList.size();
/*  63 */         for (i$ = partnerList.iterator(); i$.hasNext();) { int partnerid = ((Integer)i$.next()).intValue();
/*  64 */           PartnerOutFightObj partnerOutFightObj = mzm.gsp.partner.main.PartnerInterface.getPartnerOutFightObjById(roleid, partnerid);
/*     */           
/*  66 */           if (partnerOutFightObj == null) {
/*  67 */             GameServer.logger().error(String.format("[Fight]POnPvEFightEnd.processImp@not exist partner|roleid=%d|partnerid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(partnerid) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*  72 */             partnerBattlePoint += partnerOutFightObj.getFightValue();
/*     */           }
/*     */         }
/*     */       }
/*  76 */       List<Long> petList = (List)((PVIMonsterFightEndArg)this.arg).petids.get(Long.valueOf(roleid));
/*  77 */       int petLevel = 0;
/*  78 */       int petBattlePoint = 0;
/*  79 */       if ((petList != null) && (petList.size() > 0)) {
/*  80 */         long petid = ((Long)petList.get(0)).longValue();
/*  81 */         Pet pet = mzm.gsp.pet.main.PetInterface.getPetById(roleid, petid);
/*  82 */         if (pet != null) {
/*  83 */           petLevel = pet.getLevel();
/*  84 */           petBattlePoint = pet.getPetYaoli();
/*     */         }
/*     */       }
/*     */       
/*  88 */       int fightEndReason = ((PVIMonsterFightEndArg)this.arg).fightEndReason;
/*  89 */       if (((PVIMonsterFightEndArg)this.arg).fightEndReason == 101) {
/*  90 */         if (((PVIMonsterFightEndArg)this.arg).isPlayerWin) {
/*  91 */           fightEndReason = 1;
/*     */         } else {
/*  93 */           fightEndReason = 0;
/*     */         }
/*     */       }
/*     */       
/*  97 */       FightStorage xFightStorage = Role2fightstorage.get(Long.valueOf(roleid));
/*  98 */       if (xFightStorage == null) {
/*  99 */         xFightStorage = xbean.Pod.newFightStorage();
/* 100 */         Role2fightstorage.insert(Long.valueOf(roleid), xFightStorage);
/*     */       }
/* 102 */       long befroeBattleMills = xFightStorage.getLastestendtime();
/* 103 */       xFightStorage.setLastestendtime(((PVIMonsterFightEndArg)this.arg).timeMills + ((PVIMonsterFightEndArg)this.arg).startTime);
/*     */       
/* 105 */       int battleCDMil = Integer.MAX_VALUE;
/* 106 */       if (befroeBattleMills > 0L) {
/* 107 */         battleCDMil = (int)(((PVIMonsterFightEndArg)this.arg).startTime - befroeBattleMills);
/*     */       }
/* 109 */       FightManager.tlogFightSecurity(userid, roleid, partnerCount, partnerBattlePoint, petLevel, petBattlePoint, ((PVIMonsterFightEndArg)this.arg).fightReason, fightEndReason, ((PVIMonsterFightEndArg)this.arg).fightCfgID, (int)((PVIMonsterFightEndArg)this.arg).timeMills, battleCDMil, ((PVIMonsterFightEndArg)this.arg).round, ((PVIMonsterFightEndArg)this.arg).actionMaxCountRound, ((PVIMonsterFightEndArg)this.arg).actionTotalCount, ((PVIMonsterFightEndArg)this.arg).startTime);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPVIMonsterFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */