/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.item.confbean.MapID2Prop;
/*     */ import mzm.gsp.item.confbean.SItemCangBaoTuCfg;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ 
/*     */ final class BaoTuItem extends BasicItem
/*     */ {
/*     */   protected BaoTuItem(xbean.Item item)
/*     */   {
/*  12 */     super(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean onCreateItem()
/*     */   {
/*  19 */     SItemCangBaoTuCfg sItemCangBaoTuCfg = SItemCangBaoTuCfg.get(getCfgId());
/*  20 */     if (sItemCangBaoTuCfg == null) {
/*  21 */       return false;
/*     */     }
/*  23 */     int index = xdb.Xdb.random().nextInt(sItemCangBaoTuCfg.mapIdProp.size());
/*  24 */     MapID2Prop id2prop = (MapID2Prop)sItemCangBaoTuCfg.mapIdProp.get(index);
/*  25 */     Position position = mzm.gsp.map.main.MapInterface.randomWalkablePos(id2prop.mapId);
/*  26 */     if (position == null) {
/*  27 */       return false;
/*     */     }
/*  29 */     setX(position.getX());
/*  30 */     setY(position.getY());
/*  31 */     setZ(position.getZ());
/*  32 */     setMapId(id2prop.mapId);
/*  33 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setMapId(int mapId)
/*     */   {
/*  42 */     setExtra(ItemStoreEnum.BAO_TU_MAP_ID, mapId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setX(int x)
/*     */   {
/*  51 */     setExtra(ItemStoreEnum.BAO_TU_X, x);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setY(int y)
/*     */   {
/*  60 */     setExtra(ItemStoreEnum.BAO_TU_Y, y);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setZ(int z)
/*     */   {
/*  69 */     setExtra(ItemStoreEnum.BAO_TU_Z, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Integer getX()
/*     */   {
/*  78 */     return getExtra(ItemStoreEnum.BAO_TU_X);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Integer getY()
/*     */   {
/*  87 */     return getExtra(ItemStoreEnum.BAO_TU_Y);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Integer getZ()
/*     */   {
/*  96 */     return getExtra(ItemStoreEnum.BAO_TU_Z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Integer getMapId()
/*     */   {
/* 105 */     return getExtra(ItemStoreEnum.BAO_TU_MAP_ID);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\BaoTuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */