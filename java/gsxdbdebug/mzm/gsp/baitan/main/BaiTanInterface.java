/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid;
/*     */ import xbean.Item;
/*     */ import xbean.RoleGrid;
/*     */ import xtable.Role2grid;
/*     */ import xtable.Roleshoppinginfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaiTanInterface
/*     */ {
/*     */   public static int getSubTypeGroup(int itemId)
/*     */   {
/*  18 */     return BaiTanManager.getSubtypeidByItemid(itemId);
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
/*     */   public static int getBigTypeGroup(int itemId)
/*     */   {
/*  31 */     int subTypeId = getSubTypeGroup(itemId);
/*  32 */     if (subTypeId == -1)
/*     */     {
/*  34 */       return -1;
/*     */     }
/*     */     
/*  37 */     return BaiTanManager.getBigTypeBySubType(subTypeId);
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
/*     */   public static int getItemPrice(int itemId)
/*     */   {
/*  50 */     return getItemRecommandPrice(itemId);
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
/*     */   public static int getItemRecommandPrice(int itemId)
/*     */   {
/*  63 */     return BaiTanManager.getItemRecommendPrice(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isBaitanItem(int itemid)
/*     */   {
/*  74 */     return SItemId2BaitanItemCfgid.get(itemid) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getNowBaiTanShangJiaCount(long roleId)
/*     */   {
/*  85 */     RoleGrid xGrid = Role2grid.get(Long.valueOf(roleId));
/*  86 */     if (xGrid == null)
/*     */     {
/*  88 */       return 0;
/*     */     }
/*  90 */     int c = 0;
/*  91 */     for (Iterator i$ = xGrid.getShoppingid2channelid().keySet().iterator(); i$.hasNext();) { long shoppingid = ((Long)i$.next()).longValue();
/*     */       
/*  93 */       Item xItem = Roleshoppinginfo.selectItem(Long.valueOf(shoppingid));
/*  94 */       if (xItem != null)
/*     */       {
/*     */ 
/*     */ 
/*  98 */         c += xItem.getNumber();
/*     */       }
/*     */     }
/* 101 */     return c;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\BaiTanInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */