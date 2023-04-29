/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SingleCrossFieldWaitNextRoundMatchReq
/*    */   implements Marshal, Comparable<SingleCrossFieldWaitNextRoundMatchReq>
/*    */ {
/*    */   public long game_server_contextid;
/*    */   public long matcher_server_contextid;
/*    */   public byte reason;
/*    */   
/*    */   public SingleCrossFieldWaitNextRoundMatchReq()
/*    */   {
/* 16 */     this.game_server_contextid = 0L;
/* 17 */     this.matcher_server_contextid = 0L;
/*    */   }
/*    */   
/*    */   public SingleCrossFieldWaitNextRoundMatchReq(long _game_server_contextid_, long _matcher_server_contextid_, byte _reason_) {
/* 21 */     this.game_server_contextid = _game_server_contextid_;
/* 22 */     this.matcher_server_contextid = _matcher_server_contextid_;
/* 23 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.game_server_contextid);
/* 32 */     _os_.marshal(this.matcher_server_contextid);
/* 33 */     _os_.marshal(this.reason);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.game_server_contextid = _os_.unmarshal_long();
/* 39 */     this.matcher_server_contextid = _os_.unmarshal_long();
/* 40 */     this.reason = _os_.unmarshal_byte();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof SingleCrossFieldWaitNextRoundMatchReq)) {
/* 47 */       SingleCrossFieldWaitNextRoundMatchReq _o_ = (SingleCrossFieldWaitNextRoundMatchReq)_o1_;
/* 48 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 49 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/* 50 */       if (this.reason != _o_.reason) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += (int)this.game_server_contextid;
/* 59 */     _h_ += (int)this.matcher_server_contextid;
/* 60 */     _h_ += this.reason;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.game_server_contextid).append(",");
/* 68 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 69 */     _sb_.append(this.reason).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SingleCrossFieldWaitNextRoundMatchReq _o_) {
/* 75 */     if (_o_ == this) return 0;
/* 76 */     int _c_ = 0;
/* 77 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     _c_ = this.reason - _o_.reason;
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SingleCrossFieldWaitNextRoundMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */