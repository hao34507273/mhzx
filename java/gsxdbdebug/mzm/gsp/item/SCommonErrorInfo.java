/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCommonErrorInfo extends __SCommonErrorInfo__ { public static final int PROTOCOL_TYPE = 12584738;
/*     */   public static final int MOVE_ITEM_UNKNOWN_ERROR = 1;
/*     */   public static final int MOVE_ITEM_CheckFlagFail = 2;
/*     */   public static final int MOVE_ITEM_ITEMNUMBER_NOT_ENOUGH = 3;
/*     */   public static final int MOVE_ITEM_STORAGE_SPACE_NOT_ENOUGH = 4;
/*     */   public static final int MOVE_ITEM_BAG_SPACE_NOT_ENOUGH = 5;
/*     */   public static final int BAG_FULL = 20;
/*     */   public static final int BAG_GRID_NOT_ENOUGH = 21;
/*     */   public static final int SPECIFIC_BAG_GRID_NOT_ENOUGH = 22;
/*     */   public static final int SPECIFIC_BAG_FULL = 23;
/*     */   public static final int REMOVE_ITEM_ITEM_NOT_ENOUGH = 40;
/*     */   public static final int ITEM_OPER_BAGID_WRONG = 99;
/*     */   public static final int ITEM_OPER_UNKNOWN_WRONG = 100;
/*     */   public static final int ITEM_OPER_WRONG_CFG = 101;
/*     */   public static final int ITEM_OPER_UUID_WRONG = 102;
/*     */   public static final int ITEM_OPER_USECOUNT_WRONG = 103;
/*     */   public static final int ITEM_OPER_BIND = 104;
/*     */   public static final int ITEM_OPER_CANNOT_GIVE = 105;
/*     */   public static final int ITEM_OPER_PROPRIETARY = 106;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12584738; }
/*     */   
/*     */ 
/*     */   public static final int EQUIP_WRONG_CFG = 300;
/*     */   
/*     */   public static final int EQUIP_REFRESH_HUN_TMP_EXTRA_PROP_EMPTY = 301;
/*     */   
/*     */   public static final int EQUIP_REFRESH_HUN_ITEM_NOT_ENOUGH = 302;
/*     */   
/*     */   public static final int EQUIP_LOCK_HUN_ALREADY_LOCKED = 350;
/*     */   
/*     */   public static final int EQUIP_LOCK_HUN_MAX_NUM_LIMIT = 351;
/*     */   
/*     */   public static final int EQUIP_LOCK_HUN_ITEM_NOT_ENOUGH = 352;
/*     */   
/*     */   public static final int EQUIP_LOCK_HUN_YUANBAO_NOT_ENOUGH = 353;
/*     */   
/*     */   public static final int EQUIP_UNLOCK_HUN_NOT_LOCKED = 370;
/*     */   
/*     */   public static final int EQUIP_QILIN_BAGID_ERROR = 400;
/*     */   
/*     */   public static final int EQUIP_QILIN_KEY_ERROR = 401;
/*     */   
/*     */   public static final int EQUIP_QILIN_CONF_ERROR = 402;
/*     */   
/*     */   public static final int EQUIP_QILIN_QILIN_CONF_ERROR = 403;
/*     */   
/*     */   public static final int EQUIP_QILIN_SILVER_NOT_ENOUGH = 404;
/*     */   
/*     */   public static final int EQUIP_QILIN_ITEM_NOT_ENOUGH = 405;
/*     */   
/*     */   public static final int EQUIP_QILIN_SUCCESSITEM_NOT_ENOUGH = 406;
/*     */   
/*     */   public static final int EQUIP_QILIN_LEVEL_ERROR = 407;
/*     */   
/*     */   public static final int EQUIP_QILIN_CAN_NOT_USE_SUCCESSITEM = 408;
/*     */   
/*     */   public static final int EQUIP_QILIN_ITEM_LEVEL_ERROR = 409;
/*     */   
/*     */   public static final int EQUIP_QILIN_YUNABO_NOT_ENOUGH = 410;
/*     */   
/*     */   public static final int EQUIP_TRANSFER_BAGID_ERROR = 430;
/*     */   public static final int EQUIP_TRANSFER_KEY_ERROR = 431;
/*     */   public static final int EQUIP_TRANSFER_HUN_KEY_ERROR = 432;
/*     */   public static final int EQUIP_TRANSFER_CONF_ERROR = 433;
/*     */   public static final int EQUIP_TRANSFER_TRAN_CONF_ERROR = 434;
/*     */   public static final int EQUIP_TRANSFER_SILVER_NOT_ENOUGH = 435;
/*     */   public static final int EQUIP_TRANSFER_ITEM_NOT_ENOUGH = 436;
/*     */   public static final int EQUIP_TRANSFER_WEAR_POS_ERROR = 437;
/*     */   public static final int EQUIP_TRANSFER_NO_HUN_ERROR = 438;
/*     */   public static final int EQUIP_TRANSFER_LEVEL_ERROR = 439;
/*     */   public static final int EQUIP_TRANSFER_REMOVE_EQUIP_ERROR = 440;
/*     */   public static final int EQUIP_TRANSFER_REPLACE_HUN_ERROR = 441;
/*     */   public static final int EQUIP_INHERIT_BAGID_ERROR = 460;
/*     */   public static final int EQUIP_INHERIT_KEY_ERROR = 461;
/*     */   public static final int EQUIP_INHERIT_CONF_ERROR = 462;
/*     */   public static final int EQUIP_INHERIT_HERI_CONF_ERROR = 463;
/*     */   public static final int EQUIP_INHERIT_SILVER_NOT_ENOUGH = 464;
/*     */   public static final int EQUIP_INHERIT_WEAR_POS_ERROR = 465;
/*     */   public static final int EQUIP_INHERIT_EQUIP_LEVEL_ERROR = 466;
/*     */   public static final int EQUIP_INHERIT_LIN_LEVEL_ERROR = 467;
/*     */   public static final int EQUIP_INHERIT_REMOVE_EQUIP_ERROR = 468;
/*     */   public static final int EQUIP_MAKE_BAG_ERROR = 490;
/*     */   public static final int EQUIP_MAKE_MAKE_CONF_ERROR = 491;
/*     */   public static final int EQUIP_MAKE_EQUIP_CONF_ERROR = 492;
/*     */   public static final int EQUIP_MAKE_ITEM_CONF_ERROR = 493;
/*     */   public static final int EQUIP_MAKE_LEVEL_ERROR = 494;
/*     */   public static final int EQUIP_MAKE_OCCUPATIONH_ERROR = 495;
/*     */   public static final int EQUIP_MAKE_GENDER_ERROR = 496;
/*     */   public static final int EQUIP_MAKE_ITEM_NOT_ENOUGH = 497;
/*     */   public static final int EQUIP_MAKE_YUANBAO_NOT_ENOUGH = 498;
/*     */   public static final int EQUIP_MAKE_FAILED = 499;
/*     */   public static final int EQUIP_UNEQUIP_BAG_ERROR = 580;
/*     */   public static final int EQUIP_UNEQUIP_KEY_ERROR = 581;
/*     */   public static final int EQUIP_UNEQUIP_BAG_FULL = 582;
/*     */   public static final int EQUIP_WEAR_BAG_ERROR = 610;
/*     */   public static final int EQUIP_WEAR_KEY_ERROR = 611;
/*     */   public static final int EQUIP_WEAR_CONF_ERROR = 612;
/*     */   public static final int EQUIP_WEAR_POS_ERROR = 613;
/*     */   public static final int EQUIP_WEAR_USEPOINT_ERROR = 614;
/*     */   public static final int EQUIP_WEAR_LEVEL_ERROR = 615;
/*     */   public static final int EQUIP_WEAR_OCCP_ERROR = 616;
/*     */   public static final int EQUIP_WEAR_SEX_ERROR = 617;
/*     */   public static final int EQUIP_WEAR_SERVER_LEVEL_ERROR = 618;
/*     */   public static final int EQUIP_FIX_BAG_ERROR = 640;
/*     */   public static final int EQUIP_FIX_KEY_ERROR = 641;
/*     */   public static final int EQUIP_FIX_SILVER_NOT_ENOUGH = 642;
/*     */   public static final int EQUIP_FIX_USEPOINT_ERROR = 643;
/*     */   public static final int ITEM_COMPOUND_BAG_ERROR = 670;
/*     */   public static final int ITEM_COMPOUND_CONF_ERROR = 671;
/*     */   public static final int ITEM_COMPOUND_GOLD_ERROR = 672;
/*     */   public static final int ITEM_COMPOUND_ITEMID_ERROR = 673;
/*     */   public static final int ITEM_COMPOUND_ITEM_NOT_ENOUGH = 674;
/*     */   public static final int ITEM_COMPOUND_SILVER_ERROR = 675;
/*     */   public static final int ITEM_COMPOUND_VIGOR_ERROR = 676;
/*     */   public static final int ITEM_COMPOUND_CAN_NOT_COMPOUND_ALL = 677;
/*     */   public static final int WING_POS_NULL = 700;
/*     */   public static final int FABAO_POS_NULL = 701;
/*     */   public static final int ITEM_GIVE_COUNT_ERROR = 730;
/*     */   public static final int ITEM_GIVE_YUANBAO_ERROR = 731;
/*     */   public static final int ITEM_GIVE_MASK_ERROR = 732;
/*     */   public static final int GIFT_BAG_ITEM_LEVEL_ERROR = 770;
/*     */   public static final int GIFT_BAG_ITEM_TIME_ERROR = 771;
/*     */   public static final int GIFT_BAG_ITEM_MONEY_ERROR = 772;
/*     */   public static final int ITEM_EXCHANGE_CONF_ERROR = 780;
/*     */   public static final int ITEM_EXCHANGE_YUANBAO_ERROR = 781;
/*     */   public static final int ITEM_EXCHANGE_ITEM_NOT_ENOUGH = 782;
/*     */   public static final int ITEM_EXCHANGE_ITEM_NOT_IN_TIME_LIMIT = 783;
/*     */   public static final int ITEM_EXCHANGE_EXCHANGE_TIME_TO_LIMIT = 784;
/*     */   public static final int ITEM_EXCHANGE_DAILY_EXCHANGE_TIME_TO_LIMIT = 785;
/*     */   public static final int DOUBLE_ITEM_USECOUNT_ERROR = 800;
/*     */   public static final int DOUBLE_ITEM_POINT_ERROR = 801;
/*     */   public static final int USE_WING_ROOT_HAS_WING = 850;
/*     */   public static final int USE_WING_ROOT_LEVEL_ERROR = 851;
/*     */   public static final int USE_WING_VIEW_MODEL_EXIST = 852;
/*     */   public static final int USE_WING_VIEW_MODEL_NUM_TO_MAX = 853;
/*     */   public static final int ALREADY_HAS_RIDDER = 900;
/*     */   public static final int NO_RIDDER = 901;
/*     */   public static final int STORAGE_NUM_TO_MAX = 1000;
/*     */   public static final int STORAGE_MONEY_NOT_ENOUGH = 1001;
/*     */   public static final int STORAGE_NAME_ERROR = 1002;
/*     */   public static final int ROLE_LEVEL_TO_MAX = 1050;
/*     */   public static final int SELL_ITEM_TO_GOLD_TO_MAX = 1100;
/*     */   public static final int SELL_ITEM_TO_SILVER_TO_MAX = 1101;
/*     */   public static final int USE_MONEY_BAG_TO_GOLD_TO_MAX = 1102;
/*     */   public static final int USE_MONEY_BAG_TO_SILVER_TO_MAX = 1103;
/*     */   public static final int USE_MONEY_BAG_TO_BANGGONG_TO_MAX = 1104;
/*     */   public static final int ITEM_TO_CARRY_MAX = 1105;
/*     */   public static final int ITEM_YUAN_BAO_PRICE = 1106;
/*     */   public static final int MOSHOU_FRAGMENT_ITEM_NUN_ERROR = 1130;
/*     */   public static final int MOSHOU_EXCAHNGE_COUNT_ERROR = 1131;
/*     */   public static final int HOMELAND_CAT_EXPLORE_STATE = 1150;
/*     */   public static final int HOMELAND_CAT_RESET_STATE = 1151;
/*     */   public static final int HOMELAND_CAT_AWARD_NOT_RECEIVED = 1152;
/*     */   public static final int HOMELAND_CAT_MAX = 1153;
/*     */   public static final int HOMELAND_NOT_EXIST = 1154;
/*     */   public static final int CAT_ITEM_LEVEL_LIMIT = 1155;
/*     */   public static final int EXCHANGE_ITEM_NEED_YUANBAO_COUNT_EEEOR = 1156;
/*     */   public static final int ACCUMULATION_NEED_YUANBAO_ERROR = 1170;
/*     */   public static final int ACCUMULATION_QILIN_ITEM_USE_COUNT_TO_MAX = 1171;
/*     */   public static final int QILIN_NOT_RISK_MODE = 1173;
/*     */   public static final int QILIN_NOT_ACCUMULATION_MODE = 1174;
/*     */   public static final int ROLE_HAS_ITEM_CAN_NOT_USE_YUANBAO = 1175;
/*     */   public static final int EQUIP_LEVEL_IS_TOO_LOW = 1176;
/*     */   public static final int EQUIP_MAX_LIN_LEVEL_ERROR = 1177;
/*     */   public static final int USE_GIFT_BAG_ERROR_MONEY_TO_MAX = 1178;
/*     */   public static final int NOT_CLICK_REMOVE_ITEM = 1179;
/*     */   public static final int ITEM_LEFT_PROPERTY_NOT_ZERO = 1180;
/*     */   public static final int GENIUS_STONE_ITEM_USE_LEVEL_LIMIT = 1190;
/*     */   public static final int GENIUS_FUN_LEVEL_LIMIT = 1191;
/*     */   public static final int GENIUS_STONE_ITEM_USE_MAX = 1192;
/*     */   public static final int EMBRY0_ITEM_ANIMAL_MAX = 1193;
/*     */   public static final int CHAINED_GIFT_BAG_INVALID_USE_TIME = 1194;
/*     */   public static final int CANNOT_SPLIT = 1195;
/*     */   public static final int CANNOT_SPLIT_ALL = 1196;
/*     */   public static final int CANNOT_SPLIT_BIND = 1197;
/*     */   public static final int SPLIT_INSUFFICIENT_SILVER = 1198;
/*     */   public static final int SPLIT_INSUFFICIENT_GOLD = 1199;
/*     */   public static final int SPLIT_INSUFFICIENT_VIGOR = 1200;
/*     */   public static final int USE_ITEM_FAIL_LEVEL_NOT_MATCH = 1210;
/*     */   public int errorcode;
/*     */   public java.util.ArrayList<String> params;
/*     */   public SCommonErrorInfo()
/*     */   {
/* 191 */     this.params = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SCommonErrorInfo(int _errorcode_, java.util.ArrayList<String> _params_) {
/* 195 */     this.errorcode = _errorcode_;
/* 196 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 200 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 204 */     _os_.marshal(this.errorcode);
/* 205 */     _os_.compact_uint32(this.params.size());
/* 206 */     for (String _v_ : this.params) {
/* 207 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/* 209 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 213 */     this.errorcode = _os_.unmarshal_int();
/* 214 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 216 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 217 */       this.params.add(_v_);
/*     */     }
/* 219 */     if (!_validator_()) {
/* 220 */       throw new VerifyError("validator failed");
/*     */     }
/* 222 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 226 */     if (_o1_ == this) return true;
/* 227 */     if ((_o1_ instanceof SCommonErrorInfo)) {
/* 228 */       SCommonErrorInfo _o_ = (SCommonErrorInfo)_o1_;
/* 229 */       if (this.errorcode != _o_.errorcode) return false;
/* 230 */       if (!this.params.equals(_o_.params)) return false;
/* 231 */       return true;
/*     */     }
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 237 */     int _h_ = 0;
/* 238 */     _h_ += this.errorcode;
/* 239 */     _h_ += this.params.hashCode();
/* 240 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.errorcode).append(",");
/* 247 */     _sb_.append(this.params).append(",");
/* 248 */     _sb_.append(")");
/* 249 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SCommonErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */