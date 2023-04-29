/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.baitan.SCommonResultRes;
/*     */ import mzm.gsp.baitan.event.ShangJiaArg;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.lifeskill.main.LifeSkillBag;
/*     */ import mzm.gsp.lifeskill.main.LifeSkillInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Channels;
/*     */ import xbean.Item;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.ShoppingIds;
/*     */ import xbean.Shoppoingid2Sessionid;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2grid;
/*     */ import xtable.Role2shoppingsession;
/*     */ 
/*     */ public class PWuQIFuVigorSellReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int skillid;
/*     */   private int itemid;
/*     */   private int price;
/*     */   private int num;
/*     */   
/*     */   public PWuQIFuVigorSellReq(long roleId, int skillid, int itemId, int price, int num)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.skillid = skillid;
/*  42 */     this.itemid = itemId;
/*  43 */     this.price = price;
/*  44 */     this.num = num;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.BAITAN.value, this.itemid))
/*     */     {
/*  53 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemid));
/*  54 */       return false;
/*     */     }
/*  56 */     String log = String.format("[baitan]PWuQIFuVigorSellReq.processImp@receive sellitem req|roleid=%d|itemid=%d|skillid=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.skillid), Integer.valueOf(this.price), Integer.valueOf(this.num) });
/*     */     
/*     */ 
/*  59 */     BaiTanManager.logger.info(log);
/*     */     
/*  61 */     if ((this.price <= 0) || (this.num <= 0))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/*  67 */     if (roleGrid == null)
/*     */     {
/*  69 */       return false;
/*     */     }
/*  71 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  73 */       String logStr = String.format("[baitan]PWuQIFuVigorSellReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  75 */       BaiTanManager.logger.info(logStr);
/*  76 */       return false;
/*     */     }
/*  78 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  80 */       return false;
/*     */     }
/*  82 */     int subtype = BaiTanManager.getSubtypeidByItemid(this.itemid);
/*  83 */     if (subtype == -1)
/*     */     {
/*  85 */       String logStr = String.format("[baitan]PWuQIFuVigorSellReq.processImp@subtype error|roleid=%d|itemid=%d|price=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(subtype) });
/*     */       
/*     */ 
/*  88 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  90 */       return false;
/*     */     }
/*  92 */     if (roleGrid.getShoppingid2channelid().size() >= roleGrid.getMaxgridnum())
/*     */     {
/*  94 */       String logStr = String.format("[baitan]PWuQIFuVigorSellReq.processImp@baitan grid not enough|roleid=%d|gridnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleGrid.getShoppingid2channelid().size()) });
/*     */       
/*  96 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     LifeSkillBag<?> lifeSkillBag = LifeSkillInterface.getLifeSkill(this.roleId, this.skillid, this.itemid);
/* 102 */     if (lifeSkillBag == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     int needVigor = lifeSkillBag.getCostVigor();
/* 108 */     if (needVigor < 0)
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     if (RoleInterface.getVigor(this.roleId) < needVigor * this.num)
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     int newprice = BaiTanManager.checkAndModifyPrice(this.price, this.itemid);
/* 118 */     if (newprice <= 0)
/*     */     {
/* 120 */       String logStr = String.format("[baitan]PWuQIFuVigorSellReq.processImp@baitan sell item price error|roleid=%d|itemid=%d|price=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(newprice) });
/*     */       
/*     */ 
/* 123 */       BaiTanManager.logger.error(logStr);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     int needgridnum = BaiTanManager.getNeedGrid(this.itemid, this.num);
/* 128 */     if (roleGrid.getShoppingid2channelid().size() + needgridnum > roleGrid.getMaxgridnum())
/*     */     {
/* 130 */       String logStr = String.format("[baitan]PWuQIFuVigorSellReq.processImp@baitan item grid not enough|roleid=%d|itemid=%d|needgrid=%d|hasgrid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(needgridnum), Integer.valueOf(roleGrid.getMaxgridnum() - roleGrid.getShoppingid2channelid().size()) });
/*     */       
/*     */ 
/* 133 */       BaiTanManager.logger.error(logStr);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     int tax = BaiTanManager.computeNeedTaxSillver(newprice, this.itemid, this.num);
/* 138 */     if (tax <= 0)
/*     */     {
/* 140 */       String logStr = String.format("[baitan]PWuQIFuVigorSellReq.processImp@baitan sell item tax error|roleid=%d|itemid=%d|tax=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(tax), Integer.valueOf(this.num) });
/*     */       
/*     */ 
/* 143 */       BaiTanManager.logger.error(logStr);
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     if (RoleInterface.getSilver(this.roleId) < tax)
/*     */     {
/* 149 */       BaiTanManager.sendCommonError(this.roleId, 4);
/*     */       
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     int numpergrid = BaiTanManager.getCanShangjiaNumPerGrid(this.itemid);
/* 155 */     int restnum = this.num;
/* 156 */     while (restnum > 0)
/*     */     {
/*     */ 
/* 159 */       int addnum = Math.min(restnum, numpergrid);
/* 160 */       new SellWuqifuItem(this.roleId, this.itemid, newprice, addnum, needVigor).execute();
/* 161 */       restnum -= addnum;
/*     */     }
/*     */     
/* 164 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SellWuqifuItem
/*     */     extends LogicProcedure
/*     */   {
/*     */     private long roleId;
/*     */     private int itemid;
/*     */     private int newprice;
/*     */     private int addnum;
/*     */     private int needVigor;
/*     */     
/*     */     public SellWuqifuItem(long roleid, int itemid, int newprice, int addnum, int needVigor)
/*     */     {
/* 179 */       this.roleId = roleid;
/* 180 */       this.itemid = itemid;
/* 181 */       this.newprice = newprice;
/* 182 */       this.addnum = addnum;
/* 183 */       this.needVigor = needVigor;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 190 */       Lockeys.lock(Role2grid.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 191 */       RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 192 */       if (roleGrid == null)
/*     */       {
/* 194 */         return false;
/*     */       }
/* 196 */       int needgridnum = BaiTanManager.getNeedGrid(this.itemid, this.addnum);
/* 197 */       if (roleGrid.getShoppingid2channelid().size() + needgridnum > roleGrid.getMaxgridnum())
/*     */       {
/* 199 */         String logStr = String.format("[baitan]SellWuqifuItem.processImp@baitan item grid not enough|roleid=%d|itemid=%d|needgrid=%d|hasgrid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(needgridnum), Integer.valueOf(roleGrid.getMaxgridnum() - roleGrid.getShoppingid2channelid().size()) });
/*     */         
/*     */ 
/* 202 */         BaiTanManager.logger.error(logStr);
/* 203 */         return false;
/*     */       }
/* 205 */       long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemid);
/* 206 */       Lockeys.lock(xtable.Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */       
/* 208 */       int tax = BaiTanManager.computeNeedTaxSillver(this.newprice, this.itemid, this.addnum);
/* 209 */       if (tax <= 0)
/*     */       {
/* 211 */         String logStr = String.format("[baitan]SellWuqifuItem.processImp@baitan sell item tax error|roleid=%d|itemid=%d|tax=%d|addnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(tax), Integer.valueOf(this.addnum) });
/*     */         
/*     */ 
/* 214 */         BaiTanManager.logger.error(logStr);
/* 215 */         return false;
/*     */       }
/* 217 */       Channels xChannels = BaiTanManager.getChannelOnAdd(this.itemid, this.newprice);
/* 218 */       ChannelShopingIdBean cs = BaiTanManager.findChannelShoppingBean(xChannels);
/* 219 */       if (cs == null)
/*     */       {
/* 221 */         String logStr = String.format("[baitan]SellWuqifuItem.processImp@find channelid and xbean.Shpoppingid error|roleid=%d|itemid=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.newprice) });
/*     */         
/*     */ 
/* 224 */         BaiTanManager.logger.error(logStr);
/* 225 */         return false;
/*     */       }
/* 227 */       TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.BAITAN_SHANGJIA_REM, this.itemid);
/*     */       
/* 229 */       if (!RoleInterface.cutSilver(this.roleId, tax, logArg))
/*     */       {
/* 231 */         SCommonResultRes res = new SCommonResultRes();
/* 232 */         res.res = 4;
/* 233 */         OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/* 234 */         return false;
/*     */       }
/* 236 */       int costvigor = this.needVigor * this.addnum;
/* 237 */       if (!RoleInterface.cutVigor(this.roleId, costvigor, logArg))
/*     */       {
/* 239 */         return false;
/*     */       }
/*     */       
/* 242 */       long channelid = cs.channelid;
/* 243 */       ShoppingIds shoppingIds = cs.xShoppingIds;
/*     */       
/* 245 */       List<Item> itemList = ItemInterface.createXItem(this.itemid, this.addnum);
/* 246 */       if (itemList.size() != 1)
/*     */       {
/* 248 */         return false;
/*     */       }
/* 250 */       int recommendPrice = BaiTanManager.getItemRecommendPrice(this.itemid);
/* 251 */       if (recommendPrice == -1)
/*     */       {
/* 253 */         String logStr = String.format("[baitan]SellWuqifuItem.processImp@recommendPrice error|roleid=%d|itemid=%d|recommendPrice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(recommendPrice) });
/*     */         
/*     */ 
/* 256 */         BaiTanManager.logger.error(logStr);
/* 257 */         return false;
/*     */       }
/* 259 */       boolean isLower = BaiTanManager.isLowerThanRecyclePrice(this.newprice, recommendPrice);
/* 260 */       boolean isNeedRecycle = false;
/* 261 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 262 */       long expireTime = 0L;
/* 263 */       long intervalMills = 0L;
/* 264 */       if (isLower)
/*     */       {
/* 266 */         intervalMills = BaiTanManager.computeRecycleInterval(this.newprice, recommendPrice);
/* 267 */         if (intervalMills < BaiTanManager.getBaitangItemInterval())
/*     */         {
/* 269 */           isNeedRecycle = true;
/* 270 */           expireTime = now + intervalMills;
/*     */         }
/*     */         else
/*     */         {
/* 274 */           isNeedRecycle = false;
/* 275 */           expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 280 */         isNeedRecycle = false;
/* 281 */         expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */       }
/*     */       
/* 284 */       long shoppingid = BaiTanManager.createShoppingInfo((Item)itemList.get(0), this.roleId, this.newprice, expireTime);
/*     */       
/* 286 */       boolean ret = shoppingIds.getShoppingids().add(Long.valueOf(shoppingid));
/* 287 */       if (!ret)
/*     */       {
/* 289 */         return false;
/*     */       }
/*     */       
/* 292 */       ret = BaiTanManager.addRoleShoppingChannel(this.roleId, shoppingid, channelid);
/* 293 */       if (!ret)
/*     */       {
/* 295 */         return false;
/*     */       }
/*     */       
/* 298 */       BaiTanManager.sendSSellItemRes(this.roleId, this.newprice, shoppingid, (Item)itemList.get(0));
/*     */       
/* 300 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.baitan.event.ShangJiaEvent(), new ShangJiaArg(this.roleId, this.itemid, this.addnum, this.newprice));
/*     */       
/*     */ 
/* 303 */       Shoppoingid2Sessionid shoppoingid2Sessionid = Role2shoppingsession.get(Long.valueOf(this.roleId));
/* 304 */       if (shoppoingid2Sessionid == null)
/*     */       {
/* 306 */         shoppoingid2Sessionid = xbean.Pod.newShoppoingid2Sessionid();
/* 307 */         Role2shoppingsession.insert(Long.valueOf(this.roleId), shoppoingid2Sessionid);
/*     */       }
/* 309 */       long lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/* 310 */       if (isNeedRecycle)
/*     */       {
/*     */ 
/* 313 */         BaiTanManager.startRecycleObserver(shoppoingid2Sessionid, this.roleId, shoppingid, intervalMills);
/* 314 */         roleGrid.getNeedrecycleshoppingids().add(Long.valueOf(shoppingid));
/* 315 */         lengthTime = TimeUnit.MILLISECONDS.toSeconds(intervalMills);
/*     */       }
/*     */       else
/*     */       {
/* 319 */         BaiTanManager.startObserver(shoppoingid2Sessionid, this.roleId, shoppingid, BaiTanManager.getBaitangItemInterval());
/* 320 */         lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */       }
/*     */       
/* 323 */       BaiTanManager.addItemGridnum(this.itemid);
/* 324 */       BaiTanManager.tlogBaitan(this.roleId, this.itemid, this.addnum, this.newprice, tax, costvigor, BaiTanOperateEnum.VIGOR);
/* 325 */       BaiTanManager.tlogBaitanSellForIdip(this.roleId, this.itemid, this.addnum, this.newprice, ((Item)itemList.get(0)).getUuidAsData(), shoppingid, lengthTime, BaiTanOperateEnum.VIGOR.value);
/*     */       
/* 327 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PWuQIFuVigorSellReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */