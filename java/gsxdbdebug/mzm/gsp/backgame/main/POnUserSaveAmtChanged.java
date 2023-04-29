/*    */ package mzm.gsp.backgame.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.backgame.SNotifyBackScoreChange;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2BackGameInfo;
/*    */ import xtable.Role2backgame;
/*    */ 
/*    */ public class POnUserSaveAmtChanged extends SaveAmtChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     String userId = ((SaveAmtChangedArg)this.arg).userid;
/*    */     
/* 18 */     long roleId = mzm.gsp.qingfu.main.QingfuInterface.getSuitableRoleId(userId);
/*    */     
/* 20 */     if (!BackGameManager.isBackGameSwitchOpen(roleId, null, false, false))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 26 */     Role2BackGameInfo xRole2BackGameInfo = Role2backgame.get(Long.valueOf(roleId));
/* 27 */     if (xRole2BackGameInfo == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (!BackGameManager.isInBackState(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis(), xRole2BackGameInfo.getBack_state_start_time()))
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     BackGameManager.checkAndClearBackGameScore(xRole2BackGameInfo, userId, roleId, ((SaveAmtChangedArg)this.arg).oldSaveAmt, -1, "POnUserSaveAmtChanged.processImp");
/*    */     
/* 39 */     int nowScore = BackGameManager.getNowBackGameScoreValue(userId, roleId, xRole2BackGameInfo);
/*    */     
/* 41 */     SNotifyBackScoreChange sNotifyBackScoreChange = new SNotifyBackScoreChange();
/* 42 */     sNotifyBackScoreChange.now_back_score = nowScore;
/*    */     
/* 44 */     OnlineManager.getInstance().send(roleId, sNotifyBackScoreChange);
/*    */     
/* 46 */     GameServer.logger().info(String.format("[backgame]POnRoleAddActivePoint.processImp@add score success|role_id=%d|curr_save_amt=%d|old_save_amt=%d|now_score=%d|current_active_base_value=%d|current_yuan_bao_base_value=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(((SaveAmtChangedArg)this.arg).currSaveAmt), Long.valueOf(((SaveAmtChangedArg)this.arg).oldSaveAmt), Integer.valueOf(nowScore), Integer.valueOf(xRole2BackGameInfo.getActive_base_value()), Long.valueOf(xRole2BackGameInfo.getYuan_bao_save_amt_base_value()) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\main\POnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */