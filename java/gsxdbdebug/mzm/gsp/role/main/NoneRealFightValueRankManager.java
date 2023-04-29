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
/*     */ import xbean.NoneRealRoleFightValueBean;
/*     */ import xbean.NoneRealTimeFightValueRank;
/*     */ import xbean.NoneRealTimeFightValueRankBackUp;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimefightvaluerank;
/*     */ import xtable.Nonerealtimefightvaluerankbackup;
/*     */ 
/*     */ public class NoneRealFightValueRankManager extends NoneRealTimeRoleKeyRankManagerNew<RoleFightValueChart> implements mzm.gsp.chart.main.RankAwardHandler
/*     */ {
/*     */   private static NoneRealFightValueRankManager instance;
/*     */   
/*     */   public static NoneRealFightValueRankManager getInstance()
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
/*  42 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(0);
/*  43 */     instance = new NoneRealFightValueRankManager(chartSubTypeCfg.chartType, FightValueRankManager.getInstance());
/*  44 */     RankInterface.registerRankAwardHandle(0, getInstance());
/*     */   }
/*     */   
/*     */   private NoneRealFightValueRankManager(int chartType, FightValueRankManager fightValueRankManager)
/*     */   {
/*  49 */     super(chartType, fightValueRankManager);
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  55 */     NoneRealTimeFightValueRank noneRealTimeFightValueRank = Nonerealtimefightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  56 */     if (noneRealTimeFightValueRank == null)
/*     */     {
/*  58 */       noneRealTimeFightValueRank = Pod.newNoneRealTimeFightValueRank();
/*  59 */       noneRealTimeFightValueRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*  60 */       Nonerealtimefightvaluerank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), noneRealTimeFightValueRank);
/*     */     }
/*  62 */     noneRealTimeFightValueRank.getRankdatas().clear();
/*  63 */     noneRealTimeFightValueRank.getKeytorankchange().clear();
/*     */     
/*     */ 
/*     */ 
/*  67 */     noneRealTimeFightValueRank.setSavetime(getSaveDbTime());
/*     */     
/*  69 */     for (RoleFightValueChart roleFightValueChart : getCacheRankDatas())
/*     */     {
/*  71 */       NoneRealRoleFightValueBean roleFightValueBean = Pod.newNoneRealRoleFightValueBean();
/*  72 */       roleFightValueBean.setFightvalue(roleFightValueChart.getFightValue());
/*  73 */       roleFightValueBean.setRoleid(roleFightValueChart.getKey().longValue());
/*  74 */       noneRealTimeFightValueRank.getRankdatas().add(roleFightValueBean);
/*     */     }
/*     */     
/*  77 */     noneRealTimeFightValueRank.getKeytorankchange().putAll(getCacheRankChangeMap());
/*     */     
/*  79 */     mzm.gsp.role.log.LogRankManager.logFVRankAsyn();
/*     */   }
/*     */   
/*     */ 
/*     */   public void initCachDataFromDb()
/*     */   {
/*  85 */     NoneRealTimeFightValueRank noneRealTimeFightValueRank = Nonerealtimefightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  86 */     if (noneRealTimeFightValueRank != null)
/*     */     {
/*     */ 
/*  89 */       _initSaveDbTime(noneRealTimeFightValueRank.getSavetime());
/*  90 */       List<RoleFightValueChart> roleFightValueCharts = new ArrayList();
/*  91 */       for (NoneRealRoleFightValueBean roleFightValueBean : noneRealTimeFightValueRank.getRankdatas())
/*     */       {
/*  93 */         long roleId = roleFightValueBean.getRoleid();
/*     */         
/*  95 */         if (RoleInterface.isRoleRealDel(roleId))
/*     */         {
/*  97 */           GameServer.logger().info(String.format("[mfv]NoneRealFightValueRankManager.initCachDataFromDb@ role is deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 102 */           RoleFightValueChart roleFightValueChart = new RoleFightValueChart(roleId, roleFightValueBean.getFightvalue());
/* 103 */           roleFightValueCharts.add(roleFightValueChart);
/*     */         }
/*     */       }
/* 106 */       _initCacheRankDatas(roleFightValueCharts);
/*     */       
/* 108 */       _initCacheRankChangeMap(noneRealTimeFightValueRank.getKeytorankchange());
/*     */       
/*     */ 
/* 111 */       long awrdTime = noneRealTimeFightValueRank.getAwardtime();
/* 112 */       if (awrdTime <= 0L)
/*     */       {
/* 114 */         noneRealTimeFightValueRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 119 */         checkAndAward(noneRealTimeFightValueRank);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkAndAward(NoneRealTimeFightValueRank xNoneRealTimeFightValueRank)
/*     */   {
/* 126 */     long awardTime = xNoneRealTimeFightValueRank.getAwardtime();
/* 127 */     boolean sameTime = RankInterface.isInSameAwardTime(awardTime, 0);
/* 128 */     if (!sameTime)
/*     */     {
/*     */ 
/* 131 */       if (mzm.gsp.open.main.OpenInterface.getOpenStatus(149))
/*     */       {
/* 133 */         int rank = RankInterface.getAwardRank(0);
/* 134 */         GameServer.logger().info(String.format("[Role]NoneRealFightValueRankManager.checkAndAwarad@do award rank|rank=%d", new Object[] { Integer.valueOf(rank) }));
/*     */         
/* 136 */         NoneRealTimeFightValueRankBackUp xNRTRoleFVBackUp = initBackUp();
/* 137 */         for (int i = 0; i <= rank; i++)
/*     */         {
/* 139 */           if (xNoneRealTimeFightValueRank.getRankdatas().size() <= i)
/*     */             break;
/* 141 */           NoneRealRoleFightValueBean xNoneRealRoleFightValueBean = (NoneRealRoleFightValueBean)xNoneRealTimeFightValueRank.getRankdatas().get(i);
/*     */           
/* 143 */           long roleid = xNoneRealRoleFightValueBean.getRoleid();
/* 144 */           NoneRealTimeTaskManager.getInstance().addTask(new AwardProcedure(roleid, i));
/*     */           
/* 146 */           GameServer.logger().info(String.format("[Role]NoneRealFightValueRankManager.checkAndAwarad@do award rank|rank=%d|roleid=%d", new Object[] { Integer.valueOf(rank), Long.valueOf(roleid) }));
/*     */           
/*     */ 
/*     */ 
/* 150 */           backUp(xNRTRoleFVBackUp, xNoneRealRoleFightValueBean);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */       xNoneRealTimeFightValueRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     else
/*     */     {
/* 163 */       GameServer.logger().info(String.format("[Role]NoneRealFightValueRankManager.checkAndAwarad@do not needAward|awardTime=%d", new Object[] { Long.valueOf(awardTime) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private NoneRealTimeFightValueRankBackUp initBackUp()
/*     */   {
/* 175 */     NoneRealTimeFightValueRankBackUp xNRTRoleFVBackUp = Nonerealtimefightvaluerankbackup.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 176 */     if (xNRTRoleFVBackUp == null)
/*     */     {
/* 178 */       xNRTRoleFVBackUp = Pod.newNoneRealTimeFightValueRankBackUp();
/* 179 */       Nonerealtimefightvaluerankbackup.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xNRTRoleFVBackUp);
/*     */     }
/* 181 */     xNRTRoleFVBackUp.getRankdatas().clear();
/* 182 */     return xNRTRoleFVBackUp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void backUp(NoneRealTimeFightValueRankBackUp xNRTRoleFVBackUp, NoneRealRoleFightValueBean xNRTRoleFVBeanDB)
/*     */   {
/* 194 */     if (xNRTRoleFVBeanDB == null)
/*     */     {
/* 196 */       return;
/*     */     }
/* 198 */     NoneRealRoleFightValueBean xNRTRoleFVBeanBackUp = Pod.newNoneRealRoleFightValueBean();
/* 199 */     xNRTRoleFVBeanBackUp.setRoleid(xNRTRoleFVBeanDB.getRoleid());
/* 200 */     xNRTRoleFVBeanBackUp.setFightvalue(xNRTRoleFVBeanDB.getFightvalue());
/*     */     
/* 202 */     xNRTRoleFVBackUp.getRankdatas().add(xNRTRoleFVBeanBackUp);
/*     */   }
/*     */   
/*     */   private static class AwardProcedure extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int rank;
/*     */     
/*     */     public AwardProcedure(long roleid, int rank)
/*     */     {
/* 212 */       this.roleid = roleid;
/* 213 */       this.rank = rank;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 219 */       String userid = RoleInterface.getUserId(this.roleid);
/* 220 */       lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/* 221 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 222 */       RankInterface.sendChartAward(userid, this.roleid, 0, this.rank);
/* 223 */       NoneRealFightValueRankManager.tlogRankAward(userid, this.roleid, this.rank);
/* 224 */       return true;
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
/* 240 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 241 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 243 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(rank) };
/*     */     
/* 245 */     TLogManager.getInstance().addLog(roleId, "RoleFightRankAwardInfo", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long ranRoleFromRankList()
/*     */   {
/* 255 */     return RoleManager.ranOneFromRankList(getRankListRoleIds());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getRankListRoleIds()
/*     */   {
/* 265 */     List<Long> roleIds = new ArrayList();
/* 266 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(0);
/* 267 */     int size = chartSubTypeCfg.capacity;
/* 268 */     List<RoleFightValueChart> roleFightValueCharts = getInstance().getRankObjs(0, size - 1);
/* 269 */     for (RoleFightValueChart each : roleFightValueCharts)
/*     */     {
/* 271 */       roleIds.add(each.getKey());
/*     */     }
/* 273 */     return roleIds;
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 279 */     int fightValue = RoleInterface.getFightValue(roleid);
/* 280 */     rank(new RoleFightValueChart(roleid, fightValue));
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
/* 292 */     NoneRealTimeFightValueRank noneRealTimeFightValueRank = Nonerealtimefightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 293 */     if (noneRealTimeFightValueRank != null)
/*     */     {
/* 295 */       checkAndAward(noneRealTimeFightValueRank);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\NoneRealFightValueRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */