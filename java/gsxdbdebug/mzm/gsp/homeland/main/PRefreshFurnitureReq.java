/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SSynRefreshFurnitureRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PRefreshFurnitureReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PRefreshFurnitureReq(long roleId)
/*     */   {
/*  20 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  29 */       return false;
/*     */     }
/*  31 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  33 */       String logStr = String.format("[home]PRefreshFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  35 */       HomelandManager.logger.info(logStr);
/*  36 */       return false;
/*     */     }
/*  38 */     String userid = RoleInterface.getUserId(this.roleId);
/*  39 */     if (userid == null)
/*     */     {
/*  41 */       String logString = String.format("[home]PRefreshFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  43 */       HomelandManager.logger.error(logString);
/*  44 */       return false;
/*     */     }
/*  46 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  48 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  49 */     if (homeInfoWrapper == null)
/*     */     {
/*  51 */       String logString = String.format("[home]PRefreshFurnitureReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  53 */       HomelandManager.logger.warn(logString);
/*     */       
/*  55 */       return false;
/*     */     }
/*  57 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  58 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  60 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  61 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  63 */       String logString = String.format("[home]PRefreshFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  67 */       HomelandManager.logger.info(logString);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*  72 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  73 */     HomelandManager.initHomeOperateCount(this.roleId, xHomeOperate, now);
/*  74 */     if (xHomeOperate.getDayrefreshcount() >= SHomelandCfgConsts.getInstance().FRESH_FURNITURE_MAX_COUNT)
/*     */     {
/*  76 */       String logString = String.format("[home]PRefreshFurnitureReq.processImp@fresh count to max |roleId=%d|partnerRoleid=%d|freshcount=%d|maxfreshcount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(xHomeOperate.getDayrefreshcount()), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_MAX_COUNT) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  81 */       HomelandManager.logger.info(logString);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, mzm.gsp.tlog.LogReason.FRAESH_FURNITURE, 0, SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_TYPE, SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_NUM, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_FRESH_FURNITURE);
/*     */     
/*     */ 
/*  88 */     if (!ret)
/*     */     {
/*  90 */       String logString = String.format("[home]PRefreshFurnitureReq.processImp@fresh furniture failed cut money error|roleId=%d|partnerRoleid=%d|moneytype=%d|moneynum=%d|freshcount=%d|maxfreshcount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_TYPE), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_NUM), Integer.valueOf(xHomeOperate.getDayrefreshcount()), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_MAX_COUNT) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */       HomelandManager.logger.error(logString);
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     String logString = String.format("[home]PRefreshFurnitureReq.processImp@fresh furniture success|roleId=%d|partnerRoleid=%d|moneytype=%d|moneynum=%d|freshcount=%d|maxfreshcount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_TYPE), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_NUM), Integer.valueOf(xHomeOperate.getDayrefreshcount() + 1), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_MAX_COUNT) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */     HomelandManager.logger.error(logString);
/*     */     
/* 109 */     xHomeOperate.setDayrefreshcount(xHomeOperate.getDayrefreshcount() + 1);
/* 110 */     xHomeOperate.getCanbuyitem2num().clear();
/* 111 */     xHomeOperate.getCanbuyitem2num().putAll(HomelandManager.randomCanBuyFurnitureItems());
/*     */     
/* 113 */     SSynRefreshFurnitureRes res = new SSynRefreshFurnitureRes();
/* 114 */     res.dayrefreshcount = xHomeOperate.getDayrefreshcount();
/* 115 */     res.canbuyitems.putAll(xHomeOperate.getCanbuyitem2num());
/*     */     
/* 117 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 119 */     tlogRefreshfurnitureitem(userid, roleLevel, res.dayrefreshcount, SHomelandCfgConsts.getInstance().FRESH_FURNITURE_MAX_COUNT - res.dayrefreshcount, homeInfoWrapper.getxHomeInfo(), isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogRefreshfurnitureitem(String userid, int roleLevel, int refreshcount, long restcount, HomeInfo xHomeInfo, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 130 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 132 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(refreshcount), Long.valueOf(restcount), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_TYPE), Integer.valueOf(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NEED_MONEY_NUM), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 137 */     TLogManager.getInstance().addLog(userid, this.roleId, "Refreshfurnitureitem", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PRefreshFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */