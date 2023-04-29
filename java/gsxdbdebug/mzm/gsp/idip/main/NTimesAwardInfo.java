/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NTimesAwardInfo
/*    */ {
/*    */   private int NTimes;
/*    */   private long startTime;
/*    */   private long expireTime;
/*    */   private Set<Integer> validedZoneIdSet;
/*    */   
/*    */   public NTimesAwardInfo(int NTimes, long startTime, long expireTime)
/*    */   {
/* 27 */     this.NTimes = NTimes;
/* 28 */     this.startTime = startTime;
/* 29 */     this.expireTime = expireTime;
/* 30 */     this.validedZoneIdSet = new HashSet();
/*    */   }
/*    */   
/*    */   public NTimesAwardInfo(int NTimes, long startTime, long expireTime, Set<Integer> validedZoneIdSet)
/*    */   {
/* 35 */     this.NTimes = NTimes;
/* 36 */     this.startTime = startTime;
/* 37 */     this.expireTime = expireTime;
/* 38 */     this.validedZoneIdSet = validedZoneIdSet;
/*    */   }
/*    */   
/*    */   public int getNTimes()
/*    */   {
/* 43 */     return this.NTimes;
/*    */   }
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 48 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public long getExpireTime()
/*    */   {
/* 53 */     return this.expireTime;
/*    */   }
/*    */   
/*    */   public void setExpireTime(long expireTime)
/*    */   {
/* 58 */     this.expireTime = expireTime;
/*    */   }
/*    */   
/*    */   public Set<Integer> getValidedZoneIdSet()
/*    */   {
/* 63 */     return this.validedZoneIdSet;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NTimesAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */