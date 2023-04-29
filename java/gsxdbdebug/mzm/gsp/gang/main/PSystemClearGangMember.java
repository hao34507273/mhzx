/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gang.SGetSignState;
/*    */ import mzm.gsp.gang.SSyncSystemKickOut;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gang.event.LeaveGangArg.LeaveType;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PSystemClearGangMember extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long gangId;
/*    */   
/*    */   PSystemClearGangMember(long roleId, long gangId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 30 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangId));
/* 31 */     if (xGang == null) {
/* 32 */       return true;
/*    */     }
/* 34 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(this.gangId, true);
/*    */     
/* 36 */     long bangzuid = xGang.getBangzhuid();
/*    */     
/* 38 */     xGangMember.setIssign(0);
/* 39 */     xGangMember.setSigntime(0L);
/*    */     
/* 41 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/*    */ 
/* 44 */     if (OnlineManager.getInstance().isOnline(this.roleId)) {
/* 45 */       SGetSignState result = new SGetSignState();
/* 46 */       result.state = 0;
/* 47 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 48 */       return true;
/*    */     }
/*    */     
/* 51 */     if (this.roleId == bangzuid) {
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     int dutyId = xGangMember.getDuty();
/* 56 */     if ((dutyId != SGangConst.getInstance().BANGZHONG_ID) && (dutyId != SGangConst.getInstance().XUETU_ID)) {
/* 57 */       return true;
/*    */     }
/* 59 */     long logoffTime = RoleInterface.getLastLogoffTime(this.roleId);
/* 60 */     int difDay = GangManager.getDiffDay(logoffTime, now);
/*    */     
/* 62 */     if (dutyId == SGangConst.getInstance().BANGZHONG_ID) {
/* 63 */       if (difDay < SGangConst.getInstance().KICK_NORMAL_OFFLINE_DAYS) {
/* 64 */         return true;
/*    */       }
/* 66 */       if (xGangMember.getHistorybanggong() > SGangConst.getInstance().KICK_NORMAL_BANGGONG_MIN) {
/* 67 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 71 */     if (dutyId == SGangConst.getInstance().XUETU_ID) {
/* 72 */       if (difDay < SGangConst.getInstance().KICK_XUETU_OFFLINE_DAYS) {
/* 73 */         return true;
/*    */       }
/* 75 */       if (xGangMember.getHistorybanggong() > SGangConst.getInstance().KICK_XUETU_BANGGONG_MIN) {
/* 76 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 80 */     ForbidTalkObserver.stopObserver(this.roleId);
/*    */     
/* 82 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 83 */       return true;
/*    */     }
/*    */     
/* 86 */     SSyncSystemKickOut sSyncSystemKickOut = new SSyncSystemKickOut();
/* 87 */     sSyncSystemKickOut.rolelist.add(Long.valueOf(this.roleId));
/* 88 */     GangManager.broadcast(xGang, sSyncSystemKickOut);
/* 89 */     GangManager.removeMember(this.gangId, xGang, xGangMemory, this.roleId, xGangMember, true);
/*    */     
/* 91 */     GangManager.passiveLeaveGangHandle(xGangMember, this.roleId);
/*    */     
/* 93 */     GangManager.triggerLeaveGangEvent(this.roleId, this.gangId, LeaveGangArg.LeaveType.KickedOutBySystem);
/*    */     
/* 95 */     GangManager.logInfo("PSystemClearGangMember.processImp@gang dayupdate systemclear xuetu|xuetuid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.gangId) });
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSystemClearGangMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */