/*    */ package mzm.gsp.christmasstocking;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SHangStockingFail extends __SHangStockingFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12629507;
/*    */   public static final int CAN_NOT_JOIN_ACTIVITY = -1;
/*    */   public static final int TARGET_ROLE_NOT_JOIN_ACTIVITY = -2;
/*    */   public static final int NOT_IN_HOMELAND_OF_TARGET_ROLE = -3;
/*    */   public static final int INVALID_POSITION = -4;
/*    */   public static final int POSITION_NOT_EMPTY = -5;
/*    */   public static final int ITEM_NOT_ENOUGH = -6;
/*    */   public static final int REMAIN_HANG_ON_ONE_TREE_NUM_NOT_ENOUGH = -7;
/*    */   public static final int REMAIN_ROLE_HANG_NUM_NOT_ENOUGH = -8;
/*    */   public static final int TARGET_ROLE_NOT_EXIST = -9;
/*    */   public static final int REMAIN_SELF_HANG_NUM_NOT_ENOUGH = -10;
/*    */   public static final int REMAIN_OTHERS_HANG_NUM_NOT_ENOUGH = -11;
/*    */   public static final int REMAIN_HANG_FOR_OTHERS_NUM_NOT_ENOUGH = -12;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12629507;
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
/*    */   public SHangStockingFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SHangStockingFail(int _error_code_)
/*    */   {
/* 49 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 57 */     _os_.marshal(this.error_code);
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.error_code = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SHangStockingFail)) {
/* 72 */       SHangStockingFail _o_ = (SHangStockingFail)_o1_;
/* 73 */       if (this.error_code != _o_.error_code) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.error_code;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.error_code).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SHangStockingFail _o_) {
/* 94 */     if (_o_ == this) return 0;
/* 95 */     int _c_ = 0;
/* 96 */     _c_ = this.error_code - _o_.error_code;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\SHangStockingFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */