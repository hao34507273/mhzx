/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ 
/*     */ public class PSearchPetEquipReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final mzm.gsp.market.PetEquipCondition condition;
/*     */   private final int pubOrSell;
/*     */   private final int priceSort;
/*     */   private final int pageIndex;
/*     */   private final long roleId;
/*     */   
/*     */   public PSearchPetEquipReq(long roleId, mzm.gsp.market.PetEquipCondition condition, int pubOrSell, int priceSort, int pageIndex)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.condition = condition;
/*  27 */     this.pubOrSell = pubOrSell;
/*  28 */     this.priceSort = priceSort;
/*  29 */     this.pageIndex = pageIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[marketsearch]PSearchPetEquipReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       MarketInterface.getLogger().info(logStr);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     String logStr = String.format("[marketsearch]PSearchPetEquipReq.processImp@receive search pet equip req|roleid=%d|subid=%d|property=%d|skillids=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString() });
/*     */     
/*     */ 
/*     */ 
/*  48 */     MarketInterface.getLogger().info(logStr);
/*     */     
/*  50 */     if ((this.condition.property == 0) && (this.condition.skillids.isEmpty()))
/*     */     {
/*  52 */       MarketInterface.sendCommonError(this.roleId, 23);
/*  53 */       return false;
/*     */     }
/*  55 */     Lockeys.lock(Role2marketinfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  56 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     if (!MarketInterface.isMarketSearchSwitchOpenForRole(this.roleId))
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     if (!MarketInterface.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.condition.subid))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.condition.subid);
/*  73 */     if (marketSubTypeCfg == null)
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     int state = 1;
/*  79 */     if (this.pubOrSell == 1)
/*     */     {
/*  81 */       state = 2;
/*     */     }
/*     */     else
/*     */     {
/*  85 */       state = 1;
/*     */     }
/*  87 */     PetEquipCondition c = MarketSearcherManager.getPetEquipConditionFromProtocol(this.condition);
/*  88 */     MarketTlogManager.tlogMarketsearch(this.roleId, SearchTypeEnum.PET_EQUIP.value, this.condition.subid, c, state);
/*  89 */     int size = PetEquipQueryCache.getInstance().getSize(this.condition.subid, c, state);
/*     */     
/*  91 */     if (size == -1)
/*     */     {
/*  93 */       if ((this.pageIndex == 0) && (!MarketSearcherManager.checkAndSetSearchTime(this.roleId)))
/*     */       {
/*  95 */         return false;
/*     */       }
/*  97 */       int ret = SearchTaskManager.getInstance().addTask(new SearchPetEquipProcedure(this.roleId, this.condition, this.pubOrSell, this.priceSort, this.pageIndex));
/*     */       
/*  99 */       if (0 != ret)
/*     */       {
/* 101 */         MarketInterface.sendCommonError(this.roleId, 18);
/* 102 */         String log = String.format("[marketsearch]PSearchPetEquipReq.processImp@search queue full|roleid=%d|tasknum=%d|subid=%d|property=%d|skillids=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ret), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString() });
/*     */         
/*     */ 
/*     */ 
/* 106 */         MarketInterface.getLogger().info(log);
/*     */         
/* 108 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 112 */       String log = String.format("[marketsearch]PSearchPetEquipReq.processImp@add search task into queue success|roleid=%d|tasknum=%d|subid=%d|property=%d|skillids=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ret), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString() });
/*     */       
/*     */ 
/*     */ 
/* 116 */       MarketInterface.getLogger().info(log);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 121 */       MarketSearcherManager.fillAndSendQueryPetEquipResult(this.roleId, this.pubOrSell, this.priceSort, this.condition, this.pageIndex);
/*     */       
/* 123 */       String log = String.format("[marketsearch]PSearchPetEquipReq.processImp@query from cache success|roleid=%d|tasknum=%d|subid=%d|property=%d|skillids=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString() });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 128 */       MarketInterface.getLogger().info(log);
/*     */     }
/*     */     
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   private static class SearchPetEquipProcedure
/*     */     extends SearchBaseProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final mzm.gsp.market.PetEquipCondition condition;
/*     */     private final int pubOrSell;
/*     */     private final int priceSort;
/*     */     private int pageIndex;
/*     */     
/*     */     public SearchPetEquipProcedure(long roleId, mzm.gsp.market.PetEquipCondition condition, int pubOrSell, int priceSort, int pageIndex)
/*     */     {
/* 145 */       this.roleId = roleId;
/* 146 */       this.priceSort = priceSort;
/* 147 */       this.condition = condition;
/* 148 */       this.pubOrSell = pubOrSell;
/* 149 */       this.pageIndex = pageIndex;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean search()
/*     */       throws Exception
/*     */     {
/* 156 */       int state = 1;
/* 157 */       if (this.pubOrSell == 1)
/*     */       {
/* 159 */         state = 2;
/*     */       }
/*     */       else
/*     */       {
/* 163 */         state = 1;
/*     */       }
/* 165 */       PetEquipCondition c = MarketSearcherManager.getPetEquipConditionFromProtocol(this.condition);
/*     */       
/* 167 */       PetEquipQueryCache.getInstance().buildByConditionFromIndex(this.condition.subid, c, state);
/*     */       
/* 169 */       MarketSearcherManager.fillAndSendQueryPetEquipResult(this.roleId, this.pubOrSell, this.priceSort, this.condition, this.pageIndex);
/* 170 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PSearchPetEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */