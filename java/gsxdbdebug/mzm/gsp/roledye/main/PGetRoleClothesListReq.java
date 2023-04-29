/*    */ package mzm.gsp.roledye.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.roledye.SRoleClothesListRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleClothes;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGetRoleClothesListReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGetRoleClothesListReq(long roleid)
/*    */   {
/* 16 */     this.roleId = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userId = RoleInterface.getUserId(this.roleId);
/* 23 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/* 25 */     RoleClothes xRoleClothes = RoleDyeManager.getXRoleClothesIfNotExist(this.roleId);
/*    */     
/* 27 */     SRoleClothesListRes sRoleClothesListRes = new SRoleClothesListRes();
/*    */     
/* 29 */     RoleDyeManager.fillProtocolRoleCLotherListRes(this.roleId, sRoleClothesListRes, xRoleClothes);
/*    */     
/* 31 */     OnlineManager.getInstance().send(this.roleId, sRoleClothesListRes);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\PGetRoleClothesListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */