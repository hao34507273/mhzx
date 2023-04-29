/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.SSyncRoleModelChange;
/*     */ import mzm.gsp.map.SSyncRoleNameChange;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MMH_OnRoleAppearanceChanged
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*     */   public static final int REASON_APP = 0;
/*     */   public static final int REASON_TITLE = 1;
/*     */   public static final int REASON_WOLRD_APP = 2;
/*     */   public static final int REASON_WEAPON = 3;
/*     */   public static final int REASON_WING = 4;
/*     */   public static final int REASON_FABAO = 5;
/*     */   public static final int REASON_FEIJIAN = 6;
/*     */   public static final int REASON_RENAME = 7;
/*     */   public static final int REASON_MOUNTS = 9;
/*     */   public static final int REASON_MOUNTS_DYE = 10;
/*     */   public static final int REASON_AIRCRAFT = 11;
/*     */   public static final int REASON_QILING_EFFECT_LEVEL = 12;
/*     */   public static final int REASON_MOUNTS_RANK = 13;
/*     */   public static final int REASON_MAGIC_MARK_TYPE = 14;
/*     */   public static final int REASON_FABAO_LINGQI = 15;
/*     */   public static final int REASON_WUSHI = 16;
/*     */   public static final int REASON_MORAL_VALUE = 17;
/*     */   public static final int REASON_CHANGE_MODEL_CARD = 18;
/*     */   public static final int PROP_KEY_NAME = 1;
/*     */   public static final int PROP_KEY_TITLE_ID = 2;
/*     */   public static final int PROP_KEY_APPELLATION_ID = 3;
/*     */   public static final int PROP_KEY_APPELLATION = 4;
/*     */   public static final int PROP_KEY_FABAO = 5;
/*     */   public static final int PROP_KEY_QILING_LEVEL = 6;
/*     */   public static final int PROP_KEY_WEAPON = 7;
/*     */   public static final int PROP_KEY_WING = 8;
/*     */   public static final int PROP_KEY_WING_COLOR_ID = 9;
/*     */   public static final int PROP_KEY_MOUNTS_ID = 10;
/*     */   public static final int PROP_KEY_MOUNTS_COLOR_ID = 11;
/*     */   public static final int PROP_KEY_ROLE_VELOCITY = 12;
/*     */   public static final int PROP_KEY_AIRCRAFT = 13;
/*     */   public static final int PROP_KEY_QILING_EFFECT_LEVEL = 14;
/*     */   public static final int PROP_KEY_MOUNTS_RANK = 15;
/*     */   public static final int PROP_KEY_MAGIC_MARK_TYPE = 16;
/*     */   public static final int PROP_KEY_FABAO_LINGQI = 17;
/*     */   public static final int PROP_KEY_WUSHI = 18;
/*     */   public static final int PROP_KEY_MORAL_VALUE = 19;
/*     */   public static final int PROP_KEY_CHANGE_MODEL_CARD_CFGID = 20;
/*     */   public static final int PROP_KEY_CHANGE_MODEL_CARD_LEVEL = 21;
/*     */   public static final int PROP_KEY_CHANGE_MODEL_CARD_MINI = 22;
/*     */   public static final int PROP_KEY_AIRCRAFT_COLOR_ID = 23;
/*     */   private final long roleId;
/*     */   private final int reason;
/*     */   private final Map<Integer, Object> changeProps;
/*     */   
/*     */   public MMH_OnRoleAppearanceChanged(long roleId, int reason, Map<Integer, Object> changeProps)
/*     */   {
/* 229 */     this.roleId = roleId;
/* 230 */     this.reason = reason;
/* 231 */     this.changeProps = changeProps;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/* 237 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 238 */     if (role == null)
/*     */     {
/* 240 */       return;
/*     */     }
/*     */     
/* 243 */     if (this.reason == 7)
/*     */     {
/* 245 */       role.setName((String)this.changeProps.get(Integer.valueOf(1)));
/*     */       
/* 247 */       SSyncRoleNameChange roleNameChange = new SSyncRoleNameChange();
/* 248 */       roleNameChange.roleid = this.roleId;
/* 249 */       roleNameChange.name = role.getName();
/* 250 */       roleNameChange.nametype = 0;
/* 251 */       role.broadcastProtocolIncludeSelf(roleNameChange);
/*     */       
/* 253 */       return;
/*     */     }
/*     */     
/* 256 */     MapModelInfo mapModelInfo = role.getRoleModel();
/* 257 */     SSyncRoleModelChange core = new SSyncRoleModelChange();
/* 258 */     core.roleid = this.roleId;
/* 259 */     switch (this.reason)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 263 */       Integer titleId = (Integer)this.changeProps.get(Integer.valueOf(2));
/* 264 */       if (titleId == null)
/*     */       {
/* 266 */         Integer oldTitleId = (Integer)mapModelInfo.int_props.remove(Integer.valueOf(0));
/* 267 */         if (oldTitleId == null)
/*     */         {
/* 269 */           return;
/*     */         }
/*     */         
/* 272 */         core.intpropmap.put(Integer.valueOf(9), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 276 */         Integer oldTitleId = (Integer)mapModelInfo.int_props.put(Integer.valueOf(0), titleId);
/* 277 */         if ((oldTitleId != null) && (oldTitleId.intValue() == titleId.intValue()))
/*     */         {
/* 279 */           return;
/*     */         }
/*     */         
/* 282 */         core.intpropmap.put(Integer.valueOf(9), titleId);
/*     */       }
/*     */       
/* 285 */       break;
/*     */     
/*     */ 
/*     */     case 0: 
/* 289 */       if (mapModelInfo.int_props.get(Integer.valueOf(5)) != null)
/*     */       {
/* 291 */         return;
/*     */       }
/*     */       
/* 294 */       Integer appId = (Integer)this.changeProps.get(Integer.valueOf(3));
/* 295 */       if (appId == null)
/*     */       {
/* 297 */         mapModelInfo.string_props.remove(Integer.valueOf(1));
/*     */         
/* 299 */         Integer oldAppId = (Integer)mapModelInfo.int_props.remove(Integer.valueOf(1));
/* 300 */         if (oldAppId == null)
/*     */         {
/* 302 */           return;
/*     */         }
/*     */         
/* 305 */         core.intpropmap.put(Integer.valueOf(10), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 309 */         boolean changed = false;
/*     */         
/* 311 */         Integer oldAppId = (Integer)mapModelInfo.int_props.put(Integer.valueOf(1), appId);
/* 312 */         if ((oldAppId == null) || (oldAppId.intValue() != appId.intValue()))
/*     */         {
/* 314 */           changed = true;
/* 315 */           core.intpropmap.put(Integer.valueOf(10), appId);
/*     */         }
/*     */         
/* 318 */         String appName = (String)this.changeProps.get(Integer.valueOf(4));
/* 319 */         String oldAppName = (String)mapModelInfo.string_props.put(Integer.valueOf(1), appName);
/* 320 */         if ((oldAppName == null) || (!oldAppName.equals(appName)))
/*     */         {
/* 322 */           changed = true;
/* 323 */           core.stringpropmap.put(Integer.valueOf(1), appName);
/*     */         }
/*     */         
/* 326 */         if (!changed)
/*     */         {
/* 328 */           return;
/*     */         }
/*     */       }
/*     */       
/* 332 */       break;
/*     */     
/*     */ 
/*     */     case 5: 
/* 336 */       Integer fabaoId = (Integer)this.changeProps.get(Integer.valueOf(5));
/* 337 */       if (fabaoId == null)
/*     */       {
/* 339 */         Integer oldFaobaoId = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(4));
/* 340 */         if (oldFaobaoId == null)
/*     */         {
/* 342 */           return;
/*     */         }
/*     */         
/* 345 */         core.intpropmap.put(Integer.valueOf(8), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 349 */         Integer oldFaobaoId = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(4), fabaoId);
/* 350 */         if ((oldFaobaoId != null) && (oldFaobaoId.intValue() == fabaoId.intValue()))
/*     */         {
/* 352 */           return;
/*     */         }
/*     */         
/* 355 */         core.intpropmap.put(Integer.valueOf(8), fabaoId);
/*     */       }
/*     */       
/* 358 */       break;
/*     */     
/*     */ 
/*     */     case 15: 
/* 362 */       Integer fabaoLingqiId = (Integer)this.changeProps.get(Integer.valueOf(17));
/* 363 */       if (fabaoLingqiId == null)
/*     */       {
/* 365 */         Integer oldFabaoLingqiId = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(30));
/* 366 */         if (oldFabaoLingqiId == null)
/*     */         {
/* 368 */           return;
/*     */         }
/*     */         
/* 371 */         core.intpropmap.put(Integer.valueOf(36), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 375 */         Integer oldFabaoLingqiId = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(30), fabaoLingqiId);
/* 376 */         if ((oldFabaoLingqiId != null) && (oldFabaoLingqiId.intValue() == fabaoLingqiId.intValue()))
/*     */         {
/* 378 */           return;
/*     */         }
/*     */         
/* 381 */         core.intpropmap.put(Integer.valueOf(36), fabaoLingqiId);
/*     */       }
/*     */       
/* 384 */       break;
/*     */     
/*     */     case 6: 
/*     */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 391 */       boolean changed = false;
/*     */       
/* 393 */       Integer weaponId = (Integer)this.changeProps.get(Integer.valueOf(7));
/* 394 */       if (weaponId == null)
/*     */       {
/* 396 */         Integer oldWeaponId = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(1));
/* 397 */         if (oldWeaponId != null)
/*     */         {
/* 399 */           changed = true;
/* 400 */           core.intpropmap.put(Integer.valueOf(1), Integer.valueOf(0));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 405 */         Integer oldWeaponId = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(1), weaponId);
/* 406 */         if ((oldWeaponId == null) || (oldWeaponId.intValue() != weaponId.intValue()))
/*     */         {
/* 408 */           changed = true;
/* 409 */           core.intpropmap.put(Integer.valueOf(1), weaponId);
/*     */         }
/*     */         
/* 412 */         Integer qilingLv = (Integer)this.changeProps.get(Integer.valueOf(6));
/* 413 */         Integer oldQilingLv = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(5), qilingLv);
/* 414 */         if ((oldQilingLv == null) || (oldQilingLv.intValue() != qilingLv.intValue()))
/*     */         {
/* 416 */           changed = true;
/* 417 */           core.intpropmap.put(Integer.valueOf(11), qilingLv);
/*     */         }
/*     */       }
/*     */       
/* 421 */       if (updateQilingEffectLevel(mapModelInfo, core))
/*     */       {
/* 423 */         changed = true;
/*     */       }
/*     */       
/* 426 */       if (!changed)
/*     */       {
/* 428 */         return;
/*     */       }
/*     */       
/* 431 */       break;
/*     */     
/*     */ 
/*     */     case 4: 
/* 435 */       Integer wing = (Integer)this.changeProps.get(Integer.valueOf(8));
/* 436 */       if (wing == null)
/*     */       {
/* 438 */         mapModelInfo.model.extramap.remove(Integer.valueOf(3));
/*     */         
/* 440 */         Integer oldWing = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(2));
/* 441 */         if (oldWing == null)
/*     */         {
/* 443 */           return;
/*     */         }
/* 445 */         core.intpropmap.put(Integer.valueOf(3), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 449 */         boolean changed = false;
/*     */         
/* 451 */         Integer oldWing = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(2), wing);
/* 452 */         if ((oldWing == null) || (oldWing.intValue() != wing.intValue()))
/*     */         {
/* 454 */           changed = true;
/* 455 */           core.intpropmap.put(Integer.valueOf(3), wing);
/*     */         }
/*     */         
/* 458 */         Integer wingColorId = (Integer)this.changeProps.get(Integer.valueOf(9));
/* 459 */         Integer oldWingColorId = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(3), wingColorId);
/* 460 */         if ((oldWingColorId == null) || (oldWingColorId.intValue() != wingColorId.intValue()))
/*     */         {
/* 462 */           changed = true;
/* 463 */           core.intpropmap.put(Integer.valueOf(19), wingColorId);
/*     */         }
/*     */         
/* 466 */         if (!changed)
/*     */         {
/* 468 */           return;
/*     */         }
/*     */       }
/*     */       
/* 472 */       break;
/*     */     
/*     */ 
/*     */     case 9: 
/* 476 */       Integer velocity = (Integer)this.changeProps.get(Integer.valueOf(12));
/* 477 */       role.setMountsSpeed(velocity.intValue());
/*     */       
/* 479 */       boolean changed = false;
/* 480 */       Integer mountsid = (Integer)this.changeProps.get(Integer.valueOf(10));
/* 481 */       if (mountsid == null)
/*     */       {
/* 483 */         mapModelInfo.model.extramap.remove(Integer.valueOf(20));
/*     */         
/* 485 */         Integer oldMountsid = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(19));
/* 486 */         if (oldMountsid != null)
/*     */         {
/* 488 */           changed = true;
/* 489 */           core.intpropmap.put(Integer.valueOf(6), Integer.valueOf(0));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 494 */         Integer oldMountsid = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(19), mountsid);
/* 495 */         if ((oldMountsid == null) || (oldMountsid.intValue() != mountsid.intValue()))
/*     */         {
/* 497 */           changed = true;
/* 498 */           core.intpropmap.put(Integer.valueOf(6), mountsid);
/*     */         }
/*     */         
/* 501 */         Integer mountsRank = (Integer)this.changeProps.get(Integer.valueOf(15));
/* 502 */         Integer oldMountsRank = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(21), mountsRank);
/* 503 */         if ((oldMountsRank == null) || (oldMountsRank.intValue() != mountsRank.intValue()))
/*     */         {
/* 505 */           changed = true;
/* 506 */           core.intpropmap.put(Integer.valueOf(27), mountsRank);
/*     */         }
/*     */         
/* 509 */         Integer mountsColorId = (Integer)this.changeProps.get(Integer.valueOf(11));
/* 510 */         Integer oldMountsColorId = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(20), mountsColorId);
/*     */         
/* 512 */         if ((oldMountsColorId == null) || (oldMountsColorId.intValue() != mountsColorId.intValue()))
/*     */         {
/* 514 */           changed = true;
/* 515 */           core.intpropmap.put(Integer.valueOf(13), mountsColorId);
/*     */         }
/*     */       }
/*     */       
/* 519 */       if (!changed)
/*     */       {
/* 521 */         return;
/*     */       }
/*     */       
/* 524 */       break;
/*     */     
/*     */ 
/*     */     case 10: 
/* 528 */       Integer mountsColor = (Integer)this.changeProps.get(Integer.valueOf(11));
/* 529 */       Integer oldMountsColor = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(20), mountsColor);
/* 530 */       if ((oldMountsColor != null) && (oldMountsColor.intValue() == mountsColor.intValue()))
/*     */       {
/* 532 */         return;
/*     */       }
/* 534 */       core.intpropmap.put(Integer.valueOf(13), mountsColor);
/*     */       
/* 536 */       break;
/*     */     
/*     */ 
/*     */     case 13: 
/* 540 */       Integer mountsRank = (Integer)this.changeProps.get(Integer.valueOf(15));
/* 541 */       Integer oldMountsRank = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(21), mountsRank);
/* 542 */       if ((oldMountsRank != null) && (oldMountsRank.intValue() == mountsRank.intValue()))
/*     */       {
/* 544 */         return;
/*     */       }
/*     */       
/* 547 */       core.intpropmap.put(Integer.valueOf(27), mountsRank);
/*     */       
/* 549 */       break;
/*     */     
/*     */ 
/*     */     case 11: 
/* 553 */       boolean changed = false;
/* 554 */       Integer aircraftid = (Integer)this.changeProps.get(Integer.valueOf(13));
/* 555 */       if (aircraftid == null)
/*     */       {
/* 557 */         mapModelInfo.model.extramap.remove(Integer.valueOf(38));
/* 558 */         Integer oldAircraftid = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(10));
/* 559 */         if (oldAircraftid != null)
/*     */         {
/* 561 */           changed = true;
/* 562 */           core.intpropmap.put(Integer.valueOf(20), Integer.valueOf(0));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 567 */         Integer oldAircraftid = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(10), aircraftid);
/* 568 */         if ((oldAircraftid == null) || (oldAircraftid.intValue() != aircraftid.intValue()))
/*     */         {
/* 570 */           changed = true;
/* 571 */           core.intpropmap.put(Integer.valueOf(20), aircraftid);
/*     */         }
/*     */         
/* 574 */         Integer aircraftColorId = (Integer)this.changeProps.get(Integer.valueOf(23));
/* 575 */         Integer oldAircraftColorId = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(38), aircraftColorId);
/*     */         
/* 577 */         if ((oldAircraftColorId == null) || (oldAircraftColorId.intValue() != aircraftColorId.intValue()))
/*     */         {
/* 579 */           changed = true;
/* 580 */           core.intpropmap.put(Integer.valueOf(42), aircraftColorId);
/*     */         }
/*     */       }
/*     */       
/* 584 */       if (!changed)
/*     */       {
/* 586 */         return;
/*     */       }
/*     */       
/* 589 */       break;
/*     */     
/*     */ 
/*     */     case 12: 
/* 593 */       if (!updateQilingEffectLevel(mapModelInfo, core)) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       break;
/*     */     case 14: 
/* 602 */       Integer magicMarkType = (Integer)this.changeProps.get(Integer.valueOf(16));
/* 603 */       if (magicMarkType == null)
/*     */       {
/* 605 */         Integer oldMagicMarkType = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(24));
/* 606 */         if (oldMagicMarkType == null)
/*     */         {
/* 608 */           return;
/*     */         }
/* 610 */         core.intpropmap.put(Integer.valueOf(30), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 614 */         Integer oldMagicMarkType = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(24), magicMarkType);
/* 615 */         if ((oldMagicMarkType != null) && (oldMagicMarkType.intValue() == magicMarkType.intValue()))
/*     */         {
/* 617 */           return;
/*     */         }
/* 619 */         core.intpropmap.put(Integer.valueOf(30), magicMarkType);
/*     */       }
/*     */       
/* 622 */       break;
/*     */     
/*     */ 
/*     */     case 16: 
/* 626 */       Integer wushiid = (Integer)this.changeProps.get(Integer.valueOf(18));
/* 627 */       if (wushiid == null)
/*     */       {
/* 629 */         Integer oldWushiid = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(31));
/* 630 */         if (oldWushiid == null)
/*     */         {
/* 632 */           return;
/*     */         }
/* 634 */         core.intpropmap.put(Integer.valueOf(37), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 638 */         Integer oldWushiid = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(31), wushiid);
/* 639 */         if ((oldWushiid != null) && (oldWushiid.intValue() == wushiid.intValue()))
/*     */         {
/* 641 */           return;
/*     */         }
/* 643 */         core.intpropmap.put(Integer.valueOf(37), wushiid);
/*     */       }
/*     */       
/* 646 */       break;
/*     */     
/*     */ 
/*     */     case 17: 
/* 650 */       Integer moralValue = (Integer)this.changeProps.get(Integer.valueOf(19));
/* 651 */       if (moralValue == null)
/*     */       {
/* 653 */         Integer oldMoralValue = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(34));
/* 654 */         if (oldMoralValue == null)
/*     */         {
/* 656 */           return;
/*     */         }
/* 658 */         core.intpropmap.put(Integer.valueOf(38), Integer.valueOf(0));
/*     */       }
/*     */       else
/*     */       {
/* 662 */         Integer oldMoralValue = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(34), moralValue);
/* 663 */         if ((oldMoralValue != null) && (oldMoralValue.intValue() == moralValue.intValue()))
/*     */         {
/* 665 */           return;
/*     */         }
/* 667 */         core.intpropmap.put(Integer.valueOf(38), moralValue);
/*     */       }
/*     */       
/* 670 */       break;
/*     */     
/*     */ 
/*     */     case 18: 
/* 674 */       boolean changed = false;
/*     */       
/* 676 */       Integer changeModelCardCfgid = (Integer)this.changeProps.get(Integer.valueOf(20));
/* 677 */       if (changeModelCardCfgid == null)
/*     */       {
/* 679 */         mapModelInfo.model.extramap.remove(Integer.valueOf(36));
/* 680 */         mapModelInfo.model.extramap.remove(Integer.valueOf(37));
/* 681 */         Integer oldChangeModelCardCfgid = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(35));
/* 682 */         if (oldChangeModelCardCfgid != null)
/*     */         {
/* 684 */           changed = true;
/* 685 */           core.intpropmap.put(Integer.valueOf(39), Integer.valueOf(0));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 690 */         Integer oldChangeModelCardCfgid = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(35), changeModelCardCfgid);
/*     */         
/* 692 */         if ((oldChangeModelCardCfgid == null) || (oldChangeModelCardCfgid.intValue() != changeModelCardCfgid.intValue()))
/*     */         {
/* 694 */           changed = true;
/* 695 */           core.intpropmap.put(Integer.valueOf(39), changeModelCardCfgid);
/*     */         }
/* 697 */         Integer changeModelCardLevel = (Integer)this.changeProps.get(Integer.valueOf(21));
/* 698 */         Integer oldChangeModelCardLevel = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(36), changeModelCardLevel);
/*     */         
/* 700 */         if ((oldChangeModelCardLevel == null) || (oldChangeModelCardLevel.intValue() != changeModelCardLevel.intValue()))
/*     */         {
/* 702 */           changed = true;
/* 703 */           core.intpropmap.put(Integer.valueOf(40), changeModelCardLevel);
/*     */         }
/* 705 */         Integer changeModelCardMini = (Integer)this.changeProps.get(Integer.valueOf(22));
/* 706 */         Integer oldChangeModelCardMini = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(37), changeModelCardMini);
/*     */         
/* 708 */         if ((oldChangeModelCardMini == null) || (oldChangeModelCardMini.intValue() != changeModelCardMini.intValue()))
/*     */         {
/* 710 */           changed = true;
/* 711 */           core.intpropmap.put(Integer.valueOf(41), changeModelCardMini);
/*     */         }
/*     */       }
/*     */       
/* 715 */       if (!changed)
/*     */       {
/* 717 */         return;
/*     */       }
/*     */       
/* 720 */       break;
/*     */     case 2: case 7: 
/*     */     case 8: 
/*     */     default: 
/* 724 */       GameServer.logger().error(String.format("[map]MMH_OnRoleAppearanceChanged.doProcess@unkown reason|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.reason) }));
/*     */       
/*     */ 
/*     */ 
/* 728 */       return;
/*     */     }
/*     */     
/* 731 */     role.updateRoleModelCache();
/* 732 */     role.broadcastProtocolIncludeSelf(core);
/*     */   }
/*     */   
/*     */   private boolean updateQilingEffectLevel(MapModelInfo mapModelInfo, SSyncRoleModelChange core)
/*     */   {
/* 737 */     Integer level = (Integer)this.changeProps.get(Integer.valueOf(14));
/* 738 */     if ((level == null) || (level.intValue() < 0))
/*     */     {
/* 740 */       Integer oldLevel = (Integer)mapModelInfo.model.extramap.remove(Integer.valueOf(16));
/* 741 */       if (oldLevel != null)
/*     */       {
/* 743 */         core.intpropmap.put(Integer.valueOf(25), Integer.valueOf(-1));
/*     */         
/* 745 */         return true;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 750 */       Integer oldLevel = (Integer)mapModelInfo.model.extramap.put(Integer.valueOf(16), Integer.valueOf(level.intValue()));
/* 751 */       if ((oldLevel == null) || (oldLevel.intValue() != level.intValue()))
/*     */       {
/* 753 */         core.intpropmap.put(Integer.valueOf(25), level);
/*     */         
/* 755 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 759 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleAppearanceChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */