/*     */ package mzm.gsp.npc.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.item.confbean.SItemPriceCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ChangeItemInfo;
/*     */ import mzm.gsp.npc.CBuyItemReq;
/*     */ import mzm.gsp.npc.STipRes;
/*     */ import mzm.gsp.npc.confbean.SNpcTrade;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ 
/*     */ 
/*     */ public class PBuyItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private int npcId;
/*     */   private int serviceId;
/*     */   private long roleId;
/*     */   private int itemId;
/*     */   private int itemCount;
/*     */   private long clientGold;
/*     */   private long clientSilver;
/*     */   
/*     */   public PBuyItemReq(long roleid, CBuyItemReq buyItemReq)
/*     */   {
/*  36 */     this.npcId = buyItemReq.npcid;
/*  37 */     this.serviceId = buyItemReq.serviceid;
/*  38 */     this.roleId = roleid;
/*  39 */     this.itemId = buyItemReq.itemid;
/*  40 */     this.itemCount = buyItemReq.itemcount;
/*     */     
/*  42 */     this.clientGold = buyItemReq.clientgold;
/*  43 */     this.clientSilver = buyItemReq.clientsilver;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 148, true))
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.NPC_SHOP_ITEM.value, this.itemId))
/*     */     {
/*  57 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemId));
/*  58 */       return false;
/*     */     }
/*  60 */     if (!checkClientData())
/*     */     {
/*  62 */       sendResult(8, 0, 0);
/*  63 */       return false;
/*     */     }
/*  65 */     boolean ret = NpcServiceManager.checkNpcService(this.npcId, this.serviceId, this.roleId);
/*  66 */     if (!ret)
/*     */     {
/*  68 */       sendResult(6, 0, 0);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     SItemPriceCfg itemPriceCfg = ItemInterface.getSItemPriceCfg(this.itemId);
/*  73 */     if (itemPriceCfg == null)
/*     */     {
/*  75 */       sendResult(4, 0, 0);
/*  76 */       return false;
/*     */     }
/*  78 */     SNpcTrade npcTrade = NpcTradeManager.getSNpcTradeByServiceId(this.serviceId);
/*  79 */     if (npcTrade == null)
/*     */     {
/*  81 */       sendResult(5, 0, 0);
/*  82 */       return false;
/*     */     }
/*  84 */     if (this.itemCount > npcTrade.maxBuyNum)
/*     */     {
/*  86 */       sendResult(9, 0, 0);
/*  87 */       return false;
/*     */     }
/*  89 */     if (!npcTrade.items.contains(Integer.valueOf(this.itemId)))
/*     */     {
/*  91 */       sendResult(4, 0, 0);
/*  92 */       return false;
/*     */     }
/*  94 */     TLogArg logArg = new TLogArg(LogReason.ITEM_NPC_SHOP, this.itemId);
/*  95 */     switch (npcTrade.priceType)
/*     */     {
/*     */     case 3: 
/*  98 */       long hasSilver = RoleInterface.getSilver(this.roleId);
/*  99 */       long needSilver = itemPriceCfg.shopSilverNum * this.itemCount;
/*     */       
/* 101 */       if (needSilver > hasSilver)
/*     */       {
/*     */ 
/* 104 */         sendResult(3, 0, 0);
/* 105 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 110 */       RoleInterface.cutSilver(this.roleId, needSilver, logArg);
/* 111 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_SILVE, Integer.valueOf(-1 * (int)needSilver));
/*     */       
/* 113 */       break;
/*     */     
/*     */     case 2: 
/* 116 */       return false;
/*     */     
/*     */ 
/*     */     default: 
/* 120 */       return false;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 126 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, this.itemId, this.itemCount, logArg);
/* 127 */     if (!result.success())
/*     */     {
/* 129 */       sendResult(7, 0, 0);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     int addNumber = 0;
/* 134 */     for (ItemOperateResult.ChangeItemInfo c : result.getChangeItemInfoList())
/*     */     {
/* 136 */       addNumber += c.basicItem.getNumber();
/*     */     }
/* 138 */     if (addNumber != this.itemCount)
/*     */     {
/* 140 */       sendResult(7, 0, 0);
/* 141 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 145 */     sendResult(0, this.itemId, this.itemCount);
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkClientData()
/*     */   {
/* 151 */     if (this.clientGold != RoleInterface.getGold(this.roleId))
/*     */     {
/* 153 */       return false;
/*     */     }
/* 155 */     if (this.clientSilver != RoleInterface.getSilver(this.roleId))
/*     */     {
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   private void sendResult(int code, int itemid, int count)
/*     */   {
/* 165 */     STipRes sTipRes = new STipRes(code, itemid, count);
/* 166 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sTipRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\PBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */