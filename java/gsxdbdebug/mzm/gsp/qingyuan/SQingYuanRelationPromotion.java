/*    */ package mzm.gsp.qingyuan;
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
/*    */ public class SQingYuanRelationPromotion
/*    */   extends __SQingYuanRelationPromotion__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602891;
/*    */   public long role_id_a;
/*    */   public long role_id_b;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602891;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SQingYuanRelationPromotion() {}
/*    */   
/*    */ 
/*    */   public SQingYuanRelationPromotion(long _role_id_a_, long _role_id_b_)
/*    */   {
/* 37 */     this.role_id_a = _role_id_a_;
/* 38 */     this.role_id_b = _role_id_b_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.role_id_a);
/* 47 */     _os_.marshal(this.role_id_b);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.role_id_a = _os_.unmarshal_long();
/* 53 */     this.role_id_b = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SQingYuanRelationPromotion)) {
/* 63 */       SQingYuanRelationPromotion _o_ = (SQingYuanRelationPromotion)_o1_;
/* 64 */       if (this.role_id_a != _o_.role_id_a) return false;
/* 65 */       if (this.role_id_b != _o_.role_id_b) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.role_id_a;
/* 74 */     _h_ += (int)this.role_id_b;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.role_id_a).append(",");
/* 82 */     _sb_.append(this.role_id_b).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SQingYuanRelationPromotion _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.role_id_a - _o_.role_id_a);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.role_id_b - _o_.role_id_b);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SQingYuanRelationPromotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */