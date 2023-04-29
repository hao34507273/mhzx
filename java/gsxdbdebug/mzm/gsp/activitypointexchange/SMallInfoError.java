/*    */ package mzm.gsp.activitypointexchange;
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
/*    */ public class SMallInfoError
/*    */   extends __SMallInfoError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624911;
/*    */   public static final int MALL_CLOSED = 1;
/*    */   public int errorcode;
/*    */   public int activityid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12624911;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMallInfoError() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SMallInfoError(int _errorcode_, int _activityid_)
/*    */   {
/* 37 */     this.errorcode = _errorcode_;
/* 38 */     this.activityid = _activityid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.errorcode);
/* 47 */     _os_.marshal(this.activityid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.errorcode = _os_.unmarshal_int();
/* 53 */     this.activityid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SMallInfoError)) {
/* 63 */       SMallInfoError _o_ = (SMallInfoError)_o1_;
/* 64 */       if (this.errorcode != _o_.errorcode) return false;
/* 65 */       if (this.activityid != _o_.activityid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.errorcode;
/* 74 */     _h_ += this.activityid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.errorcode).append(",");
/* 82 */     _sb_.append(this.activityid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMallInfoError _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.errorcode - _o_.errorcode;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.activityid - _o_.activityid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SMallInfoError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */