/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.fabao.event.FabaoSysChangeArg;
/*    */ import mzm.gsp.fabao.event.FabaoSysChangeProcedure;
/*    */ import mzm.gsp.fabao.main.FabaoInterface;
/*    */ 
/*    */ public class POnFabaoSysChange extends FabaoSysChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((FabaoSysChangeArg)this.arg).roleid);
/* 12 */     role.setFabaoPro(FabaoInterface.getFabaoSysPro(((FabaoSysChangeArg)this.arg).roleid, true));
/* 13 */     role.syncClientRoleProperty();
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnFabaoSysChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */