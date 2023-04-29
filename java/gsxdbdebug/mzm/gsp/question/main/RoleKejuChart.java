/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*    */ import xbean.KeJuInfo;
/*    */ import xtable.Role2keju;
/*    */ 
/*    */ class RoleKejuChart
/*    */   extends RoleKeyChartObj<RoleKejuChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int usetime;
/*    */   
/*    */   RoleKejuChart(long roleid, int usetime)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.usetime = usetime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 26 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getUsetime()
/*    */   {
/* 31 */     return this.usetime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 38 */     if (IdipManager.isBanRank(getKey().longValue(), 4))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     KeJuInfo keJuInfo = Role2keju.select(Long.valueOf(this.roleid));
/* 43 */     if (keJuInfo == null)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if ((keJuInfo.getState() != 3) && (keJuInfo.getState() != 2))
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     int usetime = (int)(TimeUnit.MILLISECONDS.toSeconds(keJuInfo.getFinishtime() - keJuInfo.getStarttime()) + keJuInfo.getPunishtime());
/* 53 */     if (usetime <= 0)
/*    */     {
/* 55 */       return false;
/*    */     }
/* 57 */     return keJuInfo.getStarttime() > ActivityInterface.getActivityStartTime(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isTopThan(RoleKejuChart rankObj)
/*    */   {
/* 65 */     return getUsetime() < rankObj.getUsetime();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\RoleKejuChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */