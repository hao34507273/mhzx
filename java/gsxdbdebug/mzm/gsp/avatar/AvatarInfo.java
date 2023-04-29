/*    */ package mzm.gsp.avatar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class AvatarInfo
/*    */   implements Marshal, Comparable<AvatarInfo>
/*    */ {
/*    */   public int avatar;
/*    */   public long expire_time;
/*    */   
/*    */   public AvatarInfo() {}
/*    */   
/*    */   public AvatarInfo(int _avatar_, long _expire_time_)
/*    */   {
/* 18 */     this.avatar = _avatar_;
/* 19 */     this.expire_time = _expire_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.avatar);
/* 28 */     _os_.marshal(this.expire_time);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.avatar = _os_.unmarshal_int();
/* 34 */     this.expire_time = _os_.unmarshal_long();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof AvatarInfo)) {
/* 41 */       AvatarInfo _o_ = (AvatarInfo)_o1_;
/* 42 */       if (this.avatar != _o_.avatar) return false;
/* 43 */       if (this.expire_time != _o_.expire_time) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.avatar;
/* 52 */     _h_ += (int)this.expire_time;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.avatar).append(",");
/* 60 */     _sb_.append(this.expire_time).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(AvatarInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.avatar - _o_.avatar;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = Long.signum(this.expire_time - _o_.expire_time);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\AvatarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */