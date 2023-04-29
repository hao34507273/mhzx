/*    */ package mzm.gsp.partner;
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
/*    */ public class SImproveYuanShenRep
/*    */   extends __SImproveYuanShenRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588055;
/*    */   public int partnerid;
/*    */   public int index;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588055;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SImproveYuanShenRep() {}
/*    */   
/*    */ 
/*    */   public SImproveYuanShenRep(int _partnerid_, int _index_)
/*    */   {
/* 37 */     this.partnerid = _partnerid_;
/* 38 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.partnerid);
/* 47 */     _os_.marshal(this.index);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.partnerid = _os_.unmarshal_int();
/* 53 */     this.index = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SImproveYuanShenRep)) {
/* 63 */       SImproveYuanShenRep _o_ = (SImproveYuanShenRep)_o1_;
/* 64 */       if (this.partnerid != _o_.partnerid) return false;
/* 65 */       if (this.index != _o_.index) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.partnerid;
/* 74 */     _h_ += this.index;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.partnerid).append(",");
/* 82 */     _sb_.append(this.index).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SImproveYuanShenRep _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.partnerid - _o_.partnerid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.index - _o_.index;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SImproveYuanShenRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */