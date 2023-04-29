/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class JiuXiaoRankObj extends RoleKeyChartObj<JiuXiaoRankObj>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int layer;
/*    */   private final int timeSec;
/*    */   
/*    */   public JiuXiaoRankObj(long roleid, int layer, int timeSec) {
/* 12 */     this.roleid = roleid;
/* 13 */     this.layer = layer;
/* 14 */     this.timeSec = timeSec;
/*    */   }
/*    */   
/*    */   public Long getKey()
/*    */   {
/* 19 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public boolean isAvailable()
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public int getLayer() {
/* 28 */     return this.layer;
/*    */   }
/*    */   
/*    */   public int getSec() {
/* 32 */     return this.timeSec;
/*    */   }
/*    */   
/*    */   public boolean isTopThan(JiuXiaoRankObj rankObj)
/*    */   {
/* 37 */     if (getLayer() > rankObj.getLayer())
/* 38 */       return true;
/* 39 */     if (getLayer() < rankObj.getLayer()) {
/* 40 */       return false;
/*    */     }
/* 42 */     if (getSec() < rankObj.getSec())
/* 43 */       return true;
/* 44 */     if (getSec() > rankObj.getSec()) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoRankObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */