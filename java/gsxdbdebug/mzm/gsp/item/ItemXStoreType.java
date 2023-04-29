/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemXStoreType
/*     */   implements Marshal, Comparable<ItemXStoreType>
/*     */ {
/*     */   public static final int STRENGTH_LEVEL = 0;
/*     */   public static final int ATTRI_A = 2;
/*     */   public static final int ATTRI_B = 3;
/*     */   public static final int STRENGTHEN_SCORE = 4;
/*     */   public static final int USE_POINT_VALUE = 5;
/*     */   public static final int EQUIP_SKILL = 6;
/*     */   public static final int BAO_TU_X = 20;
/*     */   public static final int BAO_TU_Y = 21;
/*     */   public static final int BAO_TU_Z = 22;
/*     */   public static final int BAO_TU_MAPID = 23;
/*     */   public static final int PET_EQUIP_ATTRI_A = 40;
/*     */   public static final int PET_EQUIP_ATTRI_B = 41;
/*     */   public static final int PET_EQUIP_SKILL_ID_1 = 42;
/*     */   public static final int PET_EQUIP_SKILL_ID_2 = 43;
/*     */   public static final int PET_EQUIP_ATTRI_A_TYPE = 44;
/*     */   public static final int PET_EQUIP_ATTRI_B_TYPE = 45;
/*     */   public static final int ITEM_SOURCE = 46;
/*     */   public static final int SHANGHUI_PRICE = 47;
/*     */   public static final int EQUIP_FLAG = 53;
/*     */   public static final int FABAO_OWN_SKILL_ID = 61;
/*     */   public static final int FABAO_RANK_RANDOM_SKILL_ID = 66;
/*     */   public static final int FABAO_NEXT_RANK_SKILL_ID = 67;
/*     */   public static final int FABAO_AUTO_RANKUP_TO = 68;
/*     */   public static final int FABAO_WASH_SKILL_ID = 71;
/*     */   public static final int FABAO_CUR_RANK_EXP = 76;
/*     */   public static final int FABAO_CUR_EXP = 77;
/*     */   public static final int FABAO_CUR_LV = 78;
/*     */   public static final int QILING_SCORE = 79;
/*     */   public static final int MARKET_BUY_TIME = 100;
/*     */   public static final int CAT_LEVEL = 120;
/*     */   public static final int QILINZHU_USE_COUNT = 150;
/*     */   public static final int ZHENGLINSHI_USE_COUNT = 151;
/*     */   public static final int XINGYUNSHI_USE_COUNT = 152;
/*     */   public static final int ACCUMULATION_QILIN_SCORE = 153;
/*     */   public static final int CAN_ADD_INIT_QILIN_SCORE = 154;
/*     */   public static final int CHILDREN_EQUIP_EXP = 170;
/*     */   public static final int CHILDREN_EQUIP_LEVEL = 171;
/*     */   public static final int CHILDREN_EQUIP_STAGE = 172;
/*     */   public static final int CHILDREN_EQUIP_PROP_A = 173;
/*     */   public static final int EQUIP_SKILL_TEMP = 190;
/*     */   public static final int MAKER_ID_HIGH = 201;
/*     */   public static final int MAKER_ID_LOW = 202;
/*     */   public static final int BUFF_ID = 203;
/*     */   public static final int ACTIVITY_CFG_ID = 204;
/*     */   public static final int EXPERIENCE_VALUE = 205;
/*     */   public static final int TOTAL_BOTTLE_EXP_VALUE = 211;
/*     */   public static final int LEFT_BOTTLE_EXP_VALUE = 212;
/*     */   public static final int LEFT_DOUBLE_ITEM_USE_TIMES = 221;
/*     */   public static final int TIME_ITEM_END_TIME = 231;
/*     */   public static final int SUPER_EQUIPMENT_STAGE = 241;
/*     */   public static final int SUPER_EQUIPMENT_LEVEL = 242;
/*     */   public static final int PK_REVENGE_ITEM_AVAILABLE_TIMES = 251;
/*     */   public static final int PK_REVENGE_ITEM_BIND_HIGH = 252;
/*     */   public static final int PK_REVENGE_ITEM_BIND_LOW = 253;
/*     */   public static final int CHAINED_GIFT_BAG_USE_TIME = 261;
/*     */   public static final int INDIANA_ACTIVITY_CFG_ID = 271;
/*     */   public static final int INDIANA_ACTIVITY_TURN = 272;
/*     */   public static final int INDIANA_SORT_ID = 273;
/*     */   public static final int INDIANA_NUMBER = 274;
/*     */   public static final int EQUIPMENT_BLESS_LEVEL = 281;
/*     */   public static final int EQUIPMENT_BLESS_EXP = 282;
/*     */   public static final int CAKE_MAKER_ID_HIGH = 291;
/*     */   public static final int CAKE_MAKER_ID_LOW = 292;
/*     */   public static final int CAKE_ACTIVITY_ID = 293;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof ItemXStoreType)) {
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(ItemXStoreType _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\ItemXStoreType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */