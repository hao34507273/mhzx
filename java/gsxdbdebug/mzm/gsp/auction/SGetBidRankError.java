/*    */ package mzm.gsp.auction;
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
/*    */ public class SGetBidRankError
/*    */   extends __SGetBidRankError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12627211;
/*    */   public static final int SERVER_LEVEL_LOW = 1;
/*    */   public static final int ACTIVITY_CLOSE = 2;
/*    */   public int activityid;
/*    */   public int errorcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12627211;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetBidRankError() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetBidRankError(int _activityid_, int _errorcode_)
/*    */   {
/* 38 */     this.activityid = _activityid_;
/* 39 */     this.errorcode = _errorcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activityid);
/* 48 */     _os_.marshal(this.errorcode);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.activityid = _os_.unmarshal_int();
/* 54 */     this.errorcode = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SGetBidRankError)) {
/* 64 */       SGetBidRankError _o_ = (SGetBidRankError)_o1_;
/* 65 */       if (this.activityid != _o_.activityid) return false;
/* 66 */       if (this.errorcode != _o_.errorcode) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.activityid;
/* 75 */     _h_ += this.errorcode;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.activityid).append(",");
/* 83 */     _sb_.append(this.errorcode).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetBidRankError _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.activityid - _o_.activityid;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.errorcode - _o_.errorcode;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\SGetBidRankError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */