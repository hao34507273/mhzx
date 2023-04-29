/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mall.SBuyItemRes;
/*     */ import mzm.gsp.mall.event.BuyItem;
/*     */ import mzm.gsp.mall.event.BuyItemArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBuyPreciousItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int itemid;
/*     */   private int count;
/*     */   private long clientyuanbao;
/*     */   
/*     */   public PBuyPreciousItem(long roleid, int itemid, int count, long clientyuanbao)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.itemid = itemid;
/*  42 */     this.count = count;
/*  43 */     this.clientyuanbao = clientyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if ((this.itemid <= 0) || (this.count <= 0))
/*     */     {
/*  51 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@param error|roleid=%d|itemid=%d|count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count) });
/*     */       
/*  53 */       MallManager.logger.info(logstr);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!MallManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  59 */       String logStr = String.format("[mall]PBuyPreciousItem.processImp@role state can not operate mall|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  60 */       MallManager.logger.info(logStr);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, this.itemid))
/*     */     {
/*  66 */       ItemBanTrade.getInstance().sendTipToTole(this.roleid, ItemInterface.getItemName(this.itemid));
/*  67 */       return false;
/*     */     }
/*  69 */     if (!MallManager.isMallSwitchOpenForRole(this.roleid))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     int price = MallManager.getPreciousItemPrice(this.itemid);
/*  75 */     if (price == -1)
/*     */     {
/*  77 */       MallManager.sendWrongInfo(this.roleid, 3, new String[0]);
/*  78 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@item price error|roleid=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price) });
/*     */       
/*  80 */       MallManager.logger.error(logstr);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     String userid = RoleInterface.getUserId(this.roleid);
/*  86 */     long yuanbaoBalance = QingfuInterface.getBalance(userid, true);
/*  87 */     if (this.clientyuanbao != yuanbaoBalance)
/*     */     {
/*  89 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@client yuanbao is not same as server|userid=%s|roleid=%d|itemid=%d|price=%d|clientyuanbao=%d|serveryuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Long.valueOf(this.clientyuanbao), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/*  92 */       MallManager.logger.info(logstr);
/*  93 */       return false;
/*     */     }
/*  95 */     int maxcount = ItemInterface.getPileMaxCount(this.itemid);
/*  96 */     if (this.count > maxcount)
/*     */     {
/*  98 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@buy count more than pile num|userid=%s|roleid=%d|itemid=%d|price=%d|count=%d|maxcount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(this.count), Integer.valueOf(maxcount) });
/*     */       
/*     */ 
/* 101 */       MallManager.logger.info(logstr);
/* 102 */       MallManager.sendWrongInfo(this.roleid, 4, new String[0]);
/* 103 */       return false;
/*     */     }
/* 105 */     int yuanbaonum = price * this.count;
/* 106 */     if (yuanbaonum > yuanbaoBalance)
/*     */     {
/* 108 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@yuanbao not enough|userid=%s|roleid=%d|itemid=%d|count=%d|price=%d|needyuanbao=%d|hasyuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/* 111 */       MallManager.logger.error(logstr);
/* 112 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 113 */       return false;
/*     */     }
/* 115 */     List<Item> xItems = ItemInterface.createXItem(this.itemid, this.count, null, false);
/*     */     
/* 117 */     TLogArg logArg = new TLogArg(LogReason.PRECIOUS_MALL, this.itemid);
/* 118 */     logArg.addItem2num(this.itemid, this.count);
/* 119 */     MallManager.fillCurrencyData(userid, this.roleid, logArg, yuanbaonum);
/* 120 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, logArg);
/* 121 */     if (result.isBagFull())
/*     */     {
/* 123 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 124 */       return false;
/*     */     }
/* 126 */     int addcount = result.getItemChangeNum(this.itemid);
/* 127 */     if ((!result.success()) || (addcount <= 0) || (addcount != this.count))
/*     */     {
/* 129 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@buy item failed,bagfull or item to carry max|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d|addnum=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count), Integer.valueOf(addcount) });
/*     */       
/*     */ 
/* 132 */       MallManager.logger.error(logstr);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaonum, CostType.COST_BIND_FIRST_MALL_BUY_PRECIOUS_ITEM, logArg) == CostResult.Success;
/*     */     
/* 138 */     if (!ret)
/*     */     {
/* 140 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     SBuyItemRes buyItemRes = new SBuyItemRes();
/* 145 */     buyItemRes.malltype = 1;
/* 146 */     buyItemRes.buynum = addcount;
/* 147 */     buyItemRes.itemid = this.itemid;
/* 148 */     OnlineManager.getInstance().send(this.roleid, buyItemRes);
/*     */     
/* 150 */     if (result.success())
/*     */     {
/* 152 */       String logstr = String.format("[mall]PBuyPreciousItem.processImp@buy item success|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 155 */       MallManager.logger.info(logstr);
/*     */     }
/* 157 */     TriggerEventsManger.getInstance().triggerEvent(new BuyItem(), new BuyItemArg(this.roleid, this.itemid, addcount, price, 1));
/*     */     
/* 159 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PBuyPreciousItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */