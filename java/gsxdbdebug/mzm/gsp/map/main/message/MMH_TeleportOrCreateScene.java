/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.proto.Cell;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MMH_TeleportOrCreateScene
/*     */   extends AbstractMapMsgHandler
/*     */   implements MapMsgHandlerDone<MMH_TeleportOrCreateScene>
/*     */ {
/*  21 */   private static final Logger logger = Logger.getLogger(MMH_TeleportOrCreateScene.class);
/*     */   
/*     */   private final long roleId;
/*     */   
/*     */   private final long worldId;
/*     */   private final int targetMapId;
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final int targetX;
/*     */   private final int targetY;
/*     */   private final int channelid;
/*     */   private final TransferType transferType;
/*     */   private final MapCallback<Boolean> callback;
/*  34 */   private boolean result = false;
/*     */   
/*     */ 
/*     */   public MMH_TeleportOrCreateScene(long roleId, long worldId, int targetMapId, int x, int y, int targetX, int targetY, TransferType transferType)
/*     */   {
/*  39 */     this(roleId, worldId, targetMapId, x, y, targetX, targetY, Integer.MAX_VALUE, transferType, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_TeleportOrCreateScene(long roleId, long worldId, int targetMapId, int x, int y, int targetX, int targetY, int channelid, TransferType transferType)
/*     */   {
/*  45 */     this(roleId, worldId, targetMapId, x, y, targetX, targetY, channelid, transferType, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_TeleportOrCreateScene(long roleId, long worldId, int targetMapId, int x, int y, int targetX, int targetY, TransferType transferType, MapCallback<Boolean> callback)
/*     */   {
/*  51 */     this(roleId, worldId, targetMapId, x, y, targetX, targetY, Integer.MAX_VALUE, transferType, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public MMH_TeleportOrCreateScene(long roleId, long worldId, int targetMapId, int x, int y, int targetX, int targetY, int channelid, TransferType transferType, MapCallback<Boolean> callback)
/*     */   {
/*  58 */     this.roleId = roleId;
/*  59 */     this.worldId = worldId;
/*  60 */     this.targetMapId = targetMapId;
/*  61 */     this.x = x;
/*  62 */     this.y = y;
/*  63 */     this.targetX = targetX;
/*  64 */     this.targetY = targetY;
/*  65 */     this.channelid = channelid;
/*  66 */     this.transferType = transferType;
/*  67 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  72 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  78 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/*  79 */     if (mapRole == null)
/*     */     {
/*  81 */       if (this.transferType == TransferType.FORCE_TRANSFER)
/*     */       {
/*  83 */         WorldInstance worldInstance = WorldManager.getInstance().getWorldInstance(this.worldId);
/*  84 */         if (worldInstance != null)
/*     */         {
/*  86 */           Scene scene = checkAndGetScene();
/*  87 */           if (scene == null)
/*     */           {
/*  89 */             return;
/*     */           }
/*     */           
/*  92 */           if (scene.isHomelandMap())
/*     */           {
/*  94 */             return;
/*     */           }
/*  96 */           Position pos = null;
/*  97 */           if ((this.x > 0) || (this.y > 0))
/*     */           {
/*  99 */             pos = new Position(this.x, this.y, 0, scene.getId());
/*     */           }
/*     */           else
/*     */           {
/* 103 */             SMapConfig mapConfig = scene.getMapConfig();
/* 104 */             pos = new Position(mapConfig.defaultTransPosX, mapConfig.defaultTransPosY, 0, scene.getId());
/*     */           }
/* 106 */           worldInstance.forceSetPosition(this.roleId, pos);
/*     */         }
/*     */       }
/*     */       
/* 110 */       return;
/*     */     }
/*     */     
/* 113 */     if (!mapRole.isCanTransfer(this.transferType))
/*     */     {
/* 115 */       return;
/*     */     }
/*     */     
/* 118 */     Scene scene = checkAndGetScene(mapRole);
/* 119 */     if (scene == null)
/*     */     {
/* 121 */       return;
/*     */     }
/*     */     
/* 124 */     int targetSceneId = scene.getId();
/* 125 */     if ((this.x > 0) && (this.y > 0) && (this.targetX > 0) && (this.targetY > 0))
/*     */     {
/* 127 */       this.result = mapRole.teleportWithProtocol(this.x, this.y, 0, this.targetX, this.targetY, targetSceneId, this.channelid, this.transferType);
/*     */       
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     if ((this.targetX > 0) && (this.targetY > 0))
/*     */     {
/* 134 */       this.result = mapRole.teleportToDefaultPosWithProtocol(targetSceneId, this.targetX, this.targetY, this.channelid, this.transferType);
/*     */       
/* 136 */       return;
/*     */     }
/*     */     
/* 139 */     this.result = mapRole.teleportToDefaultPosAndTargetWithProtocol(targetSceneId, this.channelid, this.transferType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected MapMsgHandlerDone<MMH_TeleportOrCreateScene> getMapMsgHandlerDone()
/*     */   {
/* 146 */     if (this.callback == null)
/*     */     {
/* 148 */       return null;
/*     */     }
/*     */     
/* 151 */     return this;
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_TeleportOrCreateScene mmh)
/*     */     throws Exception
/*     */   {
/* 157 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 163 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   private Scene checkAndGetScene()
/*     */   {
/* 168 */     return checkAndGetScene(null);
/*     */   }
/*     */   
/*     */   private Scene checkAndGetScene(MapRole mapRole)
/*     */   {
/* 173 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 174 */     if (instance == null)
/*     */     {
/* 176 */       logger.error("fuben world release or not create targetMapId " + this.targetMapId);
/* 177 */       return null;
/*     */     }
/*     */     
/* 180 */     Scene scene = instance.nextScene(this.targetMapId);
/* 181 */     if (scene == null)
/*     */     {
/* 183 */       logger.error("can not find target scene id : " + this.targetMapId);
/* 184 */       return null;
/*     */     }
/*     */     
/* 187 */     SMapConfig mapConfig = scene.getMapConfig();
/* 188 */     if (mapConfig == null)
/*     */     {
/* 190 */       logger.error("can not find target map config id : " + this.targetMapId);
/* 191 */       return null;
/*     */     }
/*     */     
/* 194 */     if ((this.x > 0) || (this.y > 0))
/*     */     {
/* 196 */       Cell srcCell = scene.getCell(mapConfig, this.x, this.y);
/* 197 */       if (srcCell == null)
/*     */       {
/* 199 */         return null;
/*     */       }
/*     */       
/* 202 */       if ((mapRole != null) && (!mapRole.isFlyState()) && (srcCell.isBlock()))
/*     */       {
/* 204 */         return null;
/*     */       }
/*     */     }
/*     */     
/* 208 */     if ((this.targetX > 0) || (this.targetY > 0))
/*     */     {
/* 210 */       Cell targetCell = scene.getCell(mapConfig, this.targetX, this.targetY);
/* 211 */       if (targetCell == null)
/*     */       {
/* 213 */         return null;
/*     */       }
/*     */       
/* 216 */       if ((mapRole != null) && (!mapRole.isFlyState()) && (targetCell.isBlock()))
/*     */       {
/* 218 */         return null;
/*     */       }
/*     */     }
/*     */     
/* 222 */     return scene;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TeleportOrCreateScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */