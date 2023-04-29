/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import xbean.MasterRankInfo;
/*     */ import xbean.RoleMasterRankInfo;
/*     */ import xtable.Masterrank;
/*     */ 
/*     */ public class MasterRankManager extends RoleKeyRankManagerNew<RoleMasterChart>
/*     */ {
/*     */   private static MasterRankManager instance;
/*     */   
/*     */   private MasterRankManager(int charttype)
/*     */   {
/*  16 */     super(charttype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  23 */     if (instance != null)
/*     */     {
/*  25 */       return;
/*     */     }
/*     */     
/*     */ 
/*  29 */     instance = new MasterRankManager(13);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static MasterRankManager getInstance()
/*     */   {
/*  36 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  43 */     List<RoleMasterChart> allMasterCharts = getAllChartObjs();
/*     */     
/*     */ 
/*  46 */     MasterRankInfo xLocalMasterRankInfo = Masterrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  47 */     if (xLocalMasterRankInfo == null)
/*     */     {
/*  49 */       xLocalMasterRankInfo = xbean.Pod.newMasterRankInfo();
/*  50 */       Masterrank.add(Long.valueOf(GameServerInfoManager.getLocalId()), xLocalMasterRankInfo);
/*     */     }
/*  52 */     List<RoleMasterRankInfo> xRoleMasterRankList = xLocalMasterRankInfo.getRolemasterrankdatas();
/*  53 */     xRoleMasterRankList.clear();
/*     */     
/*  55 */     for (RoleMasterChart roleMasterChart : allMasterCharts)
/*     */     {
/*  57 */       RoleMasterRankInfo xRoleMasterRankInfo = xbean.Pod.newRoleMasterRankInfo();
/*  58 */       xRoleMasterRankInfo.setRoleid(roleMasterChart.getKey().longValue());
/*  59 */       xRoleMasterRankList.add(xRoleMasterRankInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  66 */     MasterRankInfo xMasterRankInfo = Masterrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  67 */     if (xMasterRankInfo != null)
/*     */     {
/*  69 */       for (RoleMasterRankInfo xRoleMasterRankInfo : xMasterRankInfo.getRolemasterrankdatas())
/*     */       {
/*  71 */         long roleId = xRoleMasterRankInfo.getRoleid();
/*     */         
/*  73 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleId))
/*     */         {
/*  75 */           mzm.gsp.GameServer.logger().info(String.format("[shitu]MasterRankManager.rankDataFromDB@role is deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  80 */           int apprenticSize = ShiTuManager.selectApprenticeSize(roleId);
/*     */           
/*  82 */           RoleMasterChart roleMasterChart = new RoleMasterChart(roleId, apprenticSize);
/*     */           
/*  84 */           rank(roleMasterChart);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void rank(long roleId, int apprenticeSize)
/*     */   {
/*  98 */     RoleMasterChart roleMasterChart = new RoleMasterChart(roleId, apprenticeSize);
/*  99 */     rank(roleMasterChart);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 105 */     getInstance().rank(new RoleMasterChart(roleid, ShiTuManager.selectApprenticeSize(roleid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleId)
/*     */   {
/* 114 */     xbean.role2ShiTuInfo xRole2ShiTuInfo = xtable.Role2shitu.get(Long.valueOf(roleId));
/* 115 */     if (xRole2ShiTuInfo == null)
/*     */     {
/* 117 */       return;
/*     */     }
/* 119 */     xRole2ShiTuInfo.getMasterinfo().getApprentice_graduate().clear();
/* 120 */     delete(Long.valueOf(roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\MasterRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */