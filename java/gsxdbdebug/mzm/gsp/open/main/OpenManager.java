/*     */ package mzm.gsp.open.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.SGetModuleFunSwitchesRep;
/*     */ import mzm.gsp.open.SModuleFunSwitchInfoChanged;
/*     */ import mzm.gsp.open.confbean.SGrayServerCfg;
/*     */ import mzm.gsp.open.confbean.SModuleFunSwitchCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GameServerInfo;
/*     */ import xbean.ModuleFunSwitches;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class OpenManager
/*     */ {
/*     */   static final int DAULT_FUN_ID = 0;
/*  27 */   private static final Map<Integer, Map<Integer, ModuleFunSwitchInfo>> moduleFunSwitches = new HashMap();
/*  28 */   private static final ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   static void init()
/*     */   {
/*  32 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  37 */         long localID = GameServerInfoManager.getLocalId();
/*  38 */         GameServerInfo xGameServerInfo = xtable.Gamesrv.select(Long.valueOf(localID));
/*  39 */         if (xGameServerInfo == null)
/*     */         {
/*  41 */           return false;
/*     */         }
/*     */         
/*  44 */         OpenManager.rwLock.writeLock().lock();
/*     */         try
/*     */         {
/*  47 */           Map<Integer, ModuleFunSwitches> xModuleFunSwitchesMap = xGameServerInfo.getModule_fun_switches();
/*  48 */           for (Map.Entry<Integer, ModuleFunSwitches> xModuleFunSwitchesEntry : xModuleFunSwitchesMap.entrySet())
/*     */           {
/*  50 */             moduleid = ((Integer)xModuleFunSwitchesEntry.getKey()).intValue();
/*  51 */             ModuleFunSwitches xModuleFunSwitches = (ModuleFunSwitches)xModuleFunSwitchesEntry.getValue();
/*  52 */             Map<Integer, xbean.ModuleFunSwitchInfo> xModuleFunSwitchInfoMap = xModuleFunSwitches.getFun_switch_infos();
/*  53 */             for (Map.Entry<Integer, xbean.ModuleFunSwitchInfo> xModuleFunSwitchInfoEntry : xModuleFunSwitchInfoMap.entrySet())
/*     */             {
/*  55 */               int funid = ((Integer)xModuleFunSwitchInfoEntry.getKey()).intValue();
/*  56 */               xbean.ModuleFunSwitchInfo xModuleFunSwitchInfo = (xbean.ModuleFunSwitchInfo)xModuleFunSwitchInfoEntry.getValue();
/*     */               
/*     */ 
/*  59 */               Map<Integer, ModuleFunSwitchInfo> funSwitches = (Map)OpenManager.moduleFunSwitches.get(Integer.valueOf(moduleid));
/*  60 */               if (funSwitches == null)
/*     */               {
/*  62 */                 funSwitches = new HashMap();
/*  63 */                 OpenManager.moduleFunSwitches.put(Integer.valueOf(moduleid), funSwitches);
/*     */               }
/*     */               
/*  66 */               ModuleFunSwitchInfo moduleFunSwichInfo = (ModuleFunSwitchInfo)funSwitches.get(Integer.valueOf(funid));
/*  67 */               if (moduleFunSwichInfo == null)
/*     */               {
/*  69 */                 moduleFunSwichInfo = new ModuleFunSwitchInfo(moduleid, funid, xModuleFunSwitchInfo.getParams());
/*  70 */                 funSwitches.put(Integer.valueOf(funid), moduleFunSwichInfo);
/*     */               }
/*     */               else
/*     */               {
/*  74 */                 moduleFunSwichInfo.setParams(xModuleFunSwitchInfo.getParams());
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         finally
/*     */         {
/*     */           int moduleid;
/*  82 */           OpenManager.rwLock.writeLock().unlock();
/*     */         }
/*     */         
/*  85 */         return true;
/*     */       }
/*     */     }.call();
/*     */     
/*  89 */     for (SModuleFunSwitchCfg v : SModuleFunSwitchCfg.getAll().values())
/*     */     {
/*  91 */       setModuleFunSwitchStatus(v.moduleid, 0, null, v.isopen, true, true);
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isModuleFunSwitchOpen(int moduleid)
/*     */   {
/*  97 */     return isModuleFunSwitchOpen(moduleid, 0);
/*     */   }
/*     */   
/*     */   static boolean isModuleFunSwitchOpen(int moduleid, int funid)
/*     */   {
/* 102 */     rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 105 */       Map<Integer, ModuleFunSwitchInfo> funSwitches = (Map)moduleFunSwitches.get(Integer.valueOf(moduleid));
/* 106 */       boolean bool; if (funSwitches == null)
/*     */       {
/* 108 */         return true;
/*     */       }
/*     */       
/* 111 */       if (funSwitches.containsKey(Integer.valueOf(funid)))
/*     */       {
/* 113 */         return false;
/*     */       }
/*     */       
/* 116 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 120 */       rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static List<Integer> getModuleFunSwitchParams(int moduleid)
/*     */   {
/* 126 */     return getModuleFunSwitchParams(moduleid, 0);
/*     */   }
/*     */   
/*     */   static List<Integer> getModuleFunSwitchParams(int moduleid, int funid)
/*     */   {
/* 131 */     rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 134 */       Map<Integer, ModuleFunSwitchInfo> funSwitches = (Map)moduleFunSwitches.get(Integer.valueOf(moduleid));
/* 135 */       if (funSwitches == null)
/*     */       {
/* 137 */         return null;
/*     */       }
/*     */       
/* 140 */       ModuleFunSwitchInfo moduleFunSwitchInfo = (ModuleFunSwitchInfo)funSwitches.get(Integer.valueOf(funid));
/* 141 */       Object localObject1; if (moduleFunSwitchInfo == null)
/*     */       {
/* 143 */         return null;
/*     */       }
/*     */       
/* 146 */       return moduleFunSwitchInfo.getParams();
/*     */     }
/*     */     finally
/*     */     {
/* 150 */       rwLock.readLock().unlock();
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
/*     */   static void setModuleFunSwitchDefaultStatus(int moduleid, int funid, List<Integer> params, boolean isOpen)
/*     */   {
/* 169 */     setModuleFunSwitchStatus(moduleid, funid, params, isOpen, true, false);
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
/*     */   static void setModuleFunSwitchStatus(int moduleid, int funid, List<Integer> params, boolean isOpen)
/*     */   {
/* 186 */     setModuleFunSwitchStatus(moduleid, funid, params, isOpen, false, false);
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
/*     */   static void setModuleFunSwitchStatus(int moduleid, final int funid, final List<Integer> params, final boolean isOpen, final boolean isSetDefault, boolean isSync)
/*     */   {
/* 208 */     LogicProcedure proc = new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 213 */         long localID = GameServerInfoManager.getLocalId();
/* 214 */         GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(localID));
/* 215 */         if (xGameServerInfo == null)
/*     */         {
/* 217 */           return false;
/*     */         }
/*     */         
/* 220 */         Map<Integer, ModuleFunSwitches> xModuleFunSwitchesMap = xGameServerInfo.getModule_fun_switches();
/* 221 */         ModuleFunSwitches xModuleFunSwitches = (ModuleFunSwitches)xModuleFunSwitchesMap.get(Integer.valueOf(this.val$moduleid));
/* 222 */         if (xModuleFunSwitches == null)
/*     */         {
/* 224 */           xModuleFunSwitches = xbean.Pod.newModuleFunSwitches();
/* 225 */           xModuleFunSwitchesMap.put(Integer.valueOf(this.val$moduleid), xModuleFunSwitches);
/*     */           
/* 227 */           if (isSetDefault)
/*     */           {
/* 229 */             if (!xModuleFunSwitches.getFun_switch_init_infos().add(Integer.valueOf(funid)))
/*     */             {
/* 231 */               return false;
/*     */             }
/*     */           }
/*     */           
/* 235 */           if (isOpen)
/*     */           {
/* 237 */             return true;
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 242 */         else if (isSetDefault)
/*     */         {
/* 244 */           if (!xModuleFunSwitches.getFun_switch_init_infos().add(Integer.valueOf(funid)))
/*     */           {
/* 246 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 250 */         Map<Integer, xbean.ModuleFunSwitchInfo> xModuleFunSwitchInfoMap = xModuleFunSwitches.getFun_switch_infos();
/* 251 */         if (isOpen)
/*     */         {
/* 253 */           if (xModuleFunSwitchInfoMap.remove(Integer.valueOf(funid)) == null)
/*     */           {
/* 255 */             return true;
/*     */           }
/*     */           
/* 258 */           if ((xModuleFunSwitchInfoMap.isEmpty()) && (xModuleFunSwitches.getFun_switch_init_infos().isEmpty()))
/*     */           {
/* 260 */             xModuleFunSwitchesMap.remove(Integer.valueOf(this.val$moduleid));
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 265 */           xbean.ModuleFunSwitchInfo xModuleFunSwitchInfo = (xbean.ModuleFunSwitchInfo)xModuleFunSwitchInfoMap.get(Integer.valueOf(funid));
/* 266 */           if (xModuleFunSwitchInfo == null)
/*     */           {
/* 268 */             xModuleFunSwitchInfo = xbean.Pod.newModuleFunSwitchInfo();
/* 269 */             xModuleFunSwitchInfoMap.put(Integer.valueOf(funid), xModuleFunSwitchInfo);
/*     */ 
/*     */ 
/*     */           }
/* 273 */           else if (!isSetDefault)
/*     */           {
/* 275 */             List<Integer> xParams = xModuleFunSwitchInfo.getParams();
/* 276 */             if ((params == null) || (params.isEmpty()))
/*     */             {
/* 278 */               if (xParams.isEmpty())
/*     */               {
/* 280 */                 return false;
/*     */               }
/*     */               
/*     */ 
/*     */             }
/* 285 */             else if ((params.size() == xParams.size()) && (params.containsAll(xParams)))
/*     */             {
/* 287 */               return false;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 293 */           List<Integer> xParams = xModuleFunSwitchInfo.getParams();
/* 294 */           xParams.clear();
/* 295 */           if (params != null)
/*     */           {
/* 297 */             xModuleFunSwitchInfo.getParams().addAll(params);
/*     */           }
/*     */         }
/*     */         
/* 301 */         OpenManager.rwLock.writeLock().lock();
/*     */         try
/*     */         {
/* 304 */           Map<Integer, ModuleFunSwitchInfo> funSwitches = (Map)OpenManager.moduleFunSwitches.get(Integer.valueOf(this.val$moduleid));
/* 305 */           if (funSwitches == null)
/*     */           {
/* 307 */             funSwitches = new HashMap();
/* 308 */             OpenManager.moduleFunSwitches.put(Integer.valueOf(this.val$moduleid), funSwitches);
/*     */           }
/*     */           
/* 311 */           if (isOpen)
/*     */           {
/* 313 */             funSwitches.remove(Integer.valueOf(funid));
/* 314 */             if (funSwitches.isEmpty())
/*     */             {
/* 316 */               OpenManager.moduleFunSwitches.remove(Integer.valueOf(this.val$moduleid));
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 321 */             ModuleFunSwitchInfo moduleFunSwitchInfo = (ModuleFunSwitchInfo)funSwitches.get(Integer.valueOf(funid));
/* 322 */             if (moduleFunSwitchInfo == null)
/*     */             {
/* 324 */               moduleFunSwitchInfo = new ModuleFunSwitchInfo(this.val$moduleid, funid, params);
/* 325 */               funSwitches.put(Integer.valueOf(funid), moduleFunSwitchInfo);
/*     */             }
/*     */             else
/*     */             {
/* 329 */               moduleFunSwitchInfo.setParams(params);
/*     */             }
/*     */           }
/*     */         }
/*     */         finally
/*     */         {
/* 335 */           OpenManager.rwLock.writeLock().unlock();
/*     */         }
/*     */         
/* 338 */         SModuleFunSwitchInfoChanged switchInfoChanged = new SModuleFunSwitchInfoChanged();
/* 339 */         switchInfoChanged.info.moduleid = this.val$moduleid;
/* 340 */         switchInfoChanged.info.funid = funid;
/* 341 */         if (!isOpen)
/*     */         {
/* 343 */           if (params != null)
/*     */           {
/* 345 */             switchInfoChanged.info.params.addAll(params);
/*     */           }
/*     */         }
/* 348 */         switchInfoChanged.info.isopen = ((byte)(isOpen ? 1 : 0));
/* 349 */         OnlineManager.getInstance().sendAll(switchInfoChanged);
/*     */         
/* 351 */         if (funid == 0)
/*     */         {
/* 353 */           TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.open.event.OpenChange(), new mzm.gsp.open.event.OpenChangeComplexArg(this.val$moduleid, isOpen));
/*     */         }
/*     */         
/* 356 */         return true;
/*     */       }
/*     */     };
/*     */     
/* 360 */     if (isSync)
/*     */     {
/* 362 */       proc.call();
/*     */     }
/*     */     else
/*     */     {
/* 366 */       proc.execute();
/*     */     }
/*     */   }
/*     */   
/*     */   static void getModuleFunSwitches(Protocol core)
/*     */   {
/* 372 */     SGetModuleFunSwitchesRep rep = new SGetModuleFunSwitchesRep();
/*     */     
/* 374 */     rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 377 */       for (Map<Integer, ModuleFunSwitchInfo> switches : moduleFunSwitches.values())
/*     */       {
/* 379 */         for (ModuleFunSwitchInfo info : switches.values())
/*     */         {
/* 381 */           mzm.gsp.open.ModuleFunSwitchInfo switchInfo = new mzm.gsp.open.ModuleFunSwitchInfo();
/* 382 */           switchInfo.moduleid = info.getModuleid();
/* 383 */           switchInfo.funid = info.getFunid();
/* 384 */           switchInfo.isopen = 0;
/* 385 */           List<Integer> params = info.getParams();
/* 386 */           if (params.size() > 0)
/*     */           {
/* 388 */             switchInfo.params.addAll(params);
/*     */           }
/* 390 */           rep.funswitches.add(switchInfo);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 396 */       rwLock.readLock().unlock();
/*     */     }
/*     */     
/* 399 */     Onlines.getInstance().sendResponse(core, rep);
/*     */   }
/*     */   
/*     */   static List<Integer> getCloseStatusModuleFunSwitches()
/*     */   {
/* 404 */     List<Integer> closeStatusSwitches = new java.util.ArrayList();
/*     */     
/* 406 */     rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 409 */       for (Map<Integer, ModuleFunSwitchInfo> entries : moduleFunSwitches.values())
/*     */       {
/* 411 */         for (ModuleFunSwitchInfo info : entries.values())
/*     */         {
/* 413 */           if (info.getFunid() == 0)
/*     */           {
/* 415 */             closeStatusSwitches.add(Integer.valueOf(info.getModuleid()));
/*     */             
/* 417 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 424 */       rwLock.readLock().unlock();
/*     */     }
/*     */     
/* 427 */     return closeStatusSwitches;
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
/*     */   static void sendCloseProtocol(long roleid, int moduleid, List<String> params) {}
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
/*     */   static boolean isGrayValid(String userid)
/*     */   {
/* 463 */     return isGrayValid(GameServerInfoManager.getZoneidFromUserid(userid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGrayValid(long roleid)
/*     */   {
/* 475 */     return isGrayValid(GameServerInfoManager.getZoneidFromRoleid(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGrayValid(int zoneid)
/*     */   {
/* 487 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/* 489 */       return false;
/*     */     }
/*     */     
/* 492 */     if (!isModuleFunSwitchOpen(246))
/*     */     {
/* 494 */       return false;
/*     */     }
/*     */     
/* 497 */     SGrayServerCfg grayServerCfg = SGrayServerCfg.get(zoneid);
/* 498 */     if (grayServerCfg == null)
/*     */     {
/* 500 */       return false;
/*     */     }
/*     */     
/* 503 */     return grayServerCfg.isvalid;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\main\OpenManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */