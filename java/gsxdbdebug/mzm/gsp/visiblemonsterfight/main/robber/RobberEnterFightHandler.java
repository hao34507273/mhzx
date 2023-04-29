/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RobberEnterFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(59)) {
/* 26 */       return 5;
/*    */     }
/* 28 */     long gangId = GangInterface.getGangId(roleId);
/* 29 */     if (gangId == 0L) {
/* 30 */       return 3;
/*    */     }
/* 32 */     if (GangInterface.getGangWorldId(gangId) != context.worldId) {
/* 33 */       return 3;
/*    */     }
/* 35 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 36 */     if (teamId == null) {
/* 37 */       return 4;
/*    */     }
/* 39 */     List<Long> memberList = TeamInterface.getNormalRoleList(roleId);
/* 40 */     if (!memberList.contains(Long.valueOf(roleId))) {
/* 41 */       return 4;
/*    */     }
/* 43 */     Procedure.execute(new GangRobberInitProcedure(memberList));
/* 44 */     int counter = 0;
/* 45 */     if (!RoleStatusInterface.checkCansetStatus(memberList, 91, true, memberList)) {
/* 46 */       return 5;
/*    */     }
/* 48 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long mmId = ((Long)i$.next()).longValue();
/* 49 */       if (OpenInterface.isBanPlay(mmId, 59)) {
/* 50 */         OpenInterface.sendBanPlayMsg(roleId, mmId, RoleInterface.getName(mmId), 59);
/*    */         
/* 52 */         return 5;
/*    */       }
/* 54 */       if (GangInterface.isGangMember(mmId, gangId)) {
/* 55 */         counter++;
/* 56 */         if (counter >= SGangRobberConst.getInstance().TEAM_GANG_MEMBER_NUM) {
/* 57 */           FightInterface.startPVEFight(roleId, fightId, context, FightReason.GANG_ROBBER_FIGHT);
/* 58 */           return 1;
/*    */         }
/*    */       }
/*    */     }
/* 62 */     return 4;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\RobberEnterFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */