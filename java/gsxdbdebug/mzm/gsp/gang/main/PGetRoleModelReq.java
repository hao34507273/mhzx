/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CGetRoleModelReq;
/*    */ import mzm.gsp.gang.SGetRoleModelRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGetRoleModelReq
/*    */   extends GangProcedure<CGetRoleModelReq>
/*    */ {
/*    */   public PGetRoleModelReq(CGetRoleModelReq protocol)
/*    */   {
/* 15 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CGetRoleModelReq protocol)
/*    */   {
/* 21 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 22 */     if (xGangMember == null) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/* 27 */     if (xGang == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!GangManager.isInGang(xGang, protocol.roleid)) {
/* 34 */       return false;
/*    */     }
/* 36 */     SGetRoleModelRes res = new SGetRoleModelRes();
/* 37 */     RoleInterface.fillModelInfo(protocol.roleid, res.modelinfo);
/* 38 */     OnlineManager.getInstance().send(roleId, res);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGetRoleModelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */