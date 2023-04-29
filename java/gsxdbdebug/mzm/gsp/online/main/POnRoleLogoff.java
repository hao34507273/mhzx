/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 12 */     lock(xtable.Role2properties.getTable(), Collections.singletonList(this.arg));
/* 13 */     int level = RoleInterface.getLevel(((Long)this.arg).longValue());
/* 14 */     OnlineRoleLevelManage.getInstance().remRole(level, ((Long)this.arg).longValue());
/* 15 */     OnlineUsers.users.remove(this.arg);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */