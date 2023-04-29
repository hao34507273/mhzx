/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo
/*    */   implements Marshal, Comparable<GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo>
/*    */ {
/*    */   public int session;
/*    */   public long role_id;
/*    */   public int rank;
/*    */   public long corps_id;
/*    */   
/*    */   public GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo() {}
/*    */   
/*    */   public GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo(int _session_, long _role_id_, int _rank_, long _corps_id_)
/*    */   {
/* 20 */     this.session = _session_;
/* 21 */     this.role_id = _role_id_;
/* 22 */     this.rank = _rank_;
/* 23 */     this.corps_id = _corps_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.session);
/* 32 */     _os_.marshal(this.role_id);
/* 33 */     _os_.marshal(this.rank);
/* 34 */     _os_.marshal(this.corps_id);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.session = _os_.unmarshal_int();
/* 40 */     this.role_id = _os_.unmarshal_long();
/* 41 */     this.rank = _os_.unmarshal_int();
/* 42 */     this.corps_id = _os_.unmarshal_long();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo)) {
/* 49 */       GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo _o_ = (GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo)_o1_;
/* 50 */       if (this.session != _o_.session) return false;
/* 51 */       if (this.role_id != _o_.role_id) return false;
/* 52 */       if (this.rank != _o_.rank) return false;
/* 53 */       if (this.corps_id != _o_.corps_id) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.session;
/* 62 */     _h_ += (int)this.role_id;
/* 63 */     _h_ += this.rank;
/* 64 */     _h_ += (int)this.corps_id;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.session).append(",");
/* 72 */     _sb_.append(this.role_id).append(",");
/* 73 */     _sb_.append(this.rank).append(",");
/* 74 */     _sb_.append(this.corps_id).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.session - _o_.session;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.rank - _o_.rank;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_GetFinalHistoryTopThreeCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */