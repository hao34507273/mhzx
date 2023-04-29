/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*    */ import xbean.FightValueRank;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleFightValueBean;
/*    */ import xtable.Fightvaluerank;
/*    */ 
/*    */ public class FightValueRankManager extends RoleKeyRankManagerNew<RoleFightValueChart>
/*    */ {
/*    */   private static FightValueRankManager instance;
/*    */   
/*    */   static FightValueRankManager getInstance()
/*    */   {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */   private FightValueRankManager(int rankType)
/*    */   {
/* 22 */     super(rankType);
/*    */   }
/*    */   
/*    */   static void init()
/*    */   {
/* 27 */     if (instance != null)
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     instance = new FightValueRankManager(0);
/*    */   }
/*    */   
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 37 */     List<RoleFightValueChart> allObjs = getAllChartObjs();
/* 38 */     FightValueRank fightValueRank = Fightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 39 */     if (fightValueRank == null)
/*    */     {
/* 41 */       fightValueRank = Pod.newFightValueRank();
/* 42 */       Fightvaluerank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), fightValueRank);
/*    */     }
/* 44 */     fightValueRank.getRolerankdatas().clear();
/* 45 */     for (RoleFightValueChart roleFightValueChart : allObjs)
/*    */     {
/*    */ 
/* 48 */       RoleFightValueBean roleFightValueBean = Pod.newRoleFightValueBean();
/* 49 */       roleFightValueBean.setRoleid(roleFightValueChart.getKey().longValue());
/* 50 */       fightValueRank.getRolerankdatas().add(roleFightValueBean);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 58 */     FightValueRank fightValueRank = Fightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 59 */     if (fightValueRank != null)
/*    */     {
/* 61 */       for (RoleFightValueBean roleFightValueBean : fightValueRank.getRolerankdatas())
/*    */       {
/* 63 */         long roleId = roleFightValueBean.getRoleid();
/*    */         
/* 65 */         if (RoleInterface.isRoleRealDel(roleId))
/*    */         {
/* 67 */           mzm.gsp.GameServer.logger().info(String.format("[mfv]FightValueRankManager.rankDataFromDB@ role is deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */         }
/*    */         else
/*    */         {
/* 71 */           RoleFightValueChart roleFightValueChart = new RoleFightValueChart(roleId, RoleInterface.getFightValue(roleFightValueBean.getRoleid()));
/*    */           
/*    */ 
/* 74 */           rank(roleFightValueChart);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 82 */     int fightValue = RoleInterface.getFightValue(roleid);
/* 83 */     rank(new RoleFightValueChart(roleid, fightValue));
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\FightValueRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */