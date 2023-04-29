/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.fight.event.RoleEscapeProcedure;
/*    */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FightStorage;
/*    */ import xtable.Role2fightstorage;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleEscape extends RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(((RoleEscapeArg)this.arg).roleid);
/* 21 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 22 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(((RoleEscapeArg)this.arg).roleid) }));
/*    */     
/* 24 */     int partnerCount = 0;
/* 25 */     int partnerBattlePoint = 0;
/* 26 */     Iterator i$; if (((RoleEscapeArg)this.arg).fellowers != null) {
/* 27 */       partnerCount = ((RoleEscapeArg)this.arg).fellowers.size();
/* 28 */       for (i$ = ((RoleEscapeArg)this.arg).fellowers.iterator(); i$.hasNext();) { int partnerid = ((Integer)i$.next()).intValue();
/* 29 */         PartnerOutFightObj partnerOutFightObj = mzm.gsp.partner.main.PartnerInterface.getPartnerOutFightObjById(((RoleEscapeArg)this.arg).roleid, partnerid);
/*    */         
/* 31 */         if (partnerOutFightObj == null) {
/* 32 */           GameServer.logger().error(String.format("[Fight]POnRoleEscape.processImp@not exist partner|roleid=%d|partnerid=%d", new Object[] { Long.valueOf(((RoleEscapeArg)this.arg).roleid), Integer.valueOf(partnerid) }));
/*    */         }
/*    */         else
/*    */         {
/* 36 */           partnerBattlePoint += partnerOutFightObj.getFightValue();
/*    */         }
/*    */       }
/*    */     }
/* 40 */     List<Long> petList = ((RoleEscapeArg)this.arg).petids;
/* 41 */     int petLevel = 0;
/* 42 */     int petBattlePoint = 0;
/* 43 */     if ((petList != null) && (petList.size() > 0)) {
/* 44 */       long petid = ((Long)petList.get(0)).longValue();
/* 45 */       Pet pet = mzm.gsp.pet.main.PetInterface.getPetById(((RoleEscapeArg)this.arg).roleid, petid);
/* 46 */       if (pet != null) {
/* 47 */         petLevel = pet.getLevel();
/* 48 */         petBattlePoint = pet.getPetYaoli();
/*    */       }
/*    */     }
/*    */     
/* 52 */     int fightEndReason = 2;
/* 53 */     FightStorage xFightStorage = Role2fightstorage.get(Long.valueOf(((RoleEscapeArg)this.arg).roleid));
/* 54 */     if (xFightStorage == null) {
/* 55 */       xFightStorage = xbean.Pod.newFightStorage();
/* 56 */       Role2fightstorage.insert(Long.valueOf(((RoleEscapeArg)this.arg).roleid), xFightStorage);
/*    */     }
/* 58 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 59 */     long befroeBattleMills = xFightStorage.getLastestendtime();
/* 60 */     xFightStorage.setLastestendtime(curTime);
/* 61 */     int battleCDMil = Integer.MAX_VALUE;
/* 62 */     if (befroeBattleMills > 0L) {
/* 63 */       battleCDMil = (int)(((RoleEscapeArg)this.arg).startTime - befroeBattleMills);
/*    */     }
/* 65 */     FightManager.tlogFightSecurity(userid, ((RoleEscapeArg)this.arg).roleid, partnerCount, partnerBattlePoint, petLevel, petBattlePoint, ((RoleEscapeArg)this.arg).fightType, fightEndReason, ((RoleEscapeArg)this.arg).fightCfgId, (int)(curTime - ((RoleEscapeArg)this.arg).startTime), battleCDMil, ((RoleEscapeArg)this.arg).round, ((RoleEscapeArg)this.arg).actionMaxCountRound, ((RoleEscapeArg)this.arg).actionTotalCount, ((RoleEscapeArg)this.arg).startTime);
/*    */     
/*    */ 
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */