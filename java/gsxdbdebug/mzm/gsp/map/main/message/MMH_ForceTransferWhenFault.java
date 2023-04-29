/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapArgs;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.TransferType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MMH_ForceTransferWhenFault extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_ForceTransferWhenFault>
/*     */ {
/*     */   private final long roleid;
/*     */   private final MapCallback<Boolean> callback;
/*  19 */   private boolean result = false;
/*     */   
/*     */   public MMH_ForceTransferWhenFault(long roleid)
/*     */   {
/*  23 */     this(roleid, null);
/*     */   }
/*     */   
/*     */   public MMH_ForceTransferWhenFault(long roleid, MapCallback<Boolean> callback)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  34 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  40 */     Position pos = MapArgs.getInstance().randomFaultPos();
/*  41 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/*  42 */     if (role == null)
/*     */     {
/*  44 */       WorldManager.getInstance().getBigWorldInstance().forceSetPosition(this.roleid, pos);
/*  45 */       return;
/*     */     }
/*     */     
/*  48 */     Scene scene = WorldManager.getInstance().getBigWorldInstance().getSceneByCfgId(pos.getSceneId());
/*  49 */     if (scene == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[map]MMH_ForceTransferWhenFault.doProcess@target scene is null|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(pos.getSceneId()), Integer.valueOf(pos.getX()), Integer.valueOf(pos.getY()) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     mzm.gsp.map.confbean.SMapConfig mapConfig = scene.getMapConfig();
/*  59 */     if (mapConfig == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[map]MMH_ForceTransferWhenFault.doProcess@target map config is null|roleid=%d|map_cfgid=%d|target_posx=%d|target_posy=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(pos.getSceneId()), Integer.valueOf(pos.getX()), Integer.valueOf(pos.getY()) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return;
/*     */     }
/*     */     
/*  68 */     if ((role.isFollower()) || (role.isFightState()) || (role.isTeleporting()) || (role.isServerDominateGroup()))
/*     */     {
/*  70 */       return;
/*     */     }
/*     */     
/*  73 */     role.teleportWithProtocol(pos.getX(), pos.getY(), 0, pos.getX(), pos.getY(), pos.getSceneId(), TransferType.FAULT);
/*     */     
/*     */ 
/*  76 */     role.setXunLuoState(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected MapMsgHandlerDone<MMH_ForceTransferWhenFault> getMapMsgHandlerDone()
/*     */   {
/*  83 */     if (this.callback == null)
/*     */     {
/*  85 */       return null;
/*     */     }
/*     */     
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_ForceTransferWhenFault mmh)
/*     */     throws Exception
/*     */   {
/*  94 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 100 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_ForceTransferWhenFault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */