/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetFightStageEndCorpsInfo_FinalHistory
/*    */   implements Marshal, Comparable<GetFightStageEndCorpsInfo_FinalHistory>
/*    */ {
/*    */   public long role_id;
/*    */   public int rank;
/*    */   public int session;
/*    */   
/*    */   public GetFightStageEndCorpsInfo_FinalHistory() {}
/*    */   
/*    */   public GetFightStageEndCorpsInfo_FinalHistory(long _role_id_, int _rank_, int _session_)
/*    */   {
/* 19 */     this.role_id = _role_id_;
/* 20 */     this.rank = _rank_;
/* 21 */     this.session = _session_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.role_id);
/* 30 */     _os_.marshal(this.rank);
/* 31 */     _os_.marshal(this.session);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.role_id = _os_.unmarshal_long();
/* 37 */     this.rank = _os_.unmarshal_int();
/* 38 */     this.session = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof GetFightStageEndCorpsInfo_FinalHistory)) {
/* 45 */       GetFightStageEndCorpsInfo_FinalHistory _o_ = (GetFightStageEndCorpsInfo_FinalHistory)_o1_;
/* 46 */       if (this.role_id != _o_.role_id) return false;
/* 47 */       if (this.rank != _o_.rank) return false;
/* 48 */       if (this.session != _o_.session) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += (int)this.role_id;
/* 57 */     _h_ += this.rank;
/* 58 */     _h_ += this.session;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.role_id).append(",");
/* 66 */     _sb_.append(this.rank).append(",");
/* 67 */     _sb_.append(this.session).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetFightStageEndCorpsInfo_FinalHistory _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.rank - _o_.rank;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.session - _o_.session;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetFightStageEndCorpsInfo_FinalHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */