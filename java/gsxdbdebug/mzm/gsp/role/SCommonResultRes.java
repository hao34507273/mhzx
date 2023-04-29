/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SCommonResultRes extends __SCommonResultRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585985;
/*    */   public static final int RENAME_DUPLICATE = 0;
/*    */   public static final int RENAME_SENSITIVE = 1;
/*    */   public static final int RENAME_SUCCESS = 2;
/*    */   public static final int RENAME_BAN_BY_IDIP = 101;
/*    */   public static final int VIGOR_NOT_ENOUGH = 3;
/*    */   public static final int VIGOR_OUT_OF_LIMIT = 4;
/*    */   public static final int USE_VIGOR_ITEM_DAY_LIMIT = 5;
/*    */   public static final int ADD_EXP_REACH_MAX_LEVEL = 6;
/*    */   public static final int NO_MORE_CHANGE_TO_XIULIAN = 7;
/*    */   public static final int ADD_SILVER_REACH_MAX_LEVEL = 10;
/*    */   public static final int ADD_GOLD_REACH_MAX_LEVEL = 11;
/*    */   public static final int CHECK_ROLE_INFO__NOT_EXIST = 20;
/*    */   public static final int CHECK_ROLE_INFO__DIFF_SERVER = 21;
/*    */   public int result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585985;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCommonResultRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCommonResultRes(int _result_)
/*    */   {
/* 50 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 58 */     _os_.marshal(this.result);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 63 */     this.result = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SCommonResultRes)) {
/* 73 */       SCommonResultRes _o_ = (SCommonResultRes)_o1_;
/* 74 */       if (this.result != _o_.result) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.result;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.result).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCommonResultRes _o_) {
/* 95 */     if (_o_ == this) return 0;
/* 96 */     int _c_ = 0;
/* 97 */     _c_ = this.result - _o_.result;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SCommonResultRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */