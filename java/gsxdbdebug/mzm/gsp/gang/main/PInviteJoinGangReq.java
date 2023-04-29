/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.CInviteJoinGangReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SInviteJoinGang;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PInviteJoinGangReq
/*    */   extends GangProcedure<CInviteJoinGangReq>
/*    */ {
/*    */   public PInviteJoinGangReq(CInviteJoinGangReq protocol)
/*    */   {
/* 21 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean doProcess(long roleId, CInviteJoinGangReq protocol)
/*    */   {
/* 26 */     long targetId = protocol.targetid;
/*    */     
/* 28 */     lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(targetId) }));
/*    */     
/*    */ 
/* 31 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 102, true)) {
/* 32 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleId);
/* 33 */       GangManager.logError("PInviteJoinGangReq.processImp@role status cannot invite|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleId), statusSet });
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     GangMember inventor = Role2gangmember.get(Long.valueOf(roleId));
/* 40 */     GangMember target = Role2gangmember.get(Long.valueOf(targetId));
/* 41 */     if (inventor == null) {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(inventor.getGangid()));
/* 46 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     xbean.Gang xTargetGang = null;
/* 51 */     if (target != null)
/*    */     {
/* 53 */       xTargetGang = xtable.Gang.select(Long.valueOf(target.getGangid()));
/*    */     }
/*    */     
/* 56 */     if ((xTargetGang != null) && (GangManager.isInGang(xTargetGang, targetId))) {
/* 57 */       if (inventor.getGangid() == target.getGangid()) {
/* 58 */         SGangNormalResult result = new SGangNormalResult();
/* 59 */         result.result = 12;
/* 60 */         OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */       } else {
/* 62 */         SGangNormalResult result = new SGangNormalResult();
/* 63 */         result.result = 8;
/* 64 */         OnlineManager.getInstance().send(roleId, result);
/*    */       }
/* 66 */       return false;
/*    */     }
/* 68 */     SInviteJoinGang res = new SInviteJoinGang();
/* 69 */     res.inviterid = roleId;
/* 70 */     res.gangid = inventor.getGangid();
/* 71 */     res.gangname = xGang.getName();
/* 72 */     res.invitername = RoleInterface.getName(roleId);
/* 73 */     OnlineManager.getInstance().send(targetId, res);
/* 74 */     SGangNormalResult result = new SGangNormalResult();
/* 75 */     result.result = 11;
/* 76 */     OnlineManager.getInstance().send(roleId, result);
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PInviteJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */