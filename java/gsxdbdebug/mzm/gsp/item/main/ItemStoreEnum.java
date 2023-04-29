/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ItemStoreEnum
/*     */ {
/*  16 */   STRENGTH_LEVEL(0), 
/*     */   
/*     */ 
/*     */ 
/*  20 */   ATTRI_A(2), 
/*     */   
/*  22 */   ATTRI_B(3), 
/*     */   
/*  24 */   EQUIP_SKILL(6), 
/*     */   
/*     */ 
/*  27 */   STRENGTHEN_SCORE(4), 
/*     */   
/*  29 */   USE_POINT_VALUE(5), 
/*     */   
/*     */ 
/*  32 */   BAO_TU_X(20), 
/*     */   
/*  34 */   BAO_TU_Y(21), 
/*     */   
/*  36 */   BAO_TU_Z(22), 
/*     */   
/*  38 */   BAO_TU_MAP_ID(23), 
/*     */   
/*     */ 
/*  41 */   PET_EQUIP_ATTRI_A(40),  PET_EQUIP_ATTRI_B(41),  PET_EQUIP_SKILL_1(42), 
/*  42 */   PET_EQUIP_SKILL_2(43),  PET_EQUIP_ATTRI_A_TYPE(44), 
/*  43 */   PET_EQUIP_ATTRI_B_TYPE(45), 
/*     */   
/*  45 */   SHANGHUI_PRICE(47),  ITEM_SOURCE(46), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */   FABAO_OWN_SKILL_ID(61), 
/*     */   
/*  56 */   FABAO_RANK_RANDOM_SKILL_ID(66), 
/*     */   
/*  58 */   FABAO_NEXT_RANK_SKILL_ID(67), 
/*     */   
/*  60 */   FABAO_AUTO_RANKUP_TO(68), 
/*     */   
/*  62 */   FABAO_WASH_SKILL_ID(71), 
/*     */   
/*  64 */   FABAO_CUR_RANK_EXP(76),  FABAO_CUR_EXP(77),  FABAO_CUR_LV(78), 
/*     */   
/*     */ 
/*  67 */   EQUIP_FLAG(53), 
/*     */   
/*  69 */   QILING_SCORE(79), 
/*     */   
/*  71 */   MARKET_BUY_TIME(100), 
/*     */   
/*  73 */   CAT_LEVEL(120), 
/*     */   
/*  75 */   QILINZHU_USE_COUNT(150), 
/*     */   
/*  77 */   ZHENGLINSHI_USE_COUNT(151), 
/*     */   
/*  79 */   XINGYUNSHI_USE_COUNT(152), 
/*     */   
/*  81 */   ACCUMULATION_QILIN_SCORE(153), 
/*     */   
/*  83 */   CAN_ADD_INIT_QILIN_SCORE(154), 
/*     */   
/*     */ 
/*  86 */   CHILDREN_EQUIP_EXP(170), 
/*  87 */   CHILDREN_EQUIP_LEVEL(171), 
/*  88 */   CHILDREN_EQUIP_STAGE(172), 
/*  89 */   CHILDREN_EQUIP_PROP_A(173), 
/*     */   
/*  91 */   EQUIP_SKILL_TEMP(190), 
/*  92 */   MAKER_ID_HIGH(201), 
/*  93 */   MAKER_ID_LOW(202), 
/*  94 */   BUFF_ID(203), 
/*  95 */   ACTIVITY_CFG_ID(204), 
/*  96 */   EXPERIENCE_VALUE(205), 
/*     */   
/*  98 */   TOTAL_BOTTLE_EXP_VALUE(211), 
/*  99 */   LEFT_BOTTLE_EXP_VALUE(212), 
/*     */   
/* 101 */   LEFT_DOUBLE_ITEM_USE_TIMES(221), 
/*     */   
/*     */ 
/* 104 */   SUPER_EQUIPMENT_STAGE(241), 
/* 105 */   SUPER_EQUIPMENT_LEVEL(242), 
/*     */   
/*     */ 
/*     */ 
/* 109 */   REVENGE_ITEM_AVAILABLE_TIMES(251), 
/* 110 */   REVENGE_ITEM_BIND_HIGH(252), 
/* 111 */   REVENGE_ITEM_BIND_LOW(253), 
/*     */   
/*     */ 
/* 114 */   CHAINED_GIFT_BAG_USE_TIME(261), 
/*     */   
/* 116 */   TIME_ITEM_END_TIME(231), 
/*     */   
/*     */ 
/* 119 */   INDIANA_ACTIVITY_CFG_ID(271), 
/* 120 */   INDIANA_ACTIVITY_TURN(272), 
/* 121 */   INDIANA_SORT_ID(273), 
/* 122 */   INDIANA_NUMBER(274), 
/*     */   
/*     */ 
/* 125 */   EQUIPMENT_BLESS_LEVEL(281), 
/* 126 */   EQUIPMENT_BLESS_EXP(282), 
/*     */   
/*     */ 
/* 129 */   CAKE_MAKER_ID_HIGH(291), 
/* 130 */   CAKE_MAKER_ID_LOW(292), 
/* 131 */   CAKE_ACTIVITY_ID(293);
/*     */   
/*     */ 
/*     */   private int storeType;
/*     */   
/*     */   private ItemStoreEnum(int storeType)
/*     */   {
/* 138 */     this.storeType = storeType;
/*     */   }
/*     */   
/*     */   public int getStoreType()
/*     */   {
/* 143 */     return this.storeType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean check()
/*     */   {
/* 153 */     HashSet<Integer> set = new HashSet();
/* 154 */     for (ItemStoreEnum storeEnum : values())
/*     */     {
/* 156 */       if (set.contains(Integer.valueOf(storeEnum.getStoreType())))
/*     */       {
/* 158 */         throw new RuntimeException("ItemStoreEnum:道具的存储类型不能够重复");
/*     */       }
/* 160 */       set.add(Integer.valueOf(storeEnum.getStoreType()));
/*     */     }
/* 162 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemStoreEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */