/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.homeland.SCommonResultRes;
/*     */ import mzm.gsp.homeland.SUnDisplayCourtYardFurnitureRes;
/*     */ import mzm.gsp.homeland.SUnDisplayFurnitureRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PUnDisplayFurnitureReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long furnitureUuId;
/*     */   private int furnitureCfgId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PUnDisplayFurnitureReq(long roleId, long furnitureUuId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.furnitureUuId = furnitureUuId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  42 */       String logStr = String.format("[home]PUnDisplayFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  44 */       HomelandManager.logger.info(logStr);
/*  45 */       return false;
/*     */     }
/*  47 */     String userid = RoleInterface.getUserId(this.roleId);
/*  48 */     if (userid == null)
/*     */     {
/*  50 */       String logString = String.format("[home]PUnDisplayFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  52 */       HomelandManager.logger.error(logString);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  58 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  59 */     if (homeInfoWrapper == null)
/*     */     {
/*  61 */       String logString = String.format("[home]PUnDisplayFurnitureReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  63 */       HomelandManager.logger.warn(logString);
/*     */       
/*  65 */       return false;
/*     */     }
/*  67 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  68 */     this.partnerRoleId = (isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId());
/*     */     
/*  70 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  71 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  73 */       String logString = String.format("[home]PUnDisplayFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  77 */       HomelandManager.logger.info(logString);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  82 */     FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(this.furnitureUuId));
/*  83 */     if (xFurnitureInfo == null)
/*     */     {
/*  85 */       xFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(this.furnitureUuId));
/*     */     }
/*     */     
/*  88 */     if (xFurnitureInfo == null)
/*     */     {
/*  90 */       SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  91 */       sCommonResultRes.res = 33;
/*     */       
/*  93 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     this.furnitureCfgId = xFurnitureInfo.getFurnitureid();
/*  98 */     boolean ret = clearFurniture(userid, roleLevel, homeInfoWrapper, isOwner, this.partnerRoleId);
/*     */     
/* 100 */     if (!ret)
/*     */     {
/* 102 */       String logString = String.format("[home]PUnDisplayFurnitureReq.processImp@un display furniture error |roleId=%d|partenerRoleId=%d|furnitureUuId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.furnitureUuId) });
/*     */       
/*     */ 
/*     */ 
/* 106 */       HomelandManager.logger.info(logString);
/*     */     }
/* 108 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean clearFurniture(String userid, int rolelevel, HomeInfoWrapper homeInfoWrapper, boolean isOwner, long partnerRoleId)
/*     */   {
/* 115 */     SFurnitureItem sFurnitureItem = SFurnitureItem.get(this.furnitureCfgId);
/* 116 */     if (sFurnitureItem == null)
/*     */     {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (HomelandManager.isSpecialFurniture(sFurnitureItem))
/*     */     {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 127 */     if (HomelandManager.isSpecialFurniture(this.furnitureUuId, xHomeInfo))
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     int homeLevel = homeInfoWrapper.getxHomeInfo().getHomelevel();
/* 133 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 134 */     if (sHomelandCfg == null)
/*     */     {
/* 136 */       String logString = String.format("[home]PUnDisplayFurnitureReq.clearFurniture@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 140 */       HomelandManager.logger.error(logString);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 145 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/* 148 */       String logString = String.format("[home]PUnDisplayFurnitureReq.clearFurniture@SCourtyardCfg is null|roleId=%d|ownerRoleI=%d|partnerRoleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Integer.valueOf(xHomeInfo.getCourtyardlevel()) });
/*     */       
/*     */ 
/*     */ 
/* 152 */       HomelandManager.logger.info(logString);
/* 153 */       return false;
/*     */     }
/* 155 */     int oldValue = 0;
/* 156 */     if (sFurnitureItem.area == 1)
/*     */     {
/* 158 */       oldValue = HomelandManager.getFengShui(xHomeInfo);
/*     */     }
/*     */     else
/*     */     {
/* 162 */       oldValue = CourtYardManager.getBeautiful(xHomeInfo);
/*     */     }
/*     */     
/* 165 */     HomeOperate xOwnerHomeOperate = HomelandManager.getXHomeOperate(homeInfoWrapper.getOwnerRoleId());
/*     */     
/* 167 */     HomeOperate xPartnerHomeOperate = null;
/* 168 */     if (homeInfoWrapper.getPartnerRoleId() != -1L)
/*     */     {
/* 170 */       xPartnerHomeOperate = HomelandManager.getXHomeOperate(homeInfoWrapper.getPartnerRoleId());
/*     */     }
/*     */     
/* 173 */     FurnitureInfo xFurnitureInfo = HomelandManager.moveFurnitureFromHome2Bag(homeInfoWrapper.getxHomeInfo(), this.furnitureUuId, homeInfoWrapper.getOwnerRoleId(), xOwnerHomeOperate, xPartnerHomeOperate, homeInfoWrapper.getPartnerRoleId());
/*     */     
/*     */ 
/*     */ 
/* 177 */     if (xFurnitureInfo == null)
/*     */     {
/* 179 */       String logString = String.format("[home]PUnDisplayFurnitureReq.clearFurniture@move furniture into bag error |roleId=%d|partenerRoleId=%d|isOwn=%d|furnitureId=%d|oldFengShui=%d|furnitureUuId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0), Integer.valueOf(-1), Integer.valueOf(oldValue), Long.valueOf(this.furnitureUuId) });
/*     */       
/*     */ 
/*     */ 
/* 183 */       HomelandManager.logger.error(logString);
/* 184 */       SCommonResultRes sCommonResultRes = new SCommonResultRes();
/* 185 */       sCommonResultRes.res = 33;
/*     */       
/* 187 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     int newValue = 0;
/* 192 */     if (sFurnitureItem.area == 1)
/*     */     {
/* 194 */       newValue = HomelandManager.computeFurnitureFengShui(xHomeInfo);
/* 195 */       syncFengShuiChange(oldValue, newValue);
/*     */       
/* 197 */       HomelandManager.removeFurnitureFromWorld(this.furnitureUuId);
/* 198 */       HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/*     */       
/* 200 */       HomelandManager.triggerFengshuiChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldValue, newValue);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 205 */       newValue = CourtYardManager.computeFurnitureBeautiful(xHomeInfo);
/* 206 */       syncBeautifulChange(oldValue, newValue);
/*     */       
/* 208 */       HomelandManager.removeFurnitureFromWorld(this.furnitureUuId);
/* 209 */       CourtYardManager.changeCourtYardBeautifulIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*     */     }
/*     */     
/* 212 */     HomeOperate xHomeOperate = xOwnerHomeOperate;
/* 213 */     if ((!isOwner) && (xPartnerHomeOperate != null))
/*     */     {
/* 215 */       xHomeOperate = xPartnerHomeOperate;
/*     */     }
/* 217 */     HomelandManager.tlogUndisplayfurniture(userid, this.roleId, rolelevel, xFurnitureInfo.getFurnitureid(), this.furnitureUuId, xFurnitureInfo.getX(), xFurnitureInfo.getY(), xFurnitureInfo.getDirection(), oldValue - newValue, xHomeInfo, xHomeOperate, isOwner, partnerRoleId, oldValue, newValue, homeInfoWrapper.getOwnerRoleId(), sFurnitureItem.area);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 222 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(homeInfoWrapper.getOwnerRoleId(), HomelandManager.getHomelandPoint(xHomeInfo)));
/*     */     
/*     */ 
/* 225 */     String logString = String.format("[home]PUnDisplayFurnitureReq.clearFurniture@un display furniture success |roleId=%d|partenerRoleId=%d|isOwn=%d|furnitureId=%d|oldFengShui=%d|newFengShui=%d|furnitureUuId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0), Integer.valueOf(this.furnitureCfgId), Integer.valueOf(oldValue), Integer.valueOf(newValue), Long.valueOf(this.furnitureUuId) });
/*     */     
/*     */ 
/*     */ 
/* 229 */     HomelandManager.logger.info(logString);
/* 230 */     return true;
/*     */   }
/*     */   
/*     */   private void syncFengShuiChange(int oldValue, int newValue)
/*     */   {
/* 235 */     SUnDisplayFurnitureRes res = new SUnDisplayFurnitureRes();
/* 236 */     res.furnitureuuid = this.furnitureUuId;
/* 237 */     res.furnitureid = this.furnitureCfgId;
/* 238 */     res.decfengshui = (oldValue - newValue);
/* 239 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 241 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 243 */       HomelandManager.sendSSynFengshuiRes(this.partnerRoleId, newValue);
/*     */     }
/*     */   }
/*     */   
/*     */   private void syncBeautifulChange(int oldValue, int newValue)
/*     */   {
/* 249 */     SUnDisplayCourtYardFurnitureRes res = new SUnDisplayCourtYardFurnitureRes();
/* 250 */     res.furnitureuuid = this.furnitureUuId;
/* 251 */     res.furnitureid = this.furnitureCfgId;
/* 252 */     res.dec_beautiful = (oldValue - newValue);
/* 253 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 255 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 257 */       CourtYardManager.sendSSynBeautifulRes(this.partnerRoleId, newValue);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PUnDisplayFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */