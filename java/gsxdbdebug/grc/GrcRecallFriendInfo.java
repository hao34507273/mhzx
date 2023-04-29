/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcRecallFriendInfo implements Marshal
/*    */ {
/*    */   public GrcRecallUserInfo user_info;
/*    */   public GrcRoleInfo roleinfo;
/*    */   public int callback;
/*    */   public int state;
/*    */   
/*    */   public GrcRecallFriendInfo()
/*    */   {
/* 15 */     this.user_info = new GrcRecallUserInfo();
/* 16 */     this.roleinfo = new GrcRoleInfo();
/*    */   }
/*    */   
/*    */   public GrcRecallFriendInfo(GrcRecallUserInfo _user_info_, GrcRoleInfo _roleinfo_, int _callback_, int _state_) {
/* 20 */     this.user_info = _user_info_;
/* 21 */     this.roleinfo = _roleinfo_;
/* 22 */     this.callback = _callback_;
/* 23 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     if (!this.user_info._validator_()) return false;
/* 28 */     if (!this.roleinfo._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.user_info);
/* 34 */     _os_.marshal(this.roleinfo);
/* 35 */     _os_.marshal(this.callback);
/* 36 */     _os_.marshal(this.state);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.user_info.unmarshal(_os_);
/* 42 */     this.roleinfo.unmarshal(_os_);
/* 43 */     this.callback = _os_.unmarshal_int();
/* 44 */     this.state = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof GrcRecallFriendInfo)) {
/* 51 */       GrcRecallFriendInfo _o_ = (GrcRecallFriendInfo)_o1_;
/* 52 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 53 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 54 */       if (this.callback != _o_.callback) return false;
/* 55 */       if (this.state != _o_.state) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.user_info.hashCode();
/* 64 */     _h_ += this.roleinfo.hashCode();
/* 65 */     _h_ += this.callback;
/* 66 */     _h_ += this.state;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.user_info).append(",");
/* 74 */     _sb_.append(this.roleinfo).append(",");
/* 75 */     _sb_.append(this.callback).append(",");
/* 76 */     _sb_.append(this.state).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcRecallFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */