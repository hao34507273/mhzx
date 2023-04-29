/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCMassWeddingSignUpInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCMassWeddingSignUpInfo(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(SMassWeddingConsts.getInstance().waiterNpc, SMassWeddingConsts.getInstance().signUpServiceid, this.roleid))
/*    */     {
/* 26 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingSignUpInfo.processImp@npc service is not useable|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/* 30 */       return false;
/*    */     }
/* 32 */     List<Long> teamRoleids = TeamInterface.getNormalRoleList(this.roleid);
/* 33 */     if (!teamRoleids.contains(Long.valueOf(this.roleid))) {
/* 34 */       teamRoleids.clear();
/* 35 */       teamRoleids.add(Long.valueOf(this.roleid));
/*    */     }
/* 37 */     for (Iterator i$ = teamRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 38 */       if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(roleid, 164)))
/*    */       {
/* 40 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 164);
/*    */         
/* 42 */         return false;
/*    */       }
/*    */     }
/* 45 */     long marryRoleid = MarriageInterface.getMarriedRoleid(this.roleid);
/* 46 */     MassWeddingSignUpChart massWeddingSignUpChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getObjByKey(Long.valueOf(this.roleid));
/* 47 */     if (massWeddingSignUpChart == null) {
/* 48 */       massWeddingSignUpChart = (MassWeddingSignUpChart)MassWeddingSignUpChartManager.getInstance().getObjByKey(Long.valueOf(marryRoleid));
/*    */     }
/* 50 */     int myPrice = 0;
/* 51 */     int rank = 0;
/* 52 */     if (massWeddingSignUpChart != null) {
/* 53 */       myPrice = massWeddingSignUpChart.roleAPrice + massWeddingSignUpChart.roleBPrice;
/* 54 */       rank = MassWeddingSignUpChartManager.getInstance().getRank(Long.valueOf(massWeddingSignUpChart.roleidA)) + 1;
/*    */     }
/*    */     
/* 57 */     MassWeddingManager.asynSendMassWeddingSignUpInfo(teamRoleids, myPrice, rank);
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCMassWeddingSignUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */