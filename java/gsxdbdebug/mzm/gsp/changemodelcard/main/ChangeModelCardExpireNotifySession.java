/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*    */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Role2ChangeModelCardInfo;
/*    */ import xbean.Role2ChangeModelCardSessionInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ChangeModelCardExpireNotifySession
/*    */   extends Session
/*    */ {
/*    */   ChangeModelCardExpireNotifySession(long interval, long roleId)
/*    */   {
/* 24 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 30 */     final long roleId = getOwerId();
/* 31 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(roleId);
/* 38 */         int cardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/* 39 */         int cardLevel = xRole2CardInfo.getCurrent_card_level();
/* 40 */         if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*    */         {
/* 42 */           return false;
/*    */         }
/* 44 */         SCardLevelBean sCardLevelCfg = ChangeModelCardCfgManager.getCardLevelCfg(cardCfgId, cardLevel);
/*    */         
/*    */ 
/* 47 */         int notifyMinute = SChangeModelCardConsts.getInstance().EXPIRE_NOTIFY_REMAIN_MINUTES;
/* 48 */         int notifyOverlayCount = notifyMinute / sCardLevelCfg.effectPersistMinute;
/* 49 */         if (xRole2CardInfo.getOverlay_count() - 1 == notifyOverlayCount)
/*    */         {
/* 51 */           ChangeModelCardManager.sendExpireNotifyProto(roleId, 1);
/*    */         }
/*    */         
/*    */ 
/* 55 */         long sessionId = new ChangeModelCardExpireNotifySession(sCardLevelCfg.effectPersistMinute * 60L, roleId).getSessionId();
/*    */         
/* 57 */         ChangeModelCardManager.getRole2CardSessionInfo(roleId).setExpire_notify_session_id(sessionId);
/*    */         
/* 59 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\ChangeModelCardExpireNotifySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */