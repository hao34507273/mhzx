/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xbean.RoleReceivceFlowerRank;
/*     */ import xbean.RoleReceiveFlowerBean;
/*     */ import xtable.Rolereceiveflowerrank;
/*     */ 
/*     */ public class ReceiveFlowerRankManager extends mzm.gsp.chart.main.RoleKeyRankManagerNew<RoleReceiveFlowerChart>
/*     */ {
/*     */   private static ReceiveFlowerRankManager instance;
/*     */   
/*     */   private ReceiveFlowerRankManager(int charttype)
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
/*  28 */     instance = new ReceiveFlowerRankManager(6);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static ReceiveFlowerRankManager getInstance()
/*     */   {
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  41 */     List<RoleReceiveFlowerChart> allCharts = getAllChartObjs();
/*  42 */     RoleReceivceFlowerRank receivceFlowerRank = Rolereceiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  43 */     if (receivceFlowerRank == null)
/*     */     {
/*  45 */       receivceFlowerRank = xbean.Pod.newRoleReceivceFlowerRank();
/*  46 */       receivceFlowerRank.setVersion(ItemGiveManager.getConfigVersion());
/*  47 */       Rolereceiveflowerrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), receivceFlowerRank);
/*     */     }
/*  49 */     receivceFlowerRank.getRankdatas().clear();
/*  50 */     for (RoleReceiveFlowerChart roleReceiveFlowerChart : allCharts)
/*     */     {
/*  52 */       RoleReceiveFlowerBean roleReceiveFlowerBean = xbean.Pod.newRoleReceiveFlowerBean();
/*  53 */       roleReceiveFlowerBean.setRoleid(roleReceiveFlowerChart.getKey().longValue());
/*  54 */       roleReceiveFlowerBean.setPoint(roleReceiveFlowerChart.getReceivePoint());
/*  55 */       receivceFlowerRank.getRankdatas().add(roleReceiveFlowerBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  63 */     RoleReceivceFlowerRank receivceFlowerRank = Rolereceiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  64 */     if (receivceFlowerRank != null)
/*     */     {
/*  66 */       for (RoleReceiveFlowerBean roleReceiveFlowerBean : receivceFlowerRank.getRankdatas())
/*     */       {
/*  68 */         long roleid = roleReceiveFlowerBean.getRoleid();
/*  69 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleid))
/*     */         {
/*  71 */           ItemManager.logger.info(String.format("[flower]ReceiveFlowerRankManager.rankDataFromDB@ role is deleted!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  76 */           RoleReceiveFlowerChart roleReceiveFlowerChart = new RoleReceiveFlowerChart(roleid, ItemGiveManager.getReceiveFlowerPoint(roleid));
/*     */           
/*     */ 
/*  79 */           rank(roleReceiveFlowerChart);
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
/*  90 */     RoleReceivceFlowerRank roleReceivceFlowerRank = Rolereceiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  91 */     if (roleReceivceFlowerRank != null)
/*     */     {
/*  93 */       roleReceivceFlowerRank.getRankdatas().clear();
/*     */     }
/*  95 */     super.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/* 101 */     getInstance().rank(new RoleReceiveFlowerChart(roleid, ItemGiveManager.getReceiveFlowerPoint(roleid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid)
/*     */   {
/* 109 */     getInstance().delete(Long.valueOf(roleid));
/* 110 */     xbean.FlowerPoint flowerPoint = xtable.Role2flowerpoint.get(Long.valueOf(roleid));
/* 111 */     if (flowerPoint == null)
/*     */     {
/* 113 */       return;
/*     */     }
/* 115 */     flowerPoint.setReceivepoint(0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ReceiveFlowerRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */