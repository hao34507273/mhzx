/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcBindFriendVitalityInfo implements Marshal
/*    */ {
/*    */   public GrcRecallUserInfo user_info;
/*    */   public GrcRoleInfo roleinfo;
/*    */   public int vitality;
/*    */   public long update_time;
/*    */   public long bind_time;
/*    */   public byte state;
/*    */   
/*    */   public GrcBindFriendVitalityInfo()
/*    */   {
/* 17 */     this.user_info = new GrcRecallUserInfo();
/* 18 */     this.roleinfo = new GrcRoleInfo();
/*    */   }
/*    */   
/*    */   public GrcBindFriendVitalityInfo(GrcRecallUserInfo _user_info_, GrcRoleInfo _roleinfo_, int _vitality_, long _update_time_, long _bind_time_, byte _state_) {
/* 22 */     this.user_info = _user_info_;
/* 23 */     this.roleinfo = _roleinfo_;
/* 24 */     this.vitality = _vitality_;
/* 25 */     this.update_time = _update_time_;
/* 26 */     this.bind_time = _bind_time_;
/* 27 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     if (!this.user_info._validator_()) return false;
/* 32 */     if (!this.roleinfo._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.user_info);
/* 38 */     _os_.marshal(this.roleinfo);
/* 39 */     _os_.marshal(this.vitality);
/* 40 */     _os_.marshal(this.update_time);
/* 41 */     _os_.marshal(this.bind_time);
/* 42 */     _os_.marshal(this.state);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.user_info.unmarshal(_os_);
/* 48 */     this.roleinfo.unmarshal(_os_);
/* 49 */     this.vitality = _os_.unmarshal_int();
/* 50 */     this.update_time = _os_.unmarshal_long();
/* 51 */     this.bind_time = _os_.unmarshal_long();
/* 52 */     this.state = _os_.unmarshal_byte();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof GrcBindFriendVitalityInfo)) {
/* 59 */       GrcBindFriendVitalityInfo _o_ = (GrcBindFriendVitalityInfo)_o1_;
/* 60 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 61 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 62 */       if (this.vitality != _o_.vitality) return false;
/* 63 */       if (this.update_time != _o_.update_time) return false;
/* 64 */       if (this.bind_time != _o_.bind_time) return false;
/* 65 */       if (this.state != _o_.state) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.user_info.hashCode();
/* 74 */     _h_ += this.roleinfo.hashCode();
/* 75 */     _h_ += this.vitality;
/* 76 */     _h_ += (int)this.update_time;
/* 77 */     _h_ += (int)this.bind_time;
/* 78 */     _h_ += this.state;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.user_info).append(",");
/* 86 */     _sb_.append(this.roleinfo).append(",");
/* 87 */     _sb_.append(this.vitality).append(",");
/* 88 */     _sb_.append(this.update_time).append(",");
/* 89 */     _sb_.append(this.bind_time).append(",");
/* 90 */     _sb_.append(this.state).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcBindFriendVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */