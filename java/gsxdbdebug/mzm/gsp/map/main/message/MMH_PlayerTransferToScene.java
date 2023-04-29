/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MMH_PlayerTransferToScene extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_PlayerTransferToScene>
/*     */ {
/*  17 */   private static final Logger logger = Logger.getLogger(MMH_PlayerTransferToScene.class);
/*     */   
/*     */   private final long roleId;
/*     */   
/*     */   private final int targetSceneId;
/*     */   
/*     */   private final int x;
/*     */   
/*     */   private final int y;
/*     */   
/*     */   private final int targetX;
/*     */   
/*     */   private final int targetY;
/*     */   
/*     */   private final int channelid;
/*     */   
/*     */   private final TransferType transferType;
/*     */   
/*     */   private final MapCallback<Boolean> callback;
/*     */   
/*  37 */   private boolean result = false;
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt) {
/*  40 */     this(paramLong, paramInt, 0, 0, 0, 0, Integer.MAX_VALUE, TransferType.TRANSPOS, null);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt, MapCallback<Boolean> paramMapCallback) {
/*  44 */     this(paramLong, paramInt, 0, 0, 0, 0, Integer.MAX_VALUE, TransferType.TRANSPOS, paramMapCallback);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt, TransferType paramTransferType) {
/*  48 */     this(paramLong, paramInt, 0, 0, 0, 0, Integer.MAX_VALUE, paramTransferType, null);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt, TransferType paramTransferType, MapCallback<Boolean> paramMapCallback) {
/*  52 */     this(paramLong, paramInt, 0, 0, 0, 0, Integer.MAX_VALUE, paramTransferType, paramMapCallback);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt1, int paramInt2, int paramInt3, TransferType paramTransferType) {
/*  56 */     this(paramLong, paramInt1, paramInt2, paramInt3, paramInt2, paramInt3, Integer.MAX_VALUE, paramTransferType, null);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt1, int paramInt2, int paramInt3, TransferType paramTransferType, MapCallback<Boolean> paramMapCallback) {
/*  60 */     this(paramLong, paramInt1, paramInt2, paramInt3, paramInt2, paramInt3, Integer.MAX_VALUE, paramTransferType, paramMapCallback);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, TransferType paramTransferType) {
/*  64 */     this(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, Integer.MAX_VALUE, paramTransferType, null);
/*     */   }
/*     */   
/*     */   public MMH_PlayerTransferToScene(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, TransferType paramTransferType, MapCallback<Boolean> paramMapCallback) {
/*  68 */     this.roleId = paramLong;
/*  69 */     this.targetSceneId = paramInt1;
/*  70 */     this.x = paramInt2;
/*  71 */     this.y = paramInt3;
/*  72 */     this.targetX = paramInt4;
/*  73 */     this.targetY = paramInt5;
/*  74 */     this.channelid = paramInt6;
/*  75 */     this.transferType = paramTransferType;
/*  76 */     this.callback = paramMapCallback;
/*     */   }
/*     */   
/*     */   public boolean getResult() {
/*  80 */     return this.result;
/*     */   }
/*     */   
/*     */   public void doProcess() {
/*  84 */     MapRole localMapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/*  85 */     if (localMapRole == null) {
/*  86 */       GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@MapRole is null|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  87 */       if (this.transferType == TransferType.FORCE_TRANSFER) {
/*  88 */         Scene localScene = checkAndGetScene(null);
/*  89 */         if (localScene == null)
/*  90 */           return;
/*  91 */         if (localScene.isHomelandMap())
/*  92 */           return;
/*  93 */         WorldInstance localWorldInstance = localScene.getWorld();
/*  94 */         if (localWorldInstance == null)
/*  95 */           return;
/*  96 */         Position localPosition = null;
/*  97 */         if ((this.x > 0) || (this.y > 0)) {
/*  98 */           localPosition = new Position(this.x, this.y, 0, localScene.getId());
/*     */         } else {
/* 100 */           SMapConfig localSMapConfig = localScene.getMapConfig();
/* 101 */           localPosition = new Position(localSMapConfig.defaultTransPosX, localSMapConfig.defaultTransPosY, 0, localScene.getId());
/*     */         }
/* 103 */         localWorldInstance.forceSetPosition(this.roleId, localPosition);
/*     */       }
/* 105 */       return;
/*     */     }
/* 107 */     if (!localMapRole.isCanTransfer(this.transferType)) {
/* 108 */       GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@is Can not Transfer|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 109 */       return;
/*     */     }
/* 111 */     if (checkAndGetScene(localMapRole) == null) {
/* 112 */       GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@checkAndGetScene = null|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 113 */       return;
/*     */     }
/* 115 */     if ((this.x > 0) && (this.y > 0) && (this.targetX > 0) && (this.targetY > 0)) {
/* 116 */       GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@teleportWithProtocol 1|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 117 */       this.result = localMapRole.teleportWithProtocol(this.x, this.y, 0, this.targetX, this.targetY, this.targetSceneId, this.channelid, this.transferType);
/* 118 */       return;
/*     */     }
/* 120 */     if ((this.targetX > 0) && (this.targetY > 0)) {
/* 121 */       GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@teleportWithProtocol 2|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 122 */       this.result = localMapRole.teleportToDefaultPosWithProtocol(this.targetSceneId, this.targetX, this.targetY, this.channelid, this.transferType);
/* 123 */       return;
/*     */     }
/* 125 */     GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@teleportWithProtocol 3|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 126 */     this.result = localMapRole.teleportToDefaultPosAndTargetWithProtocol(this.targetSceneId, this.channelid, this.transferType);
/*     */   }
/*     */   
/*     */   protected MapMsgHandlerDone<MMH_PlayerTransferToScene> getMapMsgHandlerDone() {
/* 130 */     if (this.callback == null)
/* 131 */       return null;
/* 132 */     return this;
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_PlayerTransferToScene paramMMH_PlayerTransferToScene) throws Exception {
/* 136 */     return this.callback.onResult(Boolean.valueOf(paramMMH_PlayerTransferToScene.getResult()));
/*     */   }
/*     */   
/*     */   public boolean isCallInProcedure() {
/* 140 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   private Scene checkAndGetScene(MapRole paramMapRole) {
/* 144 */     Scene localScene = mzm.gsp.map.main.scene.SceneManager.getInstance().getScene(this.targetSceneId);
/* 145 */     if (localScene == null) {
/* 146 */       logger.error("can not find target scene id : " + this.targetSceneId);
/* 147 */       return null;
/*     */     }
/* 149 */     SMapConfig localSMapConfig = localScene.getMapConfig();
/* 150 */     if (localSMapConfig == null) {
/* 151 */       logger.error("can not find target map config id : " + this.targetSceneId);
/* 152 */       return null; }
/*     */     Cell localCell;
/* 154 */     if ((this.x > 0) || (this.y > 0)) {
/* 155 */       localCell = localScene.getCell(localSMapConfig, this.x, this.y);
/* 156 */       if (localCell == null) {
/* 157 */         GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@srcCell = null|roleid=%d|x=%d|y=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.x), Long.valueOf(this.y) }));
/* 158 */         return null;
/*     */       }
/* 160 */       if ((paramMapRole != null) && (!paramMapRole.isFlyState()) && (localCell.isBlock())) {
/* 161 */         GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@srcCell 2|roleid=%d|x=%d|y=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.x), Long.valueOf(this.y) }));
/* 162 */         return null;
/*     */       }
/*     */     }
/* 165 */     if ((this.targetX > 0) || (this.targetY > 0)) {
/* 166 */       localCell = localScene.getCell(localSMapConfig, this.targetX, this.targetY);
/* 167 */       if (localCell == null) {
/* 168 */         GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@targetCell = null|roleid=%d|targetX=%d|targetY=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetX), Long.valueOf(this.targetY) }));
/* 169 */         return null;
/*     */       }
/* 171 */       if ((paramMapRole != null) && (!paramMapRole.isFlyState()) && (localCell.isBlock())) {
/* 172 */         GameServer.logger().info(String.format("[map]MMH_PlayerTransferToScene.doProcess@targetCell 2|roleid=%d|targetX=%d|targetY=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetX), Long.valueOf(this.targetY) }));
/* 173 */         return null;
/*     */       }
/*     */     }
/* 176 */     return localScene;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PlayerTransferToScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */