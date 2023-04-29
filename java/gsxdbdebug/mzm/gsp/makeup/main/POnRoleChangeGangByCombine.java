/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.RoleChangeGangByCombineArg;
/*    */ 
/*    */ public class POnRoleChangeGangByCombine extends mzm.gsp.gang.event.RoleChangeGangByCombineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     MakeUpManager.synAllMakeupInfo(((RoleChangeGangByCombineArg)this.arg).roleid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\POnRoleChangeGangByCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */