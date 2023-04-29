/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SLongjingPropertyTransferErrorRes
/*    */   extends __SLongjingPropertyTransferErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596036;
/*    */   public static final int ERROR_UNKNOWN = 0;
/*    */   public static final int ERROR_COUNT_ERROR = 1;
/*    */   public static final int ERROR_ITEMID_NOT_EXSIT = 2;
/*    */   public static final int ERROR_PROPERTY_NOT_EXSIT = 3;
/*    */   public static final int ERROR_GOLD_TO_MAX = 4;
/*    */   public static final int ERROR_GOLD_NOT_ENOUGH = 5;
/*    */   public static final int ERROR_LEVEL_NOT_SAME = 6;
/*    */   public int resultcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596036;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SLongjingPropertyTransferErrorRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SLongjingPropertyTransferErrorRes(int _resultcode_)
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
/* 66 */     if ((_o1_ instanceof SLongjingPropertyTransferErrorRes)) {
/* 67 */       SLongjingPropertyTransferErrorRes _o_ = (SLongjingPropertyTransferErrorRes)_o1_;
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
/*    */   public int compareTo(SLongjingPropertyTransferErrorRes _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.resultcode - _o_.resultcode;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SLongjingPropertyTransferErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */