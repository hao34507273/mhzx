/*     */ package mzm.gsp.csprovider.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.ActiveCardUse;
/*     */ import csprovider.ActiveCardUseArg;
/*     */ import csprovider.ActiveCardUseRes;
/*     */ import csprovider.GiftCardUse;
/*     */ import csprovider.GiftCardUseArg;
/*     */ import csprovider.GiftCardUseRes;
/*     */ import gnet.GDeliveryManager;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import mzm.event.BasicEvent;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.csprovider.SUseActivateCardSuccess;
/*     */ import mzm.gsp.csprovider.SUseGiftCardSuccess;
/*     */ import mzm.gsp.csprovider.event.UseActivateCardArg;
/*     */ import mzm.gsp.csprovider.event.UseActivateCardArg.ErrorCode;
/*     */ import mzm.gsp.csprovider.event.UseActivateCardFailure;
/*     */ import mzm.gsp.csprovider.event.UseActivateCardSuccess;
/*     */ import mzm.gsp.csprovider.event.UseGiftCardArg;
/*     */ import mzm.gsp.csprovider.event.UseGiftCardArg.ErrorCode;
/*     */ import mzm.gsp.csprovider.event.UseGiftCardFailure;
/*     */ import mzm.gsp.csprovider.event.UseGiftCardSuccess;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.signaward.confbean.SGiftCode;
/*     */ import mzm.gsp.signaward.main.SignAwardInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CSProviderManager
/*     */ {
/*  43 */   private static String ENCODING = "UTF-8";
/*  44 */   private static AtomicBoolean requireActivateUser = new AtomicBoolean(false);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setRequireActivateUser(boolean value)
/*     */   {
/*  53 */     requireActivateUser.set(value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean getRequireActivateUser()
/*     */   {
/*  63 */     return requireActivateUser.get();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void activateUser(String userId)
/*     */   {
/*  73 */     xbean.User xUser = xtable.User.get(userId);
/*  74 */     if (xUser == null)
/*     */     {
/*  76 */       xUser = Pod.newUser();
/*  77 */       xtable.User.insert(userId, xUser);
/*     */     }
/*  79 */     xUser.setActivated(true);
/*     */     
/*     */     try
/*     */     {
/*  83 */       Protocol context = UseActivateCardContextManager.getInstance().getProtocol(userId);
/*  84 */       if (context == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*  89 */       SUseActivateCardSuccess res = new SUseActivateCardSuccess();
/*  90 */       Onlines.getInstance().sendResponse(context, res);
/*     */     }
/*     */     finally
/*     */     {
/*  94 */       UseActivateCardContextManager.getInstance().removeContext(userId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean useActivateCard(String userIdentiy, String cardNumber, int loginip)
/*     */   {
/* 112 */     ActiveCardUseArg arg = new ActiveCardUseArg();
/* 113 */     arg.userid = Octets.wrap(userIdentiy, ENCODING);
/* 114 */     arg.cardnumber = Octets.wrap(cardNumber, ENCODING);
/* 115 */     arg.loginip = loginip;
/* 116 */     arg.serverid = GameServerInfoManager.getZoneidFromUserid(userIdentiy);
/* 117 */     ActiveCardUse rpc = new ActiveCardUse(arg);
/* 118 */     boolean result = GDeliveryManager.getInstance().send(rpc);
/* 119 */     if (!result)
/*     */     {
/* 121 */       onUseActivateCardTimeout(arg);
/*     */     }
/*     */     
/* 124 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onUseActivateCardAck(ActiveCardUseArg arg, ActiveCardUseRes res)
/*     */   {
/* 137 */     String userId = arg.userid.getString(ENCODING);
/* 138 */     String cardNumber = arg.cardnumber.getString(ENCODING);
/* 139 */     UseActivateCardArg.ErrorCode errorCode = UseActivateCardArg.ErrorCode.ERROR_CSP_OTHER_ERROR;
/* 140 */     switch (res.retcode)
/*     */     {
/*     */     case 0: 
/* 143 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_SUCCESS;
/* 144 */       break;
/*     */     
/*     */     case 1: 
/* 147 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_INVALID;
/* 148 */       break;
/*     */     
/*     */     case 2: 
/* 151 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_NOT_IN_EFFECTIVE_TIME;
/* 152 */       break;
/*     */     
/*     */     case 3: 
/* 155 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_IS_OUT_OF_DATE;
/* 156 */       break;
/*     */     case 4: 
/* 158 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_USED_BY_THE_USER;
/* 159 */       break;
/*     */     case 5: 
/* 161 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_USED_BY_THE_USER_BUT_CARD_BATCH_INVALID;
/* 162 */       break;
/*     */     case 6: 
/* 164 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_USED_BY_THE_USER_IN_OTHER_SERVER;
/* 165 */       break;
/*     */     case 7: 
/* 167 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_ALREADY_USED_BY_OTHERS;
/* 168 */       break;
/*     */     case 8: 
/* 170 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CARD_NOT_EXIST;
/* 171 */       break;
/*     */     case 9: 
/* 173 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_CSP_OTHER_ERROR;
/* 174 */       break;
/*     */     case 10: 
/* 176 */       errorCode = UseActivateCardArg.ErrorCode.ERROR_NETWORK;
/* 177 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 182 */     BasicEvent<UseActivateCardArg> event = null;
/* 183 */     if (res.retcode == 0)
/*     */     {
/* 185 */       event = new UseActivateCardSuccess();
/*     */     }
/*     */     else
/*     */     {
/* 189 */       event = new UseActivateCardFailure();
/*     */     }
/* 191 */     event.setSequential(true);
/* 192 */     UseActivateCardArg eventArg = new UseActivateCardArg(userId, cardNumber, res.cardtype, errorCode);
/* 193 */     TriggerEventsManger.getInstance().triggerEvent(event, eventArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onUseActivateCardTimeout(ActiveCardUseArg arg)
/*     */   {
/* 204 */     String userId = arg.userid.getString(ENCODING);
/* 205 */     String cardNumber = arg.cardnumber.getString(ENCODING);
/* 206 */     UseActivateCardFailure event = new UseActivateCardFailure();
/* 207 */     event.setSequential(true);
/* 208 */     UseActivateCardArg eventArg = new UseActivateCardArg(userId, cardNumber, UseActivateCardArg.ErrorCode.ERROR_NETWORK);
/* 209 */     TriggerEventsManger.getInstance().triggerEvent(event, eventArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean awardGiftCard(UseGiftCardArg arg)
/*     */   {
/* 220 */     long roleId = arg.roleId;
/* 221 */     int cardtype = arg.cardType;
/* 222 */     int parenttype = arg.parentType;
/* 223 */     int award_id = arg.awardId;
/* 224 */     String cardnumber = arg.cardNumber;
/* 225 */     SGiftCode giftCode = SignAwardInterface.getSGiftCode(cardtype, parenttype);
/* 226 */     int paramreason = 0;
/* 227 */     if (giftCode != null)
/*     */     {
/* 229 */       paramreason = giftCode.id;
/* 230 */       if ((giftCode != null) && (award_id != giftCode.awarditemid))
/*     */       {
/* 232 */         String logStr = String.format("CSProviderManager.awardGiftCard@award_id not same |roleid=%d|cardnumber=%s|parenttype=%d|cardtype=%d|award_id=%d|award_id_s=%d", new Object[] { Long.valueOf(roleId), cardnumber, Integer.valueOf(parenttype), Integer.valueOf(cardtype), Integer.valueOf(award_id), Integer.valueOf(giftCode.awarditemid) });
/*     */         
/*     */ 
/* 235 */         GameServer.logger().error(logStr);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 241 */       String logStr = String.format("CSProviderManager.awardGiftCard@not found SGiftCode,null|roleid=%d|cardnumber=%s|parenttype=%d|cardtype=%d|award_id=%d", new Object[] { Long.valueOf(roleId), cardnumber, Integer.valueOf(parenttype), Integer.valueOf(cardtype), Integer.valueOf(award_id) });
/*     */       
/*     */ 
/* 244 */       GameServer.logger().error(logStr);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 249 */     ItemOperateResult result = ItemInterface.addItem(roleId, award_id, 1, new TLogArg(LogReason.USE_GIFT_CODE_ADD, paramreason));
/*     */     
/*     */ 
/* 252 */     SUseGiftCardSuccess suc = new SUseGiftCardSuccess();
/* 253 */     OnlineManager.getInstance().send(roleId, suc);
/* 254 */     boolean ret = (result.success()) || (result.isBagFull());
/*     */     
/* 256 */     if (!ret)
/*     */     {
/* 258 */       String logStr = String.format("CSProviderManager.awardGiftCard@cardnumber is used |roleid=%d|cardnumber=%s|parenttype=%d|cardtype=%d|award_id=%d", new Object[] { Long.valueOf(roleId), cardnumber, Integer.valueOf(parenttype), Integer.valueOf(cardtype), Integer.valueOf(award_id) });
/*     */       
/*     */ 
/* 261 */       GameServer.logger().error(logStr);
/*     */     }
/*     */     
/* 264 */     SignAwardInterface.tlogGiftcode(roleId, giftCode.id, cardnumber);
/* 265 */     SignAwardInterface.logGiftcode(arg.userId, roleId, cardnumber);
/* 266 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean useGiftCard(long roleId, String userIdentiy, String cardNumber, int loginip)
/*     */   {
/* 285 */     GiftCardUseArg arg = new GiftCardUseArg();
/* 286 */     arg.roleid = roleId;
/* 287 */     arg.userid = Octets.wrap(userIdentiy, ENCODING);
/* 288 */     arg.cardnumber = Octets.wrap(cardNumber, ENCODING);
/* 289 */     arg.loginip = loginip;
/* 290 */     arg.serverid = GameServerInfoManager.getZoneidFromRoleid(roleId);
/* 291 */     GiftCardUse rpc = new GiftCardUse(arg);
/* 292 */     boolean result = GDeliveryManager.getInstance().send(rpc);
/* 293 */     if (!result)
/*     */     {
/* 295 */       onUseGiftCardTimeout(arg);
/*     */     }
/*     */     
/* 298 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onUseGiftCardAck(GiftCardUseArg arg, GiftCardUseRes res)
/*     */   {
/* 311 */     String userId = arg.userid.getString(ENCODING);
/* 312 */     String cardNumber = arg.cardnumber.getString(ENCODING);
/* 313 */     UseGiftCardArg.ErrorCode errorCode = UseGiftCardArg.ErrorCode.ERROR_CSP_OTHER_ERROR;
/* 314 */     switch (res.retcode)
/*     */     {
/*     */     case 0: 
/* 317 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_SUCCESS;
/* 318 */       break;
/*     */     
/*     */     case 1: 
/* 321 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_CARD_INVALID;
/* 322 */       break;
/*     */     
/*     */     case 2: 
/* 325 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_NOT_IN_EFFECTIVE_TIME;
/* 326 */       break;
/*     */     
/*     */     case 3: 
/* 329 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_CARD_IS_OUT_OF_DATE;
/* 330 */       break;
/*     */     case 4: 
/* 332 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_MAX_USE_TIMES_OF_THE_PARENT_TYPE_LIMIT;
/* 333 */       break;
/*     */     case 5: 
/* 335 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_CARD_USED_BY_THE_ROLE;
/* 336 */       break;
/*     */     case 6: 
/* 338 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_CARD_USED_BY_OTHERS;
/* 339 */       break;
/*     */     case 7: 
/* 341 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_CARD_NOT_EXIST;
/* 342 */       break;
/*     */     case 8: 
/* 344 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_CSP_OTHER_ERROR;
/* 345 */       break;
/*     */     case 9: 
/* 347 */       errorCode = UseGiftCardArg.ErrorCode.ERROR_NETWORK;
/* 348 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 353 */     BasicEvent<UseGiftCardArg> event = null;
/* 354 */     if (res.retcode == 0)
/*     */     {
/* 356 */       event = new UseGiftCardSuccess();
/*     */     }
/*     */     else
/*     */     {
/* 360 */       event = new UseGiftCardFailure();
/*     */     }
/* 362 */     event.setSequential(true);
/* 363 */     UseGiftCardArg eventArg = new UseGiftCardArg(arg.roleid, userId, cardNumber, res.parenttype, res.cardtype, res.award_id, errorCode);
/*     */     
/* 365 */     TriggerEventsManger.getInstance().triggerEvent(event, eventArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onUseGiftCardTimeout(GiftCardUseArg arg)
/*     */   {
/* 376 */     String userId = arg.userid.getString(ENCODING);
/* 377 */     String cardNumber = arg.cardnumber.getString(ENCODING);
/* 378 */     UseGiftCardFailure event = new UseGiftCardFailure();
/* 379 */     event.setSequential(true);
/* 380 */     UseGiftCardArg eventArg = new UseGiftCardArg(arg.roleid, userId, cardNumber, UseGiftCardArg.ErrorCode.ERROR_NETWORK);
/*     */     
/* 382 */     TriggerEventsManger.getInstance().triggerEvent(event, eventArg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\CSProviderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */