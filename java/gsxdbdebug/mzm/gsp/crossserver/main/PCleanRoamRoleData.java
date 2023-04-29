/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PCleanRoamRoleData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   PCleanRoamRoleData(String userid, long roleid)
/*    */   {
/* 42 */     this.userid = userid;
/* 43 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 49 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 50 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 52 */     CrossServerManager.cleanRoleXtableData(this.userid, this.roleid);
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PCleanRoamRoleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */