/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemModuleSwitchInterface
/*     */ {
/*     */   public static boolean isAbandonItemSwitchOpenForRole(long roleid)
/*     */   {
/*  12 */     if (!OpenInterface.getOpenStatus(62))
/*     */     {
/*  14 */       return false;
/*     */     }
/*  16 */     if (OpenInterface.isBanPlay(roleid, 62))
/*     */     {
/*  18 */       OpenInterface.sendBanPlayMsg(roleid, 62);
/*  19 */       return false;
/*     */     }
/*  21 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isExchangeGoldSilverItemSwitchOpenForRole(long roleid)
/*     */   {
/*  26 */     if (!OpenInterface.getOpenStatus(63))
/*     */     {
/*  28 */       return false;
/*     */     }
/*  30 */     if (OpenInterface.isBanPlay(roleid, 63))
/*     */     {
/*  32 */       OpenInterface.sendBanPlayMsg(roleid, 63);
/*  33 */       return false;
/*     */     }
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isExchangeIngotItemSwitchOpenForRole(long roleid)
/*     */   {
/*  40 */     if (!OpenInterface.getOpenStatus(64))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (OpenInterface.isBanPlay(roleid, 64))
/*     */     {
/*  46 */       OpenInterface.sendBanPlayMsg(roleid, 64);
/*  47 */       return false;
/*     */     }
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isItemRecycleSwitchOpenForRole(long roleid)
/*     */   {
/*  54 */     if (!OpenInterface.getOpenStatus(65))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     if (OpenInterface.isBanPlay(roleid, 65))
/*     */     {
/*  60 */       OpenInterface.sendBanPlayMsg(roleid, 65);
/*  61 */       return false;
/*     */     }
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipMakeSwitchOpenForRole(long roleid)
/*     */   {
/*  68 */     if (!OpenInterface.getOpenStatus(66))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if (OpenInterface.isBanPlay(roleid, 66))
/*     */     {
/*  74 */       OpenInterface.sendBanPlayMsg(roleid, 66);
/*  75 */       return false;
/*     */     }
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipQilinSwitchOpenForRole(long roleid)
/*     */   {
/*  82 */     if (!OpenInterface.getOpenStatus(67))
/*     */     {
/*  84 */       return false;
/*     */     }
/*  86 */     if (OpenInterface.isBanPlay(roleid, 67))
/*     */     {
/*  88 */       OpenInterface.sendBanPlayMsg(roleid, 67);
/*  89 */       return false;
/*     */     }
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipXihunSwitchOpenForRole(long roleid)
/*     */   {
/*  96 */     if (!OpenInterface.getOpenStatus(68))
/*     */     {
/*  98 */       return false;
/*     */     }
/* 100 */     if (OpenInterface.isBanPlay(roleid, 68))
/*     */     {
/* 102 */       OpenInterface.sendBanPlayMsg(roleid, 68);
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipZhuanhunSwitchOpenForRole(long roleid)
/*     */   {
/* 110 */     if (!OpenInterface.getOpenStatus(69))
/*     */     {
/* 112 */       return false;
/*     */     }
/* 114 */     if (OpenInterface.isBanPlay(roleid, 69))
/*     */     {
/* 116 */       OpenInterface.sendBanPlayMsg(roleid, 69);
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipChuanLinSwitchOpenForRole(long roleid)
/*     */   {
/* 124 */     if (!OpenInterface.getOpenStatus(70))
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     if (OpenInterface.isBanPlay(roleid, 70))
/*     */     {
/* 130 */       OpenInterface.sendBanPlayMsg(roleid, 70);
/* 131 */       return false;
/*     */     }
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isItemExchangeSwitchOpenForRole(long roleid)
/*     */   {
/* 138 */     if (!OpenInterface.getOpenStatus(71))
/*     */     {
/* 140 */       return false;
/*     */     }
/* 142 */     if (OpenInterface.isBanPlay(roleid, 71))
/*     */     {
/* 144 */       OpenInterface.sendBanPlayMsg(roleid, 71);
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isBagExtendSwitchOpenForRole(long roleid)
/*     */   {
/* 152 */     if (!OpenInterface.getOpenStatus(72))
/*     */     {
/* 154 */       return false;
/*     */     }
/* 156 */     if (OpenInterface.isBanPlay(roleid, 72))
/*     */     {
/* 158 */       OpenInterface.sendBanPlayMsg(roleid, 72);
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipFixSwitchOpenForRole(long roleid)
/*     */   {
/* 166 */     if (!OpenInterface.getOpenStatus(73))
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     if (OpenInterface.isBanPlay(roleid, 73))
/*     */     {
/* 172 */       OpenInterface.sendBanPlayMsg(roleid, 73);
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isGiveFlowerSwitchOpenForRole(long roleid, long receiveRoleid)
/*     */   {
/* 187 */     if (!OpenInterface.getOpenStatus(74))
/*     */     {
/* 189 */       return false;
/*     */     }
/* 191 */     if (OpenInterface.isBanPlay(roleid, 74))
/*     */     {
/* 193 */       OpenInterface.sendBanPlayMsg(roleid, 74);
/* 194 */       return false;
/*     */     }
/* 196 */     if (OpenInterface.isBanPlay(receiveRoleid, 74))
/*     */     {
/* 198 */       OpenInterface.sendBanPlayMsg(roleid, receiveRoleid, RoleInterface.getName(receiveRoleid), 74);
/*     */       
/* 200 */       return false;
/*     */     }
/* 202 */     return true;
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
/*     */   public static boolean isGiveItemSwitchOpenForRole(long roleid, long receiveRoleid)
/*     */   {
/* 215 */     if (!OpenInterface.getOpenStatus(75))
/*     */     {
/* 217 */       return false;
/*     */     }
/* 219 */     if (OpenInterface.isBanPlay(roleid, 75))
/*     */     {
/* 221 */       OpenInterface.sendBanPlayMsg(roleid, 75);
/* 222 */       return false;
/*     */     }
/* 224 */     if (OpenInterface.isBanPlay(receiveRoleid, 75))
/*     */     {
/* 226 */       OpenInterface.sendBanPlayMsg(roleid, receiveRoleid, RoleInterface.getName(receiveRoleid), 75);
/*     */       
/* 228 */       return false;
/*     */     }
/* 230 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isItemCompoundSwitchOpenForRole(long roleid)
/*     */   {
/* 235 */     if (!OpenInterface.getOpenStatus(76))
/*     */     {
/* 237 */       return false;
/*     */     }
/* 239 */     if (OpenInterface.isBanPlay(roleid, 76))
/*     */     {
/* 241 */       OpenInterface.sendBanPlayMsg(roleid, 76);
/* 242 */       return false;
/*     */     }
/* 244 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isItemCompoundAllSwitchOpenForRole(long roleid)
/*     */   {
/* 249 */     if (!OpenInterface.getOpenStatus(404))
/*     */     {
/* 251 */       return false;
/*     */     }
/* 253 */     if (OpenInterface.isBanPlay(roleid, 404))
/*     */     {
/* 255 */       OpenInterface.sendBanPlayMsg(roleid, 404);
/* 256 */       return false;
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipLockHunSwitchOpenForRole(long roleid)
/*     */   {
/* 263 */     if (!OpenInterface.getOpenStatus(77))
/*     */     {
/* 265 */       return false;
/*     */     }
/* 267 */     if (OpenInterface.isBanPlay(roleid, 77))
/*     */     {
/* 269 */       OpenInterface.sendBanPlayMsg(roleid, 77);
/* 270 */       return false;
/*     */     }
/* 272 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isMoveItemIntoStorageSwitchOpenForRole(long roleid)
/*     */   {
/* 277 */     if (!OpenInterface.getOpenStatus(78))
/*     */     {
/* 279 */       return false;
/*     */     }
/* 281 */     if (OpenInterface.isBanPlay(roleid, 78))
/*     */     {
/* 283 */       OpenInterface.sendBanPlayMsg(roleid, 78);
/* 284 */       return false;
/*     */     }
/* 286 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isMoveItemIntoBagSwitchOpenForRole(long roleid)
/*     */   {
/* 291 */     if (!OpenInterface.getOpenStatus(79))
/*     */     {
/* 293 */       return false;
/*     */     }
/* 295 */     if (OpenInterface.isBanPlay(roleid, 79))
/*     */     {
/* 297 */       OpenInterface.sendBanPlayMsg(roleid, 79);
/* 298 */       return false;
/*     */     }
/* 300 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isOpenNewStorageSwitchOpenForRole(long roleid)
/*     */   {
/* 305 */     if (!OpenInterface.getOpenStatus(80))
/*     */     {
/* 307 */       return false;
/*     */     }
/* 309 */     if (OpenInterface.isBanPlay(roleid, 80))
/*     */     {
/* 311 */       OpenInterface.sendBanPlayMsg(roleid, 80);
/* 312 */       return false;
/*     */     }
/* 314 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isPutOnAirCraftSwitchOpenForRole(long roleid)
/*     */   {
/* 319 */     if (!OpenInterface.getOpenStatus(81))
/*     */     {
/* 321 */       return false;
/*     */     }
/* 323 */     if (OpenInterface.isBanPlay(roleid, 81))
/*     */     {
/* 325 */       OpenInterface.sendBanPlayMsg(roleid, 81);
/* 326 */       return false;
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isPutOnFabaoSwitchOpenForRole(long roleid)
/*     */   {
/* 333 */     if (!OpenInterface.getOpenStatus(82))
/*     */     {
/* 335 */       return false;
/*     */     }
/* 337 */     if (OpenInterface.isBanPlay(roleid, 82))
/*     */     {
/* 339 */       OpenInterface.sendBanPlayMsg(roleid, 82);
/* 340 */       return false;
/*     */     }
/* 342 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipOnSwitchOpenForRole(long roleid)
/*     */   {
/* 347 */     if (!OpenInterface.getOpenStatus(83))
/*     */     {
/* 349 */       return false;
/*     */     }
/* 351 */     if (OpenInterface.isBanPlay(roleid, 83))
/*     */     {
/* 353 */       OpenInterface.sendBanPlayMsg(roleid, 83);
/* 354 */       return false;
/*     */     }
/* 356 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseBaotuSwitchOpenForRole(long roleid)
/*     */   {
/* 361 */     if (!OpenInterface.getOpenStatus(84))
/*     */     {
/* 363 */       return false;
/*     */     }
/* 365 */     if (OpenInterface.isBanPlay(roleid, 84))
/*     */     {
/* 367 */       OpenInterface.sendBanPlayMsg(roleid, 84);
/* 368 */       return false;
/*     */     }
/* 370 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseDoubleItemSwitchOpenForRole(long roleid)
/*     */   {
/* 375 */     if (!OpenInterface.getOpenStatus(85))
/*     */     {
/* 377 */       return false;
/*     */     }
/* 379 */     if (OpenInterface.isBanPlay(roleid, 85))
/*     */     {
/* 381 */       OpenInterface.sendBanPlayMsg(roleid, 85);
/* 382 */       return false;
/*     */     }
/* 384 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseFabaoResetItemSwitchOpenForRole(long roleid)
/*     */   {
/* 389 */     if (!OpenInterface.getOpenStatus(86))
/*     */     {
/* 391 */       return false;
/*     */     }
/* 393 */     if (OpenInterface.isBanPlay(roleid, 86))
/*     */     {
/* 395 */       OpenInterface.sendBanPlayMsg(roleid, 86);
/* 396 */       return false;
/*     */     }
/* 398 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseFumoItemSwitchOpenForRole(long roleid)
/*     */   {
/* 403 */     if (!OpenInterface.getOpenStatus(87))
/*     */     {
/* 405 */       return false;
/*     */     }
/* 407 */     if (OpenInterface.isBanPlay(roleid, 87))
/*     */     {
/* 409 */       OpenInterface.sendBanPlayMsg(roleid, 87);
/* 410 */       return false;
/*     */     }
/* 412 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseGangFileItemSwitchOpenForRole(long roleid)
/*     */   {
/* 417 */     if (!OpenInterface.getOpenStatus(88))
/*     */     {
/* 419 */       return false;
/*     */     }
/* 421 */     if (OpenInterface.isBanPlay(roleid, 88))
/*     */     {
/* 423 */       OpenInterface.sendBanPlayMsg(roleid, 88);
/* 424 */       return false;
/*     */     }
/* 426 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseGiftBagItemSwitchOpenForRole(long roleid)
/*     */   {
/* 431 */     if (!OpenInterface.getOpenStatus(89))
/*     */     {
/* 433 */       return false;
/*     */     }
/* 435 */     if (OpenInterface.isBanPlay(roleid, 89))
/*     */     {
/* 437 */       OpenInterface.sendBanPlayMsg(roleid, 89);
/* 438 */       return false;
/*     */     }
/* 440 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseLotteryItemSwitchOpenForRole(long roleid)
/*     */   {
/* 445 */     if (!OpenInterface.getOpenStatus(90))
/*     */     {
/* 447 */       return false;
/*     */     }
/* 449 */     if (OpenInterface.isBanPlay(roleid, 90))
/*     */     {
/* 451 */       OpenInterface.sendBanPlayMsg(roleid, 90);
/* 452 */       return false;
/*     */     }
/* 454 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseAllLotteryItemSwitchOpenForRole(long roleId)
/*     */   {
/* 459 */     if (!isUseLotteryItemSwitchOpenForRole(roleId))
/* 460 */       return false;
/* 461 */     if (!OpenInterface.getOpenStatus(488))
/* 462 */       return false;
/* 463 */     if (OpenInterface.isBanPlay(roleId, 488))
/*     */     {
/* 465 */       OpenInterface.sendBanPlayMsg(roleId, 488);
/* 466 */       return false;
/*     */     }
/* 468 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseMoneyBagItemSwitchOpenForRole(long roleid)
/*     */   {
/* 473 */     if (!OpenInterface.getOpenStatus(91))
/*     */     {
/* 475 */       return false;
/*     */     }
/* 477 */     if (OpenInterface.isBanPlay(roleid, 91))
/*     */     {
/* 479 */       OpenInterface.sendBanPlayMsg(roleid, 91);
/* 480 */       return false;
/*     */     }
/* 482 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseRidderItemSwitchOpenForRole(long roleid)
/*     */   {
/* 487 */     if (!OpenInterface.getOpenStatus(92))
/*     */     {
/* 489 */       return false;
/*     */     }
/* 491 */     if (OpenInterface.isBanPlay(roleid, 92))
/*     */     {
/* 493 */       OpenInterface.sendBanPlayMsg(roleid, 92);
/* 494 */       return false;
/*     */     }
/* 496 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseRidderDyeItemSwitchOpenForRole(long roleid)
/*     */   {
/* 501 */     if (!OpenInterface.getOpenStatus(93))
/*     */     {
/* 503 */       return false;
/*     */     }
/* 505 */     if (OpenInterface.isBanPlay(roleid, 93))
/*     */     {
/* 507 */       OpenInterface.sendBanPlayMsg(roleid, 93);
/* 508 */       return false;
/*     */     }
/* 510 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseSelectBagItemSwitchOpenForRole(long roleid)
/*     */   {
/* 515 */     if (!OpenInterface.getOpenStatus(94))
/*     */     {
/* 517 */       return false;
/*     */     }
/* 519 */     if (OpenInterface.isBanPlay(roleid, 94))
/*     */     {
/* 521 */       OpenInterface.sendBanPlayMsg(roleid, 94);
/* 522 */       return false;
/*     */     }
/* 524 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUseRoleExpItemSwitchOpenForRole(long roleid)
/*     */   {
/* 529 */     if (!OpenInterface.getOpenStatus(95))
/*     */     {
/* 531 */       return false;
/*     */     }
/* 533 */     if (OpenInterface.isBanPlay(roleid, 95))
/*     */     {
/* 535 */       OpenInterface.sendBanPlayMsg(roleid, 95);
/* 536 */       return false;
/*     */     }
/* 538 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isMoShouFragmentExchangeSwitchOpenForRole(long roleid)
/*     */   {
/* 543 */     if (!OpenInterface.getOpenStatus(130))
/*     */     {
/* 545 */       return false;
/*     */     }
/* 547 */     if (OpenInterface.isBanPlay(roleid, 130))
/*     */     {
/* 549 */       OpenInterface.sendBanPlayMsg(roleid, 130);
/* 550 */       return false;
/*     */     }
/* 552 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isUsePlayExpressionItemSwitchOpenForRole(long roleid)
/*     */   {
/* 557 */     if (!OpenInterface.getOpenStatus(173))
/*     */     {
/* 559 */       return false;
/*     */     }
/*     */     
/* 562 */     if (OpenInterface.isBanPlay(roleid, 173))
/*     */     {
/* 564 */       OpenInterface.sendBanPlayMsg(roleid, 173);
/* 565 */       return false;
/*     */     }
/* 567 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isQilinAccumulationModeSwitchOpenForRole(long roleid)
/*     */   {
/* 572 */     if (!OpenInterface.getOpenStatus(234))
/*     */     {
/* 574 */       return false;
/*     */     }
/* 576 */     if (OpenInterface.isBanPlay(roleid, 234))
/*     */     {
/* 578 */       OpenInterface.sendBanPlayMsg(roleid, 234);
/* 579 */       return false;
/*     */     }
/* 581 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipSkillRefreshSwitchOpenForRole(long roleid)
/*     */   {
/* 586 */     if (!OpenInterface.getOpenStatus(238))
/*     */     {
/* 588 */       return false;
/*     */     }
/* 590 */     if (OpenInterface.isBanPlay(roleid, 238))
/*     */     {
/* 592 */       OpenInterface.sendBanPlayMsg(roleid, 238);
/* 593 */       return false;
/*     */     }
/* 595 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isEquipDisassembleSwitchOpenForRole(long roleid)
/*     */   {
/* 600 */     if (!OpenInterface.getOpenStatus(277))
/*     */     {
/* 602 */       return false;
/*     */     }
/* 604 */     if (OpenInterface.isBanPlay(roleid, 277))
/*     */     {
/* 606 */       OpenInterface.sendBanPlayMsg(roleid, 277);
/* 607 */       return false;
/*     */     }
/* 609 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isNLevelEquipMakeSwitchOpenForRole(long roleid) {
/* 613 */     if (!OpenInterface.getOpenStatus(279))
/*     */     {
/* 615 */       return false;
/*     */     }
/* 617 */     if (OpenInterface.isBanPlay(roleid, 279))
/*     */     {
/* 619 */       OpenInterface.sendBanPlayMsg(roleid, 279);
/* 620 */       return false;
/*     */     }
/* 622 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isItemSplitSwitchOpenForRole(long roleId)
/*     */   {
/* 627 */     if (!OpenInterface.getOpenStatus(465))
/* 628 */       return false;
/* 629 */     if (OpenInterface.isBanPlay(roleId, 465))
/*     */     {
/* 631 */       OpenInterface.sendBanPlayMsg(roleId, 465);
/* 632 */       return false;
/*     */     }
/* 634 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemModuleSwitchInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */