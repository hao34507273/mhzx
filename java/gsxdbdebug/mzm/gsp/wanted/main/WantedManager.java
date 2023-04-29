/*     */ package mzm.gsp.wanted.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.prison.main.PrisonInterface;
/*     */ import mzm.gsp.prison.main.PrisonPageManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.wanted.SWantedRoleError;
/*     */ import xbean.WantedInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WantedManager
/*     */ {
/*     */   static final String CHARSET = "utf-8";
/*     */   
/*     */   static boolean isHongMing(long roleId)
/*     */   {
/*  49 */     return MallInterface.getJifen(roleId, 7) <= SPKConsts.getInstance().WANTED_MORAL_VALUE;
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
/*     */   static boolean checkCanBeWantedByNPC(long wantedRoleId, WantedInfo xWantedInfo, long activeRoleId, SWantedRoleError wantedRoleError, boolean isSendProtocol)
/*     */     throws Exception
/*     */   {
/*  66 */     if (xWantedInfo == null)
/*     */     {
/*  68 */       if (isSendProtocol)
/*     */       {
/*  70 */         wantedRoleError.errorcode = 6;
/*  71 */         OnlineManager.getInstance().sendAtOnce(activeRoleId, wantedRoleError);
/*     */       }
/*  73 */       WantedInterface.removeRoleWantedInfo(wantedRoleId);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     if (!OnlineManager.getInstance().isOnline(wantedRoleId))
/*     */     {
/*  80 */       if (isSendProtocol)
/*     */       {
/*  82 */         wantedRoleError.errorcode = 5;
/*  83 */         OnlineManager.getInstance().sendAtOnce(activeRoleId, wantedRoleError);
/*     */       }
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     if (FightInterface.isInFight(wantedRoleId))
/*     */     {
/*  91 */       if (isSendProtocol)
/*     */       {
/*  93 */         wantedRoleError.errorcode = 2;
/*  94 */         OnlineManager.getInstance().sendAtOnce(activeRoleId, wantedRoleError);
/*     */       }
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     SMapConfig mapConfig = SMapConfig.get(MapInterface.getRoleMapId(wantedRoleId));
/* 101 */     if ((mapConfig == null) || (!mapConfig.canArrestWanted))
/*     */     {
/* 103 */       if (isSendProtocol)
/*     */       {
/* 105 */         wantedRoleError.errorcode = 1;
/* 106 */         OnlineManager.getInstance().sendAtOnce(activeRoleId, wantedRoleError);
/*     */       }
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if (!RoleStatusInterface.checkCanSetStatus(wantedRoleId, 1654, false))
/*     */     {
/* 114 */       if (isSendProtocol)
/*     */       {
/* 116 */         wantedRoleError.errorcode = 9;
/* 117 */         OnlineManager.getInstance().sendAtOnce(activeRoleId, wantedRoleError);
/*     */       }
/* 119 */       return false;
/*     */     }
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   static Set<Long> getWantedRoleIds(Collection<Long> roles)
/*     */   {
/* 126 */     Set<Long> wantedRoles = new HashSet();
/* 127 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 129 */       if (isHongMing(roleId))
/*     */       {
/* 131 */         wantedRoles.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/* 134 */     return wantedRoles;
/*     */   }
/*     */   
/*     */   static boolean checkCanBeWantedByRole(long wantedRoleId, WantedInfo xWantedInfo, long activeRoleId, SWantedRoleError wantedRoleError, boolean isSendProtocol)
/*     */     throws Exception
/*     */   {
/* 140 */     if (!WantedPageManager.getInstance().containsRecord(Long.valueOf(wantedRoleId)))
/*     */     {
/* 142 */       if (isSendProtocol)
/*     */       {
/* 144 */         wantedRoleError.errorcode = 6;
/* 145 */         OnlineManager.getInstance().sendAtOnce(activeRoleId, wantedRoleError);
/* 146 */         return false;
/*     */       }
/*     */     }
/* 149 */     return checkCanBeWantedByNPC(wantedRoleId, xWantedInfo, activeRoleId, wantedRoleError, true);
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
/*     */   static void getRoleNamesOctets(Collection<Long> roleIds, ArrayList<Octets> nameList, boolean isWanted)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 164 */     for (Long roleId : roleIds)
/*     */     {
/* 166 */       if ((!isWanted) || (isHongMing(roleId.longValue())))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 171 */         Octets octets = new Octets();
/* 172 */         octets.setString(RoleInterface.getName(roleId.longValue()), "utf-8");
/* 173 */         nameList.add(octets);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startNPCFightSession(long wantedRoleId, WantedInfo xWantedInfo)
/*     */   {
/* 184 */     if ((xWantedInfo != null) && (!WantedPageManager.getInstance().containsRecord(Long.valueOf(wantedRoleId))) && (!PrisonPageManager.getInstance().containsRecord(Long.valueOf(wantedRoleId))))
/*     */     {
/*     */ 
/* 187 */       Session oldSession = Session.getSession(xWantedInfo.getSessionid());
/* 188 */       if ((oldSession != null) && (oldSession.getOwerId() == wantedRoleId))
/*     */       {
/* 190 */         return;
/*     */       }
/*     */       
/* 193 */       int fightId = xWantedInfo.getNpcfightcount() >= 1 ? SPKConsts.getInstance().NPC_ARREST_FIGHT_ID_2 : SPKConsts.getInstance().NPC_ARREST_FIGHT_ID_1;
/*     */       
/*     */ 
/*     */ 
/* 197 */       NPCWantedSession npcWantedSession = new NPCWantedSession(0L, wantedRoleId, fightId);
/* 198 */       xWantedInfo.setSessionid(npcWantedSession.getSessionId());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopNPCFightSession(long wantedRoleId, WantedInfo xWantedInfo)
/*     */   {
/* 209 */     if ((xWantedInfo != null) && (!WantedPageManager.getInstance().containsRecord(Long.valueOf(wantedRoleId))) && (!PrisonPageManager.getInstance().containsRecord(Long.valueOf(wantedRoleId))))
/*     */     {
/*     */ 
/* 212 */       Session.removeSession(xWantedInfo.getSessionid(), wantedRoleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void ArrestRoles(Collection<Long> wantedRoles)
/*     */     throws Exception
/*     */   {
/* 223 */     for (Iterator i$ = wantedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 226 */       PrisonInterface.putRoleInJail(roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void reduceEquipmentUsePoint(long roleId, int penalty)
/*     */   {
/* 233 */     RoleEquipBag equipBag = ItemInterface.getRoleEquipBag(roleId);
/* 234 */     if (equipBag == null)
/*     */     {
/* 236 */       return;
/*     */     }
/* 238 */     Map<Integer, BasicItem> allEquipments = equipBag.getAllItems(false);
/*     */     
/* 240 */     for (Map.Entry<Integer, BasicItem> entry : allEquipments.entrySet())
/*     */     {
/* 242 */       BasicItem basicItem = (BasicItem)entry.getValue();
/* 243 */       if ((basicItem instanceof EquipmentItem))
/*     */       {
/*     */ 
/*     */ 
/* 247 */         EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/* 248 */         equipmentItem.reduceUsePointByRatio(penalty);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean checkSwitchAndCross(long roleId, int status)
/*     */   {
/* 255 */     if (!OpenInterface.getOpenStatus(412))
/*     */     {
/* 257 */       return false;
/*     */     }
/* 259 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, status, false))
/*     */     {
/* 261 */       return false;
/*     */     }
/* 263 */     return true;
/*     */   }
/*     */   
/*     */   public static Boolean checkMoneyForRole(String userId, long roleId, int moneyType, long moneyToCut)
/*     */   {
/* 268 */     long roleMoneyCount = getMoneyForRole(userId, roleId, moneyType);
/* 269 */     if (roleMoneyCount < moneyToCut)
/*     */     {
/* 271 */       return Boolean.valueOf(false);
/*     */     }
/* 273 */     return Boolean.valueOf(true);
/*     */   }
/*     */   
/*     */   public static long getMoneyForRole(String userId, long roleId, int moneyType)
/*     */   {
/* 278 */     switch (moneyType)
/*     */     {
/*     */     case 3: 
/* 281 */       return RoleInterface.getSilver(roleId);
/*     */     case 2: 
/* 283 */       return RoleInterface.getGold(roleId);
/*     */     case 5: 
/* 285 */       return RoleInterface.getGoldIngot(roleId);
/*     */     case 1: 
/* 287 */       return QingfuInterface.getBalance(userId, true);
/*     */     case 4: 
/* 289 */       return GangInterface.getBangGong(roleId);
/*     */     }
/* 291 */     return -1L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean cutMoney(String userId, long roleId, LogReason logReason, int subReason, int moneyType, long moneyToCut, CostType costType)
/*     */   {
/* 298 */     TLogArg logArg = new TLogArg(logReason, subReason);
/* 299 */     if (moneyToCut == 0L)
/*     */     {
/* 301 */       return true;
/*     */     }
/* 303 */     switch (moneyType)
/*     */     {
/*     */     case 0: 
/* 306 */       return true;
/*     */     case 3: 
/* 308 */       if (!RoleInterface.cutSilver(roleId, moneyToCut, logArg))
/*     */       {
/* 310 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 314 */       if (!RoleInterface.cutGold(roleId, moneyToCut, logArg))
/*     */       {
/* 316 */         return false;
/*     */       }
/*     */       break;
/*     */     case 5: 
/* 320 */       if (!RoleInterface.cutGoldIngot(roleId, moneyToCut, logArg))
/*     */       {
/* 322 */         return false;
/*     */       }
/*     */       break;
/*     */     case 1: 
/* 326 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, (int)moneyToCut, costType, logArg);
/* 327 */       if (costResult != CostResult.Success)
/*     */       {
/* 329 */         return false;
/*     */       }
/*     */       break;
/*     */     case 4: 
/* 333 */       if (!GangInterface.cutBangGong(roleId, (int)moneyToCut, logArg))
/*     */       {
/* 335 */         return false;
/*     */       }
/*     */       break;
/*     */     default: 
/* 339 */       return false;
/*     */     }
/* 341 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkActiveRoles(long wantedRoleId, WantedInfo xWantedInfo, List<Long> activeRoleIds, SWantedRoleError wantedRoleError)
/*     */     throws Exception
/*     */   {
/* 347 */     long receiverId = ((Long)activeRoleIds.get(0)).longValue();
/* 348 */     if (xWantedInfo == null)
/*     */     {
/* 350 */       wantedRoleError.errorcode = 6;
/* 351 */       OnlineManager.getInstance().sendAtOnce(receiverId, wantedRoleError);
/* 352 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 357 */     Map<Long, Integer> xRoleId2count = xWantedInfo.getRoleid2count();
/* 358 */     int requiredWantedRoleLevel = RoleInterface.getLevel(wantedRoleId) - SPKConsts.getInstance().ARREST_LEVEL_DIFF;
/*     */     
/*     */ 
/* 361 */     for (Iterator i$ = activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 363 */       String name = RoleInterface.getName(roleId);
/* 364 */       boolean ret = checkMoneyForRole(RoleInterface.getUserId(roleId), roleId, SPKConsts.getInstance().ARREST_MONEY_TYPE, SPKConsts.getInstance().ARREST_PRICE).booleanValue();
/*     */       
/* 366 */       if (!ret)
/*     */       {
/* 368 */         Octets octets = new Octets();
/* 369 */         octets.setString(name, "utf-8");
/* 370 */         wantedRoleError.params.add(octets);
/*     */       }
/*     */     }
/* 373 */     if (!wantedRoleError.params.isEmpty())
/*     */     {
/* 375 */       wantedRoleError.errorcode = 3;
/* 376 */       OnlineManager.getInstance().sendAtOnce(receiverId, wantedRoleError);
/* 377 */       return false;
/*     */     }
/*     */     
/* 380 */     for (Iterator i$ = activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 382 */       String name = RoleInterface.getName(roleId);
/*     */       
/* 384 */       if (!RoleStatusInterface.checkCanSetStatus(roleId, 1652, false))
/*     */       {
/* 386 */         Octets octets = new Octets();
/* 387 */         octets.setString(name, "utf-8");
/* 388 */         wantedRoleError.params.add(octets);
/*     */       }
/*     */     }
/* 391 */     if (!wantedRoleError.params.isEmpty())
/*     */     {
/* 393 */       wantedRoleError.errorcode = 7;
/* 394 */       OnlineManager.getInstance().sendAtOnce(receiverId, wantedRoleError);
/* 395 */       return false;
/*     */     }
/*     */     
/* 398 */     for (Iterator i$ = activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 400 */       String name = RoleInterface.getName(roleId);
/*     */       
/* 402 */       if (RoleInterface.getLevel(roleId) < requiredWantedRoleLevel)
/*     */       {
/* 404 */         Octets octets = new Octets();
/* 405 */         octets.setString(name, "utf-8");
/* 406 */         wantedRoleError.params.add(octets);
/*     */       }
/*     */     }
/*     */     
/* 410 */     if (!wantedRoleError.params.isEmpty())
/*     */     {
/* 412 */       wantedRoleError.errorcode = 8;
/* 413 */       OnlineManager.getInstance().sendAtOnce(receiverId, wantedRoleError);
/* 414 */       return false;
/*     */     }
/*     */     
/* 417 */     for (Iterator i$ = activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 419 */       String name = RoleInterface.getName(roleId);
/*     */       
/* 421 */       if ((xRoleId2count.containsKey(Long.valueOf(roleId))) && (((Integer)xRoleId2count.get(Long.valueOf(roleId))).intValue() >= SPKConsts.getInstance().ARREST_MAX_COUNT))
/*     */       {
/* 423 */         Octets octets = new Octets();
/* 424 */         octets.setString(name, "utf-8");
/* 425 */         wantedRoleError.params.add(octets);
/*     */       }
/*     */     }
/* 428 */     if (!wantedRoleError.params.isEmpty())
/*     */     {
/* 430 */       wantedRoleError.errorcode = 4;
/* 431 */       OnlineManager.getInstance().sendAtOnce(receiverId, wantedRoleError);
/* 432 */       return false;
/*     */     }
/* 434 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */