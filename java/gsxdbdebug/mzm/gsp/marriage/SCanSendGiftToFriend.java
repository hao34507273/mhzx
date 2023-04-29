/*    */ package mzm.gsp.marriage;
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
/*    */ public class SCanSendGiftToFriend
/*    */   extends __SCanSendGiftToFriend__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599835;
/*    */   public static final int SUC = 0;
/*    */   public static final int ALREADY_SEND = 1;
/*    */   public static final int OUT_OF_DATE = 2;
/*    */   public static final int NOT_IN_MARRIAGE = 3;
/*    */   public long friendid;
/*    */   public int ret;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599835;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCanSendGiftToFriend() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCanSendGiftToFriend(long _friendid_, int _ret_)
/*    */   {
/* 42 */     this.friendid = _friendid_;
/* 43 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.friendid);
/* 52 */     _os_.marshal(this.ret);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.friendid = _os_.unmarshal_long();
/* 58 */     this.ret = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SCanSendGiftToFriend)) {
/* 68 */       SCanSendGiftToFriend _o_ = (SCanSendGiftToFriend)_o1_;
/* 69 */       if (this.friendid != _o_.friendid) return false;
/* 70 */       if (this.ret != _o_.ret) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.friendid;
/* 79 */     _h_ += this.ret;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.friendid).append(",");
/* 87 */     _sb_.append(this.ret).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SCanSendGiftToFriend _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.ret - _o_.ret;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SCanSendGiftToFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */