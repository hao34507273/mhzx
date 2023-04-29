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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncGrcFriendsCountAwardInfo
/*    */   extends __SSyncGrcFriendsCountAwardInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600339;
/*    */   public int award_serial_no;
/*    */   public int friends_count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600339;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncGrcFriendsCountAwardInfo()
/*    */   {
/* 34 */     this.award_serial_no = 0;
/*    */   }
/*    */   
/*    */   public SSyncGrcFriendsCountAwardInfo(int _award_serial_no_, int _friends_count_) {
/* 38 */     this.award_serial_no = _award_serial_no_;
/* 39 */     this.friends_count = _friends_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.award_serial_no);
/* 48 */     _os_.marshal(this.friends_count);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.award_serial_no = _os_.unmarshal_int();
/* 54 */     this.friends_count = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSyncGrcFriendsCountAwardInfo)) {
/* 64 */       SSyncGrcFriendsCountAwardInfo _o_ = (SSyncGrcFriendsCountAwardInfo)_o1_;
/* 65 */       if (this.award_serial_no != _o_.award_serial_no) return false;
/* 66 */       if (this.friends_count != _o_.friends_count) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.award_serial_no;
/* 75 */     _h_ += this.friends_count;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.award_serial_no).append(",");
/* 83 */     _sb_.append(this.friends_count).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncGrcFriendsCountAwardInfo _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.award_serial_no - _o_.award_serial_no;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.friends_count - _o_.friends_count;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SSyncGrcFriendsCountAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */