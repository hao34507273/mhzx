/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.SUseFriendsCircleOrnamentItemSuccess;
/*     */ import mzm.gsp.item.confbean.SFriendsCircleDressUpItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleOrnamentItem;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseFriendsCircleOrnamentItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long itemUuid;
/*     */   private int itemCfgId;
/*     */   
/*     */   public PCUseFriendsCircleOrnamentItem(long roleId, long itemUuid)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.itemUuid = itemUuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  42 */       onUseFriendsCircleDressUpItemFail(1);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 470, true))
/*     */     {
/*  48 */       onUseFriendsCircleDressUpItemFail(50);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(this.roleId))
/*     */     {
/*  54 */       onUseFriendsCircleDressUpItemFail(44);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userId = RoleInterface.getUserId(this.roleId);
/*  59 */     if (userId == null)
/*     */     {
/*  61 */       onUseFriendsCircleDressUpItemFail(6);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  68 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1825, true, true))
/*     */     {
/*  70 */       onUseFriendsCircleDressUpItemFail(47);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(this.roleId))
/*     */     {
/*  76 */       onUseFriendsCircleDressUpItemFail(44);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.itemUuid);
/*  81 */     if (basicItem == null)
/*     */     {
/*  83 */       onUseFriendsCircleDressUpItemFail(12);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     this.itemCfgId = basicItem.getCfgId();
/*  88 */     SFriendsCircleDressUpItemCfg sFriendsCircleDressUpItemCfg = SFriendsCircleDressUpItemCfg.get(this.itemCfgId);
/*  89 */     if (sFriendsCircleDressUpItemCfg == null)
/*     */     {
/*  91 */       onUseFriendsCircleDressUpItemFail(13);
/*  92 */       return false;
/*     */     }
/*  94 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*     */     
/*  96 */     boolean isAleardyOwn = false;
/*     */     
/*  98 */     if (sFriendsCircleDressUpItemCfg.ornament_type == 0)
/*     */     {
/* 100 */       Map<Integer, Long> xOwnPendantOrnamentMap = xRole2FriendsCircleInfo.getOwn_pendant_ornament_map();
/* 101 */       if ((xRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id() == this.itemCfgId) || (xOwnPendantOrnamentMap.containsKey(Integer.valueOf(this.itemCfgId))))
/*     */       {
/*     */ 
/* 104 */         isAleardyOwn = true;
/*     */       }
/*     */       else
/*     */       {
/* 108 */         xOwnPendantOrnamentMap.put(Integer.valueOf(this.itemCfgId), Long.valueOf(this.itemUuid));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 113 */       Map<Integer, Long> xOwnRahmenOrnamentMap = xRole2FriendsCircleInfo.getOwn_rahmen_ornament_map();
/* 114 */       if ((xRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id() == this.itemCfgId) || (xOwnRahmenOrnamentMap.containsKey(Integer.valueOf(this.itemCfgId))))
/*     */       {
/*     */ 
/* 117 */         isAleardyOwn = true;
/*     */       }
/*     */       else
/*     */       {
/* 121 */         xOwnRahmenOrnamentMap.put(Integer.valueOf(this.itemCfgId), Long.valueOf(this.itemUuid));
/*     */       }
/*     */     }
/*     */     
/* 125 */     if (isAleardyOwn)
/*     */     {
/* 127 */       Map<String, Object> extraMap = new HashMap();
/* 128 */       extraMap.put("own_pendant", xRole2FriendsCircleInfo.getOwn_pendant_ornament_map().keySet());
/* 129 */       extraMap.put("own_rahmen", xRole2FriendsCircleInfo.getOwn_rahmen_ornament_map().keySet());
/* 130 */       extraMap.put("current_pendant_cfg_id", Integer.valueOf(xRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id()));
/* 131 */       extraMap.put("own_rahmen_cfg_id", Integer.valueOf(xRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id()));
/*     */       
/* 133 */       onUseFriendsCircleDressUpItemFail(14, extraMap);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     boolean removeResult = ItemInterface.removeItemByUuid(this.roleId, this.itemUuid, 1, new TLogArg(LogReason.FRIENDS_CIRCLE_UNLOCK_PENDANT, this.itemCfgId));
/*     */     
/* 139 */     if (!removeResult)
/*     */     {
/* 141 */       onUseFriendsCircleDressUpItemFail(15);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     SUseFriendsCircleOrnamentItemSuccess sUseFriendsCircleOrnamentItemSuccess = new SUseFriendsCircleOrnamentItemSuccess();
/* 146 */     sUseFriendsCircleOrnamentItemSuccess.add_item_cfg_id = this.itemCfgId;
/*     */     
/* 148 */     OnlineManager.getInstance().send(this.roleId, sUseFriendsCircleOrnamentItemSuccess);
/*     */     
/* 150 */     StringBuilder sBuilder = new StringBuilder();
/* 151 */     sBuilder.append("[friendscircle]PCUseFriendsCircleDressUpItem.processImp@use friends circle ornament item success");
/* 152 */     sBuilder.append("|role_id=").append(this.roleId);
/* 153 */     sBuilder.append("|item_uuid=").append(this.itemUuid);
/* 154 */     sBuilder.append("|item_cfg_id=").append(this.itemCfgId);
/*     */     
/* 156 */     GameServer.logger().info(sBuilder.toString());
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   private void onUseFriendsCircleDressUpItemFail(int ret)
/*     */   {
/* 162 */     onUseFriendsCircleDressUpItemFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onUseFriendsCircleDressUpItemFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 167 */     StringBuilder sbLog = new StringBuilder();
/* 168 */     sbLog.append("[friendscircle]PCUseFriendsCircleDressUpItem.processImp@use friends circle ornament item failed");
/* 169 */     sbLog.append("|ret=").append(ret);
/* 170 */     sbLog.append("|role_id=").append(this.roleId);
/* 171 */     sbLog.append("|item_uuid=").append(this.itemUuid);
/* 172 */     sbLog.append("|item_cfg_id=").append(this.itemCfgId);
/*     */     
/* 174 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 176 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 178 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 181 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 183 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 184 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 186 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCUseFriendsCircleOrnamentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */