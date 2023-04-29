/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardSessionInfo;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */   {
/*  13 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*     */ 
/*  16 */     Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(roleId);
/*  17 */     checkCardState(roleId, xRole2CardInfo);
/*     */     
/*     */ 
/*  20 */     ChangeModelCardManager.synRoleCardInfo(roleId, xRole2CardInfo);
/*     */     
/*  22 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkCardState(long roleId, Role2ChangeModelCardInfo xRole2CardInfo)
/*     */   {
/*  33 */     if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*     */     {
/*  35 */       return;
/*     */     }
/*  37 */     int cardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/*  38 */     int cardLevel = xRole2CardInfo.getCurrent_card_level();
/*     */     
/*  40 */     SCardLevelBean sCardLevelBean = ChangeModelCardCfgManager.getCardLevelCfg(cardCfgId, cardLevel);
/*  41 */     long singlePersistTime = sCardLevelBean.effectPersistMinute * 60000L;
/*     */     
/*  43 */     long currentTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  44 */     int needOverlay = (int)Math.max((currentTime - xRole2CardInfo.getStart_time()) / singlePersistTime, 0L);
/*     */     
/*  46 */     if (needOverlay >= xRole2CardInfo.getOverlay_count())
/*     */     {
/*  48 */       ChangeModelCardManager.tryRemoveChangeModelState(roleId, xRole2CardInfo, ChangeModelCardManager.RemoveCardStateReason.TIME_OUT);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  53 */       int newOverlayCount = xRole2CardInfo.getOverlay_count() - needOverlay;
/*  54 */       long newStartTime = xRole2CardInfo.getStart_time() + needOverlay * singlePersistTime;
/*  55 */       xRole2CardInfo.setOverlay_count(newOverlayCount);
/*  56 */       xRole2CardInfo.setStart_time(newStartTime);
/*     */       
/*     */ 
/*  59 */       Role2ChangeModelCardSessionInfo xCardSessionInfo = ChangeModelCardManager.getRole2CardSessionInfo(roleId);
/*  60 */       if (needStartSession(xCardSessionInfo, newStartTime))
/*     */       {
/*     */ 
/*  63 */         long mainSessionId = xCardSessionInfo.getMain_session_id();
/*  64 */         ChangeModelCardExpireSession.removeSession(mainSessionId);
/*  65 */         long notifySessionId = xCardSessionInfo.getExpire_notify_session_id();
/*  66 */         ChangeModelCardExpireNotifySession.removeSession(notifySessionId);
/*     */         
/*     */ 
/*  69 */         long newStartSec = newStartTime / 1000L;
/*  70 */         long currentSec = currentTime / 1000L;
/*  71 */         long mainIntervalSec = sCardLevelBean.effectPersistMinute * 60L;
/*  72 */         long newMainSessionId = new ChangeModelCardExpireSession(newStartTime, newStartSec + mainIntervalSec - currentSec, roleId).getSessionId();
/*     */         
/*  74 */         long notifyRemainSec = SChangeModelCardConsts.getInstance().EXPIRE_NOTIFY_REMAIN_MINUTES * 60L;
/*     */         
/*  76 */         long notifyIntervalSec = newStartSec + mainIntervalSec - notifyRemainSec - currentSec;
/*  77 */         if (notifyIntervalSec <= 0L)
/*     */         {
/*  79 */           notifyIntervalSec = mainIntervalSec + notifyIntervalSec % mainIntervalSec;
/*     */         }
/*  81 */         long newNotifySessionId = new ChangeModelCardExpireNotifySession(notifyIntervalSec, roleId).getSessionId();
/*     */         
/*  83 */         xCardSessionInfo.setMain_session_id(newMainSessionId);
/*  84 */         xCardSessionInfo.setExpire_notify_session_id(newNotifySessionId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean needStartSession(Role2ChangeModelCardSessionInfo xCardSessionInfo, long newStartTime)
/*     */   {
/*  97 */     if (null != xCardSessionInfo)
/*     */     {
/*  99 */       long mainSessionId = xCardSessionInfo.getMain_session_id();
/* 100 */       ChangeModelCardExpireSession session = (ChangeModelCardExpireSession)ChangeModelCardExpireSession.getSession(mainSessionId);
/* 101 */       if (null == session)
/*     */       {
/* 103 */         return true;
/*     */       }
/* 105 */       if (session.startTime == newStartTime)
/*     */       {
/* 107 */         return false;
/*     */       }
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */