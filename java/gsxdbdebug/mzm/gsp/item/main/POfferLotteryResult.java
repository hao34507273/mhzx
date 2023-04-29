/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.baotu.SBaotuFanBaoBulletinRes;
/*     */ import mzm.gsp.baotu.event.WaBao;
/*     */ import mzm.gsp.baotu.event.WaBaoArg;
/*     */ import mzm.gsp.baotu.main.BaoTuInterface;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*     */ import mzm.gsp.luckybag.main.LuckyBagInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LotteryResult;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POfferLotteryResult extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private int lotterytype;
/*     */   
/*     */   public POfferLotteryResult(long roleId, int lotterytype)
/*     */   {
/*  32 */     this.roleId = roleId;
/*     */     
/*  34 */     this.lotterytype = lotterytype;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     String userid = RoleInterface.getUserId(this.roleId);
/*  42 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*  43 */     LotteryResult result = null;
/*  44 */     Map<Integer, Integer> itemmaMap = null;
/*  45 */     switch (this.lotterytype)
/*     */     {
/*     */     case 2: 
/*  48 */       boolean res = LotteryManager.awardToRole(userid, this.roleId, 2);
/*  49 */       if (!res)
/*     */       {
/*  51 */         return false;
/*     */       }
/*  53 */       itemmaMap = LotteryManager.getItemMap(this.roleId, 2);
/*     */       
/*  55 */       result = LotteryManager.removeLottery(this.roleId, 2);
/*  56 */       if (result == null)
/*     */       {
/*  58 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 0: 
/*  63 */       boolean r = LotteryManager.awardToRole(userid, this.roleId, 0);
/*  64 */       if (!r)
/*     */       {
/*  66 */         return false;
/*     */       }
/*  68 */       itemmaMap = LotteryManager.getItemMap(this.roleId, 0);
/*     */       
/*  70 */       result = LotteryManager.removeLottery(this.roleId, 0);
/*  71 */       if (result == null)
/*     */       {
/*  73 */         return false;
/*     */       }
/*  75 */       Integer controllerId = (Integer)result.getMap().get(Integer.valueOf(7));
/*  76 */       if ((controllerId != null) && (controllerId.intValue() > 0))
/*     */       {
/*  78 */         List<Integer> mapList = mzm.gsp.map.main.ControllerInterface.getControllerMapList(controllerId.intValue());
/*  79 */         boolean isBaobao = BaoTuInterface.isBaoBaoController(controllerId.intValue());
/*     */         
/*  81 */         if ((!mapList.isEmpty()) && (isBaobao))
/*     */         {
/*  83 */           SBaotuFanBaoBulletinRes bulletinRes = new SBaotuFanBaoBulletinRes();
/*     */           
/*  85 */           bulletinRes.controllerid = controllerId.intValue();
/*  86 */           bulletinRes.itemid = result.getUseditemid();
/*  87 */           bulletinRes.mapid = ((Integer)mapList.get(0)).intValue();
/*  88 */           bulletinRes.rolename.setString(RoleInterface.getName(this.roleId), "UTF-8");
/*     */           
/*  90 */           OnlineManager.getInstance().sendAll(bulletinRes);
/*     */         }
/*     */         else
/*     */         {
/*  94 */           String logStr = String.format("[item]POfferLotteryResult.processImp@mapList is empty|roleid=%d|controllerid=%d|isBaobao=%d", new Object[] { Long.valueOf(this.roleId), controllerId, Integer.valueOf(isBaobao ? 1 : 0) });
/*     */           
/*     */ 
/*  97 */           ItemManager.logger.warn(logStr);
/*     */         }
/*     */       }
/*     */       
/* 101 */       worldBroadcast(itemmaMap, result.getUseditemid());
/*     */       
/* 103 */       TriggerEventsManger.getInstance().triggerEvent(new WaBao(), new WaBaoArg(this.roleId, result.copy()));
/* 104 */       break;
/*     */     
/*     */     case 1: 
/* 107 */       boolean ret = LotteryManager.awardToRole(userid, this.roleId, 1);
/* 108 */       if (!ret)
/*     */       {
/* 110 */         return false;
/*     */       }
/* 112 */       itemmaMap = LotteryManager.getItemMap(this.roleId, 1);
/*     */       
/* 114 */       result = LotteryManager.removeLottery(this.roleId, 1);
/* 115 */       if (result == null)
/*     */       {
/* 117 */         return false;
/*     */       }
/* 119 */       worldBroadcast(this.roleId, itemmaMap, result.getUseditemid());
/* 120 */       break;
/*     */     case 3: 
/* 122 */       boolean awarded = LotteryManager.awardToRole(userid, this.roleId, 3);
/* 123 */       if (!awarded)
/*     */       {
/* 125 */         return false;
/*     */       }
/* 127 */       itemmaMap = LotteryManager.getItemMap(this.roleId, 3);
/*     */       
/* 129 */       result = LotteryManager.removeLottery(this.roleId, 3);
/* 130 */       if (result == null)
/*     */       {
/* 132 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 5: 
/* 137 */       boolean miBaoRet = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 138 */       if (!miBaoRet)
/*     */       {
/* 140 */         return false;
/*     */       }
/* 142 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 144 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 145 */       if (result == null)
/*     */       {
/* 147 */         return false;
/*     */       }
/*     */       
/* 150 */       commonWorldBroadcast(this.roleId, itemmaMap, 32);
/*     */       
/* 152 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award mi bao success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 154 */       break;
/*     */     
/*     */     case 6: 
/* 157 */       boolean luckyBagRet = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 158 */       if (!luckyBagRet)
/*     */       {
/* 160 */         return false;
/*     */       }
/* 162 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 164 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 165 */       if (result == null)
/*     */       {
/* 167 */         return false;
/*     */       }
/* 169 */       LuckyBagInterface.worldBroadcast(this.roleId, itemmaMap);
/* 170 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award lucky bag success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 172 */       break;
/*     */     
/*     */     case 7: 
/* 175 */       boolean payNewYearAwardResult = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 176 */       if (!payNewYearAwardResult)
/*     */       {
/* 178 */         return false;
/*     */       }
/* 180 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 182 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 183 */       if (result == null)
/*     */       {
/* 185 */         return false;
/*     */       }
/* 187 */       worldBroadcastPayNewYear(this.roleId, itemmaMap);
/*     */       
/* 189 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award pay new year success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 191 */       break;
/*     */     
/*     */     case 8: 
/* 194 */       boolean romanticDanceAwardResult = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 195 */       if (!romanticDanceAwardResult)
/*     */       {
/* 197 */         return false;
/*     */       }
/* 199 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 201 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 202 */       if (result == null)
/*     */       {
/* 204 */         return false;
/*     */       }
/*     */       
/* 207 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award romantic award success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 210 */       break;
/*     */     
/*     */     case 9: 
/* 213 */       boolean signPerciousAwardResult = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 214 */       if (!signPerciousAwardResult)
/*     */       {
/* 216 */         return false;
/*     */       }
/* 218 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 220 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 221 */       if (result == null)
/*     */       {
/* 223 */         return false;
/*     */       }
/*     */       
/* 226 */       boolean triggerResult = mzm.gsp.signaward.main.SignAwardInterface.triggerLuckyPrecious(userid, this.roleId);
/* 227 */       if (!triggerResult)
/*     */       {
/* 229 */         return false;
/*     */       }
/*     */       
/* 232 */       commonWorldBroadcast(this.roleId, itemmaMap, 36);
/* 233 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award sign precious award success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 236 */       break;
/*     */     case 10: 
/* 238 */       boolean axeRes = LotteryManager.awardToRole(userid, this.roleId, 10);
/* 239 */       if (!axeRes)
/*     */       {
/* 241 */         return false;
/*     */       }
/* 243 */       itemmaMap = LotteryManager.getItemMap(this.roleId, 10);
/*     */       
/* 245 */       result = LotteryManager.removeLottery(this.roleId, 10);
/* 246 */       if (result == null)
/*     */       {
/* 248 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 11: 
/* 253 */       boolean xhkpInnerDrawRet = LotteryManager.awardToRole(userid, this.roleId, 11);
/*     */       
/* 255 */       if (!xhkpInnerDrawRet)
/*     */       {
/* 257 */         return false;
/*     */       }
/* 259 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 261 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 262 */       if (result == null)
/*     */       {
/* 264 */         return false;
/*     */       }
/*     */       
/* 267 */       commonWorldBroadcast(this.roleId, itemmaMap, 47);
/*     */       
/* 269 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award xiao hui kuai pao inner draw success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 272 */       break;
/*     */     
/*     */     case 12: 
/* 275 */       boolean xhkpOuterDrawRet = LotteryManager.awardToRole(userid, this.roleId, 12);
/*     */       
/* 277 */       if (!xhkpOuterDrawRet)
/*     */       {
/* 279 */         return false;
/*     */       }
/* 281 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 283 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 284 */       if (result == null)
/*     */       {
/* 286 */         return false;
/*     */       }
/*     */       
/* 289 */       commonWorldBroadcast(this.roleId, itemmaMap, 48);
/*     */       
/* 291 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award xiao hui kuai pao outer draw success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 294 */       break;
/*     */     
/*     */     case 13: 
/* 297 */       boolean awardResult = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 298 */       if (!awardResult)
/*     */       {
/* 300 */         return false;
/*     */       }
/* 302 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 304 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 305 */       if (null == result)
/*     */       {
/* 307 */         return false;
/*     */       }
/*     */       
/* 310 */       ChangeModelCardInterface.sendCardLotteryBulletin(this.roleId, itemmaMap.keySet());
/*     */       
/*     */ 
/* 313 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award LOTTRY_TYPE_CHANGE_MODEL_CARD_DRAW success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 318 */       break;
/*     */     
/*     */     case 14: 
/* 321 */       boolean petMarkAwardResult = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 322 */       if (!petMarkAwardResult)
/*     */       {
/* 324 */         return false;
/*     */       }
/* 326 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 328 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 329 */       if (null == result)
/*     */       {
/* 331 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 335 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award LOTTRY_TYPE_PET_MARK_DRAW success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/* 339 */       break;
/*     */     
/*     */     case 15: 
/* 342 */       boolean drawCarnivalDrawRet = LotteryManager.awardToRole(userid, this.roleId, 15);
/*     */       
/* 344 */       if (!drawCarnivalDrawRet)
/*     */       {
/* 346 */         return false;
/*     */       }
/* 348 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 350 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 351 */       if (result == null)
/*     */       {
/* 353 */         return false;
/*     */       }
/*     */       
/* 356 */       commonWorldBroadcast(this.roleId, itemmaMap, 54);
/*     */       
/* 358 */       GameServer.logger().info(String.format("[item]POfferLotteryResult.processImp@award draw carnival draw success|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 361 */       break;
/*     */     case 4: default: 
/* 363 */       boolean r1 = LotteryManager.awardToRole(userid, this.roleId, this.lotterytype);
/* 364 */       if (!r1)
/*     */       {
/* 366 */         return false;
/*     */       }
/* 368 */       itemmaMap = LotteryManager.getItemMap(this.roleId, this.lotterytype);
/*     */       
/* 370 */       result = LotteryManager.removeLottery(this.roleId, this.lotterytype);
/* 371 */       if (result == null)
/*     */       {
/* 373 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/* 379 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void worldBroadcast(Map<Integer, Integer> itemMap, int baotuId)
/*     */   {
/* 390 */     Iterator<Integer> it = itemMap.keySet().iterator();
/* 391 */     int findItemId = -1;
/* 392 */     while (it.hasNext())
/*     */     {
/* 394 */       int id = ((Integer)it.next()).intValue();
/* 395 */       if (BaoTuInterface.needBulletin(id))
/*     */       {
/* 397 */         findItemId = id;
/* 398 */         break;
/*     */       }
/*     */     }
/* 401 */     if (findItemId < 0)
/*     */     {
/* 403 */       return;
/*     */     }
/* 405 */     if (BaoTuInterface.needBulletin(findItemId))
/*     */     {
/* 407 */       SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 408 */       sBulletinInfo.bulletintype = 12;
/* 409 */       sBulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleId));
/* 410 */       sBulletinInfo.params.put(Integer.valueOf(11), String.valueOf(baotuId));
/* 411 */       sBulletinInfo.params.put(Integer.valueOf(4), String.valueOf(findItemId));
/* 412 */       BulletinInterface.sendBulletin(sBulletinInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void worldBroadcast(long roleid, Map<Integer, Integer> itemMap, int lotteryItemid)
/*     */   {
/* 419 */     Iterator<Integer> it = itemMap.keySet().iterator();
/* 420 */     int findItemId = -1;
/* 421 */     while (it.hasNext())
/*     */     {
/* 423 */       int id = ((Integer)it.next()).intValue();
/* 424 */       if (BaoTuInterface.needBulletin(id))
/*     */       {
/* 426 */         findItemId = id;
/* 427 */         break;
/*     */       }
/*     */     }
/* 430 */     if (findItemId < 0)
/*     */     {
/* 432 */       return;
/*     */     }
/* 434 */     if (BaoTuInterface.needBulletin(findItemId))
/*     */     {
/* 436 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 437 */       bulletinInfo.bulletintype = 14;
/* 438 */       bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/* 439 */       bulletinInfo.params.put(Integer.valueOf(12), String.valueOf(lotteryItemid));
/* 440 */       bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(findItemId));
/* 441 */       BulletinInterface.sendBulletin(bulletinInfo);
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
/*     */   private void commonWorldBroadcast(long roleid, Map<Integer, Integer> itemMap, int buffetType)
/*     */   {
/* 456 */     for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*     */     {
/* 458 */       int itemCfgId = ((Integer)entry.getKey()).intValue();
/* 459 */       if (BaoTuInterface.needBulletin(itemCfgId))
/*     */       {
/* 461 */         int itemNum = ((Integer)entry.getValue()).intValue();
/* 462 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 463 */         bulletinInfo.bulletintype = buffetType;
/* 464 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/* 465 */         bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemCfgId));
/* 466 */         bulletinInfo.params.put(Integer.valueOf(15), String.valueOf(itemNum));
/* 467 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
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
/*     */   private void worldBroadcastPayNewYear(long roleid, Map<Integer, Integer> itemMap)
/*     */   {
/* 482 */     for (Map.Entry<Integer, Integer> entry : itemMap.entrySet())
/*     */     {
/* 484 */       int itemCfgId = ((Integer)entry.getKey()).intValue();
/* 485 */       if (BaoTuInterface.needBulletin(itemCfgId))
/*     */       {
/* 487 */         int itemNum = ((Integer)entry.getValue()).intValue();
/* 488 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 489 */         bulletinInfo.bulletintype = 35;
/* 490 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/* 491 */         bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemCfgId));
/* 492 */         bulletinInfo.params.put(Integer.valueOf(15), String.valueOf(itemNum));
/* 493 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POfferLotteryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */