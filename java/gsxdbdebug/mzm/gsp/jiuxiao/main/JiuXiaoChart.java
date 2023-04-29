/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import xbean.JiuXiaoRank;
/*    */ import xbean.JiuXiaoRankRole;
/*    */ 
/*    */ class JiuXiaoChart extends mzm.gsp.chart.main.RoleKeyRankManagerNew<JiuXiaoRankObj>
/*    */ {
/*    */   JiuXiaoChart(int chartType)
/*    */   {
/* 10 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 16 */     java.util.List<JiuXiaoRankObj> jiuXiaoRankObjs = getAllChartObjs();
/*    */     
/* 18 */     long uniqKey = JiuXiaoRankManager.getInstance().getRankUniqKey(this.chartType);
/* 19 */     JiuXiaoRank xJiuXiaoRank = xtable.Jiuxiaorank.get(Long.valueOf(uniqKey));
/* 20 */     if (xJiuXiaoRank != null) {
/* 21 */       xJiuXiaoRank.getRanklist().clear();
/*    */     } else {
/* 23 */       xJiuXiaoRank = xbean.Pod.newJiuXiaoRank();
/* 24 */       xtable.Jiuxiaorank.insert(Long.valueOf(uniqKey), xJiuXiaoRank);
/*    */     }
/* 26 */     for (JiuXiaoRankObj jiuXiaoRankObj : jiuXiaoRankObjs) {
/* 27 */       JiuXiaoRankRole xJiuXiaoRankRole = xbean.Pod.newJiuXiaoRankRole();
/* 28 */       xJiuXiaoRankRole.setLayer(jiuXiaoRankObj.getLayer());
/* 29 */       xJiuXiaoRankRole.setRoleid(jiuXiaoRankObj.getKey().longValue());
/* 30 */       xJiuXiaoRankRole.setSec(jiuXiaoRankObj.getSec());
/* 31 */       xJiuXiaoRank.getRanklist().add(xJiuXiaoRankRole);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 38 */     long uniqKey = JiuXiaoRankManager.getInstance().getRankUniqKey(this.chartType);
/* 39 */     JiuXiaoRank xJiuXiaoRank = xtable.Jiuxiaorank.get(Long.valueOf(uniqKey));
/* 40 */     if (xJiuXiaoRank != null) {
/* 41 */       for (JiuXiaoRankRole jiuXiaoRankRole : xJiuXiaoRank.getRanklist()) {
/* 42 */         JiuXiaoRankObj jiuXiaoRankObj = new JiuXiaoRankObj(jiuXiaoRankRole.getRoleid(), jiuXiaoRankRole.getLayer(), jiuXiaoRankRole.getSec());
/*    */         
/* 44 */         rank(jiuXiaoRankObj);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void addRankRoleForIDIP(long roleid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void clearRoleRankData(long roleid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRankLayer(long roleid)
/*    */   {
/* 66 */     JiuXiaoRankObj jiuXiaoRankObj = (JiuXiaoRankObj)getObjByKey(Long.valueOf(roleid));
/* 67 */     if (jiuXiaoRankObj == null) {
/* 68 */       return -1;
/*    */     }
/* 70 */     return jiuXiaoRankObj.getLayer();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void setLayerAndRank(long roleid, int layer, int timeSec)
/*    */   {
/* 81 */     JiuXiaoRankObj jiuXiaoRankObj = new JiuXiaoRankObj(roleid, layer, timeSec);
/* 82 */     rank(jiuXiaoRankObj);
/*    */   }
/*    */   
/*    */   void pgm_setCapacity(int capacity) {
/* 86 */     this.capacity = capacity;
/* 87 */     this.extraSize = 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */