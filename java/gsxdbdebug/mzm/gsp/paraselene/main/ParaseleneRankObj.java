/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import xbean.Paraselene;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ public class ParaseleneRankObj extends RoleKeyChartObj<ParaseleneRankObj>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int seconds;
/*    */   
/*    */   public ParaseleneRankObj(long roleid, int seconds)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.seconds = seconds;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 22 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 28 */     if (IdipManager.isBanRank(getKey().longValue(), 10))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (this.seconds <= 0)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     Paraselene paraselene = Role2paraselene.select(Long.valueOf(this.roleid));
/* 37 */     if (paraselene == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     return paraselene.getStarttime() >= ParaseleneManager.getActivityStartTime();
/*    */   }
/*    */   
/*    */   public int getSeconds()
/*    */   {
/* 47 */     return this.seconds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isTopThan(ParaseleneRankObj rankObj)
/*    */   {
/* 54 */     return getSeconds() < rankObj.getSeconds();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneRankObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */