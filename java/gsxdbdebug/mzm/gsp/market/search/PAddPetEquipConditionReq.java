/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.SAddPetEquipConditionRes;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CustommizedCons;
/*     */ import xbean.MarketPetEquipCon;
/*     */ import xbean.MarketPetEquipConSet;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2customized;
/*     */ 
/*     */ public class PAddPetEquipConditionReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final mzm.gsp.market.PetEquipCondition condition;
/*     */   private final long roleId;
/*     */   
/*     */   public PAddPetEquipConditionReq(long roleId, mzm.gsp.market.PetEquipCondition condition)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.condition = condition;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  40 */       String logStr = String.format("[marketcustomized]PAddPetEquipConditionReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       MarketInterface.getLogger().info(logStr);
/*  43 */       return false;
/*     */     }
/*  45 */     String userid = RoleInterface.getUserId(this.roleId);
/*  46 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  47 */     lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  49 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!MarketInterface.isMarketCustomizedSwitchOpenForRole(this.roleId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     if (!MarketInterface.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.condition.subid))
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!MarketInterface.isItemSubtype(this.condition.subid))
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.condition.subid);
/*  71 */     if (marketSubTypeCfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (this.condition.skillids.isEmpty())
/*     */     {
/*  77 */       MarketInterface.sendCommonError(this.roleId, 22);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     CustommizedCons xCustommizedCons = Role2customized.get(Long.valueOf(this.roleId));
/*  82 */     if (xCustommizedCons == null)
/*     */     {
/*  84 */       xCustommizedCons = Pod.newCustommizedCons();
/*  85 */       Role2customized.insert(Long.valueOf(this.roleId), xCustommizedCons);
/*     */     }
/*  87 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  88 */     CustomizedConditionManager.getInstance().removeRoleTimeOutConditions(xCustommizedCons, now);
/*  89 */     if (CustomizedConditionManager.getInstance().isCustomizedToMax(xCustommizedCons))
/*     */     {
/*  91 */       String log = String.format("[marketcustomized]PAddPetEquipConditionReq.processImp@customized condition to max|roleid=%d|subid=%d|property=%d|skillids=%s|maxnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString(), Integer.valueOf(SMarketConsts.getInstance().MAX_CUSTOMIZED_CONDITION_NUM) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  96 */       MarketInterface.getLogger().info(log);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_CUSTOMIZED, this.condition.subid);
/*     */     
/* 102 */     CostResult result = mzm.gsp.qingfu.main.QingfuInterface.costYuanbao(userid, this.roleId, SMarketConsts.getInstance().CUSTOMIZED_NEED_YUANBAO_NUM, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MARKET_CUSTOMIZED, logArg);
/*     */     
/* 104 */     if (result != CostResult.Success)
/*     */     {
/* 106 */       String log = String.format("[marketcustomized]PAddPetEquipConditionReq.processImp@cost yuanbao fialed|roleid=%d|subid=%d|property=%d|skillids=%s|cosetnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString(), Integer.valueOf(SMarketConsts.getInstance().CUSTOMIZED_NEED_YUANBAO_NUM) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 111 */       MarketInterface.getLogger().info(log);
/*     */       
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     MarketPetEquipCon xPetEquipCon = Pod.newMarketPetEquipCon();
/* 117 */     xPetEquipCon.setProperty(this.condition.property);
/*     */     
/* 119 */     xPetEquipCon.getSkillids().addAll(this.condition.skillids);
/* 120 */     xPetEquipCon.setCusttime(TimeUnit.MILLISECONDS.toSeconds(now));
/*     */     
/* 122 */     MarketPetEquipConSet xMarketPetEquipConSet = (MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(this.condition.subid));
/* 123 */     if (xMarketPetEquipConSet == null)
/*     */     {
/* 125 */       xMarketPetEquipConSet = Pod.newMarketPetEquipConSet();
/* 126 */       xCustommizedCons.getSubid2petequipcons().put(Integer.valueOf(this.condition.subid), xMarketPetEquipConSet);
/*     */     }
/* 128 */     PetEquipCondition c = MarketSearcherManager.getPetEquipConditionFromProtocol(this.condition);
/* 129 */     for (MarketPetEquipCon xMarketPetEquipCon : xMarketPetEquipConSet.getPetequipcons())
/*     */     {
/* 131 */       if (CustomizedConditionManager.getInstance().isSame(xMarketPetEquipCon, c))
/*     */       {
/* 133 */         String log = String.format("[marketcustomized]PAddPetEquipConditionReq.processImp@condition already exists|roleid=%d|subid=%d|property=%d|skillids=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.property), this.condition.skillids.toString() });
/*     */         
/*     */ 
/*     */ 
/* 137 */         MarketInterface.getLogger().info(log);
/*     */         
/* 139 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 143 */     xMarketPetEquipConSet.getPetequipcons().add(xPetEquipCon);
/*     */     
/* 145 */     SAddPetEquipConditionRes res = new SAddPetEquipConditionRes();
/* 146 */     res.condition = this.condition;
/* 147 */     res.condition.custtime = xPetEquipCon.getCusttime();
/* 148 */     res.index = xMarketPetEquipConSet.getPetequipcons().size();
/* 149 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 151 */     CustomizedConditionManager.getInstance().addPetEquipConditionRoleId(this.condition.subid, c, this.roleId);
/* 152 */     MarketTlogManager.tlogMarketcustomized(this.roleId, SearchTypeEnum.PET_EQUIP.value, this.condition.subid, c);
/* 153 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PAddPetEquipConditionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */