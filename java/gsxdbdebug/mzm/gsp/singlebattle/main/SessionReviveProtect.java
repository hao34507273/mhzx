/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Role2singlebattle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SessionReviveProtect
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public SessionReviveProtect(long interval, long roleId)
/*    */   {
/* 21 */     super(interval, roleId);
/*    */     
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     new PReviveProtect().execute();
/*    */   }
/*    */   
/*    */   class PReviveProtect extends LogicProcedure
/*    */   {
/*    */     PReviveProtect() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 38 */       RoleSingleBattle xRoleBattle = Role2singlebattle.get(Long.valueOf(SessionReviveProtect.this.roleId));
/* 39 */       if (xRoleBattle == null)
/*    */       {
/* 41 */         GameServer.logger().error(String.format("[singlebattle]PReviveProtect.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(SessionReviveProtect.this.roleId) }));
/*    */         
/* 43 */         return false;
/*    */       }
/*    */       
/* 46 */       RoleStatusInterface.unsetStatus(SessionReviveProtect.this.roleId, 1513);
/* 47 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   long getRoleId()
/*    */   {
/* 54 */     return this.roleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SessionReviveProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */