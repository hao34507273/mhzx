/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ public class POnRoleRename
/*    */   extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 17 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 18 */     if (xGroupInfo == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     String roleName = RoleInterface.getName(roleid);
/* 23 */     GroupAsynTaskManager.getInstance().addTask(new PMemberRenameNotify(roleid, xGroupInfo.getCreate_same_zone_groupids().keySet(), xGroupInfo.getJoin_same_zone_groupids().keySet(), roleName));
/*    */     
/*    */ 
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */