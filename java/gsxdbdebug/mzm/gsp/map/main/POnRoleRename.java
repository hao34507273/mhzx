/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleRename
/*    */   extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 16 */     String roleName = RoleInterface.getName(roleid);
/*    */     
/* 18 */     Map<Integer, Object> changeProps = new HashMap();
/* 19 */     changeProps.put(Integer.valueOf(1), roleName);
/* 20 */     new MMH_OnRoleAppearanceChanged(roleid, 7, changeProps).execute();
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */