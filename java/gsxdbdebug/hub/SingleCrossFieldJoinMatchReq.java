/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SingleCrossFieldJoinMatchReq
/*    */   implements Marshal
/*    */ {
/*    */   public long game_server_contextid;
/*    */   public int activity_cfg_id;
/*    */   public int field_role_num;
/*    */   public SingleCrossFieldRoleMatchInfo role_info;
/*    */   
/*    */   public SingleCrossFieldJoinMatchReq()
/*    */   {
/* 17 */     this.role_info = new SingleCrossFieldRoleMatchInfo();
/*    */   }
/*    */   
/*    */   public SingleCrossFieldJoinMatchReq(long _game_server_contextid_, int _activity_cfg_id_, int _field_role_num_, SingleCrossFieldRoleMatchInfo _role_info_) {
/* 21 */     this.game_server_contextid = _game_server_contextid_;
/* 22 */     this.activity_cfg_id = _activity_cfg_id_;
/* 23 */     this.field_role_num = _field_role_num_;
/* 24 */     this.role_info = _role_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     if (!this.role_info._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.game_server_contextid);
/* 34 */     _os_.marshal(this.activity_cfg_id);
/* 35 */     _os_.marshal(this.field_role_num);
/* 36 */     _os_.marshal(this.role_info);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.game_server_contextid = _os_.unmarshal_long();
/* 42 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 43 */     this.field_role_num = _os_.unmarshal_int();
/* 44 */     this.role_info.unmarshal(_os_);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof SingleCrossFieldJoinMatchReq)) {
/* 51 */       SingleCrossFieldJoinMatchReq _o_ = (SingleCrossFieldJoinMatchReq)_o1_;
/* 52 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 53 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 54 */       if (this.field_role_num != _o_.field_role_num) return false;
/* 55 */       if (!this.role_info.equals(_o_.role_info)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += (int)this.game_server_contextid;
/* 64 */     _h_ += this.activity_cfg_id;
/* 65 */     _h_ += this.field_role_num;
/* 66 */     _h_ += this.role_info.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.game_server_contextid).append(",");
/* 74 */     _sb_.append(this.activity_cfg_id).append(",");
/* 75 */     _sb_.append(this.field_role_num).append(",");
/* 76 */     _sb_.append(this.role_info).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SingleCrossFieldJoinMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */