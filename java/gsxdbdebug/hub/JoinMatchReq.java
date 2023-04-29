/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class JoinMatchReq implements Marshal
/*    */ {
/*    */   public long game_server_contextid;
/*    */   public int activity_context_typeid;
/*    */   public int level_range;
/*    */   public ArrayList<RoleMatchMarkingInfo> role_infos;
/*    */   
/*    */   public JoinMatchReq()
/*    */   {
/* 17 */     this.game_server_contextid = 0L;
/* 18 */     this.role_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public JoinMatchReq(long _game_server_contextid_, int _activity_context_typeid_, int _level_range_, ArrayList<RoleMatchMarkingInfo> _role_infos_) {
/* 22 */     this.game_server_contextid = _game_server_contextid_;
/* 23 */     this.activity_context_typeid = _activity_context_typeid_;
/* 24 */     this.level_range = _level_range_;
/* 25 */     this.role_infos = _role_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     for (RoleMatchMarkingInfo _v_ : this.role_infos)
/* 30 */       if (!_v_._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.game_server_contextid);
/* 36 */     _os_.marshal(this.activity_context_typeid);
/* 37 */     _os_.marshal(this.level_range);
/* 38 */     _os_.compact_uint32(this.role_infos.size());
/* 39 */     for (RoleMatchMarkingInfo _v_ : this.role_infos) {
/* 40 */       _os_.marshal(_v_);
/*    */     }
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.game_server_contextid = _os_.unmarshal_long();
/* 47 */     this.activity_context_typeid = _os_.unmarshal_int();
/* 48 */     this.level_range = _os_.unmarshal_int();
/* 49 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 50 */       RoleMatchMarkingInfo _v_ = new RoleMatchMarkingInfo();
/* 51 */       _v_.unmarshal(_os_);
/* 52 */       this.role_infos.add(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof JoinMatchReq)) {
/* 60 */       JoinMatchReq _o_ = (JoinMatchReq)_o1_;
/* 61 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 62 */       if (this.activity_context_typeid != _o_.activity_context_typeid) return false;
/* 63 */       if (this.level_range != _o_.level_range) return false;
/* 64 */       if (!this.role_infos.equals(_o_.role_infos)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.game_server_contextid;
/* 73 */     _h_ += this.activity_context_typeid;
/* 74 */     _h_ += this.level_range;
/* 75 */     _h_ += this.role_infos.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.game_server_contextid).append(",");
/* 83 */     _sb_.append(this.activity_context_typeid).append(",");
/* 84 */     _sb_.append(this.level_range).append(",");
/* 85 */     _sb_.append(this.role_infos).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\JoinMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */