/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_UnSetCrossServer extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_UnSetCrossServer(long gmRoleid, long roleid)
/*    */   {
/* 15 */     this.gmRoleid = gmRoleid;
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     String userid = RoleInterface.getUserId(this.roleid);
/* 22 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 23 */     LoginManager.getInstance().onReturnOrigianServer(userid, this.roleid);
/* 24 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("unSet crossServer status success", new Object[0]));
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_UnSetCrossServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */