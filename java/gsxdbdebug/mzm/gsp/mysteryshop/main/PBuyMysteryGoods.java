/*     */ package mzm.gsp.mysteryshop.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mall.event.BuyItem;
/*     */ import mzm.gsp.mall.event.BuyItemArg;
/*     */ import mzm.gsp.mysteryshop.SMysteryGoodsChangeInfo;
/*     */ import mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg;
/*     */ import mzm.gsp.mysteryshop.confbean.SMysteryShopGoodsCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MysteryGoodsInfo;
/*     */ import xbean.MysteryShopInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBuyMysteryGoods
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int shoptype;
/*     */   private final int goods_index;
/*     */   private final int goods_id;
/*     */   private final int count;
/*     */   private final int client_cost_type;
/*     */   private final long client_cost_num;
/*     */   
/*     */   public PBuyMysteryGoods(long roleid, int shoptype, int goods_index, int goods_id, int count, int client_cost_type, long client_cost_num)
/*     */   {
/*  43 */     this.roleid = roleid;
/*  44 */     this.shoptype = shoptype;
/*  45 */     this.goods_index = goods_index;
/*  46 */     this.goods_id = goods_id;
/*  47 */     this.count = count;
/*  48 */     this.client_cost_type = client_cost_type;
/*  49 */     this.client_cost_num = client_cost_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     if ((this.goods_index < 0) || (this.count <= 0))
/*     */     {
/*  59 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@param error|roleid=%d|shoptype=%d|goods_index=%d|goods_id=%d|count=%d|client_cost_type=%d|client_cost_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_index), Integer.valueOf(this.goods_id), Integer.valueOf(this.count), Integer.valueOf(this.client_cost_type), Long.valueOf(this.client_cost_num) });
/*     */       
/*     */ 
/*  62 */       MysteryShopManager.logger.info(logstr);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!MysteryShopManager.isMysteryShopSwitchOpenForRole(this.roleid))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!MysteryShopManager.isOpenForRoleLevel(this.roleid, this.shoptype))
/*     */     {
/*  73 */       String logStr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@role level can not operate mysteryshop|roleid=%d|shoptype=%d|rolelevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(RoleInterface.getLevel(this.roleid)) });
/*     */       
/*     */ 
/*  76 */       MysteryShopManager.logger.info(logStr);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!MysteryShopManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  82 */       String logStr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@role state can not operate mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*     */       
/*     */ 
/*  85 */       MysteryShopManager.logger.info(logStr);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     String userid = RoleInterface.getUserId(this.roleid);
/*  90 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  92 */     MysteryShopInfo mysteryShopInfo = MysteryShopManager.getMysteryShopInfo(this.roleid, this.shoptype);
/*  93 */     if (mysteryShopInfo == null)
/*     */     {
/*  95 */       String logStr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@role have not mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*     */       
/*     */ 
/*  98 */       MysteryShopManager.logger.info(logStr);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (this.goods_index >= mysteryShopInfo.getGoods_list().size())
/*     */     {
/* 104 */       String logStr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@mysteryshop goods_id error|roleid=%d|shoptype=%d|goods_index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_index) });
/*     */       
/*     */ 
/* 107 */       MysteryShopManager.logger.info(logStr);
/* 108 */       MysteryShopManager.sendWrongInfo(this.roleid, 4, new String[0]);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     MysteryGoodsInfo goodsInfo = (MysteryGoodsInfo)mysteryShopInfo.getGoods_list().get(this.goods_index);
/* 113 */     if (this.goods_id != goodsInfo.getGoods_id())
/*     */     {
/* 115 */       String logStr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@mysteryshop goods_id error|roleid=%d|shoptype=%d|goods_index=%d|client_goods_id=%d|server_goods_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_index), Integer.valueOf(this.goods_id), Integer.valueOf(goodsInfo.getGoods_id()) });
/*     */       
/*     */ 
/* 118 */       MysteryShopManager.logger.info(logStr);
/* 119 */       MysteryShopManager.sendWrongInfo(this.roleid, 4, new String[0]);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     int price = MysteryShopManager.getGoodsPrice(this.goods_id, goodsInfo.getSale());
/* 124 */     if (price <= 0)
/*     */     {
/* 126 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@item price error|roleid=%d|shoptype=%d|goods_id=%d|sale=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_id), Integer.valueOf(goodsInfo.getSale()), Integer.valueOf(price) });
/*     */       
/*     */ 
/* 129 */       MysteryShopManager.logger.error(logstr);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     SMysteryShopGoodsCfg goodsCfg = SMysteryShopGoodsCfg.get(this.goods_id);
/*     */     
/* 135 */     long server_cost_num = MysteryShopManager.getLeftCurrencyValue(this.roleid, goodsCfg.moneyType);
/* 136 */     if ((this.client_cost_type != goodsCfg.moneyType) || (this.client_cost_num != server_cost_num))
/*     */     {
/*     */ 
/* 139 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@client cost is not same as server|userid=%s|roleid=%d|shoptype=%d|goods_id=%d|price=%d|client_cost_type=%d|server_cost_type=%d|client_cost_num=%d|server_cost_num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_id), Integer.valueOf(price), Integer.valueOf(this.client_cost_type), Integer.valueOf(goodsCfg.moneyType), Long.valueOf(this.client_cost_num), Long.valueOf(server_cost_num) });
/*     */       
/*     */ 
/*     */ 
/* 143 */       MysteryShopManager.logger.info(logstr);
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     int maxBuycount = goodsCfg.maxbuynum;
/* 148 */     int hasbuycount = goodsInfo.getCount();
/* 149 */     if ((maxBuycount != -1) && (this.count + hasbuycount > maxBuycount))
/*     */     {
/*     */ 
/* 152 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@buy count error|userid=%s|roleid=%d|shoptype=%d|goods_id=%d|price=%d|buycount=%d|maxbuycount=%d|hasbuycount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_id), Integer.valueOf(price), Integer.valueOf(this.count), Integer.valueOf(maxBuycount), Integer.valueOf(hasbuycount) });
/*     */       
/*     */ 
/* 155 */       MysteryShopManager.logger.info(logstr);
/* 156 */       MysteryShopManager.sendWrongInfo(this.roleid, 5, new String[0]);
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     int costnum = price * this.count;
/* 161 */     if ((costnum <= 0) || (costnum > server_cost_num))
/*     */     {
/* 163 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@yuanbao not enough|userid=%s|roleid=%d|shoptype=%d|goods_id=%d|count=%d|price=%d|costnum=%d|server_cost_num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_id), Integer.valueOf(this.count), Integer.valueOf(price), Integer.valueOf(costnum), Long.valueOf(server_cost_num) });
/*     */       
/*     */ 
/* 166 */       MysteryShopManager.logger.error(logstr);
/* 167 */       MysteryShopManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 168 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 172 */     TLogArg logArg = MysteryShopManager.newTLogArg(goodsCfg.moneyType, this.goods_id);
/* 173 */     logArg.addItem2num(goodsCfg.itemId, this.count * goodsCfg.num);
/* 174 */     if (goodsCfg.moneyType == 1)
/*     */     {
/* 176 */       MysteryShopManager.fillCurrencyData(userid, this.roleid, logArg, costnum);
/*     */     }
/*     */     
/* 179 */     boolean ret = MysteryShopManager.costCurrencyValue(this.roleid, costnum, goodsCfg.moneyType, logArg);
/* 180 */     if (!ret)
/*     */     {
/* 182 */       MysteryShopManager.sendWrongInfo(this.roleid, 1, new String[0]);
/* 183 */       return false;
/*     */     }
/*     */     
/* 186 */     boolean is_bind = false;
/* 187 */     if (goodsCfg.is_bind == 1)
/*     */     {
/* 189 */       is_bind = true;
/*     */     }
/* 191 */     List<Item> xItems = ItemInterface.createXItem(goodsCfg.itemId, this.count * goodsCfg.num, null, is_bind);
/* 192 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, logArg);
/* 193 */     if (result.isBagFull())
/*     */     {
/* 195 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 196 */       return false;
/*     */     }
/* 198 */     int addcount = result.getItemChangeNum(goodsCfg.itemId);
/* 199 */     if ((!result.success()) || (addcount <= 0) || (addcount != this.count * goodsCfg.num))
/*     */     {
/* 201 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@buy item failed,bagfull or item to carry max|userid=%s|roleid=%d|itemid=%d|price=%d|needyuanbao=%d|num=%d|addnum=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(goodsCfg.itemId), Integer.valueOf(price), Integer.valueOf(costnum), Integer.valueOf(this.count * goodsCfg.num), Integer.valueOf(addcount) });
/*     */       
/*     */ 
/* 204 */       MysteryShopManager.logger.error(logstr);
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     goodsInfo.setCount(goodsInfo.getCount() + this.count);
/*     */     
/* 210 */     SMysteryGoodsChangeInfo ch = new SMysteryGoodsChangeInfo();
/* 211 */     ch.shoptype = this.shoptype;
/* 212 */     ch.goods_index = this.goods_index;
/* 213 */     ch.goods_id = this.goods_id;
/* 214 */     ch.count = goodsInfo.getCount();
/* 215 */     OnlineManager.getInstance().send(this.roleid, ch);
/*     */     
/* 217 */     if (result.success())
/*     */     {
/* 219 */       CSMysteryShopConstsCfg constsCfg = CSMysteryShopConstsCfg.get(this.shoptype);
/*     */       
/* 221 */       if (goodsInfo.getSale() <= constsCfg.BULLETIN_MIN_SALE * 1000.0D)
/*     */       {
/* 223 */         MysteryShopManager.sendBulletin(this.roleid, goodsInfo.getSale(), goodsCfg);
/*     */       }
/*     */       
/* 226 */       if (maxBuycount <= goodsInfo.getCount())
/*     */       {
/* 228 */         if (MysteryShopManager.checkAndUpdateFreeTimes(mysteryShopInfo, constsCfg))
/*     */         {
/*     */ 
/* 231 */           MysteryShopManager.synMysteryShopInfo(this.roleid, this.shoptype);
/*     */         }
/*     */       }
/*     */       
/* 235 */       String logstr = String.format("[mysteryshop]PBuyMysteryGoods.processImp@buy goods success|userid=%s|roleid=%d|shoptype=%d|goods_id=%d|price=%d|costnum=%d|num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.goods_id), Integer.valueOf(price), Integer.valueOf(costnum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 238 */       MysteryShopManager.logger.info(logstr);
/*     */       
/* 240 */       MysteryShopTLogManager.tlogMysteryShopBuyGoods(this.roleid, this.shoptype, goodsCfg.moneyType, costnum, this.count, goodsInfo);
/*     */       
/* 242 */       TriggerEventsManger.getInstance().triggerEvent(new BuyItem(), new BuyItemArg(this.roleid, goodsCfg.itemId, addcount, price, 5));
/*     */     }
/*     */     
/* 245 */     return result.success();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\PBuyMysteryGoods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */