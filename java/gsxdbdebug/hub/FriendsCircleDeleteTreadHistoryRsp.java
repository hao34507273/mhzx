/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FriendsCircleDeleteTreadHistoryRsp
/*    */   implements Marshal, Comparable<FriendsCircleDeleteTreadHistoryRsp>
/*    */ {
/*    */   public static final int RESULT_SUCCEED = 0;
/*    */   public static final int RESULT_SERIAL_NOT_FOUND = 1;
/*    */   public static final int RESULT_NOT_DONE = 2;
/*    */   public static final int RESULT_USER_NOT_FOUND = 3;
/*    */   public static final int RESULT_CONTEXT_NOT_MATCH = 4;
/*    */   public byte result;
/*    */   
/*    */   public FriendsCircleDeleteTreadHistoryRsp() {}
/*    */   
/*    */   public FriendsCircleDeleteTreadHistoryRsp(byte _result_)
/*    */   {
/* 23 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.result);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.result = _os_.unmarshal_byte();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof FriendsCircleDeleteTreadHistoryRsp)) {
/* 43 */       FriendsCircleDeleteTreadHistoryRsp _o_ = (FriendsCircleDeleteTreadHistoryRsp)_o1_;
/* 44 */       if (this.result != _o_.result) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += this.result;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.result).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FriendsCircleDeleteTreadHistoryRsp _o_) {
/* 65 */     if (_o_ == this) return 0;
/* 66 */     int _c_ = 0;
/* 67 */     _c_ = this.result - _o_.result;
/* 68 */     if (0 != _c_) return _c_;
/* 69 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleDeleteTreadHistoryRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */