/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import xbean.BigBoss;
/*    */ 
/*    */ public class RoleBigBossChart extends mzm.gsp.chart.main.RoleKeyChartObj<RoleBigBossChart>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int damagePoint;
/*    */   
/*    */   public RoleBigBossChart(long roleid, int damagePoint)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.damagePoint = damagePoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 19 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getDamagePoint()
/*    */   {
/* 24 */     return this.damagePoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 30 */     if (this.damagePoint <= 0)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     boolean isbanRank = BigbossManager.isBanRank(this.roleid);
/* 35 */     if (isbanRank)
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     long starttime = BigbossManager.getActivityStarttime();
/* 40 */     if (starttime <= 0L)
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     BigBoss bigBoss = xtable.Role2bigboss.select(getKey());
/* 45 */     if (bigBoss == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     return bigBoss.getStarttime() == starttime;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(RoleBigBossChart rankObj)
/*    */   {
/* 55 */     if (getDamagePoint() != rankObj.getDamagePoint())
/*    */     {
/* 57 */       return getDamagePoint() > rankObj.getDamagePoint();
/*    */     }
/* 59 */     return getRoleid() < rankObj.getRoleid();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\RoleBigBossChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */