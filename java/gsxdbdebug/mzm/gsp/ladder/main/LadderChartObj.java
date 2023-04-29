/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ public class LadderChartObj extends RoleKeyChartObj<LadderChartObj>
/*    */ {
/*    */   public final long roleid;
/*    */   public final int score;
/*    */   public final int stage;
/*    */   
/*    */   public LadderChartObj(long roleid, int score, int stage) {
/* 12 */     this.roleid = roleid;
/* 13 */     this.score = score;
/* 14 */     this.stage = stage;
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
/*    */   public boolean isTopThan(LadderChartObj rankObj)
/*    */   {
/* 29 */     if (this.stage > rankObj.stage)
/* 30 */       return true;
/* 31 */     if (this.stage == rankObj.stage) {
/* 32 */       return this.score > rankObj.score;
/*    */     }
/* 34 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 40 */     StringBuilder _sb_ = new StringBuilder();
/* 41 */     _sb_.append("(");
/* 42 */     _sb_.append(this.roleid);
/* 43 */     _sb_.append(",");
/* 44 */     _sb_.append(this.score);
/* 45 */     _sb_.append(",");
/* 46 */     _sb_.append(this.stage);
/* 47 */     _sb_.append(")");
/* 48 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */