/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.pet.main.PetYaoLiChart;
/*    */ import mzm.gsp.pet.main.PetYaoLiChartRankManager;
/*    */ import mzm.gsp.role.multirank.AbsOMFVRankManager;
/*    */ import mzm.gsp.role.multirank.MultiFightValueRankManager;
/*    */ import mzm.gsp.role.multirank.RoleMultiFightValueChart;
/*    */ import xbean.HeartBeatBean;
/*    */ import xtable.Role2heartbeat;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     RoleFightValueChart roleFightValueChart = new RoleFightValueChart(((Long)this.arg).longValue(), RoleInterface.getFightValue(((Long)this.arg).longValue()));
/* 20 */     FightValueRankManager.getInstance().rank(roleFightValueChart);
/*    */     
/* 22 */     RoleLevelChart roleLevelChart = new RoleLevelChart(((Long)this.arg).longValue(), RoleInterface.getLevel(((Long)this.arg).longValue()), RoleInterface.getLevelUpCurTime(((Long)this.arg).longValue()));
/*    */     
/* 24 */     RoleLevelRankManager.getInstance().rank(roleLevelChart);
/*    */     
/* 26 */     reRankRoleMFV(((Long)this.arg).longValue());
/*    */     
/*    */ 
/* 29 */     for (Iterator i$ = PetInterface.getPetList(((Long)this.arg).longValue(), true).iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/*    */       
/* 31 */       int petYaoli = PetInterface.getPetYaoli(((Long)this.arg).longValue(), petid);
/* 32 */       long petYaoliChangeTime = PetInterface.getPetYaoliChangeTime(((Long)this.arg).longValue(), petid);
/* 33 */       if (petYaoli > 0)
/*    */       {
/* 35 */         PetYaoLiChart petYaoLiChart = new PetYaoLiChart(petid, ((Long)this.arg).longValue(), petYaoli, petYaoliChangeTime);
/* 36 */         PetYaoLiChartRankManager.getInstance().rank(petYaoLiChart);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 42 */     xtable.Role2outfightbean.remove((Long)this.arg);
/* 43 */     xtable.Role2tempskill.remove((Long)this.arg);
/*    */     
/* 45 */     HeartBeatBean heartBeatBean = Role2heartbeat.get((Long)this.arg);
/* 46 */     if (heartBeatBean != null)
/*    */     {
/* 48 */       heartBeatBean.getHeartbeatobserver().stopTimer();
/* 49 */       Role2heartbeat.remove((Long)this.arg);
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void reRankRoleMFV(long roleId)
/*    */   {
/* 61 */     int mfv = mzm.gsp.role.multirank.MultiRankManager.getRoleMFValue(roleId);
/* 62 */     int occId = RoleInterface.getOccupationId(roleId);
/*    */     
/*    */ 
/* 65 */     RoleMultiFightValueChart roleMFVChart = new RoleMultiFightValueChart(((Long)this.arg).longValue(), mfv);
/* 66 */     MultiFightValueRankManager.getInstance().rank(roleMFVChart);
/*    */     
/*    */ 
/* 69 */     RoleMultiFightValueChart roleOMFVChart = new RoleMultiFightValueChart(((Long)this.arg).longValue(), mfv, occId);
/* 70 */     AbsOMFVRankManager rankManager = AbsOMFVRankManager.getAbsOMFVRankManagerByOccId(occId);
/* 71 */     if (rankManager == null)
/*    */     {
/* 73 */       GameServer.logger().error(String.format("[MFV]POnRoleLogoff.reRankRoleMFV@ no rankManager!|roleId=%d|MFV=%d|occupationId=%d", new Object[] { this.arg, Integer.valueOf(mfv), Integer.valueOf(occId) }));
/*    */       
/*    */ 
/* 76 */       return;
/*    */     }
/* 78 */     rankManager.rank(roleOMFVChart);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */