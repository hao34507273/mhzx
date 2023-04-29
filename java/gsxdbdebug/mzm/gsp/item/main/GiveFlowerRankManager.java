/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xbean.RoleGiveFlowerBean;
/*     */ import xbean.RoleGiveFlowerRank;
/*     */ import xtable.Rolegiveflowerrank;
/*     */ 
/*     */ public class GiveFlowerRankManager extends mzm.gsp.chart.main.RoleKeyRankManagerNew<RoleGiveFlowerChart>
/*     */ {
/*     */   private static GiveFlowerRankManager instance;
/*     */   
/*     */   private GiveFlowerRankManager(int charttype)
/*     */   {
/*  15 */     super(charttype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  22 */     if (instance != null)
/*     */     {
/*  24 */       return;
/*     */     }
/*     */     
/*     */ 
/*  28 */     instance = new GiveFlowerRankManager(5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static GiveFlowerRankManager getInstance()
/*     */   {
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  41 */     List<RoleGiveFlowerChart> allCharts = getAllChartObjs();
/*  42 */     RoleGiveFlowerRank roleGiveFlowerRank = Rolegiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  43 */     if (roleGiveFlowerRank == null)
/*     */     {
/*  45 */       roleGiveFlowerRank = xbean.Pod.newRoleGiveFlowerRank();
/*  46 */       roleGiveFlowerRank.setVersion(ItemGiveManager.getConfigVersion());
/*  47 */       Rolegiveflowerrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), roleGiveFlowerRank);
/*     */     }
/*  49 */     roleGiveFlowerRank.getRankdatas().clear();
/*  50 */     for (RoleGiveFlowerChart roleGiveFlowerChart : allCharts)
/*     */     {
/*  52 */       RoleGiveFlowerBean roleGiveFlowerBean = xbean.Pod.newRoleGiveFlowerBean();
/*  53 */       roleGiveFlowerBean.setRoleid(roleGiveFlowerChart.getKey().longValue());
/*  54 */       roleGiveFlowerBean.setPoint(roleGiveFlowerChart.getGivePoint());
/*  55 */       roleGiveFlowerRank.getRankdatas().add(roleGiveFlowerBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  62 */     RoleGiveFlowerRank roleGiveFlowerRank = Rolegiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  63 */     if (roleGiveFlowerRank != null)
/*     */     {
/*  65 */       for (RoleGiveFlowerBean roleGiveFlowerBean : roleGiveFlowerRank.getRankdatas())
/*     */       {
/*  67 */         long roleid = roleGiveFlowerBean.getRoleid();
/*     */         
/*  69 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  71 */           ItemManager.logger.info(String.format("[flower]GiveFlowerRankManager.rankDataFromDB@ role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  76 */           RoleGiveFlowerChart roleGiveFlowerChart = new RoleGiveFlowerChart(roleid, ItemGiveManager.getGiveFlowerPoint(roleid));
/*     */           
/*  78 */           rank(roleGiveFlowerChart);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/*  90 */     RoleGiveFlowerRank rolegiveflowerrank = Rolegiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  91 */     if (rolegiveflowerrank != null)
/*     */     {
/*  93 */       rolegiveflowerrank.getRankdatas().clear();
/*     */     }
/*  95 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 101 */     getInstance().rank(new RoleGiveFlowerChart(roleid, ItemGiveManager.getGiveFlowerPoint(roleid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 108 */     getInstance().delete(Long.valueOf(roleid));
/* 109 */     xbean.FlowerPoint flowerPoint = xtable.Role2flowerpoint.get(Long.valueOf(roleid));
/* 110 */     if (flowerPoint == null)
/*     */     {
/* 112 */       return;
/*     */     }
/* 114 */     flowerPoint.setGivepoint(0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\GiveFlowerRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */