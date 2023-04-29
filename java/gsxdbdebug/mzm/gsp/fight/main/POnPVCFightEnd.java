/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVCFightEndArg;
/*    */ import mzm.gsp.fight.event.PVCFightEndProcedure;
/*    */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import xbean.FightStorage;
/*    */ import xtable.Role2fightstorage;
/*    */ 
/*    */ public class POnPVCFightEnd extends PVCFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     List<String> userids = new java.util.ArrayList();
/* 19 */     for (Iterator i$ = ((PVCFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 20 */       userids.add(mzm.gsp.role.main.RoleInterface.getUserId(roleid));
/*    */     }
/* 22 */     lock(xtable.User.getTable(), userids);
/* 23 */     lock(xtable.Role2properties.getTable(), ((PVCFightEndArg)this.arg).activeRoleList);
/* 24 */     for (int i = 0; i < ((PVCFightEndArg)this.arg).activeRoleList.size(); i++) {
/* 25 */       long roleid = ((Long)((PVCFightEndArg)this.arg).activeRoleList.get(i)).longValue();
/* 26 */       String userid = (String)userids.get(i);
/* 27 */       FightManager.tlogRoundFlow(roleid, 2, 0, ((PVCFightEndArg)this.arg).isActiveWin, (int)((PVCFightEndArg)this.arg).timeMills / 1000, ((PVCFightEndArg)this.arg).round);
/*    */       
/* 29 */       FightManager.logRoundFlow(roleid, 2, 0, ((PVCFightEndArg)this.arg).isActiveWin, (int)((PVCFightEndArg)this.arg).timeMills / 1000, ((PVCFightEndArg)this.arg).round);
/*    */       
/*    */ 
/* 32 */       if (!((PVCFightEndArg)this.arg).activeEscapedRoles.contains(Long.valueOf(roleid)))
/*    */       {
/*    */ 
/*    */ 
/* 36 */         List<Integer> partnerList = (List)((PVCFightEndArg)this.arg).activeFellowers.get(Long.valueOf(roleid));
/* 37 */         int partnerCount = 0;
/* 38 */         int partnerBattlePoint = 0;
/* 39 */         Iterator i$; if (partnerList != null) {
/* 40 */           partnerCount = partnerList.size();
/* 41 */           for (i$ = partnerList.iterator(); i$.hasNext();) { int partnerid = ((Integer)i$.next()).intValue();
/* 42 */             PartnerOutFightObj partnerOutFightObj = mzm.gsp.partner.main.PartnerInterface.getPartnerOutFightObjById(roleid, partnerid);
/*    */             
/* 44 */             if (partnerOutFightObj == null) {
/* 45 */               GameServer.logger().error(String.format("[Fight]POnPVCFightEnd.processImp@not exist partner|roleid=%d|partnerid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(partnerid) }));
/*    */ 
/*    */             }
/*    */             else
/*    */             {
/* 50 */               partnerBattlePoint += partnerOutFightObj.getFightValue();
/*    */             }
/*    */           }
/*    */         }
/* 54 */         List<Long> petList = (List)((PVCFightEndArg)this.arg).activePetids.get(Long.valueOf(roleid));
/* 55 */         int petLevel = 0;
/* 56 */         int petBattlePoint = 0;
/* 57 */         if ((petList != null) && (petList.size() > 0)) {
/* 58 */           long petid = ((Long)petList.get(0)).longValue();
/* 59 */           Pet pet = mzm.gsp.pet.main.PetInterface.getPetById(roleid, petid);
/* 60 */           if (pet != null) {
/* 61 */             petLevel = pet.getLevel();
/* 62 */             petBattlePoint = pet.getPetYaoli();
/*    */           }
/*    */         }
/*    */         
/* 66 */         int fightEndReason = ((PVCFightEndArg)this.arg).fightEndReason;
/* 67 */         if (((PVCFightEndArg)this.arg).fightEndReason == 101) {
/* 68 */           if (((PVCFightEndArg)this.arg).isActiveWin) {
/* 69 */             fightEndReason = 1;
/*    */           } else {
/* 71 */             fightEndReason = 0;
/*    */           }
/*    */         }
/* 74 */         FightStorage xFightStorage = Role2fightstorage.get(Long.valueOf(roleid));
/* 75 */         if (xFightStorage == null) {
/* 76 */           xFightStorage = xbean.Pod.newFightStorage();
/* 77 */           Role2fightstorage.insert(Long.valueOf(roleid), xFightStorage);
/*    */         }
/* 79 */         long befroeBattleMills = xFightStorage.getLastestendtime();
/* 80 */         xFightStorage.setLastestendtime(((PVCFightEndArg)this.arg).timeMills + ((PVCFightEndArg)this.arg).startTime);
/* 81 */         int battleCDMil = Integer.MAX_VALUE;
/* 82 */         if (befroeBattleMills > 0L) {
/* 83 */           battleCDMil = (int)(((PVCFightEndArg)this.arg).startTime - befroeBattleMills);
/*    */         }
/* 85 */         FightManager.tlogFightSecurity(userid, roleid, partnerCount, partnerBattlePoint, petLevel, petBattlePoint, ((PVCFightEndArg)this.arg).fightReason, fightEndReason, 0, (int)((PVCFightEndArg)this.arg).timeMills, battleCDMil, ((PVCFightEndArg)this.arg).round, ((PVCFightEndArg)this.arg).actionMaxCountRound, ((PVCFightEndArg)this.arg).actionTotalCount, ((PVCFightEndArg)this.arg).startTime);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */