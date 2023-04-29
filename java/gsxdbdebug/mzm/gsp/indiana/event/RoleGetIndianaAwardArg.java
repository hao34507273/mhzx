/*    */ package mzm.gsp.indiana.event;
/*    */ 
/*    */ 
/*    */ public class RoleGetIndianaAwardArg
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   private final int activityCfgid;
/*    */   
/*    */   private final int turn;
/*    */   
/*    */   private final int sortid;
/*    */   
/*    */   private final int fixAwardid;
/*    */   
/*    */   public RoleGetIndianaAwardArg(long roleid, int activityCfgid, int turn, int sortid, int fixAwardid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.activityCfgid = activityCfgid;
/* 20 */     this.turn = turn;
/* 21 */     this.sortid = sortid;
/* 22 */     this.fixAwardid = fixAwardid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final long getRoleid()
/*    */   {
/* 32 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 42 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getTurn()
/*    */   {
/* 52 */     return this.turn;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getSortid()
/*    */   {
/* 62 */     return this.sortid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getFixAwardid()
/*    */   {
/* 73 */     return this.fixAwardid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\event\RoleGetIndianaAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */