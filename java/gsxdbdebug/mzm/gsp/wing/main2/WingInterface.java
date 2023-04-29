/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.wing.WingSimpleData;
/*     */ import mzm.gsp.wing.confbean.SWingInfoCfg;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import mzm.gsp.wing.event.WingModelChangedArg;
/*     */ import mzm.gsp.wing.event.WingModelChangedEvent;
/*     */ import mzm.gsp.wing.event.WingPropertyChangedArg;
/*     */ import mzm.gsp.wing.event.WingPropertyChangedEvent;
/*     */ import mzm.gsp.wing.event.WingSkillChangedArg;
/*     */ import mzm.gsp.wing.event.WingSkillChangedEvent;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.Pod;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xbean.WingContent;
/*     */ import xbean.WingPlan;
/*     */ import xtable.Role2wingplans;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WingInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getCurWingPlanPros(long roleId, boolean remainLock)
/*     */   {
/*  35 */     return WingInterfaceImpl.getCurWingPlanPros(roleId, remainLock);
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
/*     */   public static Map<Integer, Integer> getCurWingPlanSkills(long roleId, boolean remainLock)
/*     */   {
/*  51 */     return WingInterfaceImpl.getCurWingPlanSkills(roleId, remainLock);
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
/*     */   public static boolean addNewWing(long roleId, int wingId)
/*     */   {
/*  67 */     return new PAddWing(roleId, wingId).call();
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
/*     */   public static boolean openNewWingPlan(long roleId)
/*     */   {
/*  83 */     return new POpenWingPlan(roleId).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMinRoleLvForWing()
/*     */   {
/*  95 */     return WingCfgConsts.getInstance().MIN_ROLE_LEVLE_FOR_WING;
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
/*     */   public static RoleWingCheckData getRoleWingData(long roleId, boolean remainLock)
/*     */   {
/* 111 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, remainLock);
/* 112 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 113 */     if (xWingPlan == null)
/*     */     {
/* 115 */       return null;
/*     */     }
/* 117 */     return new RoleWingCheckData(xWingPlan);
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
/*     */   public static int getRoleWingLevel(long roleId, boolean remainRoleLock)
/*     */   {
/* 132 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, remainRoleLock);
/* 133 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 134 */     if (xWingPlan == null)
/*     */     {
/* 136 */       return -1;
/*     */     }
/* 138 */     return xWingPlan.getCurlv();
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
/*     */   public static WingSimpleData getWingSimpleData(long roleId, int wingId)
/*     */   {
/* 154 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, false);
/* 155 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 156 */     if (xWingPlan == null)
/*     */     {
/* 158 */       return null;
/*     */     }
/*     */     
/* 161 */     if (wingId < 0)
/*     */     {
/* 163 */       RoleWingPlan xPlan = new RoleWingPlan(roleId, 1, xWingPlan);
/* 164 */       if (wingId > 0)
/*     */       {
/* 166 */         if (!xPlan.hasWing(wingId))
/*     */         {
/* 168 */           return null;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 173 */         wingId = xWingPlan.getCurwing();
/* 174 */         if (wingId <= 0)
/*     */         {
/* 176 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 181 */     return new WingSimpleData(xWingPlan.getCurlv(), xWingPlan.getCurrank(), wingId);
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
/*     */   public static WingSimpleData getWingSimpleData(long roleId)
/*     */   {
/* 195 */     return getWingSimpleData(roleId, -1);
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
/*     */   public static WingExteriorInfo getEquipedWingId(long roleid, boolean remainRoleLock)
/*     */   {
/* 211 */     return WingInterfaceImpl.getEquipedWingId(roleid, remainRoleLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class WingExteriorInfo
/*     */   {
/*     */     private int exteriorId;
/*     */     
/*     */ 
/*     */     private int colorId;
/*     */     
/*     */ 
/*     */ 
/*     */     public WingExteriorInfo(int wingInfoId, int colorId)
/*     */     {
/* 227 */       this.exteriorId = wingInfoId;
/* 228 */       this.colorId = colorId;
/*     */     }
/*     */     
/*     */     public int getExteriorId()
/*     */     {
/* 233 */       return this.exteriorId;
/*     */     }
/*     */     
/*     */     public int getColorId()
/*     */     {
/* 238 */       return this.colorId;
/*     */     }
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
/*     */   public static boolean activeNewOccupation(long roleId, int newOccupation, int oldOccupation)
/*     */   {
/* 259 */     if (newOccupation == oldOccupation)
/*     */     {
/* 261 */       GameServer.logger().error(String.format("[wing]WingInterface.activeNewOccupation@new occupation same with current occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 265 */       return false;
/*     */     }
/*     */     
/* 268 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleId));
/* 269 */     if (xAllWingPlans == null)
/*     */     {
/* 271 */       GameServer.logger().error(String.format("[wing]WingInterface.activeNewOccupation@role wing info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 275 */       return false;
/*     */     }
/*     */     
/* 278 */     Map<Integer, TransferOccupationWing> xTransferOccupatonWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/* 279 */     if (xTransferOccupatonWingMap.isEmpty())
/*     */     {
/*     */ 
/* 282 */       GameServer.logger().error(String.format("[wing]WingInterface.activeNewOccupation@xTransferOccupatonWingMap is empty|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 286 */       return false;
/*     */     }
/* 288 */     TransferOccupationWing xNewOccWingData = (TransferOccupationWing)xTransferOccupatonWingMap.get(Integer.valueOf(newOccupation));
/* 289 */     if (xNewOccWingData == null)
/*     */     {
/* 291 */       TransferOccupationWing xCurWingData = getEffectWingData(xAllWingPlans);
/* 292 */       if (xCurWingData == null)
/*     */       {
/*     */ 
/* 295 */         GameServer.logger().error(String.format("[wing]WingInterface.activeNewOccupation@xCurWingData is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */         
/*     */ 
/*     */ 
/* 299 */         return false;
/*     */       }
/* 301 */       xTransferOccupatonWingMap.put(Integer.valueOf(newOccupation), xNewOccWingData = copyWingData(xCurWingData));
/* 302 */       if (xNewOccWingData.getWings().size() > 0)
/*     */       {
/* 304 */         xAllWingPlans.getOcc2lastplanoccid().put(Integer.valueOf(newOccupation), Integer.valueOf(newOccupation));
/* 305 */         xAllWingPlans.getNewoccplans().add(Integer.valueOf(newOccupation));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 313 */     if (xNewOccWingData.getWings().size() != 0)
/*     */     {
/* 315 */       Integer needOpenPlanOccId = (Integer)xAllWingPlans.getOcc2lastplanoccid().get(Integer.valueOf(newOccupation));
/* 316 */       if (needOpenPlanOccId == null)
/*     */       {
/* 318 */         needOpenPlanOccId = Integer.valueOf(newOccupation);
/*     */       }
/*     */       
/* 321 */       if (!WingManager.changeOccPlan(roleId, needOpenPlanOccId.intValue(), newOccupation))
/*     */       {
/*     */ 
/* 324 */         GameServer.logger().error(String.format("[wing]WingInterface.activeNewOccupation@changeOccPlan is err|role_id=%d|new_occupation=%d|old_occupation=%d|needOpenPlanOccId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation), needOpenPlanOccId }));
/*     */         
/*     */ 
/*     */ 
/* 328 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 334 */       xAllWingPlans.setEffectwingoccid(newOccupation);
/*     */     }
/*     */     
/* 337 */     GameServer.logger().info(String.format("[wing]WingInterface.activeNewOccupation@|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */     
/*     */ 
/* 340 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static TransferOccupationWing getEffectWingData(AllWingPlans xAllWingPlans)
/*     */   {
/* 351 */     return (TransferOccupationWing)xAllWingPlans.getTransfer_occupation_wing_map().get(Integer.valueOf(xAllWingPlans.getEffectwingoccid()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static TransferOccupationWing copyWingData(TransferOccupationWing xWingData)
/*     */   {
/* 362 */     TransferOccupationWing xNewOccupationWingPlan = Pod.newTransferOccupationWing();
/*     */     
/* 364 */     xNewOccupationWingPlan.setCurplan(xWingData.getCurplan());
/*     */     
/*     */ 
/* 367 */     Map<Integer, WingPlan> xNewOccupationWingPlanMap = xNewOccupationWingPlan.getWings();
/* 368 */     for (Map.Entry<Integer, WingPlan> entry : xWingData.getWings().entrySet())
/*     */     {
/* 370 */       xNewOccupationWingPlanMap.put(entry.getKey(), ((WingPlan)entry.getValue()).copy());
/*     */     }
/* 372 */     return xNewOccupationWingPlan;
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
/* 389 */     if (newOccupation == oldOccupation)
/*     */     {
/* 391 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@new occupation same with old occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 395 */       return false;
/*     */     }
/*     */     
/* 398 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleId));
/* 399 */     if (xAllWingPlans == null)
/*     */     {
/* 401 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@role wing info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 405 */       return false;
/*     */     }
/* 407 */     TransferOccupationWing xCurWingInfo = getEffectWingData(xAllWingPlans);
/* 408 */     if (xCurWingInfo == null)
/*     */     {
/* 410 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@ cur wing info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 414 */       return false;
/*     */     }
/* 416 */     if (xCurWingInfo.getWings().size() == 0)
/*     */     {
/* 418 */       xAllWingPlans.setEffectwingoccid(newOccupation);
/* 419 */       GameServer.logger().info(String.format("[wing]WingInterface.switchOccupation@ not get any wing, transform suc! |role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 423 */       return true;
/*     */     }
/* 425 */     Integer needOpenPlanOccId = (Integer)xAllWingPlans.getOcc2lastplanoccid().get(Integer.valueOf(newOccupation));
/* 426 */     if (needOpenPlanOccId == null)
/*     */     {
/* 428 */       needOpenPlanOccId = Integer.valueOf(newOccupation);
/*     */     }
/*     */     
/* 431 */     if (!WingManager.changeOccPlan(roleId, needOpenPlanOccId.intValue(), newOccupation))
/*     */     {
/*     */ 
/* 434 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@ changeOccPlan err|role_id=%d|new_occupation=%d|old_occupation=%d|needOpenPlanOccId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation), needOpenPlanOccId }));
/*     */       
/*     */ 
/*     */ 
/* 438 */       return false;
/*     */     }
/* 440 */     GameServer.logger().info(String.format("[wing]WingInterface.switchOccupation@ transform suc|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */     
/*     */ 
/*     */ 
/* 444 */     return true;
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
/*     */   public static boolean switchOccupation_old(long roleId, int newOccupation, int oldOccupation)
/*     */   {
/* 461 */     if (newOccupation == oldOccupation)
/*     */     {
/* 463 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@new occupation same with old occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 467 */       return false;
/*     */     }
/*     */     
/* 470 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(roleId));
/* 471 */     if (xAllWingPlans == null)
/*     */     {
/* 473 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@role wing info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 477 */       return false;
/*     */     }
/*     */     
/* 480 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/*     */     
/* 482 */     TransferOccupationWing xOldOccupationWing = Pod.newTransferOccupationWing();
/* 483 */     xOldOccupationWing.setCurplan(xAllWingPlans.getCurplan());
/*     */     
/* 485 */     Map<Integer, WingPlan> xOldOccupationWingPlanMap = xOldOccupationWing.getWings();
/* 486 */     for (Map.Entry<Integer, WingPlan> entry : xAllWingPlans.getWings().entrySet())
/*     */     {
/* 488 */       xOldOccupationWingPlanMap.put(entry.getKey(), ((WingPlan)entry.getValue()).copy());
/*     */     }
/* 490 */     xTransferOccupationWingMap.put(Integer.valueOf(oldOccupation), xOldOccupationWing);
/*     */     
/*     */ 
/* 493 */     TransferOccupationWing xNewOccupationWingPlan = (TransferOccupationWing)xTransferOccupationWingMap.remove(Integer.valueOf(newOccupation));
/* 494 */     if (xNewOccupationWingPlan == null)
/*     */     {
/* 496 */       GameServer.logger().error(String.format("[wing]WingInterface.switchOccupation@role not has the new occupation wing info|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newOccupation), Integer.valueOf(oldOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 500 */       return false;
/*     */     }
/*     */     
/* 503 */     xAllWingPlans.setCurplan(xNewOccupationWingPlan.getCurplan());
/* 504 */     Map<Integer, WingPlan> xCurrentOccupationWingMap = xAllWingPlans.getWings();
/* 505 */     xCurrentOccupationWingMap.clear();
/* 506 */     for (Map.Entry<Integer, WingPlan> entry : xNewOccupationWingPlan.getWings().entrySet())
/*     */     {
/* 508 */       xCurrentOccupationWingMap.put(entry.getKey(), ((WingPlan)entry.getValue()).copy());
/*     */     }
/*     */     
/*     */ 
/* 512 */     WingPlan xWingPlan = (WingPlan)xCurrentOccupationWingMap.get(Integer.valueOf(1));
/* 513 */     if (xWingPlan == null)
/*     */     {
/* 515 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 519 */     WingPropertyChangedArg wingPropertyChangedArg = new WingPropertyChangedArg(roleId, WingChangeReasonEnum.CHANGE_OCCUPATION);
/*     */     
/* 521 */     TriggerEventsManger.getInstance().triggerEvent(new WingPropertyChangedEvent(), wingPropertyChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/*     */ 
/* 525 */     WingSkillChangedArg wingSkillChangedArg = new WingSkillChangedArg(roleId, WingChangeReasonEnum.CHANGE_OCCUPATION);
/* 526 */     TriggerEventsManger.getInstance().triggerEvent(new WingSkillChangedEvent(), wingSkillChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/* 529 */     int newWingCfgId = xWingPlan.getCurwing();
/* 530 */     int newWingColorId = getWingColorId(newWingCfgId, xWingPlan);
/*     */     
/* 532 */     WingPlan xOldWingPlan = (WingPlan)xOldOccupationWing.getWings().get(Integer.valueOf(1));
/* 533 */     int oldWingCfgId = xOldWingPlan.getCurwing();
/* 534 */     int oldWingColorId = getWingColorId(oldWingCfgId, xOldWingPlan);
/*     */     
/*     */ 
/* 537 */     WingModelChangedArg wingModelChangedArg = new WingModelChangedArg(roleId, oldWingCfgId, oldWingColorId, newWingCfgId, newWingColorId, WingChangeReasonEnum.CHANGE_OCCUPATION);
/*     */     
/*     */ 
/* 540 */     TriggerEventsManger.getInstance().triggerEvent(new WingModelChangedEvent(), wingModelChangedArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/* 542 */     return true;
/*     */   }
/*     */   
/*     */   private static int getWingColorId(int wingId, WingPlan xWingPlan)
/*     */   {
/* 547 */     WingContent xWingData = (WingContent)xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 548 */     if (xWingData == null)
/*     */     {
/* 550 */       return -1;
/*     */     }
/* 552 */     return xWingData.getColorid();
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
/*     */   public static int deleteWing(long roleid, int wingCfgid)
/*     */   {
/* 566 */     return WingManager.deleteWing(roleid, wingCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getRoleWingInfoCfgIdsByOutLook(long roleId, boolean remainRoleLock, int outlookType)
/*     */   {
/* 578 */     Set<Integer> result = new HashSet();
/* 579 */     RoleWingInfo roleWingInfo = new RoleWingInfo(roleId, remainRoleLock);
/* 580 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 581 */     if (xWingPlan == null)
/*     */     {
/* 583 */       return result;
/*     */     }
/*     */     
/* 586 */     for (Iterator i$ = xWingPlan.getWings().keySet().iterator(); i$.hasNext();) { int wingInfoCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 588 */       SWingInfoCfg sWingInfoCfg = SWingInfoCfg.get(wingInfoCfgId);
/* 589 */       if (sWingInfoCfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 593 */         if (sWingInfoCfg.outlookType == outlookType)
/*     */         {
/* 595 */           result.add(Integer.valueOf(wingInfoCfgId)); }
/*     */       }
/*     */     }
/* 598 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */