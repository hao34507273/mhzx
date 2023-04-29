/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SReturnNotify
/*    */   extends __SReturnNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616743;
/*    */   public static final int REASON_ACTIVE = 0;
/*    */   public static final int REASON_LACK_ACTION_POINT = 1;
/*    */   public static final int REASON_MAP_ROLE_DESTROY = 2;
/*    */   public static final int REASON_LOSE = 3;
/*    */   public static final int REASON_TREASURE = 4;
/*    */   public static final int REASON_FORCE_END = 5;
/*    */   public static final int REASON_WINNER_ACTIVE = 6;
/*    */   public int reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616743;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SReturnNotify() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SReturnNotify(int _reason_)
/*    */   {
/* 44 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.reason);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.reason = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SReturnNotify)) {
/* 67 */       SReturnNotify _o_ = (SReturnNotify)_o1_;
/* 68 */       if (this.reason != _o_.reason) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.reason;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.reason).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SReturnNotify _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.reason - _o_.reason;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SReturnNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */