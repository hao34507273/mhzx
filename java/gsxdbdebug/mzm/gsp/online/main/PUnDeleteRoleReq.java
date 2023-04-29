/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.CUnDeleteRoleReq;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.SUnDeleteRoleRes;
/*    */ import mzm.gsp.online.event.PlayerRecovery;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DeleteState;
/*    */ import xtable.Role2delete;
/*    */ 
/*    */ public class PUnDeleteRoleReq extends LogicProcedure
/*    */ {
/*    */   private CUnDeleteRoleReq protocol;
/*    */   
/*    */   public PUnDeleteRoleReq(CUnDeleteRoleReq protocol)
/*    */   {
/* 21 */     this.protocol = protocol;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     long roleId = this.protocol.roleid;
/* 27 */     DeleteState xDeleteState = Role2delete.get(Long.valueOf(roleId));
/* 28 */     if (xDeleteState == null) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (xDeleteState.getDeletestate() == 2) {
/* 33 */       return false;
/*    */     }
/* 35 */     Role2delete.delete(Long.valueOf(roleId));
/* 36 */     TriggerEventsManger.getInstance().triggerEvent(new PlayerRecovery(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */     
/* 38 */     SUnDeleteRoleRes res = new SUnDeleteRoleRes();
/* 39 */     res.roleid = roleId;
/* 40 */     Onlines.getInstance().sendResponse(this.protocol, res);
/* 41 */     GameServer.logger().info(String.format("[Role]PUnDeleteRoleReq.processImp@PUnDeleteRoleReq|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/* 42 */     RoleDeleteLogManager.tlogRoleDel(roleId, 4);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PUnDeleteRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */