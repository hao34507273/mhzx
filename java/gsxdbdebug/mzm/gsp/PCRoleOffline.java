/*    */ package mzm.gsp;
/*    */ 
/*    */ import gnet.link.Dispatch;
/*    */ import gnet.link.Onlines;
/*    */ import gnet.link.Role;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.online.main.PPlayerPreLogout;
/*    */ 
/*    */ public class PCRoleOffline extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final CRoleOffline roleOffline;
/*    */   
/*    */   public PCRoleOffline(CRoleOffline roleOffline)
/*    */   {
/* 15 */     this.roleOffline = roleOffline;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Dispatch ctx = null;
/* 22 */     String userid = null;
/* 23 */     gnet.link.Link link = null;
/* 24 */     Role role = Onlines.getInstance().find(this.roleOffline);
/*    */     
/* 26 */     if (role != null) {
/* 27 */       long roleid = role.getRoleid();
/* 28 */       userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 29 */       lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/* 30 */       lock(xtable.Role2properties.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/* 31 */       boolean ret = mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 90, true);
/* 32 */       if (!ret) {
/* 33 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 38 */     if ((this.roleOffline.getContext() instanceof Dispatch)) {
/* 39 */       ctx = (Dispatch)this.roleOffline.getContext();
/* 40 */       userid = ctx.userid.getString("UTF-8");
/* 41 */       link = Onlines.getInstance().find(this.roleOffline.getConnection());
/* 42 */       Onlines.getInstance().remUserSession(userid, link, ctx.linksid);
/*    */     }
/* 44 */     if (role != null)
/*    */     {
/* 46 */       GameServer.logger().info("role offline, roleid=" + role.getRoleid());
/* 47 */       new PPlayerPreLogout(role.getRoleid(), this.roleOffline.reason).call();
/* 48 */       if (userid == null) {
/* 49 */         userid = role.getUserid();
/*    */       }
/*    */     }
/* 52 */     else if (ctx != null) {
/* 53 */       LoginManager.getInstance().leaveQueue(userid, link, ctx.linksid, false);
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PCRoleOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */