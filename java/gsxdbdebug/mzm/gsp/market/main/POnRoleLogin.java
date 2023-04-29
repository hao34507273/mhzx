/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.market.SSynRoleOnShelfInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.Pet;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2marketids;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     new PSynMarketBanTrandeItemPetRes(((Long)this.arg).longValue()).execute();
/*  27 */     RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get((Long)this.arg);
/*  28 */     if (xRoleMarketInfo == null)
/*     */     {
/*  30 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  34 */     if (xRoleMarketInfo.getOnshelf_item_ids().size() + xRoleMarketInfo.getOnshelf_pet_ids().size() <= 0)
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  40 */     SSynRoleOnShelfInfo res = new SSynRoleOnShelfInfo();
/*     */     
/*  42 */     Set<Long> expireOrSelledIds = new HashSet();
/*  43 */     Set<Long> toMoveMarketItemids = new HashSet();
/*     */     
/*  45 */     for (Iterator i$ = xRoleMarketInfo.getOnshelf_item_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*  47 */       xbean.MarketItem xMarketItem = Marketitem.select(Long.valueOf(marketId));
/*  48 */       xbean.AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.select(Long.valueOf(marketId));
/*  49 */       if (xMarketItem == null)
/*     */       {
/*  51 */         expireOrSelledIds.add(Long.valueOf(marketId));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  57 */         if ((MarketManager.hasState(xMarketItem.getState(), 8)) || (xMarketItem.getRest_num() == 0) || (xMarketItem.getState() == 4) || ((!MarketManager.hasState(xMarketItem.getState(), 1)) && (MarketManager.isExpire(now, xMarketItem.getOnshelf_time()))))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */           toMoveMarketItemids.add(Long.valueOf(marketId));
/*     */         }
/*     */         
/*  66 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/*  67 */         MarketManager.fillProtocolMarketItem(marketItem, marketId, xMarketItem, xAuctionItemInfo);
/*  68 */         res.marketitemlist.add(marketItem);
/*     */       }
/*     */     }
/*     */     
/*  72 */     for (Iterator i$ = expireOrSelledIds.iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*  74 */       xbean.MarketItem xMarketItem = (xbean.MarketItem)xRoleMarketInfo.getMarketid2timeoutorselleditem().get(Long.valueOf(marketId));
/*     */       
/*  76 */       if (xMarketItem != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  81 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/*  82 */         MarketManager.fillProtocolMarketItem(marketItem, marketId, xMarketItem, null);
/*  83 */         res.marketitemlist.add(marketItem);
/*     */       } }
/*  85 */     for (Iterator i$ = toMoveMarketItemids.iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*  87 */       new ModifyRoleMarketItem(((Long)this.arg).longValue(), marketId).execute();
/*     */     }
/*     */     
/*  90 */     Set<Long> toMoveMarketPetids = new HashSet();
/*  91 */     expireOrSelledIds.clear();
/*  92 */     for (Iterator i$ = xRoleMarketInfo.getOnshelf_pet_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*  94 */       xbean.MarketPet xMarketPet = Marketpet.select(Long.valueOf(marketId));
/*  95 */       xbean.AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(marketId));
/*     */       
/*  97 */       if (xMarketPet == null)
/*     */       {
/*  99 */         expireOrSelledIds.add(Long.valueOf(marketId));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 105 */         if ((MarketManager.hasState(xMarketPet.getState(), 8)) || (MarketManager.hasState(xMarketPet.getState(), 4)) || ((!MarketManager.hasState(xMarketPet.getState(), 1)) && (MarketManager.isExpire(now, xMarketPet.getOnshelf_time()))))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 110 */           toMoveMarketPetids.add(Long.valueOf(marketId));
/*     */         }
/*     */         
/* 113 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/* 114 */         MarketManager.fillProtocolMarketPet(marketPet, marketId, xMarketPet, xAuctionPetInfo);
/* 115 */         res.marketpetlist.add(marketPet);
/*     */       }
/*     */     }
/*     */     
/* 119 */     for (Iterator i$ = expireOrSelledIds.iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/* 121 */       xbean.MarketPet xMarketPet = (xbean.MarketPet)xRoleMarketInfo.getMarketid2timeoutorselledpet().get(Long.valueOf(marketId));
/* 122 */       if (xMarketPet != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/* 129 */         MarketManager.fillProtocolMarketPet(marketPet, marketId, xMarketPet, null);
/* 130 */         res.marketpetlist.add(marketPet);
/*     */       } }
/* 132 */     for (Iterator i$ = toMoveMarketPetids.iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/* 134 */       new ModifyRoleMarketPet(((Long)this.arg).longValue(), marketId).execute();
/*     */     }
/*     */     
/* 137 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), res);
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   private static class ModifyRoleMarketItem
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long marketId;
/*     */     
/*     */     public ModifyRoleMarketItem(long roleid, long marketId)
/*     */     {
/* 149 */       this.roleid = roleid;
/* 150 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 156 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 157 */       RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleid));
/* 158 */       if (xRoleMarketInfo == null)
/*     */       {
/* 160 */         String logs = String.format("[market]ModifyRoleMarketItem.processImp@xRoleMarketInfo null|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 161 */         MarketManager.logger.error(logs);
/* 162 */         return false;
/*     */       }
/*     */       
/* 165 */       xbean.MarketItem xMarketItem = Marketitem.select(Long.valueOf(this.marketId));
/* 166 */       if (xMarketItem == null)
/*     */       {
/* 168 */         return false;
/*     */       }
/* 170 */       if ((!MarketManager.hasState(xMarketItem.getState(), 1)) && (MarketManager.isExpire(now, xMarketItem.getOnshelf_time())) && (xMarketItem.getRest_num() > 0))
/*     */       {
/*     */ 
/* 173 */         xMarketItem.setState(xMarketItem.getState() | 0x8);
/*     */       }
/*     */       
/* 176 */       if ((MarketManager.hasState(xMarketItem.getState(), 8)) || (xMarketItem.getRest_num() == 0) || (xMarketItem.getState() == 4))
/*     */       {
/*     */ 
/* 179 */         long itemLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketItem.getItem().getCfgid());
/* 180 */         Lockeys.lock(xtable.Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(itemLockKey) }));
/* 181 */         Lockeys.lock(Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketItem.getChannel_id()) }));
/*     */         
/* 183 */         MarketManager.removeMarketIdFromItemChannel(itemLockKey, this.marketId, xMarketItem.getChannel_id());
/* 184 */         MarketManager.addMarketTimeOutOrSelledItem(xRoleMarketInfo, this.marketId, xMarketItem);
/* 185 */         Marketitem.remove(Long.valueOf(this.marketId));
/*     */         
/* 187 */         int subid = MarketManager.getSubidByItemId(xMarketItem.getItem().getCfgid());
/* 188 */         if (MarketManager.isLevelSift(subid))
/*     */         {
/* 190 */           int level = mzm.gsp.item.main.ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 191 */           LevelSiftRankManager.deletePub(subid, this.marketId, level);
/* 192 */           LevelSiftRankManager.deleteSell(subid, this.marketId, level);
/*     */         }
/*     */         else
/*     */         {
/* 196 */           PriceRankManager.deletePub(subid, this.marketId);
/* 197 */           PriceRankManager.deleteSell(subid, this.marketId);
/*     */         }
/*     */         
/* 200 */         String logs = String.format("[market]ModifyRoleMarketItem.processImp@remove role market item on login|roleid=%d|itemId=%d|marketId=%d|state=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xMarketItem.getItem().getCfgid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(xMarketItem.getPrice()) });
/*     */         
/*     */ 
/* 203 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       
/*     */ 
/* 207 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ModifyRoleMarketPet
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final long marketId;
/*     */     
/*     */     public ModifyRoleMarketPet(long roleid, long marketId)
/*     */     {
/* 219 */       this.roleid = roleid;
/* 220 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 226 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 227 */       RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleid));
/* 228 */       if (xRoleMarketInfo == null)
/*     */       {
/* 230 */         String logs = String.format("[market]ModifyRoleMarketPet.processImp@xRoleMarketInfo null|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 231 */         MarketManager.logger.error(logs);
/* 232 */         return false;
/*     */       }
/*     */       
/* 235 */       xbean.MarketPet xMarketPet = Marketpet.select(Long.valueOf(this.marketId));
/* 236 */       if (xMarketPet == null)
/*     */       {
/* 238 */         return false;
/*     */       }
/* 240 */       if ((!MarketManager.hasState(xMarketPet.getState(), 1)) && (MarketManager.isExpire(now, xMarketPet.getOnshelf_time())))
/*     */       {
/*     */ 
/* 243 */         xMarketPet.setState(8);
/*     */       }
/* 245 */       if ((MarketManager.hasState(xMarketPet.getState(), 8)) || (xMarketPet.getState() == 4))
/*     */       {
/*     */ 
/* 248 */         long petLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketPet.getPet().getTemplateid());
/* 249 */         Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(petLockKey) }));
/* 250 */         Lockeys.lock(Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketPet.getChannel_id()) }));
/*     */         
/* 252 */         MarketManager.removeMarketIdFromPetChannel(petLockKey, this.marketId, xMarketPet.getChannel_id());
/* 253 */         MarketManager.addMarketTimeOutOrSelledPet(xRoleMarketInfo, this.marketId, xMarketPet);
/* 254 */         Marketpet.remove(Long.valueOf(this.marketId));
/*     */         
/* 256 */         int subid = MarketManager.getSubidByPetId(xMarketPet.getPet().getTemplateid());
/*     */         
/* 258 */         if (MarketManager.isLevelSift(subid))
/*     */         {
/*     */ 
/* 261 */           LevelSiftRankManager.deletePub(subid, this.marketId, xMarketPet.getPet().getLevel());
/* 262 */           LevelSiftRankManager.deleteSell(subid, this.marketId, xMarketPet.getPet().getLevel());
/*     */         }
/*     */         else
/*     */         {
/* 266 */           PriceRankManager.deletePub(subid, this.marketId);
/* 267 */           PriceRankManager.deleteSell(subid, this.marketId);
/*     */         }
/* 269 */         String logs = String.format("[market]ModifyRoleMarketPet.processImp@remove role market pet on login|roleid=%d|petCfgId=%d|marketId=%d|state=%d|price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), Integer.valueOf(xMarketPet.getPrice()) });
/*     */         
/*     */ 
/* 272 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       
/* 275 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */