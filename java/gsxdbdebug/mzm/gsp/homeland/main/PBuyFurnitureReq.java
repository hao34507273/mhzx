/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SBuyFurnitureFailedRes;
/*     */ import mzm.gsp.homeland.SBuyFurnitureRes;
/*     */ import mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg;
/*     */ import mzm.gsp.homeland.event.BuyFurniture;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import mzm.gsp.util.UuidUtils.UuidType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xtable.Role2homeoperate;
/*     */ 
/*     */ public class PBuyFurnitureReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int furnitureId;
/*     */   private final int count;
/*     */   
/*     */   public PBuyFurnitureReq(long roleId, int furnitureId, int count)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.furnitureId = furnitureId;
/*  34 */     this.count = count;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.count <= 0) || (this.furnitureId <= 0))
/*     */     {
/*  42 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@param error|roleid=%d|furnitureid=%d|count=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.furnitureId), Integer.valueOf(this.count) });
/*     */       
/*  44 */       HomelandManager.logger.error(logString);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     SFurnitureBuyCountCfg sFurnitureBuyCountCfg = SFurnitureBuyCountCfg.get(this.furnitureId);
/*  49 */     if (sFurnitureBuyCountCfg == null)
/*     */     {
/*     */ 
/*  52 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@SFurnitureBuyCountCfg is not exists |roleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*  55 */       HomelandManager.logger.error(logString);
/*  56 */       return false;
/*     */     }
/*  58 */     if (this.count > sFurnitureBuyCountCfg.maxBuyNum)
/*     */     {
/*  60 */       HomelandManager.sendSCommonResultRes(this.roleId, 6);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  71 */       String logStr = String.format("[home]PBuyFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  72 */       HomelandManager.logger.info(logStr);
/*  73 */       return false;
/*     */     }
/*  75 */     String userid = RoleInterface.getUserId(this.roleId);
/*  76 */     if (userid == null)
/*     */     {
/*  78 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  79 */       HomelandManager.logger.error(logString);
/*  80 */       return false;
/*     */     }
/*  82 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  84 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  85 */     if (homeInfoWrapper == null)
/*     */     {
/*  87 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@xHomeInfo is null|roleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*  89 */       HomelandManager.logger.warn(logString);
/*  90 */       return false;
/*     */     }
/*  92 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  93 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  95 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  96 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  98 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*     */ 
/* 102 */       HomelandManager.logger.info(logString);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     HomeOperate xHomeOperate = Role2homeoperate.get(Long.valueOf(this.roleId));
/* 107 */     if (xHomeOperate == null)
/*     */     {
/* 109 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@xFurnitures null|roleId=%d|partnerRoleid=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/* 112 */       HomelandManager.logger.info(logString);
/* 113 */       return false;
/*     */     }
/* 115 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 116 */     if (!DateTimeUtils.isInSameDay(now, xHomeOperate.getUpdatetime()))
/*     */     {
/* 118 */       HomelandManager.sendSCommonResultRes(this.roleId, 7);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (!xHomeOperate.getCanbuyitem2num().containsKey(Integer.valueOf(this.furnitureId)))
/*     */     {
/* 124 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@furnitureId is not in can buy list |roleId=%d|partnerRoleid=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/* 127 */       HomelandManager.logger.info(logString);
/* 128 */       return false;
/*     */     }
/* 130 */     int restBuyNum = ((Integer)xHomeOperate.getCanbuyitem2num().get(Integer.valueOf(this.furnitureId))).intValue();
/* 131 */     if (restBuyNum < this.count)
/*     */     {
/* 133 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@rest furniture can buy num error|roleId=%d|partnerRoleid=%d|furnitureId=%d|restBuyNum=%d|count=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Integer.valueOf(restBuyNum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/* 136 */       HomelandManager.logger.info(logString);
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     Integer oldBuyNum = (Integer)xHomeOperate.getItem2buynum().get(Integer.valueOf(this.furnitureId));
/* 141 */     if (oldBuyNum == null)
/*     */     {
/* 143 */       oldBuyNum = Integer.valueOf(0);
/*     */     }
/* 145 */     if (oldBuyNum.intValue() + this.count > sFurnitureBuyCountCfg.maxBuyNum)
/*     */     {
/* 147 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@can buy num error|roleId=%d|partnerRoleid=%d|furnitureId=%d|moneytype=%d|moneynum=%d|oldBuyNum=%d|maxBuyNum=%d|count=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyNum), oldBuyNum, Integer.valueOf(sFurnitureBuyCountCfg.maxBuyNum), Integer.valueOf(this.count) });
/*     */       
/*     */ 
/*     */ 
/* 151 */       HomelandManager.logger.info(logString);
/* 152 */       sendBuyFailedRes(oldBuyNum.intValue(), sFurnitureBuyCountCfg.maxBuyNum - oldBuyNum.intValue());
/* 153 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 157 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, mzm.gsp.tlog.LogReason.BUY_FURNITURE_ITEM, this.furnitureId, sFurnitureBuyCountCfg.buyMoneyType, sFurnitureBuyCountCfg.buyMoneyNum * this.count, CostType.COST_BIND_FIRST_BUY_FURNITURE);
/*     */     
/*     */ 
/* 160 */     if (!ret)
/*     */     {
/* 162 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@buy furniture failed cut money error|roleId=%d|partnerRoleid=%d|furnitureId=%d|moneytype=%d|moneynum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyNum) });
/*     */       
/*     */ 
/*     */ 
/* 166 */       HomelandManager.logger.error(logString);
/* 167 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 172 */     String logString = String.format("[home]PBuyFurnitureReq.processImp@buy furniture success|roleId=%d|partnerRoleid=%d|furnitureId=%d|moneytype=%d|moneynum=%d|oldBuyNum=%d|newBuyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyNum), oldBuyNum, Integer.valueOf(oldBuyNum.intValue() + this.count) });
/*     */     
/*     */ 
/*     */ 
/* 176 */     HomelandManager.logger.info(logString);
/*     */     
/* 178 */     xHomeOperate.getItem2buynum().put(Integer.valueOf(this.furnitureId), Integer.valueOf(oldBuyNum.intValue() + this.count));
/* 179 */     xHomeOperate.getCanbuyitem2num().put(Integer.valueOf(this.furnitureId), Integer.valueOf(restBuyNum - this.count));
/* 180 */     java.util.List<Long> uuids = UuidUtils.generateUuids(UuidUtils.UuidType.Item, this.count);
/*     */     
/* 182 */     boolean r = HomelandManager.addFurniture2Bag(this.furnitureId, uuids, xHomeOperate);
/* 183 */     if (!r)
/*     */     {
/* 185 */       String logString = String.format("[home]PBuyFurnitureReq.processImp@add furniture into bag error|roleId=%d|partnerRoleid=%d|uuids=%s|itemId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), uuids.toString(), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*     */ 
/* 189 */       HomelandManager.logger.error(logString);
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     TriggerEventsManger.getInstance().triggerEvent(new BuyFurniture(), new mzm.gsp.homeland.event.BuyFurnitureArg(this.roleId, this.furnitureId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 196 */     SBuyFurnitureRes res = new SBuyFurnitureRes();
/* 197 */     res.furnitureuuids.addAll(uuids);
/* 198 */     res.furnitureid = this.furnitureId;
/* 199 */     res.moneytype = sFurnitureBuyCountCfg.buyMoneyType;
/* 200 */     res.moneynum = sFurnitureBuyCountCfg.buyMoneyNum;
/* 201 */     res.buynum = (oldBuyNum.intValue() + this.count);
/* 202 */     res.restcanbuynum = (sFurnitureBuyCountCfg.maxBuyNum - res.buynum);
/* 203 */     res.restfreshnum = (restBuyNum - this.count);
/* 204 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 206 */     tlogBuyfurnitureitem(userid, roleLevel, this.furnitureId, this.count, res.buynum, res.restcanbuynum, sFurnitureBuyCountCfg, homeInfoWrapper.getxHomeInfo(), xHomeOperate, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 209 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogBuyfurnitureitem(String userid, int roleLevel, int furnitureId, int count, int buycount, int restbuycount, SFurnitureBuyCountCfg sFurnitureBuyCountCfg, HomeInfo xHomeInfo, HomeOperate xHomeOperate, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 217 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 218 */     int totalcount = HomelandManager.getTotalFurnitureCount(furnitureId, xHomeInfo, isOwner, xHomeOperate);
/* 219 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(furnitureId), Integer.valueOf(count), Integer.valueOf(totalcount), Integer.valueOf(buycount), Integer.valueOf(restbuycount), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.buyMoneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/*     */ 
/* 223 */     TLogManager.getInstance().addLog(userid, this.roleId, "Buyfurnitureitem", columnns);
/*     */   }
/*     */   
/*     */   private void sendBuyFailedRes(int oldBuyNum, int restcanbuynum)
/*     */   {
/* 228 */     SBuyFurnitureFailedRes failedRes = new SBuyFurnitureFailedRes();
/* 229 */     failedRes.buynum = oldBuyNum;
/* 230 */     failedRes.furnitureid = this.furnitureId;
/* 231 */     failedRes.restcanbuynum = restcanbuynum;
/* 232 */     OnlineManager.getInstance().sendAtOnce(this.roleId, failedRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PBuyFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */