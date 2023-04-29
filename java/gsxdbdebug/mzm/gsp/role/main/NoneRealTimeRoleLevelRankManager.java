/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import mzm.gsp.chart.main.NoneRealTimeRoleKeyRankManagerNew;
/*     */ import mzm.gsp.chart.main.RankInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleLevelBean;
/*     */ import xbean.NoneRealTimeRoleLevelRank;
/*     */ import xbean.NoneRealTimeRoleLevelRankBackUp;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimerolelevelrank;
/*     */ import xtable.Nonerealtimerolelevelrankbackup;
/*     */ 
/*     */ public class NoneRealTimeRoleLevelRankManager extends NoneRealTimeRoleKeyRankManagerNew<RoleLevelChart> implements mzm.gsp.chart.main.RankAwardHandler
/*     */ {
/*     */   private static NoneRealTimeRoleLevelRankManager instance;
/*     */   
/*     */   static NoneRealTimeRoleLevelRankManager getInstance()
/*     */   {
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  38 */     if (instance != null)
/*     */     {
/*  40 */       return;
/*     */     }
/*  42 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(2);
/*  43 */     instance = new NoneRealTimeRoleLevelRankManager(chartSubTypeCfg.chartType, RoleLevelRankManager.getInstance());
/*  44 */     RankInterface.registerRankAwardHandle(2, getInstance());
/*     */   }
/*     */   
/*     */   private NoneRealTimeRoleLevelRankManager(int chartType, RoleLevelRankManager roleLevelRankManager)
/*     */   {
/*  49 */     super(chartType, roleLevelRankManager);
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  55 */     NoneRealTimeRoleLevelRank noneRealTimeRoleLevelRank = Nonerealtimerolelevelrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  56 */     if (noneRealTimeRoleLevelRank == null)
/*     */     {
/*  58 */       noneRealTimeRoleLevelRank = Pod.newNoneRealTimeRoleLevelRank();
/*  59 */       noneRealTimeRoleLevelRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*  60 */       Nonerealtimerolelevelrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), noneRealTimeRoleLevelRank);
/*     */     }
/*  62 */     noneRealTimeRoleLevelRank.getRankdatas().clear();
/*  63 */     noneRealTimeRoleLevelRank.getKeytorankchange().clear();
/*     */     
/*     */ 
/*     */ 
/*  67 */     noneRealTimeRoleLevelRank.setSavetime(getSaveDbTime());
/*     */     
/*  69 */     for (RoleLevelChart roleLevelChart : getCacheRankDatas())
/*     */     {
/*  71 */       NoneRealRoleLevelBean noneRealRoleLevelBean = Pod.newNoneRealRoleLevelBean();
/*  72 */       noneRealRoleLevelBean.setLevel(roleLevelChart.getLevel());
/*  73 */       noneRealRoleLevelBean.setRoleid(roleLevelChart.getKey().longValue());
/*  74 */       noneRealRoleLevelBean.setLvuptime(roleLevelChart.getLvupTime());
/*  75 */       noneRealTimeRoleLevelRank.getRankdatas().add(noneRealRoleLevelBean);
/*     */     }
/*     */     
/*  78 */     noneRealTimeRoleLevelRank.getKeytorankchange().putAll(getCacheRankChangeMap());
/*     */   }
/*     */   
/*     */ 
/*     */   public void initCachDataFromDb()
/*     */   {
/*  84 */     NoneRealTimeRoleLevelRank noneRealTimeRoleLevelRank = Nonerealtimerolelevelrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*     */     
/*  86 */     if (noneRealTimeRoleLevelRank != null)
/*     */     {
/*     */ 
/*  89 */       _initSaveDbTime(noneRealTimeRoleLevelRank.getSavetime());
/*  90 */       List<RoleLevelChart> roleLevelCharts = new ArrayList();
/*  91 */       for (NoneRealRoleLevelBean roleLevelBean : noneRealTimeRoleLevelRank.getRankdatas())
/*     */       {
/*  93 */         long roleId = roleLevelBean.getRoleid();
/*     */         
/*  95 */         if (RoleInterface.isRoleRealDel(roleId))
/*     */         {
/*  97 */           GameServer.logger().info(String.format("[mfv]NoneRealTimeRoleLevelRankManager.initCachDataFromDb@ role is deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 103 */           RoleLevelChart roleLevelChart = new RoleLevelChart(roleId, roleLevelBean.getLevel(), roleLevelBean.getLvuptime());
/*     */           
/* 105 */           roleLevelCharts.add(roleLevelChart);
/*     */         }
/*     */       }
/* 108 */       _initCacheRankDatas(roleLevelCharts);
/*     */       
/* 110 */       _initCacheRankChangeMap(noneRealTimeRoleLevelRank.getKeytorankchange());
/*     */       
/* 112 */       long awrdTime = noneRealTimeRoleLevelRank.getAwardtime();
/* 113 */       if (awrdTime <= 0L)
/*     */       {
/*     */ 
/* 116 */         noneRealTimeRoleLevelRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 121 */         checkAndAwarad(noneRealTimeRoleLevelRank);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkAndAwarad(NoneRealTimeRoleLevelRank noneRealTimeRoleLevelRank)
/*     */   {
/* 128 */     long awardTime = noneRealTimeRoleLevelRank.getAwardtime();
/* 129 */     boolean sameTime = RankInterface.isInSameAwardTime(awardTime, 2);
/* 130 */     if (!sameTime)
/*     */     {
/*     */ 
/* 133 */       if (mzm.gsp.open.main.OpenInterface.getOpenStatus(145))
/*     */       {
/* 135 */         int rank = RankInterface.getAwardRank(2);
/* 136 */         GameServer.logger().info(String.format("[Role]NoneRealTimeRoleLevelRankManager.checkAndAwarad@do award rank|rank=%d", new Object[] { Integer.valueOf(rank) }));
/*     */         
/* 138 */         NoneRealTimeRoleLevelRankBackUp xNoneRealTimeRoleLevelRankBackUp = initBackUp();
/* 139 */         for (int i = 0; i <= rank; i++)
/*     */         {
/* 141 */           if (noneRealTimeRoleLevelRank.getRankdatas().size() <= i)
/*     */             break;
/* 143 */           NoneRealRoleLevelBean xNoneRealRoleLevelBean = (NoneRealRoleLevelBean)noneRealTimeRoleLevelRank.getRankdatas().get(i);
/* 144 */           long roleid = xNoneRealRoleLevelBean.getRoleid();
/* 145 */           NoneRealTimeTaskManager.getInstance().addTask(new AwardProcedure(roleid, i));
/*     */           
/* 147 */           GameServer.logger().info(String.format("[Role]NoneRealTimeRoleLevelRankManager.checkAndAwarad@do award rank|rank=%d|roleid=%d", new Object[] { Integer.valueOf(rank), Long.valueOf(roleid) }));
/*     */           
/*     */ 
/*     */ 
/* 151 */           backUp(xNoneRealTimeRoleLevelRankBackUp, xNoneRealRoleLevelBean);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */       noneRealTimeRoleLevelRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     else
/*     */     {
/* 164 */       GameServer.logger().info(String.format("[Role]NoneRealTimeRoleLevelRankManager.checkAndAwarad@do not needAward|awardTime=%d", new Object[] { Long.valueOf(awardTime) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private NoneRealTimeRoleLevelRankBackUp initBackUp()
/*     */   {
/* 177 */     NoneRealTimeRoleLevelRankBackUp xNRTRoleLevelRankBackUp = Nonerealtimerolelevelrankbackup.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 178 */     if (xNRTRoleLevelRankBackUp == null)
/*     */     {
/* 180 */       xNRTRoleLevelRankBackUp = Pod.newNoneRealTimeRoleLevelRankBackUp();
/* 181 */       Nonerealtimerolelevelrankbackup.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xNRTRoleLevelRankBackUp);
/*     */     }
/* 183 */     xNRTRoleLevelRankBackUp.getRankdatas().clear();
/* 184 */     return xNRTRoleLevelRankBackUp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void backUp(NoneRealTimeRoleLevelRankBackUp xNRTRoleLevelRankBackUp, NoneRealRoleLevelBean xNRRoleLevelBeanDB)
/*     */   {
/* 196 */     if (xNRRoleLevelBeanDB == null)
/*     */     {
/* 198 */       return;
/*     */     }
/* 200 */     NoneRealRoleLevelBean xNRRoleLevelBeanBackUp = Pod.newNoneRealRoleLevelBean();
/* 201 */     xNRRoleLevelBeanBackUp.setRoleid(xNRRoleLevelBeanDB.getRoleid());
/* 202 */     xNRRoleLevelBeanBackUp.setLevel(xNRRoleLevelBeanDB.getLevel());
/* 203 */     xNRRoleLevelBeanBackUp.setLvuptime(xNRRoleLevelBeanDB.getLvuptime());
/*     */     
/* 205 */     xNRTRoleLevelRankBackUp.getRankdatas().add(xNRRoleLevelBeanBackUp);
/*     */   }
/*     */   
/*     */   private static class AwardProcedure extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     
/*     */     public AwardProcedure(long roleid, int rank)
/*     */     {
/* 215 */       this.roleid = roleid;
/* 216 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 222 */       String userid = RoleInterface.getUserId(this.roleid);
/* 223 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/* 224 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 225 */       RankInterface.sendChartAward(userid, this.roleid, 2, this.rank);
/* 226 */       NoneRealTimeRoleLevelRankManager.tlogRankAward(userid, this.roleid, this.rank);
/* 227 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogRankAward(String userId, long roleId, int rank)
/*     */   {
/* 243 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 244 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 246 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(rank) };
/*     */     
/* 248 */     TLogManager.getInstance().addLog(roleId, "RoleLevelRankAwardInfo", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long ranRoleFromRankList()
/*     */   {
/* 258 */     return RoleManager.ranOneFromRankList(getRankListRoleIds());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getRankListRoleIds()
/*     */   {
/* 268 */     List<Long> roleIds = new ArrayList();
/* 269 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(2);
/* 270 */     int size = chartSubTypeCfg.capacity;
/* 271 */     List<RoleFightValueChart> roleFightValueCharts = NoneRealFightValueRankManager.getInstance().getRankObjs(0, size - 1);
/* 272 */     for (RoleFightValueChart each : roleFightValueCharts)
/*     */     {
/* 274 */       roleIds.add(each.getKey());
/*     */     }
/* 276 */     return roleIds;
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 282 */     int level = RoleInterface.getLevel(roleid);
/* 283 */     long lvupTime = RoleInterface.getLevelUpCurTime(roleid);
/* 284 */     if (lvupTime <= 0L)
/*     */     {
/* 286 */       GameServer.logger().error(String.format("[Role]NoneRealTimeRoleLevelRankManager.addRankRoleForIDIP@role not exist|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */     }
/*     */     
/* 289 */     rank(new RoleLevelChart(roleid, level, lvupTime));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void doAward()
/*     */   {
/* 301 */     NoneRealTimeRoleLevelRank noneRealTimeRoleLevelRank = Nonerealtimerolelevelrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 302 */     if (noneRealTimeRoleLevelRank != null)
/*     */     {
/* 304 */       checkAndAwarad(noneRealTimeRoleLevelRank);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\NoneRealTimeRoleLevelRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */