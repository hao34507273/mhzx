/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.SMapCommonResult;
/*     */ import mzm.gsp.map.confbean.SMapItemCfg;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.scene.PositionWithCfgid;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapItem;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MMH_MapItemGatherCheck extends AbstractMapMsgHandler
/*     */ {
/*     */   private final long roleid;
/*     */   private final int mapItemInstanceid;
/*  19 */   private SMapItemCfg mapItemCfg = null;
/*  20 */   private long worldid = 0L;
/*  21 */   private int mapCfgid = 0;
/*  22 */   private int mapItemCfgid = 0;
/*  23 */   private PositionWithCfgid mapItemPos = null;
/*     */   
/*     */   public MMH_MapItemGatherCheck(long roleid, int instanceid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.mapItemInstanceid = instanceid;
/*     */   }
/*     */   
/*     */   public SMapItemCfg getMapItemCfg()
/*     */   {
/*  33 */     return this.mapItemCfg;
/*     */   }
/*     */   
/*     */   public long getWorldid()
/*     */   {
/*  38 */     return this.worldid;
/*     */   }
/*     */   
/*     */   public int getMapCfgid()
/*     */   {
/*  43 */     return this.mapCfgid;
/*     */   }
/*     */   
/*     */   public int getMapItemCfgid()
/*     */   {
/*  48 */     return this.mapItemCfgid;
/*     */   }
/*     */   
/*     */   public PositionWithCfgid getMapItemPos()
/*     */   {
/*  53 */     return this.mapItemPos;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  59 */     MapItem item = MapObjectInstanceManager.getInstance().getMapItem(this.mapItemInstanceid);
/*  60 */     if (item == null)
/*     */     {
/*  62 */       SMapCommonResult mapCommonResult = new SMapCommonResult();
/*  63 */       mapCommonResult.result = 102;
/*  64 */       MapProtocolSendQueue.getInstance().send(this.roleid, mapCommonResult);
/*  65 */       return;
/*     */     }
/*     */     
/*  68 */     if (!item.isAlive())
/*     */     {
/*  70 */       SMapCommonResult mapCommonResult = new SMapCommonResult();
/*  71 */       mapCommonResult.result = 102;
/*  72 */       MapProtocolSendQueue.getInstance().send(this.roleid, mapCommonResult);
/*  73 */       return;
/*     */     }
/*     */     
/*  76 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/*  77 */     if (mapRole == null)
/*     */     {
/*  79 */       return;
/*     */     }
/*  81 */     if (!mapRole.isSee(item))
/*     */     {
/*  83 */       return;
/*     */     }
/*  85 */     Scene scene = SceneManager.getInstance().getScene(item.getSceneId());
/*  86 */     if (scene == null)
/*     */     {
/*  88 */       return;
/*     */     }
/*     */     
/*  91 */     WorldInstance instance = scene.getWorld();
/*  92 */     if (instance == null)
/*     */     {
/*  94 */       return;
/*     */     }
/*     */     
/*     */ 
/*  98 */     SMapItemCfg cfg = item.getMapItemCfg();
/*  99 */     if (mapRole.getDistance(item) > cfg.radius)
/*     */     {
/* 101 */       GameServer.logger().warn(String.format("[map]MMH_MapItemGatherCheck.doProcess@server detected gather action but not in gather radius|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/* 105 */       return;
/*     */     }
/*     */     
/* 108 */     this.mapItemCfg = cfg;
/* 109 */     this.worldid = instance.getId();
/* 110 */     this.mapCfgid = scene.getCfgId();
/* 111 */     this.mapItemCfgid = item.getCfgId();
/* 112 */     this.mapItemPos = item.getPositionWithExtraInfo();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_MapItemGatherCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */