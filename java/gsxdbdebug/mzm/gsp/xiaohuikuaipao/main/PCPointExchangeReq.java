/*     */ package mzm.gsp.xiaohuikuaipao.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.xiaohuikuaipao.SPointExchangeError;
/*     */ import mzm.gsp.xiaohuikuaipao.SPointExchangeRsp;
/*     */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoPointExchangeCfg;
/*     */ import xbean.Pod;
/*     */ import xbean.XiaoHuiKuaiPaoPointInfo;
/*     */ import xtable.Role2xiaohuikuaipaopointinfo;
/*     */ 
/*     */ public class PCPointExchangeReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int pointExchangeCfgId;
/*     */   final int count;
/*     */   
/*     */   public PCPointExchangeReq(long roleId, int pointExchangeCfgId, int count)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.pointExchangeCfgId = pointExchangeCfgId;
/*  32 */     this.count = count;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!OpenInterface.getOpenStatus(482))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1845, true))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (this.count <= 0)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     int activityId = XiaoHuiKuaiPaoManager.getCurrentActivityId();
/*  57 */     if (activityId <= 0)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     XiaoHuiKuaiPaoPointExchangeCfg pointExchangeCfg = XiaoHuiKuaiPaoPointExchangeCfg.get(this.pointExchangeCfgId);
/*  63 */     if (pointExchangeCfg == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  70 */     SPointExchangeError pointExchangeError = new SPointExchangeError();
/*  71 */     pointExchangeError.count = this.count;
/*     */     
/*     */ 
/*  74 */     long lastPointCount = MallInterface.getJifen(this.roleId, 8);
/*  75 */     long needPoint = pointExchangeCfg.pointCount * this.count;
/*  76 */     if (lastPointCount < needPoint)
/*     */     {
/*  78 */       pointExchangeError.errorcode = 1;
/*  79 */       OnlineManager.getInstance().sendAtOnce(this.roleId, pointExchangeError);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     SPointExchangeRsp pointExchangeRsp = new SPointExchangeRsp();
/*  84 */     pointExchangeRsp.pointexchangecfgid = this.pointExchangeCfgId;
/*  85 */     pointExchangeRsp.available = -1;
/*  86 */     pointExchangeRsp.count = this.count;
/*     */     
/*  88 */     int lastExchangeCount = -1;
/*  89 */     int currentExchangeCount = -1;
/*     */     
/*     */ 
/*  92 */     if (pointExchangeCfg.exchangeMaxCount != -1)
/*     */     {
/*  94 */       XiaoHuiKuaiPaoPointInfo xXiaoHuiKuaiPaoPointInfo = Role2xiaohuikuaipaopointinfo.get(Long.valueOf(this.roleId));
/*  95 */       if (xXiaoHuiKuaiPaoPointInfo == null)
/*     */       {
/*  97 */         xXiaoHuiKuaiPaoPointInfo = Pod.newXiaoHuiKuaiPaoPointInfo();
/*  98 */         Role2xiaohuikuaipaopointinfo.insert(Long.valueOf(this.roleId), xXiaoHuiKuaiPaoPointInfo);
/*     */       }
/*     */       
/* 101 */       if (xXiaoHuiKuaiPaoPointInfo.getCfgid2count().containsKey(Integer.valueOf(this.pointExchangeCfgId)))
/*     */       {
/* 103 */         lastExchangeCount = ((Integer)xXiaoHuiKuaiPaoPointInfo.getCfgid2count().get(Integer.valueOf(this.pointExchangeCfgId))).intValue();
/*     */       }
/*     */       else
/*     */       {
/* 107 */         lastExchangeCount = 0;
/*     */       }
/* 109 */       currentExchangeCount = lastExchangeCount + this.count;
/* 110 */       if (currentExchangeCount > pointExchangeCfg.exchangeMaxCount)
/*     */       {
/* 112 */         pointExchangeError.errorcode = 2;
/* 113 */         OnlineManager.getInstance().sendAtOnce(this.roleId, pointExchangeError);
/* 114 */         return false;
/*     */       }
/*     */       
/* 117 */       xXiaoHuiKuaiPaoPointInfo.getCfgid2count().put(Integer.valueOf(this.pointExchangeCfgId), Integer.valueOf(currentExchangeCount));
/* 118 */       pointExchangeRsp.available = (pointExchangeCfg.exchangeMaxCount - currentExchangeCount);
/*     */     }
/*     */     
/*     */ 
/* 122 */     JifenOperateResult jifenOperateResult = MallInterface.cutJifen(this.roleId, needPoint, 8, new TLogArg(LogReason.XIAO_HUI_KUAI_PAO_POINT_EXCHANGE));
/*     */     
/* 124 */     if (!jifenOperateResult.isSuccess())
/*     */     {
/* 126 */       pointExchangeError.errorcode = 1;
/* 127 */       OnlineManager.getInstance().sendAtOnce(this.roleId, pointExchangeError);
/* 128 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 133 */     AwardReason awardReason = new AwardReason(LogReason.XIAO_HUI_KUAI_PAO_POINT_EXCHANGE, this.pointExchangeCfgId);
/* 134 */     awardReason.setAwardItemBind(true);
/* 135 */     for (int i = 0; i < this.count; i++)
/*     */     {
/* 137 */       AwardModel awardModel = AwardInterface.awardFixAward(pointExchangeCfg.fixAwardId, userId, this.roleId, true, true, awardReason);
/*     */       
/* 139 */       if (awardModel == null)
/*     */       {
/* 141 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 145 */     pointExchangeRsp.pointcount = MallInterface.getJifen(this.roleId, 8);
/* 146 */     OnlineManager.getInstance().send(this.roleId, pointExchangeRsp);
/*     */     
/*     */ 
/* 149 */     XiaoHuiKuaiPaoTLogManager.tLogPointExchange(this.roleId, activityId, this.pointExchangeCfgId, this.count, lastPointCount, pointExchangeRsp.pointcount, lastExchangeCount, currentExchangeCount);
/*     */     
/*     */ 
/* 152 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PCPointExchangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */