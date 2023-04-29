/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SingleCrossFieldCancelMatchReq
/*    */   implements Marshal, Comparable<SingleCrossFieldCancelMatchReq>
/*    */ {
/*    */   public long game_server_contextid;
/*    */   public long matcher_server_contextid;
/*    */   
/*    */   public SingleCrossFieldCancelMatchReq()
/*    */   {
/* 15 */     this.game_server_contextid = 0L;
/* 16 */     this.matcher_server_contextid = 0L;
/*    */   }
/*    */   
/*    */   public SingleCrossFieldCancelMatchReq(long _game_server_contextid_, long _matcher_server_contextid_) {
/* 20 */     this.game_server_contextid = _game_server_contextid_;
/* 21 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.game_server_contextid);
/* 30 */     _os_.marshal(this.matcher_server_contextid);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.game_server_contextid = _os_.unmarshal_long();
/* 36 */     this.matcher_server_contextid = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof SingleCrossFieldCancelMatchReq)) {
/* 43 */       SingleCrossFieldCancelMatchReq _o_ = (SingleCrossFieldCancelMatchReq)_o1_;
/* 44 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 45 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += (int)this.game_server_contextid;
/* 54 */     _h_ += (int)this.matcher_server_contextid;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.game_server_contextid).append(",");
/* 62 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SingleCrossFieldCancelMatchReq _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SingleCrossFieldCancelMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */