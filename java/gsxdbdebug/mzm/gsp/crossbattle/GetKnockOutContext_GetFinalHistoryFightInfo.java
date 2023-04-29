/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetKnockOutContext_GetFinalHistoryFightInfo
/*    */   implements Marshal, Comparable<GetKnockOutContext_GetFinalHistoryFightInfo>
/*    */ {
/*    */   public int session;
/*    */   public long role_id;
/*    */   public int req_type;
/*    */   
/*    */   public GetKnockOutContext_GetFinalHistoryFightInfo() {}
/*    */   
/*    */   public GetKnockOutContext_GetFinalHistoryFightInfo(int _session_, long _role_id_, int _req_type_)
/*    */   {
/* 19 */     this.session = _session_;
/* 20 */     this.role_id = _role_id_;
/* 21 */     this.req_type = _req_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.session);
/* 30 */     _os_.marshal(this.role_id);
/* 31 */     _os_.marshal(this.req_type);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.session = _os_.unmarshal_int();
/* 37 */     this.role_id = _os_.unmarshal_long();
/* 38 */     this.req_type = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof GetKnockOutContext_GetFinalHistoryFightInfo)) {
/* 45 */       GetKnockOutContext_GetFinalHistoryFightInfo _o_ = (GetKnockOutContext_GetFinalHistoryFightInfo)_o1_;
/* 46 */       if (this.session != _o_.session) return false;
/* 47 */       if (this.role_id != _o_.role_id) return false;
/* 48 */       if (this.req_type != _o_.req_type) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.session;
/* 57 */     _h_ += (int)this.role_id;
/* 58 */     _h_ += this.req_type;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.session).append(",");
/* 66 */     _sb_.append(this.role_id).append(",");
/* 67 */     _sb_.append(this.req_type).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetKnockOutContext_GetFinalHistoryFightInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.session - _o_.session;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.req_type - _o_.req_type;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_GetFinalHistoryFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */