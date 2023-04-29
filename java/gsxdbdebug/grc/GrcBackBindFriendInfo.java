/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcBackBindFriendInfo implements Marshal
/*    */ {
/*    */   public GrcRecallUserInfo user_info;
/*    */   public long bind_time;
/*    */   public int mail_state;
/*    */   
/*    */   public GrcBackBindFriendInfo()
/*    */   {
/* 14 */     this.user_info = new GrcRecallUserInfo();
/*    */   }
/*    */   
/*    */   public GrcBackBindFriendInfo(GrcRecallUserInfo _user_info_, long _bind_time_, int _mail_state_) {
/* 18 */     this.user_info = _user_info_;
/* 19 */     this.bind_time = _bind_time_;
/* 20 */     this.mail_state = _mail_state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     if (!this.user_info._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.user_info);
/* 30 */     _os_.marshal(this.bind_time);
/* 31 */     _os_.marshal(this.mail_state);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 36 */     this.user_info.unmarshal(_os_);
/* 37 */     this.bind_time = _os_.unmarshal_long();
/* 38 */     this.mail_state = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof GrcBackBindFriendInfo)) {
/* 45 */       GrcBackBindFriendInfo _o_ = (GrcBackBindFriendInfo)_o1_;
/* 46 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 47 */       if (this.bind_time != _o_.bind_time) return false;
/* 48 */       if (this.mail_state != _o_.mail_state) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.user_info.hashCode();
/* 57 */     _h_ += (int)this.bind_time;
/* 58 */     _h_ += this.mail_state;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.user_info).append(",");
/* 66 */     _sb_.append(this.bind_time).append(",");
/* 67 */     _sb_.append(this.mail_state).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcBackBindFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */