/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleEscape;
/*    */ 
/*    */ public class POnRoleEscape extends mzm.gsp.fight.event.RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     new MMH_OnRoleEscape(((RoleEscapeArg)this.arg).roleid).execute();
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */