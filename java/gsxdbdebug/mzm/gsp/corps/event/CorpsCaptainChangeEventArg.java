/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ public class CorpsCaptainChangeEventArg
/*    */ {
/*    */   private final long corpsId;
/*    */   private final long oldLeaderId;
/*    */   private final long newLeaderId;
/*    */   private final ChangeLeaderReason reason;
/*    */   
/*    */   public CorpsCaptainChangeEventArg(long corpsId, long oldLeader, long newLeader, ChangeLeaderReason reason)
/*    */   {
/* 12 */     this.corpsId = corpsId;
/* 13 */     this.oldLeaderId = oldLeader;
/* 14 */     this.newLeaderId = newLeader;
/* 15 */     this.reason = reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsId()
/*    */   {
/* 25 */     return this.corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getOldLeaderId()
/*    */   {
/* 35 */     return this.oldLeaderId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getNewLeaderId()
/*    */   {
/* 45 */     return this.newLeaderId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ChangeLeaderReason getReason()
/*    */   {
/* 55 */     return this.reason;
/*    */   }
/*    */   
/*    */   public static enum ChangeLeaderReason
/*    */   {
/* 60 */     ACTIVE_CHANGE;
/*    */     
/*    */     private ChangeLeaderReason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\CorpsCaptainChangeEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */