/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetAccumTotalCostActivityAwardSuccess
/*    */   extends __SGetAccumTotalCostActivityAwardSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588824;
/*    */   public int activity_cfgid;
/*    */   public int sort_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588824;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetAccumTotalCostActivityAwardSuccess() {}
/*    */   
/*    */ 
/*    */   public SGetAccumTotalCostActivityAwardSuccess(int _activity_cfgid_, int _sort_id_)
/*    */   {
/* 37 */     this.activity_cfgid = _activity_cfgid_;
/* 38 */     this.sort_id = _sort_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.activity_cfgid);
/* 47 */     _os_.marshal(this.sort_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.activity_cfgid = _os_.unmarshal_int();
/* 53 */     this.sort_id = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SGetAccumTotalCostActivityAwardSuccess)) {
/* 63 */       SGetAccumTotalCostActivityAwardSuccess _o_ = (SGetAccumTotalCostActivityAwardSuccess)_o1_;
/* 64 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 65 */       if (this.sort_id != _o_.sort_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activity_cfgid;
/* 74 */     _h_ += this.sort_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activity_cfgid).append(",");
/* 82 */     _sb_.append(this.sort_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetAccumTotalCostActivityAwardSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.sort_id - _o_.sort_id;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetAccumTotalCostActivityAwardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */