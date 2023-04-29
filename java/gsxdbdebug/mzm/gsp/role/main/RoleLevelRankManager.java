/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*    */ import xbean.RoleLevelBean;
/*    */ import xbean.RoleLevelRank;
/*    */ import xtable.Rolelevelrank;
/*    */ 
/*    */ class RoleLevelRankManager extends RoleKeyRankManagerNew<RoleLevelChart>
/*    */ {
/*    */   private static RoleLevelRankManager instance;
/*    */   
/*    */   private RoleLevelRankManager(int chartType)
/*    */   {
/* 17 */     super(chartType);
/*    */   }
/*    */   
/*    */   static RoleLevelRankManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   static void init()
/*    */   {
/* 27 */     if (instance != null)
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     instance = new RoleLevelRankManager(2);
/*    */   }
/*    */   
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 37 */     List<RoleLevelChart> roleLevelCharts = getAllChartObjs();
/* 38 */     RoleLevelRank roleLevelRank = Rolelevelrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 39 */     if (roleLevelRank == null)
/*    */     {
/* 41 */       roleLevelRank = xbean.Pod.newRoleLevelRank();
/* 42 */       Rolelevelrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), roleLevelRank);
/*    */     }
/* 44 */     roleLevelRank.getRankdatas().clear();
/* 45 */     for (RoleLevelChart roleLevelChart : roleLevelCharts)
/*    */     {
/* 47 */       RoleLevelBean roleLevelBean = xbean.Pod.newRoleLevelBean();
/* 48 */       roleLevelBean.setRoleid(roleLevelChart.getKey().longValue());
/* 49 */       roleLevelRank.getRankdatas().add(roleLevelBean);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 56 */     RoleLevelRank roleLevelRank = Rolelevelrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 57 */     if (roleLevelRank != null)
/*    */     {
/* 59 */       for (RoleLevelBean roleLevelBean : roleLevelRank.getRankdatas())
/*    */       {
/* 61 */         long roleId = roleLevelBean.getRoleid();
/*    */         
/* 63 */         if (RoleInterface.isRoleRealDel(roleId))
/*    */         {
/* 65 */           GameServer.logger().info(String.format("[mfv]RoleLevelRankManager.rankDataFromDB@ role is deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */         }
/*    */         else
/*    */         {
/* 69 */           RoleLevelChart roleLevelChart = new RoleLevelChart(roleId, RoleInterface.getLevel(roleLevelBean.getRoleid()), RoleInterface.getLevelUpCurTime(roleLevelBean.getRoleid()));
/*    */           
/* 71 */           rank(roleLevelChart);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 80 */     int level = RoleInterface.getLevel(roleid);
/* 81 */     long lvupTime = RoleInterface.getLevelUpCurTime(roleid);
/* 82 */     if (lvupTime <= 0L)
/*    */     {
/* 84 */       GameServer.logger().error(String.format("[Role]RoleLevelRankManager.addRankRoleForIDIP@role not exist|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */     }
/*    */     
/* 87 */     rank(new RoleLevelChart(roleid, level, lvupTime));
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleLevelRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */