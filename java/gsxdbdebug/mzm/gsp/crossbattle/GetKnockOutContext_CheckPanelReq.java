/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetKnockOutContext_CheckPanelReq
/*    */   implements Marshal, Comparable<GetKnockOutContext_CheckPanelReq>
/*    */ {
/*    */   public long role_id;
/*    */   
/*    */   public GetKnockOutContext_CheckPanelReq() {}
/*    */   
/*    */   public GetKnockOutContext_CheckPanelReq(long _role_id_)
/*    */   {
/* 17 */     this.role_id = _role_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.role_id);
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 30 */     this.role_id = _os_.unmarshal_long();
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 35 */     if (_o1_ == this) return true;
/* 36 */     if ((_o1_ instanceof GetKnockOutContext_CheckPanelReq)) {
/* 37 */       GetKnockOutContext_CheckPanelReq _o_ = (GetKnockOutContext_CheckPanelReq)_o1_;
/* 38 */       if (this.role_id != _o_.role_id) return false;
/* 39 */       return true;
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 45 */     int _h_ = 0;
/* 46 */     _h_ += (int)this.role_id;
/* 47 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuilder _sb_ = new StringBuilder();
/* 52 */     _sb_.append("(");
/* 53 */     _sb_.append(this.role_id).append(",");
/* 54 */     _sb_.append(")");
/* 55 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetKnockOutContext_CheckPanelReq _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 62 */     if (0 != _c_) return _c_;
/* 63 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_CheckPanelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */