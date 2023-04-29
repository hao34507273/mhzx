/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.occupation.confbean.SOccupationPropTable;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.RoleInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ import xbean.BasicPropertiesSystem;
/*     */ import xbean.CoinInfo;
/*     */ import xbean.DeleteState;
/*     */ import xbean.Pod;
/*     */ import xbean.Properties;
/*     */ import xbean.RoleDayClearCounter;
/*     */ import xbean.TransferOccupationPropertiesSys;
/*     */ import xtable.Name2roleid;
/*     */ import xtable.Role2dayclear;
/*     */ import xtable.Role2delete;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class RoleInterface
/*     */ {
/*     */   public static boolean isRoleExit(long paramLong)
/*     */   {
/*  40 */     return xtable.Basic.select(Long.valueOf(paramLong)) != null;
/*     */   }
/*     */   
/*     */   public static boolean isRoleRealDel(long paramLong) {
/*  44 */     DeleteState localDeleteState = Role2delete.select(Long.valueOf(paramLong));
/*  45 */     if (localDeleteState == null) {
/*  46 */       return false;
/*     */     }
/*  48 */     int i = localDeleteState.getDeletestate();
/*  49 */     if (i == 2) {
/*  50 */       return true;
/*     */     }
/*  52 */     if (i != 0) {
/*  53 */       return false;
/*     */     }
/*  55 */     long l = localDeleteState.getDeleteendtime() - DateTimeUtils.getCurrTimeInMillis();
/*  56 */     if (l > 0L) {
/*  57 */       return false;
/*     */     }
/*  59 */     new PSetRoleRealDel(paramLong).execute();
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public static String getName(long paramLong) {
/*  64 */     return xtable.Basic.selectName(Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   public static int getGender(long paramLong) {
/*  68 */     return xtable.Basic.selectGender(Long.valueOf(paramLong)).intValue();
/*     */   }
/*     */   
/*     */   public static boolean setGender(long paramLong, int paramInt)
/*     */   {
/*  73 */     xbean.Basic localBasic = xtable.Basic.get(Long.valueOf(paramLong));
/*  74 */     if (localBasic == null) {
/*  75 */       return false;
/*     */     }
/*  77 */     localBasic.setGender(paramInt);
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   public static int getLevel(long paramLong) {
/*  82 */     return Role2properties.selectLevel(Long.valueOf(paramLong)).intValue();
/*     */   }
/*     */   
/*     */   public static long getLevelUpCurTime(long paramLong) {
/*  86 */     Long localLong = Role2properties.selectLevelupcurtime(Long.valueOf(paramLong));
/*  87 */     return localLong == null ? -1L : localLong.longValue();
/*     */   }
/*     */   
/*     */   public static int getOccupationId(long paramLong) {
/*  91 */     return xtable.Basic.selectOccupationid(Long.valueOf(paramLong)).intValue();
/*     */   }
/*     */   
/*     */   public static boolean setOccupationid(long paramLong, int paramInt) {
/*  95 */     xbean.Basic localBasic = xtable.Basic.get(Long.valueOf(paramLong));
/*  96 */     if (localBasic == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     localBasic.setOccupationid(paramInt);
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   public static int getCurExp(long paramLong) {
/* 104 */     Integer localInteger = Role2properties.selectExp(Long.valueOf(paramLong));
/* 105 */     return localInteger == null ? 0 : localInteger.intValue();
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addSilver(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 109 */     return RoleModuleManager.addSilverInAll(paramLong1, paramLong2, paramTLogArg, false);
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addSilverWithinMax(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 113 */     return RoleModuleManager.addSilverInAll(paramLong1, paramLong2, paramTLogArg, true);
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addSilver(long paramLong1, long paramLong2, TLogArg paramTLogArg, boolean paramBoolean) {
/* 117 */     return RoleModuleManager.addSilverInAll(paramLong1, paramLong2, paramTLogArg, paramBoolean);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult addSilverByIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 121 */     return RoleModuleManager.addSilverByIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult addSilverByAqIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 125 */     return RoleModuleManager.addSilverByAqIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult cutSilverByIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 129 */     return RoleModuleManager.cutSilverByIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult cutSilverByAqIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 133 */     return RoleModuleManager.cutSilverByAqIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static boolean addSilver(long paramLong1, long paramLong2) {
/* 138 */     if (paramLong2 < 0L) {
/* 139 */       return false;
/*     */     }
/* 141 */     if (paramLong2 == 0L) {
/* 142 */       return true;
/*     */     }
/* 144 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong1));
/* 145 */     long l = localProperties.getSilver();
/* 146 */     if (Long.MAX_VALUE - l < paramLong2) {
/* 147 */       return false;
/*     */     }
/* 149 */     localProperties.setSilver(l + paramLong2);
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   public static void fillRoleInfo(long paramLong, RoleInfo paramRoleInfo) {
/* 154 */     Properties localProperties = Role2properties.select(Long.valueOf(paramLong));
/* 155 */     xbean.Basic localBasic = xtable.Basic.select(Long.valueOf(paramLong));
/* 156 */     if ((localProperties == null) || (localBasic == null)) {
/* 157 */       GameServer.logger().error(String.format("[role]roleInterface.fillRoleInfo@can not find role xData!|roleId=%d", new Object[] { Long.valueOf(paramLong) }));
/* 158 */       return;
/*     */     }
/* 160 */     paramRoleInfo.occupationid = localBasic.getOccupationid();
/* 161 */     paramRoleInfo.roleid = paramLong;
/* 162 */     String str1 = getUserId(paramLong);
/* 163 */     String str2 = gnet.link.Onlines.getInstance().findOpenid(str1);
/* 164 */     paramRoleInfo.openid = str2;
/* 165 */     paramRoleInfo.level = localProperties.getLevel();
/* 166 */     paramRoleInfo.name = localBasic.getName();
/* 167 */     paramRoleInfo.gender = localBasic.getGender();
/* 168 */     paramRoleInfo.onlinestatus = (OnlineManager.getInstance().isOnline(paramLong) ? 1 : 2);
/* 169 */     Long localLong = TeamInterface.getTeamidByRoleid(paramLong, false);
/* 170 */     paramRoleInfo.teamid = -1L;
/* 171 */     if (localLong != null) {
/* 172 */       paramRoleInfo.teamid = localLong.longValue();
/* 173 */       localObject = TeamInterface.getTeamMemberList(localLong.longValue(), false);
/* 174 */       paramRoleInfo.teammembernum = ((List)localObject).size();
/*     */     }
/* 176 */     mzm.gsp.gang.main.GangInterface.fillRoleGangInfo(paramLong, paramRoleInfo);
/* 177 */     paramRoleInfo.friendsetting = mzm.gsp.systemsetting.main.SystemSettingInterface.getSetting(paramLong, 2).intValue();
/* 178 */     Object localObject = Role2delete.select(Long.valueOf(paramLong));
/* 179 */     paramRoleInfo.deletestate = 3;
/* 180 */     if (localObject != null) {
/* 181 */       paramRoleInfo.deletestate = ((DeleteState)localObject).getDeletestate();
/*     */     }
/* 183 */     mzm.gsp.title.main.TitleInterface.fillAppellationInfoBean(paramLong, paramRoleInfo.appellationinfo);
/* 184 */     paramRoleInfo.hashomeland = (mzm.gsp.homeland.main.HomelandInterface.hasHome(paramLong) ? 1 : 0);
/* 185 */     paramRoleInfo.holdbanquest = (mzm.gsp.banquest.main.BanquestInterface.isHoldBanquesting(paramLong) ? 1 : 0);
/* 186 */     paramRoleInfo.avatarid = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(paramLong, false);
/* 187 */     paramRoleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(paramLong, false);
/*     */   }
/*     */   
/*     */   public static boolean cutVigor(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 191 */     if (paramInt < 0) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (paramInt == 0) {
/* 195 */       return true;
/*     */     }
/* 197 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong));
/* 198 */     int i = localProperties.getVigor() - paramInt;
/* 199 */     if (i < 0) {
/* 200 */       return false;
/*     */     }
/* 202 */     localProperties.setVigor(i);
/* 203 */     RoleVigorManager.logVigorChange(paramLong, paramTLogArg, i, paramInt * -1);
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addGold(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 208 */     return RoleModuleManager.addGoldInAll(paramLong1, paramLong2, paramTLogArg, false);
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addGoldWithinMax(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 212 */     return RoleModuleManager.addGoldInAll(paramLong1, paramLong2, paramTLogArg, true);
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addGold(long paramLong1, long paramLong2, TLogArg paramTLogArg, boolean paramBoolean) {
/* 216 */     return RoleModuleManager.addGoldInAll(paramLong1, paramLong2, paramTLogArg, paramBoolean);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static boolean addGold(long paramLong1, long paramLong2) {
/* 221 */     if (paramLong2 < 0L) {
/* 222 */       return false;
/*     */     }
/* 224 */     if (paramLong2 == 0L) {
/* 225 */       return true;
/*     */     }
/* 227 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong1));
/* 228 */     long l = localProperties.getGold();
/* 229 */     if (Long.MAX_VALUE - l < paramLong2) {
/* 230 */       return false;
/*     */     }
/* 232 */     RoleModuleManager.setGold(paramLong1, localProperties, l + paramLong2);
/* 233 */     return true;
/*     */   }
/*     */   
/*     */   public static MoneyOperResult addGoldByIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 237 */     return RoleModuleManager.addGoldByIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult addGoldByAqIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 241 */     return RoleModuleManager.addGoldByAqIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult cutGoldByIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 245 */     return RoleModuleManager.cutGoldByIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult cutGoldByAqIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 249 */     return RoleModuleManager.cutGoldByAqIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static boolean cutGold(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 253 */     return new RoleOperMoneyGold(paramLong1, paramLong2, paramTLogArg).cutMoney();
/*     */   }
/*     */   
/*     */   public static long getGoldIngot(long paramLong) {
/* 257 */     Long localLong = Role2properties.selectGoldingot(Long.valueOf(paramLong));
/* 258 */     return localLong == null ? 0L : localLong.longValue();
/*     */   }
/*     */   
/*     */   public static ModMoneyResult addGoldIngotInAll(long paramLong1, long paramLong2, TLogArg paramTLogArg, boolean paramBoolean) {
/* 262 */     return new RoleOperMoneyGoldIngot(paramLong1, paramLong2, paramTLogArg, paramBoolean).addMoneyInAll();
/*     */   }
/*     */   
/*     */   public static MoneyOperResult addGoldIngotByIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 266 */     return RoleModuleManager.addGoldIngotByIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static MoneyOperResult addGoldIngotByAqIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 270 */     return RoleModuleManager.addGoldIngotByAqIDIP(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static boolean cutGoldIngot(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 274 */     return new RoleOperMoneyGoldIngot(paramLong1, paramLong2, paramTLogArg).cutMoney();
/*     */   }
/*     */   
/*     */   public static MoneyOperResult cutGoldIngotByIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 278 */     return new RoleOperMoneyGoldIngot(paramLong1, paramLong2, paramTLogArg).cutMoneyByIDIP();
/*     */   }
/*     */   
/*     */   public static MoneyOperResult cutGoldIngotByAqIDIP(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 282 */     return new RoleOperMoneyGoldIngot(paramLong1, paramLong2, paramTLogArg).cutMoneyByAqIDIP();
/*     */   }
/*     */   
/*     */   public static int getModelId(long paramLong) {
/* 286 */     int i = getOccupationId(paramLong);
/* 287 */     int j = getGender(paramLong);
/* 288 */     Occupation localOccupation = OccupationManager.getOccupationById(i, j);
/* 289 */     return localOccupation.getModelId();
/*     */   }
/*     */   
/*     */   public static boolean cutSilver(long paramLong1, long paramLong2, TLogArg paramTLogArg) {
/* 293 */     return RoleModuleManager.cutSilver(paramLong1, paramLong2, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static long getGold(long paramLong) {
/* 297 */     return Role2properties.selectGold(Long.valueOf(paramLong)).longValue();
/*     */   }
/*     */   
/*     */   public static long getSilver(long paramLong) {
/* 301 */     return Role2properties.selectSilver(Long.valueOf(paramLong)).longValue();
/*     */   }
/*     */   
/*     */   public static Role getRole(long paramLong, boolean paramBoolean) {
/* 305 */     Role localRole = new Role(paramLong, paramBoolean);
/* 306 */     return localRole;
/*     */   }
/*     */   
/*     */   public static int getVigor(long paramLong) {
/* 310 */     return Role2properties.selectVigor(Long.valueOf(paramLong)).intValue();
/*     */   }
/*     */   
/*     */   public static RoleOutFightObj getRoleOutFightObject(long paramLong) {
/* 314 */     RoleOutFightObj localRoleOutFightObj = new RoleOutFightObj(paramLong);
/* 315 */     return localRoleOutFightObj;
/*     */   }
/*     */   
/*     */   public static void fillModelInfo(long paramLong, mzm.gsp.pubdata.ModelInfo paramModelInfo) {
/* 319 */     Role localRole = new Role(paramLong, false);
/* 320 */     localRole.fillModelInfo(paramModelInfo);
/*     */   }
/*     */   
/*     */   public static Set<Long> getRoleSet(String paramString) {
/* 324 */     HashSet localHashSet = new HashSet();
/* 325 */     xbean.User localUser = xtable.User.select(paramString);
/* 326 */     if (localUser == null) {
/* 327 */       return null;
/*     */     }
/* 329 */     long l1 = DateTimeUtils.getCurrTimeInMillis();
/* 330 */     for (Iterator localIterator = localUser.getRoleids().iterator(); localIterator.hasNext();) { long l2 = ((Long)localIterator.next()).longValue();
/* 331 */       xbean.Basic localBasic = xtable.Basic.select(Long.valueOf(l2));
/* 332 */       if (localBasic != null)
/*     */       {
/*     */ 
/* 335 */         Integer localInteger = Role2delete.selectDeletestate(Long.valueOf(l2));
/* 336 */         if (localInteger != null) {
/* 337 */           if (localInteger.intValue() == 2) {
/*     */             continue;
/*     */           }
/* 340 */           if (localInteger.intValue() == 0) {
/* 341 */             Long localLong = Role2delete.selectDeleteendtime(Long.valueOf(l2));
/* 342 */             if (localLong == null) {
/*     */               continue;
/*     */             }
/* 345 */             long l3 = localLong.longValue() - l1;
/* 346 */             if (l3 <= 0L) {
/*     */               continue;
/*     */             }
/*     */           }
/*     */         }
/* 351 */         localHashSet.add(Long.valueOf(l2));
/*     */       } }
/* 353 */     return localHashSet;
/*     */   }
/*     */   
/*     */   public static String getRoleList(String paramString) {
/* 357 */     xbean.User localUser = xtable.User.select(paramString);
/* 358 */     if (localUser == null) {
/* 359 */       return null;
/*     */     }
/* 361 */     JSONArray localJSONArray = new JSONArray();
/* 362 */     long l1 = DateTimeUtils.getCurrTimeInMillis();
/* 363 */     for (Iterator localIterator = localUser.getRoleids().iterator(); localIterator.hasNext();) { long l2 = ((Long)localIterator.next()).longValue();
/* 364 */       xbean.Basic localBasic = xtable.Basic.select(Long.valueOf(l2));
/* 365 */       if (localBasic != null)
/*     */       {
/*     */ 
/* 368 */         Integer localInteger = Role2delete.selectDeletestate(Long.valueOf(l2));
/* 369 */         if (localInteger != null) {
/* 370 */           if (localInteger.intValue() == 2) {
/*     */             continue;
/*     */           }
/* 373 */           if (localInteger.intValue() == 0) {
/* 374 */             localObject = Role2delete.selectDeleteendtime(Long.valueOf(l2));
/* 375 */             if (localObject == null) {
/*     */               continue;
/*     */             }
/* 378 */             long l3 = ((Long)localObject).longValue() - l1;
/* 379 */             if (l3 <= 0L) {
/*     */               continue;
/*     */             }
/*     */           }
/*     */         }
/* 384 */         Object localObject = new JSONObject();
/* 385 */         ((JSONObject)localObject).put("roleid", l2);
/* 386 */         ((JSONObject)localObject).put("name", localBasic.getName());
/* 387 */         ((JSONObject)localObject).put("gender", localBasic.getGender());
/* 388 */         ((JSONObject)localObject).put("occupation", localBasic.getOccupationid());
/* 389 */         ((JSONObject)localObject).put("avatarid", mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(l2));
/* 390 */         ((JSONObject)localObject).put("avatar_frameid", AvatarFrameInterface.getCurrentAvatarFrameId(l2, false));
/* 391 */         ((JSONObject)localObject).put("level", getLevel(l2));
/* 392 */         localJSONArray.put(localObject);
/*     */       } }
/* 394 */     if (localJSONArray.length() < 1) {
/* 395 */       return null;
/*     */     }
/* 397 */     return localJSONArray.toString();
/*     */   }
/*     */   
/*     */   public static int getFightValue(long paramLong) {
/* 401 */     return Role2properties.selectFightvalue(Long.valueOf(paramLong)).intValue();
/*     */   }
/*     */   
/*     */   public static void setHP(long paramLong, int paramInt) {
/* 405 */     RoleOutFightObj localRoleOutFightObj = getRoleOutFightObject(paramLong);
/* 406 */     int i = localRoleOutFightObj.getFinalMaxHP();
/* 407 */     paramInt = Math.min(i, paramInt);
/* 408 */     paramInt = Math.max(paramInt, 1);
/* 409 */     localRoleOutFightObj.setHP(paramInt);
/*     */   }
/*     */   
/*     */   public static void setMP(long paramLong, int paramInt) {
/* 413 */     RoleOutFightObj localRoleOutFightObj = getRoleOutFightObject(paramLong);
/* 414 */     int i = localRoleOutFightObj.getFinalMaxMP();
/* 415 */     paramInt = Math.min(i, paramInt);
/* 416 */     paramInt = Math.max(paramInt, 1);
/* 417 */     localRoleOutFightObj.setMP(paramInt);
/*     */   }
/*     */   
/*     */   public static void setAnger(long paramLong, int paramInt) {
/* 421 */     RoleOutFightObj localRoleOutFightObj = getRoleOutFightObject(paramLong);
/* 422 */     localRoleOutFightObj.setAnger(paramInt);
/*     */   }
/*     */   
/*     */   public static VigorOperResult addVigor(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 426 */     Role localRole = getRole(paramLong, true);
/* 427 */     return localRole.addVigor(paramInt, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static VigorOperResult addVigorByIDIP(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 431 */     Role localRole = getRole(paramLong, true);
/* 432 */     return localRole.addVigor(paramInt, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static VigorOperResult addVigorByAqIDIP(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 436 */     return addVigorByIDIP(paramLong, paramInt, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static VigorOperResult cutVigorByIDIP(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 440 */     Role localRole = getRole(paramLong, true);
/* 441 */     return localRole.cutVigorByIDIP(paramInt, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static VigorOperResult cutVigorByAqIDIP(long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 445 */     Role localRole = getRole(paramLong, true);
/* 446 */     return localRole.cutVigorByAqIDIP(paramInt, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static int addBaoShiDu(long paramLong, int paramInt) {
/* 450 */     return RoleModuleManager.addBaoShiDu(paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public static boolean costBaoShiDu(long paramLong, int paramInt) {
/* 454 */     Role localRole = getRole(paramLong, true);
/* 455 */     return localRole.costBaoShiDu(paramInt);
/*     */   }
/*     */   
/*     */   public static long getLastLoginTime(long paramLong) {
/* 459 */     return Role2properties.selectLastlogintime(Long.valueOf(paramLong)).longValue();
/*     */   }
/*     */   
/*     */   public static long getLastLogoffTime(long paramLong) {
/* 463 */     Role localRole = getRole(paramLong, false);
/* 464 */     return localRole.getLastLogoffTime();
/*     */   }
/*     */   
/*     */   public static long setLastLogoffTimeWhenLogIn(long paramLong) {
/* 468 */     Role localRole = getRole(paramLong, true);
/* 469 */     if (localRole == null) {
/* 470 */       return -1L;
/*     */     }
/* 472 */     return localRole.setLastLogOffTimeWhenLogIn();
/*     */   }
/*     */   
/*     */   public static int getPlatform(long paramLong) {
/* 476 */     return OnlineManager.getInstance().getPlatform(getUserId(paramLong));
/*     */   }
/*     */   
/*     */   public static String getChannel(long paramLong) {
/* 480 */     return OnlineManager.getInstance().getChannel(getUserId(paramLong));
/*     */   }
/*     */   
/*     */   public static String getChannel(String paramString) {
/* 484 */     return OnlineManager.getInstance().getChannel(paramString);
/*     */   }
/*     */   
/*     */   public static String getMac(long paramLong) {
/* 488 */     return OnlineManager.getInstance().getMac(getUserId(paramLong));
/*     */   }
/*     */   
/*     */   public static String getUserId(long paramLong) {
/* 492 */     return xtable.Basic.selectUser_id(Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   public static String getIpStr(long paramLong) {
/* 496 */     int i = getIp(paramLong);
/* 497 */     return mzm.gsp.util.CommonUtils.convertIpBigEndianIntToStr(i);
/*     */   }
/*     */   
/*     */   public static int getIp(long paramLong) {
/* 501 */     return OnlineManager.getInstance().getIp(getUserId(paramLong));
/*     */   }
/*     */   
/*     */   public static boolean addExp(String paramString, long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 505 */     return addExp(paramString, paramLong, paramInt, true, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static boolean addExp(String paramString, long paramLong, int paramInt, boolean paramBoolean, TLogArg paramTLogArg) {
/* 509 */     Role localRole = getRole(paramLong, true);
/* 510 */     return localRole.addExp(paramInt, paramTLogArg, paramBoolean);
/*     */   }
/*     */   
/*     */   public static mzm.gsp.role.result.CutRoleExpResult cutExp(String paramString, long paramLong, int paramInt, TLogArg paramTLogArg) {
/* 514 */     Role localRole = getRole(paramLong, true);
/* 515 */     return localRole.cutRoleExp(paramInt, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static mzm.gsp.role.result.ReleaseStorageExpResult releaseExp(String paramString, long paramLong, TLogArg paramTLogArg) {
/* 519 */     Role localRole = getRole(paramLong, true);
/* 520 */     return localRole.releaseStorageExp(paramString, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static int getDeleteState(long paramLong, boolean paramBoolean) {
/* 524 */     DeleteState localDeleteState = null;
/* 525 */     if (paramBoolean) {
/* 526 */       localDeleteState = Role2delete.get(Long.valueOf(paramLong));
/*     */     }
/*     */     else {
/* 529 */       localDeleteState = Role2delete.select(Long.valueOf(paramLong));
/*     */     }
/* 531 */     if (localDeleteState == null) {
/* 532 */       return 3;
/*     */     }
/* 534 */     return localDeleteState.getDeletestate();
/*     */   }
/*     */   
/*     */   public static Integer getDeleteState(long paramLong) {
/* 538 */     return Role2delete.selectDeletestate(Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   public static int getRoleMaxLevel() {
/* 542 */     return Math.min(RoleCommonConstants.getInstance().MAX_LEVEL, mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() + RoleCommonConstants.getInstance().ROLE_LEVEL_MORE_THAN_SERVER_LEVEL);
/*     */   }
/*     */   
/*     */   public static void addSilverLog(long paramLong1, long paramLong2, long paramLong3, TLogArg paramTLogArg) {
/* 546 */     addCurrencyLog(paramLong1, CurrencyType.CURRENCY_SILVE, paramLong2, paramLong3, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static void addGoldLog(long paramLong1, long paramLong2, long paramLong3, TLogArg paramTLogArg) {
/* 550 */     addCurrencyLog(paramLong1, CurrencyType.CURRENCY_GOLD, paramLong2, paramLong3, paramTLogArg);
/*     */   }
/*     */   
/*     */   static void addCurrencyLog(long paramLong1, CurrencyType paramCurrencyType, long paramLong2, long paramLong3, TLogArg paramTLogArg) {
/* 554 */     CurrencyLogUtil.logCurrency(paramLong1, paramCurrencyType, (int)paramLong2, paramLong3, paramTLogArg);
/* 555 */     CurrencyLogUtil.tLogCurrency(paramLong1, paramCurrencyType, (int)paramLong2, paramLong3, paramTLogArg);
/* 556 */     CurrencyLogUtil.tlogMoneyFlow(paramLong1, paramCurrencyType, (int)paramLong2, paramLong3, paramTLogArg);
/*     */   }
/*     */   
/*     */   public static String getLogPCMURL(long paramLong) {
/* 560 */     String str = getUserId(paramLong);
/* 561 */     StringBuilder localStringBuilder = new StringBuilder();
/* 562 */     OnlineManager localOnlineManager = OnlineManager.getInstance();
/* 563 */     localStringBuilder.append(localOnlineManager.getPlatform(str)).append("|").append(localOnlineManager.getChannel(str)).append("|").append(localOnlineManager.getMac(str)).append("|").append(str).append("|").append(paramLong).append("|").append(getLevel(paramLong));
/* 564 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static void addDayCounter(long paramLong, int paramInt1, int paramInt2) {
/* 568 */     RoleDayClearCounter localRoleDayClearCounter = Role2dayclear.get(Long.valueOf(paramLong));
/* 569 */     if (localRoleDayClearCounter == null) {
/* 570 */       localRoleDayClearCounter = Pod.newRoleDayClearCounter();
/* 571 */       Role2dayclear.add(Long.valueOf(paramLong), localRoleDayClearCounter);
/*     */     }
/* 573 */     checkbefore(localRoleDayClearCounter);
/* 574 */     Integer localInteger = (Integer)localRoleDayClearCounter.getDatamap().get(Integer.valueOf(paramInt1));
/* 575 */     if (localInteger == null) {
/* 576 */       localInteger = Integer.valueOf(0);
/*     */     }
/* 578 */     localRoleDayClearCounter.getDatamap().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*     */   }
/*     */   
/*     */   private static void checkbefore(RoleDayClearCounter paramRoleDayClearCounter) {
/* 582 */     long l = DateTimeUtils.getCurrTimeInMillis();
/* 583 */     if (!DateTimeUtils.needDailyReset(paramRoleDayClearCounter.getTimestamp(), l, 0)) {
/* 584 */       return;
/*     */     }
/* 586 */     paramRoleDayClearCounter.getDatamap().clear();
/* 587 */     paramRoleDayClearCounter.setTimestamp(l);
/*     */   }
/*     */   
/*     */   public static int getDayCounter(long paramLong, int paramInt) {
/* 591 */     RoleDayClearCounter localRoleDayClearCounter = Role2dayclear.get(Long.valueOf(paramLong));
/* 592 */     if (localRoleDayClearCounter == null) {
/* 593 */       return 0;
/*     */     }
/* 595 */     checkbefore(localRoleDayClearCounter);
/* 596 */     Integer localInteger = (Integer)localRoleDayClearCounter.getDatamap().get(Integer.valueOf(paramInt));
/* 597 */     if (localInteger != null) {
/* 598 */       return localInteger.intValue();
/*     */     }
/* 600 */     return 0;
/*     */   }
/*     */   
/*     */   public static boolean isRoleExist(long paramLong, boolean paramBoolean) {
/* 604 */     if (paramBoolean) {
/* 605 */       if (Role2properties.get(Long.valueOf(paramLong)) == null) {
/* 606 */         return false;
/*     */       }
/*     */     }
/* 609 */     else if (Role2properties.select(Long.valueOf(paramLong)) == null) {
/* 610 */       return false;
/*     */     }
/* 612 */     return getDeleteState(paramLong, paramBoolean) == 3;
/*     */   }
/*     */   
/*     */   public static long getRoleIdByName(String paramString) {
/* 616 */     Long localLong = Name2roleid.select(paramString);
/* 617 */     if (localLong == null) {
/* 618 */       return -1L;
/*     */     }
/* 620 */     return localLong.longValue();
/*     */   }
/*     */   
/*     */   public static int changeRoleName(long paramLong, String paramString) {
/* 624 */     return changeRoleName(paramLong, paramString, true);
/*     */   }
/*     */   
/*     */   public static int changeRoleName4Idip(long paramLong, String paramString) {
/* 628 */     return changeRoleName(paramLong, paramString, false);
/*     */   }
/*     */   
/*     */   public static int changeRoleName(long paramLong, String paramString, boolean paramBoolean) {
/* 632 */     if ((paramBoolean) && (mzm.gsp.idip.main.IdipManager.isLockRoleInfo(paramLong, 1))) {
/* 633 */       return -4;
/*     */     }
/* 635 */     int i = RoleManager.renameChecker(paramString);
/* 636 */     if (i == 0) {
/* 637 */       new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         private final long val$roleId;
/*     */         private final String val$newName;
/*     */         
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  27 */           xbean.Basic var1 = xtable.Basic.get(Long.valueOf(this.val$roleId));
/*  28 */           String var2 = var1.getName();
/*  29 */           lock(Name2roleid.getTable(), java.util.Arrays.asList(new String[] { this.val$newName, var2 }));
/*  30 */           var1.setName(this.val$newName);
/*  31 */           Name2roleid.remove(var2);
/*  32 */           Name2roleid.insert(this.val$newName, Long.valueOf(this.val$roleId));
/*  33 */           mzm.event.TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.role.event.RoleRename(), Long.valueOf(this.val$roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.val$roleId)));
/*  34 */           RoleOutFightObj var3 = RoleInterface.getRoleOutFightObject(this.val$roleId);
/*  35 */           var3.syncClientRoleProperty();
/*  36 */           xdb.util.UniqName.release("role", var2);
/*  37 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
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
/* 654 */     return i;
/*     */   }
/*     */   
/*     */   public static List<Integer> getAllOccupationIds() {
/* 658 */     ArrayList localArrayList = new ArrayList();
/* 659 */     for (SOccupationPropTable localSOccupationPropTable : SOccupationPropTable.getAll().values()) {
/* 660 */       if (!localArrayList.contains(Integer.valueOf(localSOccupationPropTable.occupationId)))
/*     */       {
/*     */ 
/* 663 */         localArrayList.add(Integer.valueOf(localSOccupationPropTable.occupationId)); }
/*     */     }
/* 665 */     return localArrayList;
/*     */   }
/*     */   
/*     */   public static Set<Integer> getAvlidOccupationIds() {
/* 669 */     HashSet localHashSet = new HashSet();
/* 670 */     for (SOccupationPropTable localSOccupationPropTable : SOccupationPropTable.getAll().values()) {
/* 671 */       if (!localHashSet.contains(Integer.valueOf(localSOccupationPropTable.occupationId))) {
/* 672 */         if (mzm.gsp.open.main.OpenInterface.getOpenStatus(localSOccupationPropTable.switchId))
/*     */         {
/*     */ 
/* 675 */           localHashSet.add(Integer.valueOf(localSOccupationPropTable.occupationId)); }
/*     */       }
/*     */     }
/* 678 */     return localHashSet;
/*     */   }
/*     */   
/*     */   public static int getRoleCfgMaxLevel() {
/* 682 */     return RoleCommonConstants.getInstance().MAX_LEVEL;
/*     */   }
/*     */   
/*     */   public static String getOccupationName(int paramInt) {
/* 686 */     Occupation localOccupation = OccupationManager.getOccupationById(paramInt, 1);
/* 687 */     if (localOccupation == null) {
/* 688 */       return null;
/*     */     }
/* 690 */     return localOccupation.getName();
/*     */   }
/*     */   
/*     */   public static Occupation getOccupation(int paramInt1, int paramInt2) {
/* 694 */     return OccupationManager.getOccupationById(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static int getCoastBaoShiDu() {
/* 698 */     return RoleCommonConstants.getInstance().BAOSHIDU_COST;
/*     */   }
/*     */   
/*     */   public static boolean setHpAndMpFull(long paramLong) {
/* 702 */     RoleOutFightObj localRoleOutFightObj = new RoleOutFightObj(paramLong);
/* 703 */     localRoleOutFightObj.setHpAndMpFull();
/* 704 */     return true;
/*     */   }
/*     */   
/*     */   public static int getFlySpeed(long paramLong, boolean paramBoolean) {
/* 708 */     int i = 0;
/* 709 */     int j = mzm.gsp.aircraft.main.AircraftInterface.getEquipedFeiJianCfgId(paramLong, paramBoolean);
/* 710 */     if (j >= 0) {
/* 711 */       mzm.gsp.feijian.confbean.SFeiJianCfg localSFeiJianCfg = mzm.gsp.item.main.ItemInterface.getFeiJianCfg(j);
/* 712 */       if (localSFeiJianCfg != null) {
/* 713 */         i = localSFeiJianCfg.velocity;
/*     */       }
/*     */       else {
/* 716 */         GameServer.logger().info(String.format("[Role]RoleInterface.getFlySpeed@donot have feijian config|roleid=%d|configid=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j) }));
/*     */       }
/*     */     }
/* 719 */     return i;
/*     */   }
/*     */   
/*     */   public static long ranRoleFromFightRankList() {
/* 723 */     return NoneRealFightValueRankManager.getInstance().ranRoleFromRankList();
/*     */   }
/*     */   
/*     */   public static long ranRoleFromLevelRankList() {
/* 727 */     return NoneRealTimeRoleLevelRankManager.getInstance().ranRoleFromRankList();
/*     */   }
/*     */   
/*     */   public static void removeRoleForIDIP(long paramLong) {
/* 731 */     DeleteState localDeleteState = Role2delete.get(Long.valueOf(paramLong));
/* 732 */     if (localDeleteState == null) {
/* 733 */       localDeleteState = Pod.newDeleteState();
/* 734 */       Role2delete.add(Long.valueOf(paramLong), localDeleteState);
/*     */     }
/* 736 */     localDeleteState.setDeletestate(2);
/* 737 */     mzm.gsp.online.main.RoleDeleteLogManager.tlogRoleDel(paramLong, 2);
/*     */   }
/*     */   
/*     */   public static int getRoleMFValue(long paramLong) {
/* 741 */     return mzm.gsp.role.multirank.MultiRankManager.getRoleMFValue(paramLong);
/*     */   }
/*     */   
/*     */   public static long getRoleCreateTime(long paramLong) {
/* 745 */     return xtable.Basic.selectCreatetime(Long.valueOf(paramLong)).longValue();
/*     */   }
/*     */   
/*     */   public static DefaultColorInfo getRoleColorInfo(long paramLong, boolean paramBoolean) {
/* 749 */     Role localRole = getRole(paramLong, paramBoolean);
/* 750 */     Occupation localOccupation = OccupationManager.getOccupationById(localRole.getOccupationId(), localRole.getGender());
/* 751 */     if (localOccupation == null) {
/* 752 */       return null;
/*     */     }
/* 754 */     return new DefaultColorInfo(localOccupation.getHairColorId(), localOccupation.getClothColorId());
/*     */   }
/*     */   
/*     */   public static DefaultColorInfo getRoleColorInfo(int paramInt1, int paramInt2) {
/* 758 */     Occupation localOccupation = OccupationManager.getOccupationById(paramInt1, paramInt2);
/* 759 */     if (localOccupation == null) {
/* 760 */       return null;
/*     */     }
/* 762 */     return new DefaultColorInfo(localOccupation.getHairColorId(), localOccupation.getClothColorId());
/*     */   }
/*     */   
/*     */   public static boolean activeNewOccupation(long paramLong, int paramInt1, int paramInt2) {
/* 766 */     if (paramInt1 == paramInt2) {
/* 767 */       GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@new occupation equals current occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 768 */       return false;
/*     */     }
/* 770 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong));
/* 771 */     if (localProperties == null) {
/* 772 */       GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@role properties info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 773 */       return false;
/*     */     }
/* 775 */     Map localMap1 = localProperties.getTransfer_occupation_property_sys_map();
/* 776 */     if (localMap1.containsKey(Integer.valueOf(paramInt1))) {
/* 777 */       GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@aleardy active new occupation |role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 778 */       return false;
/*     */     }
/* 780 */     java.util.HashMap localHashMap = new java.util.HashMap();
/* 781 */     Map localMap2 = localProperties.getPropertysysmap();
/* 782 */     for (Object localObject1 = localMap2.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/* 783 */       localObject3 = (BasicPropertiesSystem)((Map.Entry)localObject2).getValue();
/* 784 */       localObject4 = ((BasicPropertiesSystem)localObject3).getBasicpropertymap();
/* 785 */       int i = ((BasicPropertiesSystem)localObject3).getPotentialpoint();
/* 786 */       for (Object localObject5 = ((Map)localObject4).values().iterator(); ((Iterator)localObject5).hasNext();) { j = ((Integer)((Iterator)localObject5).next()).intValue();
/* 787 */         i += j;
/*     */       }
/* 789 */       localObject5 = Pod.newBasicPropertiesSystem();
/* 790 */       ((BasicPropertiesSystem)localObject5).setPotentialpoint(i);
/* 791 */       int j = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
/* 792 */       localHashMap.put(Integer.valueOf(j), localObject5); }
/*     */     Object localObject4;
/* 794 */     localObject1 = Pod.newTransferOccupationPropertiesSys();
/* 795 */     Object localObject2 = ((TransferOccupationPropertiesSys)localObject1).getProperty_sys_map();
/* 796 */     for (Object localObject3 = localMap2.entrySet().iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (Map.Entry)((Iterator)localObject3).next();
/* 797 */       ((Map)localObject2).put(((Map.Entry)localObject4).getKey(), ((BasicPropertiesSystem)((Map.Entry)localObject4).getValue()).copy());
/*     */     }
/* 799 */     ((TransferOccupationPropertiesSys)localObject1).setActivity_bp_sys(localProperties.getActivitybpsys());
/* 800 */     ((TransferOccupationPropertiesSys)localObject1).setToday_prop_sys_switch_count(localProperties.getTodaypropsysswitchcount());
/* 801 */     localMap1.put(Integer.valueOf(paramInt2), localObject1);
/* 802 */     localMap2.clear();
/* 803 */     for (localObject3 = localHashMap.entrySet().iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (Map.Entry)((Iterator)localObject3).next();
/* 804 */       localMap2.put(((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue());
/*     */     }
/* 806 */     localProperties.setActivitybpsys(0);
/* 807 */     localProperties.setTodaypropsysswitchcount(0);
/* 808 */     GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@active new occupation success|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 809 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean switchOccupation(long paramLong, int paramInt1, int paramInt2) {
/* 813 */     if (paramInt1 == paramInt2) {
/* 814 */       GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@new occupation equals old occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 815 */       return false;
/*     */     }
/* 817 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong));
/* 818 */     if (localProperties == null) {
/* 819 */       GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@role properties info is null|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 820 */       return false;
/*     */     }
/* 822 */     Map localMap1 = localProperties.getTransfer_occupation_property_sys_map();
/* 823 */     TransferOccupationPropertiesSys localTransferOccupationPropertiesSys1 = (TransferOccupationPropertiesSys)localMap1.remove(Integer.valueOf(paramInt1));
/* 824 */     if (localTransferOccupationPropertiesSys1 == null) {
/* 825 */       GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@no new occupation data|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 826 */       return false;
/*     */     }
/* 828 */     Map localMap2 = localProperties.getPropertysysmap();
/* 829 */     TransferOccupationPropertiesSys localTransferOccupationPropertiesSys2 = Pod.newTransferOccupationPropertiesSys();
/* 830 */     Map localMap3 = localTransferOccupationPropertiesSys2.getProperty_sys_map();
/* 831 */     for (Iterator localIterator = localMap2.entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 832 */       localMap3.put(localEntry.getKey(), ((BasicPropertiesSystem)localEntry.getValue()).copy()); }
/*     */     Map.Entry localEntry;
/* 834 */     localTransferOccupationPropertiesSys2.setActivity_bp_sys(localProperties.getActivitybpsys());
/* 835 */     localTransferOccupationPropertiesSys2.setToday_prop_sys_switch_count(localProperties.getTodaypropsysswitchcount());
/* 836 */     localMap1.put(Integer.valueOf(paramInt2), localTransferOccupationPropertiesSys2);
/* 837 */     localProperties.getPropertysysmap().clear();
/* 838 */     for (localIterator = localTransferOccupationPropertiesSys1.getProperty_sys_map().entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 839 */       localMap2.put(localEntry.getKey(), ((BasicPropertiesSystem)localEntry.getValue()).copy());
/*     */     }
/* 841 */     localProperties.setActivitybpsys(localTransferOccupationPropertiesSys1.getActivity_bp_sys());
/* 842 */     localProperties.setTodaypropsysswitchcount(localTransferOccupationPropertiesSys1.getToday_prop_sys_switch_count());
/* 843 */     GameServer.logger().info(String.format("[role]RoleInterface.activeNewOccupation@switch new occupation success|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/* 844 */     return true;
/*     */   }
/*     */   
/*     */   public static CoinInfo getCoinInfo(long paramLong, int paramInt, boolean paramBoolean) {
/* 848 */     if (paramBoolean) {
/* 849 */       localProperties = Role2properties.get(Long.valueOf(paramLong));
/* 850 */       if (localProperties == null) {
/* 851 */         return null;
/*     */       }
/* 853 */       return (CoinInfo)localProperties.getCoins().get(Integer.valueOf(paramInt));
/*     */     }
/*     */     
/* 856 */     Properties localProperties = Role2properties.select(Long.valueOf(paramLong));
/* 857 */     if (localProperties == null) {
/* 858 */       return null;
/*     */     }
/* 860 */     return (CoinInfo)localProperties.getCoins().get(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public static boolean removeRoleOutFightObj(long paramLong)
/*     */   {
/* 865 */     return xtable.Role2outfightbean.remove(Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   public static boolean isReachMaxLevel(long paramLong, boolean paramBoolean) {
/* 869 */     return RoleModuleManager.isReachMaxLevel(paramLong, paramBoolean);
/*     */   }
/*     */   
/*     */   public static double getReachMaxLevelExpModRet(int paramInt) {
/* 873 */     return RoleModuleManager.getReachMaxLevelExpModRet(paramInt);
/*     */   }
/*     */   
/*     */   public static Set<Integer> getXTypeOccupationIds(int paramInt) {
/* 877 */     return OccupationManager.getInstance().getXTypeOccupationIds(paramInt);
/*     */   }
/*     */   
/*     */   public static int getOccupationType(int paramInt1, int paramInt2) {
/* 881 */     return OccupationManager.getInstance().getOccupationType(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static int getOccupationDefaultAvatarId(int paramInt1, int paramInt2) {
/* 885 */     return OccupationManager.getInstance().getOccupationDefaultAvatarId(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static boolean isOccupationOpen(int paramInt) {
/* 889 */     return OccupationManager.getInstance().isOccupationSwitchOpen(paramInt);
/*     */   }
/*     */   
/*     */   public static boolean isOccupationOpen(int paramInt1, int paramInt2) {
/* 893 */     return OccupationManager.getInstance().isOccupationSwitchOpen(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public static long getTotalCostMoneyThisDay(long paramLong, CurrencyType paramCurrencyType) {
/* 897 */     return RoleModuleManager.getTotalCostMoneyThisDay(paramLong, paramCurrencyType);
/*     */   }
/*     */   
/*     */   public static long getOnlineSecondThisDay(long paramLong, boolean paramBoolean) {
/* 901 */     return RoleModuleManager.getOnlineSecondThisDay(paramLong, paramBoolean);
/*     */   }
/*     */   
/*     */   public static long getOnlineSecondTotal(long paramLong, boolean paramBoolean) {
/* 905 */     return RoleModuleManager.getOnlineSecondTotal(paramLong, paramBoolean);
/*     */   }
/*     */   
/*     */   public static int getRoleOccupatinMFVRank(long paramLong) {
/* 909 */     return mzm.gsp.role.multirank.AbsNRealOMFVRankManager.getOccRank(paramLong);
/*     */   }
/*     */   
/*     */   public static List<Long> getTopNRoleIds(int paramInt1, int paramInt2, int paramInt3) {
/* 913 */     return mzm.gsp.role.multirank.AbsNRealOMFVRankManager.getTopNRoleIds(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public static long getOnlineSeconds(long paramLong, boolean paramBoolean) {
/* 917 */     Properties localProperties = null;
/* 918 */     if (paramBoolean) {
/* 919 */       localProperties = Role2properties.get(Long.valueOf(paramLong));
/*     */     }
/*     */     else {
/* 922 */       localProperties = Role2properties.select(Long.valueOf(paramLong));
/*     */     }
/* 924 */     if (localProperties == null) {
/* 925 */       return 0L;
/*     */     }
/* 927 */     return localProperties.getOnlineseconds();
/*     */   }
/*     */   
/*     */   public static class DefaultColorInfo
/*     */   {
/*     */     private final int hairColorId;
/*     */     private final int clothColorId;
/*     */     
/*     */     public DefaultColorInfo(int paramInt1, int paramInt2) {
/* 936 */       this.hairColorId = paramInt1;
/* 937 */       this.clothColorId = paramInt2;
/*     */     }
/*     */     
/*     */     public int getHairColorId() {
/* 941 */       return this.hairColorId;
/*     */     }
/*     */     
/*     */     public int getClothColorId() {
/* 945 */       return this.clothColorId;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */