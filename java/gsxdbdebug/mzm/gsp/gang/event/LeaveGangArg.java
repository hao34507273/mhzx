/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeaveGangArg
/*    */ {
/*    */   public final long gangId;
/*    */   
/*    */   public static enum LeaveType
/*    */   {
/* 17 */     ActiveLeave, 
/* 18 */     KickedOutByLeader, 
/* 19 */     RemoveRole, 
/* 20 */     KickedOutBySystem, 
/* 21 */     KickedOutByGm, 
/* 22 */     KickedOutByCombine, 
/* 23 */     KickedOutByLvlDown;
/*    */     
/*    */     private LeaveType() {} }
/*    */   
/* 27 */   public final List<Long> extraMemberList = new ArrayList();
/*    */   public final LeaveType leaveType;
/*    */   
/*    */   public LeaveGangArg(long gangid, long roleid, LeaveType leaveType) {
/* 31 */     this.gangId = gangid;
/* 32 */     this.extraMemberList.add(Long.valueOf(roleid));
/* 33 */     this.leaveType = leaveType;
/*    */   }
/*    */   
/*    */   public LeaveGangArg(long gangid, Collection<Long> roles, LeaveType leaveType) {
/* 37 */     this.gangId = gangid;
/* 38 */     this.extraMemberList.addAll(roles);
/* 39 */     this.leaveType = leaveType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isPassiveKickedOut()
/*    */   {
/* 48 */     if ((this.leaveType.equals(LeaveType.KickedOutByLeader)) || (this.leaveType.equals(LeaveType.KickedOutBySystem)) || (this.leaveType.equals(LeaveType.KickedOutByGm)) || (this.leaveType.equals(LeaveType.KickedOutByLvlDown)) || (this.leaveType.equals(LeaveType.KickedOutByCombine)))
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/* 53 */       return true;
/*    */     }
/*    */     
/* 56 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean activeLeave()
/*    */   {
/* 65 */     return this.leaveType.equals(LeaveType.ActiveLeave);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\LeaveGangArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */