/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class FriendRecallInfo
/*    */   implements Marshal
/*    */ {
/*    */   public RecallUserInfo user_info;
/*    */   public RecallRoleInfo role_info;
/*    */   public int callback;
/*    */   public int state;
/*    */   
/*    */   public FriendRecallInfo()
/*    */   {
/* 17 */     this.user_info = new RecallUserInfo();
/* 18 */     this.role_info = new RecallRoleInfo();
/*    */   }
/*    */   
/*    */   public FriendRecallInfo(RecallUserInfo _user_info_, RecallRoleInfo _role_info_, int _callback_, int _state_) {
/* 22 */     this.user_info = _user_info_;
/* 23 */     this.role_info = _role_info_;
/* 24 */     this.callback = _callback_;
/* 25 */     this.state = _state_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.user_info._validator_()) return false;
/* 30 */     if (!this.role_info._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.user_info);
/* 36 */     _os_.marshal(this.role_info);
/* 37 */     _os_.marshal(this.callback);
/* 38 */     _os_.marshal(this.state);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.user_info.unmarshal(_os_);
/* 44 */     this.role_info.unmarshal(_os_);
/* 45 */     this.callback = _os_.unmarshal_int();
/* 46 */     this.state = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof FriendRecallInfo)) {
/* 53 */       FriendRecallInfo _o_ = (FriendRecallInfo)_o1_;
/* 54 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 55 */       if (!this.role_info.equals(_o_.role_info)) return false;
/* 56 */       if (this.callback != _o_.callback) return false;
/* 57 */       if (this.state != _o_.state) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.user_info.hashCode();
/* 66 */     _h_ += this.role_info.hashCode();
/* 67 */     _h_ += this.callback;
/* 68 */     _h_ += this.state;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.user_info).append(",");
/* 76 */     _sb_.append(this.role_info).append(",");
/* 77 */     _sb_.append(this.callback).append(",");
/* 78 */     _sb_.append(this.state).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\FriendRecallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */