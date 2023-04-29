/*    */ package mzm.gsp.indiana.event;
/*    */ 
/*    */ 
/*    */ public class RoleAttendIndianaArg
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   private final int activityCfgid;
/*    */   
/*    */   private final int turn;
/*    */   
/*    */   private final int sortid;
/*    */   
/*    */   private final int moneyType;
/*    */   private final int moneyNum;
/*    */   
/*    */   public RoleAttendIndianaArg(long roleid, int activityCfgid, int turn, int sortid, int moneyType, int moneyNum)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.activityCfgid = activityCfgid;
/* 21 */     this.turn = turn;
/* 22 */     this.sortid = sortid;
/* 23 */     this.moneyType = moneyType;
/* 24 */     this.moneyNum = moneyNum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final long getRoleid()
/*    */   {
/* 34 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 44 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getTurn()
/*    */   {
/* 54 */     return this.turn;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getSortid()
/*    */   {
/* 64 */     return this.sortid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getMoneyType()
/*    */   {
/* 75 */     return this.moneyType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getMoneyNum()
/*    */   {
/* 85 */     return this.moneyNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\event\RoleAttendIndianaArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */