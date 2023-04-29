/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCrossBattleHistoryNormalRes extends __SCrossBattleHistoryNormalRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617089;
/*     */   public static final int TIME_LIMIT = 1;
/*     */   public static final int FUNCTION_NOT_OPEN = 2;
/*     */   public static final int ACTIVITY_DB_DATA_NOT_EXIST = 3;
/*     */   public static final int FINAL_DB_DATA_NOT_EXIST = 4;
/*     */   public static final int FIGHT_ZONE_DB_DATA_NOT_EXIST = 5;
/*     */   public static final int ACTIVITY_CFG_DATA_NOT_EXIST = 6;
/*     */   public static final int FINAL_CFG_DATA_NOT_EXIST = 7;
/*     */   public static final int PARAM_SESSION_ERROR = 8;
/*     */   public static final int HISTORY_CFG_NOT_EXIST = 9;
/*     */   public static final int GET_FINAL_STAGE_ERROR = 10;
/*     */   public static final int GRC_SEND_ERROR = 11;
/*     */   public static final int GRC_GET_DATA_ERROR = 12;
/*     */   public static final int GET_KNOCK_OUT_HANDLER_ERROR = 13;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617089;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int CAN_NOT_QUERY_FINAL_ERROR = 15;
/*     */   
/*     */   public static final int NOT_FINAL_LAST_ROUND_ERROR = 16;
/*     */   
/*     */   public static final int CHAMPION_NOT_OUT_ERROR = 17;
/*     */   
/*     */   public static final int CHAMPION_STAGE_DATA_NOT_FOUND_ERROR = 18;
/*     */   
/*     */   public static final int CHAMPION_FIGHT_AGAINST_DATA_NOT_FOUND_ERROR = 19;
/*     */   
/*     */   public static final int THIRD_PLACE_STAGE_DATA_NOT_FOUND_ERROR = 20;
/*     */   
/*     */   public static final int THRID_PLACE_FIGHT_AGAINST_DATA_NOT_FOUND_ERROR = 21;
/*     */   
/*     */   public static final int RANK_DATA_ERROR = 22;
/*     */   
/*     */   public static final int NO_CHAMPION_ERROR = 23;
/*     */   
/*     */   public static final int CORPS_ID_NO_CHAMPION_ERROR = 24;
/*     */   
/*     */   public static final int CORPS_ID_NO_SECOND_PLACE_ERROR = 25;
/*     */   
/*     */   public static final int CORPS_ID_NO_THIRD_PLACE_ERROR = 26;
/*     */   
/*     */   public static final int LAST_SESSION_CFG_NOT_FOUND_ERROR = 27;
/*     */   
/*     */   public int ret;
/*     */   
/*     */   public SCrossBattleHistoryNormalRes() {}
/*     */   
/*     */   public SCrossBattleHistoryNormalRes(int _ret_)
/*     */   {
/*  63 */     this.ret = _ret_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  71 */     _os_.marshal(this.ret);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.ret = _os_.unmarshal_int();
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SCrossBattleHistoryNormalRes)) {
/*  86 */       SCrossBattleHistoryNormalRes _o_ = (SCrossBattleHistoryNormalRes)_o1_;
/*  87 */       if (this.ret != _o_.ret) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.ret;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.ret).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCrossBattleHistoryNormalRes _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.ret - _o_.ret;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SCrossBattleHistoryNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */