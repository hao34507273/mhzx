/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
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
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardExpireSession
/*    */   extends Session
/*    */ {
/*    */   public final long startTime;
/*    */   
/*    */   ChangeModelCardExpireSession(long startTime, long interval, long roleId)
/*    */   {
/* 27 */     super(interval, roleId);
/* 28 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 34 */     final long roleId = getOwerId();
/* 35 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 41 */         Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(roleId);
/* 42 */         int cardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/* 43 */         int cardLevel = xRole2CardInfo.getCurrent_card_level();
/* 44 */         if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*    */         {
/* 46 */           return false;
/*    */         }
/* 48 */         SCardLevelBean sCardLevelCfg = ChangeModelCardCfgManager.getCardLevelCfg(cardCfgId, cardLevel);
/*    */         
/*    */ 
/* 51 */         int newOverlayCount = Math.max(xRole2CardInfo.getOverlay_count() - 1, 0);
/* 52 */         if ((null == sCardLevelCfg) || (newOverlayCount == 0))
/*    */         {
/*    */ 
/* 55 */           ChangeModelCardManager.tryRemoveChangeModelState(roleId, xRole2CardInfo, ChangeModelCardManager.RemoveCardStateReason.TIME_OUT);
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 60 */           long newStartTime = xRole2CardInfo.getStart_time() + sCardLevelCfg.effectPersistMinute * 60000L;
/*    */           
/* 62 */           int newFightCount = Math.max(0, xRole2CardInfo.getFight_count() - sCardLevelCfg.effectPersistPVPFight);
/* 63 */           xRole2CardInfo.setOverlay_count(newOverlayCount);
/* 64 */           xRole2CardInfo.setStart_time(newStartTime);
/* 65 */           xRole2CardInfo.setFight_count(newFightCount);
/*    */           
/*    */ 
/* 68 */           long sessionId = new ChangeModelCardExpireSession(newStartTime, sCardLevelCfg.effectPersistMinute * 60L, roleId).getSessionId();
/*    */           
/* 70 */           ChangeModelCardManager.getRole2CardSessionInfo(roleId).setMain_session_id(sessionId);
/*    */           
/*    */ 
/* 73 */           ChangeModelCardManager.synRoleCardInfoChange(roleId, xRole2CardInfo);
/*    */         }
/*    */         
/* 76 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\ChangeModelCardExpireSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */