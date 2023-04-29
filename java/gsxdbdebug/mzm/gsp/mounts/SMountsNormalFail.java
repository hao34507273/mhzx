/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMountsNormalFail
/*     */   extends __SMountsNormalFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606228;
/*     */   public static final int MOUNTS_PET_NOT_BATTLE = 1;
/*     */   public static final int MOUNTS_ROLE_INFO_NULL = 2;
/*     */   public static final int MOUNTS_BATTLE_CELL_EMPTY = 3;
/*     */   public static final int MOUNTS_NOT_EXIST = 4;
/*     */   public static final int MOUNTS_PASSIVE_SKILL_NOT_EXIST = 5;
/*     */   public static final int MOUNTS_PASSIVE_SKILL_RANK_NOT_EXIST = 6;
/*     */   public static final int PET_NOT_IN_BAG = 7;
/*     */   public static final int PET_ALEARDY_BE_PROTECTED = 8;
/*     */   public static final int PROTECT_PET_NUM_LIMIT = 9;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606228;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int NO_MOUNTS_ON_CELL = 10;
/*     */   
/*     */   public static final int NO_MOUNTS_RIDE = 11;
/*     */   
/*     */   public static final int NO_MOUNTS_BATTLE_CELL = 12;
/*     */   
/*     */   public static final int MOUNTS_BATTLE_CELL_NOT_OPEN = 13;
/*     */   
/*     */   public static final int MOUNTS_BATTLE_CELL_NOT_EMPTY = 14;
/*     */   
/*     */   public static final int MOUNTS_DYE_COLOR_NOT_EXIST = 15;
/*     */   
/*     */   public static final int MOUNTS_DYE_COLOR_SAME = 16;
/*     */   
/*     */   public static final int MOUNTS_NOT_CONTAIN_DYE = 17;
/*     */   
/*     */   public static final int MOUNTS_YUAN_BAO_NOT_SAME = 18;
/*     */   
/*     */   public static final int MOUNTS_CUT_YUAN_BAO_FAIL = 19;
/*     */   
/*     */   public static final int MOUNTS_REMOVE_ITEM_FAIL = 20;
/*     */   public static final int MOUNTS_NUM_LIMIT = 21;
/*     */   public static final int MOUNTS_RIDE_REPEAT = 22;
/*     */   public static final int MOUNTS_BATTLE_TYPE_REPEAT = 23;
/*     */   public static final int MOUNTS_CFG_NOT_EXIST = 24;
/*     */   public static final int MOUNTS_NOT_STAR_CFG = 25;
/*     */   public static final int MOUNTS_NOT_STAR_LEVEL_CFG = 26;
/*     */   public static final int MOUNTS_STAR_LIFE_FULL = 27;
/*     */   public static final int MOUNTS_NOT_STAR_LIFE_NUM = 28;
/*     */   public static final int MOUNTS_STAR_NUM_NOT_UNLOCK = 29;
/*     */   public static final int ITEM_CAN_NOT_UNLOCK_MOUNTS = 30;
/*     */   public static final int ITEM_NUM_NOT_ENOUGH = 31;
/*     */   public static final int MOUNTS_STAR_LIFE_UNLOCK_NOT_EXIST = 32;
/*     */   public static final int MOUNTS_STAR_NUM_UNLOCK_NOT_EXIST = 33;
/*     */   public static final int MOUNTS_CAN_NOT_REFRESH_PASSIVE_SKILL = 34;
/*     */   public static final int BE_REPLACE_PASSIVE_SKILL_NOT_EXIST = 35;
/*     */   public static final int NO_PASSIVE_SKILL_CAN_REPLACE = 36;
/*     */   public static final int RANK_UP_CAN_NOT_COST_SELF = 37;
/*     */   public static final int RANK_UP_CAN_NOT_COST_BATTLE = 38;
/*     */   public static final int RANK_UP_CAN_NOT_COST_RIDE = 39;
/*     */   public static final int RANK_UP_MAIL_ITEM_FAIL = 40;
/*     */   public static final int RANK_UP_MAX = 41;
/*     */   public static final int RANK_UP_MATERIAL_NOT_EXIST = 42;
/*     */   public static final int RANK_UP_MATERIAL_TYPE_NOT_MATCH = 43;
/*     */   public static final int RANK_UP_MATERIAL_CFG_NOT_EXIST = 44;
/*     */   public static final int RANK_UP_MATERIAL_NUM_NOT_ENOUGH = 45;
/*     */   public static final int APPEARENCE_MOUNTS_CAN_NOT_BATTLE = 46;
/*     */   public static final int NEED_YUAN_BAO_NOT_SAME = 47;
/*     */   public static final int ITEM_ENOUGH_AND_YUAN_BAO_ON = 48;
/*     */   public static final int PASSIVE_SKILL_NOT_ENOUGH = 49;
/*     */   public static final int PASSIVE_SKILL_CAT_NOT_REFRESH = 50;
/*     */   public static final int MATERIAL_MOUNTS_RANK_NOT_MATCH = 51;
/*     */   public static final int ONLE_APPEARENCE_MOUNTS_CAN_EXTEND_TIME = 52;
/*     */   public static final int NO_MOUNTS_CAN_EXTEND_TIME = 53;
/*     */   public static final int MOUNTS_ALEARDY_FOREVER = 54;
/*     */   public static final int MOUNTS_ALEARDY_HAS = 55;
/*     */   public static final int RANK_UP_MATERIAL_NUM_TOO_MANY = 56;
/*     */   public static final int ROLE_LEVEL_NOT_ENOUGH = 57;
/*     */   public static final int SCORE_MATERIAL_CFG_NOT_EXIST = 58;
/*     */   public static final int ADD_SCORE_CFG_NOT_EXIST = 59;
/*     */   public static final int SCORE_ENOUGH = 60;
/*     */   public static final int SCORE_NOT_ENOUGH = 61;
/*     */   public static final int CHIP_ITEM_ID_NOT_EXIST = 62;
/*     */   public static final int APPEARENCE_MOUNTS_CAN_NOT_RANK_UP = 63;
/*     */   public static final int MOUNTS_ALEARDY_BATTLE = 64;
/*     */   public static final int MOUNTS_STAR_LIFE_MAILL_FAIL = 65;
/*     */   public static final int MOUNTS_BATTLE_CELL_WRONG = 66;
/*     */   public static final int CAN_NOT_SET_RIDE_STATUS = 67;
/*     */   public static final int NOT_ITEM = 68;
/*     */   public static final int SELECT_ORNAMENT_RANK_WRONG = 69;
/*     */   public static final int EXPAND_PROTECT_PET_INDEX_ERROR = 70;
/*     */   public static final int EXPAND_PROTECT_PET_SIZE_MAX = 71;
/*     */   public static final int EXPAND_PROTECT_PET_INDEX_HAS_PET = 72;
/*     */   public static final int EXPAND_PROTECT_PET_RANK_NOT_ENOUGH = 73;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_NOT_IN_TEAM = 74;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_NOT_EXIST = 75;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_LEADER_NOT_RIDE = 76;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_NO_POSITION = 77;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_ALREADY_RIDE = 78;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_IS_LEADER = 79;
/*     */   public static final int UNRIDE_MULTI_ROLE_MOUNTS_NOT_IN_TEAM = 80;
/*     */   public static final int UNRIDE_MULTI_ROLE_MOUNTS_NOT_EXIST = 81;
/*     */   public static final int UNRIDE_MULTI_ROLE_MOUNTS_LEADER_NOT_RIDE = 82;
/*     */   public static final int UNRIDE_MULTI_ROLE_MOUNTS_ALREADY_UNRIDE = 83;
/*     */   public static final int UNRIDE_MULTI_ROLE_MOUNTS_IS_LEADER = 84;
/*     */   public static final int RIDE_MULTI_ROLE_MOUNTS_STATE_NOT_NORMAL = 85;
/*     */   public int result;
/*     */   public SMountsNormalFail() {}
/*     */   
/*     */   public SMountsNormalFail(int _result_)
/*     */   {
/* 122 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 130 */     _os_.marshal(this.result);
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 135 */     this.result = _os_.unmarshal_int();
/* 136 */     if (!_validator_()) {
/* 137 */       throw new VerifyError("validator failed");
/*     */     }
/* 139 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 143 */     if (_o1_ == this) return true;
/* 144 */     if ((_o1_ instanceof SMountsNormalFail)) {
/* 145 */       SMountsNormalFail _o_ = (SMountsNormalFail)_o1_;
/* 146 */       if (this.result != _o_.result) return false;
/* 147 */       return true;
/*     */     }
/* 149 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 153 */     int _h_ = 0;
/* 154 */     _h_ += this.result;
/* 155 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 159 */     StringBuilder _sb_ = new StringBuilder();
/* 160 */     _sb_.append("(");
/* 161 */     _sb_.append(this.result).append(",");
/* 162 */     _sb_.append(")");
/* 163 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMountsNormalFail _o_) {
/* 167 */     if (_o_ == this) return 0;
/* 168 */     int _c_ = 0;
/* 169 */     _c_ = this.result - _o_.result;
/* 170 */     if (0 != _c_) return _c_;
/* 171 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */