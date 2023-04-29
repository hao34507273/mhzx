/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class PGM_JiuXiaoChart extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int capacity;
/*    */   
/*    */   public PGM_JiuXiaoChart(long roleid, int capacity)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.capacity = capacity;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (this.capacity < 0) {
/* 19 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("九霄排行榜容量不能小于0", new Object[] { Integer.valueOf(this.capacity) }));
/* 20 */       return false;
/*    */     }
/* 22 */     JiuXiaoRankManager.getInstance().PGM_SetChartNum(this.capacity);
/* 23 */     GmManager.getInstance().sendResultToGM(this.roleid, String.format("九霄排行榜重新设置的容量为%d", new Object[] { Integer.valueOf(this.capacity) }));
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PGM_JiuXiaoChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */