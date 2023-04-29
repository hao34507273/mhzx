/*     */ package mzm.gsp.children.fashion;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.children.ChildBean;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.FashionInfo;
/*     */ import xbean.FashionObserverInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Children;
/*     */ import xtable.Role2children;
/*     */ import xtable.Role2fashionobserver;
/*     */ 
/*     */ public class FashionManager
/*     */ {
/*     */   public static boolean isFunOpen(long roleid)
/*     */   {
/*  28 */     if (!OpenInterface.getOpenStatus(218))
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     if (OpenInterface.isBanPlay(roleid, 218))
/*     */     {
/*  34 */       OpenInterface.sendBanPlayMsg(roleid, 218);
/*  35 */       return false;
/*     */     }
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   static void startFashionObserver(long roleid, int fashionCfgid, long second)
/*     */   {
/*  42 */     FashionObserverInfo xFashionObserverInfo = Role2fashionobserver.get(Long.valueOf(roleid));
/*  43 */     if (xFashionObserverInfo == null)
/*     */     {
/*  45 */       xFashionObserverInfo = xbean.Pod.newFashionObserverInfo();
/*  46 */       Role2fashionobserver.insert(Long.valueOf(roleid), xFashionObserverInfo);
/*     */     }
/*  48 */     Observer oldObserver = (Observer)xFashionObserverInfo.getObservers().put(Integer.valueOf(fashionCfgid), new FashionObserver(roleid, fashionCfgid, second));
/*     */     
/*  50 */     if (oldObserver != null)
/*     */     {
/*  52 */       oldObserver.stopTimer();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void onHomeWorldDestory(List<Long> roles)
/*     */   {
/*  59 */     for (Long roleid : roles)
/*     */     {
/*  61 */       if (OnlineManager.getInstance().isOnline(roleid.longValue()))
/*     */       {
/*  63 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  68 */     for (Long roleid : roles)
/*     */     {
/*  70 */       cancelFashionObserver(roleid.longValue());
/*     */     }
/*     */   }
/*     */   
/*     */   static void removeFashionObserver(long roleid, int fashionCfgid)
/*     */   {
/*  76 */     FashionObserverInfo xFashionObserverInfo = Role2fashionobserver.get(Long.valueOf(roleid));
/*  77 */     if (xFashionObserverInfo == null)
/*     */     {
/*  79 */       return;
/*     */     }
/*  81 */     Observer xObserver = (Observer)xFashionObserverInfo.getObservers().remove(Integer.valueOf(fashionCfgid));
/*  82 */     if (xObserver != null)
/*     */     {
/*  84 */       xObserver.stopTimer();
/*     */     }
/*  86 */     if (xFashionObserverInfo.getObservers().isEmpty())
/*     */     {
/*  88 */       Role2fashionobserver.remove(Long.valueOf(roleid));
/*     */     }
/*     */   }
/*     */   
/*     */   static void cancelFashionObserver(long roleid)
/*     */   {
/*  94 */     FashionObserverInfo xFashionObserverInfo = Role2fashionobserver.get(Long.valueOf(roleid));
/*  95 */     if (xFashionObserverInfo == null)
/*     */     {
/*  97 */       return;
/*     */     }
/*  99 */     for (Observer xObserver : xFashionObserverInfo.getObservers().values())
/*     */     {
/* 101 */       xObserver.stopTimer();
/*     */     }
/* 103 */     Role2fashionobserver.remove(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   static boolean isExpire(int duration, long startTime)
/*     */   {
/* 108 */     if ((startTime == 0L) || (duration <= 0))
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     return TimeUnit.HOURS.toMillis(duration) + startTime <= DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */   static void sendProtocol(long roleid, long marriedRoleid, xio.Protocol msg)
/*     */   {
/* 117 */     OnlineManager.getInstance().send(roleid, msg);
/* 118 */     if ((marriedRoleid > 0L) && (OnlineManager.getInstance().isOnline(marriedRoleid)))
/*     */     {
/* 120 */       OnlineManager.getInstance().send(marriedRoleid, msg);
/*     */     }
/*     */   }
/*     */   
/*     */   static void handleFashionObserver(long roleid)
/*     */   {
/* 126 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/* 127 */     if (xRole2ChildrenInfo == null)
/*     */     {
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     xbean.ChildFashionInfo xChildFashionInfo = xRole2ChildrenInfo.getFashion_info();
/* 133 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 134 */     for (Map.Entry<Integer, FashionInfo> xEntry : xChildFashionInfo.getFashions().entrySet())
/*     */     {
/* 136 */       int fashionCfgid = ((Integer)xEntry.getKey()).intValue();
/* 137 */       SFashionCfg fashionCfg = SFashionCfg.get(fashionCfgid);
/* 138 */       if (fashionCfg == null)
/*     */       {
/* 140 */         mzm.gsp.GameServer.logger().error(String.format("[childfashion]FashionManager.handleFashionObserver@fashion cfg is null|roleid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(fashionCfgid) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 146 */         int duration = fashionCfg.duration;
/* 147 */         long startTime = ((FashionInfo)xEntry.getValue()).getStart_time();
/* 148 */         if ((startTime != 0L) && (duration > 0))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 153 */           long delay = TimeUnit.MILLISECONDS.toSeconds(TimeUnit.HOURS.toMillis(duration) + startTime - now);
/*     */           
/* 155 */           startFashionObserver(roleid, fashionCfgid, delay < 0L ? 0L : delay);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 161 */   static void syncRemoveFashionInfo(long roleid, int fashionCfgid) { mzm.gsp.children.SSyncRemoveFashionInfo msg = new mzm.gsp.children.SSyncRemoveFashionInfo();
/* 162 */     msg.fashion_cfgid = fashionCfgid;
/* 163 */     OnlineManager.getInstance().send(roleid, msg);
/*     */   }
/*     */   
/*     */   public static void fillFashionInfo(ChildBean childBean, ChildInfo xChildInfo)
/*     */   {
/* 168 */     for (Map.Entry<Integer, xbean.DressedInfo> xEntry : xChildInfo.getDressed().entrySet())
/*     */     {
/* 170 */       xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xEntry.getValue();
/* 171 */       childBean.fashions.put(xEntry.getKey(), new mzm.gsp.children.DressedInfo(xDressedInfo.getFashion_cfgid(), xDressedInfo.getOwner_roleid()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onDivorce(long roleIdA, Role2ChildrenInfo xRoleIdAChildrenInfo, List<Long> roleIdABagIdList, long roleIdB, Role2ChildrenInfo xRoleIdBChildrenInfo, List<Long> roleIdBBagIdList)
/*     */   {
/* 181 */     fashionRemoveEvent(roleIdA, xRoleIdAChildrenInfo, roleIdB, xRoleIdBChildrenInfo);
/*     */     
/*     */ 
/* 184 */     for (Iterator i$ = roleIdABagIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*     */       
/* 186 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childId));
/* 187 */       if (xChildInfo != null)
/*     */       {
/* 189 */         removeDressed(roleIdA, xChildInfo);
/*     */       }
/*     */     }
/*     */     
/* 193 */     for (Iterator i$ = roleIdBBagIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*     */       
/* 195 */       ChildInfo xChildInfo = Children.get(Long.valueOf(childId));
/* 196 */       if (xChildInfo != null)
/*     */       {
/* 198 */         removeDressed(roleIdB, xChildInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void removeDressed(long roleid, ChildInfo xChildInfo)
/*     */   {
/* 205 */     Map<Integer, xbean.DressedInfo> dresseds = xChildInfo.getDressed();
/* 206 */     Iterator<Map.Entry<Integer, xbean.DressedInfo>> xIt = dresseds.entrySet().iterator();
/* 207 */     while (xIt.hasNext())
/*     */     {
/* 209 */       Map.Entry<Integer, xbean.DressedInfo> xNext = (Map.Entry)xIt.next();
/* 210 */       xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xNext.getValue();
/* 211 */       if (xDressedInfo.getOwner_roleid() != roleid)
/*     */       {
/* 213 */         xIt.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static void fashionRemoveEvent(long roleIdA, Role2ChildrenInfo xRoleIdAChildrenInfo, long roleIdB, Role2ChildrenInfo xRoleIdBChildrenInfo)
/*     */   {
/* 221 */     if (xRoleIdAChildrenInfo != null)
/*     */     {
/* 223 */       long showChildId = xRoleIdAChildrenInfo.getShow_child_id();
/* 224 */       if (showChildId != -1L)
/*     */       {
/* 226 */         ChildInfo xChildInfo = Children.get(Long.valueOf(showChildId));
/* 227 */         if (xChildInfo != null)
/*     */         {
/* 229 */           int showChildPeriod = xRoleIdAChildrenInfo.getShow_child_period();
/* 230 */           xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(showChildPeriod));
/* 231 */           if ((xDressedInfo != null) && (xDressedInfo.getOwner_roleid() != roleIdA))
/*     */           {
/* 233 */             mzm.gsp.children.main.ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(roleIdA, mzm.gsp.children.event.ChildShowModelChangeReason.FASHION_REMOVE));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 240 */     if (xRoleIdBChildrenInfo != null)
/*     */     {
/* 242 */       long showChildId = xRoleIdBChildrenInfo.getShow_child_id();
/* 243 */       if (showChildId != -1L)
/*     */       {
/* 245 */         ChildInfo xChildInfo = Children.get(Long.valueOf(showChildId));
/* 246 */         if (xChildInfo != null)
/*     */         {
/* 248 */           int showChildPeriod = xRoleIdBChildrenInfo.getShow_child_period();
/* 249 */           xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(showChildPeriod));
/* 250 */           if ((xDressedInfo != null) && (xDressedInfo.getOwner_roleid() != roleIdA))
/*     */           {
/* 252 */             mzm.gsp.children.main.ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(roleIdB, mzm.gsp.children.event.ChildShowModelChangeReason.FASHION_REMOVE));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static ShowChildFashionObj getShowChildFashionObj(long roleid, boolean remainLock)
/*     */   {
/*     */     Role2ChildrenInfo xRole2ChildrenInfo;
/*     */     Role2ChildrenInfo xRole2ChildrenInfo;
/* 263 */     if (remainLock)
/*     */     {
/* 265 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 269 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 272 */     if (xRole2ChildrenInfo == null)
/*     */     {
/* 274 */       return null;
/*     */     }
/*     */     
/* 277 */     long showChildid = xRole2ChildrenInfo.getShow_child_id();
/* 278 */     if (showChildid == -1L)
/*     */     {
/* 280 */       return null;
/*     */     }
/*     */     
/* 283 */     ChildInfo xChildInfo = Children.get(Long.valueOf(showChildid));
/* 284 */     if (xChildInfo == null)
/*     */     {
/* 286 */       return null;
/*     */     }
/*     */     
/* 289 */     int showPhase = xRole2ChildrenInfo.getShow_child_period();
/* 290 */     xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(showPhase));
/* 291 */     if (xDressedInfo == null)
/*     */     {
/* 293 */       return null;
/*     */     }
/*     */     
/* 296 */     return new ShowChildFashionObj(showChildid, showPhase, xDressedInfo.getFashion_cfgid());
/*     */   }
/*     */   
/*     */ 
/*     */   public static void onCreateHomeWorld(long roleid, long marriedRoleid)
/*     */   {
/* 302 */     handleFashionObserver(roleid);
/* 303 */     if (marriedRoleid > 0L)
/*     */     {
/* 305 */       handleFashionObserver(marriedRoleid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void onLogin(long roleid, long marriedRoleid)
/*     */   {
/* 312 */     handleFashionObserver(roleid);
/* 313 */     if (marriedRoleid > 0L)
/*     */     {
/* 315 */       handleFashionObserver(marriedRoleid);
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
/*     */   public static int getChangeFashionCfgid(ChildInfo xChildInfo, int phase)
/*     */   {
/* 328 */     if (xChildInfo == null)
/*     */     {
/* 330 */       return 0;
/*     */     }
/* 332 */     xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(phase));
/* 333 */     if (xDressedInfo == null)
/*     */     {
/* 335 */       return 0;
/*     */     }
/* 337 */     SFashionCfg fashionCfg = SFashionCfg.get(xDressedInfo.getFashion_cfgid());
/* 338 */     if (fashionCfg == null)
/*     */     {
/* 340 */       return 0;
/*     */     }
/* 342 */     return fashionCfg.changeFashionCfgid;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\FashionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */