/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ 
/*    */ public class PDumpInfoOnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!GameServerInfoManager.isRoamServer())
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     long roleid = ((Long)this.arg).longValue();
/* 19 */     String userid = RoleInterface.getUserId(roleid);
/* 20 */     if (userid == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 27 */     RoleOutFightObj roleOutFightObj = RoleInterface.getRoleOutFightObject(roleid);
/* 28 */     GameServer.logger().info(String.format("[crossserver]PDumpInfoOnRoleLogin.processImp@dump role out fight obj info|userid=%s|%s", new Object[] { userid, roleOutFightObj.getSimpleInfo() }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PDumpInfoOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */