/*    */ package mzm.gsp.friend;
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
/*    */ public class SSynFriendAvatar
/*    */   extends __SSynFriendAvatar__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587038;
/*    */   public long friendid;
/*    */   public int avatarid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587038;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynFriendAvatar() {}
/*    */   
/*    */ 
/*    */   public SSynFriendAvatar(long _friendid_, int _avatarid_)
/*    */   {
/* 35 */     this.friendid = _friendid_;
/* 36 */     this.avatarid = _avatarid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.friendid);
/* 45 */     _os_.marshal(this.avatarid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.friendid = _os_.unmarshal_long();
/* 51 */     this.avatarid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynFriendAvatar)) {
/* 61 */       SSynFriendAvatar _o_ = (SSynFriendAvatar)_o1_;
/* 62 */       if (this.friendid != _o_.friendid) return false;
/* 63 */       if (this.avatarid != _o_.avatarid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.friendid;
/* 72 */     _h_ += this.avatarid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.friendid).append(",");
/* 80 */     _sb_.append(this.avatarid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynFriendAvatar _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.avatarid - _o_.avatarid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynFriendAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */