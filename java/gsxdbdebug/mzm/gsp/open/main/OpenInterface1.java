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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpenInterface
/*     */ {
/*     */   public static boolean isBanPlay(long roleid, int moduleid)
/*     */   {
/*  22 */     return IdipManager.isBanPlay(roleid, moduleid);
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
/*     */   public static void sendBanPlayMsg(long roleid, int moduleid)
/*     */   {
/*  35 */     IdipManager.banPlayMsg(roleid, moduleid);
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
/*     */ 
/*     */   public static void sendBanPlayMsg(long targetRoleid, long banRoleid, String banRolename, int moduleid)
/*     */   {
/*  54 */     IdipManager.banPlayQueryMsg(targetRoleid, banRoleid, banRolename, moduleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean getOpenStatus(int moduleid)
/*     */   {
/*  66 */     return OpenManager.isModuleFunSwitchOpen(moduleid);
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
/*     */   public static boolean getOpenStatus(int moduleid, int funid)
/*     */   {
/*  80 */     return OpenManager.isModuleFunSwitchOpen(moduleid, funid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getModuleFunSwitchParams(int moduleid)
/*     */   {
/*  92 */     return OpenManager.getModuleFunSwitchParams(moduleid);
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
/*     */   public static List<Integer> getModuleFunSwitchParams(int moduleid, int funid)
/*     */   {
/* 106 */     return OpenManager.getModuleFunSwitchParams(moduleid, funid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean containsModuleFunSwitchInfo(int moduleid)
/*     */   {
/* 118 */     return OpenManager.getModuleFunSwitchParams(moduleid) != null;
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
/*     */   public static boolean containsModuleFunSwitchInfo(int moduleid, int funid)
/*     */   {
/* 132 */     return OpenManager.getModuleFunSwitchParams(moduleid, funid) != null;
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
/*     */   @Deprecated
/*     */   public static void setOpenDefaultStatus(int moduleid, boolean isOpen) {}
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
/*     */   @Deprecated
/*     */   public static void setOpenDefaultStatus(int moduleid, int funid, boolean isOpen) {}
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
/*     */   @Deprecated
/*     */   public static void setOpenDefaultStatus(int moduleid, int funid, List<Integer> params, boolean isOpen) {}
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
/*     */   public static void setOpenStatus(int moduleid, boolean isOpen)
/*     */   {
/* 194 */     OpenManager.setModuleFunSwitchStatus(moduleid, 0, null, isOpen);
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
/*     */   public static void setOpenStatus(int moduleid, int funid, boolean isOpen)
/*     */   {
/* 209 */     OpenManager.setModuleFunSwitchStatus(moduleid, funid, null, isOpen);
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
/*     */   public static void setOpenStatus(int moduleid, int funid, List<Integer> params, boolean isOpen)
/*     */   {
/* 226 */     OpenManager.setModuleFunSwitchStatus(moduleid, funid, params, isOpen);
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
/*     */   @Deprecated
/*     */   public static void sendCloseProtocol(long roleid, int moduleid) {}
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
/*     */   @Deprecated
/*     */   public static void sendCloseProtocol(long roleid, int moduleid, List<String> params) {}
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
/*     */   public static void getModuleFunSwitches(Protocol core)
/*     */   {
/* 266 */     OpenManager.getModuleFunSwitches(core);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isGrayValid(String userid)
/*     */   {
/* 278 */     return OpenManager.isGrayValid(userid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isGrayValid(long roleid)
/*     */   {
/* 290 */     return OpenManager.isGrayValid(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isGrayValid(int zoneid)
/*     */   {
/* 302 */     return OpenManager.isGrayValid(zoneid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getCloseStatusModuleFunSwitches()
/*     */   {
/* 312 */     return OpenManager.getCloseStatusModuleFunSwitches();
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
/*     */   public static boolean isModuleidValid(int moduleid)
/*     */   {
/* 325 */     return (moduleid >= 0) && (moduleid <= 592);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\main\OpenInterface1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */