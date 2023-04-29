/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChildNormalFail
/*     */   extends __SChildNormalFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609328;
/*     */   public static final int ERROR_NOT_CONTAINS_THE_CHILDREN = 1;
/*     */   public static final int ERROR_CHILDREN_NOT_EXIST = 2;
/*     */   public static final int ERROR_CHILDREN_NOT_IN_HOME = 3;
/*     */   public static final int ERROR_CHILDREN_INFO_NULL = 4;
/*     */   public static final int ERROR_CHILDREN_NOT_IN_BAG = 5;
/*     */   public static final int ERROR_CHILDREN_ALEARDY_IN_HOME = 6;
/*     */   public static final int ERROR_CHILDREN_PERIOD_WRONG = 7;
/*     */   public static final int ERROR_CHILDREN_CHOSE_OWNER_SIZE_FULL = 8;
/*     */   public static final int ERROR_CHILDREN_OPERATOR_NOT_IN_HOME = 9;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609328;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ERROR_CHILDREN_NOT_HAS_HOME = 10;
/*     */   
/*     */   public static final int ERROR_CHILDREN_NPC_SERVICE_NOT_USE = 11;
/*     */   
/*     */   public static final int ERROR_CHILDREN_NOT_MARRAY = 12;
/*     */   
/*     */   public static final int ERROR_CHILDREN_TEAM_NOT_EXIST = 13;
/*     */   
/*     */   public static final int ERROR_CHILDREN_TEAM_SIZE_NOT_RIGHT = 14;
/*     */   
/*     */   public static final int ERROR_CHILDREN_TEAM_LEADER_WRONG = 15;
/*     */   
/*     */   public static final int ERROR_CHILDREN_TEAM_MEMBER_WRONG = 16;
/*     */   
/*     */   public static final int ERROR_CHILDREN_BELONG_WRONG = 17;
/*     */   
/*     */   public static final int ERROR_CHILDREN_LEADER_NOT_AT_HOME = 18;
/*     */   
/*     */   public static final int ERROR_CHILDREN_MEMBER_NOT_AT_HOME = 19;
/*     */   
/*     */   public static final int ERROR_CHILDREN_NOT_CHUANG = 20;
/*     */   public static final int ERROR_CHILDREN_LEVEL_NOT_ENOUGH = 21;
/*     */   public static final int ERROR_CHILDREN_NOT_COUPLE = 22;
/*     */   public static final int ERROR_CHILDREN_LEADER_STATE = 23;
/*     */   public static final int ERROR_CHILDREN_LEADER_STEP = 24;
/*     */   public static final int ERROR_CHILDREN_PARTNER_STATE = 25;
/*     */   public static final int ERROR_CHILDREN_PARTNER_STEP = 26;
/*     */   public static final int ERROR_CHILDREN_SIZE_FULL = 27;
/*     */   public static final int ERROR_CHILDREN_HAS_COUTPLE_BREED = 28;
/*     */   public static final int ERROR_CHILDREN_GIVE_BIRTH_STATE_WRONG = 29;
/*     */   public static final int ERROR_CHILDREN_GIVE_BIRTH_STEP_WRONG = 30;
/*     */   public static final int ERROR_CHILDREN_QUERY_MARRIAGE_EMPTY = 31;
/*     */   public static final int ERROR_CHILDREN_SESSION_CONTEXT_NOT_MATCH = 32;
/*     */   public static final int ERROR_CHILDREN_NOT_BABY = 33;
/*     */   public static final int ERROR_CHILDREN_HEALTH_VALUE_NOT_ENOUGH = 34;
/*     */   public static final int ERROR_CHILDREN_DIARY_NOT_FOUND = 35;
/*     */   public static final int ERROR_CHILDREN_CAN_NOT_BREED = 36;
/*     */   public static final int ERROR_CHILDREN_BAG_ALEARDY_HAS_THE_KID = 37;
/*     */   public static final int ERROR_CHILDREN_NAME_LENGTH_NOT_RIGHT = 38;
/*     */   public static final int ERROR_CHILDREN_NAME_SENSITIVE = 39;
/*     */   public static final int ERROR_CHILDREN_NAME_STRING_NOT_USE = 40;
/*     */   public static final int ERROR_CHILDREN_NAME_CAN_NOT_ONLY_NUMBER = 41;
/*     */   public static final int ERROR_CHILDREN_CHANGE_NAME_CUT_GOLD_FAIL = 42;
/*     */   public static final int ERROR_CHILDREN_NO_NEED_GIVE_UP_BREED = 43;
/*     */   public static final int ERROR_CHILDREN_GIVE_UP_ERROR = 44;
/*     */   public static final int ERROR_CHILDREN_ALEARDY_BREED = 45;
/*     */   public static final int ERROR_CHILDREN_TIRED_FULL = 46;
/*     */   public static final int ERROR_CHILDREN_BREED_CFG_NOT_EXIST = 47;
/*     */   public static final int ERROR_CHILDREN_BREED_COST_CUT_FAIL = 48;
/*     */   public static final int ERROR_CHILDREN_BABY_CARRY_MAX = 49;
/*     */   public static final int ERROR_CHILDREN_STATE_NOT_SLEEP = 50;
/*     */   public static final int ERROR_CHILDREN_STATE_IN_FIGHT = 51;
/*     */   public static final int ERROR_CHILDREN_CARRY_ROLE_ID = 52;
/*     */   public static final int ERROR_CHILDREN_HOME_STATE = 53;
/*     */   public static final int ERROR_CHILDREN_POSITION_ERROR = 54;
/*     */   public static final int ERROR_USER_NOT_FOUND = 55;
/*     */   public static final int ERROR_UUID_NOT_FOUND = 56;
/*     */   public static final int ERROR_ITEM_NOT_CHILDREN_COMPENSATE = 57;
/*     */   public static final int ERROR_CHILDREN_COMPENSATE_CFG_NOT_EXIST = 58;
/*     */   public static final int ERROR_CAN_NOT_OWN_MORE_CHILDREN = 59;
/*     */   public static final int ERROR_GIVE_BIRTH_TIME_POINT_CFG_NOT_EXIST = 60;
/*     */   public static final int AUTO_BREED_BABY__LACK_YUANBAO = 61;
/*     */   public static final int AUTO_BREED_BABY__NO_NEED = 62;
/*     */   public static final int AUTO_BREED_BABY__YUANBAO_DIFF = 63;
/*     */   public static final int AUTO_BREED_BABY__ALREADY = 64;
/*     */   public static final int ERROR_CHILDHOOD_TIME_POINT_CFG_NOT_EXIST = 65;
/*     */   public static final int ERROR_ADULTHOOD_TIME_POINT_CFG_NOT_EXIST = 66;
/*     */   public static final int ERROR_ANOTHER_PARENT_ROLE_ID_ERROR = 67;
/*     */   public static final int ERROR_PET_AMULET_CFG_ID_ERROR = 68;
/*     */   public static final int ERROR_PET_NOT_AMULET_ERROR = 69;
/*     */   public static final int ERROR_DEL_ITEM_ERROR = 70;
/*     */   public static final int ERROR_CAN_NOT_DO_THIS = 71;
/*     */   public static final int ERROR_CHILD_IN_WELFARE_CAN_NOT_DO_THIS = 72;
/*     */   public static final int ERROR_CHILD_RECALL_CFG_NOT_EXIST = 73;
/*     */   public static final int ERROR_CHILD_RECALL_CURRENCY_NOT_ENOUGH = 74;
/*     */   public static final int ERROR_CHILD_RECALL_CUT_CURRENCY = 75;
/*     */   public static final int ERROR_CHILD_RECALL_CLIENT_CURRENCY_NOT_SAME_SERVER = 76;
/*     */   public static final int ERROR_CHILD_RECALL_CURRENCY_TYPE_NOT_SUPPORT = 77;
/*     */   public static final int ERROR_CHILD_RECALL_NPC_SERVICE_NOT_SUPPORT = 78;
/*     */   public static final int ERROR_CHILD_NOT_IN_WELFARE = 79;
/*     */   public static final int ERROR_CHILD_RECALL_NOT_OPEN = 80;
/*     */   public static final int ERROR_CHILD_RECALL_TIMES_NOT_LEFT = 81;
/*     */   public int result;
/*     */   public SChildNormalFail() {}
/*     */   
/*     */   public SChildNormalFail(int _result_)
/*     */   {
/* 118 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 126 */     _os_.marshal(this.result);
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 131 */     this.result = _os_.unmarshal_int();
/* 132 */     if (!_validator_()) {
/* 133 */       throw new VerifyError("validator failed");
/*     */     }
/* 135 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 139 */     if (_o1_ == this) return true;
/* 140 */     if ((_o1_ instanceof SChildNormalFail)) {
/* 141 */       SChildNormalFail _o_ = (SChildNormalFail)_o1_;
/* 142 */       if (this.result != _o_.result) return false;
/* 143 */       return true;
/*     */     }
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 149 */     int _h_ = 0;
/* 150 */     _h_ += this.result;
/* 151 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 155 */     StringBuilder _sb_ = new StringBuilder();
/* 156 */     _sb_.append("(");
/* 157 */     _sb_.append(this.result).append(",");
/* 158 */     _sb_.append(")");
/* 159 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChildNormalFail _o_) {
/* 163 */     if (_o_ == this) return 0;
/* 164 */     int _c_ = 0;
/* 165 */     _c_ = this.result - _o_.result;
/* 166 */     if (0 != _c_) return _c_;
/* 167 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */