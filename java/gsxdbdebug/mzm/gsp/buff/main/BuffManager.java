/*      */ package mzm.gsp.buff.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.buff.BuffInfo;
/*      */ import mzm.gsp.buff.SAddBuff;
/*      */ import mzm.gsp.buff.SBuffAmountChange;
/*      */ import mzm.gsp.buff.SRemoveBuff;
/*      */ import mzm.gsp.buff.SSyncRoleBuffList;
/*      */ import mzm.gsp.buff.confbean.BuffEffect;
/*      */ import mzm.gsp.buff.confbean.SStateBuffPriorityCfg;
/*      */ import mzm.gsp.buff.confbean.STBuffCfg;
/*      */ import mzm.gsp.buff.event.InstallBuff;
/*      */ import mzm.gsp.buff.event.InstallBuffArg;
/*      */ import mzm.gsp.buff.event.UninstallBuff;
/*      */ import mzm.gsp.buff.event.UninstallBuffArg;
/*      */ import mzm.gsp.effect.confbean.SProfitEffectCfg;
/*      */ import mzm.gsp.effect.main.OutFightEffect;
/*      */ import mzm.gsp.effect.main.OutFightEffectManager;
/*      */ import mzm.gsp.effect.outfight.ActionEffect;
/*      */ import mzm.gsp.effect.outfight.AddMoveSpeedEffect;
/*      */ import mzm.gsp.effect.outfight.AuraEffect;
/*      */ import mzm.gsp.effect.outfight.ChangeModelEffect;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.role.main.RoleOutFightObj;
/*      */ import mzm.gsp.team.main.TeamInfo;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleBuff;
/*      */ import xbean.RoleBuffList;
/*      */ import xtable.Role2buff;
/*      */ import xtable.Role2buffmemory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class BuffManager
/*      */ {
/*   63 */   private static final Logger logger = Logger.getLogger(BuffManager.class);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static final int DEFAULT_RATE = 10000;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void init() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCollisionBuff(long roleId, int buffId)
/*      */   {
/*   82 */     int colisionBuffId = getCollisionBuff(buffId, Role2buff.get(Long.valueOf(roleId)));
/*   83 */     if (colisionBuffId != -1)
/*      */     {
/*   85 */       return colisionBuffId;
/*      */     }
/*   87 */     colisionBuffId = getCollisionBuff(buffId, Role2buffmemory.get(Long.valueOf(roleId)));
/*   88 */     return colisionBuffId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getCollisionBuff(int buffId, RoleBuffList xRoleBuffList)
/*      */   {
/*  100 */     STBuffCfg buffCfg = STBuffCfg.get(buffId);
/*  101 */     if ((xRoleBuffList != null) && (xRoleBuffList.getBuffmap().size() > 0))
/*      */     {
/*  103 */       for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */       {
/*  105 */         STBuffCfg roleBuffCfg = STBuffCfg.get(xRoleBuff.getId());
/*  106 */         if (buffCfg.bufStateType == roleBuffCfg.bufStateType)
/*      */         {
/*  108 */           return xRoleBuff.getId();
/*      */         }
/*      */       }
/*      */     }
/*  112 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void roleLogin(long roleId)
/*      */   {
/*  122 */     if (!isBuffSwitchOpenForRole(roleId))
/*      */     {
/*  124 */       return;
/*      */     }
/*  126 */     RoleBuffList xRoleBuffList = Role2buff.get(Long.valueOf(roleId));
/*  127 */     if (xRoleBuffList == null)
/*      */     {
/*  129 */       xRoleBuffList = Pod.newRoleBuffList();
/*  130 */       Role2buff.add(Long.valueOf(roleId), xRoleBuffList);
/*      */     }
/*      */     
/*  133 */     initFromDB(roleId, xRoleBuffList);
/*  134 */     RoleBuffList xMemoryRoleBuffList = Role2buffmemory.get(Long.valueOf(roleId));
/*  135 */     syncRoleBuffList(roleId, xRoleBuffList, xMemoryRoleBuffList);
/*      */   }
/*      */   
/*      */   private static void initFromDB(long roleId, RoleBuffList xRoleBuffList)
/*      */   {
/*  140 */     long logofftime = RoleInterface.getLastLogoffTime(roleId);
/*  141 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  142 */     Iterator<RoleBuff> it = xRoleBuffList.getBuffmap().values().iterator();
/*  143 */     while (it.hasNext())
/*      */     {
/*  145 */       RoleBuff xRoleBuff = (RoleBuff)it.next();
/*  146 */       int buffCfgId = xRoleBuff.getId();
/*  147 */       STBuffCfg buffCfg = STBuffCfg.get(buffCfgId);
/*  148 */       if (buffCfg == null)
/*      */       {
/*  150 */         it.remove();
/*      */       }
/*      */       else {
/*  153 */         if (buffCfg.effectType == 4)
/*      */         {
/*      */ 
/*  156 */           if (!TeamInterface.isRoleInTeam(roleId, false))
/*      */           {
/*  158 */             it.remove();
/*      */           }
/*      */           
/*      */         }
/*  162 */         else if (buffCfg.effectType == 2)
/*      */         {
/*  164 */           long endTime = xRoleBuff.getEndtime();
/*  165 */           if (endTime != -1L)
/*      */           {
/*  167 */             if (buffCfg.offlineEffect == 3)
/*      */             {
/*  169 */               long remainTime = endTime - logofftime;
/*  170 */               if (remainTime <= 0L)
/*      */               {
/*  172 */                 it.remove();
/*  173 */                 continue;
/*      */               }
/*  175 */               xRoleBuff.setEndtime(remainTime + now);
/*  176 */               BuffMilliObserverCache.getInstance().addMillObserver(roleId, xRoleBuff.getId(), new BuffMilliObserver(remainTime, roleId, buffCfgId, xRoleBuff.getInstall_time()));
/*      */ 
/*      */             }
/*  179 */             else if (buffCfg.offlineEffect == 1)
/*      */             {
/*  181 */               long remainTime = endTime - now;
/*  182 */               if (remainTime <= 0L)
/*      */               {
/*  184 */                 it.remove();
/*  185 */                 continue;
/*      */               }
/*  187 */               BuffMilliObserverCache.getInstance().addMillObserver(roleId, xRoleBuff.getId(), new BuffMilliObserver(remainTime, roleId, buffCfgId, xRoleBuff.getInstall_time()));
/*      */ 
/*      */             }
/*  190 */             else if (buffCfg.offlineEffect == 4)
/*      */             {
/*  192 */               long remainTime = endTime - now;
/*  193 */               if (remainTime <= 0L)
/*      */               {
/*  195 */                 it.remove();
/*  196 */                 continue;
/*      */               }
/*  198 */               BuffMilliObserverCache.getInstance().addMillObserver(roleId, xRoleBuff.getId(), new BuffMilliObserver(remainTime, roleId, buffCfgId, xRoleBuff.getInstall_time()));
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  204 */         installBuffEffect(roleId, buffCfg);
/*      */         
/*  206 */         xRoleBuff.setEffect_state(1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static void fillBuffMap(RoleBuffList xRoleBuffList, List<BuffInfo> infoList) {
/*  212 */     for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */     {
/*  214 */       BuffInfo buffInfo = new BuffInfo();
/*  215 */       buffInfo.buffid = xRoleBuff.getId();
/*  216 */       STBuffCfg sBuffCfg = STBuffCfg.get(xRoleBuff.getId());
/*  217 */       if (sBuffCfg.effectType == 2)
/*      */       {
/*  219 */         long endTime = xRoleBuff.getEndtime();
/*  220 */         buffInfo.typevalue = (endTime > 0L ? TimeUnit.MILLISECONDS.toSeconds(endTime) : endTime);
/*      */       }
/*  222 */       else if (sBuffCfg.effectType == 4)
/*      */       {
/*  224 */         buffInfo.typevalue = -1L;
/*      */       }
/*  226 */       else if (sBuffCfg.effectType == 5)
/*      */       {
/*  228 */         buffInfo.typevalue = -1L;
/*  229 */         buffInfo.idipbuffinfo.put(Integer.valueOf(0), Long.valueOf(xRoleBuff.getMultiple()));
/*  230 */         buffInfo.idipbuffinfo.put(Integer.valueOf(1), Long.valueOf(xRoleBuff.getEndtime()));
/*      */       }
/*      */       else
/*      */       {
/*  234 */         buffInfo.typevalue = xRoleBuff.getCount();
/*      */       }
/*  236 */       infoList.add(buffInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncRoleBuffList(long roleId, RoleBuffList xBuffList, RoleBuffList xMemoryBuffList)
/*      */   {
/*  247 */     if ((xBuffList == null) && (xMemoryBuffList == null))
/*      */     {
/*  249 */       return;
/*      */     }
/*  251 */     SSyncRoleBuffList syncBuffList = new SSyncRoleBuffList();
/*  252 */     if (xBuffList != null)
/*      */     {
/*  254 */       fillBuffMap(xBuffList, syncBuffList.bufflist);
/*      */     }
/*  256 */     if (xMemoryBuffList != null)
/*      */     {
/*  258 */       fillBuffMap(xMemoryBuffList, syncBuffList.bufflist);
/*      */     }
/*  260 */     OnlineManager.getInstance().send(roleId, syncBuffList);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logoff(long roleId)
/*      */   {
/*  272 */     RoleBuffList xRoleBuffList = Role2buffmemory.get(Long.valueOf(roleId));
/*  273 */     if (xRoleBuffList != null)
/*      */     {
/*  275 */       stopObserver(roleId, xRoleBuffList);
/*  276 */       uninstallBuffsEffect(roleId, xRoleBuffList);
/*      */     }
/*  278 */     Role2buffmemory.remove(Long.valueOf(roleId));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  283 */     RoleBuffList xRoleBuffList = Role2buff.get(Long.valueOf(roleId));
/*  284 */     if (xRoleBuffList != null)
/*      */     {
/*  286 */       stopObserver(roleId, xRoleBuffList);
/*  287 */       uninstallBuffsEffect(roleId, xRoleBuffList);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void uninstallBuffs(long roleid)
/*      */   {
/*  295 */     RoleBuffList xRoleBuffList = Role2buffmemory.get(Long.valueOf(roleid));
/*  296 */     if (xRoleBuffList != null)
/*      */     {
/*  298 */       stopObserver(roleid, xRoleBuffList, true);
/*  299 */       uninstallBuffsEffect(roleid, xRoleBuffList);
/*  300 */       Role2buffmemory.remove(Long.valueOf(roleid));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  305 */     RoleBuffList xRoleBuffList = Role2buff.get(Long.valueOf(roleid));
/*  306 */     if (xRoleBuffList != null)
/*      */     {
/*  308 */       stopObserver(roleid, xRoleBuffList, true);
/*  309 */       uninstallBuffsEffect(roleid, xRoleBuffList);
/*  310 */       Role2buff.remove(Long.valueOf(roleid));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void uninstallBuffsEffect(long roleid, RoleBuffList xRoleBuffList)
/*      */   {
/*  317 */     Iterator<Map.Entry<Integer, RoleBuff>> buffIterator = xRoleBuffList.getBuffmap().entrySet().iterator();
/*  318 */     while (buffIterator.hasNext())
/*      */     {
/*  320 */       Map.Entry<Integer, RoleBuff> entry = (Map.Entry)buffIterator.next();
/*  321 */       RoleBuff xBuff = (RoleBuff)entry.getValue();
/*  322 */       if (xBuff.getEffect_state() != 0)
/*      */       {
/*      */ 
/*      */ 
/*  326 */         xBuff.setEffect_state(0);
/*  327 */         STBuffCfg sBuffCfg = STBuffCfg.get(xBuff.getId());
/*  328 */         uninstallBuffEffect(roleid, sBuffCfg);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void stopObserver(long roleId, RoleBuffList xRoleBuffList) {
/*  334 */     stopObserver(roleId, xRoleBuffList, false);
/*      */   }
/*      */   
/*      */   static void stopObserver(long roleId, RoleBuffList xRoleBuffList, boolean forceStop)
/*      */   {
/*  339 */     if (xRoleBuffList == null)
/*      */     {
/*  341 */       return;
/*      */     }
/*  343 */     for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */     {
/*  345 */       if (forceStop)
/*      */       {
/*  347 */         BuffMilliObserverCache.getInstance().stopMillObserver(roleId, xRoleBuff.getId());
/*      */       }
/*      */       else
/*      */       {
/*  351 */         STBuffCfg buffCfg = STBuffCfg.get(xRoleBuff.getId());
/*  352 */         if (buffCfg.effectType == 2)
/*      */         {
/*  354 */           BuffMilliObserverCache.getInstance().stopMillObserver(roleId, xRoleBuff.getId());
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static List<OutFightEffect> getBuffEffectList(STBuffCfg buffCfg) {
/*  361 */     if (buffCfg == null)
/*      */     {
/*  363 */       return Collections.emptyList();
/*      */     }
/*  365 */     List<OutFightEffect> effectList = new ArrayList();
/*  366 */     List<Integer> param = new ArrayList();
/*  367 */     for (BuffEffect bf : buffCfg.effectList)
/*      */     {
/*  369 */       param.clear();
/*  370 */       param.add(Integer.valueOf(bf.effectValue));
/*  371 */       OutFightEffect effect = OutFightEffectManager.getInstance().getEffect(bf.effectId, param);
/*  372 */       effectList.add(effect);
/*      */     }
/*  374 */     return effectList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void installBuffEffect(long roleId, STBuffCfg buffCfg)
/*      */   {
/*  385 */     if (buffCfg == null)
/*      */     {
/*  387 */       return;
/*      */     }
/*  389 */     List<OutFightEffect> effectList = getBuffEffectList(buffCfg);
/*  390 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(roleId);
/*  391 */     for (OutFightEffect effect : effectList)
/*      */     {
/*  393 */       role.installBuffEffect(effect);
/*  394 */       if ((effect instanceof AuraEffect))
/*      */       {
/*      */ 
/*  397 */         NoneRealTimeTaskManager.getInstance().addTask(new PAddAuraBuff(roleId, buffCfg.buffid, ((AuraEffect)effect).getAuraCfgId()));
/*      */ 
/*      */       }
/*  400 */       else if ((effect instanceof ChangeModelEffect))
/*      */       {
/*  402 */         ((ChangeModelEffect)effect).changeRoleModel(roleId);
/*      */       }
/*  404 */       else if ((effect instanceof AddMoveSpeedEffect))
/*      */       {
/*  406 */         ((AddMoveSpeedEffect)effect).addMoveSpeed(roleId);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  411 */     BuffChangeHandler buffChangeHandler = (BuffChangeHandler)getBuffChangeHandlers().get(Integer.valueOf(buffCfg.buffid));
/*  412 */     if (null != buffChangeHandler)
/*      */     {
/*  414 */       buffChangeHandler.changeHandler(roleId, buffCfg.buffid, 1);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void uninstallBuffEffect(long roleId, STBuffCfg buffCfg)
/*      */   {
/*  426 */     if (buffCfg == null)
/*      */     {
/*  428 */       return;
/*      */     }
/*  430 */     List<OutFightEffect> effectList = getBuffEffectList(buffCfg);
/*  431 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(roleId);
/*  432 */     for (OutFightEffect effect : effectList)
/*      */     {
/*  434 */       role.uninstallBuffEffect(effect);
/*  435 */       if ((effect instanceof ChangeModelEffect))
/*      */       {
/*  437 */         ((ChangeModelEffect)effect).unChangeRoleModel(roleId);
/*      */       }
/*  439 */       else if ((effect instanceof AuraEffect))
/*      */       {
/*      */ 
/*  442 */         NoneRealTimeTaskManager.getInstance().addTask(new PRemoveAuraBuff(roleId, buffCfg.buffid, ((AuraEffect)effect).getAuraCfgId()));
/*      */ 
/*      */       }
/*  445 */       else if ((effect instanceof AddMoveSpeedEffect))
/*      */       {
/*  447 */         ((AddMoveSpeedEffect)effect).reduceMoveSpeed(roleId);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  452 */     BuffChangeHandler buffChangeHandler = (BuffChangeHandler)getBuffChangeHandlers().get(Integer.valueOf(buffCfg.buffid));
/*  453 */     if (null != buffChangeHandler)
/*      */     {
/*  455 */       buffChangeHandler.changeHandler(roleId, buffCfg.buffid, 0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean declineCount(long roleId, RoleBuff xRoleBuff)
/*      */   {
/*  468 */     int buffId = xRoleBuff.getId();
/*  469 */     STBuffCfg sBuffCfg = STBuffCfg.get(buffId);
/*  470 */     int count = xRoleBuff.getCount();
/*  471 */     int remainCount = count - 1;
/*  472 */     xRoleBuff.setCount(remainCount);
/*  473 */     List<OutFightEffect> effectList = getBuffEffectList(sBuffCfg);
/*  474 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(roleId);
/*  475 */     for (OutFightEffect effect : effectList)
/*      */     {
/*  477 */       if ((effect instanceof ActionEffect))
/*      */       {
/*  479 */         ((ActionEffect)effect).cast(role);
/*      */       }
/*      */     }
/*  482 */     boolean isOver = false;
/*      */     
/*  484 */     if (remainCount <= 0)
/*      */     {
/*  486 */       SRemoveBuff removeBuff = new SRemoveBuff();
/*  487 */       removeBuff.buffid = buffId;
/*  488 */       OnlineManager.getInstance().send(roleId, removeBuff);
/*  489 */       isOver = true;
/*      */     }
/*      */     else
/*      */     {
/*  493 */       SBuffAmountChange amountChange = new SBuffAmountChange();
/*  494 */       amountChange.buffid = buffId;
/*  495 */       amountChange.buffcount = remainCount;
/*  496 */       OnlineManager.getInstance().send(roleId, amountChange);
/*      */     }
/*  498 */     return isOver;
/*      */   }
/*      */   
/*      */   public static boolean triggerBuff(long roleId, ITriggerCondition condition)
/*      */   {
/*  503 */     List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleId, true);
/*  504 */     if (xAllBuffs == null)
/*      */     {
/*  506 */       return false;
/*      */     }
/*      */     
/*  509 */     boolean isTrigger = false;
/*  510 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */     {
/*  512 */       Iterator<RoleBuff> xBuffIt = xRoleBuffList.getBuffmap().values().iterator();
/*  513 */       while (xBuffIt.hasNext())
/*      */       {
/*  515 */         RoleBuff xRoleBuff = (RoleBuff)xBuffIt.next();
/*  516 */         STBuffCfg buffCfg = STBuffCfg.get(xRoleBuff.getId());
/*  517 */         if (buffCfg != null)
/*      */         {
/*      */ 
/*      */ 
/*  521 */           if (condition.isCanTrigger(roleId, buffCfg.buffid))
/*      */           {
/*  523 */             if (declineCount(roleId, xRoleBuff))
/*      */             {
/*  525 */               xBuffIt.remove();
/*      */               
/*  527 */               triggerUninstallBuff(roleId, buffCfg.buffid, xRoleBuff.getEffect_state());
/*      */             }
/*  529 */             isTrigger = true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  534 */     return isTrigger;
/*      */   }
/*      */   
/*      */   public static boolean isMapEffectBuff(int id)
/*      */   {
/*  539 */     STBuffCfg cfg = STBuffCfg.get(id);
/*  540 */     if (cfg == null)
/*  541 */       return false;
/*  542 */     return cfg.mapEffect == 2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean containBuff(long roleId, List<Integer> buffIdList)
/*      */   {
/*  554 */     List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleId, false);
/*  555 */     if (xAllBuffs == null)
/*      */     {
/*  557 */       return false;
/*      */     }
/*      */     
/*  560 */     Iterator<Integer> it = buffIdList.iterator();
/*  561 */     int id; boolean find; while (it.hasNext())
/*      */     {
/*  563 */       id = ((Integer)it.next()).intValue();
/*  564 */       find = false;
/*  565 */       for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */       {
/*  567 */         for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */         {
/*  569 */           if (xRoleBuff.getId() == id)
/*      */           {
/*  571 */             it.remove();
/*  572 */             find = true;
/*  573 */             break;
/*      */           }
/*      */         }
/*  576 */         if (find) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  582 */     return buffIdList.isEmpty();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> contains(long roleid, List<Integer> buffids, boolean retainLock)
/*      */   {
/*  594 */     List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleid, retainLock);
/*  595 */     if (xAllBuffs == null)
/*      */     {
/*  597 */       return Collections.emptyList();
/*      */     }
/*      */     
/*  600 */     List<Integer> result = new ArrayList();
/*  601 */     for (Iterator i$ = buffids.iterator(); i$.hasNext();) { buffid = ((Integer)i$.next()).intValue();
/*      */       
/*  603 */       find = false;
/*  604 */       for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */       {
/*  606 */         for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */         {
/*  608 */           if (xRoleBuff.getId() == buffid)
/*      */           {
/*  610 */             result.add(Integer.valueOf(buffid));
/*  611 */             find = true;
/*  612 */             break;
/*      */           }
/*      */         }
/*  615 */         if (find)
/*      */           break;
/*      */       }
/*      */     }
/*      */     int buffid;
/*      */     boolean find;
/*  621 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean installIDIPBuff(long roleId, int buffcfgId, int multiple, long endTime)
/*      */   {
/*  637 */     if (!isBuffSwitchOpenForRole(roleId))
/*      */     {
/*  639 */       return false;
/*      */     }
/*      */     
/*  642 */     STBuffCfg sBuffCfg = STBuffCfg.get(buffcfgId);
/*  643 */     if (sBuffCfg == null)
/*      */     {
/*  645 */       logError("[buff]BuffManager.installIDIPBuff@buff cfg not find|buffid=%d", new Object[] { Integer.valueOf(buffcfgId) });
/*  646 */       return false;
/*      */     }
/*      */     
/*  649 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  650 */     if (endTime <= now)
/*      */     {
/*  652 */       logError("[buff]BuffManager.installIDIPBuff@end time invalid|roleid=%d|buffid=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(buffcfgId), Long.valueOf(endTime) });
/*      */       
/*  654 */       return false;
/*      */     }
/*      */     
/*  657 */     RoleBuffList xRoleBuffList = Role2buffmemory.get(Long.valueOf(roleId));
/*  658 */     if (xRoleBuffList == null)
/*      */     {
/*  660 */       xRoleBuffList = Pod.newRoleBuffList();
/*  661 */       Role2buffmemory.add(Long.valueOf(roleId), xRoleBuffList);
/*      */     }
/*      */     
/*  664 */     RoleBuff xRoleNewBuff = Pod.newRoleBuff();
/*  665 */     RoleBuff xRoleOldBuff = (RoleBuff)xRoleBuffList.getBuffmap().put(Integer.valueOf(sBuffCfg.bufStateType), xRoleNewBuff);
/*  666 */     if (xRoleOldBuff != null)
/*      */     {
/*  668 */       int oldBuffid = xRoleOldBuff.getId();
/*      */       
/*  670 */       removeBuffMsg(roleId, oldBuffid);
/*      */       
/*  672 */       triggerUninstallBuff(roleId, oldBuffid, xRoleOldBuff.getEffect_state());
/*      */     }
/*  674 */     xRoleNewBuff.setInstall_time(now);
/*  675 */     xRoleNewBuff.setId(sBuffCfg.buffid);
/*  676 */     xRoleNewBuff.setEndtime(endTime);
/*  677 */     if (OnlineManager.getInstance().isOnline(roleId))
/*      */     {
/*  679 */       xRoleNewBuff.setEffect_state(1);
/*      */     }
/*      */     else
/*      */     {
/*  683 */       xRoleNewBuff.setEffect_state(0);
/*      */     }
/*  685 */     if (multiple == 0)
/*      */     {
/*  687 */       xRoleNewBuff.setMultiple(10000);
/*      */     }
/*      */     else
/*      */     {
/*  691 */       xRoleNewBuff.setMultiple(multiple);
/*      */     }
/*      */     
/*  694 */     SAddBuff addBuffProtocol = new SAddBuff();
/*  695 */     addBuffProtocol.buff.buffid = sBuffCfg.buffid;
/*  696 */     addBuffProtocol.buff.typevalue = -1L;
/*  697 */     addBuffProtocol.buff.idipbuffinfo.put(Integer.valueOf(0), Long.valueOf(multiple + 10000));
/*  698 */     addBuffProtocol.buff.idipbuffinfo.put(Integer.valueOf(1), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(endTime)));
/*  699 */     OnlineManager.getInstance().send(roleId, addBuffProtocol);
/*      */     
/*      */ 
/*  702 */     triggerInstallBuff(roleId, buffcfgId, now, xRoleNewBuff.getEffect_state());
/*      */     
/*  704 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean installBuff(long roleid, int buffCfgid)
/*      */   {
/*  717 */     if (!isBuffSwitchOpenForRole(roleid))
/*      */     {
/*  719 */       return false;
/*      */     }
/*      */     
/*  722 */     STBuffCfg buffCfg = STBuffCfg.get(buffCfgid);
/*  723 */     if (buffCfg == null)
/*      */     {
/*  725 */       logDebug("[buff]BuffManager.installBuff@buff cfg not find|buffid=%d", new Object[] { Integer.valueOf(buffCfgid) });
/*  726 */       return false;
/*      */     }
/*      */     
/*  729 */     List<RoleBuffList> xAllBuffs = new ArrayList();
/*  730 */     RoleBuffList xdbBuffList = Role2buff.get(Long.valueOf(roleid));
/*  731 */     if (xdbBuffList != null)
/*      */     {
/*  733 */       xAllBuffs.add(xdbBuffList);
/*      */     }
/*  735 */     RoleBuffList xRoleBuffList = Role2buffmemory.get(Long.valueOf(roleid));
/*  736 */     if (xRoleBuffList != null)
/*      */     {
/*  738 */       xAllBuffs.add(xRoleBuffList);
/*      */     }
/*      */     
/*      */ 
/*  742 */     if (xAllBuffs.size() > 0)
/*      */     {
/*  744 */       if (!checkBuff(roleid, xAllBuffs, buffCfg))
/*      */       {
/*  746 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  750 */     if (isMemoryBuff(buffCfg))
/*      */     {
/*  752 */       if (xRoleBuffList == null)
/*      */       {
/*  754 */         xRoleBuffList = Pod.newRoleBuffList();
/*  755 */         Role2buffmemory.add(Long.valueOf(roleid), xRoleBuffList);
/*      */       }
/*  757 */       doInstallBuff(roleid, xRoleBuffList, buffCfg);
/*      */     }
/*      */     else
/*      */     {
/*  761 */       if (xdbBuffList == null)
/*      */       {
/*  763 */         xdbBuffList = Pod.newRoleBuffList();
/*  764 */         Role2buff.add(Long.valueOf(roleid), xdbBuffList);
/*      */       }
/*  766 */       doInstallBuff(roleid, xdbBuffList, buffCfg);
/*      */     }
/*      */     
/*  769 */     logInfo("[buff]BuffManager.installBuff@install buff success|roleid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffCfgid) });
/*  770 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean checkBuff(long roleid, List<RoleBuffList> xAllBuffs, STBuffCfg buffCfg)
/*      */   {
/*  776 */     int buffCfgid = buffCfg.buffid;
/*  777 */     Set<Integer> checkStateBuffSet; if (buffCfg.effectType == 4)
/*      */     {
/*  779 */       if (!checkCanInstallStateBuff(xAllBuffs, buffCfgid))
/*      */       {
/*  781 */         logError("[buff]BuffManager.installBuff@have top level buff on role|buffid=%d|roleid=%d", new Object[] { Integer.valueOf(buffCfgid), Long.valueOf(roleid) });
/*  782 */         return false;
/*      */       }
/*      */       
/*  785 */       Set<Integer> stateBuffSet = new HashSet();
/*  786 */       stateBuffSet.add(Integer.valueOf(buffCfgid));
/*      */       
/*  788 */       for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */       {
/*  790 */         for (Map.Entry<Integer, RoleBuff> buffEntry : xRoleBuffList.getBuffmap().entrySet())
/*      */         {
/*  792 */           if (buffCfgid == ((RoleBuff)buffEntry.getValue()).getId())
/*      */           {
/*  794 */             logError("[buff]BuffManager.installBuff@have same buff on role|buffid=%d|roleid=%d", new Object[] { Integer.valueOf(buffCfgid), Long.valueOf(roleid) });
/*  795 */             return false;
/*      */           }
/*  797 */           stateBuffSet.add(Integer.valueOf(((RoleBuff)buffEntry.getValue()).getId()));
/*      */         }
/*      */       }
/*  800 */       checkStateBuffSet = getValidAuraBuffs(stateBuffSet);
/*      */       
/*  802 */       if (!checkStateBuffSet.contains(Integer.valueOf(buffCfgid)))
/*      */       {
/*  804 */         logError("[buff]BuffManager.installBuff@have top level buff on role|buffid=%d|roleid=%d", new Object[] { Integer.valueOf(buffCfgid), Long.valueOf(roleid) });
/*  805 */         return false;
/*      */       }
/*      */       
/*  808 */       if (checkStateBuffSet.size() < stateBuffSet.size())
/*      */       {
/*  810 */         for (Integer removeBuffId : stateBuffSet)
/*      */         {
/*  812 */           if (!checkStateBuffSet.contains(removeBuffId))
/*      */           {
/*  814 */             uninstallBuff(roleid, removeBuffId.intValue());
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  819 */     return true;
/*      */   }
/*      */   
/*      */   private static void doInstallBuff(long roleid, RoleBuffList xRoleBuffList, STBuffCfg buffCfg)
/*      */   {
/*  824 */     int buffCfgid = buffCfg.buffid;
/*  825 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/*  827 */     RoleBuff xRoleNewBuff = Pod.newRoleBuff();
/*  828 */     xRoleNewBuff.setId(buffCfgid);
/*  829 */     xRoleNewBuff.setInstall_time(now);
/*  830 */     if (OnlineManager.getInstance().isOnline(roleid))
/*      */     {
/*  832 */       xRoleNewBuff.setEffect_state(1);
/*      */     }
/*      */     else
/*      */     {
/*  836 */       xRoleNewBuff.setEffect_state(0);
/*      */     }
/*      */     
/*  839 */     RoleBuff xRoleOldBuff = (RoleBuff)xRoleBuffList.getBuffmap().put(Integer.valueOf(buffCfg.bufStateType), xRoleNewBuff);
/*  840 */     if (xRoleOldBuff != null)
/*      */     {
/*  842 */       int oldBuffCfgid = xRoleOldBuff.getId();
/*      */       
/*  844 */       removeBuffMsg(roleid, oldBuffCfgid);
/*      */       
/*  846 */       triggerUninstallBuff(roleid, oldBuffCfgid, xRoleOldBuff.getEffect_state());
/*      */     }
/*      */     
/*  849 */     SAddBuff msg = new SAddBuff();
/*  850 */     msg.buff.buffid = buffCfgid;
/*      */     
/*  852 */     if (buffCfg.effectType == 2)
/*      */     {
/*  854 */       long endTime = -1L;
/*  855 */       int persistTime = buffCfg.persistTime;
/*  856 */       if (persistTime > 0)
/*      */       {
/*  858 */         endTime = TimeUnit.SECONDS.toMillis(persistTime) + now;
/*      */       }
/*  860 */       xRoleNewBuff.setEndtime(endTime);
/*  861 */       msg.buff.typevalue = (endTime > 0L ? TimeUnit.MILLISECONDS.toSeconds(endTime) : -1L);
/*      */     }
/*  863 */     else if (buffCfg.effectType == 4)
/*      */     {
/*      */ 
/*  866 */       msg.buff.typevalue = -1L;
/*      */     }
/*  868 */     else if (buffCfg.effectType == 5)
/*      */     {
/*  870 */       msg.buff.typevalue = -1L;
/*  871 */       msg.buff.idipbuffinfo.put(Integer.valueOf(0), Long.valueOf(20000L));
/*  872 */       msg.buff.idipbuffinfo.put(Integer.valueOf(1), Long.valueOf(-1L));
/*  873 */       xRoleNewBuff.setMultiple(10000);
/*  874 */       xRoleNewBuff.setEndtime(-1L);
/*      */     }
/*      */     else
/*      */     {
/*  878 */       int newCount = buffCfg.acculumaeCout;
/*  879 */       if ((xRoleOldBuff != null) && (xRoleOldBuff.getId() == xRoleNewBuff.getId()))
/*      */       {
/*  881 */         newCount = xRoleOldBuff.getCount() + newCount;
/*      */       }
/*  883 */       newCount = Math.min(newCount, buffCfg.acculumaeCoutLimit);
/*  884 */       xRoleNewBuff.setCount(newCount);
/*  885 */       msg.buff.typevalue = newCount;
/*      */     }
/*      */     
/*      */ 
/*  889 */     triggerInstallBuff(roleid, buffCfgid, now, xRoleNewBuff.getEffect_state());
/*  890 */     OnlineManager.getInstance().send(roleid, msg);
/*      */   }
/*      */   
/*      */   private static boolean isMemoryBuff(STBuffCfg buffCfg)
/*      */   {
/*  895 */     return (buffCfg.offlineEffect == 2) || (buffCfg.effectType == 5);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean uninstallBuff(long roleId, int buffId)
/*      */   {
/*  907 */     return uninstallBuff(roleId, buffId, -1L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean uninstallBuff(long roleid, int buffCfgid, long installTime)
/*      */   {
/*  919 */     STBuffCfg buffCfg = STBuffCfg.get(buffCfgid);
/*  920 */     if (buffCfg == null)
/*      */     {
/*  922 */       logError("[buff]BuffManager.uninstallBuff@buff cfg not find|roleid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffCfgid) });
/*  923 */       return false;
/*      */     }
/*      */     
/*  926 */     int bufStateType = buffCfg.bufStateType;
/*  927 */     if (isMemoryBuff(buffCfg))
/*      */     {
/*  929 */       RoleBuffList xRoleBuffList = Role2buffmemory.get(Long.valueOf(roleid));
/*  930 */       if (!doUninstallBuff(roleid, xRoleBuffList, buffCfgid, bufStateType, installTime))
/*      */       {
/*  932 */         logError("[buff]BuffManager.uninstallBuff@do uninstall buff failed|roleid=%d|buffid=%d|instatll_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffCfgid), Long.valueOf(installTime) });
/*      */         
/*  934 */         return false;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  939 */       RoleBuffList xdbBuffList = Role2buff.get(Long.valueOf(roleid));
/*  940 */       if (!doUninstallBuff(roleid, xdbBuffList, buffCfgid, bufStateType, installTime))
/*      */       {
/*  942 */         logError("[buff]BuffManager.uninstallBuff@do uninstall buff failed|roleid=%d|buffid=%d|instatll_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffCfgid), Long.valueOf(installTime) });
/*      */         
/*  944 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  949 */     removeBuffMsg(roleid, buffCfgid);
/*      */     
/*  951 */     logInfo("[buff]BuffManager.uninstallBuff@uninstall buff success|roleId=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffCfgid) });
/*  952 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean doUninstallBuff(long roleid, RoleBuffList xRoleBuffList, int buffCfgid, int stateType, long installTime)
/*      */   {
/*  958 */     if (xRoleBuffList == null)
/*      */     {
/*  960 */       return false;
/*      */     }
/*  962 */     RoleBuff xRoleBuff = (RoleBuff)xRoleBuffList.getBuffmap().get(Integer.valueOf(stateType));
/*  963 */     if (xRoleBuff == null)
/*      */     {
/*  965 */       return false;
/*      */     }
/*  967 */     if (xRoleBuff.getId() != buffCfgid)
/*      */     {
/*  969 */       return false;
/*      */     }
/*  971 */     if ((installTime >= 0L) && (xRoleBuff.getInstall_time() != installTime))
/*      */     {
/*  973 */       return false;
/*      */     }
/*  975 */     xRoleBuffList.getBuffmap().remove(Integer.valueOf(stateType));
/*      */     
/*      */ 
/*  978 */     triggerUninstallBuff(roleid, buffCfgid, xRoleBuff.getEffect_state());
/*      */     
/*  980 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void uninstallBuffWithType(long roleId, int type)
/*      */   {
/*  992 */     List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleId, true);
/*  993 */     if (xAllBuffs == null)
/*      */     {
/*  995 */       return;
/*      */     }
/*      */     
/*  998 */     List<Integer> dels = new ArrayList();
/*  999 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */     {
/* 1001 */       for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */       {
/* 1003 */         int buffid = xRoleBuff.getId();
/* 1004 */         STBuffCfg buffCfg = STBuffCfg.get(buffid);
/* 1005 */         if ((buffCfg != null) && (buffCfg.effectType == type))
/*      */         {
/* 1007 */           dels.add(Integer.valueOf(buffid));
/*      */         }
/*      */       }
/*      */     }
/* 1011 */     if (dels.isEmpty())
/*      */     {
/* 1013 */       return;
/*      */     }
/* 1015 */     for (Iterator i$ = dels.iterator(); i$.hasNext();) { int buffid = ((Integer)i$.next()).intValue();
/*      */       
/* 1017 */       uninstallBuff(roleId, buffid);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/* 1024 */   private static Map<Integer, BuffChangeHandler> BuffChangeHandlers = new ConcurrentHashMap();
/*      */   
/*      */   static Map<Integer, BuffChangeHandler> getBuffChangeHandlers()
/*      */   {
/* 1028 */     return BuffChangeHandlers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void registerBuffChangeImpl(Integer buffCfgId, BuffChangeHandler buffChangeHandler)
/*      */   {
/* 1040 */     if (BuffChangeHandlers.containsKey(buffCfgId))
/*      */     {
/* 1042 */       logger.error("buff改变类已经被注册了，buffCfgId = " + buffCfgId + "；" + buffChangeHandler.getClass().getName());
/*      */     }
/* 1044 */     BuffChangeHandlers.put(buffCfgId, buffChangeHandler);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean unRegisterBuffChangeImpl(Integer buffCfgId)
/*      */   {
/* 1055 */     if (!BuffChangeHandlers.containsKey(buffCfgId))
/*      */     {
/* 1057 */       logger.error("buff改变类没有被注册，worldId = " + buffCfgId);
/* 1058 */       return false;
/*      */     }
/* 1060 */     BuffChangeHandlers.remove(buffCfgId);
/* 1061 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Set<Integer> getRewardBuffIdSet(long roleId)
/*      */   {
/* 1072 */     List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleId, false);
/* 1073 */     if (xAllBuffs == null)
/*      */     {
/* 1075 */       return Collections.emptySet();
/*      */     }
/* 1077 */     Set<Integer> rewardBuffSet = new HashSet();
/* 1078 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */     {
/* 1080 */       for (i$ = xRoleBuffList.getBuffmap().entrySet().iterator(); i$.hasNext();) { entryBuff = (Map.Entry)i$.next();
/*      */         
/* 1082 */         STBuffCfg buffCfg = STBuffCfg.get(((RoleBuff)entryBuff.getValue()).getId());
/* 1083 */         if ((buffCfg != null) && (buffCfg.effectList.size() > 0))
/*      */         {
/* 1085 */           for (BuffEffect effect : buffCfg.effectList)
/*      */           {
/* 1087 */             SProfitEffectCfg sProfitEffectCfg = SProfitEffectCfg.get(effect.effectValue);
/* 1088 */             if (sProfitEffectCfg != null)
/*      */             {
/* 1090 */               rewardBuffSet.add(Integer.valueOf(((RoleBuff)entryBuff.getValue()).getId())); }
/*      */           } }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/*      */     Map.Entry<Integer, RoleBuff> entryBuff;
/* 1096 */     return rewardBuffSet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ProfitResult getProfitEffect(long roleId, int profigType, Set<Integer> conditionList)
/*      */   {
/* 1113 */     ProfitResult profitResult = new ProfitResult();
/*      */     
/* 1115 */     if ((conditionList == null) || (conditionList.size() == 0))
/*      */     {
/* 1117 */       return profitResult;
/*      */     }
/*      */     
/* 1120 */     List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleId, false);
/* 1121 */     if (xAllBuffs == null)
/*      */     {
/* 1123 */       return profitResult;
/*      */     }
/*      */     
/* 1126 */     for (Integer conditionId : conditionList)
/*      */     {
/* 1128 */       getProfitEffect(roleId, profitResult, profigType, conditionId.intValue(), xAllBuffs);
/*      */     }
/* 1130 */     return profitResult;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ProfitResult getProfitEffect(long roleId, ProfitResult profitResult, int profigType, int conditionId, List<RoleBuffList> xAllBuffs)
/*      */   {
/* 1149 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */     {
/* 1151 */       for (i$ = xRoleBuffList.getBuffmap().entrySet().iterator(); i$.hasNext();) { entryBuff = (Map.Entry)i$.next();
/*      */         
/* 1153 */         STBuffCfg buffCfg = STBuffCfg.get(((RoleBuff)entryBuff.getValue()).getId());
/* 1154 */         if ((buffCfg != null) && (!buffCfg.effectList.isEmpty()))
/*      */         {
/*      */ 
/*      */ 
/* 1158 */           for (BuffEffect effect : buffCfg.effectList)
/*      */           {
/* 1160 */             SProfitEffectCfg profitEffectCfg = SProfitEffectCfg.get(effect.effectValue);
/* 1161 */             if ((profitEffectCfg != null) && ((profitEffectCfg.profitType & profigType) == profigType) && (
/*      */             
/*      */ 
/*      */ 
/* 1165 */               (conditionId == -1) || (profitEffectCfg.conditionList.contains(Integer.valueOf(conditionId)))))
/*      */             {
/*      */ 
/*      */ 
/* 1169 */               ProfitArg profitArg = new ProfitArg();
/* 1170 */               profitArg.setBuffId(((RoleBuff)entryBuff.getValue()).getId());
/* 1171 */               profitArg.setProfitId(effect.effectId);
/* 1172 */               profitArg.setValue(profitEffectCfg.value);
/* 1173 */               if (((RoleBuff)entryBuff.getValue()).getMultiple() == 0)
/*      */               {
/* 1175 */                 profitArg.setNTimes(10000);
/*      */               }
/*      */               else
/*      */               {
/* 1179 */                 profitArg.setNTimes(((RoleBuff)entryBuff.getValue()).getMultiple());
/*      */               }
/* 1181 */               profitArg.setConditionId(conditionId);
/* 1182 */               if (profitEffectCfg.profitControlType == 1)
/*      */               {
/* 1184 */                 profitResult.getAddList().add(profitArg);
/*      */               }
/* 1186 */               else if (profitEffectCfg.profitControlType == 2)
/*      */               {
/* 1188 */                 profitResult.getRateList().add(profitArg);
/*      */               }
/* 1190 */               else if (profitEffectCfg.profitControlType == 3)
/*      */               {
/* 1192 */                 profitResult.setZeroProfit(true); }
/*      */             }
/*      */           } } } }
/*      */     Iterator i$;
/*      */     Map.Entry<Integer, RoleBuff> entryBuff;
/* 1197 */     return profitResult;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isBuffSwitchOpenForRole(long roleid)
/*      */   {
/* 1208 */     if (!OpenInterface.getOpenStatus(108))
/*      */     {
/* 1210 */       return false;
/*      */     }
/* 1212 */     if (OpenInterface.isBanPlay(roleid, 108))
/*      */     {
/* 1214 */       OpenInterface.sendBanPlayMsg(roleid, 108);
/* 1215 */       return false;
/*      */     }
/* 1217 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkCanInstallStateBuff(List<RoleBuffList> xAllBuffs, int buffId)
/*      */   {
/* 1230 */     if ((xAllBuffs == null) || (xAllBuffs.size() == 0))
/*      */     {
/* 1232 */       return true;
/*      */     }
/*      */     
/* 1235 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */     {
/* 1237 */       for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */       {
/* 1239 */         STBuffCfg sBuffCfg = STBuffCfg.get(xRoleBuff.getId());
/* 1240 */         if (sBuffCfg != null)
/*      */         {
/*      */ 
/*      */ 
/* 1244 */           for (BuffEffect buffEffect : sBuffCfg.effectList)
/*      */           {
/* 1246 */             if (buffEffect.effectValue == buffId)
/*      */             {
/* 1248 */               return false; }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1253 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Integer> getAuraBuffMap(List<RoleBuffList> xAllBuffs)
/*      */   {
/* 1265 */     Map<Integer, Integer> buffMap = new HashMap();
/* 1266 */     if ((xAllBuffs == null) || (xAllBuffs.size() == 0))
/*      */     {
/* 1268 */       return buffMap;
/*      */     }
/* 1270 */     for (RoleBuffList xRoleBuffList : xAllBuffs)
/*      */     {
/* 1272 */       for (RoleBuff xRoleBuff : xRoleBuffList.getBuffmap().values())
/*      */       {
/* 1274 */         stBuffCfg = STBuffCfg.get(xRoleBuff.getId());
/* 1275 */         if ((stBuffCfg != null) && (stBuffCfg.auraBuffList != null) && (stBuffCfg.auraBuffList.size() > 0))
/*      */         {
/* 1277 */           for (Integer auraBuffId : stBuffCfg.auraBuffList)
/*      */           {
/* 1279 */             buffMap.put(auraBuffId, Integer.valueOf(stBuffCfg.buffid)); }
/*      */         }
/*      */       }
/*      */     }
/*      */     STBuffCfg stBuffCfg;
/* 1284 */     return buffMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Long, Map<Integer, Integer>> getTeamAuraBuffMap(Map<Long, List<RoleBuffList>> roleBuffListMap, TeamInfo teamInfo)
/*      */   {
/* 1295 */     Map<Long, Map<Integer, Integer>> auraBuffMap = new HashMap();
/* 1296 */     if ((teamInfo == null) || (roleBuffListMap == null) || (roleBuffListMap.size() == 0))
/*      */     {
/* 1298 */       return auraBuffMap;
/*      */     }
/* 1300 */     for (Map.Entry<Long, List<RoleBuffList>> roleListEntry : roleBuffListMap.entrySet())
/*      */     {
/* 1302 */       int teamMemberStatus = teamInfo.getMemberStatus(((Long)roleListEntry.getKey()).longValue());
/* 1303 */       if ((teamMemberStatus != -1) && 
/*      */       
/*      */ 
/*      */ 
/* 1307 */         (teamMemberStatus != 2) && (teamMemberStatus != 1))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1312 */         Map<Integer, Integer> auraMap = getAuraBuffMap((List)roleListEntry.getValue());
/* 1313 */         if ((auraMap != null) && (auraMap.size() > 0))
/*      */         {
/* 1315 */           auraBuffMap.put(roleListEntry.getKey(), auraMap);
/*      */         }
/*      */       }
/*      */     }
/* 1319 */     return auraBuffMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addStateBuffWithTeamInfo(Map<Long, List<RoleBuffList>> roleBuffListMap, TeamInfo teamInfo, Long roleId)
/*      */   {
/* 1330 */     if ((teamInfo == null) || (roleBuffListMap == null) || (roleBuffListMap.size() == 0))
/*      */     {
/* 1332 */       return;
/*      */     }
/*      */     
/* 1335 */     List<Long> teamRoleIds = teamInfo.getTeamMemberList();
/* 1336 */     Set<Integer> auraBuffSet = new HashSet();
/* 1337 */     Map<Long, Map<Integer, Integer>> auraBuffMap = getTeamAuraBuffMap(roleBuffListMap, teamInfo);
/* 1338 */     if (auraBuffMap.size() == 0)
/*      */     {
/* 1340 */       return;
/*      */     }
/*      */     
/* 1343 */     for (Map.Entry<Long, Map<Integer, Integer>> auraMapEntry : auraBuffMap.entrySet())
/*      */     {
/* 1345 */       if ((roleId == null) || (((Long)auraMapEntry.getKey()).longValue() != roleId.longValue()))
/*      */       {
/*      */ 
/*      */ 
/* 1349 */         auraBuffSet.addAll(((Map)auraMapEntry.getValue()).keySet());
/*      */       }
/*      */     }
/*      */     
/* 1353 */     auraBuffSet = getValidAuraBuffs(auraBuffSet);
/*      */     
/* 1355 */     for (Iterator i$ = auraBuffSet.iterator(); i$.hasNext();) { auraBuffId = (Integer)i$.next();
/*      */       
/* 1357 */       for (i$ = teamRoleIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */         
/* 1359 */         if (((roleId == null) || (roleId.longValue() != roleid)) && 
/*      */         
/*      */ 
/*      */ 
/* 1363 */           (teamInfo.getMemberStatus(roleid) != 2) && (teamInfo.getMemberStatus(roleid) != 1))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1368 */           Map<Integer, Integer> auraSet = (Map)auraBuffMap.get(Long.valueOf(roleid));
/* 1369 */           if (auraSet == null)
/*      */           {
/* 1371 */             BuffInterface.installBuffAsyc(roleid, auraBuffId.intValue());
/*      */           }
/*      */           else
/*      */           {
/* 1375 */             boolean hasAuraBuff = false;
/* 1376 */             if (auraSet.containsKey(auraBuffId))
/*      */             {
/* 1378 */               hasAuraBuff = true;
/*      */ 
/*      */             }
/* 1381 */             else if (!hasAuraBuff)
/*      */             {
/* 1383 */               BuffInterface.installBuffAsyc(roleid, auraBuffId.intValue());
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */     Integer auraBuffId;
/*      */     
/*      */     Iterator i$;
/*      */   }
/*      */   
/*      */ 
/*      */   static void removeStateBuffWhenTeamAuraChange(TeamInfo teamInfo, long roleId, Integer auraBuffCfgId, Integer subBuffCfgId)
/*      */   {
/* 1399 */     if (teamInfo == null)
/*      */     {
/* 1401 */       return;
/*      */     }
/* 1403 */     List<Long> rolelistList = teamInfo.getTeamMemberList();
/* 1404 */     for (Long roleid : rolelistList)
/*      */     {
/* 1406 */       if (roleid.longValue() != roleId)
/*      */       {
/*      */ 
/* 1409 */         if ((BuffInterface.isContainBuff(roleid.longValue(), auraBuffCfgId.intValue())) && (teamInfo.getMemberStatus(roleid.longValue()) == 0))
/*      */         {
/*      */ 
/* 1412 */           return;
/*      */         }
/*      */       }
/*      */     }
/* 1416 */     for (Long roleid : rolelistList)
/*      */     {
/* 1418 */       if (roleid.longValue() != roleId)
/*      */       {
/* 1420 */         BuffInterface.uninstallBufAsyc(roleid.longValue(), subBuffCfgId.intValue());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Set<Integer> getValidAuraBuffs(Set<Integer> auraBuffs)
/*      */   {
/* 1433 */     if (auraBuffs.size() == 0)
/*      */     {
/* 1435 */       return auraBuffs;
/*      */     }
/* 1437 */     Set<Integer> endBuffIds = new HashSet();
/* 1438 */     endBuffIds.addAll(auraBuffs);
/* 1439 */     SStateBuffPriorityCfg firstStateBuffPriorityCfg = null;
/* 1440 */     Set<Integer> removeBuffIds = new HashSet();
/* 1441 */     for (Integer auraBuffId : auraBuffs)
/*      */     {
/* 1443 */       SStateBuffPriorityCfg stateBuffPriorityCfg = SStateBuffPriorityCfg.get(auraBuffId.intValue());
/* 1444 */       if (stateBuffPriorityCfg != null)
/*      */       {
/*      */ 
/*      */ 
/* 1448 */         if (firstStateBuffPriorityCfg == null)
/*      */         {
/* 1450 */           firstStateBuffPriorityCfg = stateBuffPriorityCfg;
/*      */ 
/*      */ 
/*      */         }
/* 1454 */         else if (stateBuffPriorityCfg.priority < firstStateBuffPriorityCfg.priority)
/*      */         {
/* 1456 */           removeBuffIds.add(Integer.valueOf(firstStateBuffPriorityCfg.buffid));
/* 1457 */           firstStateBuffPriorityCfg = stateBuffPriorityCfg;
/*      */         }
/*      */         else
/*      */         {
/* 1461 */           removeBuffIds.add(auraBuffId);
/*      */         }
/*      */       }
/*      */     }
/* 1465 */     endBuffIds.removeAll(removeBuffIds);
/*      */     
/* 1467 */     return endBuffIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Long, List<RoleBuffList>> getRoleBuffListMap(List<Long> roleList)
/*      */   {
/* 1478 */     Map<Long, List<RoleBuffList>> roleBuffListMap = new HashMap();
/* 1479 */     if ((roleList == null) || (roleList.size() == 0))
/*      */     {
/* 1481 */       return roleBuffListMap;
/*      */     }
/* 1483 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/* 1485 */       List<RoleBuffList> xAllBuffs = getRoleAllBuffs(roleId, true);
/* 1486 */       if (xAllBuffs != null)
/*      */       {
/*      */ 
/*      */ 
/* 1490 */         roleBuffListMap.put(Long.valueOf(roleId), xAllBuffs); }
/*      */     }
/* 1492 */     return roleBuffListMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<RoleBuffList> getRoleAllBuffs(long roleId, boolean holdLock)
/*      */   {
/* 1503 */     RoleBuffList xRoleBuffList = null;
/* 1504 */     if (holdLock)
/*      */     {
/* 1506 */       xRoleBuffList = Role2buffmemory.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1510 */       xRoleBuffList = Role2buffmemory.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1513 */     RoleBuffList xdbBuffList = null;
/* 1514 */     if (holdLock)
/*      */     {
/* 1516 */       xdbBuffList = Role2buff.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1520 */       xdbBuffList = Role2buff.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1523 */     if ((xRoleBuffList == null) && (xdbBuffList == null))
/*      */     {
/* 1525 */       return null;
/*      */     }
/* 1527 */     List<RoleBuffList> allBuffs = new ArrayList();
/* 1528 */     if ((xRoleBuffList != null) && (xRoleBuffList.getBuffmap().size() > 0))
/*      */     {
/* 1530 */       allBuffs.add(xRoleBuffList);
/*      */     }
/* 1532 */     if ((xdbBuffList != null) && (xdbBuffList.getBuffmap().size() > 0))
/*      */     {
/* 1534 */       allBuffs.add(xdbBuffList);
/*      */     }
/* 1536 */     if (allBuffs.isEmpty())
/*      */     {
/* 1538 */       return null;
/*      */     }
/* 1540 */     return allBuffs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logDebug(String format, Object... args)
/*      */   {
/* 1551 */     if (logger.isDebugEnabled())
/*      */     {
/* 1553 */       logger.debug(String.format(format, args));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logInfo(String format, Object... args)
/*      */   {
/* 1565 */     logger.info(String.format(format, args));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logError(String format, Object... args)
/*      */   {
/* 1576 */     logger.error(String.format(format, args));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void removeBuffMsg(long roleid, int buffid)
/*      */   {
/* 1587 */     SRemoveBuff removeBuffProtocol = new SRemoveBuff();
/* 1588 */     removeBuffProtocol.buffid = buffid;
/* 1589 */     OnlineManager.getInstance().send(roleid, removeBuffProtocol);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerInstallBuff(long roleid, int buffid, long installTime, int state)
/*      */   {
/* 1600 */     InstallBuffArg arg = new InstallBuffArg(roleid, buffid, installTime, state);
/* 1601 */     InstallBuff event = new InstallBuff();
/* 1602 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerUninstallBuff(long roleid, int buffid, int state)
/*      */   {
/* 1613 */     UninstallBuffArg arg = new UninstallBuffArg(roleid, buffid, state);
/* 1614 */     UninstallBuff event = new UninstallBuff();
/* 1615 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\BuffManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */