/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*    */ 
/*    */ 
/*    */ public class SelectionOrFinalMatchFailedArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long leaderid;
/*    */   private final KnockOutTeamInfo ownCrossBattleTeamInfo;
/*    */   private final long createTime;
/*    */   
/*    */   public SelectionOrFinalMatchFailedArg(long contextid, long leaderid, KnockOutTeamInfo ownCrossBattleTeamInfo, long createTime)
/*    */   {
/* 15 */     this.contextid = contextid;
/* 16 */     this.leaderid = leaderid;
/* 17 */     this.ownCrossBattleTeamInfo = ownCrossBattleTeamInfo;
/* 18 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 28 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 38 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getMatchStartTime()
/*    */   {
/* 48 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public KnockOutTeamInfo getOwnCrossBattleTeamInfo()
/*    */   {
/* 53 */     return this.ownCrossBattleTeamInfo;
/*    */   }
/*    */   
/*    */   public long getCreateTime()
/*    */   {
/* 58 */     return this.createTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SelectionOrFinalMatchFailedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */