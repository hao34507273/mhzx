/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ConfirmJoinMatchReq
/*    */   implements Marshal, Comparable<ConfirmJoinMatchReq>
/*    */ {
/*    */   public long matcher_server_contextid;
/*    */   public long game_server_contextid;
/*    */   public int activity_context_typeid;
/*    */   public int level_range;
/*    */   
/*    */   public ConfirmJoinMatchReq()
/*    */   {
/* 17 */     this.matcher_server_contextid = 0L;
/* 18 */     this.game_server_contextid = 0L;
/*    */   }
/*    */   
/*    */   public ConfirmJoinMatchReq(long _matcher_server_contextid_, long _game_server_contextid_, int _activity_context_typeid_, int _level_range_) {
/* 22 */     this.matcher_server_contextid = _matcher_server_contextid_;
/* 23 */     this.game_server_contextid = _game_server_contextid_;
/* 24 */     this.activity_context_typeid = _activity_context_typeid_;
/* 25 */     this.level_range = _level_range_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.matcher_server_contextid);
/* 34 */     _os_.marshal(this.game_server_contextid);
/* 35 */     _os_.marshal(this.activity_context_typeid);
/* 36 */     _os_.marshal(this.level_range);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.matcher_server_contextid = _os_.unmarshal_long();
/* 42 */     this.game_server_contextid = _os_.unmarshal_long();
/* 43 */     this.activity_context_typeid = _os_.unmarshal_int();
/* 44 */     this.level_range = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof ConfirmJoinMatchReq)) {
/* 51 */       ConfirmJoinMatchReq _o_ = (ConfirmJoinMatchReq)_o1_;
/* 52 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/* 53 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 54 */       if (this.activity_context_typeid != _o_.activity_context_typeid) return false;
/* 55 */       if (this.level_range != _o_.level_range) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += (int)this.matcher_server_contextid;
/* 64 */     _h_ += (int)this.game_server_contextid;
/* 65 */     _h_ += this.activity_context_typeid;
/* 66 */     _h_ += this.level_range;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 74 */     _sb_.append(this.game_server_contextid).append(",");
/* 75 */     _sb_.append(this.activity_context_typeid).append(",");
/* 76 */     _sb_.append(this.level_range).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ConfirmJoinMatchReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.activity_context_typeid - _o_.activity_context_typeid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.level_range - _o_.level_range;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ConfirmJoinMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */