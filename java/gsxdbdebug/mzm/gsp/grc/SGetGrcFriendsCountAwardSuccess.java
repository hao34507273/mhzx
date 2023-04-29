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
/*    */ 
/*    */ public class SGetGrcFriendsCountAwardSuccess
/*    */   extends __SGetGrcFriendsCountAwardSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600340;
/*    */   public int award_serial_no;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600340;
/*    */   }
/*    */   
/*    */ 
/*    */   public SGetGrcFriendsCountAwardSuccess()
/*    */   {
/* 33 */     this.award_serial_no = 0;
/*    */   }
/*    */   
/*    */   public SGetGrcFriendsCountAwardSuccess(int _award_serial_no_) {
/* 37 */     this.award_serial_no = _award_serial_no_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.award_serial_no);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.award_serial_no = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof SGetGrcFriendsCountAwardSuccess)) {
/* 60 */       SGetGrcFriendsCountAwardSuccess _o_ = (SGetGrcFriendsCountAwardSuccess)_o1_;
/* 61 */       if (this.award_serial_no != _o_.award_serial_no) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.award_serial_no;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.award_serial_no).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetGrcFriendsCountAwardSuccess _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.award_serial_no - _o_.award_serial_no;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetGrcFriendsCountAwardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */