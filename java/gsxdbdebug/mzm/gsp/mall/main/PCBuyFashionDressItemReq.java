/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mall.SBuyItemRes;
/*     */ import mzm.gsp.mall.confbean.PriceMaxbuynum;
/*     */ import mzm.gsp.mall.confbean.SMalltype2Item;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ 
/*     */ 
/*     */ public class PCBuyFashionDressItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemId;
/*     */   private final int itemCount;
/*     */   private final long clientYuanbao;
/*     */   
/*     */   public PCBuyFashionDressItemReq(long roleId, int itemId, int count, long clientyuanbao)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.itemId = itemId;
/*  38 */     this.itemCount = count;
/*  39 */     this.clientYuanbao = clientyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((this.itemId <= 0) || (this.itemCount <= 0))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!MallManager.isRoleStateCanOperateMall(this.roleId))
/*     */     {
/*  51 */       String logStr = String.format("[mall]PCBuyFashionDressItemReq.processImp@role state can not operate mall|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  53 */       MallManager.logger.info(logStr);
/*  54 */       return false;
/*     */     }
/*  56 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, this.itemId))
/*     */     {
/*  58 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemId));
/*  59 */       return false;
/*     */     }
/*  61 */     if (!OpenInterface.getOpenStatus(31))
/*     */     {
/*  63 */       GameServer.logger().info(String.format("[mall]PCBuyFashionDressItemReq.processImp@mall switch is close|role_id=%d|item_id=%d|item_count=%d|client_yuan_bao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.itemCount), Long.valueOf(this.clientYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     if (OpenInterface.isBanPlay(this.roleId, 31))
/*     */     {
/*  71 */       OpenInterface.sendBanPlayMsg(this.roleId, 31);
/*  72 */       GameServer.logger().info(String.format("[mall]PCBuyFashionDressItemReq.processImp@mall is ban play|role_id=%d|item_id=%d|item_count=%d|client_yuan_bao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.itemCount), Long.valueOf(this.clientYuanbao) }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     SMalltype2Item sMalltype2Item = SMalltype2Item.get(4);
/*  80 */     if (sMalltype2Item == null)
/*     */     {
/*  82 */       MallManager.sendWrongInfo(this.roleId, 3, new String[0]);
/*     */       
/*  84 */       String logstr = String.format("[mall]PCBuyFashionDressItemReq.processImp@mall fashion dress type item is null|role_id=%d|item_id=%d|item_count=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.itemCount) });
/*     */       
/*     */ 
/*  87 */       MallManager.logger.error(logstr);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     PriceMaxbuynum p = (PriceMaxbuynum)sMalltype2Item.itemid2pricenum.get(Integer.valueOf(this.itemId));
/*  92 */     if (p == null)
/*     */     {
/*  94 */       MallManager.sendWrongInfo(this.roleId, 3, new String[0]);
/*     */       
/*  96 */       String logstr = String.format("[mall]PCBuyFashionDressItemReq.processImp@item price error|role_id=%d|item_id=%d|item_count=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.itemCount) });
/*     */       
/*     */ 
/*  99 */       MallManager.logger.error(logstr);
/* 100 */       return false;
/*     */     }
/* 102 */     int price = p.price;
/*     */     
/* 104 */     String userId = RoleInterface.getUserId(this.roleId);
/* 105 */     long nowYuanBaoNum = QingfuInterface.getBalance(userId, true);
/* 106 */     if (this.clientYuanbao != nowYuanBaoNum)
/*     */     {
/* 108 */       String logstr = String.format("[mall]PCBuyFashionDressItemReq.processImp@client yuanbao is not same as server|user_id=%s|role_id=%d|item_id=%d|price=%d|client_yuan_bao=%d|server_yuan_bao=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(price), Long.valueOf(this.clientYuanbao), Long.valueOf(nowYuanBaoNum) });
/*     */       
/*     */ 
/* 111 */       MallManager.logger.info(logstr);
/*     */       
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     int maxCount = ItemInterface.getPileMaxCount(this.itemId);
/* 117 */     if (this.itemCount > maxCount)
/*     */     {
/* 119 */       String logstr = String.format("[mall]PCBuyFashionDressItemReq.processImp@buy count more than pile num|user_id=%s|role_id=%d|item_id=%d|price=%d|item_count=%d|max_count=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(price), Integer.valueOf(this.itemCount), Integer.valueOf(maxCount) });
/*     */       
/*     */ 
/* 122 */       MallManager.logger.info(logstr);
/*     */       
/* 124 */       MallManager.sendWrongInfo(this.roleId, 4, new String[0]);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     int needYuanBaoNum = price * this.itemCount;
/* 129 */     if (needYuanBaoNum > nowYuanBaoNum)
/*     */     {
/* 131 */       String logstr = String.format("[mall]PCBuyFashionDressItemReq.processImp@yuanbao not enough|user_id=%s|role_id=%d|item_id=%d|item_count=%d|price=%d|need_yuan_bao=%d|has_yuan_bao=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.itemCount), Integer.valueOf(price), Integer.valueOf(needYuanBaoNum), Long.valueOf(nowYuanBaoNum) });
/*     */       
/*     */ 
/* 134 */       MallManager.logger.error(logstr);
/*     */       
/* 136 */       MallManager.sendWrongInfo(this.roleId, 1, new String[0]);
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     long nowBindYuanBaoNum = QingfuInterface.getBindYuanbao(userId, true);
/* 142 */     boolean itemIsBind = nowBindYuanBaoNum > 0L;
/*     */     
/* 144 */     List<Item> xItemList = ItemInterface.createXItem(this.itemId, this.itemCount, null, itemIsBind);
/*     */     
/* 146 */     TLogArg logArg = new TLogArg(LogReason.FASHION_DRESS_MALL, this.itemId);
/* 147 */     logArg.addItem2num(this.itemId, this.itemCount);
/* 148 */     MallManager.fillCurrencyData(userId, this.roleId, logArg, needYuanBaoNum);
/*     */     
/* 150 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, xItemList, true, logArg);
/* 151 */     if (result.isBagFull())
/*     */     {
/* 153 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleId, result.getFullBagId());
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     int addcount = result.getItemChangeNum(this.itemId);
/* 158 */     if ((!result.success()) || (addcount <= 0) || (addcount != this.itemCount))
/*     */     {
/* 160 */       String logstr = String.format("[mall]PCBuyFashionDressItemReq.processImp@buy item failed,bagfull or item to carry max|user_id=%s|role_id=%d|item_id=%d|price=%d|need_yuan_bao=%d|num=%d|add_num=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(price), Integer.valueOf(needYuanBaoNum), Integer.valueOf(this.itemCount), Integer.valueOf(addcount) });
/*     */       
/*     */ 
/* 163 */       MallManager.logger.error(logstr);
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     boolean ret = QingfuInterface.costYuanbao(userId, this.roleId, needYuanBaoNum, CostType.COST_BIND_FIRST_MALL_BUY_FASHION_DRESS_ITEM, logArg) == CostResult.Success;
/*     */     
/* 169 */     if (!ret)
/*     */     {
/* 171 */       MallManager.sendWrongInfo(this.roleId, 1, new String[0]);
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     SBuyItemRes buyItemRes = new SBuyItemRes();
/* 176 */     buyItemRes.malltype = 4;
/* 177 */     buyItemRes.buynum = addcount;
/* 178 */     buyItemRes.itemid = this.itemId;
/* 179 */     OnlineManager.getInstance().send(this.roleId, buyItemRes);
/*     */     
/* 181 */     if (result.success())
/*     */     {
/* 183 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@buy item success|user_id=%s|role_id=%d|item_id=%d|price=%d|need_yuan_bao=%d|item_count=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(price), Integer.valueOf(needYuanBaoNum), Integer.valueOf(this.itemCount) });
/*     */       
/*     */ 
/*     */ 
/* 187 */       MallManager.logger.info(logstr);
/*     */     }
/* 189 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PCBuyFashionDressItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */