/*    */ package mzm.gsp.bigboss;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SErrorInfo
/*    */   extends __SErrorInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598022;
/*    */   public static final int CHANLLENGE_COUNT_NOT_ENOUGH = 1;
/*    */   public static final int YUANBAO_NOT_ENOUGH = 2;
/*    */   public static final int ROLE_LEVLE_ERROR = 3;
/*    */   public static final int ROLE_IN_TEAM = 4;
/*    */   public static final int ACTIVITY_NOT_OPEN = 5;
/*    */   public static final int BUY_COUNT_TO_MAX = 6;
/*    */   public static final int ACTIVITY_FINISHED = 7;
/*    */   public static final int CHANLLENGE_COUNT_ERROR = 8;
/*    */   public int errorcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598022;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SErrorInfo() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SErrorInfo(int _errorcode_)
/*    */   {
/* 45 */     this.errorcode = _errorcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.errorcode);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.errorcode = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SErrorInfo)) {
/* 68 */       SErrorInfo _o_ = (SErrorInfo)_o1_;
/* 69 */       if (this.errorcode != _o_.errorcode) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.errorcode;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.errorcode).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SErrorInfo _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.errorcode - _o_.errorcode;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */