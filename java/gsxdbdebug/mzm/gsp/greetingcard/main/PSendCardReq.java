/*     */ package mzm.gsp.greetingcard.main;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.greetingcard.GreetingCardData;
/*     */ import mzm.gsp.greetingcard.SSendCardBroadcast;
/*     */ import mzm.gsp.greetingcard.SSendCardFail;
/*     */ import mzm.gsp.greetingcard.SenderData;
/*     */ import mzm.gsp.greetingcard.event.SendCardEvent;
/*     */ import mzm.gsp.greetingcard.event.SendCardEventArg;
/*     */ import mzm.gsp.item.confbean.SGreetingCardItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PSendCardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemKey;
/*     */   private int channel;
/*     */   private GreetingCardData data;
/*     */   
/*     */   public PSendCardReq(long roleId, int itemKey, int channel, GreetingCardData data)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.itemKey = itemKey;
/*  42 */     this.channel = channel;
/*  43 */     this.data = data;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!OpenInterface.getOpenStatus(344)) {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     BasicItem item = ItemInterface.getItem(this.roleId, this.itemKey);
/*  55 */     if ((item == null) || (item.getCfgId() != this.data.cardcfgid))
/*     */     {
/*  57 */       SSendCardFail sSendCardFail = new SSendCardFail(2, this.itemKey);
/*  58 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSendCardFail);
/*  59 */       GreetingCardManager.debug(String.format("[GreetingCard]PSendCardReq#processImp()@no item|roleId=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) }));
/*     */       
/*  61 */       return false;
/*     */     }
/*  63 */     SGreetingCardItemCfg card = SGreetingCardItemCfg.get(item.getCfgId());
/*  64 */     if (card == null)
/*     */     {
/*  66 */       SSendCardFail sSendCardFail = new SSendCardFail(1, this.itemKey);
/*  67 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSendCardFail);
/*  68 */       GreetingCardManager.debug(String.format("[GreetingCard]PSendCardReq#processImp()@not card item|roleId=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) }));
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     SSendCardBroadcast sSendCardBroadcast = new SSendCardBroadcast(this.channel, this.data, new SenderData());
/*  76 */     GreetingCardManager.fillSenderData(sSendCardBroadcast.senderdata, this.roleId);
/*  77 */     switch (this.channel)
/*     */     {
/*     */ 
/*     */     case 2: 
/*  81 */       long gangId = GangInterface.getGangId(this.roleId);
/*  82 */       if (gangId == 0L)
/*     */       {
/*  84 */         SSendCardFail sSendCardFail = new SSendCardFail(4, this.itemKey);
/*  85 */         OnlineManager.getInstance().sendAtOnce(this.roleId, sSendCardFail);
/*  86 */         GreetingCardManager.debug(String.format("[GreetingCard]PSendCardReq#processImp()@not gang member|roleId=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) }));
/*     */         
/*     */ 
/*  89 */         return false;
/*     */       }
/*  91 */       OnlineManager.getInstance().sendMulti(sSendCardBroadcast, GangInterface.getGangMemberList(gangId));
/*  92 */       break;
/*     */     
/*     */     case 5: 
/*  95 */       OnlineManager.getInstance().sendAll(sSendCardBroadcast);
/*  96 */       break;
/*     */     
/*     */     default: 
/*  99 */       SSendCardFail sSendCardFail = new SSendCardFail(3, this.itemKey);
/* 100 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSendCardFail);
/* 101 */       GreetingCardManager.debug(String.format("[GreetingCard]PSendCardReq#processImp()@invalid channel|roleId=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) }));
/*     */       
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/*     */     
/* 108 */     if (card.rewardId != 0)
/*     */     {
/* 110 */       AwardReason reason = new AwardReason(LogReason.SEND_GREETING_CARD);
/* 111 */       AwardInterface.award(card.rewardId, RoleInterface.getUserId(this.roleId), this.roleId, false, true, reason);
/*     */     }
/*     */     
/*     */ 
/* 115 */     if (!ItemInterface.removeItemByGrid(this.roleId, 340600000, this.itemKey, 1, new TLogArg(LogReason.SEND_GREETING_CARD)))
/*     */     {
/* 117 */       SSendCardFail sSendCardFail = new SSendCardFail(2, this.itemKey);
/* 118 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSendCardFail);
/* 119 */       GreetingCardManager.debug(String.format("[GreetingCard]PSendCardReq#processImp()@no item|roleId=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) }));
/*     */       
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     SendCardEventArg sendCardEventArg = new SendCardEventArg();
/* 126 */     sendCardEventArg.cardItemCfgId = card.id;
/* 127 */     TriggerEventsManger.getInstance().triggerEvent(new SendCardEvent(), sendCardEventArg);
/*     */     
/* 129 */     GreetingCardManager.debug(String.format("[GreetingCard]PSendCardReq#processImp()@success|roleId=%d|itemKey=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) }));
/*     */     
/*     */ 
/* 132 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\main\PSendCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */