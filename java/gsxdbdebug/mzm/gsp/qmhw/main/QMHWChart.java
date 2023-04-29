/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import xbean.QMHWRank;
/*    */ import xbean.QMHWRankRole;
/*    */ import xbean.RoleQMHWScore;
/*    */ import xtable.Role2qmhw;
/*    */ 
/*    */ public class QMHWChart extends mzm.gsp.chart.main.RoleKeyRankManagerNew<QMHWChartObj>
/*    */ {
/*    */   private static QMHWChart instance;
/*    */   
/*    */   public static QMHWChart getInstance()
/*    */   {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   static void init() {
/* 18 */     if (instance == null) {
/* 19 */       instance = new QMHWChart(14);
/*    */     } else {
/* 21 */       throw new RuntimeException("初始化七脉会武排行榜时，manager不为null");
/*    */     }
/*    */   }
/*    */   
/*    */   private QMHWChart(int chartType) {
/* 26 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 32 */     QMHWRank xQmhwRank = xtable.Qmhwrank.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 33 */     if (xQmhwRank == null) {
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     for (QMHWRankRole xQmhwRankRole : xQmhwRank.getRanklist()) {
/* 38 */       long roleid = xQmhwRankRole.getRoleid();
/*    */       
/* 40 */       int score = Role2qmhw.selectScore(Long.valueOf(roleid)).intValue();
/* 41 */       QMHWChartObj qmhwChartObj = new QMHWChartObj(roleid, score);
/* 42 */       rank(qmhwChartObj);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 50 */     java.util.List<QMHWChartObj> qmhwChartObjs = getAllChartObjs();
/* 51 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 52 */     QMHWRank xQmhwRank = xtable.Qmhwrank.get(Long.valueOf(localid));
/* 53 */     if (xQmhwRank != null) {
/* 54 */       xQmhwRank.getRanklist().clear();
/*    */     } else {
/* 56 */       xQmhwRank = xbean.Pod.newQMHWRank();
/* 57 */       xtable.Qmhwrank.insert(Long.valueOf(localid), xQmhwRank);
/*    */     }
/* 59 */     for (QMHWChartObj qmhwChartObj : qmhwChartObjs) {
/* 60 */       QMHWRankRole xQmhwRankRole = xbean.Pod.newQMHWRankRole();
/* 61 */       xQmhwRankRole.setRoleid(qmhwChartObj.roleid);
/* 62 */       xQmhwRankRole.setScore(qmhwChartObj.score);
/* 63 */       xQmhwRank.getRanklist().add(xQmhwRankRole);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addRankRoleForIDIP(long roleid)
/*    */   {
/* 69 */     Integer score = Role2qmhw.selectScore(Long.valueOf(roleid));
/* 70 */     if (score != null) {
/* 71 */       QMHWChartObj qmhwChartObj = new QMHWChartObj(roleid, score.intValue());
/* 72 */       rank(qmhwChartObj);
/*    */     }
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid)
/*    */   {
/* 78 */     RoleQMHWScore xRoleQMHWScore = Role2qmhw.get(Long.valueOf(roleid));
/* 79 */     if (xRoleQMHWScore != null) {
/* 80 */       xRoleQMHWScore.setScore(mzm.gsp.qmhw.confbean.SQMHWCfgConsts.getInstance().INI_SCORE);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void setScore(long roleid, int score)
/*    */   {
/* 92 */     RoleQMHWScore xRoleQMHWScore = QMHWManager.getXQMHWRoleCreateIfNotExist(roleid);
/* 93 */     xRoleQMHWScore.setScore(score);
/* 94 */     QMHWManager.sendQMHWRoleInfo(roleid, xRoleQMHWScore);
/*    */     
/* 96 */     QMHWChartObj qmhwChartObj = new QMHWChartObj(roleid, score);
/* 97 */     rank(qmhwChartObj);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */