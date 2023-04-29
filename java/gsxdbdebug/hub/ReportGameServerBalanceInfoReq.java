/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ReportGameServerBalanceInfoReq
/*    */   implements Marshal, Comparable<ReportGameServerBalanceInfoReq>
/*    */ {
/*    */   public int roam_type_mask;
/*    */   public int online_role_num;
/*    */   
/*    */   public ReportGameServerBalanceInfoReq()
/*    */   {
/* 15 */     this.roam_type_mask = 0;
/* 16 */     this.online_role_num = 0;
/*    */   }
/*    */   
/*    */   public ReportGameServerBalanceInfoReq(int _roam_type_mask_, int _online_role_num_) {
/* 20 */     this.roam_type_mask = _roam_type_mask_;
/* 21 */     this.online_role_num = _online_role_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.roam_type_mask);
/* 30 */     _os_.marshal(this.online_role_num);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.roam_type_mask = _os_.unmarshal_int();
/* 36 */     this.online_role_num = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof ReportGameServerBalanceInfoReq)) {
/* 43 */       ReportGameServerBalanceInfoReq _o_ = (ReportGameServerBalanceInfoReq)_o1_;
/* 44 */       if (this.roam_type_mask != _o_.roam_type_mask) return false;
/* 45 */       if (this.online_role_num != _o_.online_role_num) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.roam_type_mask;
/* 54 */     _h_ += this.online_role_num;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.roam_type_mask).append(",");
/* 62 */     _sb_.append(this.online_role_num).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ReportGameServerBalanceInfoReq _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     _c_ = this.roam_type_mask - _o_.roam_type_mask;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     _c_ = this.online_role_num - _o_.online_role_num;
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ReportGameServerBalanceInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */