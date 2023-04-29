/*     */ package mzm.gsp.skylantern.main;
/*     */ 
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.greetingcard.GreetingCardData;
/*     */ import mzm.gsp.greetingcard.SSendCardBroadcast;
/*     */ import mzm.gsp.greetingcard.SenderData;
/*     */ import mzm.gsp.greetingcard.main.GreetingCardManager;
/*     */ import mzm.gsp.item.confbean.SGreetingCardItemCfg;
/*     */ import mzm.gsp.map.main.message.MMH_IsNearByPos;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
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
/*     */ public class SkyLanternManager
/*     */ {
/*     */   static boolean isFunOpen(long roleid, int openId)
/*     */   {
/*  31 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (OpenInterface.isBanPlay(roleid, openId))
/*     */     {
/*  37 */       OpenInterface.sendBanPlayMsg(roleid, openId);
/*  38 */       return false;
/*     */     }
/*  40 */     return true;
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
/*     */   static boolean isNearByPos(long roleid, int mapCfgid, int x, int y)
/*     */   {
/*  54 */     MMH_IsNearByPos handler = new MMH_IsNearByPos(roleid, mapCfgid, x, y, null);
/*  55 */     handler.call();
/*  56 */     return handler.getResult();
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
/*     */   static int sendGreetingCardWithoutBagItem(long roleId, int itemCfgId, int channel, GreetingCardData data)
/*     */   {
/*  73 */     SGreetingCardItemCfg card = SGreetingCardItemCfg.get(itemCfgId);
/*  74 */     if (card == null)
/*     */     {
/*  76 */       return 7;
/*     */     }
/*     */     
/*     */ 
/*  80 */     SSendCardBroadcast sSendCardBroadcast = new SSendCardBroadcast(channel, data, new SenderData());
/*  81 */     GreetingCardManager.fillSenderData(sSendCardBroadcast.senderdata, roleId);
/*  82 */     switch (channel)
/*     */     {
/*     */ 
/*     */     case 2: 
/*  86 */       long gangId = GangInterface.getGangId(roleId);
/*  87 */       if (gangId == 0L)
/*     */       {
/*  89 */         return 9;
/*     */       }
/*  91 */       OnlineManager.getInstance().sendMulti(sSendCardBroadcast, GangInterface.getGangMemberList(gangId));
/*  92 */       break;
/*     */     
/*     */     case 5: 
/*  95 */       OnlineManager.getInstance().sendAll(sSendCardBroadcast);
/*  96 */       break;
/*     */     
/*     */     default: 
/*  99 */       return 8;
/*     */     }
/*     */     
/*     */     
/* 103 */     if (card.rewardId != 0)
/*     */     {
/* 105 */       AwardReason reason = new AwardReason(LogReason.SEND_GREETING_CARD);
/* 106 */       AwardInterface.award(card.rewardId, RoleInterface.getUserId(roleId), roleId, false, true, reason);
/*     */     }
/*     */     
/* 109 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skylantern\main\SkyLanternManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */