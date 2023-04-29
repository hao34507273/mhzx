/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CBuyYaoCaiReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncGangYaoCaiNumChange;
/*    */ import mzm.gsp.gang.SYaoDianInfoRes;
/*    */ import mzm.gsp.gang.confbean.SGangYaoDianCfg;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.YaoDian;
/*    */ 
/*    */ public class PBuyYaoCaiReq extends GangProcedure<CBuyYaoCaiReq>
/*    */ {
/*    */   public PBuyYaoCaiReq(CBuyYaoCaiReq protocol)
/*    */   {
/* 18 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CBuyYaoCaiReq protocol)
/*    */   {
/* 24 */     xbean.GangMember xMember = xtable.Role2gangmember.get(Long.valueOf(roleId));
/* 25 */     if (xMember == null) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xMember.getGangid()));
/* 30 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     YaoDian xYaoDian = xGang.getYaodian();
/* 35 */     Integer removeNum = (Integer)xYaoDian.getYaocaimap().get(Integer.valueOf(protocol.itemid));
/* 36 */     if (removeNum == null) {
/* 37 */       SGangNormalResult result = new SGangNormalResult();
/* 38 */       result.result = 38;
/* 39 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 40 */       syncYaoDianInfo(xYaoDian);
/* 41 */       return false;
/*    */     }
/* 43 */     if (removeNum.intValue() == 0) {
/* 44 */       SGangNormalResult result = new SGangNormalResult();
/* 45 */       result.result = 34;
/* 46 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 47 */       syncYaoDianInfo(xYaoDian);
/* 48 */       return false;
/*    */     }
/* 50 */     SGangYaoDianCfg cfg = SGangYaoDianCfg.get(xYaoDian.getLevel());
/*    */     
/* 52 */     if (!mzm.gsp.role.main.RoleInterface.cutSilver(roleId, cfg.itemSilverPrice, new TLogArg(LogReason.GANG_BUY_YAOCAI_SILVER_REM))) {
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     if (!GangInterface.cutBangGong(roleId, cfg.itemBangGongPrice, new TLogArg(LogReason.GANG_BUY_YAOCAI_REM))) {
/* 57 */       return false;
/*    */     }
/* 59 */     ItemOperateResult itemReason = mzm.gsp.item.main.ItemInterface.addItem(roleId, protocol.itemid, 1, new TLogArg(LogReason.ITEM_GANG_YAODIAN_BUY_ADD, protocol.itemid));
/* 60 */     if (itemReason.isBagFull()) {
/* 61 */       SGangNormalResult sGangNormalResult = new SGangNormalResult();
/* 62 */       sGangNormalResult.result = 35;
/* 63 */       OnlineManager.getInstance().sendAtOnce(roleId, sGangNormalResult);
/* 64 */       return false;
/*    */     }
/* 66 */     if (!itemReason.success()) {
/* 67 */       return false;
/*    */     }
/* 69 */     xYaoDian.getYaocaimap().put(Integer.valueOf(protocol.itemid), Integer.valueOf(removeNum.intValue() - 1));
/* 70 */     SSyncGangYaoCaiNumChange sSyncGangYaoCaiNumChange = new SSyncGangYaoCaiNumChange();
/* 71 */     sSyncGangYaoCaiNumChange.yaocaimap.put(Integer.valueOf(protocol.itemid), Integer.valueOf(removeNum.intValue() - 1));
/* 72 */     OnlineManager.getInstance().send(roleId, sSyncGangYaoCaiNumChange);
/* 73 */     mzm.gsp.gang.SBuyYaoCaiRes res = new mzm.gsp.gang.SBuyYaoCaiRes();
/* 74 */     res.itemid = protocol.itemid;
/* 75 */     OnlineManager.getInstance().send(roleId, res);
/*    */     
/* 77 */     GangManager.logInfo("PBuyYaoCaiReq.processImp@gang buy yao cai success|roleid=%d|itemid=%d|canbuynum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(protocol.itemid), Integer.valueOf(removeNum.intValue() - 1) });
/* 78 */     return true;
/*    */   }
/*    */   
/*    */   public void syncYaoDianInfo(YaoDian xYaoDian) {
/* 82 */     SYaoDianInfoRes res = new SYaoDianInfoRes();
/* 83 */     GangManager.fillYaoDian(xYaoDian, res.yaodianinfo);
/* 84 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PBuyYaoCaiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */