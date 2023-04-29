/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.marriage.confbean.SMarriageParadeRobConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleLessCold1;
/*    */ import xtable.Role2lesscold1;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MarriageParadeFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 24 */     int monstercfgid = FightInterface.getFightFirstMonsterid(fightId);
/* 25 */     if (!MarriageManager.isParadeRobMonsterCfgid(monstercfgid)) {
/* 26 */       return 0;
/*    */     }
/* 28 */     List<Long> memberList = TeamInterface.getNormalRoleList(roleId);
/* 29 */     if (!memberList.contains(Long.valueOf(roleId))) {
/* 30 */       memberList.clear();
/* 31 */       memberList.add(Long.valueOf(roleId));
/*    */     }
/* 33 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 34 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long mmId = ((Long)i$.next()).longValue();
/* 35 */       if ((!OpenInterface.getOpenStatus(129)) || (OpenInterface.isBanPlay(mmId, 129)))
/*    */       {
/* 37 */         OpenInterface.sendBanPlayMsg(roleId, mmId, RoleInterface.getName(mmId), 129);
/*    */         
/* 39 */         return 5;
/*    */       }
/* 41 */       RoleLessCold1 xRoleLessCold1 = Role2lesscold1.select(Long.valueOf(mmId));
/* 42 */       if ((xRoleLessCold1 != null) && 
/*    */       
/*    */ 
/* 45 */         (DateTimeUtils.isInSameDay(curTime, xRoleLessCold1.getRobprotecttime())))
/*    */       {
/*    */ 
/* 48 */         if (xRoleLessCold1.getRobprotectcount() >= SMarriageParadeRobConsts.getInstance().attackProtectMaxPerDay) {
/* 49 */           for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long tempRoleid = ((Long)i$.next()).longValue();
/* 50 */             String name = RoleInterface.getName(mmId);
/* 51 */             if (tempRoleid == mmId) {
/* 52 */               MarriageManager.sendAttackParadeError(tempRoleid, 104, new String[0]);
/*    */             }
/*    */             else {
/* 55 */               MarriageManager.sendAttackParadeError(tempRoleid, 101, new String[] { name });
/*    */             }
/*    */           }
/*    */           
/* 59 */           return 5;
/*    */         }
/*    */       }
/*    */     }
/* 63 */     FightInterface.startPVEFight(roleId, fightId, context, FightReason.ROB_MARRIAGE);
/* 64 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageParadeFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */