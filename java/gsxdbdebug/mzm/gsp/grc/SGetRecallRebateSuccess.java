/*    */ package mzm.gsp.grc;
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
/*    */ public class SGetRecallRebateSuccess
/*    */   extends __SGetRecallRebateSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600386;
/*    */   public int num;
/*    */   public RebateInfo rebate_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600386;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetRecallRebateSuccess()
/*    */   {
/* 34 */     this.rebate_info = new RebateInfo();
/*    */   }
/*    */   
/*    */   public SGetRecallRebateSuccess(int _num_, RebateInfo _rebate_info_) {
/* 38 */     this.num = _num_;
/* 39 */     this.rebate_info = _rebate_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.rebate_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.num);
/* 49 */     _os_.marshal(this.rebate_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.num = _os_.unmarshal_int();
/* 55 */     this.rebate_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SGetRecallRebateSuccess)) {
/* 65 */       SGetRecallRebateSuccess _o_ = (SGetRecallRebateSuccess)_o1_;
/* 66 */       if (this.num != _o_.num) return false;
/* 67 */       if (!this.rebate_info.equals(_o_.rebate_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.num;
/* 76 */     _h_ += this.rebate_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.num).append(",");
/* 84 */     _sb_.append(this.rebate_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetRecallRebateSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.num - _o_.num;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.rebate_info.compareTo(_o_.rebate_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGetRecallRebateSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */