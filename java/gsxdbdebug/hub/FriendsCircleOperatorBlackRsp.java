/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FriendsCircleOperatorBlackRsp
/*    */   implements Marshal, Comparable<FriendsCircleOperatorBlackRsp>
/*    */ {
/*    */   public static final int RESULT_SUCCEED = 0;
/*    */   public static final int RESULT_USER_NOT_FOUND = 1;
/*    */   public static final int RESULT_ALEARDY_DEAL = 2;
/*    */   public byte result;
/*    */   
/*    */   public FriendsCircleOperatorBlackRsp() {}
/*    */   
/*    */   public FriendsCircleOperatorBlackRsp(byte _result_)
/*    */   {
/* 21 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.result);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.result = _os_.unmarshal_byte();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof FriendsCircleOperatorBlackRsp)) {
/* 41 */       FriendsCircleOperatorBlackRsp _o_ = (FriendsCircleOperatorBlackRsp)_o1_;
/* 42 */       if (this.result != _o_.result) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += this.result;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.result).append(",");
/* 58 */     _sb_.append(")");
/* 59 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FriendsCircleOperatorBlackRsp _o_) {
/* 63 */     if (_o_ == this) return 0;
/* 64 */     int _c_ = 0;
/* 65 */     _c_ = this.result - _o_.result;
/* 66 */     if (0 != _c_) return _c_;
/* 67 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleOperatorBlackRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */