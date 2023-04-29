/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import xbean.IdipForbidInfo;
/*    */ 
/*    */ public class IdipForbidData {
/*    */   private String reason;
/*    */   private long startTime;
/*    */   private long expireTime;
/*    */   
/*    */   public IdipForbidData(IdipForbidInfo xIdipForbidInfo) {
/* 11 */     this.reason = xIdipForbidInfo.getReason();
/* 12 */     this.startTime = xIdipForbidInfo.getStarttime();
/* 13 */     this.expireTime = xIdipForbidInfo.getExpiretime();
/*    */   }
/*    */   
/*    */ 
/*    */   public IdipForbidData() {}
/*    */   
/*    */ 
/*    */   public String getReason()
/*    */   {
/* 22 */     return this.reason;
/*    */   }
/*    */   
/*    */   public void setReason(String reason)
/*    */   {
/* 27 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 32 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public void setStartTime(long startTime)
/*    */   {
/* 37 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public long getExpireTime()
/*    */   {
/* 42 */     return this.expireTime;
/*    */   }
/*    */   
/*    */   public void setExpireTime(long expireTime)
/*    */   {
/* 47 */     this.expireTime = expireTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\IdipForbidData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */