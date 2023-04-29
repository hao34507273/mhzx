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
/*     */ public class PBuyFunctionItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int itemid;
/*     */   private int count;
/*     */   private long clientyuanbao;
/*     */   
/*     */   public PBuyFunctionItem(long roleid, int itemid, int count, long clientyuanbao)
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
/*  51 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@param error|roleid=%d|itemid=%d|count=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count) });
/*     */       
/*  53 */       MallManager.logger.info(logstr);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!MallManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  58 */       String logStr = String.format("[mall]PBuyFunctionItem.processImp@role state can not operate mall|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  59 */       MallManager.logger.info(logStr);
/*  60 */       return false;
/*     */     }
/*  62 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MALL.value, this.itemid))
/*     */     {
/*  64 */       ItemBanTrade.getInstance().sendTipToTole(this.roleid, ItemInterface.getItemName(this.itemid));
/*  65 */       return false;
/*     */     }
/*  67 */     if (!MallManager.isMallSwitchOpenForRole(this.roleid))
/*     */     {
/*  69 */       return false;
/*     */     }
/*  71 */     int price = MallManager.getFunctionItemPrice(this.itemid);
/*  72 */     if (price == -1)
/*     */     {
/*  74 */       MallManager.sendWrongInfo(this.roleid, 3, new String[0]);
/*     */       
/*  76 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@item price error|roleid=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price) });
/*     */       
/*  78 */       MallManager.logger.error(logstr);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     String userid = RoleInterface.getUserId(this.roleid);
/*  84 */     long yuanbaoBalance = QingfuInterface.getBalance(userid, true);
/*  85 */     if (this.clientyuanbao != yuanbaoBalance)
/*     */     {
/*  87 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@client yuanbao is not same as server|userid=%s|roleid=%d|itemid=%d|price=%d|clientyuanbao=%d|serveryuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Long.valueOf(this.clientyuanbao), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/*  90 */       MallManager.logger.info(logstr);
/*  91 */       return false;
/*     */     }
/*  93 */     int maxcount = ItemInterface.getPileMaxCount(this.itemid);
/*  94 */     if (this.count > maxcount)
/*     */     {
/*  96 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@buy count more than pile num|userid=%s|roleid=%d|itemid=%d|price=%d|count=%d|maxcount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(this.count), Integer.valueOf(maxcount) });
/*     */       
/*     */ 
/*  99 */       MallManager.logger.info(logstr);
/* 100 */       MallManager.sendWrongInfo(this.roleid, 4, new String[0]);
/* 101 */       return false;
/*     */     }
/* 103 */     int yuanbaonum = price * this.count;
/* 104 */     if (yuanbaonum > yuanbaoBalance)
/*     */     {
/* 106 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@yuanbao not enough|userid=%s|roleid=%d|itemid=%d|count=%d|price=%d|needyuanbao=%d|hasyuanbao=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(this.count), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/* 109 */       MallManager.logger.error(logstr);
/* 110 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     List<Item> xItems = ItemInterface.createXItem(this.itemid, this.count, null, false);
/* 115 */     TLogArg logArg = new TLogArg(LogReason.FUNCTION_MALL, this.itemid);
/* 116 */     logArg.addItem2num(this.itemid, this.count);
/* 117 */     MallManager.fillCurrencyData(userid, this.roleid, logArg, yuanbaonum);
/* 118 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, logArg);
/* 119 */     if (result.isBagFull())
/*     */     {
/* 121 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 122 */       return false;
/*     */     }
/* 124 */     int addcount = result.getItemChangeNum(this.itemid);
/*     */     
/* 126 */     if ((!result.success()) || (addcount <= 0) || (addcount != this.count))
/*     */     {
/* 128 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@buy item failed,bagfull or item to carry max|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d|addnum=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count), Integer.valueOf(addcount) });
/*     */       
/*     */ 
/* 131 */       MallManager.logger.error(logstr);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaonum, CostType.COST_BIND_FIRST_MALL_BUY_FUNCTION_ITEM, logArg) == CostResult.Success;
/*     */     
/* 137 */     if (!ret)
/*     */     {
/* 139 */       MallManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     SBuyItemRes buyItemRes = new SBuyItemRes();
/* 144 */     buyItemRes.malltype = 3;
/* 145 */     buyItemRes.buynum = addcount;
/* 146 */     buyItemRes.itemid = this.itemid;
/* 147 */     OnlineManager.getInstance().send(this.roleid, buyItemRes);
/* 148 */     if (result.success())
/*     */     {
/* 150 */       String logstr = String.format("[mall]PBuyFunctionItem.processImp@buy item success|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(price), Integer.valueOf(yuanbaonum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 153 */       MallManager.logger.info(logstr);
/*     */     }
/* 155 */     TriggerEventsManger.getInstance().triggerEvent(new BuyItem(), new BuyItemArg(this.roleid, this.itemid, addcount, price, 3));
/*     */     
/* 157 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PBuyFunctionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */