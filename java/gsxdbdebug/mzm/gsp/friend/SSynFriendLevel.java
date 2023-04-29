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
/*    */ public class SSynFriendLevel
/*    */   extends __SSynFriendLevel__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587023;
/*    */   public long friendid;
/*    */   public int level;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587023;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynFriendLevel() {}
/*    */   
/*    */ 
/*    */   public SSynFriendLevel(long _friendid_, int _level_)
/*    */   {
/* 35 */     this.friendid = _friendid_;
/* 36 */     this.level = _level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.friendid);
/* 45 */     _os_.marshal(this.level);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.friendid = _os_.unmarshal_long();
/* 51 */     this.level = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynFriendLevel)) {
/* 61 */       SSynFriendLevel _o_ = (SSynFriendLevel)_o1_;
/* 62 */       if (this.friendid != _o_.friendid) return false;
/* 63 */       if (this.level != _o_.level) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.friendid;
/* 72 */     _h_ += this.level;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.friendid).append(",");
/* 80 */     _sb_.append(this.level).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynFriendLevel _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.level - _o_.level;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynFriendLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */