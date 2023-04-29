/*    */ package mzm.gsp.bandstand;
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
/*    */ 
/*    */ public class SStartBandstandFail
/*    */   extends __SStartBandstandFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627974;
/*    */   public static final int ACTIVITY_NOT_OPEN = 1;
/*    */   public static final int ACTIVITY_TYPE_ERROR = 2;
/*    */   public static final int ALREADY_STARTED = 3;
/*    */   public static final int NPC_SERVICE_NOT_AVAILABLE = 4;
/*    */   public int error_code;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12627974;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStartBandstandFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStartBandstandFail(int _error_code_)
/*    */   {
/* 41 */     this.error_code = _error_code_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.error_code);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.error_code = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SStartBandstandFail)) {
/* 64 */       SStartBandstandFail _o_ = (SStartBandstandFail)_o1_;
/* 65 */       if (this.error_code != _o_.error_code) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.error_code;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.error_code).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SStartBandstandFail _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.error_code - _o_.error_code;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\SStartBandstandFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */