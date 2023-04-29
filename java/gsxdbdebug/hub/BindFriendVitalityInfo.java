/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class BindFriendVitalityInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets openid;
/*    */   public Octets nickname;
/*    */   public Octets figure_url;
/*    */   public RoleVitalityInfo roleinfo;
/*    */   public long bind_time;
/*    */   public byte state;
/*    */   
/*    */   public BindFriendVitalityInfo()
/*    */   {
/* 17 */     this.openid = new Octets();
/* 18 */     this.nickname = new Octets();
/* 19 */     this.figure_url = new Octets();
/* 20 */     this.roleinfo = new RoleVitalityInfo();
/*    */   }
/*    */   
/*    */   public BindFriendVitalityInfo(Octets _openid_, Octets _nickname_, Octets _figure_url_, RoleVitalityInfo _roleinfo_, long _bind_time_, byte _state_) {
/* 24 */     this.openid = _openid_;
/* 25 */     this.nickname = _nickname_;
/* 26 */     this.figure_url = _figure_url_;
/* 27 */     this.roleinfo = _roleinfo_;
/* 28 */     this.bind_time = _bind_time_;
/* 29 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     if (!this.roleinfo._validator_()) return false;
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.openid);
/* 39 */     _os_.marshal(this.nickname);
/* 40 */     _os_.marshal(this.figure_url);
/* 41 */     _os_.marshal(this.roleinfo);
/* 42 */     _os_.marshal(this.bind_time);
/* 43 */     _os_.marshal(this.state);
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 48 */     this.openid = _os_.unmarshal_Octets();
/* 49 */     this.nickname = _os_.unmarshal_Octets();
/* 50 */     this.figure_url = _os_.unmarshal_Octets();
/* 51 */     this.roleinfo.unmarshal(_os_);
/* 52 */     this.bind_time = _os_.unmarshal_long();
/* 53 */     this.state = _os_.unmarshal_byte();
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof BindFriendVitalityInfo)) {
/* 60 */       BindFriendVitalityInfo _o_ = (BindFriendVitalityInfo)_o1_;
/* 61 */       if (!this.openid.equals(_o_.openid)) return false;
/* 62 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 63 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 64 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 65 */       if (this.bind_time != _o_.bind_time) return false;
/* 66 */       if (this.state != _o_.state) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.openid.hashCode();
/* 75 */     _h_ += this.nickname.hashCode();
/* 76 */     _h_ += this.figure_url.hashCode();
/* 77 */     _h_ += this.roleinfo.hashCode();
/* 78 */     _h_ += (int)this.bind_time;
/* 79 */     _h_ += this.state;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 87 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 88 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 89 */     _sb_.append(this.roleinfo).append(",");
/* 90 */     _sb_.append(this.bind_time).append(",");
/* 91 */     _sb_.append(this.state).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\BindFriendVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */