/*    */ package mzm.gsp.grc;
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
/*    */ public class SGetGrcFriendsCountAwardFailed
/*    */   extends __SGetGrcFriendsCountAwardFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600333;
/*    */   public static final int ERR_SERIAL_NO_INVALID = -1;
/*    */   public static final int ERR_FRIENDS_COUNT_NOT_MEET = -2;
/*    */   public static final int ERR_AWARD_FAILED = -3;
/*    */   public int retcode;
/*    */   public int award_serial_no;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600333;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetGrcFriendsCountAwardFailed()
/*    */   {
/* 38 */     this.award_serial_no = 0;
/*    */   }
/*    */   
/*    */   public SGetGrcFriendsCountAwardFailed(int _retcode_, int _award_serial_no_) {
/* 42 */     this.retcode = _retcode_;
/* 43 */     this.award_serial_no = _award_serial_no_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     _os_.marshal(this.award_serial_no);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     this.award_serial_no = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGetGrcFriendsCountAwardFailed)) {
/* 68 */       SGetGrcFriendsCountAwardFailed _o_ = (SGetGrcFriendsCountAwardFailed)_o1_;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       if (this.award_serial_no != _o_.award_serial_no) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.retcode;
/* 79 */     _h_ += this.award_serial_no;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append(this.award_serial_no).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetGrcFriendsCountAwardFailed _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.retcode - _o_.retcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.award_serial_no - _o_.award_serial_no;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetGrcFriendsCountAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */