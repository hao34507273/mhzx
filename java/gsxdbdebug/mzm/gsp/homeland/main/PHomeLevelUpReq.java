/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.homeland.SHomeLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.event.HomeLevelUp;
/*     */ import mzm.gsp.homeland.event.HomeLevelUpArg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xbean.MaidInfo;
/*     */ 
/*     */ public class PHomeLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int createType;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PHomeLevelUpReq(long roleId, int createType)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.createType = createType;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  51 */       String logStr = String.format("[home]PHomeLevelUpReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  52 */       HomelandManager.logger.info(logStr);
/*  53 */       return false;
/*     */     }
/*  55 */     String userid = RoleInterface.getUserId(this.roleId);
/*  56 */     if (userid == null)
/*     */     {
/*  58 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  60 */       HomelandManager.logger.error(logString);
/*  61 */       return false;
/*     */     }
/*  63 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  65 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  66 */     if (homeInfoWrapper == null)
/*     */     {
/*  68 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@xHomeInfo is null|roleId=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.createType) });
/*     */       
/*     */ 
/*  71 */       HomelandManager.logger.warn(logString);
/*     */       
/*  73 */       return false;
/*     */     }
/*  75 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  76 */     this.partnerRoleId = (isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId());
/*  77 */     if (!isOwner)
/*     */     {
/*  79 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  83 */       HomelandManager.logger.warn(logString);
/*  84 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  89 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  90 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  92 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(this.createType) });
/*     */       
/*     */ 
/*     */ 
/*  96 */       HomelandManager.logger.info(logString);
/*  97 */       return false;
/*     */     }
/*  99 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_LEVEL_UP_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/* 103 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/* 105 */       HomelandManager.logger.warn(logString);
/* 106 */       return false;
/*     */     }
/* 108 */     boolean r = mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 38, true);
/* 109 */     if (!r)
/*     */     {
/* 111 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@can not set home level up state|roleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/* 115 */       HomelandManager.logger.info(logString);
/*     */       
/* 117 */       return false;
/*     */     }
/* 119 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/* 121 */     SHomelandCfg currentHomelandCfg = SHomelandCfg.get(homeLevel);
/* 122 */     if (currentHomelandCfg == null)
/*     */     {
/* 124 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(this.createType) });
/*     */       
/*     */ 
/*     */ 
/* 128 */       HomelandManager.logger.error(logString);
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel + 1);
/* 134 */     if (sHomelandCfg == null)
/*     */     {
/* 136 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel + 1), Integer.valueOf(this.createType) });
/*     */       
/*     */ 
/*     */ 
/* 140 */       HomelandManager.logger.error(logString);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     int xCourtYardLevel = homeInfoWrapper.getxHomeInfo().getCourtyardlevel();
/* 145 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xCourtYardLevel);
/* 146 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/* 149 */       String logString = String.format("[home]PHomeLevelUpReq.processImp@SCourtyardCfg is null|roleId=%d|ownerRoleI=%d|partnerRoleId=%d|homeWorleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(xCourtYardLevel) });
/*     */       
/*     */ 
/*     */ 
/* 153 */       HomelandManager.logger.info(logString);
/* 154 */       return false;
/*     */     }
/* 156 */     TLogArg logArg = new TLogArg(LogReason.HOME_LEVEl_UP, this.createType);
/* 157 */     if (this.createType == 0)
/*     */     {
/*     */ 
/* 160 */       boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.HOME_LEVEl_UP, 0, sHomelandCfg.moneyType, sHomelandCfg.moneyNum, CostType.COST_BIND_FIRST_HOME_LEVEL_UP);
/*     */       
/* 162 */       if (!ret)
/*     */       {
/* 164 */         String logString = String.format("[home]PHomeLevelUpReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|moneyType=%d|moneyNum=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(sHomelandCfg.moneyType), Integer.valueOf(sHomelandCfg.moneyNum), Integer.valueOf(this.createType) });
/*     */         
/*     */ 
/* 167 */         HomelandManager.logger.error(logString);
/* 168 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 174 */       boolean ret = ItemInterface.removeItemById(this.roleId, sHomelandCfg.itemId, sHomelandCfg.itemNum, logArg);
/*     */       
/* 176 */       if (!ret)
/*     */       {
/* 178 */         String logString = String.format("[home]PHomeLevelUpReq.processImp@cut item error|roleId=%d|partnerRoleid=%d|homeLevel=%d|itemId=%d|itemNum=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(sHomelandCfg.itemId), Integer.valueOf(sHomelandCfg.itemNum), Integer.valueOf(this.createType) });
/*     */         
/*     */ 
/* 181 */         HomelandManager.logger.error(logString);
/* 182 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 186 */     HomeOperate xOwnerHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/* 187 */     HomeOperate xPartnerHomeOperate = null;
/*     */     
/*     */ 
/* 190 */     moveFurniture(this.roleId, xHomeInfo, isOwner, xOwnerHomeOperate);
/*     */     
/* 192 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 194 */       xPartnerHomeOperate = HomelandManager.getXHomeOperate(this.partnerRoleId);
/*     */       
/*     */ 
/* 197 */       moveFurniture(this.partnerRoleId, xHomeInfo, !isOwner, xPartnerHomeOperate);
/*     */     }
/*     */     
/* 200 */     xHomeInfo.setHomelevel(homeLevel + 1);
/* 201 */     for (MaidInfo xMaidInfo : xHomeInfo.getUuid2maidinfo().values())
/*     */     {
/* 203 */       xMaidInfo.setX(sHomelandCfg.maidX);
/* 204 */       xMaidInfo.setY(sHomelandCfg.maidY);
/*     */     }
/* 206 */     HomelandManager.sendSSynOwnFurnitureRes(this.roleId, xOwnerHomeOperate);
/* 207 */     if ((this.partnerRoleId != -1L) && (xPartnerHomeOperate != null))
/*     */     {
/* 209 */       HomelandManager.sendSSynOwnFurnitureRes(this.partnerRoleId, xPartnerHomeOperate);
/*     */     }
/*     */     
/* 212 */     int newFengshui = HomelandManager.computeFurnitureFengShui(xHomeInfo);
/*     */     
/* 214 */     HomelandManager.sendSSynHomelandRes(this.roleId, true, xHomeInfo, xOwnerHomeOperate);
/* 215 */     if ((this.partnerRoleId != -1L) && (xPartnerHomeOperate != null))
/*     */     {
/* 217 */       HomelandManager.sendSSynHomelandRes(this.partnerRoleId, false, xHomeInfo, xPartnerHomeOperate);
/*     */     }
/*     */     
/*     */ 
/* 221 */     HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/* 222 */     HomelandManager.changeHomeLevelIntoWorld(homeInfoWrapper);
/*     */     
/*     */ 
/* 225 */     java.util.List<Long> roleList = MapInterface.getRoleList(homeWorleId, currentHomelandCfg.mapId);
/* 226 */     HomelandManager.goHome(roleList, homeWorleId, sCourtyardCfg.mapId, -1, -1, sHomelandCfg.maidX, sHomelandCfg.maidY, homeInfoWrapper);
/*     */     
/*     */ 
/* 229 */     MapInterface.destroyScene(homeWorleId, currentHomelandCfg.mapId, null);
/*     */     
/* 231 */     SHomeLevelUpRes res = new SHomeLevelUpRes();
/* 232 */     res.homelevel = (homeLevel + 1);
/* 233 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 235 */     HomelandManager.sendSSynFengshuiRes(this.roleId, newFengshui);
/* 236 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 238 */       OnlineManager.getInstance().send(this.partnerRoleId, res);
/* 239 */       HomelandManager.sendSSynFengshuiRes(this.partnerRoleId, newFengshui);
/*     */     }
/*     */     
/* 242 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(this.roleId, HomelandManager.getHomelandPoint(xHomeInfo)));
/*     */     
/* 244 */     ChildrenInterface.onHomeLevelUp(this.roleId, this.partnerRoleId);
/* 245 */     tlogHomeLevelUp(userid, roleLevel, homeLevel, xHomeInfo, sHomelandCfg, isOwner, this.partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 248 */     TriggerEventsManger.getInstance().triggerEvent(new HomeLevelUp(), new HomeLevelUpArg(this.roleId, isOwner, homeLevel, homeLevel + 1), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 251 */     if (this.partnerRoleId > 0L)
/*     */     {
/* 253 */       TriggerEventsManger.getInstance().triggerEvent(new HomeLevelUp(), new HomeLevelUpArg(this.partnerRoleId, !isOwner, homeLevel, homeLevel + 1), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.partnerRoleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 258 */     String logString = String.format("[home]PHomeLevelUpReq.processImp@home level up success|roleId=%d|partnerRoleId=%d|oldHomeLevel=%d|newHomeLevel=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(homeLevel + 1), Integer.valueOf(this.createType) });
/*     */     
/*     */ 
/* 261 */     HomelandManager.logger.info(logString);
/*     */     
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogHomeLevelUp(String userid, int roleLevel, int oldHomeLevel, HomeInfo xHomeInfo, SHomelandCfg sHomelandCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 269 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 271 */     int moneytype = 0;
/* 272 */     int moneynum = 0;
/* 273 */     int itemid = 0;
/* 274 */     int itemnum = 0;
/* 275 */     if (this.createType == 0)
/*     */     {
/* 277 */       moneytype = sHomelandCfg.moneyType;
/* 278 */       moneynum = sHomelandCfg.moneyNum;
/*     */     }
/*     */     else
/*     */     {
/* 282 */       itemid = sHomelandCfg.itemId;
/* 283 */       itemnum = sHomelandCfg.itemNum;
/*     */     }
/*     */     
/* 286 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(oldHomeLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(moneytype), Integer.valueOf(moneynum), Integer.valueOf(itemid), Integer.valueOf(itemnum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 289 */     TLogManager.getInstance().addLog(userid, this.roleId, "Homelevelup", columnns);
/*     */   }
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
/*     */ 
/*     */ 
/*     */   private void moveFurniture(long roleId, HomeInfo xHomeInfo, boolean isOwner, HomeOperate xHomeOperate)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 307 */     HomelandManager.moveRoomAllFurnitureFromHome2Bag(xHomeInfo, isOwner, xHomeOperate, false);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PHomeLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */