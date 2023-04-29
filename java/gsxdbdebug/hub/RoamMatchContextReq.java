/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RoamMatchContextReq implements Marshal
/*    */ {
/*    */   public int activity_context_typeid;
/*    */   public ArrayList<RoleMatchMarkingInfo> role_infos;
/*    */   public ArrayList<RoleMatchMarkingInfo> opponent_role_infos;
/*    */   
/*    */   public RoamMatchContextReq()
/*    */   {
/* 16 */     this.role_infos = new ArrayList();
/* 17 */     this.opponent_role_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public RoamMatchContextReq(int _activity_context_typeid_, ArrayList<RoleMatchMarkingInfo> _role_infos_, ArrayList<RoleMatchMarkingInfo> _opponent_role_infos_) {
/* 21 */     this.activity_context_typeid = _activity_context_typeid_;
/* 22 */     this.role_infos = _role_infos_;
/* 23 */     this.opponent_role_infos = _opponent_role_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     for (RoleMatchMarkingInfo _v_ : this.role_infos)
/* 28 */       if (!_v_._validator_()) return false;
/* 29 */     for (RoleMatchMarkingInfo _v_ : this.opponent_role_infos)
/* 30 */       if (!_v_._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.activity_context_typeid);
/* 36 */     _os_.compact_uint32(this.role_infos.size());
/* 37 */     for (RoleMatchMarkingInfo _v_ : this.role_infos) {
/* 38 */       _os_.marshal(_v_);
/*    */     }
/* 40 */     _os_.compact_uint32(this.opponent_role_infos.size());
/* 41 */     for (RoleMatchMarkingInfo _v_ : this.opponent_role_infos) {
/* 42 */       _os_.marshal(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.activity_context_typeid = _os_.unmarshal_int();
/* 49 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 50 */       RoleMatchMarkingInfo _v_ = new RoleMatchMarkingInfo();
/* 51 */       _v_.unmarshal(_os_);
/* 52 */       this.role_infos.add(_v_);
/*    */     }
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 55 */       RoleMatchMarkingInfo _v_ = new RoleMatchMarkingInfo();
/* 56 */       _v_.unmarshal(_os_);
/* 57 */       this.opponent_role_infos.add(_v_);
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof RoamMatchContextReq)) {
/* 65 */       RoamMatchContextReq _o_ = (RoamMatchContextReq)_o1_;
/* 66 */       if (this.activity_context_typeid != _o_.activity_context_typeid) return false;
/* 67 */       if (!this.role_infos.equals(_o_.role_infos)) return false;
/* 68 */       if (!this.opponent_role_infos.equals(_o_.opponent_role_infos)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.activity_context_typeid;
/* 77 */     _h_ += this.role_infos.hashCode();
/* 78 */     _h_ += this.opponent_role_infos.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_context_typeid).append(",");
/* 86 */     _sb_.append(this.role_infos).append(",");
/* 87 */     _sb_.append(this.opponent_role_infos).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoamMatchContextReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */