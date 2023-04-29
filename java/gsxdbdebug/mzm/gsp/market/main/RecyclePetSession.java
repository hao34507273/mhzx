/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2marketids;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ 
/*     */ public class RecyclePetSession extends Session
/*     */ {
/*     */   public RecyclePetSession(long interval, long marketid)
/*     */   {
/*  18 */     super(interval, marketid);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  24 */     new RecyclePetSessionTimeOutPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */   private static class RecyclePetSessionTimeOutPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public RecyclePetSessionTimeOutPro(long marketId)
/*     */     {
/*  34 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  40 */       MarketPet xMarketPet = Marketpet.select(Long.valueOf(this.marketId));
/*  41 */       if (xMarketPet == null)
/*     */       {
/*  43 */         String logStr = String.format("[market]RecyclePetSessionTimeOutPro.processImp@ xbean.MarketPet get roleid null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  45 */         MarketManager.logger.error(logStr);
/*  46 */         return false;
/*     */       }
/*  48 */       long roleId = xMarketPet.getRoleid();
/*     */       
/*  50 */       xbean.RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(roleId));
/*  51 */       if (xRoleMarketInfo == null)
/*     */       {
/*  53 */         String logs = String.format("[market]RecyclePetSessionTimeOutPro.processImp@xRoleMarketInfo null|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*     */         
/*  55 */         MarketManager.logger.info(logs);
/*  56 */         return false;
/*     */       }
/*  58 */       long petLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketPet.getPet().getTemplateid());
/*  59 */       Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(petLockKey) }));
/*  60 */       Lockeys.lock(Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketPet.getChannel_id()) }));
/*  61 */       xMarketPet = Marketpet.get(Long.valueOf(this.marketId));
/*  62 */       if (xMarketPet == null)
/*     */       {
/*  64 */         String logStr = String.format("[market]RecyclePetSessionTimeOutPro.processImp@ xbean.MarketPet get null|marketId=%d|", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  66 */         MarketManager.logger.error(logStr);
/*  67 */         return false;
/*     */       }
/*  69 */       if (xMarketPet.getRoleid() != roleId)
/*     */       {
/*  71 */         String logStr = String.format("[market]RecyclePetSessionTimeOutPro.processImp@ xbean.MarketPet role error|marketId=%d|marketRoleId=%d|roleId=%d", new Object[] { Long.valueOf(this.marketId), Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(roleId) });
/*     */         
/*     */ 
/*  74 */         MarketManager.logger.error(logStr);
/*  75 */         return false;
/*     */       }
/*  77 */       if (xMarketPet.getState() != 2)
/*     */       {
/*  79 */         String logStr = String.format("[market]RecyclePetSessionTimeOutPro.processImp@ xbean.MarketPet state no sell|marketId=%d|marketRoleId=%d|roleId=%d|state=%d", new Object[] { Long.valueOf(this.marketId), Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(roleId), Integer.valueOf(xMarketPet.getState()) });
/*     */         
/*     */ 
/*  82 */         MarketManager.logger.error(logStr);
/*  83 */         return false;
/*     */       }
/*  85 */       xMarketPet.setState(4);
/*  86 */       xMarketPet.setConcern_role_num(0);
/*     */       
/*  88 */       int petCfgId = xMarketPet.getPet().getTemplateid();
/*  89 */       int subid = MarketManager.getSubidByPetId(petCfgId);
/*     */       
/*  91 */       if (subid != -1)
/*     */       {
/*  93 */         MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, xMarketPet.getPet().getTemplateid(), false, xMarketPet.toData());
/*     */       }
/*     */       
/*  96 */       MarketManager.logMarketBuyPet(0L, roleId, this.marketId, petCfgId, 1, xMarketPet.getPrice(), xMarketPet.getPet().getLevel(), mzm.gsp.pet.main.PetInterface.getPetScoreLevel(xMarketPet.getPet()), xMarketPet.getPet().getId(), DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/*     */ 
/* 100 */       MarketManager.addMarketTimeOutOrSelledPet(xRoleMarketInfo, this.marketId, xMarketPet);
/* 101 */       MarketManager.removeMarketIdFromPetChannel(petLockKey, this.marketId, xMarketPet.getChannel_id());
/*     */       
/* 103 */       Marketpet.remove(Long.valueOf(this.marketId));
/* 104 */       Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/* 105 */       MarketManager.sendSSyncSellPetNotify(roleId, this.marketId, petCfgId);
/*     */       
/* 107 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 109 */         LevelSiftRankManager.deleteSell(subid, this.marketId, xMarketPet.getPet().getLevel());
/*     */       }
/*     */       else
/*     */       {
/* 113 */         PriceRankManager.deleteSell(subid, this.marketId);
/*     */       }
/* 115 */       MarketItemPetPriceManager.removePrice(xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/* 116 */       String logStr = String.format("[market]RecyclePetSessionTimeOutPro.processImp@ market pet recycle|roleId=%d|marketId=%d|petCfgId=%d|price=%d", new Object[] { Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(petCfgId), Integer.valueOf(xMarketPet.getPrice()) });
/*     */       
/*     */ 
/* 119 */       MarketManager.logger.info(logStr);
/* 120 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\RecyclePetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */