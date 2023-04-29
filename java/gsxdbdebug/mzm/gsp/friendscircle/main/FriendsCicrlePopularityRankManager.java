/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import xbean.Pod;
/*     */ import xbean.PopularityRankData;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xbean.RolePopularityRankData;
/*     */ import xtable.Friends_circle_popularity_rank;
/*     */ 
/*     */ public class FriendsCicrlePopularityRankManager extends RoleKeyRankManagerNew<FriendsCicrlePopularityChart>
/*     */ {
/*     */   private static FriendsCicrlePopularityRankManager instance;
/*     */   
/*     */   private FriendsCicrlePopularityRankManager(int charttype)
/*     */   {
/*  18 */     super(charttype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  25 */     if (instance != null)
/*     */     {
/*  27 */       return;
/*     */     }
/*     */     
/*     */ 
/*  31 */     instance = new FriendsCicrlePopularityRankManager(45);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static FriendsCicrlePopularityRankManager getInstance()
/*     */   {
/*  38 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  45 */     List<FriendsCicrlePopularityChart> allPopularityCharts = getAllChartObjs();
/*     */     
/*     */ 
/*  48 */     PopularityRankData xPopularityRankData = Friends_circle_popularity_rank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  49 */     if (xPopularityRankData == null)
/*     */     {
/*  51 */       xPopularityRankData = Pod.newPopularityRankData();
/*  52 */       Friends_circle_popularity_rank.add(Long.valueOf(GameServerInfoManager.getLocalId()), xPopularityRankData);
/*     */     }
/*  54 */     List<RolePopularityRankData> xRolePopularityRankList = xPopularityRankData.getRank_data_list();
/*  55 */     xRolePopularityRankList.clear();
/*     */     
/*  57 */     for (FriendsCicrlePopularityChart popularityChart : allPopularityCharts)
/*     */     {
/*  59 */       RolePopularityRankData xRolePopularityRankData = Pod.newRolePopularityRankData();
/*  60 */       xRolePopularityRankData.setRole_id(popularityChart.getRoleid());
/*     */       
/*  62 */       xRolePopularityRankList.add(xRolePopularityRankData);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  69 */     PopularityRankData xPopularityRankData = Friends_circle_popularity_rank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  70 */     if (xPopularityRankData != null)
/*     */     {
/*  72 */       for (RolePopularityRankData xRolePopularityRankData : xPopularityRankData.getRank_data_list())
/*     */       {
/*  74 */         long roleId = xRolePopularityRankData.getRole_id();
/*     */         
/*  76 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleId))
/*     */         {
/*  78 */           mzm.gsp.GameServer.logger().info(String.format("[friends_circle]FriendsCicrlePopularityRankManager.rankDataFromDB@role is deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*  86 */           int weekPopularityValue = FriendsCircleManager.getWeekPopularityValue(roleId, false);
/*     */           
/*  88 */           FriendsCicrlePopularityChart friendsCicrlePopularityChart = new FriendsCicrlePopularityChart(roleId, weekPopularityValue);
/*     */           
/*     */ 
/*  91 */           rank(friendsCicrlePopularityChart);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/*  99 */     PopularityRankData xPopularityRankData = Friends_circle_popularity_rank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 100 */     if (xPopularityRankData != null)
/*     */     {
/* 102 */       xPopularityRankData.getRank_data_list().clear();
/*     */     }
/* 104 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void rank(long roleId, int friendsCirclePopularityValue)
/*     */   {
/* 115 */     if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(469))
/*     */     {
/* 117 */       return;
/*     */     }
/* 119 */     FriendsCicrlePopularityChart rolePopularityChart = new FriendsCicrlePopularityChart(roleId, friendsCirclePopularityValue);
/*     */     
/* 121 */     rank(rolePopularityChart);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleId)
/*     */   {
/* 127 */     getInstance().rank(new FriendsCicrlePopularityChart(roleId, FriendsCircleManager.getWeekPopularityValue(roleId, false)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleId)
/*     */   {
/* 137 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = xtable.Role2friendscircle.get(Long.valueOf(roleId));
/* 138 */     if (xRole2FriendsCircleInfo == null)
/*     */     {
/* 140 */       return;
/*     */     }
/* 142 */     xRole2FriendsCircleInfo.setCurrent_week_popularity_value(0);
/* 143 */     delete(Long.valueOf(roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCicrlePopularityRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */