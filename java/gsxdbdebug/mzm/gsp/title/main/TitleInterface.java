/*     */ package mzm.gsp.title.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.title.AppellationInfo;
/*     */ import mzm.gsp.title.confbean.SAppellationCfg;
/*     */ import mzm.gsp.title.confbean.STitleCfg;
/*     */ import mzm.gsp.title.event.AppOrTitleChange;
/*     */ import mzm.gsp.title.event.AppellationPropertyChange;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TitleAppellation;
/*     */ import xtable.Role2titleappellation;
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
/*     */ public class TitleInterface
/*     */ {
/*     */   public static boolean isRoleHaveAppellationId(long roleId, int appId)
/*     */   {
/*  36 */     return TitleManager.isRoleHaveAppellationId(roleId, appId);
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
/*     */   public static ActiveInfo getActiveTitilId(long roleId)
/*     */   {
/*  49 */     return TitleManager.getActiveTitilIdImpl(roleId);
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
/*     */   public static ActiveInfo getActiveAppellationId(long roleId)
/*     */   {
/*  62 */     return TitleManager.getActiveAppellationInfoImpl(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fillAppellationInfoBean(long roleId, AppellationInfo appellationinfo)
/*     */   {
/*  74 */     TitleManager.fillAppellationInfoBeanImpl(roleId, appellationinfo);
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
/*     */   public static String getAppNameById(long roleId, int appId)
/*     */   {
/*  89 */     return TitleManager.getAppString(roleId, appId);
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
/*     */   public static List<String> getAppArgs(long roleId, int appellationId, boolean remainLock)
/*     */   {
/* 107 */     return TitleManager.getAppArgs(roleId, appellationId, remainLock);
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
/*     */   public static boolean addAppellation(long roleId, int appellationId)
/*     */   {
/* 120 */     return addAppellation(roleId, appellationId, new ArrayList(), false);
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
/*     */   public static boolean addAppellation(long roleId, int appellationId, List<String> args)
/*     */   {
/* 135 */     return TitleManager.addNewAppellation(roleId, appellationId, args, false);
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
/*     */   public static boolean addAppellation(long roleId, int appellationId, boolean needWear)
/*     */   {
/* 148 */     return addAppellation(roleId, appellationId, new ArrayList(), needWear);
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
/*     */   public static boolean addAppellation(long roleId, int appellationId, List<String> args, boolean needWear)
/*     */   {
/* 163 */     return TitleManager.addNewAppellation(roleId, appellationId, args, needWear);
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
/*     */   public static boolean addTitle(long roleId, int titleId)
/*     */   {
/* 176 */     return TitleManager.addNewTitle(roleId, titleId);
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
/*     */   public static void addAppellationNoneRealTime(long roleId, int appellationId)
/*     */   {
/* 189 */     addAppellationNoneRealTime(roleId, appellationId, new ArrayList(), false);
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
/*     */   public static void addAppellationNoneRealTime(long roleId, int appellationId, boolean needWear)
/*     */   {
/* 204 */     addAppellationNoneRealTime(roleId, appellationId, new ArrayList(), needWear);
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
/*     */   public static void addAppellationNoneRealTime(long roleId, int appellationId, List<String> args)
/*     */   {
/* 219 */     NoneRealTimeTaskManager.getInstance().addTask(new PAddAppellationId(roleId, appellationId, args, false));
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
/*     */   public static void addAppellationNoneRealTime(long roleId, int appellationId, List<String> args, boolean needWear)
/*     */   {
/* 236 */     NoneRealTimeTaskManager.getInstance().addTask(new PAddAppellationId(roleId, appellationId, args, needWear));
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
/*     */   public static void replaceAppellationArgsNoneRealTime(long roleId, int appellationId, List<String> args)
/*     */   {
/* 253 */     NoneRealTimeTaskManager.getInstance().addTask(new PReplaceAppArgs(roleId, appellationId, args));
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
/*     */   public static boolean replaceAppellationArgs(long roleId, int appellationId, List<String> args)
/*     */   {
/* 270 */     return new PReplaceAppArgs(roleId, appellationId, args).call();
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
/*     */   public static void addTitleNoneRealTime(long roleId, int titleId)
/*     */   {
/* 283 */     new PAddTitle(roleId, titleId).execute();
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
/*     */   public static boolean removeAppllation(long roleId, int appellationId)
/*     */   {
/* 298 */     return new PRemoveAppellation(roleId, appellationId).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isAppellationExit(int appellationId)
/*     */   {
/* 309 */     return SAppellationCfg.get(appellationId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isTitleExit(int titleId)
/*     */   {
/* 320 */     return STitleCfg.get(titleId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getAppellationPropertyMap(int appellationId)
/*     */   {
/* 332 */     return TitleManager.getPropertyMap(appellationId);
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
/*     */   public static Map<Integer, Integer> getNowPropertyMap(long roleId)
/*     */   {
/* 345 */     TitleAppellation xTitleAppellation = Role2titleappellation.select(Long.valueOf(roleId));
/* 346 */     if (xTitleAppellation == null)
/*     */     {
/* 348 */       return new HashMap();
/*     */     }
/* 350 */     int proAppId = xTitleAppellation.getPro2appellationid();
/* 351 */     if (proAppId <= 0)
/*     */     {
/* 353 */       return new HashMap();
/*     */     }
/* 355 */     if (!xTitleAppellation.getAppellations().keySet().contains(Integer.valueOf(proAppId)))
/*     */     {
/* 357 */       GameServer.logger().error(String.format("[title]TitleInterface.getNowPropertyMap@ not own this proAppId!|roleId=%d|proAppId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(proAppId) }));
/*     */       
/*     */ 
/* 360 */       return new HashMap();
/*     */     }
/* 362 */     return TitleManager.getPropertyMap(proAppId);
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
/*     */   public static List<Integer> getNotOwnAppIds(long roleId, List<Integer> appIds)
/*     */   {
/* 378 */     return TitleManager.getNotOwnAppIds(roleId, appIds);
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
/*     */   private static boolean updateTitleInfoWhenOccupationChange(String logStr, long roleId, int newOccupation, int oldOccupation)
/*     */   {
/* 396 */     if (newOccupation == oldOccupation)
/*     */     {
/* 398 */       GameServer.logger().error(String.format("[title]TitleInterface.%s@new occupation same with current occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { logStr, Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 402 */       return false;
/*     */     }
/*     */     
/* 405 */     TitleAppellation xRole2TitleAppellationInfo = Role2titleappellation.get(Long.valueOf(roleId));
/* 406 */     if (xRole2TitleAppellationInfo == null)
/*     */     {
/* 408 */       GameServer.logger().warn(String.format("[title]TitleInterface.%s@role title appellaton info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { logStr, Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 412 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 416 */     int activeAppellationCfgId = xRole2TitleAppellationInfo.getActiveappellation();
/* 417 */     SAppellationCfg sActiveAppellationCfg = SAppellationCfg.get(activeAppellationCfgId);
/* 418 */     if ((sActiveAppellationCfg != null) && (sActiveAppellationCfg.occupation != 0))
/*     */     {
/* 420 */       if (sActiveAppellationCfg.occupation != newOccupation)
/*     */       {
/*     */ 
/* 423 */         int oldAppellationCfgId = xRole2TitleAppellationInfo.getActiveappellation();
/* 424 */         xRole2TitleAppellationInfo.setActiveappellation(0);
/*     */         
/* 426 */         AppOrTitleChangeArg appOrTitleChangeArg = new AppOrTitleChangeArg(roleId, 0, 0, oldAppellationCfgId, TitleChangeReasonEnum.CHANGE_OCCUPATION);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 431 */         TriggerEventsManger.getInstance().triggerEvent(new AppOrTitleChange(), appOrTitleChangeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 437 */     int pro2appellationid = xRole2TitleAppellationInfo.getPro2appellationid();
/* 438 */     SAppellationCfg sProbAppellationCfg = SAppellationCfg.get(pro2appellationid);
/* 439 */     if ((sProbAppellationCfg != null) && (sProbAppellationCfg.occupation != 0))
/*     */     {
/* 441 */       if (sProbAppellationCfg.occupation != newOccupation)
/*     */       {
/*     */ 
/* 444 */         xRole2TitleAppellationInfo.setPro2appellationid(0);
/*     */         
/*     */ 
/* 447 */         TriggerEventsManger.getInstance().triggerEvent(new AppellationPropertyChange(), new AppellationPropertyChangeArg(roleId, TitleChangeReasonEnum.CHANGE_OCCUPATION), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 454 */     GameServer.logger().info(String.format("[title]TitleInterface.%s@|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { logStr, Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */     
/*     */ 
/* 457 */     return true;
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
/*     */   public static boolean activeNewOccupation(long roleId, int newOccupation, int oldOccupation)
/*     */   {
/* 476 */     boolean result = updateTitleInfoWhenOccupationChange("activeNewOccupation", roleId, newOccupation, oldOccupation);
/* 477 */     return result;
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
/*     */   public static boolean switchOccupation(long roleId, int newOccupation, int oldOccupation)
/*     */   {
/* 494 */     boolean result = updateTitleInfoWhenOccupationChange("switchOccupation", roleId, newOccupation, oldOccupation);
/* 495 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TitleOptionResult rmAppellantion4IDIP(long roleId, int appellationId)
/*     */   {
/* 507 */     TitleOptionResult res = TitleManager.rmAppellantion(roleId, appellationId);
/* 508 */     if (res == TitleOptionResult.SUCCESS)
/*     */     {
/* 510 */       OnlineManager.getInstance().forceReconnect(roleId);
/*     */     }
/* 512 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\TitleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */