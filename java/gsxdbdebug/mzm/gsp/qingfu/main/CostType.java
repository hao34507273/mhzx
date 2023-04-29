/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum CostType
/*     */ {
/*  11 */   CostTest(false, 0, "test: cost"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  16 */   CostBindFirstTest(true, 1, "test: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   COST_BIND_FIRST_BAITAN_UNLOCK_GRID(true, 100, "baitan: unlock grid cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   COST_BIND_FIRST_CSP(true, 110, "csp: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   COST_BIND_FIRST_BIGBOSS_BUY_CHALLENGE_COUNT(true, 120, "bigboss: buy challenge count cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   COST_BIND_FIRST_TASK_REN_XING_YI_XIA(true, 130, "task: ren xing yi xia cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   COST_BIND_FIRST_GANG_CREATE(true, 140, "gang: create gang cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   COST_BIND_FIRST_GANG_DESIGN_DUTY_NAME(true, 141, "gang: create gang cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   COST_BIND_FIRST_GANG_RENAME(true, 142, "gang: rename cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   COST_BIND_FIRST_USE_EXTEND_BAG_ITEM(true, 160, "item: use extend bag item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   COST_BIND_FIRST_USE_GIFT_BAG_ITEM(true, 161, "item: use gift bag item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   COST_BIND_FIRST_ITEM_OPEN_NEW_STORAGE(true, 162, "item: open new storage cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   COST_BIND_FIRST_ITEM_LOCK_EQUIP_HUN(true, 163, "item: lock equip hun cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   COST_BIND_FIRST_ITEM_EXCHANGE_ITEM(true, 164, "item: lock equip hun cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   COST_BIND_FIRST_ITEM_BUY_GOLD_SLIVER(true, 165, "item: buy gold sliver cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   COST_BIND_FIRST_ITEM_EXTEND_BAG(true, 166, "item: extend bag cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   COST_BIND_FIRST_ITEM_QUIP_QI_LING(true, 167, "item: euip qi ling cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   COST_BIND_FIRST_ITEM_QUIP_MAKE(true, 168, "item: euip make cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   COST_ITEM_BUY_GOLD_INGOT(false, 169, "item: buy gold ingot cost"), 
/*     */   
/*     */ 
/*     */ 
/* 105 */   COST_BIND_FIRST_ITEM_REFRESH_HUN(true, 170, "item: euip refresh hun cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 110 */   COST_BIND_FIRST_JINGJI_BUY_CHALLENGE_COUNT(true, 180, "jingji: buy challenge count cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 115 */   COST_BIND_FIRST_MALL_BUY_FUNCTION_ITEM(true, 190, "mall: buy function item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 120 */   COST_BIND_FIRST_MALL_BUY_LIMIT_ITEM(true, 191, "mall: buy limit item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 125 */   COST_BIND_FIRST_MALL_BUY_PRECIOUS_ITEM(true, 192, "mall: buy precious item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 130 */   COST_BIND_FIRST_MALL_BUY_FASHION_DRESS_ITEM(true, 193, "mall: buy fashion dress item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 135 */   COST_BIND_FIRST_MAP_ITEM_GATHER(true, 200, "mall: item gather cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 140 */   COST_BIND_FIRST_WING_OPEN_NEW(true, 210, "wing: open new wing cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 145 */   COST_BIND_FIRST_WING_RESET(true, 211, "wing: reset wing cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 150 */   COST_BIND_FIRST_WING_PHASE_UP(true, 212, "wing: phase up cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 155 */   COST_BIND_FIRST_WING_RANDOM_SKILL(true, 213, "wing: random phase up skill"), 
/*     */   
/*     */ 
/*     */ 
/* 159 */   COST_BIND_FIRST_WING_RESET_MAIN_SKILL(true, 214, "wing: reset main skill"), 
/*     */   
/*     */ 
/*     */ 
/* 163 */   COST_BIND_FIRST_WING_RESET_SUB_SKILL(true, 215, "wing: reset sub skill"), 
/*     */   
/*     */ 
/*     */ 
/* 167 */   COST_BIND_FIRST_WING_RESET_PROPERTY(true, 216, "wing: reset wing property"), 
/*     */   
/*     */ 
/*     */ 
/* 171 */   COST_BIND_FIRST_WING_MODLE_DYE(true, 217, "wing: dye wing model"), 
/*     */   
/*     */ 
/*     */ 
/* 175 */   COST_BIND_FIRST_MARRIAGE_CONFIRM(true, 220, "marriage: confirm cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 180 */   COST_BIND_FIRST_MARRIAGE_CHANGE_TITLE(true, 221, "marriage: change title cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 185 */   COST_UNBIND_MARRIAGE_SEND_GIFT(false, 222, "marriage: send gift cost unbind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 190 */   COST_BIND_FIRST_MARRIAGE_PARADE(true, 223, "marriage: marriage parade cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 195 */   COST_BIND_FIRST_ROLE_RENAME(true, 240, "role: rename cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 200 */   COST_BIND_FIRST_ROLE_RESET_PROP(true, 241, "role: reset prop cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 205 */   COST_BIND_FIRST_ROLE_MODLE_DYE(true, 242, "role: dye role model"), 
/*     */   
/*     */ 
/*     */ 
/* 209 */   COST_BIND_FIRST_PARTNER_ACTIVE(true, 250, "role: active cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 214 */   COST_BIND_FIRST_PET_MINGJI(true, 260, "pet: mingji cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 219 */   COST_BIND_FIRST_PET_RESET_PROP(true, 261, "pet: reset prop cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 224 */   COST_BIND_FIRST_PET_HUASHENG(true, 262, "pet: hua sheng cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 229 */   COST_BIND_FIRST_PET_FANSHENG(true, 263, "pet: fan sheng cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 234 */   COST_BIND_FIRST_PET_EXPEND_BAG(true, 264, "pet: expend bag cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 239 */   COST_BIND_FIRST_PET_EXPEND_DEPOT(true, 264, "pet: expend depot cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 244 */   COST_BIND_FIRST_PET_REFRESH_AMULET(true, 265, "pet: expend depot cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 249 */   COST_BIND_FIRST_PET_ARENA_BUY_COUNT(true, 266, "pet: buy count cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 254 */   COST_BIND_FABAO_WASH(true, 270, "fabao: wash"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 259 */   COST_BIND_FABAO_UPRANK(true, 271, "fabao: uprank"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 264 */   COST_BIND_FABAO_COMPLEX(true, 272, "fabao: complex"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 269 */   COST_BIND_FABAO_AUTO_UPRANK(true, 273, "fabao: autouprank"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 274 */   COST_BIND_FIRST_IDIP(true, 300, "idip: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 279 */   COST_BIND_FIRST_AQIDIP(true, 301, "aqidip: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 284 */   COST_AQIDIP(false, 302, "aqidip: cost"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 289 */   COST_BIND_FIRST_MI_BAO_VALUE(true, 303, "mibao: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 294 */   COST_BIND_FIRST_GMT(true, 304, "gmt: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 299 */   COST_BIND_FIRST_AQGMT(true, 305, "aqgmt: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 304 */   COST_AQGMT(false, 306, "aqgmt: cost"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 309 */   COST_BIND_FIRST_TIME_LIMIT_GIFT(true, 310, "time limit gift: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 314 */   COST_BIND_FIRST_PET_REPLACE_SKILL(true, 311, "pet: replace skill cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 319 */   COST_BIND_FIRST_MARKET_CUSTOMIZED(true, 320, "market: condition customized"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 324 */   COST_BIND_FIRST_REFRESH_BOUNTY(true, 330, "bounty: refresh tasks cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 329 */   COST_BIND_FIRST_CREATE_HOME(true, 351, "create home: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/* 333 */   COST_BIND_FIRST_PET_ROOM_LEVEL_UP(true, 352, "pet room level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/* 337 */   COST_BIND_FIRST_BED_ROOM_LEVEL_UP(true, 353, "bed room level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/* 341 */   COST_BIND_FIRST_DRUG_ROOM_LEVEL_UP(true, 354, "drug room level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/* 345 */   COST_BIND_FIRST_KITCHEN_LEVEL_UP(true, 355, "kitchen level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 350 */   COST_BIND_FIRST_MAID_ROOM_LEVEL_UP(true, 356, "maid room level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 355 */   COST_BIND_FIRST_HOME_LEVEL_UP(true, 357, "home level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 360 */   COST_BIND_FIRST_INVITE_MAID(true, 358, "invite maid: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 365 */   COST_BIND_FIRST_BUY_FURNITURE(true, 359, "buy furniture: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/* 369 */   COST_BIND_FIRST_FRESH_FURNITURE(true, 360, "fresh furniture: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 374 */   COST_BIND_FIRST_CLEAN_HOME(true, 361, "clean home: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/* 378 */   COST_BIND_FIRST_MOUNTS_REFRESH_SKILL(true, 370, "mounts:refresh passive skill"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 383 */   COST_BIND_FIRST_MOUNTS_DYE_COLOR(true, 371, "mounts:dye color"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 388 */   COST_BIND_FIRST_MOUNTS_ACTIVE_STAR_LIFE(true, 372, "mounts:active star life"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 393 */   COST_UNBIND_YUANBAO_SEND_CHAT_GIFT(false, 373, "chatgift: send chatgift"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 398 */   COST_BIND_FIRST_MOUNTS_RANK_UP(true, 374, "mounts:rank up"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 403 */   COST_BIND_FIRST_OPEN_LUCKY_BAG(true, 375, "luckybag: open lucky bag"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 408 */   COST_BIND_FIRST_MASS_EXP_FILL_GRID(true, 376, "massexp: fill grid"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 413 */   COST_BIND_FIRST_MULTI_OCCUP_ACTIVE(true, 380, "multioccupation:active new"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 418 */   COST_BIND_FIRST_BUY_LUCKY_STAR(true, 385, "lucky:buy gift"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 423 */   COST_BIND_FIRST_PET_GET_MODEL_ITEM(true, 386, "pet: get model item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 428 */   COST_BIND_FIRST_PET_CANCEL_MODEL_CHANGE(true, 387, "pet: cancel model change cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 433 */   COST_UNBIND_FIRST_SEND_GIFT(false, 400, "gift: send gift cost unbind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 438 */   COST_BIND_FIRST_CHILDHOOD_FINISH_COURSE(true, 410, "childhood: finish course"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 443 */   COST_BIND_FIRST_CHILDHOOD_END_COURSE(true, 411, "childhood: end course"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 448 */   COST_BIND_FIRST_CHILDHOOD_STUDY_COURSE(true, 412, "childhood: study course"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 453 */   COST_BIND_FIRST_SHANG_GONG(true, 413, "shanggong:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 458 */   COST_BIND_GIVE_BIRTH(true, 415, "givebirth:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 463 */   COST_BIND_BABY_BREED(true, 416, "babybreed:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 468 */   COST_BIND_FIRST_CHILD_UNLOCK_SKILL_POS(true, 417, "unlockSkillPos:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 473 */   COST_BIND_FIRST_QILIN_ACCUMULATION_MODE(true, 418, "qilin:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 478 */   COST_BIND_FIRST_CHILD_EQUIP_RANDOM_PROP(true, 419, "ChildrenEquipRandomProp:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 483 */   COST_BIND_FIRST_CHILD_REFRESH_AMULET(true, 420, "ChildrenRefreshAmulet: bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 488 */   COST_BIND_FIRST_PLANT_TREE(true, 421, "planttree:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 493 */   COST_BIND_FIRST_EQUIP_SKILL_REFRESH(true, 422, "equip skill refresh:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 498 */   COST_BIND_FIRST_CHILD_EQUIP_STAGE_UP(true, 423, "ChildrenEquipStageUp: bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 503 */   COST_BIND_FIRST_BACK_GAME_GIFT_BUY(true, 424, "backgame: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 508 */   COST_BIND_FIRST_TRUMPET(true, 425, "trumpet:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 513 */   COST_BIND_FIRST_SIGN_PRECIOUS_OPEN_CELL(true, 426, "signprecious open lucky: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 518 */   COST_BIND_FIRST_SIGN_PRECIOUS_FORCE_ARRIVE(true, 427, "signprecious arrive: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 523 */   COST_BIND_FIRST_SET_VOTE_AWARD(true, 428, "menpaistar:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 528 */   COST_AXE_ACTIVITY(false, 429, "axe activity:not cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 533 */   COST_BIND_FIRST_COURT_YARD_LEVEL_UP(true, 430, "court yard level up: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 538 */   COST_BIND_FIRST_CLEAN_YARD(true, 431, "clean court yard: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 543 */   COST_BIND_FIRST_CROSS_BATTLE_REGISTER(true, 432, "cross battle register:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 548 */   COST_BIND_FIRST_MYSTERY_SHOP(true, 433, "mystery shop register:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 553 */   COST_BIND_FIRST_FLOP_LOTTERY(true, 434, "flop lottery:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 558 */   COST_BIND_FIRST_MALL_BUY_DAILY_LIMIT_ITEM(true, 435, "mall: buy daily limit item cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 563 */   COST_BIND_FIRST_IMPROVE_FABAO_ARTIFACT(true, 436, "fabaolingqi: improve artifact property"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 568 */   COST_BIND_FIRST_IMPROVE_SUPER_EQUIPMENT_STAGE(true, 437, "super_equipment: improve stage"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 573 */   COST_BIND_FIRST_IMPROVE_SUPER_EQUIPMENT_LEVEL(true, 438, "super_equipment: improve level"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 578 */   COST_BIND_FIRST_SUPER_EQUIPMENT_JEWEL_COMPOSE(true, 439, "super equipment jewel: compose jewel"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 583 */   COST_BIND_FIRST_MOUNTS_EXPAND_PROTECT_PET_SIZE(true, 440, "mounts:expand protect pet size"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 588 */   COST_BIND_FIRST_ENABLE_PK(true, 441, "pk: enable"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 593 */   COST_BIND_FIRST_BUY_MORAL_VALUE(true, 442, "moral value: buy"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 598 */   COST_BIND_FIRST_WANTED_ROLE(true, 443, "wanted: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 603 */   COST_BIND_FIRST_JAIL_BREAK(true, 444, "jail break: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 608 */   COST_BACK_GAME_ACTIVITY_GIFT_BUY(true, 445, "back game activity gift buy: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 613 */   COST_PET_SOUL_RANDOM_PROP(true, 446, "pet soul: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 618 */   COST_BIND_FIRST_IMPROVE_PARTNER_YUANSHEN(true, 447, "partner yuanshen: improve"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 623 */   COST_PET_SOUL_EXCHANGE_PROP(true, 448, "pet soul exchage: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 628 */   COST_BIND_FIRST_LEGOUSHANGCHENG_BUY_GOODS(true, 449, "legoushangcheng buy goods: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 633 */   COST_BIND_FIRST_SINGLE_INSTANCE_SAO_DANG(true, 450, "single instance sao dang:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 638 */   COST_BIND_FIRST_FRIENDS_CIRCLE_GIVE_GIFT(true, 451, "friends circle give gift:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 643 */   COST_BIND_FIRST_SWEEP_FLOOR(true, 452, "sweep floor: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 648 */   COST_BIND_FIRST_XIAO_HUI_KUAI_PAO_OUTER_DRAW(true, 453, "xiao hui kuai pao outer draw: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 653 */   COST_BIND_FIRST_CREATE_SHOPPING_GROUP(true, 454, "group shopping: create shopping group, cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 658 */   COST_BIND_FIRST_JOIN_SHOPPING_GROUP(true, 455, "group shopping: join shopping group, cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 663 */   COST_BIND_FIRST_GROUP_SHOPPING_DIRECT_BUY(true, 456, "group shopping: direct buy, cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 668 */   COST_BIND_FIRST_AIRCRAFT_DYE(true, 457, "aircraft dye:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 673 */   COST_BIND_FIRST_BANG_GONG_CHANGE(true, 458, "bang gong change:cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 678 */   COST_BIND_FIRST_ACTIVITY_POINT_EXCHANGE_MANUAL_REFRESH(true, 459, "activity point exchange manual refresh：cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 683 */   COST_INDIANA(false, 460, "indiana:not cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 688 */   COST_CHILDREN_AUTO_BREED(true, 461, "children auto breed: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 693 */   COST_UN_BIND_AUCTION_BID(false, 462, "auction bid: cost unbind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 698 */   COST_BIND_FIRST_AUCTION_BID(true, 463, "auction bid: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 703 */   COST_ACTIVITY_COMPENSATE_GET_ONCE(true, 464, "activity compensate get once: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 708 */   COST_ACTIVITY_COMPENSATE_GET_ALL(true, 465, "activity compensate get all: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 713 */   CHILDREN_RECALL(true, 466, "children recall: cost bind first"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 718 */   COST_UN_BIND_TIME_LIMIT_GIFT_BAG_GIFT_TO_FRIEND(false, 468, "time limit gift bag send gift to friend: cost unbind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 723 */   COST_BIND_FIRST_DRAW_CARNIVAL__DRAW(true, 490, "draw carnival draw: cost bind first");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean bindFirst;
/*     */   
/*     */ 
/*     */ 
/*     */   public final int type;
/*     */   
/*     */ 
/*     */ 
/*     */   public final String reason;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private CostType(boolean bindFirst, int type, String reason)
/*     */   {
/* 744 */     this.bindFirst = bindFirst;
/* 745 */     this.type = type;
/* 746 */     this.reason = reason;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\CostType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */