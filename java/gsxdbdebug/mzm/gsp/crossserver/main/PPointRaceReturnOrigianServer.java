/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PPointRaceReturnOrigianServer extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PPointRaceReturnOrigianServer(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     String userid = RoleInterface.getUserId(this.roleid);
/* 21 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/* 22 */     CrossServerManager.removeUserRoamedInfo(userid, RoamType.CROSS_BATTLE_POINT);
/* 23 */     LoginManager.getInstance().onReturnOrigianServer(userid, this.roleid);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PPointRaceReturnOrigianServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */