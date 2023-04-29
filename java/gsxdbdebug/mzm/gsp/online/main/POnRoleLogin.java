/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     lock(xtable.Role2properties.getTable(), Collections.singletonList(this.arg));
/* 14 */     if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 41)) {
/* 15 */       CrossTokenCheckObserver.createCrossTokenCheckObserver(((Long)this.arg).longValue());
/*    */     }
/*    */     
/* 18 */     int level = RoleInterface.getLevel(((Long)this.arg).longValue());
/* 19 */     OnlineRoleLevelManage.getInstance().addRole(level, ((Long)this.arg).longValue());
/* 20 */     OnlineUsers.users.put(this.arg, Integer.valueOf(0));
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */