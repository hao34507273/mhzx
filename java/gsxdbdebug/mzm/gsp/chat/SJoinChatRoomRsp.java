/*    */ package mzm.gsp.chat;
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
/*    */ public class SJoinChatRoomRsp
/*    */   extends __SJoinChatRoomRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585250;
/*    */   public static final int SUCCESS = 0;
/*    */   public static final int ERROR_NO_PROVINCE = -1;
/*    */   public static final int ERROR_CHAT_SERVER_NETWORK_ERROR = -2;
/*    */   public static final int ERROR_OTHERS = -3;
/*    */   public int retcode;
/*    */   public int province;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585250;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SJoinChatRoomRsp() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SJoinChatRoomRsp(int _retcode_, int _province_)
/*    */   {
/* 42 */     this.retcode = _retcode_;
/* 43 */     this.province = _province_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.retcode);
/* 52 */     _os_.marshal(this.province);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.retcode = _os_.unmarshal_int();
/* 58 */     this.province = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SJoinChatRoomRsp)) {
/* 68 */       SJoinChatRoomRsp _o_ = (SJoinChatRoomRsp)_o1_;
/* 69 */       if (this.retcode != _o_.retcode) return false;
/* 70 */       if (this.province != _o_.province) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.retcode;
/* 79 */     _h_ += this.province;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.retcode).append(",");
/* 87 */     _sb_.append(this.province).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SJoinChatRoomRsp _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.retcode - _o_.retcode;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.province - _o_.province;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SJoinChatRoomRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */