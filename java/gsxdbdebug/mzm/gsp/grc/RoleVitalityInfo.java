/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleVitalityInfo implements Marshal
/*    */ {
/*    */   public RecallUserInfo user_info;
/*    */   public RecallRoleInfo role_info;
/*    */   public int update_time;
/*    */   public int vitality;
/*    */   
/*    */   public RoleVitalityInfo()
/*    */   {
/* 15 */     this.user_info = new RecallUserInfo();
/* 16 */     this.role_info = new RecallRoleInfo();
/*    */   }
/*    */   
/*    */   public RoleVitalityInfo(RecallUserInfo _user_info_, RecallRoleInfo _role_info_, int _update_time_, int _vitality_) {
/* 20 */     this.user_info = _user_info_;
/* 21 */     this.role_info = _role_info_;
/* 22 */     this.update_time = _update_time_;
/* 23 */     this.vitality = _vitality_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     if (!this.user_info._validator_()) return false;
/* 28 */     if (!this.role_info._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.user_info);
/* 34 */     _os_.marshal(this.role_info);
/* 35 */     _os_.marshal(this.update_time);
/* 36 */     _os_.marshal(this.vitality);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.user_info.unmarshal(_os_);
/* 42 */     this.role_info.unmarshal(_os_);
/* 43 */     this.update_time = _os_.unmarshal_int();
/* 44 */     this.vitality = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof RoleVitalityInfo)) {
/* 51 */       RoleVitalityInfo _o_ = (RoleVitalityInfo)_o1_;
/* 52 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 53 */       if (!this.role_info.equals(_o_.role_info)) return false;
/* 54 */       if (this.update_time != _o_.update_time) return false;
/* 55 */       if (this.vitality != _o_.vitality) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.user_info.hashCode();
/* 64 */     _h_ += this.role_info.hashCode();
/* 65 */     _h_ += this.update_time;
/* 66 */     _h_ += this.vitality;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.user_info).append(",");
/* 74 */     _sb_.append(this.role_info).append(",");
/* 75 */     _sb_.append(this.update_time).append(",");
/* 76 */     _sb_.append(this.vitality).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\RoleVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */