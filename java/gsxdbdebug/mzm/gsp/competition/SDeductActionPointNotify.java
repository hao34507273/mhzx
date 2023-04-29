/*    */ package mzm.gsp.competition;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SDeductActionPointNotify
/*    */   extends __SDeductActionPointNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598547;
/*    */   public static final int REASON__ENTER_LATER = 1;
/*    */   public static final int REASON__ATTACK = 2;
/*    */   public static final int REASON__LOSE_FIGHT = 3;
/*    */   public static final int REASON__ESCAPE_FIGHT = 4;
/*    */   public int deduct_value;
/*    */   public int reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598547;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SDeductActionPointNotify() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SDeductActionPointNotify(int _deduct_value_, int _reason_)
/*    */   {
/* 42 */     this.deduct_value = _deduct_value_;
/* 43 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.deduct_value);
/* 52 */     _os_.marshal(this.reason);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.deduct_value = _os_.unmarshal_int();
/* 58 */     this.reason = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SDeductActionPointNotify)) {
/* 68 */       SDeductActionPointNotify _o_ = (SDeductActionPointNotify)_o1_;
/* 69 */       if (this.deduct_value != _o_.deduct_value) return false;
/* 70 */       if (this.reason != _o_.reason) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.deduct_value;
/* 79 */     _h_ += this.reason;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.deduct_value).append(",");
/* 87 */     _sb_.append(this.reason).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SDeductActionPointNotify _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.deduct_value - _o_.deduct_value;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.reason - _o_.reason;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SDeductActionPointNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */