/*    */ package mzm.gsp.bigboss.event;
/*    */ 
/*    */ public class RoleGetBigBossRemoteChartAwardArg
/*    */ {
/*    */   private final int startTimestamp;
/*    */   private final int occupation;
/*    */   private final long roleid;
/*    */   private final int rank;
/*    */   
/*    */   public RoleGetBigBossRemoteChartAwardArg(int startTimestamp, int occupation, long roleid, int rank)
/*    */   {
/* 12 */     this.startTimestamp = startTimestamp;
/* 13 */     this.occupation = occupation;
/* 14 */     this.roleid = roleid;
/* 15 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   public int getStartTimestamp()
/*    */   {
/* 20 */     return this.startTimestamp;
/*    */   }
/*    */   
/*    */   public int getOccupation()
/*    */   {
/* 25 */     return this.occupation;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 30 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getRank()
/*    */   {
/* 35 */     return this.rank;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\event\RoleGetBigBossRemoteChartAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */