/*     */ package mzm.gsp.role.multirank;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*     */ import xbean.MultiFightValueRank;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMultiFightValueBean;
/*     */ import xtable.Multifightvaluerank;
/*     */ 
/*     */ public class MultiFightValueRankManager extends RoleKeyRankManagerNew<RoleMultiFightValueChart>
/*     */ {
/*     */   private static MultiFightValueRankManager instance;
/*     */   
/*     */   public static MultiFightValueRankManager getInstance()
/*     */   {
/*  18 */     return instance;
/*     */   }
/*     */   
/*     */   public static void init()
/*     */   {
/*  23 */     if (instance != null)
/*     */     {
/*  25 */       return;
/*     */     }
/*  27 */     instance = new MultiFightValueRankManager(12);
/*     */   }
/*     */   
/*     */   public MultiFightValueRankManager(int chartType)
/*     */   {
/*  32 */     super(chartType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveToDB()
/*     */   {
/*  39 */     List<RoleMultiFightValueChart> allObjs = getAllChartObjs();
/*  40 */     MultiFightValueRank xMFValueRank = Multifightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  41 */     if (xMFValueRank == null)
/*     */     {
/*  43 */       xMFValueRank = Pod.newMultiFightValueRank();
/*  44 */       Multifightvaluerank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xMFValueRank);
/*     */     }
/*  46 */     xMFValueRank.getRolerankdatas().clear();
/*  47 */     for (RoleMultiFightValueChart roleMultiFightValueChart : allObjs)
/*     */     {
/*  49 */       RoleMultiFightValueBean xMFVBean = Pod.newRoleMultiFightValueBean();
/*  50 */       xMFVBean.setRoleid(roleMultiFightValueChart.getKey().longValue());
/*  51 */       xMFValueRank.getRolerankdatas().add(xMFVBean);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void rankDataFromDB()
/*     */   {
/*  58 */     MultiFightValueRank xMFVRank = Multifightvaluerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  59 */     if (xMFVRank != null)
/*     */     {
/*  61 */       for (RoleMultiFightValueBean xMFVBean : xMFVRank.getRolerankdatas())
/*     */       {
/*  63 */         long roleId = xMFVBean.getRoleid();
/*  64 */         if (mzm.gsp.role.main.RoleInterface.isRoleRealDel(roleId))
/*     */         {
/*  66 */           GameServer.logger().error(String.format("[mfv]MultiFightValueRankManager.rankDataFromDB@ role is real deleted!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  71 */           RoleMultiFightValueChart roleMFVChart = new RoleMultiFightValueChart(roleId, MultiRankManager.getRoleMFValue(roleId));
/*     */           
/*  73 */           rank(roleMFVChart);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRankRoleForIDIP(long roleid)
/*     */   {
/*  81 */     int mfv = MultiRankManager.getRoleMFValue(roleid);
/*  82 */     rank(new RoleMultiFightValueChart(roleid, mfv));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clearRoleRankData(long roleid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private RoleMultiFightValueChart getRoleChartObj(long roleId)
/*     */   {
/*  99 */     return (RoleMultiFightValueChart)super.getObjByKey(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRankMFV(long roleId)
/*     */   {
/* 110 */     RoleMultiFightValueChart chartObj = getRoleChartObj(roleId);
/* 111 */     return chartObj == null ? 0 : chartObj.getFightValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MultiFightValueRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */