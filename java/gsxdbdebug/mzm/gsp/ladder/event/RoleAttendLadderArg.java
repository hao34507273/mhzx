/*    */ package mzm.gsp.ladder.event;
/*    */ 
/*    */ public class RoleAttendLadderArg
/*    */ {
/*    */   private final long roleid;
/*    */   private final boolean isWin;
/*    */   
/*    */   public RoleAttendLadderArg(long roleid, boolean isWin)
/*    */   {
/* 10 */     this.roleid = roleid;
/* 11 */     this.isWin = isWin;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 21 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isWin()
/*    */   {
/* 31 */     return this.isWin;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\event\RoleAttendLadderArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */