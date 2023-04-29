/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SCommonResultRes;
/*     */ import mzm.gsp.homeland.SRecycleFurnitureReqRes;
/*     */ import mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeOperate;
/*     */ import xtable.Role2homeoperate;
/*     */ 
/*     */ public class PCRecycleFurnitureReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int furnitureCfgId;
/*     */   private final long furnitureUuid;
/*     */   
/*     */   public PCRecycleFurnitureReq(long roleId, int furnitureCfgId, long furnitureUuid)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.furnitureCfgId = furnitureCfgId;
/*  34 */     this.furnitureUuid = furnitureUuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  42 */       onFail(38);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     String userid = RoleInterface.getUserId(this.roleId);
/*  47 */     if (userid == null)
/*     */     {
/*  49 */       onFail(39);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  54 */     if (homeInfoWrapper == null)
/*     */     {
/*  56 */       onFail(23);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  61 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  63 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1152, true, true))
/*     */     {
/*  65 */       onFail(44);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  70 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  72 */       onFail(26);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     HomeOperate xHomeOperate = Role2homeoperate.get(Long.valueOf(this.roleId));
/*  77 */     if (xHomeOperate == null)
/*     */     {
/*  79 */       onFail(40);
/*  80 */       return false;
/*     */     }
/*  82 */     FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(this.furnitureCfgId));
/*  83 */     if (xFurnitureUuIds == null)
/*     */     {
/*  85 */       onFail(34);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (!xFurnitureUuIds.getUuids().contains(Long.valueOf(this.furnitureUuid)))
/*     */     {
/*  91 */       onFail(33);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     SFurnitureBuyCountCfg sFurnitureBuyCountCfg = SFurnitureBuyCountCfg.get(this.furnitureCfgId);
/*  96 */     if (sFurnitureBuyCountCfg != null)
/*     */     {
/*  98 */       onFail(41);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     SItemCfg itemCfg = SItemCfg.get(this.furnitureCfgId);
/* 103 */     if (itemCfg == null)
/*     */     {
/* 105 */       onFail(35);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if (!itemCfg.canSellAndThrow)
/*     */     {
/* 111 */       onFail(42);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     if (itemCfg.isProprietary)
/*     */     {
/* 117 */       onFail(43);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     xFurnitureUuIds.getUuids().remove(Long.valueOf(this.furnitureUuid));
/* 122 */     if (xFurnitureUuIds.getUuids().isEmpty())
/*     */     {
/* 124 */       xHomeOperate.getOwnfurnitures().remove(Integer.valueOf(this.furnitureCfgId));
/*     */     }
/*     */     
/* 127 */     TLogArg tLogArg = new TLogArg(LogReason.SELL_FURNITURE_ITEM, this.furnitureCfgId);
/* 128 */     int goldprice = ItemInterface.getItemSellGoldNum(itemCfg.id);
/*     */     
/* 130 */     SRecycleFurnitureReqRes res = new SRecycleFurnitureReqRes();
/* 131 */     res.furnitureuuid = this.furnitureUuid;
/* 132 */     res.furnitureid = this.furnitureCfgId;
/*     */     
/* 134 */     if (goldprice != -1)
/*     */     {
/* 136 */       if (!ItemInterface.addMoneyWithinMax(this.roleId, tLogArg, goldprice, 2))
/*     */       {
/* 138 */         return false;
/*     */       }
/* 140 */       res.moneytype = 2;
/* 141 */       res.moneynum = goldprice;
/*     */     }
/*     */     else
/*     */     {
/* 145 */       if (!ItemInterface.addMoneyWithinMax(this.roleId, tLogArg, itemCfg.sellSilver, 3))
/*     */       {
/* 147 */         return false;
/*     */       }
/* 149 */       res.moneytype = 3;
/* 150 */       res.moneynum = itemCfg.sellSilver;
/*     */     }
/*     */     
/* 153 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 155 */     tlogRecyclefurnitureitem(this.roleId, userid, res.moneytype, res.moneynum, isOwner, partnerRoleId);
/*     */     
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 162 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 167 */     StringBuilder sBuilder = new StringBuilder();
/* 168 */     sBuilder.append("[home]PCRecycleFurnitureReq.processImp@recycle furniture failed");
/* 169 */     sBuilder.append("|ret=").append(ret);
/* 170 */     sBuilder.append("|role_id=").append(this.roleId);
/* 171 */     sBuilder.append("|furniture_cfg_id=").append(this.furnitureCfgId);
/* 172 */     sBuilder.append("|furniture_uuid=").append(this.furnitureUuid);
/*     */     
/* 174 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 176 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 178 */         sBuilder.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 181 */     GameServer.logger().error(sBuilder.toString());
/*     */     
/* 183 */     SCommonResultRes sCommonResultRes = new SCommonResultRes();
/* 184 */     sCommonResultRes.res = ret;
/*     */     
/* 186 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogRecyclefurnitureitem(long roleId, String userId, int moneyType, int moneyNum, boolean isOwner, long partnerRoleId)
/*     */   {
/* 192 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 194 */     StringBuilder sbLog = new StringBuilder();
/* 195 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 196 */     sbLog.append(userId).append('|');
/* 197 */     sbLog.append(roleId).append('|');
/* 198 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 200 */     sbLog.append(this.furnitureCfgId).append('|');
/* 201 */     sbLog.append(this.furnitureUuid).append('|');
/* 202 */     sbLog.append(moneyType).append('|');
/* 203 */     sbLog.append(moneyNum).append('|');
/* 204 */     sbLog.append(isOwner).append('|');
/* 205 */     sbLog.append(partnerRoleId);
/*     */     
/* 207 */     TLogManager.getInstance().addLog(roleId, "Recyclefurnitureitem", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PCRecycleFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */