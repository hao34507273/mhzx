/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.event.AllRoamedRoleReadyArg;
/*    */ import mzm.gsp.crossserver.main.RoamedRoleMatchMarkingInfo;
/*    */ 
/*    */ public class POnAllRoamedRoleReady extends mzm.gsp.crossserver.event.AllRoamedRoleReadyProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     LadderFightContext ladderFightContext = new LadderFightContext(((AllRoamedRoleReadyArg)this.arg).context);
/* 14 */     List<Long> activeRoles = new ArrayList();
/* 15 */     List<Long> passiveRoles = new ArrayList();
/* 16 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : ((AllRoamedRoleReadyArg)this.arg).context.roleMatchMarkingInfos) {
/* 17 */       activeRoles.add(Long.valueOf(roamedRoleMatchMarkingInfo.getRoleid()));
/* 18 */       ladderFightContext.role2DisPlayRankMap.put(Long.valueOf(roamedRoleMatchMarkingInfo.getRoleid()), Integer.valueOf(roamedRoleMatchMarkingInfo.getDisplayRank()));
/*    */     }
/*    */     
/* 21 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : ((AllRoamedRoleReadyArg)this.arg).context.opponentRoleMatchMarkingInfos) {
/* 22 */       passiveRoles.add(Long.valueOf(roamedRoleMatchMarkingInfo.getRoleid()));
/* 23 */       ladderFightContext.role2DisPlayRankMap.put(Long.valueOf(roamedRoleMatchMarkingInfo.getRoleid()), Integer.valueOf(roamedRoleMatchMarkingInfo.getDisplayRank()));
/*    */     }
/*    */     
/* 26 */     mzm.gsp.GameServer.logger().info(String.format("[Ladder]POnAllRoamedRoleReady.processImp@all roles|activeRoleids=%s|passiveRoleids=%s", new Object[] { activeRoles, passiveRoles }));
/*    */     
/*    */ 
/* 29 */     LadderInterface.startLadderFight(activeRoles, passiveRoles, ladderFightContext);
/* 30 */     List<Long> allRoleList = new ArrayList();
/* 31 */     allRoleList.addAll(activeRoles);
/* 32 */     allRoleList.addAll(passiveRoles);
/* 33 */     LadderMatchRomaContextManager.getInstance().putKeys(allRoleList, ((AllRoamedRoleReadyArg)this.arg).context);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnAllRoamedRoleReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */