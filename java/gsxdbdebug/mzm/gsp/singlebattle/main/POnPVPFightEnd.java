/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*    */ import mzm.gsp.singlebattle.SRoleDieBro;
/*    */ import mzm.gsp.singlebattle.event.EventArg_KillOther;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSessions;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnPVPFightEnd extends PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if (!(((PVPFightEndArg)this.arg).context instanceof SingleBattleFightContext))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     SingleBattleFightContext fightContext = (SingleBattleFightContext)((PVPFightEndArg)this.arg).context;
/* 28 */     long battleId = fightContext.getBattleId();
/*    */     long loser;
/*    */     long winner;
/*    */     long loser;
/* 32 */     if (((PVPFightEndArg)this.arg).isActiveWin)
/*    */     {
/* 34 */       long winner = ((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/* 35 */       loser = ((Long)((PVPFightEndArg)this.arg).passiveRoleList.get(0)).longValue();
/*    */     }
/*    */     else
/*    */     {
/* 39 */       winner = ((Long)((PVPFightEndArg)this.arg).passiveRoleList.get(0)).longValue();
/* 40 */       loser = ((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/*    */     }
/*    */     
/*    */ 
/* 44 */     SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(battleId, true);
/* 45 */     if (globalInfo == null)
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[singlebattle]POnPVPFightEnd.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*    */       
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     if (globalInfo.getStage() == 4)
/*    */     {
/* 54 */       GameServer.logger().error(String.format("[singlebattle]POnPVPFightEnd.processImp@ already in clean stage! |battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*    */       
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     globalInfo.removeFightId(((PVPFightEndArg)this.arg).fightid);
/*    */     
/*    */ 
/* 63 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(winner), Long.valueOf(loser) }));
/*    */     
/* 65 */     RoleSingleBattle xRoleBattle_loser = xtable.Role2singlebattle.select(Long.valueOf(loser));
/* 66 */     if (xRoleBattle_loser == null)
/*    */     {
/* 68 */       GameServer.logger().error(String.format("[singlebattle]POnPVPFightEnd.processImp@ no loser data! |roleId=%d", new Object[] { Long.valueOf(loser) }));
/*    */       
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     mzm.gsp.status.main.RoleStatusInterface.setStatus(loser, 1512, true);
/*    */     
/* 75 */     int reviveInterval = globalInfo.getReviveInterval(loser, xRoleBattle_loser.getCampid());
/*    */     
/* 77 */     long reviveTime = DateTimeUtils.getCurrTimeInMillis() + reviveInterval * 1000;
/*    */     
/* 79 */     globalInfo.recordFight(winner, loser, reviveTime);
/*    */     
/* 81 */     long deathSessionId = new SessionDeath(reviveInterval, loser, battleId).getSessionId();
/* 82 */     xRoleBattle_loser.getRolesessions().setDiesessionid(deathSessionId);
/*    */     
/* 84 */     globalInfo.battleBro(new SRoleDieBro(loser, winner, (int)(reviveTime / 1000L)), false);
/*    */     
/* 86 */     Set<Long> dieGuys = new HashSet();
/* 87 */     dieGuys.add(Long.valueOf(loser));
/* 88 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.singlebattle.event.KillOtherInBattle(), new EventArg_KillOther(winner, dieGuys));
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */