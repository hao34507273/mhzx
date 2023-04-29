/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleDeleteLogManager
/*    */ {
/*    */   public static void tlogRoleDel(long roleId, int delStatus)
/*    */   {
/* 19 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 20 */     String userid = RoleInterface.getUserId(roleId);
/*    */     
/*    */ 
/* 23 */     Role role = RoleInterface.getRole(roleId, false);
/*    */     
/* 25 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(role.getGender()), Integer.valueOf(role.getOccupationId()), role.getName(), Integer.valueOf(role.getLevel()), Integer.valueOf(delStatus) };
/*    */     
/*    */ 
/* 28 */     TLogManager.getInstance().addLog(roleId, "RoleDelete", colums);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\RoleDeleteLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */