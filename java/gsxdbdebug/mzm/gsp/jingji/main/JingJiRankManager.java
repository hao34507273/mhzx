/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.RoleJingJiBean;
/*     */ import xbean.RoleJingJiRank;
/*     */ import xtable.Rolejingjirank;
/*     */ 
/*     */ public class JingJiRankManager extends RoleKeyRankManagerNew<RoleJingjiChart>
/*     */ {
/*     */   private static JingJiRankManager instance;
/*     */   
/*     */   private JingJiRankManager(int charttype)
/*     */   {
/*  17 */     super(charttype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  24 */     if (instance != null)
/*     */     {
/*  26 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  31 */     instance = new JingJiRankManager(3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static JingJiRankManager getInstance()
/*     */   {
/*  38 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  45 */     List<RoleJingjiChart> jiuXiaoRankObjs = getAllChartObjs();
/*  46 */     RoleJingJiRank roleJingJiRank = Rolejingjirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  47 */     if (roleJingJiRank == null)
/*     */     {
/*  49 */       roleJingJiRank = xbean.Pod.newRoleJingJiRank();
/*  50 */       Rolejingjirank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), roleJingJiRank);
/*     */     }
/*  52 */     roleJingJiRank.getRankdatas().clear();
/*  53 */     for (RoleJingjiChart roleJingjiChart : jiuXiaoRankObjs)
/*     */     {
/*  55 */       RoleJingJiBean roleJingJiBean = xbean.Pod.newRoleJingJiBean();
/*  56 */       roleJingJiBean.setRoleid(roleJingjiChart.getKey().longValue());
/*  57 */       roleJingJiRank.getRankdatas().add(roleJingJiBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  64 */     RoleJingJiRank roleJingJiRank = Rolejingjirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  65 */     if (roleJingJiRank != null)
/*     */     {
/*  67 */       for (RoleJingJiBean roleJingJiBean : roleJingJiRank.getRankdatas())
/*     */       {
/*  69 */         long roleid = roleJingJiBean.getRoleid();
/*  70 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  72 */           JingjiManager.logger.info(String.format("[jingji]JingjiRankManager.rankDataFromDB@ role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */         }
/*     */         else
/*     */         {
/*  76 */           RoleJingjiChart roleJingjiChart = new RoleJingjiChart(roleid, JingjiManager.getWinpoint(roleid, false));
/*  77 */           rank(roleJingjiChart);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  82 */     NoneRealTimeTaskManager.getInstance().addTask(new PDailyRankAward(getAllChartObjs(), mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/*  92 */     RoleJingJiRank roleJingJiRank = Rolejingjirank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  93 */     if (roleJingJiRank != null)
/*     */     {
/*  95 */       roleJingJiRank.getRankdatas().clear();
/*     */     }
/*  97 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 103 */     getInstance().rank(new RoleJingjiChart(roleid, JingjiManager.getWinpoint(roleid, false)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 111 */     JingjiManager.setWinpoint(roleid, 0);
/* 112 */     getInstance().delete(Long.valueOf(roleid));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingJiRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */