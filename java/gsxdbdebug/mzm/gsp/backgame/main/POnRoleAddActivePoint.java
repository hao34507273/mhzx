/*    */ package mzm.gsp.backgame.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.active.event.ActiveArg;
/*    */ import mzm.gsp.active.event.AddActivePointProcedure;
/*    */ import mzm.gsp.backgame.SNotifyBackScoreChange;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2BackGameInfo;
/*    */ import xtable.Role2backgame;
/*    */ 
/*    */ public class POnRoleAddActivePoint extends AddActivePointProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleId = ((ActiveArg)this.arg).roleid;
/*    */     
/* 18 */     if (!BackGameManager.isBackGameSwitchOpen(roleId, null, false, false))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 24 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 26 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(roleId));
/* 27 */     if (xRole2BackGameInfo == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     long xBackGameStateStartTime = xRole2BackGameInfo.getBack_state_start_time();
/* 32 */     if (!BackGameManager.isInBackState(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis(), xBackGameStateStartTime))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     BackGameManager.checkAndClearBackGameScore(xRole2BackGameInfo, userId, roleId, -1L, ((ActiveArg)this.arg).oldPoint, "POnRoleAddActivePoint.processImp");
/*    */     
/*    */ 
/* 39 */     int nowScore = BackGameManager.getNowBackGameScoreValue(userId, roleId, xRole2BackGameInfo);
/*    */     
/* 41 */     SNotifyBackScoreChange sNotifyBackScoreChange = new SNotifyBackScoreChange();
/* 42 */     sNotifyBackScoreChange.now_back_score = nowScore;
/*    */     
/* 44 */     OnlineManager.getInstance().send(roleId, sNotifyBackScoreChange);
/*    */     
/* 46 */     GameServer.logger().info(String.format("[backgame]POnRoleAddActivePoint.processImp@add score success|role_id=%d|new_point=%d|old_point=%d|now_score=%d|current_active_base_value=%d|current_yuan_bao_base_value=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(((ActiveArg)this.arg).newPoint), Integer.valueOf(((ActiveArg)this.arg).oldPoint), Integer.valueOf(nowScore), Integer.valueOf(xRole2BackGameInfo.getActive_base_value()), Long.valueOf(xRole2BackGameInfo.getYuan_bao_save_amt_base_value()) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\POnRoleAddActivePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */