/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.DateObserver;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.PopularityRankData;
/*     */ import xbean.RolePopularityRankData;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Friends_circle_popularity_rank;
/*     */ import xtable.Friends_circle_popularity_rank_backup;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FriendsCircleChartObserver extends DateObserver
/*     */ {
/*     */   public FriendsCircleChartObserver(int timeCommonCfgId)
/*     */   {
/*  27 */     super(timeCommonCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean onTimeOut()
/*     */   {
/*  33 */     new PFriendsCrrcleChartObserver(null).execute();
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   private static class PFriendsCrrcleChartObserver
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  43 */       if (!OpenInterface.getOpenStatus(469))
/*     */       {
/*  45 */         StringBuilder sBuilder = new StringBuilder();
/*  46 */         sBuilder.append("[friendscircle]PFriendsCrrcleChartObserver.processImp@friends circle chart not open");
/*     */         
/*  48 */         GameServer.logger().info(sBuilder.toString());
/*     */         
/*  50 */         return false;
/*     */       }
/*     */       
/*  53 */       long localId = GameServerInfoManager.getLocalId();
/*  54 */       Lockeys.lock(Lockeys.get(Friends_circle_popularity_rank.getTable(), Long.valueOf(localId)));
/*     */       
/*  56 */       PopularityRankData xPopularityRankData_backup = Friends_circle_popularity_rank_backup.get(Long.valueOf(localId));
/*  57 */       if (xPopularityRankData_backup == null)
/*     */       {
/*  59 */         xPopularityRankData_backup = Pod.newPopularityRankData();
/*  60 */         Friends_circle_popularity_rank_backup.insert(Long.valueOf(localId), xPopularityRankData_backup);
/*     */       }
/*  62 */       xPopularityRankData_backup.getRank_data_list().clear();
/*     */       
/*  64 */       PopularityRankData xPopularityRankData = Friends_circle_popularity_rank.get(Long.valueOf(localId));
/*  65 */       if (xPopularityRankData == null)
/*     */       {
/*  67 */         xPopularityRankData = Pod.newPopularityRankData();
/*  68 */         Friends_circle_popularity_rank.insert(Long.valueOf(localId), xPopularityRankData);
/*     */       }
/*     */       
/*     */ 
/*  72 */       List<FriendsCicrlePopularityChart> popularityChartList = FriendsCicrlePopularityRankManager.getInstance().getAllChartObjs();
/*  73 */       for (int rank = 0; rank < popularityChartList.size(); rank++)
/*     */       {
/*  75 */         long roleId = ((FriendsCicrlePopularityChart)popularityChartList.get(rank)).getRoleid();
/*  76 */         int popularityValue = ((FriendsCicrlePopularityChart)popularityChartList.get(rank)).getPopularityValue();
/*     */         
/*  78 */         RolePopularityRankData xRolePopularityRankData = Pod.newRolePopularityRankData();
/*  79 */         xRolePopularityRankData.setRole_id(roleId);
/*  80 */         xPopularityRankData_backup.getRank_data_list().add(xRolePopularityRankData);
/*     */         
/*     */ 
/*  83 */         NoneRealTimeTaskManager.getInstance().addTask(new FriendsCircleChartObserver.PAwardPopularityRank(roleId, rank, popularityValue));
/*     */       }
/*     */       
/*  86 */       FriendsCicrlePopularityRankManager.getInstance().clear();
/*     */       
/*  88 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PAwardPopularityRank extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int rank;
/*     */     private final int popularityValue;
/*     */     
/*     */     public PAwardPopularityRank(long roleid, int rank, int popularityValue)
/*     */     {
/* 100 */       this.roleId = roleid;
/* 101 */       this.rank = rank;
/* 102 */       this.popularityValue = popularityValue;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 108 */       String userId = RoleInterface.getUserId(this.roleId);
/* 109 */       lock(Lockeys.get(User.getTable(), userId));
/* 110 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */       
/* 112 */       tlogWeekPopularityRank(userId, this.roleId, this.rank, this.popularityValue);
/*     */       
/* 114 */       RankInterface.sendChartAward(userId, this.roleId, 45, this.rank);
/*     */       
/* 116 */       StringBuilder sBuilder = new StringBuilder();
/* 117 */       sBuilder.append("[friendscircle]PAwardPopularityRank.processImp@award popularity rank award");
/* 118 */       sBuilder.append("|role_id=").append(this.roleId);
/* 119 */       sBuilder.append("|rank=").append(this.rank);
/* 120 */       sBuilder.append("|popularity_value=").append(this.popularityValue);
/*     */       
/* 122 */       GameServer.logger().info(sBuilder.toString());
/* 123 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     static void tlogWeekPopularityRank(String userId, long roleId, long rank, int popularity)
/*     */     {
/* 131 */       int roleLevel = RoleInterface.getLevel(roleId);
/*     */       
/* 133 */       StringBuilder sbLog = new StringBuilder();
/* 134 */       sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 135 */       sbLog.append(userId).append('|');
/* 136 */       sbLog.append(roleId).append('|');
/* 137 */       sbLog.append(roleLevel).append('|');
/*     */       
/* 139 */       sbLog.append(rank).append('|');
/* 140 */       sbLog.append(popularity);
/*     */       
/* 142 */       TLogManager.getInstance().addLog(roleId, "WeekPopularityRank", sbLog.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCircleChartObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */