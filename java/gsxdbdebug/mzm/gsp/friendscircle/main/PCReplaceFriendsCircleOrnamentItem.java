/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleOrnamentTypeShowCfg;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.SReplaceFriendsCircleOrnamentItemSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleOrnamentItem;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCReplaceFriendsCircleOrnamentItem extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final Map<Integer, Integer> replaceOrnamentMap;
/*     */   
/*     */   public PCReplaceFriendsCircleOrnamentItem(long roleId, Map<Integer, Integer> replaceOrnamentMap)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.replaceOrnamentMap = replaceOrnamentMap;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.replaceOrnamentMap.size() > 2)
/*     */     {
/*  34 */       onReplaceFriendsCircleDressUpItemFail(56);
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  40 */       onReplaceFriendsCircleDressUpItemFail(1);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 470, true))
/*     */     {
/*  46 */       onReplaceFriendsCircleDressUpItemFail(50);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userId = RoleInterface.getUserId(this.roleId);
/*  51 */     if (userId == null)
/*     */     {
/*  53 */       onReplaceFriendsCircleDressUpItemFail(6);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  59 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(this.roleId))
/*     */     {
/*  61 */       onReplaceFriendsCircleDressUpItemFail(44);
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1823, true, true))
/*     */     {
/*     */ 
/*  69 */       onReplaceFriendsCircleDressUpItemFail(47);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*     */     
/*  75 */     SReplaceFriendsCircleOrnamentItemSuccess replaceSuccess = new SReplaceFriendsCircleOrnamentItemSuccess();
/*  76 */     for (Map.Entry<Integer, Integer> entry : this.replaceOrnamentMap.entrySet())
/*     */     {
/*  78 */       int changeOrnamentType = ((Integer)entry.getKey()).intValue();
/*  79 */       int replaceItemCfgId = ((Integer)entry.getValue()).intValue();
/*     */       
/*  81 */       Map<Integer, Long> xOwnOrnamentItemMap = null;
/*  82 */       int xCurrentItemCfgId = 0;
/*  83 */       long xCurrentItemUuid = 0L;
/*     */       
/*  85 */       FriendsCircleOrnamentItem xCurrentCircleOrnamentItem = null;
/*  86 */       if (changeOrnamentType == 0)
/*     */       {
/*  88 */         xCurrentCircleOrnamentItem = xRole2FriendsCircleInfo.getCurrent_pendant_ornament();
/*  89 */         xCurrentItemCfgId = xCurrentCircleOrnamentItem.getItem_cfg_id();
/*  90 */         if (xCurrentItemCfgId == replaceItemCfgId)
/*     */         {
/*  92 */           onReplaceFriendsCircleDressUpItemFail(16);
/*  93 */           return false;
/*     */         }
/*  95 */         xCurrentItemUuid = xCurrentCircleOrnamentItem.getItem_uuid();
/*     */         
/*  97 */         xOwnOrnamentItemMap = xRole2FriendsCircleInfo.getOwn_pendant_ornament_map();
/*     */       }
/*  99 */       else if (changeOrnamentType == 1)
/*     */       {
/* 101 */         xCurrentCircleOrnamentItem = xRole2FriendsCircleInfo.getCurrent_rahmen_ornament();
/* 102 */         xCurrentItemCfgId = xCurrentCircleOrnamentItem.getItem_cfg_id();
/* 103 */         if (xCurrentItemCfgId == replaceItemCfgId)
/*     */         {
/* 105 */           onReplaceFriendsCircleDressUpItemFail(16);
/* 106 */           return false;
/*     */         }
/* 108 */         xCurrentItemUuid = xCurrentCircleOrnamentItem.getItem_uuid();
/* 109 */         xOwnOrnamentItemMap = xRole2FriendsCircleInfo.getOwn_rahmen_ornament_map();
/*     */       }
/*     */       else
/*     */       {
/* 113 */         onReplaceFriendsCircleDressUpItemFail(18);
/* 114 */         return false;
/*     */       }
/*     */       
/* 117 */       Long replaceItemUuid = (Long)xOwnOrnamentItemMap.remove(Integer.valueOf(replaceItemCfgId));
/* 118 */       SFriendsCircleOrnamentTypeShowCfg sFriendsCircleOrnamentTypeShowCfg = SFriendsCircleOrnamentTypeShowCfg.get(changeOrnamentType);
/* 119 */       if (sFriendsCircleOrnamentTypeShowCfg == null)
/*     */       {
/* 121 */         onReplaceFriendsCircleDressUpItemFail(18);
/* 122 */         return false;
/*     */       }
/*     */       
/* 125 */       if (replaceItemUuid == null)
/*     */       {
/* 127 */         onReplaceFriendsCircleDressUpItemFail(17);
/* 128 */         return false;
/*     */       }
/*     */       
/* 131 */       replaceSuccess.change_ornament_map.put(Integer.valueOf(changeOrnamentType), new mzm.gsp.friendscircle.ChangeOrnament(xCurrentItemCfgId, replaceItemCfgId));
/*     */       
/*     */ 
/* 134 */       xOwnOrnamentItemMap.put(Integer.valueOf(xCurrentItemCfgId), Long.valueOf(xCurrentItemUuid));
/* 135 */       xCurrentCircleOrnamentItem.setItem_cfg_id(replaceItemCfgId);
/* 136 */       xCurrentCircleOrnamentItem.setItem_uuid(replaceItemUuid.longValue());
/*     */     }
/*     */     
/* 139 */     xRole2FriendsCircleInfo.setUpdate_ornament_result(false);
/* 140 */     FriendsCircleManager.reportUpdateSpaceStyle(userId, this.roleId, xRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id(), xRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id());
/*     */     
/*     */ 
/*     */ 
/* 144 */     OnlineManager.getInstance().send(this.roleId, replaceSuccess);
/*     */     
/* 146 */     StringBuilder sbLog = new StringBuilder();
/* 147 */     sbLog.append("[friends_circle]PCUseFriendsCircleDressUpItem.processImp@replace friends circle dress up item failed");
/* 148 */     sbLog.append("|role_id=").append(this.roleId);
/* 149 */     for (Map.Entry<Integer, Integer> entry : this.replaceOrnamentMap.entrySet())
/*     */     {
/* 151 */       sbLog.append('|').append(entry.getKey()).append('=').append(entry.getValue());
/*     */     }
/*     */     
/* 154 */     GameServer.logger().info(sbLog.toString());
/* 155 */     return true;
/*     */   }
/*     */   
/*     */   private void onReplaceFriendsCircleDressUpItemFail(int ret)
/*     */   {
/* 160 */     onReplaceFriendsCircleOrnamentItemFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onReplaceFriendsCircleOrnamentItemFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 165 */     StringBuilder sbLog = new StringBuilder();
/* 166 */     sbLog.append("[friends_circle]PCUseFriendsCircleDressUpItem.processImp@replace friends circle ornament item failed");
/* 167 */     sbLog.append("|ret=").append(ret);
/* 168 */     sbLog.append("|role_id=").append(this.roleId);
/* 169 */     for (Map.Entry<Integer, Integer> entry : this.replaceOrnamentMap.entrySet())
/*     */     {
/* 171 */       sbLog.append('|').append(entry.getKey()).append('=').append(entry.getValue());
/*     */     }
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCReplaceFriendsCircleOrnamentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */