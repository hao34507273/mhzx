/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.SCreateRole;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.occupation.confbean.SRoleSpecialSkillScore;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BasicPropertiesSystem;
/*     */ import xbean.Location;
/*     */ import xbean.Pod;
/*     */ import xbean.Properties;
/*     */ import xbean.TransferOccupationPropertiesSys;
/*     */ import xdb.TTable;
/*     */ import xdb.util.UniqName;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class RoleManager
/*     */ {
/*  32 */   static final Logger logger = Logger.getLogger("Role");
/*     */   
/*     */   public static final int WRONG_NAME = 4;
/*     */   
/*     */   public static final int SENSITIVENAME = 3;
/*     */   public static final int DUPLICATENAME = 2;
/*     */   public static final int ALLOCATEROLEIDFAILED = 7;
/*  39 */   public static int NAME_LENGTH = 10;
/*  40 */   private static Map<Integer, Integer> roleSkill2scoreMap = new java.util.HashMap();
/*     */   
/*  42 */   private static RoleManager instance = new RoleManager();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RoleManager getInstance()
/*     */   {
/*  50 */     return instance;
/*     */   }
/*     */   
/*     */   public static void init(Map<String, String> envs)
/*     */   {
/*  55 */     NAME_LENGTH = Integer.parseInt((String)envs.get("nameLength"));
/*  56 */     for (SRoleSpecialSkillScore skillScore : SRoleSpecialSkillScore.getAll().values())
/*     */     {
/*  58 */       roleSkill2scoreMap.put(Integer.valueOf(skillScore.skillId), Integer.valueOf(skillScore.score));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void registerXdbListener()
/*     */   {
/*  67 */     Role2properties.getTable().addListener(new RoleExpListener(), new String[] { "value", "exp" });
/*  68 */     Role2properties.getTable().addListener(new RoleGoldListener(), new String[] { "value", "gold" });
/*  69 */     Role2properties.getTable().addListener(new RoleGoldIngotListener(), new String[] { "value", "goldingot" });
/*  70 */     Role2properties.getTable().addListener(new RoleSilverListener(), new String[] { "value", "silver" });
/*  71 */     Role2properties.getTable().addListener(new RoleVigorListener(), new String[] { "value", "vigor" });
/*  72 */     Role2properties.getTable().addListener(new RoleBaoShiDuListener(), new String[] { "value", "baoshidu" });
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
/*     */   public long createRole(String userId, String name, int occupationId, int gender, SCreateRole res)
/*     */   {
/*  87 */     name = name.trim();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */     if ((name.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(name) / 2.0D) > NAME_LENGTH) || (name.matches("\\d+")) || (!AvailableStringArgs.getInstance().isStringUsable(name)))
/*     */     {
/*     */ 
/*  96 */       res.result = 4;
/*  97 */       return -1L;
/*     */     }
/*     */     
/* 100 */     if (SensitiveInterface.isNameSensitive(name))
/*     */     {
/* 102 */       res.result = 3;
/* 103 */       return -1L;
/*     */     }
/*     */     
/* 106 */     if (!UniqName.allocate("role", name))
/*     */     {
/* 108 */       res.result = 2;
/* 109 */       return -1L;
/*     */     }
/*     */     
/* 112 */     Properties xProperties = Pod.newProperties();
/* 113 */     Occupation ocp = OccupationManager.getOccupationById(occupationId, gender);
/* 114 */     if (ocp == null)
/*     */     {
/* 116 */       res.result = 14;
/* 117 */       return -1L;
/*     */     }
/* 119 */     if (!ocp.isRoleOpen())
/*     */     {
/* 121 */       res.result = 14;
/* 122 */       return -1L;
/*     */     }
/* 124 */     xProperties.setExp(0);
/* 125 */     xProperties.setLevel(ocp.getBornLevel());
/*     */     
/* 127 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 128 */     xProperties.setKeeponlinetime(curTime);
/* 129 */     xProperties.setLastlogofftime(curTime);
/*     */     
/* 131 */     Location xLocation = xProperties.getLocation();
/* 132 */     xLocation.setSceneid(ocp.getBornMapId());
/* 133 */     xLocation.setX(ocp.getBornMapX());
/* 134 */     xLocation.setY(ocp.getBornMapY());
/* 135 */     int zoneid = CommonUtils.getZoneId(userId);
/* 136 */     if (!mzm.gsp.GameServerInfoManager.isValidZone(zoneid))
/*     */     {
/* 138 */       res.result = 7;
/* 139 */       return -1L;
/*     */     }
/* 141 */     Long roleId = Role2properties.insertWithLocalid(zoneid, xProperties);
/* 142 */     xProperties.setLeveluptime(curTime);
/* 143 */     xProperties.setLevelupcurtime(curTime);
/* 144 */     if (roleId == null)
/*     */     {
/* 146 */       res.result = 7;
/* 147 */       return -1L;
/*     */     }
/*     */     
/*     */ 
/* 151 */     BasicPropertiesSystem xBPSys = Pod.newBasicPropertiesSystem();
/* 152 */     xProperties.setActivitybpsys(0);
/* 153 */     xProperties.getPropertysysmap().put(Integer.valueOf(0), xBPSys);
/* 154 */     Map<Integer, Integer> autoSpecialPointMap = ocp.getDefaultPointCase();
/* 155 */     for (Iterator i$ = autoSpecialPointMap.keySet().iterator(); i$.hasNext();) { int propType = ((Integer)i$.next()).intValue();
/*     */       
/* 157 */       xBPSys.getAutoassignpointpref().put(Integer.valueOf(propType), autoSpecialPointMap.get(Integer.valueOf(propType)));
/*     */     }
/*     */     
/* 160 */     int[] basicProperType = { 25, 29, 27, 28, 26 };
/*     */     
/* 162 */     for (int propType : basicProperType)
/*     */     {
/* 164 */       xBPSys.getBasicpropertymap().put(Integer.valueOf(propType), Integer.valueOf(0));
/*     */     }
/* 166 */     xBPSys.setIsautospecialpoint(true);
/* 167 */     xbean.Basic xBasic = Pod.newBasic();
/* 168 */     xBasic.setUser_id(userId);
/* 169 */     xBasic.setName(name);
/* 170 */     xBasic.setGender(gender);
/* 171 */     xBasic.setCreatetime(DateTimeUtils.getCurrTimeInMillis());
/* 172 */     xBasic.setOccupationid(occupationId);
/*     */     
/* 174 */     mzm.gsp.roledye.main.RoleDyeInterface.initRoleDefaultClothes(roleId.longValue(), ocp.getHairColorId(), ocp.getClothColorId(), -1);
/*     */     
/*     */ 
/*     */ 
/* 178 */     xtable.Basic.insert(roleId, xBasic);
/*     */     
/* 180 */     xtable.Name2roleid.insert(xBasic.getName(), roleId);
/*     */     
/* 182 */     List<Integer> equipList = ocp.getBornEquipList();
/* 183 */     ItemInterface.createRoleBags(roleId.longValue());
/* 184 */     for (Integer equipId : equipList)
/*     */     {
/* 186 */       if (!ItemInterface.addEquipment(roleId.longValue(), equipId.intValue(), new TLogArg(mzm.gsp.tlog.LogReason.ROLE_ADD_BORN_EQUIPMENT_ADD, equipId.intValue())))
/*     */       {
/* 188 */         logger.error(String.format("create role equip error ocpId = %d, equipId = %d", new Object[] { Integer.valueOf(occupationId), equipId }));
/*     */       }
/*     */     }
/* 191 */     if (roleId.longValue() >= 0L)
/*     */     {
/* 193 */       RoleOutFightObj role = RoleInterface.getRoleOutFightObject(roleId.longValue());
/*     */       
/* 195 */       xProperties.setHp(role.getFinalMaxHP());
/* 196 */       xProperties.setMp(role.getFinalMaxMP());
/* 197 */       xProperties.setBaoshidu(RoleCommonConstants.getInstance().BAOSHIDU_LIMIT);
/*     */     }
/* 199 */     return roleId.longValue();
/*     */   }
/*     */   
/*     */   public static int getScoreForSkill(int skillId)
/*     */   {
/* 204 */     Integer score = (Integer)roleSkill2scoreMap.get(Integer.valueOf(skillId));
/* 205 */     if (score != null)
/*     */     {
/* 207 */       return score.intValue();
/*     */     }
/* 209 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int renameChecker(String newName)
/*     */   {
/* 219 */     if ((!AvailableStringArgs.getInstance().isStringUsable(newName)) || (newName.matches("\\d+")) || (Math.ceil(CommonUtils.getUTF16Length(newName) / 2.0D) > NAME_LENGTH))
/*     */     {
/*     */ 
/* 222 */       return 4;
/*     */     }
/* 224 */     if (SensitiveInterface.isNameSensitive(newName))
/*     */     {
/* 226 */       return 3;
/*     */     }
/* 228 */     if (!UniqName.allocate("role", newName))
/*     */     {
/* 230 */       return 2;
/*     */     }
/* 232 */     return 0;
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
/*     */   public static MoneyOperResult addGoldByIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 248 */     if (addValue <= 0L)
/*     */     {
/* 250 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 252 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 253 */     long gold = xProperties.getGold();
/* 254 */     if (Long.MAX_VALUE - gold < addValue)
/*     */     {
/* 256 */       return MoneyOperResult.MONEY_NUM_ADD_MAX;
/*     */     }
/* 258 */     RoleModuleManager.setGold(roleId, xProperties, gold + addValue);
/* 259 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, addValue, xProperties.getGold(), arg);
/* 260 */     return MoneyOperResult.SUCCESS;
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
/*     */   public static MoneyOperResult addGoldByAqIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 279 */     if (addValue <= 0L)
/*     */     {
/* 281 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 283 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 284 */     long gold = xProperties.getGold();
/* 285 */     if (Long.MAX_VALUE - gold < addValue)
/*     */     {
/* 287 */       RoleModuleManager.setGold(roleId, xProperties, Long.MAX_VALUE);
/* 288 */       RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, Long.MAX_VALUE - gold, xProperties.getGold(), arg);
/* 289 */       return MoneyOperResult.MONEY_NUM_REACH_MAX_FOR_AQIDIP;
/*     */     }
/*     */     
/*     */ 
/* 293 */     RoleModuleManager.setGold(roleId, xProperties, gold + addValue);
/* 294 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, addValue, xProperties.getGold(), arg);
/* 295 */     return MoneyOperResult.SUCCESS;
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
/*     */   @Deprecated
/*     */   private static MoneyOperResult cutGoldByIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 312 */     if (cutValue <= 0L)
/*     */     {
/* 314 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 316 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 317 */     long remainGold = xProperties.getGold() - cutValue;
/* 318 */     if (remainGold < 0L)
/*     */     {
/* 320 */       return MoneyOperResult.MONEY_NUM_RM_NOT_ENOUGH;
/*     */     }
/* 322 */     RoleModuleManager.setGold(roleId, xProperties, remainGold, true);
/*     */     
/* 324 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, -cutValue, remainGold, arg);
/* 325 */     return MoneyOperResult.SUCCESS;
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
/*     */   @Deprecated
/*     */   private static MoneyOperResult cutGoldByAqIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 342 */     if (cutValue <= 0L)
/*     */     {
/* 344 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 346 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 347 */     long beginValue = xProperties.getGold();
/* 348 */     long remainGold = beginValue - cutValue;
/* 349 */     if (remainGold < 0L)
/*     */     {
/* 351 */       RoleModuleManager.setGold(roleId, xProperties, 0L);
/* 352 */       RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, -beginValue, 0L, arg);
/* 353 */       return MoneyOperResult.MONEY_NUM_CLEAR_FOR_AQIDIP;
/*     */     }
/*     */     
/*     */ 
/* 357 */     RoleModuleManager.setGold(roleId, xProperties, remainGold, true);
/* 358 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, -cutValue, remainGold, arg);
/* 359 */     return MoneyOperResult.SUCCESS;
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
/*     */   @Deprecated
/*     */   public static MoneyOperResult addSilverByIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 377 */     if (addValue <= 0L)
/*     */     {
/* 379 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 381 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 382 */     long silver = xProperties.getSilver();
/* 383 */     if (Long.MAX_VALUE - silver < addValue)
/*     */     {
/* 385 */       return MoneyOperResult.MONEY_NUM_ADD_MAX;
/*     */     }
/* 387 */     xProperties.setSilver(silver + addValue);
/*     */     
/* 389 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, addValue, xProperties.getSilver(), arg);
/* 390 */     return MoneyOperResult.SUCCESS;
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
/*     */   @Deprecated
/*     */   public static MoneyOperResult addSilverByAqIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 410 */     if (addValue <= 0L)
/*     */     {
/* 412 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 414 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 415 */     long silver = xProperties.getSilver();
/* 416 */     if (Long.MAX_VALUE - silver < addValue)
/*     */     {
/* 418 */       xProperties.setSilver(Long.MAX_VALUE);
/* 419 */       RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, Long.MAX_VALUE - silver, xProperties.getSilver(), arg);
/*     */       
/* 421 */       return MoneyOperResult.MONEY_NUM_REACH_MAX_FOR_AQIDIP;
/*     */     }
/*     */     
/*     */ 
/* 425 */     xProperties.setSilver(silver + addValue);
/* 426 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, addValue, xProperties.getSilver(), arg);
/* 427 */     return MoneyOperResult.SUCCESS;
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
/*     */   public static MoneyOperResult cutSilverByIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 443 */     if (cutValue <= 0L)
/*     */     {
/* 445 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 447 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 448 */     long remainSilver = xProperties.getSilver() - cutValue;
/* 449 */     if (remainSilver < 0L)
/*     */     {
/* 451 */       return MoneyOperResult.MONEY_NUM_RM_NOT_ENOUGH;
/*     */     }
/* 453 */     xProperties.setSilver(remainSilver);
/*     */     
/* 455 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, -cutValue, remainSilver, arg);
/*     */     
/* 457 */     return MoneyOperResult.SUCCESS;
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
/*     */   public static MoneyOperResult cutSilverByAqIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 472 */     if (cutValue <= 0L)
/*     */     {
/* 474 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 476 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 477 */     long beginValue = xProperties.getSilver();
/* 478 */     long remainSilver = beginValue - cutValue;
/* 479 */     if (remainSilver < 0L)
/*     */     {
/* 481 */       xProperties.setSilver(0L);
/* 482 */       RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, -beginValue, 0L, arg);
/* 483 */       return MoneyOperResult.MONEY_NUM_CLEAR_FOR_AQIDIP;
/*     */     }
/*     */     
/*     */ 
/* 487 */     xProperties.setSilver(remainSilver);
/* 488 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, -cutValue, remainSilver, arg);
/* 489 */     return MoneyOperResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long ranOneFromRankList(List<Long> roleIds)
/*     */   {
/* 501 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 503 */       return -1L;
/*     */     }
/* 505 */     Random random = xdb.Xdb.random();
/* 506 */     int ran = random.nextInt(roleIds.size());
/* 507 */     return ((Long)roleIds.get(ran)).longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getPropSet()
/*     */   {
/* 517 */     HashSet<Integer> props = new HashSet();
/* 518 */     props.add(Integer.valueOf(25));
/* 519 */     props.add(Integer.valueOf(27));
/* 520 */     props.add(Integer.valueOf(28));
/* 521 */     props.add(Integer.valueOf(26));
/* 522 */     props.add(Integer.valueOf(29));
/* 523 */     return props;
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
/*     */   static void updateTransferOccupationPropertiesSys(Properties xProperties, int nowLevel)
/*     */   {
/* 536 */     Map<Integer, TransferOccupationPropertiesSys> transferOccupationPropertiesSysMap = xProperties.getTransfer_occupation_property_sys_map();
/* 537 */     for (java.util.Map.Entry<Integer, TransferOccupationPropertiesSys> entry : transferOccupationPropertiesSysMap.entrySet())
/*     */     {
/*     */ 
/* 540 */       Map<Integer, BasicPropertiesSystem> xBasicPropertiesMap = ((TransferOccupationPropertiesSys)entry.getValue()).getProperty_sys_map();
/* 541 */       if ((nowLevel >= OccupationManager.getInstance().getSecondSysOpenLevel()) && (!xBasicPropertiesMap.containsKey(Integer.valueOf(1))))
/*     */       {
/*     */ 
/* 544 */         BasicPropertiesSystem xBPS1 = (BasicPropertiesSystem)xBasicPropertiesMap.get(Integer.valueOf(0));
/* 545 */         BasicPropertiesSystem xBPS2 = Pod.newBasicPropertiesSystem();
/* 546 */         Map<Integer, Integer> propMap = xBPS1.getBasicpropertymap();
/* 547 */         int totalPoint = xBPS1.getPotentialpoint();
/* 548 */         for (Iterator i$ = propMap.values().iterator(); i$.hasNext();) { int propValue = ((Integer)i$.next()).intValue();
/*     */           
/* 550 */           totalPoint += propValue;
/*     */         }
/* 552 */         xBPS2.setPotentialpoint(totalPoint);
/* 553 */         xBasicPropertiesMap.put(Integer.valueOf(1), xBPS2);
/*     */       }
/*     */       
/* 556 */       if ((nowLevel >= OccupationManager.getInstance().getThirdSysOpenLevel()) && (!xBasicPropertiesMap.containsKey(Integer.valueOf(2))))
/*     */       {
/*     */ 
/* 559 */         BasicPropertiesSystem xBPS1 = (BasicPropertiesSystem)xBasicPropertiesMap.get(Integer.valueOf(0));
/* 560 */         BasicPropertiesSystem xBPS3 = Pod.newBasicPropertiesSystem();
/* 561 */         Map<Integer, Integer> propMap = xBPS1.getBasicpropertymap();
/* 562 */         int totalPoint = xBPS1.getPotentialpoint();
/* 563 */         for (Iterator i$ = propMap.values().iterator(); i$.hasNext();) { int propValue = ((Integer)i$.next()).intValue();
/*     */           
/* 565 */           totalPoint += propValue;
/*     */         }
/* 567 */         xBPS3.setPotentialpoint(totalPoint);
/* 568 */         xBasicPropertiesMap.put(Integer.valueOf(2), xBPS3);
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
/*     */   static void updatePropertiesSysOnLogin(Properties xProperties, int nowLevel)
/*     */   {
/* 583 */     if ((nowLevel >= OccupationManager.getInstance().getSecondSysOpenLevel()) && (!xProperties.getPropertysysmap().containsKey(Integer.valueOf(1))))
/*     */     {
/*     */ 
/* 586 */       BasicPropertiesSystem xBPS1 = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(0));
/* 587 */       BasicPropertiesSystem xBPS2 = Pod.newBasicPropertiesSystem();
/* 588 */       Map<Integer, Integer> propMap = xBPS1.getBasicpropertymap();
/* 589 */       int totalPoint = xBPS1.getPotentialpoint();
/* 590 */       for (Iterator i$ = propMap.values().iterator(); i$.hasNext();) { int propValue = ((Integer)i$.next()).intValue();
/*     */         
/* 592 */         totalPoint += propValue;
/*     */       }
/* 594 */       xBPS2.setPotentialpoint(totalPoint);
/* 595 */       xProperties.getPropertysysmap().put(Integer.valueOf(1), xBPS2);
/*     */     }
/*     */     
/* 598 */     if ((nowLevel >= OccupationManager.getInstance().getThirdSysOpenLevel()) && (!xProperties.getPropertysysmap().containsKey(Integer.valueOf(2))))
/*     */     {
/*     */ 
/* 601 */       BasicPropertiesSystem xBPS1 = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(0));
/* 602 */       BasicPropertiesSystem xBPS3 = Pod.newBasicPropertiesSystem();
/* 603 */       Map<Integer, Integer> propMap = xBPS1.getBasicpropertymap();
/* 604 */       int totalPoint = xBPS1.getPotentialpoint();
/* 605 */       for (Iterator i$ = propMap.values().iterator(); i$.hasNext();) { int propValue = ((Integer)i$.next()).intValue();
/*     */         
/* 607 */         totalPoint += propValue;
/*     */       }
/* 609 */       xBPS3.setPotentialpoint(totalPoint);
/* 610 */       xProperties.getPropertysysmap().put(Integer.valueOf(2), xBPS3);
/*     */     }
/*     */     
/* 613 */     updateTransferOccupationPropertiesSys(xProperties, nowLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */