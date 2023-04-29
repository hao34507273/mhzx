/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.SAddPetConditionRes;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CustommizedCons;
/*     */ import xbean.MarketPetCon;
/*     */ import xbean.MarketPetConSet;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2customized;
/*     */ 
/*     */ public class PAddPetConditionReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final mzm.gsp.market.PetCondition condition;
/*     */   private final long roleId;
/*     */   
/*     */   public PAddPetConditionReq(long roleId, mzm.gsp.market.PetCondition condition)
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
/*  40 */       String logStr = String.format("[marketcustomized]PAddPetConditionReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
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
/*  66 */     if (!MarketInterface.isPetSubtype(this.condition.subid))
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.condition.subid);
/*  71 */     if (marketSubTypeCfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */     if (this.condition.pettypes.isEmpty())
/*     */     {
/*  88 */       MarketInterface.sendCommonError(this.roleId, 21);
/*  89 */       return false;
/*     */     }
/*  91 */     if ((this.condition.skillids.isEmpty()) && (this.condition.skillnum < SMarketConsts.getInstance().MIN_PET_CUSTOMIZED_SKILL_NUM))
/*     */     {
/*  93 */       MarketInterface.sendCommonError(this.roleId, 21);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     CustommizedCons xCustommizedCons = Role2customized.get(Long.valueOf(this.roleId));
/*  98 */     if (xCustommizedCons == null)
/*     */     {
/* 100 */       xCustommizedCons = Pod.newCustommizedCons();
/* 101 */       Role2customized.insert(Long.valueOf(this.roleId), xCustommizedCons);
/*     */     }
/* 103 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 104 */     CustomizedConditionManager.getInstance().removeRoleTimeOutConditions(xCustommizedCons, now);
/* 105 */     if (CustomizedConditionManager.getInstance().isCustomizedToMax(xCustommizedCons))
/*     */     {
/* 107 */       String log = String.format("[marketcustomized]PAddPetConditionReq.processImp@customized condition to max|roleid=%d|subid=%d|pettypes=%s|skillids=%s|skillnum=%d|maxnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), this.condition.pettypes.toString(), this.condition.skillids.toString(), Integer.valueOf(this.condition.skillnum), Integer.valueOf(SMarketConsts.getInstance().MAX_CUSTOMIZED_CONDITION_NUM) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 112 */       MarketInterface.getLogger().info(log);
/*     */       
/* 114 */       return false;
/*     */     }
/* 116 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_CUSTOMIZED, this.condition.subid);
/*     */     
/* 118 */     CostResult result = mzm.gsp.qingfu.main.QingfuInterface.costYuanbao(userid, this.roleId, SMarketConsts.getInstance().CUSTOMIZED_NEED_YUANBAO_NUM, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MARKET_CUSTOMIZED, logArg);
/*     */     
/* 120 */     if (result != CostResult.Success)
/*     */     {
/* 122 */       String log = String.format("[marketcustomized]PAddPetConditionReq.processImp@cost yuanbao fialed|roleid=%d|subid=%d|pettypes=%s|skillids=%s|skillnum=%d|costnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), this.condition.pettypes.toString(), this.condition.skillids.toString(), Integer.valueOf(this.condition.skillnum), Integer.valueOf(SMarketConsts.getInstance().CUSTOMIZED_NEED_YUANBAO_NUM) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 127 */       MarketInterface.getLogger().info(log);
/*     */       
/* 129 */       return false;
/*     */     }
/* 131 */     MarketPetCon xPetCon = Pod.newMarketPetCon();
/* 132 */     xPetCon.setSkillnum(this.condition.skillnum);
/* 133 */     xPetCon.getQualitys().addAll(this.condition.qualitys);
/* 134 */     xPetCon.getPettypes().addAll(this.condition.pettypes);
/* 135 */     xPetCon.getSkillids().addAll(this.condition.skillids);
/* 136 */     xPetCon.setCusttime(TimeUnit.MILLISECONDS.toSeconds(now));
/* 137 */     MarketPetConSet xMarketPetConSet = (MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(this.condition.subid));
/* 138 */     if (xMarketPetConSet == null)
/*     */     {
/* 140 */       xMarketPetConSet = Pod.newMarketPetConSet();
/* 141 */       xCustommizedCons.getSubid2petcons().put(Integer.valueOf(this.condition.subid), xMarketPetConSet);
/*     */     }
/* 143 */     PetCondition c = MarketSearcherManager.getPetConditionFromProtocol(this.condition);
/* 144 */     for (MarketPetCon x : xMarketPetConSet.getPetcons())
/*     */     {
/* 146 */       if (CustomizedConditionManager.getInstance().isSame(x, c))
/*     */       {
/* 148 */         String log = String.format("[marketcustomized]PAddPetConditionReq.processImp@condition already exists|roleid=%d|subid=%d|pettypes=%s|skillids=%s|skillnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), this.condition.pettypes.toString(), this.condition.skillids.toString(), Integer.valueOf(this.condition.skillnum) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 153 */         MarketInterface.getLogger().info(log);
/*     */         
/* 155 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 159 */     xMarketPetConSet.getPetcons().add(xPetCon);
/*     */     
/* 161 */     SAddPetConditionRes res = new SAddPetConditionRes();
/* 162 */     res.condition = this.condition;
/* 163 */     res.condition.custtime = xPetCon.getCusttime();
/* 164 */     res.index = xMarketPetConSet.getPetcons().size();
/* 165 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 167 */     CustomizedConditionManager.getInstance().addPetConditionRoleId(this.condition.subid, c, this.roleId);
/* 168 */     MarketTlogManager.tlogMarketcustomized(this.roleId, SearchTypeEnum.PET.value, this.condition.subid, c);
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PAddPetConditionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */