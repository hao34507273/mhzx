/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChangeSwornNameRes
/*    */   extends __SChangeSwornNameRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597801;
/*    */   public static final int SUCCESS = 0;
/*    */   public static final int ERROR_UNKNOWN = 1;
/*    */   public static final int ERROR_NAME = 2;
/*    */   public static final int ERROR_SILVER_NOT_ENOUGH = 3;
/*    */   public static final int ERROR_NOT_SWORN = 4;
/*    */   public static final int ERROR_VOTEING = 5;
/*    */   public static final int ERROR_NOT_AGREE = 6;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12597801;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChangeSwornNameRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChangeSwornNameRes(int _resultcode_)
/*    */   {
/* 44 */     this.resultcode = _resultcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.resultcode);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.resultcode = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SChangeSwornNameRes)) {
/* 67 */       SChangeSwornNameRes _o_ = (SChangeSwornNameRes)_o1_;
/* 68 */       if (this.resultcode != _o_.resultcode) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.resultcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.resultcode).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChangeSwornNameRes _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.resultcode - _o_.resultcode;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SChangeSwornNameRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */