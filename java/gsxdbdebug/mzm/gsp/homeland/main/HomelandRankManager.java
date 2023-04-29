/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomelandRankList;
/*     */ import xtable.Homelandrank;
/*     */ import xtable.Role2homeinfo;
/*     */ 
/*     */ public class HomelandRankManager extends RoleKeyRankManagerNew<RoleHomelandChart> implements mzm.gsp.chart.main.RankAwardHandler
/*     */ {
/*     */   private static HomelandRankManager instance;
/*     */   
/*     */   private HomelandRankManager(int charttype)
/*     */   {
/*  24 */     super(charttype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  31 */     if (instance != null)
/*     */     {
/*  33 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  38 */     instance = new HomelandRankManager(22);
/*  39 */     RankInterface.registerRankAwardHandle(22, getInstance());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static HomelandRankManager getInstance()
/*     */   {
/*  46 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  53 */     List<RoleHomelandChart> homelandCharts = getAllChartObjs();
/*  54 */     HomelandRankList roleHomelandRankList = Homelandrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  55 */     if (roleHomelandRankList == null)
/*     */     {
/*  57 */       roleHomelandRankList = xbean.Pod.newHomelandRankList();
/*  58 */       Homelandrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), roleHomelandRankList);
/*     */     }
/*  60 */     roleHomelandRankList.getRanklist().clear();
/*  61 */     for (RoleHomelandChart roleHomelandChart : homelandCharts)
/*     */     {
/*  63 */       roleHomelandRankList.getRanklist().add(roleHomelandChart.getKey());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  70 */     HomelandRankList roleHomelandRankList = Homelandrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  71 */     Iterator i$; if (roleHomelandRankList != null)
/*     */     {
/*  73 */       for (i$ = roleHomelandRankList.getRanklist().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*     */ 
/*  76 */         if (RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  78 */           HomelandManager.logger.info(String.format("[homeland]HomelandRankManager.rankDataFromDB@ role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */         }
/*     */         else
/*     */         {
/*  82 */           HomeInfo xHomeInfo = Role2homeinfo.select(Long.valueOf(roleid));
/*     */           
/*  84 */           RoleHomelandChart roleHomelandChart = new RoleHomelandChart(roleid, HomelandManager.getHomelandPoint(xHomeInfo));
/*  85 */           rank(roleHomelandChart);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/*  96 */     HomelandRankList roleHomelandRankList = Homelandrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  97 */     if (roleHomelandRankList != null)
/*     */     {
/*  99 */       roleHomelandRankList.getRanklist().clear();
/*     */     }
/* 101 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 107 */     HomeInfo xHomeInfo = Role2homeinfo.select(Long.valueOf(roleid));
/* 108 */     getInstance().rank(new RoleHomelandChart(roleid, HomelandManager.getHomelandPoint(xHomeInfo)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 115 */     getInstance().delete(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */   public void doAward()
/*     */   {
/* 121 */     HomelandRankList roleHomelandRankList = Homelandrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 122 */     if (roleHomelandRankList == null)
/*     */     {
/* 124 */       return;
/*     */     }
/* 126 */     checkAndAwarad(roleHomelandRankList);
/*     */   }
/*     */   
/*     */ 
/*     */   private void checkAndAwarad(HomelandRankList roleHomelandRankList)
/*     */   {
/* 132 */     long awardTime = roleHomelandRankList.getAwardtime();
/* 133 */     boolean sameTime = RankInterface.isInSameAwardTime(awardTime, 22);
/* 134 */     if (!sameTime)
/*     */     {
/*     */ 
/* 137 */       if (mzm.gsp.open.main.OpenInterface.getOpenStatus(175))
/*     */       {
/* 139 */         int rank = RankInterface.getAwardRank(22);
/* 140 */         GameServer.logger().info(String.format("[homeland]HomelandRankManager.checkAndAwarad@do award top rank|rank=%d", new Object[] { Integer.valueOf(rank) }));
/*     */         
/* 142 */         for (int i = 0; i <= rank; i++)
/*     */         {
/* 144 */           if (roleHomelandRankList.getRanklist().size() <= i)
/*     */             break;
/* 146 */           long roleid = ((Long)roleHomelandRankList.getRanklist().get(i)).longValue();
/* 147 */           NoneRealTimeTaskManager.getInstance().addTask(new AwardProcedure(roleid, i));
/*     */           
/* 149 */           GameServer.logger().info(String.format("[homeland]HomelandRankManager.checkAndAwarad@do award rank|rank=%d|roleid=%d", new Object[] { Integer.valueOf(rank), Long.valueOf(roleid) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */       roleHomelandRankList.setAwardtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     else
/*     */     {
/* 164 */       GameServer.logger().info(String.format("[homeland]HomelandRankManager.checkAndAwarad@do not needAward|awardTime=%d", new Object[] { Long.valueOf(awardTime) }));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class AwardProcedure
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     
/*     */     public AwardProcedure(long roleid, int rank)
/*     */     {
/* 176 */       this.roleid = roleid;
/* 177 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 183 */       String userid = RoleInterface.getUserId(this.roleid);
/* 184 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/* 185 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 186 */       RankInterface.sendChartAward(userid, this.roleid, 22, this.rank);
/*     */       
/* 188 */       addTLog(this.roleid, "HomelandRankAward", new Object[] { Integer.valueOf(this.rank) });
/* 189 */       return true;
/*     */     }
/*     */     
/*     */     void addTLog(long roleid, String logName, Object... logColumns)
/*     */     {
/* 194 */       String vGameIp = GameServerInfoManager.getHostIP();
/* 195 */       int roleLevel = RoleInterface.getLevel(roleid);
/* 196 */       String userid = RoleInterface.getUserId(roleid);
/*     */       
/* 198 */       StringBuilder logStr = new StringBuilder();
/* 199 */       logStr.append(vGameIp);
/* 200 */       logStr.append("|").append(userid);
/* 201 */       logStr.append("|").append(roleid);
/* 202 */       logStr.append("|").append(roleLevel);
/*     */       
/* 204 */       for (Object colum : logColumns)
/*     */       {
/* 206 */         logStr.append("|").append(colum);
/*     */       }
/*     */       
/* 209 */       mzm.gsp.tlog.TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomelandRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */