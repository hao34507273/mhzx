/*     */ package mzm.gsp.mysteryshop.main;
/*     */ 
/*     */ import mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg;
/*     */ import mzm.gsp.mysteryshop.confbean.CSMysteryShopRefreshCostCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MysteryShopInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PRefreshMysteryShop
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int shoptype;
/*     */   private final int client_cost_type;
/*     */   private final long client_cost_num;
/*     */   
/*     */   public PRefreshMysteryShop(long roleid, int shoptype, int client_cost_type, long client_cost_num)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.shoptype = shoptype;
/*  29 */     this.client_cost_type = client_cost_type;
/*  30 */     this.client_cost_num = client_cost_num;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!MysteryShopManager.isMysteryShopSwitchOpenForRole(this.roleid))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!MysteryShopManager.isOpenForRoleLevel(this.roleid, this.shoptype))
/*     */     {
/*  44 */       String logStr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@role level can not operate mysteryshop|roleid=%d|shoptype=%d|rolelevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(RoleInterface.getLevel(this.roleid)) });
/*     */       
/*     */ 
/*  47 */       MysteryShopManager.logger.info(logStr);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!MysteryShopManager.isRoleStateCanOperateMall(this.roleid))
/*     */     {
/*  53 */       String logStr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@role state can not operate mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*     */       
/*     */ 
/*  56 */       MysteryShopManager.logger.info(logStr);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     String userid = RoleInterface.getUserId(this.roleid);
/*  61 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  63 */     MysteryShopInfo mysteryShopInfo = MysteryShopManager.getMysteryShopInfo(this.roleid, this.shoptype);
/*  64 */     if (mysteryShopInfo == null)
/*     */     {
/*  66 */       String logStr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@role have not mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*     */       
/*     */ 
/*  69 */       MysteryShopManager.logger.info(logStr);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     CSMysteryShopRefreshCostCfg cotsCfg = CSMysteryShopRefreshCostCfg.get(mysteryShopInfo.getRefresh_times() + 1);
/*     */     
/*     */ 
/*  76 */     long server_cost_num = MysteryShopManager.getLeftCurrencyValue(this.roleid, cotsCfg.moneyType);
/*  77 */     if ((this.client_cost_type != cotsCfg.moneyType) || (this.client_cost_num != server_cost_num))
/*     */     {
/*     */ 
/*  80 */       String logstr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@client cost is not same as server|userid=%s|roleid=%d|shoptype=%d|client_cost_type=%d|server_cost_type=%d|client_cost_num=%d|server_cost_num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(this.client_cost_type), Integer.valueOf(cotsCfg.moneyType), Long.valueOf(this.client_cost_num), Long.valueOf(server_cost_num) });
/*     */       
/*     */ 
/*  83 */       MysteryShopManager.logger.info(logstr);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     CSMysteryShopConstsCfg constsCfg = CSMysteryShopConstsCfg.get(this.shoptype);
/*  88 */     if (mysteryShopInfo.getRefresh_times() > constsCfg.DAILY_MAX_REFRESH_TIMES)
/*     */     {
/*  90 */       MysteryShopManager.sendWrongInfo(this.roleid, 3, new String[0]);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (cotsCfg.moneyNum > server_cost_num)
/*     */     {
/*  96 */       String logstr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@yuanbao not enough|userid=%s|roleid=%d|shoptype=%d|count=%d|costnum=%d|server_cost_num=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(mysteryShopInfo.getRefresh_times() + 1), Integer.valueOf(cotsCfg.moneyNum), Long.valueOf(server_cost_num) });
/*     */       
/*     */ 
/*  99 */       MysteryShopManager.logger.error(logstr);
/* 100 */       MysteryShopManager.sendWrongInfo(this.roleid, 2, new String[0]);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (!MysteryShopManager.refreshMysteryShop(this.roleid, mysteryShopInfo, this.shoptype))
/*     */     {
/* 106 */       String logStr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@refresh fail mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*     */       
/*     */ 
/* 109 */       MysteryShopManager.logger.error(logStr);
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     TLogArg logArg = MysteryShopManager.newTLogArg(cotsCfg.moneyType, 0);
/* 114 */     boolean ret = MysteryShopManager.costCurrencyValue(this.roleid, cotsCfg.moneyNum, cotsCfg.moneyType, logArg);
/* 115 */     if (!ret)
/*     */     {
/* 117 */       MysteryShopManager.sendWrongInfo(this.roleid, 2, new String[0]);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     MysteryShopManager.synMysteryShopInfo(this.roleid, this.shoptype);
/* 122 */     String logstr = String.format("[mysteryshop]PRefreshMysteryShop.processImp@refresh goods success|userid=%s|roleid=%d|shoptype=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*     */     
/*     */ 
/* 125 */     MysteryShopManager.logger.info(logstr);
/*     */     
/* 127 */     MysteryShopTLogManager.tlogMysteryShopRefresh(this.roleid, this.shoptype, cotsCfg.moneyType, cotsCfg.moneyNum, mysteryShopInfo);
/* 128 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\PRefreshMysteryShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */