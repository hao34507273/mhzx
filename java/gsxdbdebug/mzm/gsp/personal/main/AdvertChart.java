/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.util.RankObj;
/*    */ 
/*    */ public class AdvertChart extends RankObj<Long>
/*    */ {
/*    */   private final long roleId;
/*    */   private final long advertId;
/*    */   private final int integrity;
/*    */   private final long releaseTimestamp;
/*    */   
/*    */   public AdvertChart(long roleId, long advertId, int integrity, long releaseTimestamp)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.advertId = advertId;
/* 16 */     this.integrity = integrity;
/* 17 */     this.releaseTimestamp = releaseTimestamp;
/*    */   }
/*    */   
/*    */   public int getIntegrity()
/*    */   {
/* 22 */     return this.integrity;
/*    */   }
/*    */   
/*    */   public long getAdvertId()
/*    */   {
/* 27 */     return this.advertId;
/*    */   }
/*    */   
/*    */   public long getReleaseTimestamp()
/*    */   {
/* 32 */     return this.releaseTimestamp;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 37 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(RankObj<Long> o)
/*    */   {
/* 43 */     AdvertChart tmp = (AdvertChart)o;
/* 44 */     if (tmp.getIntegrity() == this.integrity)
/*    */     {
/* 46 */       return (int)(tmp.advertId - this.advertId);
/*    */     }
/*    */     
/*    */ 
/* 50 */     return tmp.integrity - this.integrity;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 57 */     return Long.valueOf(this.advertId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\AdvertChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */