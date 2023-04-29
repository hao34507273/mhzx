/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SUseFurnitureItemRes;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PUseFurnitureItemReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   
/*     */   public PUseFurnitureItemReq(long roleId, long uuid)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 147, true))
/*     */     {
/*  44 */       String logStr = String.format("[home]PUseFurnitureItemReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  46 */       HomelandManager.logger.info(logStr);
/*  47 */       return false;
/*     */     }
/*  49 */     String userid = RoleInterface.getUserId(this.roleId);
/*  50 */     if (userid == null)
/*     */     {
/*  52 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  54 */       HomelandManager.logger.error(logString);
/*  55 */       return false;
/*     */     }
/*  57 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  59 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  60 */     if (homeInfoWrapper == null)
/*     */     {
/*  62 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@xHomeInfo is null|roleId=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid) });
/*     */       
/*     */ 
/*  65 */       HomelandManager.logger.warn(logString);
/*  66 */       HomelandManager.sendSCommonResultRes(this.roleId, 17);
/*  67 */       return false;
/*     */     }
/*  69 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  70 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  72 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/*  73 */     if (basicItem == null)
/*     */     {
/*  75 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@item is null|roleId=%d|partnerRoleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid) });
/*     */       
/*     */ 
/*     */ 
/*  79 */       HomelandManager.logger.warn(logString);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     SFurnitureItem sFurnitureItem = SFurnitureItem.get(basicItem.getCfgId());
/*  84 */     if (sFurnitureItem == null)
/*     */     {
/*     */ 
/*  87 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@SFurnitureItem is null|roleId=%d|partnerRoleid=%d|uuid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/*     */ 
/*     */ 
/*  91 */       HomelandManager.logger.error(logString);
/*  92 */       return false;
/*     */     }
/*  94 */     if ((sFurnitureItem.type != 83) && (sFurnitureItem.type != 121))
/*     */     {
/*  96 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@SFurnitureItem type error|roleId=%d|partnerRoleid=%d|uuid=%d|itemId=%d|itemType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(sFurnitureItem.type) });
/*     */       
/*     */ 
/*     */ 
/* 100 */       HomelandManager.logger.error(logString);
/* 101 */       return false;
/*     */     }
/* 103 */     int furnitureId = basicItem.getCfgId();
/*     */     
/* 105 */     TLogArg logArg = new TLogArg(LogReason.USE_FURNITURE_ITEM, furnitureId);
/*     */     
/* 107 */     Map<Long, Integer> uuid2num = new HashMap();
/* 108 */     uuid2num.put(Long.valueOf(this.uuid), Integer.valueOf(1));
/*     */     
/* 110 */     ItemOperateResult ret = ItemInterface.removeItemByUuid(this.roleId, uuid2num, logArg);
/* 111 */     if (!ret.success())
/*     */     {
/* 113 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@item is null|roleId=%d|partnerRoleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid) });
/*     */       
/*     */ 
/*     */ 
/* 117 */       HomelandManager.logger.warn(logString);
/* 118 */       return false;
/*     */     }
/* 120 */     Set<Long> uuids = (Set)ret.getChangedItemId2Uuids().get(Integer.valueOf(furnitureId));
/* 121 */     if ((uuids == null) || (uuids.size() != 1))
/*     */     {
/* 123 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@use item error|roleId=%d|partnerRoleid=%d|uuid=%d|itemId=%d|itemType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid), Integer.valueOf(furnitureId), Integer.valueOf(sFurnitureItem.type) });
/*     */       
/*     */ 
/*     */ 
/* 127 */       HomelandManager.logger.error(logString);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*     */     
/* 133 */     long furnitureUuid = ((Long)uuids.iterator().next()).longValue();
/* 134 */     boolean r = HomelandManager.addFurniture2Bag(furnitureId, furnitureUuid, xHomeOperate);
/* 135 */     if (!r)
/*     */     {
/* 137 */       String logString = String.format("[home]PUseFurnitureItemReq.processImp@add furniture into bag error|roleId=%d|partnerRoleid=%d|uuid=%d|itemId=%d|itemType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid), Integer.valueOf(furnitureId), Integer.valueOf(sFurnitureItem.type) });
/*     */       
/*     */ 
/*     */ 
/* 141 */       HomelandManager.logger.error(logString);
/*     */       
/* 143 */       return false;
/*     */     }
/* 145 */     SUseFurnitureItemRes res = new SUseFurnitureItemRes();
/* 146 */     res.furnitureid = furnitureId;
/* 147 */     res.furnitureuuid = furnitureUuid;
/* 148 */     res.area = sFurnitureItem.area;
/* 149 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 151 */     String logString = String.format("[home]PUseFurnitureItemReq.processImp@add furniture into bag success|roleId=%d|partnerRoleid=%d|uuid=%d|itemId=%d|itemType=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.uuid), Integer.valueOf(furnitureId), Integer.valueOf(sFurnitureItem.type), Integer.valueOf(furnitureId), Long.valueOf(furnitureUuid) });
/*     */     
/*     */ 
/*     */ 
/* 155 */     HomelandManager.logger.info(logString);
/*     */     
/* 157 */     tlogUsefurnitureitem(userid, roleLevel, furnitureId, furnitureUuid, homeInfoWrapper.getxHomeInfo(), xHomeOperate, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 160 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogUsefurnitureitem(String userid, int roleLevel, int furnitureId, long furnitureUuid, HomeInfo xHomeInfo, HomeOperate xHomeOperate, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 167 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 169 */     int totalcount = HomelandManager.getTotalFurnitureCount(furnitureId, xHomeInfo, isOwner, xHomeOperate);
/* 170 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(furnitureId), Long.valueOf(furnitureUuid), Integer.valueOf(totalcount), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 173 */     TLogManager.getInstance().addLog(userid, this.roleId, "Usefurnitureitem", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PUseFurnitureItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */