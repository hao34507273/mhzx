/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.confbean.SPKRevengeItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.PositionWithExtraInfo;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SUseRevengeItemFail;
/*     */ import mzm.gsp.pk.SUseRevengeItemSuccess;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseRevengeItem
/*     */   extends LogicProcedure
/*     */   implements MapCallback<Map<Long, PositionWithExtraInfo>>
/*     */ {
/*     */   private final long roleId;
/*     */   private final int bagId;
/*     */   private final int grid;
/*     */   private long itemUUID;
/*     */   private long targetRoleId;
/*     */   
/*     */   public PUseRevengeItem(long roleId, int bagId, int grid)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.bagId = bagId;
/*  43 */     this.grid = grid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (PKManager.isNotEnable()) {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1628, true)) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!RoleStatusInterface.containsStatus(this.roleId, 1621))
/*     */     {
/*  58 */       notifyFail(2);
/*  59 */       PKLogManager.error(String.format("PUseRevengeItem.processImp()@not enable pk|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  65 */     if ((teamInfo != null) && (teamInfo.getLeaderId() != this.roleId) && (RoleStatusInterface.containsStatus(this.roleId, 6)))
/*     */     {
/*     */ 
/*  68 */       PKLogManager.error(String.format("PUseRevengeItem.processImp()@team member cannot use revenge item|roleId=%d|teamid=%d|bagid=%d|grid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(teamInfo.getTeamId()), Integer.valueOf(this.bagId), Integer.valueOf(this.grid) }));
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     BasicItem item = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/*  76 */     if (item == null)
/*  77 */       return false;
/*  78 */     SPKRevengeItemCfg itemCfg = SPKRevengeItemCfg.get(item.getCfgId());
/*  79 */     if (itemCfg == null)
/*  80 */       return false;
/*  81 */     this.itemUUID = item.getFirstUuid().longValue();
/*     */     
/*     */ 
/*  84 */     Pair<Boolean, Boolean> r = checkAvailableTimes(item);
/*  85 */     if (((Boolean)r.first).booleanValue()) {
/*  86 */       return ((Boolean)r.second).booleanValue();
/*     */     }
/*     */     
/*  89 */     Integer targetRoleIdHigh = item.getExtra(ItemStoreEnum.REVENGE_ITEM_BIND_HIGH);
/*  90 */     Integer targetRoleIdLow = item.getExtra(ItemStoreEnum.REVENGE_ITEM_BIND_LOW);
/*  91 */     if ((targetRoleIdHigh == null) || (targetRoleIdLow == null))
/*     */     {
/*  93 */       PKLogManager.error(String.format("PUseRevengeItem.processImp()@no assigned target|roleid=%d|bagid=%d|grid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.grid) }));
/*     */       
/*  95 */       return false;
/*     */     }
/*  97 */     this.targetRoleId = CommonUtils.getLong(targetRoleIdHigh.intValue(), targetRoleIdLow.intValue());
/*  98 */     if (!OnlineManager.getInstance().isOnline(this.targetRoleId))
/*     */     {
/* 100 */       notifyFail(3);
/* 101 */       PKLogManager.error(String.format("PUseRevengeItem.processImp()@target offline|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     MapInterface.getRolePosition(this.targetRoleId, this);
/* 108 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 114 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onResult(Map<Long, PositionWithExtraInfo> result)
/*     */   {
/* 124 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, this.itemUUID);
/* 125 */     if (item == null) {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     Pair<Boolean, Boolean> r = checkAvailableTimes(item);
/* 130 */     if (((Boolean)r.first).booleanValue()) {
/* 131 */       return ((Boolean)r.second).booleanValue();
/*     */     }
/* 133 */     PositionWithExtraInfo position = (PositionWithExtraInfo)result.get(Long.valueOf(this.targetRoleId));
/* 134 */     if (position == null)
/*     */     {
/* 136 */       notifyFail(3);
/* 137 */       PKLogManager.error(String.format("RevengeItemMapCallback.onResult()@target not found|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/* 139 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 143 */     Scene scene = SceneManager.getInstance().getScene(position.getSceneId());
/* 144 */     SMapConfig mapCfg = scene.getMapConfig();
/* 145 */     if (mapCfg == null)
/* 146 */       return false;
/* 147 */     if (!mapCfg.canPK)
/*     */     {
/* 149 */       notifyFail(4);
/* 150 */       PKLogManager.error(String.format("RevengeItemMapCallback.onResult()@target in safe zone|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     int availableTimes = item.getExtra(ItemStoreEnum.REVENGE_ITEM_AVAILABLE_TIMES).intValue();
/* 156 */     item.setExtra(ItemStoreEnum.REVENGE_ITEM_AVAILABLE_TIMES, availableTimes - 1);
/*     */     
/* 158 */     RevengeItemTransferContext context = RevengeItemTransferContext.createContext(this.roleId, this.targetRoleId, mapCfg.id, position.getX(), position.getY(), position.getChannelid());
/*     */     
/* 160 */     notifySuccess(context);
/* 161 */     PKLogManager.tlogRevengeItemQueryTarget(this.roleId, this.targetRoleId);
/* 162 */     PKLogManager.info(String.format("RevengeItemMapCallback.onResult()@done|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */     
/* 164 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Pair<Boolean, Boolean> checkAvailableTimes(BasicItem item)
/*     */   {
/* 174 */     Pair<Boolean, Boolean> r = new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
/*     */     
/* 176 */     Integer availableTimes = item.getExtra(ItemStoreEnum.REVENGE_ITEM_AVAILABLE_TIMES);
/* 177 */     if (availableTimes == null)
/*     */     {
/* 179 */       PKLogManager.error(String.format("PUseRevengeItem.checkAvailableTimes()@no assigned target|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid() }));
/*     */       
/* 181 */       r.first = Boolean.valueOf(true);
/* 182 */       return r;
/*     */     }
/* 184 */     if (availableTimes.intValue() <= 0)
/*     */     {
/* 186 */       boolean removeResult = ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), 1, new TLogArg(LogReason.REVENGE_ITEM_DEPLETED));
/*     */       
/* 188 */       if (removeResult)
/*     */       {
/* 190 */         notifyFail(1);
/* 191 */         PKLogManager.info(String.format("PUseRevengeItem.checkAvailableTimes()@depleted|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 192 */         r.first = Boolean.valueOf(true);
/* 193 */         r.second = Boolean.valueOf(true);
/* 194 */         return r;
/*     */       }
/* 196 */       PKLogManager.error(String.format("PUseRevengeItem.checkAvailableTimes()@remove depleted item fail|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid() }));
/*     */       
/*     */ 
/* 199 */       r.first = Boolean.valueOf(true);
/* 200 */       return r;
/*     */     }
/* 202 */     return r;
/*     */   }
/*     */   
/*     */   private void notifySuccess(RevengeItemTransferContext context)
/*     */   {
/* 207 */     SUseRevengeItemSuccess sUseRevengeItemSuccess = new SUseRevengeItemSuccess();
/* 208 */     sUseRevengeItemSuccess.map_id = context.mapId;
/* 209 */     sUseRevengeItemSuccess.pos_x = context.posX;
/* 210 */     sUseRevengeItemSuccess.pos_y = context.posY;
/* 211 */     OnlineManager.getInstance().send(this.roleId, sUseRevengeItemSuccess);
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 216 */     SUseRevengeItemFail sUseRevengeItemFail = new SUseRevengeItemFail();
/* 217 */     sUseRevengeItemFail.retcode = retcode;
/* 218 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sUseRevengeItemFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PUseRevengeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */