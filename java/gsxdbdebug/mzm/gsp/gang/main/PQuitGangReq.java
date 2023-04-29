/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gang.CQuitGangReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncQuitGang;
/*    */ import mzm.gsp.gang.event.LeaveGangArg.LeaveType;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GangGlobal;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PQuitGangReq extends GangProcedure<CQuitGangReq>
/*    */ {
/*    */   public PQuitGangReq(CQuitGangReq protocol)
/*    */   {
/* 22 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean doProcess(long roleId, CQuitGangReq protocol)
/*    */   {
/* 27 */     GameServer.logger().info("PQuitGangReq.doProcess@Received CQuitGangReq！ roleId:" + roleId);
/*    */     
/* 29 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 21, true)) {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 35 */     if (xGangMember == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     String userId = RoleInterface.getUserId(roleId);
/* 41 */     int roleLevel = RoleInterface.getLevel(roleId);
/*    */     
/* 43 */     long gangId = xGangMember.getGangid();
/* 44 */     int duty = xGangMember.getDuty();
/*    */     
/*    */ 
/* 47 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 48 */     if (xGang == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     if (!GangManager.isInGang(xGang, roleId, duty)) {
/* 52 */       return false;
/*    */     }
/* 54 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangId, true);
/*    */     
/* 56 */     GameServer.logger().info("PQuitGangReq.doProcess@CQuitGangReq get all lock！ roleId:" + roleId);
/*    */     
/* 58 */     if ((xGang.getBangzhuid() == roleId) && (GangManager.getMemberSize(xGang) > 1)) {
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     SSyncQuitGang sSyncQuitGang = new SSyncQuitGang();
/* 63 */     sSyncQuitGang.roleid = roleId;
/* 64 */     GangManager.broadcast(xGang, sSyncQuitGang);
/*    */     
/* 66 */     SGangNormalResult result = new SGangNormalResult();
/* 67 */     result.result = 10;
/* 68 */     OnlineManager.getInstance().send(roleId, result);
/*    */     
/*    */ 
/* 71 */     if ((xGang.getBangzhuid() == roleId) && (GangManager.getMemberSize(xGang) == 1))
/*    */     {
/*    */ 
/* 74 */       GangGlobal xGlobal = GangManager.getXGlobal(true);
/*    */       
/* 76 */       GangManager.dissolveGangAndTlog(gangId, xGang, xGangMemory, xGlobal, userId, roleLevel);
/*    */     }
/*    */     else {
/* 79 */       GangManager.removeMember(gangId, xGang, xGangMemory, roleId, xGangMember, true);
/*    */     }
/*    */     
/* 82 */     GangManager.triggerLeaveGangEvent(roleId, gangId, LeaveGangArg.LeaveType.ActiveLeave);
/*    */     
/*    */ 
/*    */ 
/* 86 */     StringBuilder tLogStr = new StringBuilder();
/* 87 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userId).append("|").append(roleId).append("|").append(roleLevel).append("|").append(gangId).append("|").append(xGang.getDisplayid()).append("|").append(GangActionLogEnum.SIGN_OUT);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 94 */     TLogManager.getInstance().addLog(roleId, "Gang", tLogStr.toString());
/*    */     
/* 96 */     GameServer.logger().info("PQuitGangReq.doProcess@CQuitGangReq success！ roleId:" + roleId);
/*    */     
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PQuitGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */