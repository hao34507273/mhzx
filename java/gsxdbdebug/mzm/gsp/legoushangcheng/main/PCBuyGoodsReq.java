/*     */ package mzm.gsp.legoushangcheng.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.legoushangcheng.SBuyGoodsError;
/*     */ import mzm.gsp.legoushangcheng.SBuyGoodsSuccess;
/*     */ import mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.main.WantedManager;
/*     */ import xbean.LeGouShangChengInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2legoushangchenginfo;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCBuyGoodsReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int cfgId;
/*     */   
/*     */   public PCBuyGoodsReq(long roleId, int cfgId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.cfgId = cfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!OpenInterface.getOpenStatus(435))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1732, false))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!LeGouShangChengManager.checkRoleLevelAndServerTime(this.roleId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     LeGouShangChengGoodsCfg leGouShangChengGoodsCfg = LeGouShangChengGoodsCfg.get(this.cfgId);
/*  58 */     if (leGouShangChengGoodsCfg == null)
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  64 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  66 */     LeGouShangChengInfo xLeGouShangChengInfo = Role2legoushangchenginfo.get(Long.valueOf(this.roleId));
/*  67 */     if (xLeGouShangChengInfo == null)
/*     */     {
/*  69 */       xLeGouShangChengInfo = Pod.newLeGouShangChengInfo();
/*  70 */       Role2legoushangchenginfo.insert(Long.valueOf(this.roleId), xLeGouShangChengInfo);
/*     */     }
/*     */     
/*  73 */     SBuyGoodsError buyGoodsError = new SBuyGoodsError();
/*  74 */     SBuyGoodsSuccess buyGoodsSuccess = new SBuyGoodsSuccess();
/*  75 */     buyGoodsSuccess.cfgid = this.cfgId;
/*  76 */     Map<Integer, Integer> cfgId2buyCount = xLeGouShangChengInfo.getCfgid2buycount();
/*     */     int buyCount;
/*     */     int buyCount;
/*  79 */     if (cfgId2buyCount.containsKey(Integer.valueOf(this.cfgId)))
/*     */     {
/*  81 */       buyCount = ((Integer)cfgId2buyCount.get(Integer.valueOf(this.cfgId))).intValue();
/*     */     }
/*     */     else
/*     */     {
/*  85 */       buyCount = 0;
/*     */     }
/*  87 */     if (buyCount >= leGouShangChengGoodsCfg.buy_top_limit)
/*     */     {
/*  89 */       buyGoodsError.errorcode = 1;
/*  90 */       OnlineManager.getInstance().sendAtOnce(this.roleId, buyGoodsError);
/*  91 */       return false;
/*     */     }
/*     */     
/*     */     int price;
/*     */     int price;
/*  96 */     if (leGouShangChengGoodsCfg.isShowDiscount == 1)
/*     */     {
/*  98 */       price = leGouShangChengGoodsCfg.base_price * leGouShangChengGoodsCfg.sale_rate / 10000;
/*     */     }
/*     */     else
/*     */     {
/* 102 */       price = leGouShangChengGoodsCfg.base_price;
/*     */     }
/*     */     
/*     */ 
/* 106 */     boolean ret = WantedManager.checkMoneyForRole(userId, this.roleId, leGouShangChengGoodsCfg.cost_currency_type, price).booleanValue();
/* 107 */     if (!ret)
/*     */     {
/* 109 */       buyGoodsError.errorcode = 2;
/* 110 */       OnlineManager.getInstance().sendAtOnce(this.roleId, buyGoodsError);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     ret = WantedManager.cutMoney(userId, this.roleId, LogReason.LEGOUSHANGCHENG_BUY_GOODS, this.cfgId, leGouShangChengGoodsCfg.cost_currency_type, price, CostType.COST_BIND_FIRST_LEGOUSHANGCHENG_BUY_GOODS);
/*     */     
/* 117 */     if (!ret)
/*     */     {
/* 119 */       buyGoodsError.errorcode = 2;
/* 120 */       OnlineManager.getInstance().sendAtOnce(this.roleId, buyGoodsError);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     AwardModel awardModel = AwardInterface.awardFixAward(leGouShangChengGoodsCfg.fix_award_Id, userId, this.roleId, true, true, new AwardReason(LogReason.LEGOUSHANGCHENG_BUY_GOODS));
/*     */     
/* 127 */     if (awardModel == null)
/*     */     {
/* 129 */       buyGoodsError.errorcode = 3;
/* 130 */       OnlineManager.getInstance().sendAtOnce(this.roleId, buyGoodsError);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     xLeGouShangChengInfo.getCfgid2buycount().put(Integer.valueOf(this.cfgId), Integer.valueOf(buyCount + 1));
/* 136 */     buyGoodsSuccess.buycount = (buyCount + 1);
/* 137 */     OnlineManager.getInstance().send(this.roleId, buyGoodsSuccess);
/*     */     
/* 139 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\main\PCBuyGoodsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */