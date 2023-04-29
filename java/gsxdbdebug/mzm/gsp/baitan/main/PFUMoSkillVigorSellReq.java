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
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import mzm.gsp.effect.outfight.GenerateGoodsItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.main.EnchantSkill;
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
/*     */ public class PFUMoSkillVigorSellReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int skillBagId;
/*     */   private int skillId;
/*     */   private int price;
/*     */   private int num;
/*     */   
/*     */   public PFUMoSkillVigorSellReq(long roleId, int skillBagId, int skillId, int price, int num)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.skillBagId = skillBagId;
/*  43 */     this.skillId = skillId;
/*  44 */     this.price = price;
/*  45 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     String log = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@receive sellitem req|roleid=%d|skillBagId=%d|skillid=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), Integer.valueOf(this.skillId), Integer.valueOf(this.price), Integer.valueOf(this.num) });
/*     */     
/*     */ 
/*  54 */     BaiTanManager.logger.info(log);
/*     */     
/*  56 */     if ((this.price <= 0) || (this.num <= 0))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/*  62 */     if (roleGrid == null)
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  68 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  70 */       BaiTanManager.logger.info(logStr);
/*  71 */       return false;
/*     */     }
/*  73 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  75 */       return false;
/*     */     }
/*  77 */     if (roleGrid.getShoppingid2channelid().size() >= roleGrid.getMaxgridnum())
/*     */     {
/*  79 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@baitan grid not enough|roleid=%d|gridnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleGrid.getShoppingid2channelid().size()) });
/*     */       
/*     */ 
/*  82 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     EnchantSkill skill = mzm.gsp.skill.main.SkillInterface.getEnchantSkill(this.roleId, this.skillBagId, this.skillId);
/*  88 */     if (skill == null)
/*     */     {
/*  90 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@role have no this skill|roleid=%d|skillBagId=%d|skill=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), Integer.valueOf(this.skillId) });
/*     */       
/*     */ 
/*  93 */       BaiTanManager.logger.error(logStr);
/*  94 */       return false;
/*     */     }
/*  96 */     List<OutFightEffect> effectList = skill.getEffectList(RoleInterface.getRoleOutFightObject(this.roleId));
/*  97 */     int itemId = -1;
/*  98 */     for (OutFightEffect effect : effectList)
/*     */     {
/* 100 */       if ((effect instanceof GenerateGoodsItem))
/*     */       {
/* 102 */         itemId = ((GenerateGoodsItem)effect).getItemId();
/* 103 */         break;
/*     */       }
/*     */     }
/* 106 */     if (itemId < 0)
/*     */     {
/* 108 */       return false;
/*     */     }
/* 110 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.BAITAN.value, itemId))
/*     */     {
/* 112 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(itemId));
/* 113 */       return false;
/*     */     }
/* 115 */     int subtype = BaiTanManager.getSubtypeidByItemid(itemId);
/* 116 */     if (subtype == -1)
/*     */     {
/* 118 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@subtype error|roleid=%d|itemid=%d|price=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId), Integer.valueOf(this.price), Integer.valueOf(subtype) });
/*     */       
/*     */ 
/* 121 */       BaiTanManager.logger.error(logStr);
/*     */       
/* 123 */       return false;
/*     */     }
/* 125 */     int needVigor = skill.getNeedVoigor(this.roleId);
/* 126 */     if (needVigor < 0)
/*     */     {
/* 128 */       return false;
/*     */     }
/* 130 */     if (RoleInterface.getVigor(this.roleId) < needVigor * this.num)
/*     */     {
/* 132 */       return false;
/*     */     }
/* 134 */     int newprice = BaiTanManager.checkAndModifyPrice(this.price, itemId);
/* 135 */     if (newprice <= 0)
/*     */     {
/* 137 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@baitan sell item price error|roleid=%d|itemid=%d|price=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId), Integer.valueOf(this.price), Integer.valueOf(newprice) });
/*     */       
/*     */ 
/* 140 */       BaiTanManager.logger.error(logStr);
/* 141 */       return false;
/*     */     }
/* 143 */     int needgridnum = BaiTanManager.getNeedGrid(itemId, this.num);
/* 144 */     if (roleGrid.getShoppingid2channelid().size() + needgridnum > roleGrid.getMaxgridnum())
/*     */     {
/* 146 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@baitan item grid not enough|roleid=%d|itemid=%d|needgrid=%d|hasgrid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId), Integer.valueOf(needgridnum), Integer.valueOf(roleGrid.getMaxgridnum() - roleGrid.getShoppingid2channelid().size()) });
/*     */       
/*     */ 
/* 149 */       BaiTanManager.logger.error(logStr);
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     int tax = BaiTanManager.computeNeedTaxSillver(newprice, itemId, this.num);
/* 154 */     if (tax <= 0)
/*     */     {
/* 156 */       String logStr = String.format("[baitan]PFUMoSkillVigorSellReq.processImp@baitan sell item tax error|roleid=%d|itemid=%d|tax=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId), Integer.valueOf(tax), Integer.valueOf(this.num) });
/*     */       
/*     */ 
/* 159 */       BaiTanManager.logger.error(logStr);
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     if (RoleInterface.getSilver(this.roleId) < tax)
/*     */     {
/* 165 */       SCommonResultRes res = new SCommonResultRes();
/* 166 */       res.res = 4;
/* 167 */       OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     int numpergrid = BaiTanManager.getCanShangjiaNumPerGrid(itemId);
/* 172 */     int restnum = this.num;
/* 173 */     int desitemid = itemId;
/* 174 */     while (restnum > 0)
/*     */     {
/*     */ 
/* 177 */       int addnum = Math.min(restnum, numpergrid);
/* 178 */       new SellFumoItem(this.roleId, desitemid, newprice, addnum, needVigor).execute();
/* 179 */       restnum -= addnum;
/*     */     }
/*     */     
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SellFumoItem
/*     */     extends LogicProcedure
/*     */   {
/*     */     private long roleId;
/*     */     private int desitemid;
/*     */     private int newprice;
/*     */     private int addnum;
/*     */     private int needVigor;
/*     */     
/*     */     public SellFumoItem(long roleid, int desitemid, int newprice, int addnum, int needVigor)
/*     */     {
/* 197 */       this.roleId = roleid;
/* 198 */       this.desitemid = desitemid;
/* 199 */       this.newprice = newprice;
/* 200 */       this.addnum = addnum;
/* 201 */       this.needVigor = needVigor;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 208 */       Lockeys.lock(Role2grid.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 209 */       RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 210 */       if (roleGrid == null)
/*     */       {
/* 212 */         return false;
/*     */       }
/* 214 */       int needgridnum = BaiTanManager.getNeedGrid(this.desitemid, this.addnum);
/* 215 */       if (roleGrid.getShoppingid2channelid().size() + needgridnum > roleGrid.getMaxgridnum())
/*     */       {
/* 217 */         String logStr = String.format("[baitan]SellFumoItem.processImp@baitan item grid not enough|roleid=%d|itemid=%d|needgrid=%d|hasgrid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.desitemid), Integer.valueOf(needgridnum), Integer.valueOf(roleGrid.getMaxgridnum() - roleGrid.getShoppingid2channelid().size()) });
/*     */         
/*     */ 
/* 220 */         BaiTanManager.logger.error(logStr);
/* 221 */         return false;
/*     */       }
/* 223 */       long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.desitemid);
/* 224 */       Lockeys.lock(xtable.Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/* 225 */       int tax = BaiTanManager.computeNeedTaxSillver(this.newprice, this.desitemid, this.addnum);
/* 226 */       if (tax <= 0)
/*     */       {
/* 228 */         String logStr = String.format("[baitan]SellFumoItem.processImp@baitan sell item tax error|roleid=%d|itemid=%d|tax=%d|addnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.desitemid), Integer.valueOf(tax), Integer.valueOf(this.addnum) });
/*     */         
/*     */ 
/* 231 */         BaiTanManager.logger.error(logStr);
/* 232 */         return false;
/*     */       }
/* 234 */       TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.BAITAN_SHANGJIA_REM, this.desitemid);
/*     */       
/* 236 */       Channels xChannels = BaiTanManager.getChannelOnAdd(this.desitemid, this.newprice);
/* 237 */       ChannelShopingIdBean cs = BaiTanManager.findChannelShoppingBean(xChannels);
/* 238 */       if (cs == null)
/*     */       {
/* 240 */         String logStr = String.format("[baitan]SellFumoItem.processImp@find channelid and xbean.Shpoppingid error|roleid=%d|itemid=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.desitemid), Integer.valueOf(this.newprice) });
/*     */         
/*     */ 
/* 243 */         BaiTanManager.logger.error(logStr);
/* 244 */         return false;
/*     */       }
/*     */       
/* 247 */       if (!RoleInterface.cutSilver(this.roleId, tax, logArg))
/*     */       {
/* 249 */         SCommonResultRes res = new SCommonResultRes();
/* 250 */         res.res = 4;
/* 251 */         OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/* 252 */         return false;
/*     */       }
/* 254 */       int costvigor = this.needVigor * this.addnum;
/* 255 */       if (!RoleInterface.cutVigor(this.roleId, costvigor, logArg))
/*     */       {
/* 257 */         return false;
/*     */       }
/* 259 */       long channelid = cs.channelid;
/* 260 */       ShoppingIds shoppingIds = cs.xShoppingIds;
/*     */       
/* 262 */       List<Item> itemList = ItemInterface.createXItem(this.desitemid, this.addnum);
/* 263 */       if (itemList.size() != 1)
/*     */       {
/* 265 */         return false;
/*     */       }
/* 267 */       int recommendPrice = BaiTanManager.getItemRecommendPrice(this.desitemid);
/* 268 */       if (recommendPrice == -1)
/*     */       {
/* 270 */         String logStr = String.format("[baitan]SellFumoItem.processImp@recommendPrice error|roleid=%d|itemid=%d|recommendPrice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.desitemid), Integer.valueOf(recommendPrice) });
/*     */         
/*     */ 
/* 273 */         BaiTanManager.logger.error(logStr);
/* 274 */         return false;
/*     */       }
/* 276 */       boolean isLower = BaiTanManager.isLowerThanRecyclePrice(this.newprice, recommendPrice);
/* 277 */       boolean isNeedRecycle = false;
/* 278 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 279 */       long expireTime = 0L;
/* 280 */       long intervalMills = 0L;
/* 281 */       if (isLower)
/*     */       {
/* 283 */         intervalMills = BaiTanManager.computeRecycleInterval(this.newprice, recommendPrice);
/* 284 */         if (intervalMills < BaiTanManager.getBaitangItemInterval())
/*     */         {
/* 286 */           isNeedRecycle = true;
/* 287 */           expireTime = now + intervalMills;
/*     */         }
/*     */         else
/*     */         {
/* 291 */           isNeedRecycle = false;
/* 292 */           expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 297 */         isNeedRecycle = false;
/* 298 */         expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */       }
/*     */       
/* 301 */       long shoppingid = BaiTanManager.createShoppingInfo((Item)itemList.get(0), this.roleId, this.newprice, expireTime);
/*     */       
/* 303 */       boolean ret = shoppingIds.getShoppingids().add(Long.valueOf(shoppingid));
/* 304 */       if (!ret)
/*     */       {
/* 306 */         return false;
/*     */       }
/*     */       
/* 309 */       ret = BaiTanManager.addRoleShoppingChannel(this.roleId, shoppingid, channelid);
/* 310 */       if (!ret)
/*     */       {
/* 312 */         return false;
/*     */       }
/*     */       
/* 315 */       BaiTanManager.sendSSellItemRes(this.roleId, this.newprice, shoppingid, (Item)itemList.get(0));
/*     */       
/* 317 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.baitan.event.ShangJiaEvent(), new ShangJiaArg(this.roleId, this.desitemid, this.addnum, this.newprice));
/*     */       
/* 319 */       Shoppoingid2Sessionid shoppoingid2Sessionid = Role2shoppingsession.get(Long.valueOf(this.roleId));
/* 320 */       if (shoppoingid2Sessionid == null)
/*     */       {
/* 322 */         shoppoingid2Sessionid = xbean.Pod.newShoppoingid2Sessionid();
/* 323 */         Role2shoppingsession.insert(Long.valueOf(this.roleId), shoppoingid2Sessionid);
/*     */       }
/*     */       
/* 326 */       long lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/* 327 */       if (isNeedRecycle)
/*     */       {
/*     */ 
/* 330 */         BaiTanManager.startRecycleObserver(shoppoingid2Sessionid, this.roleId, shoppingid, intervalMills);
/* 331 */         roleGrid.getNeedrecycleshoppingids().add(Long.valueOf(shoppingid));
/* 332 */         lengthTime = TimeUnit.MILLISECONDS.toSeconds(intervalMills);
/*     */       }
/*     */       else
/*     */       {
/* 336 */         BaiTanManager.startObserver(shoppoingid2Sessionid, this.roleId, shoppingid, BaiTanManager.getBaitangItemInterval());
/* 337 */         lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */       }
/*     */       
/* 340 */       BaiTanManager.addItemGridnum(this.desitemid);
/* 341 */       BaiTanManager.tlogBaitan(this.roleId, this.desitemid, this.addnum, this.newprice, tax, costvigor, BaiTanOperateEnum.VIGOR);
/*     */       
/* 343 */       BaiTanManager.tlogBaitanSellForIdip(this.roleId, this.desitemid, this.addnum, this.newprice, ((Item)itemList.get(0)).getUuidAsData(), shoppingid, lengthTime, BaiTanOperateEnum.VIGOR.value);
/*     */       
/* 345 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PFUMoSkillVigorSellReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */