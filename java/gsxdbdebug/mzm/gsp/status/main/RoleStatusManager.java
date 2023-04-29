/*     */ package mzm.gsp.status.main;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.SStatusTipRes;
/*     */ import mzm.gsp.status.StatusEnum;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ import xbean.RoleGameStatus;
/*     */ import xtable.Gamestatus;
/*     */ 
/*     */ class RoleStatusManager
/*     */ {
/*  27 */   static Map<Integer, SingleGameStatus> statusMap = new HashMap();
/*     */   
/*     */   static RoleGameStatus getAndPutXRoleGameStatus(long roleid) {
/*  30 */     RoleGameStatus xStatus = Gamestatus.get(Long.valueOf(roleid));
/*  31 */     if (xStatus == null) {
/*  32 */       xStatus = xbean.Pod.newRoleGameStatus();
/*  33 */       Gamestatus.insert(Long.valueOf(roleid), xStatus);
/*     */     }
/*  35 */     return xStatus;
/*     */   }
/*     */   
/*     */   static RoleGameStatus getXRoleGameStatus(long roleid) {
/*  39 */     return Gamestatus.get(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   static RoleGameStatus selectXRoleGameStatus(long roleid) {
/*  43 */     return Gamestatus.select(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   static boolean setRoleStatus(List<Long> roleids, int status, boolean sendStatusTip) {
/*  47 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/*  48 */       return false;
/*     */     }
/*  50 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  51 */       RoleGameStatus xStatus = getAndPutXRoleGameStatus(roleid);
/*  52 */       StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/*  53 */       if (statusResult.oK) {
/*  54 */         xStatus.getGamestatus().add(Integer.valueOf(status));
/*  55 */         GameServer.logger().info(String.format("[RoleStatus]RoleStatusManager.setRoleStatus@set status|roleid=%d|status=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(status) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  60 */         if (sendStatusTip)
/*  61 */           sendStatusError(roleids, statusResult);
/*  62 */         return false;
/*     */       }
/*     */     }
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   private static StatusResult checkCanSetStatus(long roleid, int status, RoleGameStatus xStatus) {
/*  69 */     SingleGameStatus gameStatus = (SingleGameStatus)statusMap.get(Integer.valueOf(status));
/*  70 */     for (Map.Entry<Integer, Integer> entry : gameStatus.getMutexStatus().entrySet()) {
/*  71 */       if (xStatus.getGamestatus().contains(entry.getKey())) {
/*  72 */         StatusResult statusResult = new StatusResult(false);
/*  73 */         statusResult.setSingleTipId(((Integer)entry.getValue()).intValue());
/*  74 */         statusResult.setWrongRoleid(roleid);
/*  75 */         if (status == 14)
/*     */         {
/*  77 */           GameServer.logger().info(String.format("玩家当前不能设置多人副本状态|roleid=%d|mutex_status=%d", new Object[] { Long.valueOf(roleid), entry.getKey() }));
/*     */         }
/*  79 */         return statusResult;
/*     */       }
/*     */     }
/*  82 */     return new StatusResult(true);
/*     */   }
/*     */   
/*     */   static boolean checkCanSetStatus(List<Long> roleids, int status, boolean sendStatusTip) {
/*  86 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/*  87 */       return false;
/*     */     }
/*  89 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  90 */       RoleGameStatus xStatus = selectXRoleGameStatus(roleid);
/*  91 */       if (xStatus != null)
/*     */       {
/*     */ 
/*  94 */         StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/*  95 */         if (!statusResult.oK)
/*     */         {
/*     */ 
/*  98 */           if (sendStatusTip)
/*  99 */             sendStatusError(roleids, statusResult);
/* 100 */           return false;
/*     */         }
/*     */       } }
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkCanSetStatus(List<Long> roleids, int status, boolean sendStatusTip, boolean retainLock)
/*     */   {
/* 108 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 109 */       return false;
/*     */     }
/* 111 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 112 */       RoleGameStatus xStatus = null;
/* 113 */       if (retainLock) {
/* 114 */         xStatus = getXRoleGameStatus(roleid);
/*     */       } else {
/* 116 */         xStatus = selectXRoleGameStatus(roleid);
/*     */       }
/* 118 */       if (xStatus != null)
/*     */       {
/*     */ 
/* 121 */         StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/* 122 */         if (!statusResult.oK)
/*     */         {
/*     */ 
/* 125 */           if (sendStatusTip)
/* 126 */             sendStatusError(roleids, statusResult);
/* 127 */           return false;
/*     */         }
/*     */       } }
/* 130 */     return true;
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
/*     */   static boolean checkCanSetStatus(List<Long> roleids, int status, boolean sendStatusTip, List<Long> receiveTipRoleids)
/*     */   {
/* 143 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 144 */       return false;
/*     */     }
/* 146 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 147 */       RoleGameStatus xStatus = selectXRoleGameStatus(roleid);
/* 148 */       if (xStatus != null)
/*     */       {
/*     */ 
/* 151 */         StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/* 152 */         if (!statusResult.oK)
/*     */         {
/*     */ 
/* 155 */           if (sendStatusTip)
/* 156 */             sendStatusError(receiveTipRoleids, statusResult);
/* 157 */           return false;
/*     */         }
/*     */       } }
/* 160 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean checkCanSetStatus(List<Long> roleids, int status, boolean sendStatusTip, List<Long> receiveTipRoleids, boolean retainLock)
/*     */   {
/* 166 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 167 */       return false;
/*     */     }
/* 169 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 170 */       RoleGameStatus xStatus = null;
/* 171 */       if (retainLock) {
/* 172 */         xStatus = getXRoleGameStatus(roleid);
/*     */       } else {
/* 174 */         xStatus = selectXRoleGameStatus(roleid);
/*     */       }
/* 176 */       if (xStatus != null)
/*     */       {
/*     */ 
/* 179 */         StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/* 180 */         if (!statusResult.oK)
/*     */         {
/*     */ 
/* 183 */           if (sendStatusTip)
/* 184 */             sendStatusError(receiveTipRoleids, statusResult);
/* 185 */           return false;
/*     */         }
/*     */       } }
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkCanSetStatus(List<Long> roleids, long reciveroleid, int status, boolean sendStatusTip) {
/* 192 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 193 */       return false;
/*     */     }
/* 195 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 196 */       RoleGameStatus xStatus = selectXRoleGameStatus(roleid);
/* 197 */       if (xStatus != null)
/*     */       {
/*     */ 
/* 200 */         StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/* 201 */         if (!statusResult.oK)
/*     */         {
/*     */ 
/* 204 */           if (sendStatusTip)
/* 205 */             sendStatusError(Arrays.asList(new Long[] { Long.valueOf(reciveroleid) }), statusResult);
/* 206 */           return false;
/*     */         }
/*     */       } }
/* 209 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean checkCanSetStatus(List<Long> roleids, long reciveroleid, int status, boolean sendStatusTip, boolean retainLock)
/*     */   {
/* 215 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 216 */       return false;
/*     */     }
/* 218 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 219 */       RoleGameStatus xStatus = null;
/* 220 */       if (retainLock) {
/* 221 */         xStatus = getXRoleGameStatus(roleid);
/*     */       } else {
/* 223 */         xStatus = selectXRoleGameStatus(roleid);
/*     */       }
/* 225 */       if (xStatus != null)
/*     */       {
/*     */ 
/* 228 */         StatusResult statusResult = checkCanSetStatus(roleid, status, xStatus);
/* 229 */         if (!statusResult.oK)
/*     */         {
/*     */ 
/* 232 */           if (sendStatusTip)
/* 233 */             sendStatusError(Arrays.asList(new Long[] { Long.valueOf(reciveroleid) }), statusResult);
/* 234 */           return false;
/*     */         }
/*     */       } }
/* 237 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Long, Boolean> unsetRoleStatus(List<Long> roleids, int status)
/*     */   {
/* 261 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 262 */       GameServer.logger().error(String.format("[RoleStatus]RoleStatusManager.unsetRoleStatus@不存在的staus|roleid=%d|status=%d", new Object[] { roleids.get(0), Integer.valueOf(status) }));
/*     */     }
/*     */     
/*     */ 
/* 266 */     Map<Long, Boolean> ret = new HashMap();
/* 267 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 268 */       ret.put(Long.valueOf(roleid), Boolean.valueOf(unsetRoleStatus(roleid, status)));
/*     */     }
/*     */     
/* 271 */     return ret;
/*     */   }
/*     */   
/*     */   static Map<Long, Boolean> unsetRoleStatus(List<Long> roleids, Collection<Integer> statuses) {
/* 275 */     for (Iterator i$ = statuses.iterator(); i$.hasNext();) { int status = ((Integer)i$.next()).intValue();
/* 276 */       if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 277 */         GameServer.logger().error(String.format("[RoleStatus]RoleStatusManager.unsetRoleStatus@不存在的staus|roleid=%d|status=%d", new Object[] { roleids.get(0), Integer.valueOf(status) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 282 */     Map<Long, Boolean> ret = new HashMap();
/* 283 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 284 */       boolean modified = false;
/* 285 */       for (Iterator i$ = statuses.iterator(); i$.hasNext();) { int status = ((Integer)i$.next()).intValue();
/* 286 */         if (unsetRoleStatus(roleid, status)) {
/* 287 */           modified = true;
/*     */         }
/*     */       }
/* 290 */       ret.put(Long.valueOf(roleid), Boolean.valueOf(modified));
/*     */     }
/*     */     
/*     */ 
/* 294 */     return ret;
/*     */   }
/*     */   
/*     */   static boolean unsetRoleStatus(long roleid, int status) {
/* 298 */     if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 299 */       GameServer.logger().error(String.format("[RoleStatus]RoleStatusManager.unsetRoleStatus@不存在的staus|roleid=%d|status=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(status) }));
/*     */     }
/*     */     
/*     */ 
/* 303 */     RoleGameStatus xStatus = getAndPutXRoleGameStatus(roleid);
/* 304 */     boolean ret = xStatus.getGamestatus().remove(Integer.valueOf(status));
/* 305 */     if (ret) {
/* 306 */       GameServer.logger().info(String.format("[RoleStatus]RoleStatusManager.unsetRoleStatus@unset status|roleid=%d|status=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(status) }));
/*     */     }
/*     */     
/*     */ 
/* 310 */     return ret;
/*     */   }
/*     */   
/*     */   public static boolean unsetRoleStatus(long roleid, Collection<Integer> statuses) {
/* 314 */     for (Iterator i$ = statuses.iterator(); i$.hasNext();) { int status = ((Integer)i$.next()).intValue();
/* 315 */       if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 316 */         GameServer.logger().error(String.format("[RoleStatus]RoleStatusManager.unsetRoleStatus@不存在的staus|roleid=%d|status=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(status) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 321 */     boolean ret = false;
/* 322 */     for (Iterator i$ = statuses.iterator(); i$.hasNext();) { int status = ((Integer)i$.next()).intValue();
/* 323 */       if (unsetRoleStatus(roleid, status)) {
/* 324 */         ret = true;
/*     */       }
/*     */     }
/* 327 */     return ret;
/*     */   }
/*     */   
/*     */   static Set<Integer> getRoleStatusSet(long roleid) {
/* 331 */     Set<Integer> statusSet = new HashSet();
/*     */     
/* 333 */     RoleGameStatus xStatus = getXRoleGameStatus(roleid);
/* 334 */     if (xStatus == null) {
/* 335 */       return statusSet;
/*     */     }
/*     */     
/* 338 */     statusSet.addAll(xStatus.getGamestatus());
/*     */     
/* 340 */     return statusSet;
/*     */   }
/*     */   
/*     */   static Set<Integer> selectRoleStatusSet(long roleid) {
/* 344 */     Set<Integer> statusSet = new HashSet();
/*     */     
/* 346 */     RoleGameStatus xStatus = selectXRoleGameStatus(roleid);
/* 347 */     if (xStatus == null) {
/* 348 */       return statusSet;
/*     */     }
/*     */     
/* 351 */     statusSet.addAll(xStatus.getGamestatus());
/*     */     
/* 353 */     return statusSet;
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
/*     */   static boolean onRoleLogin(long roleid, Set<Integer> statusSet)
/*     */   {
/* 368 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/* 375 */     String statusPath = GameServer.getGamedataDir() + "/other/status" + "/statusCfg.xml";
/* 376 */     load(statusPath);
/*     */   }
/*     */   
/*     */   private static void load(String statusPath) {
/*     */     try {
/* 381 */       Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.File(statusPath));
/* 382 */       Element root = doc.getDocumentElement();
/* 383 */       NodeList stateList = root.getElementsByTagName("status");
/* 384 */       Map<Integer, SingleGameStatus> tempMap = new HashMap();
/* 385 */       for (int i = 0; i < stateList.getLength(); i++) {
/* 386 */         SingleGameStatus status = new SingleGameStatus(stateList.item(i));
/* 387 */         int statusId = status.getStatus();
/* 388 */         if (tempMap.containsKey(Integer.valueOf(status.getStatus()))) {
/* 389 */           throw new RuntimeException(String.format("status配置文件中配置了相同的status|id=%d|name=%s", new Object[] { Integer.valueOf(statusId), status.getName() }));
/*     */         }
/*     */         
/* 392 */         tempMap.put(Integer.valueOf(status.getStatus()), status);
/*     */       }
/*     */       
/* 395 */       StatusEnum statusEnum = new StatusEnum();
/* 396 */       for (Field field : StatusEnum.class.getDeclaredFields()) {
/* 397 */         field.setAccessible(true);
/* 398 */         int status = field.getInt(statusEnum);
/* 399 */         if (!tempMap.containsKey(Integer.valueOf(status))) {
/* 400 */           throw new RuntimeException(String.format("协议中配置的status没有在status配置文件中配置status路径:gamedata/other/status/statusCfg.xml|status=%d", new Object[] { Integer.valueOf(status) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 408 */       for (Map.Entry<Integer, SingleGameStatus> entry : tempMap.entrySet()) {
/* 409 */         status = ((Integer)entry.getKey()).intValue();
/* 410 */         SingleGameStatus singleGameStatus = (SingleGameStatus)entry.getValue();
/* 411 */         for (Map.Entry<Integer, Integer> singleEntry : singleGameStatus.getMutexStatus().entrySet()) {
/* 412 */           int origalStatus = ((Integer)singleEntry.getKey()).intValue();
/* 413 */           int tipid = ((Integer)singleEntry.getValue()).intValue();
/* 414 */           SingleGameStatus gameStatus = (SingleGameStatus)statusMap.get(Integer.valueOf(origalStatus));
/* 415 */           if (gameStatus == null) {
/* 416 */             gameStatus = new SingleGameStatus();
/* 417 */             gameStatus.setToClient(((SingleGameStatus)tempMap.get(Integer.valueOf(origalStatus))).isToClient());
/* 418 */             gameStatus.setStatus(origalStatus);
/* 419 */             statusMap.put(Integer.valueOf(origalStatus), gameStatus);
/*     */           }
/* 421 */           gameStatus.getMutexStatus().put(Integer.valueOf(status), Integer.valueOf(tipid));
/*     */         }
/*     */       }
/*     */       int status;
/* 425 */       for (Field field : StatusEnum.class.getDeclaredFields()) {
/* 426 */         field.setAccessible(true);
/* 427 */         int status = field.getInt(statusEnum);
/* 428 */         if (!statusMap.containsKey(Integer.valueOf(status))) {
/* 429 */           SingleGameStatus gameStatus = new SingleGameStatus();
/* 430 */           gameStatus.setToClient(((SingleGameStatus)tempMap.get(Integer.valueOf(status))).isToClient());
/* 431 */           gameStatus.setStatus(status);
/* 432 */           statusMap.put(Integer.valueOf(status), gameStatus);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 438 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendStatusError(List<Long> roleids, StatusResult statusResult)
/*     */   {
/* 449 */     SStatusTipRes sStatusTipRes = new SStatusTipRes();
/* 450 */     sStatusTipRes.ret = statusResult.getSingleTip();
/* 451 */     OnlineManager.getInstance().sendMultiAtOnce(sStatusTipRes, roleids);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 455 */     load("D:\\mzmserver\\gs\\gamedata/other/status/statusCfg.xml");
/*     */   }
/*     */   
/*     */   static Set<Integer> getToClientAllStatus(long roleid, boolean retainlock) {
/* 459 */     Set<Integer> ret = null;
/* 460 */     if (retainlock) {
/* 461 */       ret = getRoleStatusSet(roleid);
/*     */     } else {
/* 463 */       ret = selectRoleStatusSet(roleid);
/*     */     }
/* 465 */     Iterator<Integer> iterator = ret.iterator();
/* 466 */     while (iterator.hasNext()) {
/* 467 */       int status = ((Integer)iterator.next()).intValue();
/* 468 */       SingleGameStatus singleGameStatus = (SingleGameStatus)statusMap.get(Integer.valueOf(status));
/* 469 */       if ((singleGameStatus == null) || (!singleGameStatus.isToClient())) {
/* 470 */         iterator.remove();
/*     */       }
/*     */     }
/* 473 */     return ret;
/*     */   }
/*     */   
/*     */   static boolean containsStatus(long roleid, int status) {
/* 477 */     RoleGameStatus xStatus = selectXRoleGameStatus(roleid);
/* 478 */     if (xStatus == null) {
/* 479 */       return false;
/*     */     }
/* 481 */     return xStatus.getGamestatus().contains(Integer.valueOf(status));
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean containsStatus(long roleid, int status, boolean retainLock)
/*     */   {
/* 487 */     RoleGameStatus xStatus = null;
/* 488 */     if (retainLock) {
/* 489 */       xStatus = getXRoleGameStatus(roleid);
/*     */     } else {
/* 491 */       xStatus = selectXRoleGameStatus(roleid);
/*     */     }
/* 493 */     if (xStatus == null) {
/* 494 */       return false;
/*     */     }
/* 496 */     return xStatus.getGamestatus().contains(Integer.valueOf(status));
/*     */   }
/*     */   
/*     */   static boolean containsAny(long roleid, Set<Integer> statuses, boolean retainLock)
/*     */   {
/* 501 */     RoleGameStatus xStatus = null;
/* 502 */     if (retainLock) {
/* 503 */       xStatus = getXRoleGameStatus(roleid);
/*     */     } else {
/* 505 */       xStatus = selectXRoleGameStatus(roleid);
/*     */     }
/* 507 */     if (xStatus == null) {
/* 508 */       return false;
/*     */     }
/* 510 */     for (Iterator i$ = statuses.iterator(); i$.hasNext();) { int status = ((Integer)i$.next()).intValue();
/* 511 */       if (xStatus.getGamestatus().contains(Integer.valueOf(status))) {
/* 512 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 516 */     return false;
/*     */   }
/*     */   
/*     */   static boolean containsStatus(int status)
/*     */   {
/* 521 */     return statusMap.containsKey(Integer.valueOf(status));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\RoleStatusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */