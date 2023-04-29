/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class QMHWChartObj extends RoleKeyChartObj<QMHWChartObj>
/*    */ {
/*    */   public final long roleid;
/*    */   public final int score;
/*    */   
/*    */   public QMHWChartObj(long roleid, int score) {
/* 11 */     this.roleid = roleid;
/* 12 */     this.score = score;
/*    */   }
/*    */   
/*    */   public boolean isAvailable()
/*    */   {
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isTopThan(QMHWChartObj rankObj)
/*    */   {
/* 22 */     return this.score > rankObj.score;
/*    */   }
/*    */   
/*    */   public Long getKey()
/*    */   {
/* 27 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */