/*     */ package mzm.gsp.map.main.controller;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.map.main.scene.object.SceneObjectId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ControllerContext
/*     */ {
/*     */   public static final int MAP_CFG_ID = 0;
/*     */   public static final int INSTANCE_CFG_ID = 1;
/*     */   public static final int INSTANCE_TYPE = 2;
/*     */   public static final int TYPE_MONSTER = 0;
/*     */   public static final int TYPE_MAPITEM = 1;
/*     */   public static final int TYPE_NPC = 2;
/*     */   public final long worldInstanceid;
/*     */   public final int controllerid;
/*     */   private SceneObjectId objectid;
/*  54 */   private Map<Integer, Object> paramMap = new HashMap();
/*     */   
/*     */   public ControllerContext(long worldInstanceid, int controllerid)
/*     */   {
/*  58 */     this.worldInstanceid = worldInstanceid;
/*  59 */     this.controllerid = controllerid;
/*     */   }
/*     */   
/*     */   public SceneObjectId getSceneObjectId()
/*     */   {
/*  64 */     return this.objectid;
/*     */   }
/*     */   
/*     */   void setObjectId(SceneObjectId objectid)
/*     */   {
/*  69 */     this.objectid = objectid;
/*     */   }
/*     */   
/*     */   public void putExtra(int type, Object value)
/*     */   {
/*  74 */     this.paramMap.put(Integer.valueOf(type), value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMapCfgId()
/*     */   {
/*  84 */     Integer mapCfgid = (Integer)getParam(0);
/*  85 */     if (mapCfgid == null)
/*     */     {
/*  87 */       return -1;
/*     */     }
/*  89 */     return mapCfgid.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getInstanceCfgId()
/*     */   {
/*  99 */     Integer cfgid = (Integer)getParam(1);
/* 100 */     if (cfgid == null)
/*     */     {
/* 102 */       return -1;
/*     */     }
/* 104 */     return cfgid.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getInstanceType()
/*     */   {
/* 114 */     Integer instanceType = (Integer)getParam(2);
/* 115 */     if (instanceType == null)
/*     */     {
/* 117 */       return -1;
/*     */     }
/* 119 */     return instanceType.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isMonster()
/*     */   {
/* 129 */     return getInstanceType() == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isMapItem()
/*     */   {
/* 139 */     return getInstanceType() == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNpc()
/*     */   {
/* 149 */     return getInstanceType() == 2;
/*     */   }
/*     */   
/*     */   public Object getParam(int key)
/*     */   {
/* 154 */     return this.paramMap.get(Integer.valueOf(key));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\controller\ControllerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */