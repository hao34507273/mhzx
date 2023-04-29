/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PReturnOriginalServer
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private String userid;
/*    */   
/*    */   public PReturnOriginalServer(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public PReturnOriginalServer(long roleid, String userid) {
/* 24 */     this.roleid = roleid;
/* 25 */     this.userid = userid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 30 */     if (this.userid == null)
/*    */     {
/* 32 */       this.userid = RoleInterface.getUserId(this.roleid);
/*    */     }
/*    */     
/*    */ 
/* 36 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*    */     
/* 38 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 40 */     CrossCompeteRoamManager.returnOriginalServer(this.userid, this.roleid);
/*    */     
/* 42 */     CrossCompeteManager.logInfo("PReturnOriginalServer.processImp@return original|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */     
/*    */ 
/*    */ 
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PReturnOriginalServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */