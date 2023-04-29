/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import gnet.link.Dispatch;
/*    */ import gnet.link.Onlines;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.CDeleteRoleReq;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.SDeleteRoleRes;
/*    */ import mzm.gsp.SNormalResult;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*    */ import mzm.gsp.online.event.PlayerDelete;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DeleteState;
/*    */ import xtable.Role2delete;
/*    */ 
/*    */ public class PDeleteRoleReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private CDeleteRoleReq protocol;
/*    */   
/*    */   public PDeleteRoleReq(CDeleteRoleReq protocol)
/*    */   {
/* 26 */     this.protocol = protocol;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     Dispatch ctx = (Dispatch)this.protocol.getContext();
/* 32 */     String userId = ctx.userid.getString("UTF-8");
/* 33 */     xbean.User xUser = xtable.User.get(userId);
/* 34 */     if (xUser == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     long roleId = this.protocol.roleid;
/* 38 */     if (!xUser.getRoleids().contains(Long.valueOf(roleId))) {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     if (mzm.gsp.role.main.RoleInterface.getLevel(roleId) >= RoleCommonConstants.getInstance().CAN_NOT_DELETE_ROLE_MORE_THAN_LEVEL)
/*    */     {
/* 45 */       SNormalResult result = new SNormalResult();
/* 46 */       result.res = 1;
/* 47 */       Onlines.getInstance().sendResponse(this.protocol, result);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     DeleteState xDeleteState = Role2delete.get(Long.valueOf(roleId));
/* 52 */     if (xDeleteState == null) {
/* 53 */       xDeleteState = xbean.Pod.newDeleteState();
/* 54 */       Role2delete.add(Long.valueOf(roleId), xDeleteState);
/*    */     }
/* 56 */     if (GangInterface.isBangZhu(roleId)) {
/* 57 */       SNormalResult result = new SNormalResult();
/* 58 */       result.res = 0;
/* 59 */       Onlines.getInstance().sendResponse(this.protocol, result);
/* 60 */       return false;
/*    */     }
/* 62 */     long intervals = RoleCommonConstants.getInstance().DELETE_ROLE_RECOVERY_D * 24 * 60 * 60 * 1000;
/* 63 */     xDeleteState.setDeleteendtime(intervals + DateTimeUtils.getCurrTimeInMillis());
/* 64 */     xDeleteState.setDeletestate(0);
/* 65 */     SDeleteRoleRes res = new SDeleteRoleRes();
/* 66 */     res.roleid = roleId;
/* 67 */     res.endtime = ((int)(intervals / 1000L));
/* 68 */     Onlines.getInstance().sendResponse(this.protocol, res);
/* 69 */     TriggerEventsManger.getInstance().triggerEvent(new PlayerDelete(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */     
/*    */ 
/*    */ 
/* 73 */     RoleDeleteLogManager.tlogRoleDel(roleId, 0);
/* 74 */     GameServer.logger().info(String.format("[Role]PDeleteRoleReq.processImp@delete role req|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PDeleteRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */