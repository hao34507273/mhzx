/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
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
/*     */ public class BanquestTlogManager
/*     */ {
/*     */   static void tlogHoldBanquest(long roleId, int curHoldCount, long startTime, String masterUserId, long masterId)
/*     */   {
/*  31 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  32 */     String userid = RoleInterface.getUserId(roleId);
/*  33 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  35 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(curHoldCount), Long.valueOf(startTime), masterUserId, Long.valueOf(masterId) };
/*     */     
/*  37 */     TLogManager.getInstance().addLog(roleId, "HoldBanquest", colums);
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
/*     */   static void tlogBanquestEnd(long roleId, int curHoldCount, long startTime)
/*     */   {
/*  52 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  53 */     String userid = RoleInterface.getUserId(roleId);
/*  54 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  56 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(curHoldCount), Long.valueOf(startTime) };
/*     */     
/*  58 */     TLogManager.getInstance().addLog(roleId, "HoldBanquestEnd", colums);
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
/*     */   static void tlogOfferDishes(long masterId, Map<Integer, Integer> controllerInfo, int dishesCount, int dishRank, long startTime)
/*     */   {
/*  76 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  77 */     String userid = RoleInterface.getUserId(masterId);
/*  78 */     int rolelevel = RoleInterface.getLevel(masterId);
/*     */     
/*  80 */     String controllerInfoStr = getControllerInfoStr(controllerInfo);
/*     */     
/*  82 */     Object[] colums = { vGameIP, userid, Long.valueOf(masterId), Integer.valueOf(rolelevel), controllerInfoStr, Integer.valueOf(dishesCount), Integer.valueOf(dishRank), Long.valueOf(startTime) };
/*     */     
/*     */ 
/*  85 */     TLogManager.getInstance().addLog(masterId, "OfferDishes", colums);
/*     */   }
/*     */   
/*     */   private static String getControllerInfoStr(Map<Integer, Integer> controllerInfo)
/*     */   {
/*  90 */     StringBuffer sb = new StringBuffer();
/*  91 */     sb.append("{");
/*  92 */     Iterator<Map.Entry<Integer, Integer>> it = controllerInfo.entrySet().iterator();
/*  93 */     while (it.hasNext())
/*     */     {
/*  95 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/*  96 */       int controllerId = ((Integer)entry.getKey()).intValue();
/*  97 */       int num = ((Integer)entry.getValue()).intValue();
/*     */       
/*  99 */       sb.append(controllerId);
/* 100 */       sb.append("=");
/* 101 */       sb.append(num);
/* 102 */       sb.append(",");
/*     */     }
/* 104 */     sb.append("}");
/*     */     
/* 106 */     return sb.toString();
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
/*     */ 
/*     */ 
/*     */   static void tlogPickUpDishes(long roleId, long masterId, int dishesCount, int itemCfgid, int itemNum, long startTime)
/*     */   {
/* 127 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 128 */     String userid = RoleInterface.getUserId(roleId);
/* 129 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 131 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(masterId), Integer.valueOf(dishesCount), Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Long.valueOf(startTime) };
/*     */     
/*     */ 
/* 134 */     TLogManager.getInstance().addLog(masterId, "PickUpDishes", colums);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\BanquestTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */