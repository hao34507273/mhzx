/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ import mzm.gsp.corps.main.PJoinCorps.JoinCorpsReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinCorpsEventArg
/*    */ {
/*    */   private final long newGuy;
/*    */   private final long corpsId;
/*    */   private final PJoinCorps.JoinCorpsReason joinReason;
/*    */   
/*    */   public JoinCorpsEventArg(long newGuy, long corpsId, PJoinCorps.JoinCorpsReason joinReason)
/*    */   {
/* 19 */     this.newGuy = newGuy;
/* 20 */     this.corpsId = corpsId;
/* 21 */     this.joinReason = joinReason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getNewGuy()
/*    */   {
/* 31 */     return this.newGuy;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsId()
/*    */   {
/* 41 */     return this.corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public PJoinCorps.JoinCorpsReason getJoinReason()
/*    */   {
/* 51 */     return this.joinReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\JoinCorpsEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */