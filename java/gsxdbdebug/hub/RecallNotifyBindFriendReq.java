/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RecallNotifyBindFriendReq
/*    */   implements Marshal
/*    */ {
/*    */   public BindFriendVitalityInfo friend_vitality_info;
/*    */   public RoleVitalityInfo role_vitality_info;
/*    */   public long roleid;
/*    */   
/*    */   public RecallNotifyBindFriendReq()
/*    */   {
/* 16 */     this.friend_vitality_info = new BindFriendVitalityInfo();
/* 17 */     this.role_vitality_info = new RoleVitalityInfo();
/*    */   }
/*    */   
/*    */   public RecallNotifyBindFriendReq(BindFriendVitalityInfo _friend_vitality_info_, RoleVitalityInfo _role_vitality_info_, long _roleid_) {
/* 21 */     this.friend_vitality_info = _friend_vitality_info_;
/* 22 */     this.role_vitality_info = _role_vitality_info_;
/* 23 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     if (!this.friend_vitality_info._validator_()) return false;
/* 28 */     if (!this.role_vitality_info._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.friend_vitality_info);
/* 34 */     _os_.marshal(this.role_vitality_info);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.friend_vitality_info.unmarshal(_os_);
/* 41 */     this.role_vitality_info.unmarshal(_os_);
/* 42 */     this.roleid = _os_.unmarshal_long();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof RecallNotifyBindFriendReq)) {
/* 49 */       RecallNotifyBindFriendReq _o_ = (RecallNotifyBindFriendReq)_o1_;
/* 50 */       if (!this.friend_vitality_info.equals(_o_.friend_vitality_info)) return false;
/* 51 */       if (!this.role_vitality_info.equals(_o_.role_vitality_info)) return false;
/* 52 */       if (this.roleid != _o_.roleid) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.friend_vitality_info.hashCode();
/* 61 */     _h_ += this.role_vitality_info.hashCode();
/* 62 */     _h_ += (int)this.roleid;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.friend_vitality_info).append(",");
/* 70 */     _sb_.append(this.role_vitality_info).append(",");
/* 71 */     _sb_.append(this.roleid).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RecallNotifyBindFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */