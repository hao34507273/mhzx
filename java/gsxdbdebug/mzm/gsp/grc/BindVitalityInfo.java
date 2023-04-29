/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class BindVitalityInfo
/*    */   implements Marshal
/*    */ {
/*    */   public RecallUserInfo user_info;
/*    */   public RecallRoleInfo role_info;
/*    */   public int vitality;
/*    */   public int update_time;
/*    */   public int bind_time;
/*    */   public byte state;
/*    */   
/*    */   public BindVitalityInfo()
/*    */   {
/* 19 */     this.user_info = new RecallUserInfo();
/* 20 */     this.role_info = new RecallRoleInfo();
/*    */   }
/*    */   
/*    */   public BindVitalityInfo(RecallUserInfo _user_info_, RecallRoleInfo _role_info_, int _vitality_, int _update_time_, int _bind_time_, byte _state_) {
/* 24 */     this.user_info = _user_info_;
/* 25 */     this.role_info = _role_info_;
/* 26 */     this.vitality = _vitality_;
/* 27 */     this.update_time = _update_time_;
/* 28 */     this.bind_time = _bind_time_;
/* 29 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     if (!this.user_info._validator_()) return false;
/* 34 */     if (!this.role_info._validator_()) return false;
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.user_info);
/* 40 */     _os_.marshal(this.role_info);
/* 41 */     _os_.marshal(this.vitality);
/* 42 */     _os_.marshal(this.update_time);
/* 43 */     _os_.marshal(this.bind_time);
/* 44 */     _os_.marshal(this.state);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.user_info.unmarshal(_os_);
/* 50 */     this.role_info.unmarshal(_os_);
/* 51 */     this.vitality = _os_.unmarshal_int();
/* 52 */     this.update_time = _os_.unmarshal_int();
/* 53 */     this.bind_time = _os_.unmarshal_int();
/* 54 */     this.state = _os_.unmarshal_byte();
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof BindVitalityInfo)) {
/* 61 */       BindVitalityInfo _o_ = (BindVitalityInfo)_o1_;
/* 62 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 63 */       if (!this.role_info.equals(_o_.role_info)) return false;
/* 64 */       if (this.vitality != _o_.vitality) return false;
/* 65 */       if (this.update_time != _o_.update_time) return false;
/* 66 */       if (this.bind_time != _o_.bind_time) return false;
/* 67 */       if (this.state != _o_.state) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.user_info.hashCode();
/* 76 */     _h_ += this.role_info.hashCode();
/* 77 */     _h_ += this.vitality;
/* 78 */     _h_ += this.update_time;
/* 79 */     _h_ += this.bind_time;
/* 80 */     _h_ += this.state;
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.user_info).append(",");
/* 88 */     _sb_.append(this.role_info).append(",");
/* 89 */     _sb_.append(this.vitality).append(",");
/* 90 */     _sb_.append(this.update_time).append(",");
/* 91 */     _sb_.append(this.bind_time).append(",");
/* 92 */     _sb_.append(this.state).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\BindVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */