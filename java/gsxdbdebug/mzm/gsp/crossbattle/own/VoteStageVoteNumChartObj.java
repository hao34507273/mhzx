/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.chart.main.NoneRoleKeyChartObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VoteStageVoteNumChartObj
/*    */   extends NoneRoleKeyChartObj<Long, VoteStageVoteNumChartObj>
/*    */ {
/*    */   private static final float ERROR = 1.0E-8F;
/*    */   private final long corpsid;
/*    */   private final float averageFightValue;
/*    */   private final int voteNum;
/*    */   private final long voteTimestamp;
/*    */   
/*    */   public VoteStageVoteNumChartObj(long corpsid, float averageFightValue, int voteNum, long voteTimestamp)
/*    */   {
/* 21 */     this.corpsid = corpsid;
/* 22 */     this.averageFightValue = averageFightValue;
/* 23 */     this.voteNum = voteNum;
/* 24 */     this.voteTimestamp = voteTimestamp;
/*    */   }
/*    */   
/*    */   public float getAverageFightValue()
/*    */   {
/* 29 */     return this.averageFightValue;
/*    */   }
/*    */   
/*    */   public int getVoteNum()
/*    */   {
/* 34 */     return this.voteNum;
/*    */   }
/*    */   
/*    */   public long getVoteTimestamp()
/*    */   {
/* 39 */     return this.voteTimestamp;
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 45 */     return 0L;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(VoteStageVoteNumChartObj rankObj)
/*    */   {
/* 57 */     if (getVoteNum() != rankObj.getVoteNum())
/*    */     {
/* 59 */       return getVoteNum() > rankObj.getVoteNum();
/*    */     }
/* 61 */     if (Math.abs(getAverageFightValue() - rankObj.getAverageFightValue()) > 1.0E-8F)
/*    */     {
/* 63 */       return getAverageFightValue() - rankObj.getAverageFightValue() > 1.0E-8F;
/*    */     }
/* 65 */     if (getVoteTimestamp() != rankObj.getVoteTimestamp())
/*    */     {
/* 67 */       return getVoteTimestamp() < getVoteTimestamp();
/*    */     }
/* 69 */     return getKey().longValue() < rankObj.getKey().longValue();
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 75 */     return Long.valueOf(this.corpsid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\VoteStageVoteNumChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */