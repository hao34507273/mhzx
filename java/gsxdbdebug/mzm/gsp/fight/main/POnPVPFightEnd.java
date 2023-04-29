/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*     */ import mzm.gsp.map.confbean.SMapGlobalConfig;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightStorage;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2fightstorage;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVPFightEnd
/*     */   extends PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     int activeSize = ((PVPFightEndArg)this.arg).activeRoleList.size();
/*  31 */     for (Long l : ((PVPFightEndArg)this.arg).activeRoleList) {
/*  32 */       long roleid = l.longValue();
/*  33 */       FightManager.logPVPFight(roleid, ((PVPFightEndArg)this.arg).fightCfgType, ((PVPFightEndArg)this.arg).fightReason, ((PVPFightEndArg)this.arg).fightid, 0, activeSize, ((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).round, ((PVPFightEndArg)this.arg).activeDeadTimes, ((PVPFightEndArg)this.arg).timeMills);
/*  34 */       FightManager.tLogPVPFight(roleid, ((PVPFightEndArg)this.arg).fightCfgType, ((PVPFightEndArg)this.arg).fightReason, ((PVPFightEndArg)this.arg).fightid, 0, activeSize, ((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).round, ((PVPFightEndArg)this.arg).activeDeadTimes, ((PVPFightEndArg)this.arg).timeMills);
/*  35 */       FightManager.tlogRoundFlow(roleid, 1, 0, ((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).timeMills / 1000, ((PVPFightEndArg)this.arg).round);
/*  36 */       FightManager.logRoundFlow(roleid, 1, 0, ((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).timeMills / 1000, ((PVPFightEndArg)this.arg).round);
/*     */     }
/*  38 */     int passiveSize = ((PVPFightEndArg)this.arg).passiveRoleList.size();
/*  39 */     for (Long l2 : ((PVPFightEndArg)this.arg).passiveRoleList) {
/*  40 */       long roleid2 = l2.longValue();
/*  41 */       FightManager.logPVPFight(roleid2, ((PVPFightEndArg)this.arg).fightCfgType, ((PVPFightEndArg)this.arg).fightReason, ((PVPFightEndArg)this.arg).fightid, 1, passiveSize, !((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).round, ((PVPFightEndArg)this.arg).passiveDeadTimes, ((PVPFightEndArg)this.arg).timeMills);
/*  42 */       FightManager.tLogPVPFight(roleid2, ((PVPFightEndArg)this.arg).fightCfgType, ((PVPFightEndArg)this.arg).fightReason, ((PVPFightEndArg)this.arg).fightid, 1, passiveSize, !((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).round, ((PVPFightEndArg)this.arg).passiveDeadTimes, ((PVPFightEndArg)this.arg).timeMills);
/*  43 */       FightManager.tlogRoundFlow(roleid2, 1, 0, !((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).timeMills / 1000, ((PVPFightEndArg)this.arg).round);
/*  44 */       FightManager.logRoundFlow(roleid2, 1, 0, !((PVPFightEndArg)this.arg).isActiveWin, ((PVPFightEndArg)this.arg).timeMills / 1000, ((PVPFightEndArg)this.arg).round);
/*     */     }
/*  46 */     Map<Long, String> role2User = new HashMap();
/*  47 */     Set<Long> allRoleSet = ((PVPFightEndArg)this.arg).getAllRoles();
/*  48 */     for (Long l3 : allRoleSet) {
/*  49 */       long roleid3 = l3.longValue();
/*  50 */       role2User.put(Long.valueOf(roleid3), RoleInterface.getUserId(roleid3));
/*     */     }
/*  52 */     lock(User.getTable(), role2User.values());
/*  53 */     lock(Role2properties.getTable(), allRoleSet);
/*  54 */     for (Long l4 : ((PVPFightEndArg)this.arg).activeRoleList) {
/*  55 */       long roleid4 = l4.longValue();
/*  56 */       String userid = (String)role2User.get(Long.valueOf(roleid4));
/*  57 */       if (!((PVPFightEndArg)this.arg).activeEscapedRoles.contains(Long.valueOf(roleid4))) {
/*  58 */         int fightEndReason = ((PVPFightEndArg)this.arg).fightEndReason;
/*  59 */         if (((PVPFightEndArg)this.arg).fightEndReason == 101) {
/*  60 */           if (((PVPFightEndArg)this.arg).isActiveWin) {
/*  61 */             fightEndReason = 1;
/*     */           } else {
/*  63 */             fightEndReason = 0;
/*     */           }
/*     */         }
/*  66 */         logNotEscapeRoles(roleid4, userid, fightEndReason);
/*     */       }
/*     */     }
/*  69 */     for (Long l5 : ((PVPFightEndArg)this.arg).passiveRoleList) {
/*  70 */       long roleid5 = l5.longValue();
/*  71 */       String userid2 = (String)role2User.get(Long.valueOf(roleid5));
/*  72 */       if (!((PVPFightEndArg)this.arg).passiveEscapedRoles.contains(Long.valueOf(roleid5))) {
/*  73 */         int fightEndReason2 = ((PVPFightEndArg)this.arg).fightEndReason;
/*  74 */         if (((PVPFightEndArg)this.arg).fightEndReason == 101) {
/*  75 */           if (!((PVPFightEndArg)this.arg).isActiveWin) {
/*  76 */             fightEndReason2 = 1;
/*     */           } else {
/*  78 */             fightEndReason2 = 0;
/*     */           }
/*     */         }
/*  81 */         logNotEscapeRoles(roleid5, userid2, fightEndReason2);
/*     */       }
/*     */     }
/*  84 */     int mapId = MapInterface.getRoleMapId(((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue());
/*  85 */     if ((SMapGlobalConfig.get(1).pkFailTrans.containsKey(Integer.valueOf(mapId))) && (((Boolean)SMapGlobalConfig.get(1).pkFailTrans.get(Integer.valueOf(mapId))).booleanValue())) {
/*  86 */       for (Long roleId : ((PVPFightEndArg)this.arg).getLoserList()) {
/*  87 */         MapInterface.transferToScene(roleId.longValue(), 330000001);
/*     */       }
/*     */     }
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   private void logNotEscapeRoles(long roleid, String userid, int fightEndReason) {
/*  94 */     List<Integer> partnerList = (List)((PVPFightEndArg)this.arg).fellowers.get(Long.valueOf(roleid));
/*  95 */     int partnerCount = 0;
/*  96 */     int partnerBattlePoint = 0;
/*  97 */     if (partnerList != null) {
/*  98 */       partnerCount = partnerList.size();
/*  99 */       for (Integer num : partnerList) {
/* 100 */         int partnerid = num.intValue();
/* 101 */         PartnerOutFightObj partnerOutFightObj = PartnerInterface.getPartnerOutFightObjById(roleid, partnerid);
/* 102 */         if (partnerOutFightObj == null) {
/* 103 */           GameServer.logger().error(String.format("[Fight]POnPVPFightEnd.processImp@not exist partner|roleid=%d|partnerid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(partnerid) }));
/*     */         } else {
/* 105 */           partnerBattlePoint += partnerOutFightObj.getFightValue();
/*     */         }
/*     */       }
/*     */     }
/* 109 */     List<Long> petList = (List)((PVPFightEndArg)this.arg).rolePetMap.get(Long.valueOf(roleid));
/* 110 */     int petLevel = 0;
/* 111 */     int petBattlePoint = 0;
/* 112 */     if ((petList != null) && (petList.size() > 0)) {
/* 113 */       long petid = ((Long)petList.get(0)).longValue();
/* 114 */       Pet pet = PetInterface.getPetById(roleid, petid);
/* 115 */       if (pet != null) {
/* 116 */         petLevel = pet.getLevel();
/* 117 */         petBattlePoint = pet.getPetYaoli();
/*     */       }
/*     */     }
/* 120 */     FightStorage xFightStorage = Role2fightstorage.get(Long.valueOf(roleid));
/* 121 */     if (xFightStorage == null) {
/* 122 */       xFightStorage = Pod.newFightStorage();
/* 123 */       Role2fightstorage.insert(Long.valueOf(roleid), xFightStorage);
/*     */     }
/* 125 */     long befroeBattleMills = xFightStorage.getLastestendtime();
/* 126 */     xFightStorage.setLastestendtime(((PVPFightEndArg)this.arg).timeMills + ((PVPFightEndArg)this.arg).startTime);
/* 127 */     int battleCDMil = Integer.MAX_VALUE;
/* 128 */     if (befroeBattleMills > 0L) {
/* 129 */       battleCDMil = (int)(((PVPFightEndArg)this.arg).startTime - befroeBattleMills);
/*     */     }
/* 131 */     FightManager.tlogFightSecurity(userid, roleid, partnerCount, partnerBattlePoint, petLevel, petBattlePoint, ((PVPFightEndArg)this.arg).fightReason, fightEndReason, 0, ((PVPFightEndArg)this.arg).timeMills, battleCDMil, ((PVPFightEndArg)this.arg).round, ((PVPFightEndArg)this.arg).actionMaxCountRound, ((PVPFightEndArg)this.arg).actionTotalCount, ((PVPFightEndArg)this.arg).startTime);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */