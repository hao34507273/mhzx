/*    */ package mzm.gsp.crosscompete.event;
/*    */ 
/*    */ 
/*    */ public class CrossCompeteParticipateArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */   public final long factionid;
/*    */   
/*    */   public final int winTimes;
/*    */   
/*    */   public final int loseTimes;
/*    */   
/*    */   public final int escapeTimes;
/*    */   public final boolean isWinner;
/*    */   
/*    */   public CrossCompeteParticipateArg(long roleid, long factionid, int winTimes, int loseTimes, int escapeTimes, boolean isWinner)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.factionid = factionid;
/* 21 */     this.winTimes = winTimes;
/* 22 */     this.loseTimes = loseTimes;
/* 23 */     this.escapeTimes = escapeTimes;
/* 24 */     this.isWinner = isWinner;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\event\CrossCompeteParticipateArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */