/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class ROnRoleLogin
/*    */   extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     final long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 15 */     if (RoleStatusInterface.containsStatus(roleId, 2161))
/*    */     {
/* 17 */       BallBattleActivityManager.addTask(new LogicProcedure()
/*    */       {
/*    */ 
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 23 */           if (RoleStatusInterface.containsStatus(roleId, 2161))
/*    */           {
/* 25 */             BallBattleActivityManager.syncActivityStatus(roleId);
/* 26 */             return true;
/*    */           }
/* 28 */           return false;
/*    */         }
/*    */       });
/*    */     }
/*    */     
/*    */ 
/* 34 */     if (RoleStatusInterface.containsStatus(roleId, 2162))
/*    */     {
/* 36 */       BallBattleGameInstance.handlePlayerReconnect(roleId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */