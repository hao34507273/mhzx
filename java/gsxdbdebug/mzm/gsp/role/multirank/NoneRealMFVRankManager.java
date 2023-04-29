/*     */ package mzm.gsp.role.multirank;
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
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NoneRealRoleMultiFightValueBean;
/*     */ import xbean.NoneRealTimeMultiFightValueRank;
/*     */ import xbean.NoneRealTimeMultiFightValueRankBackUp;
/*     */ import xbean.Pod;
/*     */ import xtable.Nonerealtimemultifightvaluerank;
/*     */ import xtable.Nonerealtimemultifightvaluerankbackup;
/*     */ import xtable.User;
/*     */ 
/*     */ public class NoneRealMFVRankManager extends NoneRealTimeRoleKeyRankManagerNew<RoleMultiFightValueChart> implements mzm.gsp.chart.main.RankAwardHandler
/*     */ {
/*     */   private static NoneRealMFVRankManager instance;
/*     */   
/*     */   public static NoneRealMFVRankManager getInstance()
/*     */   {
/*  33 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void init()
/*     */   {
/*  41 */     if (instance != null)
/*     */     {
/*  43 */       return;
/*     */     }
/*  45 */     SChartSubTypeCfg chartSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(12);
/*  46 */     instance = new NoneRealMFVRankManager(chartSubTypeCfg.chartType, MultiFightValueRankManager.getInstance());
/*  47 */     RankInterface.registerRankAwardHandle(12, instance);
/*     */   }
/*     */   
/*     */   private NoneRealMFVRankManager(int chartType, MultiFightValueRankManager fightValueRankManager)
/*     */   {
/*  52 */     super(chartType, fightValueRankManager);
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  58 */     NoneRealTimeMultiFightValueRank noneRealTimeMFVRank = Nonerealtimemultifightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  59 */     if (noneRealTimeMFVRank == null)
/*     */     {
/*  61 */       noneRealTimeMFVRank = Pod.newNoneRealTimeMultiFightValueRank();
/*  62 */       noneRealTimeMFVRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*  63 */       Nonerealtimemultifightvaluerank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), noneRealTimeMFVRank);
/*     */     }
/*  65 */     noneRealTimeMFVRank.getRankdatas().clear();
/*  66 */     noneRealTimeMFVRank.getKeytorankchange().clear();
/*     */     
/*     */ 
/*     */ 
/*  70 */     noneRealTimeMFVRank.setSavetime(getSaveDbTime());
/*     */     
/*  72 */     for (RoleMultiFightValueChart roleMFVChart : getCacheRankDatas())
/*     */     {
/*  74 */       NoneRealRoleMultiFightValueBean roleMFVBean = Pod.newNoneRealRoleMultiFightValueBean();
/*  75 */       roleMFVBean.setMultifightvalue(roleMFVChart.getFightValue());
/*  76 */       roleMFVBean.setRoleid(roleMFVChart.getKey().longValue());
/*  77 */       noneRealTimeMFVRank.getRankdatas().add(roleMFVBean);
/*     */     }
/*     */     
/*  80 */     noneRealTimeMFVRank.getKeytorankchange().putAll(getCacheRankChangeMap());
/*     */     
/*  82 */     mzm.gsp.role.log.LogRankManager.logMFVRankAsyn();
/*     */   }
/*     */   
/*     */ 
/*     */   public void initCachDataFromDb()
/*     */   {
/*  88 */     NoneRealTimeMultiFightValueRank noneRealTimeMFVRank = Nonerealtimemultifightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  89 */     if (noneRealTimeMFVRank != null)
/*     */     {
/*     */ 
/*  92 */       _initSaveDbTime(noneRealTimeMFVRank.getSavetime());
/*  93 */       List<RoleMultiFightValueChart> roleMFVCharts = new ArrayList();
/*  94 */       for (NoneRealRoleMultiFightValueBean roleFightValueBean : noneRealTimeMFVRank.getRankdatas())
/*     */       {
/*  96 */         long roleId = roleFightValueBean.getRoleid();
/*  97 */         if (RoleInterface.isRoleRealDel(roleId))
/*     */         {
/*  99 */           GameServer.logger().error(String.format("[mfv]NoneRealMFVRankManager.initCachDataFromDb@ role is real deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 104 */           RoleMultiFightValueChart roleFightValueChart = new RoleMultiFightValueChart(roleId, roleFightValueBean.getMultifightvalue());
/*     */           
/*     */ 
/* 107 */           roleMFVCharts.add(roleFightValueChart);
/*     */         }
/*     */       }
/* 110 */       _initCacheRankDatas(roleMFVCharts);
/*     */       
/* 112 */       _initCacheRankChangeMap(noneRealTimeMFVRank.getKeytorankchange());
/*     */       
/* 114 */       long awrdTime = noneRealTimeMFVRank.getAwardtime();
/* 115 */       if (awrdTime <= 0L)
/*     */       {
/*     */ 
/* 118 */         noneRealTimeMFVRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 123 */         checkAndAwarad(noneRealTimeMFVRank);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkAndAwarad(NoneRealTimeMultiFightValueRank noneRealTimeMFVRank)
/*     */   {
/* 130 */     long awardTime = noneRealTimeMFVRank.getAwardtime();
/* 131 */     boolean sameTime = RankInterface.isInSameAwardTime(awardTime, 12);
/* 132 */     if (!sameTime)
/*     */     {
/*     */ 
/* 135 */       if (OpenInterface.getOpenStatus(147))
/*     */       {
/* 137 */         int rank = RankInterface.getAwardRank(12);
/* 138 */         GameServer.logger().info(String.format("[Role]NoneRealMFVRankManager.checkAndAwarad@do award rank|rank=%d", new Object[] { Integer.valueOf(rank) }));
/*     */         
/* 140 */         NoneRealTimeMultiFightValueRankBackUp xNRTRoleMFVBackUp = initBackUp();
/* 141 */         for (int i = 0; i <= rank; i++)
/*     */         {
/* 143 */           if (noneRealTimeMFVRank.getRankdatas().size() <= i)
/*     */             break;
/* 145 */           NoneRealRoleMultiFightValueBean xNoneRealRoleMultiFightBean = (NoneRealRoleMultiFightValueBean)noneRealTimeMFVRank.getRankdatas().get(i);
/*     */           
/* 147 */           long roleid = xNoneRealRoleMultiFightBean.getRoleid();
/* 148 */           NoneRealTimeTaskManager.getInstance().addTask(new AwardProcedure(roleid, i));
/*     */           
/* 150 */           GameServer.logger().info(String.format("[Role]NoneRealMFVRankManager.checkAndAwarad@do award rank|rank=%d|roleid=%d", new Object[] { Integer.valueOf(rank), Long.valueOf(roleid) }));
/*     */           
/*     */ 
/* 153 */           backUp(xNRTRoleMFVBackUp, xNoneRealRoleMultiFightBean);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */       noneRealTimeMFVRank.setAwardtime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     else
/*     */     {
/* 166 */       GameServer.logger().info(String.format("[Role]NoneRealMFVRankManager.checkAndAwarad@do not needAward|awardTime=%d", new Object[] { Long.valueOf(awardTime) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private NoneRealTimeMultiFightValueRankBackUp initBackUp()
/*     */   {
/* 178 */     NoneRealTimeMultiFightValueRankBackUp xNRTRoleMFVBackUp = Nonerealtimemultifightvaluerankbackup.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 179 */     if (xNRTRoleMFVBackUp == null)
/*     */     {
/* 181 */       xNRTRoleMFVBackUp = Pod.newNoneRealTimeMultiFightValueRankBackUp();
/* 182 */       Nonerealtimemultifightvaluerankbackup.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xNRTRoleMFVBackUp);
/*     */     }
/* 184 */     xNRTRoleMFVBackUp.getRankdatas().clear();
/* 185 */     return xNRTRoleMFVBackUp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void backUp(NoneRealTimeMultiFightValueRankBackUp xNRTRoleMFVBackUp, NoneRealRoleMultiFightValueBean xNRTRoleMFVBeanDB)
/*     */   {
/* 197 */     if (xNRTRoleMFVBeanDB == null)
/*     */     {
/* 199 */       return;
/*     */     }
/* 201 */     NoneRealRoleMultiFightValueBean xNRTRoleMFVBeanBackUp = Pod.newNoneRealRoleMultiFightValueBean();
/* 202 */     xNRTRoleMFVBeanBackUp.setRoleid(xNRTRoleMFVBeanDB.getRoleid());
/* 203 */     xNRTRoleMFVBeanBackUp.setMultifightvalue(xNRTRoleMFVBeanDB.getMultifightvalue());
/*     */     
/* 205 */     xNRTRoleMFVBackUp.getRankdatas().add(xNRTRoleMFVBeanBackUp);
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
/* 223 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 224 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 225 */       RankInterface.sendChartAward(userid, this.roleid, 12, this.rank);
/* 226 */       NoneRealMFVRankManager.tlogRankAward(userid, this.roleid, this.rank);
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
/* 248 */     TLogManager.getInstance().addLog(roleId, "RoleMultiFightRankAwardInfo", colums);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 254 */     int mfv = MultiRankManager.getRoleMFValue(roleid);
/* 255 */     rank(new RoleMultiFightValueChart(roleid, mfv));
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
/* 267 */     NoneRealTimeMultiFightValueRank noneRealTimeMFVRank = Nonerealtimemultifightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 268 */     if (noneRealTimeMFVRank != null)
/*     */     {
/* 270 */       checkAndAwarad(noneRealTimeMFVRank);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\NoneRealMFVRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */