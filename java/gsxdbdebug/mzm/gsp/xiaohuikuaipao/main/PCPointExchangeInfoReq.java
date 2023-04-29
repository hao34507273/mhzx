/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.xiaohuikuaipao.SPointExchangeInfoRsp;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoPointExchangeCfg;
/*    */ import xbean.XiaoHuiKuaiPaoPointInfo;
/*    */ import xtable.Role2xiaohuikuaipaopointinfo;
/*    */ 
/*    */ public class PCPointExchangeInfoReq extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCPointExchangeInfoReq(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(482))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1846, true))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     int activityId = XiaoHuiKuaiPaoManager.getCurrentActivityId();
/* 42 */     if (activityId <= 0)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     SPointExchangeInfoRsp pointExchangeInfoRsp = new SPointExchangeInfoRsp();
/* 48 */     pointExchangeInfoRsp.pointcount = MallInterface.getJifen(this.roleId, 8);
/*    */     
/* 50 */     XiaoHuiKuaiPaoPointInfo xXiaoHuiKuaiPaoPointInfo = Role2xiaohuikuaipaopointinfo.get(Long.valueOf(this.roleId));
/* 51 */     if (xXiaoHuiKuaiPaoPointInfo == null)
/*    */     {
/* 53 */       OnlineManager.getInstance().send(this.roleId, pointExchangeInfoRsp);
/* 54 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 59 */     for (Map.Entry<Integer, Integer> entry : xXiaoHuiKuaiPaoPointInfo.getCfgid2count().entrySet())
/*    */     {
/* 61 */       int cfgId = ((Integer)entry.getKey()).intValue();
/* 62 */       XiaoHuiKuaiPaoPointExchangeCfg xiaoHuiKuaiPaoPointExchangeCfg = XiaoHuiKuaiPaoPointExchangeCfg.get(cfgId);
/* 63 */       if ((xiaoHuiKuaiPaoPointExchangeCfg != null) && (xiaoHuiKuaiPaoPointExchangeCfg.exchangeMaxCount != -1))
/*    */       {
/*    */ 
/*    */ 
/* 67 */         pointExchangeInfoRsp.cfgid2available.put(Integer.valueOf(cfgId), Integer.valueOf(xiaoHuiKuaiPaoPointExchangeCfg.exchangeMaxCount - ((Integer)entry.getValue()).intValue()));
/*    */       }
/*    */     }
/* 70 */     OnlineManager.getInstance().send(this.roleId, pointExchangeInfoRsp);
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PCPointExchangeInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */