/*     */ package mzm.gsp.guaji.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.guaji.confbean.SMapGuajiConf;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.DoublePoint;
/*     */ import xtable.Role2doublepoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuajiInterface
/*     */ {
/*     */   public static List<Integer> getAllSendMapId()
/*     */   {
/*  17 */     return GuajiManager.getAllSendMapId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getUsableDoublePoint(long roleId)
/*     */   {
/*  27 */     DoublePoint xDoublePoint = Role2doublepoint.select(Long.valueOf(roleId));
/*  28 */     if (xDoublePoint == null) {
/*  29 */       return 0;
/*     */     }
/*  31 */     return xDoublePoint.getFrozenpoolpointnum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getGetingpoolDoublePoint(long roleId)
/*     */   {
/*  40 */     DoublePoint xDoublePoint = Role2doublepoint.select(Long.valueOf(roleId));
/*  41 */     if (xDoublePoint == null) {
/*  42 */       return 0;
/*     */     }
/*  44 */     return xDoublePoint.getGettingpoolpointnum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addGetingpoolDoublePoint(long roleId, int num, TLogArg logArg)
/*     */   {
/*  54 */     return GuajiManager.addGetingpoolDoublePoint(roleId, num, logArg);
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
/*     */   public static boolean costDoublePoint(long roleId, SwitchType type, int number, TLogArg logArg)
/*     */   {
/*  67 */     return GuajiManager.costFrozenPoint(roleId, type, number, logArg);
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
/*     */   public static boolean costDoublePointFromBothPool(long roleId, SwitchType type, int number, TLogArg logArg)
/*     */   {
/*  82 */     return GuajiManager.costDoublePointFromBothPool(roleId, type, number, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getItemUseCount(long roleId)
/*     */   {
/*  92 */     return GuajiManager.getItemUseCount(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addItemUseCount(long roleId)
/*     */   {
/* 103 */     return GuajiManager.addItemUseCount(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isRightLevelGuaJiMap(long roleId, int mapId)
/*     */   {
/* 113 */     for (SMapGuajiConf sMapGuajiConf : SMapGuajiConf.getAll().values()) {
/* 114 */       if (sMapGuajiConf.sendMapId == mapId) {
/* 115 */         int roleLevel = RoleInterface.getLevel(roleId);
/* 116 */         if ((sMapGuajiConf.maxLevel < roleLevel) || (sMapGuajiConf.minLevel > roleLevel)) {
/* 117 */           return false;
/*     */         }
/* 119 */         return true;
/*     */       }
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\GuajiInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */