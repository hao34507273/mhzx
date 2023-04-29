/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gang.SSyncSystemKickOut;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class POnPlayerDelete extends mzm.gsp.online.event.PlayerRealDeleteProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     GangMember xGangMember = xtable.Role2gangmember.get((Long)this.arg);
/* 12 */     if (xGangMember == null) {
/* 13 */       return false;
/*    */     }
/* 15 */     long gangId = xGangMember.getGangid();
/*    */     
/* 17 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 18 */     if (xGang == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangId, true);
/*    */     
/* 23 */     if (!GangManager.isInGang(xGang, ((Long)this.arg).longValue())) {
/* 24 */       return false;
/*    */     }
/* 26 */     GangManager.removeMember(gangId, xGang, xGangMemory, ((Long)this.arg).longValue(), xGangMember, true);
/* 27 */     SSyncSystemKickOut sSyncSystemKickOut = new SSyncSystemKickOut();
/* 28 */     sSyncSystemKickOut.rolelist.add(this.arg);
/* 29 */     GangManager.broadcast(xGang, sSyncSystemKickOut);
/*    */     
/* 31 */     GangManager.triggerLeaveGangEvent(((Long)this.arg).longValue(), gangId, mzm.gsp.gang.event.LeaveGangArg.LeaveType.RemoveRole);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnPlayerDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */