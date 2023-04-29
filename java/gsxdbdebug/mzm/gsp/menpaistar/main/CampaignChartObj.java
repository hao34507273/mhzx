/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*     */ 
/*     */ public class CampaignChartObj
/*     */   extends RoleKeyChartObj<CampaignChartObj>
/*     */ {
/*     */   private final long roleid;
/*     */   private final int ocpid;
/*     */   private final int point;
/*     */   private final long updatePointTime;
/*     */   private final String name;
/*     */   private final int award;
/*     */   private final int num;
/*     */   
/*     */   public CampaignChartObj(long roleid, int ocpid, int point, long updatePointTime, String name, int award, int num)
/*     */   {
/*  18 */     this.roleid = roleid;
/*  19 */     this.ocpid = ocpid;
/*  20 */     this.point = point;
/*  21 */     this.updatePointTime = updatePointTime;
/*  22 */     this.name = name;
/*  23 */     this.award = award;
/*  24 */     this.num = num;
/*     */   }
/*     */   
/*     */   public int getAward()
/*     */   {
/*  29 */     return this.award;
/*     */   }
/*     */   
/*     */   public int getNum()
/*     */   {
/*  34 */     return this.num;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  39 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public int getOcpid()
/*     */   {
/*  44 */     return this.ocpid;
/*     */   }
/*     */   
/*     */   public int getPoint()
/*     */   {
/*  49 */     return this.point;
/*     */   }
/*     */   
/*     */   public long getUpdatePointTime()
/*     */   {
/*  54 */     return this.updatePointTime;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  59 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isAvailable()
/*     */   {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isTopThan(CampaignChartObj rankObj)
/*     */   {
/*  71 */     if (rankObj == null)
/*     */     {
/*  73 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (this.point > rankObj.point)
/*     */     {
/*  79 */       return true;
/*     */     }
/*  81 */     if (this.point < rankObj.point)
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     if (this.updatePointTime < rankObj.updatePointTime)
/*     */     {
/*  89 */       return true;
/*     */     }
/*  91 */     if (this.updatePointTime > rankObj.updatePointTime)
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     return this.roleid < rankObj.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public Long getKey()
/*     */   {
/* 102 */     return Long.valueOf(this.roleid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\CampaignChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */