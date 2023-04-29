/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.watchmoon.SQueryRoleModelInfoRes;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PQueryRoleModelInfo extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long targetRoleid;
/*    */   
/*    */   public PQueryRoleModelInfo(long roleid, long targetRoleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.targetRoleid = targetRoleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (this.roleid == this.targetRoleid)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     String targetUser = RoleInterface.getUserId(this.targetRoleid);
/* 29 */     if (targetUser == null)
/*    */     {
/* 31 */       String logstr = String.format("[watchmoon]PQueryRoleModelInfo.processImp@query role model req|roleid=%d|targetRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) });
/*    */       
/*    */ 
/* 34 */       WatchmoonManager.logger.error(logstr);
/* 35 */       return false;
/*    */     }
/* 37 */     SQueryRoleModelInfoRes res = new SQueryRoleModelInfoRes();
/*    */     
/* 39 */     RoleInterface.fillModelInfo(this.targetRoleid, res.modelinfo);
/* 40 */     res.roleid = this.targetRoleid;
/* 41 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\PQueryRoleModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */