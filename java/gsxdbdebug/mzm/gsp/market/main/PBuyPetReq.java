/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2marketids;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PBuyPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketId;
/*     */   private int petCfgId;
/*     */   private int price;
/*     */   
/*     */   public PBuyPetReq(long roleId, long marketId, int petCfgId, int price)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.marketId = marketId;
/*  34 */     this.petCfgId = petCfgId;
/*  35 */     this.price = price;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[market]PBuyPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  44 */       MarketManager.logger.info(logStr);
/*  45 */       return false;
/*     */     }
/*  47 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_PET.value, this.petCfgId))
/*     */     {
/*  49 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, PetInterface.getPetName(this.petCfgId));
/*  50 */       return false;
/*     */     }
/*  52 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     String log = String.format("[market]PBuyPetReq.processImp@receive buy pet req|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/*  59 */     MarketManager.logger.info(log);
/*     */     
/*  61 */     if (this.price <= 0)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     int subid = MarketManager.getSubidByPetId(this.petCfgId);
/*  70 */     if (subid == -1)
/*     */     {
/*  72 */       MarketManager.sendCommonError(this.roleId, 8);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!MarketManager.isRoleLevelRight(RoleInterface.getLevel(this.roleId), subid))
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     Long sellerRoleId = Marketpet.selectRoleid(Long.valueOf(this.marketId));
/*  81 */     if (sellerRoleId == null)
/*     */     {
/*  83 */       MarketManager.sendCommonError(this.roleId, 8);
/*  84 */       return false;
/*     */     }
/*  86 */     Long channlel_id = Marketpet.selectChannel_id(Long.valueOf(this.marketId));
/*  87 */     if (channlel_id == null)
/*     */     {
/*  89 */       MarketManager.sendCommonError(this.roleId, 8);
/*  90 */       return false;
/*     */     }
/*  92 */     List<Long> roleidList = new ArrayList(2);
/*  93 */     roleidList.add(Long.valueOf(this.roleId));
/*  94 */     if (sellerRoleId.longValue() != 0L)
/*     */     {
/*  96 */       roleidList.add(sellerRoleId);
/*     */     }
/*  98 */     Lockeys.lock(Role2marketinfo.getTable(), roleidList);
/*     */     
/* 100 */     long petLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(this.petCfgId);
/* 101 */     Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(petLockKey) }));
/* 102 */     Lockeys.lock(Channel2marketids.getTable(), Arrays.asList(new Long[] { channlel_id }));
/*     */     
/* 104 */     MarketPet xMarketPet = Marketpet.get(Long.valueOf(this.marketId));
/* 105 */     if (xMarketPet == null)
/*     */     {
/* 107 */       MarketManager.sendCommonError(this.roleId, 10);
/* 108 */       return false;
/*     */     }
/* 110 */     if (xMarketPet.getChannel_id() != channlel_id.longValue())
/*     */     {
/* 112 */       MarketManager.sendCommonError(this.roleId, 8);
/* 113 */       return false;
/*     */     }
/* 115 */     if (xMarketPet.getRoleid() == this.roleId)
/*     */     {
/* 117 */       MarketManager.sendCommonError(this.roleId, 17);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (xMarketPet.getPrice() != this.price)
/*     */     {
/* 123 */       MarketManager.sendCommonError(this.roleId, 8);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (xMarketPet.getState() != 2)
/*     */     {
/* 129 */       MarketManager.sendCommonError(this.roleId, 8);
/* 130 */       return false;
/*     */     }
/* 132 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 133 */     if (MarketManager.isExpire(now, xMarketPet.getOnshelf_time()))
/*     */     {
/* 135 */       MarketManager.sendCommonError(this.roleId, 8);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if (xMarketPet.getPet().getTemplateid() != this.petCfgId)
/*     */     {
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_BUY, this.petCfgId);
/* 145 */     if (!RoleInterface.cutGoldIngot(this.roleId, this.price, logArg))
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     xMarketPet.setState(4);
/*     */     
/* 152 */     MarketManager.sendSBuyPetRes(this.roleId, this.marketId, this.petCfgId, this.price, this.price);
/* 153 */     if (sellerRoleId.longValue() != 0L)
/*     */     {
/* 155 */       MarketManager.sendSSyncSellPetNotify(sellerRoleId.longValue(), this.marketId, this.petCfgId);
/*     */     }
/*     */     
/* 158 */     boolean ret = MarketInterface.addPetToRole(this.roleId, xMarketPet.getPet(), TimeUnit.MILLISECONDS.toSeconds(now));
/* 159 */     if (!ret)
/*     */     {
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     MarketManager.logMarketBuyPet(this.roleId, sellerRoleId.longValue(), this.marketId, this.petCfgId, 1, this.price, xMarketPet.getPet().getLevel(), PetInterface.getPetScoreLevel(xMarketPet.getPet()), xMarketPet.getPet().getId(), now);
/*     */     
/*     */ 
/* 167 */     String logStr = String.format("[market]PBuyPetReq.processImp@buy pet success|roleid=%d|petCfgId=%d|num=%d|price=%d|marketId=%d|channel_id=%d|sellerRoleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Integer.valueOf(1), Integer.valueOf(this.price), Long.valueOf(this.marketId), channlel_id, sellerRoleId });
/*     */     
/*     */ 
/* 170 */     MarketManager.logger.info(logStr);
/*     */     
/* 172 */     Long sessionId = Marketpet2sessionid.get(Long.valueOf(this.marketId));
/*     */     
/* 174 */     if (sessionId != null)
/*     */     {
/* 176 */       Session.removeSession(sessionId.longValue());
/* 177 */       Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/*     */     }
/* 179 */     if (sellerRoleId.longValue() != 0L)
/*     */     {
/* 181 */       xbean.RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(sellerRoleId);
/* 182 */       if (xRoleMarketInfo == null)
/*     */       {
/* 184 */         String logs = String.format("[market]PBuyPetReq.processImp@xRoleMarketInfo null|roleid=%d|petCfgId=%d|price=%d|marketId=%d|channel_id=%d", new Object[] { sellerRoleId, Integer.valueOf(this.petCfgId), Integer.valueOf(this.price), Long.valueOf(this.marketId), channlel_id });
/*     */         
/*     */ 
/* 187 */         MarketManager.logger.info(logs);
/* 188 */         return false;
/*     */       }
/* 190 */       MarketManager.addMarketTimeOutOrSelledPet(xRoleMarketInfo, this.marketId, xMarketPet);
/*     */     }
/*     */     
/* 193 */     MarketManager.removeMarketIdFromPetChannel(petLockKey, this.marketId, channlel_id.longValue());
/* 194 */     Marketpet.remove(Long.valueOf(this.marketId));
/*     */     
/* 196 */     if (MarketManager.isLevelSift(subid))
/*     */     {
/* 198 */       LevelSiftRankManager.deleteSell(subid, this.marketId, xMarketPet.getPet().getLevel());
/*     */     }
/*     */     else
/*     */     {
/* 202 */       PriceRankManager.deleteSell(subid, this.marketId);
/*     */     }
/* 204 */     MarketItemPetPriceManager.removePrice(xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/* 205 */     MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, this.petCfgId, false, xMarketPet.toData());
/* 206 */     MarketInterface.triggerBuyPetEvent(this.roleId, xMarketPet.getPet().getId(), xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/*     */     
/* 208 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PBuyPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */