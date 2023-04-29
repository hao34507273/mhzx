/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSessions;
/*    */ import xbean.RoleSingleBattle;
/*    */ import xtable.Role2singlebattle;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SessionDeath
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   private final long _battleId;
/*    */   
/*    */   public SessionDeath(long interval, long roleId, long battleId)
/*    */   {
/* 22 */     super(interval, roleId);
/*    */     
/* 24 */     this.roleId = roleId;
/* 25 */     this._battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     new PRoleRevive().execute();
/*    */   }
/*    */   
/*    */   class PRoleRevive
/*    */     extends LogicProcedure
/*    */   {
/*    */     PRoleRevive() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 41 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(SessionDeath.this._battleId, true);
/* 42 */       if (globalInfo == null)
/*    */       {
/* 44 */         GameServer.logger().error(String.format("[singlebattle]SessionDeath.processImp@ no xGlobalInfo! |roleId=%d|battleId=%d", new Object[] { Long.valueOf(SessionDeath.this.roleId), Long.valueOf(SessionDeath.this._battleId) }));
/*    */         
/*    */ 
/* 47 */         return false;
/*    */       }
/*    */       
/* 50 */       RoleSingleBattle xRoleBattle = Role2singlebattle.get(Long.valueOf(SessionDeath.this.roleId));
/* 51 */       if (xRoleBattle == null)
/*    */       {
/* 53 */         GameServer.logger().error(String.format("[singlebattle]PRoleRevive.processImp@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(SessionDeath.this.roleId) }));
/*    */         
/* 55 */         return false;
/*    */       }
/*    */       
/* 58 */       RoleStatusInterface.unsetStatus(SessionDeath.this.roleId, 1512);
/*    */       
/* 60 */       RoleStatusInterface.setStatus(SessionDeath.this.roleId, 1513, true);
/*    */       
/* 62 */       xRoleBattle.getRolesessions().setProtectsessionid(new SessionReviveProtect(10L, SessionDeath.this.roleId).getSessionId());
/*    */       
/* 64 */       globalInfo.transferToBattle(SessionDeath.this.roleId, xRoleBattle.getCampid());
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   long getRoleId()
/*    */   {
/* 72 */     return this.roleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SessionDeath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */