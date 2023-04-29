/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import xbean.CatInfo;
/*     */ 
/*     */ public class CatInterface
/*     */ {
/*     */   public static boolean isFunOpen(long roleid)
/*     */   {
/*  12 */     return CatManager.isFunOpen(roleid);
/*     */   }
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
/*     */   public static int useCatItem(long roleid, long uuid, BasicItem item)
/*     */   {
/*  28 */     return CatManager.useCatItem(roleid, uuid, item);
/*     */   }
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
/*     */   public static void addCatIntoWorld(long roleid, long worldid, int mapCfgid, boolean isHomeCreateor)
/*     */   {
/*  46 */     CatManager.displayAtHomeland(roleid, worldid, mapCfgid, isHomeCreateor);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onCatNameChange(long catid, String newName)
/*     */   {
/*  59 */     CatManager.onCatNameChange(catid, newName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onCatExploreEnd(long catid)
/*     */   {
/*  70 */     CatManager.onCatExploreEnd(catid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onSendCatToExplore(long catid)
/*     */   {
/*  81 */     CatManager.onSendCatToExplore(catid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onCatRecoveryToItem(long catid)
/*     */   {
/*  91 */     MapInterface.removeMapEntity(mzm.gsp.map.main.scene.object.MapEntityType.MGT_EXPLORE_CAT, catid, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeCatByRoleid(long roleid, boolean retainLock)
/*     */   {
/* 103 */     CatInfo xCatInfo = CatManager.getHomelandCat(roleid, retainLock);
/* 104 */     if (xCatInfo == null)
/*     */     {
/* 106 */       return;
/*     */     }
/* 108 */     MapInterface.removeMapEntity(mzm.gsp.map.main.scene.object.MapEntityType.MGT_EXPLORE_CAT, xCatInfo.getId(), null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAwardBirdNum(long roleid, boolean holdLock)
/*     */   {
/* 120 */     return CatManager.getAwardItemNum(roleid, SCatCfgConsts.getInstance().BIRD, holdLock);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\CatInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */