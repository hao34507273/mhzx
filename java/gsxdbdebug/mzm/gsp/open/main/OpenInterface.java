/*     */ package mzm.gsp.open.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpenInterface
/*     */ {
/*     */   public static boolean isBanPlay(long var0, int var2)
/*     */   {
/*  17 */     return IdipManager.isBanPlay(var0, var2);
/*     */   }
/*     */   
/*     */   public static void sendBanPlayMsg(long var0, int var2) {
/*  21 */     IdipManager.banPlayMsg(var0, var2);
/*     */   }
/*     */   
/*     */   public static void sendBanPlayMsg(long var0, long var2, String var4, int var5) {
/*  25 */     IdipManager.banPlayQueryMsg(var0, var2, var4, var5);
/*     */   }
/*     */   
/*     */   public static boolean getOpenStatus(int var0) {
/*  29 */     return OpenManager.isModuleFunSwitchOpen(var0);
/*     */   }
/*     */   
/*     */   public static boolean getOpenStatus(int var0, int var1) {
/*  33 */     return OpenManager.isModuleFunSwitchOpen(var0, var1);
/*     */   }
/*     */   
/*     */   public static List<Integer> getModuleFunSwitchParams(int var0) {
/*  37 */     return OpenManager.getModuleFunSwitchParams(var0);
/*     */   }
/*     */   
/*     */   public static List<Integer> getModuleFunSwitchParams(int var0, int var1) {
/*  41 */     return OpenManager.getModuleFunSwitchParams(var0, var1);
/*     */   }
/*     */   
/*     */   public static boolean containsModuleFunSwitchInfo(int var0) {
/*  45 */     return OpenManager.getModuleFunSwitchParams(var0) != null;
/*     */   }
/*     */   
/*     */   public static boolean containsModuleFunSwitchInfo(int var0, int var1) {
/*  49 */     return OpenManager.getModuleFunSwitchParams(var0, var1) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static void setOpenDefaultStatus(int var0, boolean var1) {}
/*     */   
/*     */ 
/*     */   @Deprecated
/*     */   public static void setOpenDefaultStatus(int var0, int var1, boolean var2) {}
/*     */   
/*     */ 
/*     */   @Deprecated
/*     */   public static void setOpenDefaultStatus(int var0, int var1, List<Integer> var2, boolean var3) {}
/*     */   
/*     */ 
/*     */   public static void setOpenStatus(int var0, boolean var1)
/*     */   {
/*  68 */     OpenManager.setModuleFunSwitchStatus(var0, 0, (List)null, var1);
/*     */   }
/*     */   
/*     */   public static void setOpenStatus(int var0, int var1, boolean var2) {
/*  72 */     OpenManager.setModuleFunSwitchStatus(var0, var1, (List)null, var2);
/*     */   }
/*     */   
/*     */   public static void setOpenStatus(int var0, int var1, List<Integer> var2, boolean var3) {
/*  76 */     OpenManager.setModuleFunSwitchStatus(var0, var1, var2, var3);
/*     */   }
/*     */   
/*     */ 
/*     */   @Deprecated
/*     */   public static void sendCloseProtocol(long var0, int var2) {}
/*     */   
/*     */ 
/*     */   @Deprecated
/*     */   public static void sendCloseProtocol(long var0, int var2, List<String> var3) {}
/*     */   
/*     */ 
/*     */   public static void getModuleFunSwitches(Protocol var0)
/*     */   {
/*  90 */     OpenManager.getModuleFunSwitches(var0);
/*     */   }
/*     */   
/*     */   public static boolean isGrayValid(String var0) {
/*  94 */     return OpenManager.isGrayValid(var0);
/*     */   }
/*     */   
/*     */   public static boolean isGrayValid(long var0) {
/*  98 */     return OpenManager.isGrayValid(var0);
/*     */   }
/*     */   
/*     */   public static boolean isGrayValid(int var0) {
/* 102 */     return OpenManager.isGrayValid(var0);
/*     */   }
/*     */   
/*     */   public static List<Integer> getCloseStatusModuleFunSwitches() {
/* 106 */     return OpenManager.getCloseStatusModuleFunSwitches();
/*     */   }
/*     */   
/*     */   public static boolean isModuleidValid(int var0) {
/* 110 */     return (var0 >= 0) && (var0 <= 1125);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\main\OpenInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */