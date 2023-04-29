/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPetNormalResult
/*     */   extends __SPetNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590627;
/*     */   public static final int JOIN_FIGHT_FAILED = 1;
/*     */   public static final int JOIN_FIGHT_FAILED_LIFE_TOO_LOW = 2;
/*     */   public static final int SHOW_PET_FAILED = 3;
/*     */   public static final int RENAME_PET_ILLEAGE_NAME = 4;
/*     */   public static final int RENAME_PET_FAILED = 5;
/*     */   public static final int RELEASE_PET_SUCCESS = 6;
/*     */   public static final int RELEASE_PET_FAILED = 7;
/*     */   public static final int PET_LEVEL_REACH_MAX = 8;
/*     */   public static final int PET_LIFE_REACH_MAX = 9;
/*     */   public static final int PET_GROW_REACH_MAX = 10;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590627;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int PET_REFRESH_AMULET_SUCCESS = 11;
/*     */   
/*     */   public static final int PET_HUASHENG_SUCCESS = 12;
/*     */   
/*     */   public static final int PET_DECORATE_SUCCESS = 14;
/*     */   
/*     */   public static final int PET_NEED_MORE_MONEY = 15;
/*     */   
/*     */   public static final int PET_BAG_FULL = 16;
/*     */   
/*     */   public static final int PET_SELL_TOO_MUCH = 17;
/*     */   
/*     */   public static final int PET_RENAME_SUCCESS = 18;
/*     */   
/*     */   public static final int PET_ACTION_AFTER_FIGHT = 19;
/*     */   
/*     */   public static final int CARRY_LEVEL_MORETHAN_ROLE_LEVEL = 20;
/*     */   
/*     */   public static final int PET_WILD_CANT_LIANGU = 21;
/*     */   
/*     */   public static final int PET_DECORATE_CANT_MATCH = 22;
/*     */   
/*     */   public static final int SELL_ERROR_PET_SILVER_MAX = 23;
/*     */   public static final int PET_LIANGU_MAX = 24;
/*     */   public static final int PET_LIANGU_ITEM_LIMIT = 25;
/*     */   public static final int PET_GROW_ITEM_LIMIT = 26;
/*     */   public static final int PET_COST_ITEM_ERROR = 27;
/*     */   public static final int PET_AMULET_REFRESH_MONEY_ERROR = 28;
/*     */   public static final int PET_AMULET_REFRESH_YUANBAO_NOT = 29;
/*     */   public static final int PET_REPLACE_SKILL_LEVEL_LIMIT = 30;
/*     */   public static final int PET_REPLACE_SKILL_ITEM_NOT_ENOUCH = 31;
/*     */   public static final int PET_REPLACE_SKILL_SUCCESS = 32;
/*     */   public static final int PET_RIGHT_SKILL_NOT_NEED_REPLACE_SKILL = 33;
/*     */   public static final int PET_STAGE_LEVELUP_CFG_ERROR = 34;
/*     */   public static final int PET_STAGE_LEVELUP_LEVEL_LIMIT = 35;
/*     */   public static final int PET_STAGE_LEVELUP_MAX = 36;
/*     */   public static final int PET_STAGE_LEVELUP_ITEM_NOT_ENOUCH = 37;
/*     */   public static final int PET_STAGE_LEVELUP_SUCCESS = 38;
/*     */   public static final int PET_STAGE_LEVELUP_YUANBBAO_ERROR = 39;
/*     */   public static final int PET_WILD_CAN_NOT_GET_MODEL_ITEM = 40;
/*     */   public static final int PET_GET_MODEL_COST_ITEM_NOT_ENOUGH = 41;
/*     */   public static final int PET_GET_MODEL_YUANBAO_NOT_ENOUGH = 42;
/*     */   public static final int PET_IN_FIGHT_CAN_NOT_GET_MODEL_ITEM = 43;
/*     */   public static final int PET_FIGHT_CAN_NOT_GET_MODEL_ITEM = 44;
/*     */   public static final int PET_SHOW_CAN_NOT_GET_MODEL_ITEM = 45;
/*     */   public static final int PET_GET_MODEL_ITEM_SUCCESS = 46;
/*     */   public static final int PET_WILD_CAN_NOT_USE_MODEL_ITEM = 47;
/*     */   public static final int PET_USE_MODEL_ITEM_NOT_ENOUGH = 48;
/*     */   public static final int PET_IN_FIGHT_CAN_NOT_USE_MODEL_ITEM = 49;
/*     */   public static final int PET_FIGHT_CAN_NOT_USE_MODEL_ITEM = 50;
/*     */   public static final int PET_SHOW_CAN_NOT_USE_MODEL_ITEM = 51;
/*     */   public static final int PET_USE_MODEL_ITEM_SUCCESS = 52;
/*     */   public static final int PET_NOT_HAVE_MODEL_CHANGE = 53;
/*     */   public static final int PET_CANCEL_MODEL_CHANGE_ITEM_NOT_ENOUGH = 54;
/*     */   public static final int PET_CANCEL_MODEL_CHANGE_YUANBAO_NOT_ENOUGH = 55;
/*     */   public static final int PET_IN_FIGHT_CAN_NOT_CANCEL_MODEL_CHANGE_ITEM = 56;
/*     */   public static final int PET_FIGHT_CAN_NOT_CANCEL_MODEL_CHANGE_ITEM = 57;
/*     */   public static final int PET_SHOW_CAN_NOT_CANCEL_MODEL_CHANGE_ITEM = 58;
/*     */   public static final int PET_CANCEL_MODEL_CHANGE_SUCCESS = 59;
/*     */   public static final int PET_GET_MODEL_CHANGE_YUANBAO_NOT_MATCH = 60;
/*     */   public static final int PET_CANCEL_MODEL_CHANGE_YUANBAO_NOT_MATCH = 61;
/*     */   public static final int PET_GET_MODEL_ITEM_CARRY_LEVEL_NOT_ENOUGH = 62;
/*     */   public static final int PET_GET_MODEL_ITEM_IN_CHANGE_MODEL = 63;
/*     */   public static final int PET_GET_MODEL_ITEM_COST_TYPE_ERROR = 64;
/*     */   public static final int PET_CANCEL_MODEL_CHANGE_COST_TYPE_ERROR = 65;
/*     */   public static final int PET_GET_MODEL_ITEM_FAIL = 66;
/*     */   public static final int PET_USE_MODEL_ITEM_CARRY_LEVEL_ERROR = 67;
/*     */   public static final int PET_USE_MODEL_ITEM_NOT_ALLOW = 68;
/*     */   public static final int PET_USE_MODEL_ITEM_ERROR = 69;
/*     */   public static final int PET_CANCEL_MODEL_CHANGE_CARRY_LEVEL_ERROR = 70;
/*     */   public static final int PET_GET_MODEL_CHANGE_YUANBAO_CAN_NOT_USE_YUAN_BAO = 71;
/*     */   public static final int PET_USE_MODEL_ITEM_OWN_MAX_NUM_ERROR = 72;
/*     */   public static final int PET_USE_MODEL_ITEM_OWN_ALREADY_ERROR = 73;
/*     */   public static final int ERROR_PET_HUASHENG_LEVEL = 100;
/*     */   public static final int PET_FUN_NOT_USE_IN_FIGHTING = 200;
/*     */   public static final int PET_MINMUM_GUARANTEE_CARRY_LEVEL_WRONG = 201;
/*     */   public static final int CLIENT_YUAN_BAO_NOT_SAME_WITH_SERVER_YUAN_BAO = 202;
/*     */   public static final int FU_PET_HAS_REMEMBER_SKILL_ID = 203;
/*     */   public static final int MAIN_PET_CFG_NOT_EXIST = 204;
/*     */   public static final int FU_PET_CFG_NOT_EXIST = 205;
/*     */   public static final int PET_CFG_NOT_RIGHT = 206;
/*     */   public static final int PET_HUA_SHENG_COST_CONF_NOT_EXIST = 207;
/*     */   public static final int REMOVE_HUA_SHENG_DAN_ITEM_FAIL = 208;
/*     */   public static final int HUA_SHENG_DAN_ITEM_PRICE_LESS_THAN_ZERO = 209;
/*     */   public static final int REMOVE_GUARANTEE_ITEM_FAIL = 210;
/*     */   public static final int HUA_SHENG_GUARANTEE_ITEM_PRICE_LESS_THAN_ZERO = 211;
/*     */   public static final int NOT_NEED_YUAN_BAO = 212;
/*     */   public static final int HUA_SHENG_NEED_ITEM_NOT_ENOUGH = 213;
/*     */   public static final int CUT_YUAN_BAO_FAIL = 214;
/*     */   public static final int HIGH_MINMUM_GUARANTEE_CAN_NOT_USE = 215;
/*     */   public static final int GUARANTEE_COST_ITEM_CFG_NOT_FOUND = 216;
/*     */   public static final int PET_LEVEL_SWITCH_NOT_OPEN = 217;
/*     */   public static final int CLIENT_CAL_YUAN_BAO_NOT_SAME_WITH_SERVER = 218;
/*     */   public static final int LAST_PET_IN_DEFENSE_TEAM = 300;
/*     */   public int result;
/*     */   public SPetNormalResult() {}
/*     */   
/*     */   public SPetNormalResult(int _result_)
/*     */   {
/* 130 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 134 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 138 */     _os_.marshal(this.result);
/* 139 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 143 */     this.result = _os_.unmarshal_int();
/* 144 */     if (!_validator_()) {
/* 145 */       throw new VerifyError("validator failed");
/*     */     }
/* 147 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 151 */     if (_o1_ == this) return true;
/* 152 */     if ((_o1_ instanceof SPetNormalResult)) {
/* 153 */       SPetNormalResult _o_ = (SPetNormalResult)_o1_;
/* 154 */       if (this.result != _o_.result) return false;
/* 155 */       return true;
/*     */     }
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 161 */     int _h_ = 0;
/* 162 */     _h_ += this.result;
/* 163 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 167 */     StringBuilder _sb_ = new StringBuilder();
/* 168 */     _sb_.append("(");
/* 169 */     _sb_.append(this.result).append(",");
/* 170 */     _sb_.append(")");
/* 171 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetNormalResult _o_) {
/* 175 */     if (_o_ == this) return 0;
/* 176 */     int _c_ = 0;
/* 177 */     _c_ = this.result - _o_.result;
/* 178 */     if (0 != _c_) return _c_;
/* 179 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */