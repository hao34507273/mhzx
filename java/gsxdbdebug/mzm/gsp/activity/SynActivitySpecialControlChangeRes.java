/*    */ package mzm.gsp.activity;
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
/*    */ public class SynActivitySpecialControlChangeRes
/*    */   extends __SynActivitySpecialControlChangeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587603;
/*    */   public SpecialControlData specialcontroldata;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587603;
/*    */   }
/*    */   
/*    */ 
/*    */   public SynActivitySpecialControlChangeRes()
/*    */   {
/* 31 */     this.specialcontroldata = new SpecialControlData();
/*    */   }
/*    */   
/*    */   public SynActivitySpecialControlChangeRes(SpecialControlData _specialcontroldata_) {
/* 35 */     this.specialcontroldata = _specialcontroldata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.specialcontroldata._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.specialcontroldata);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.specialcontroldata.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SynActivitySpecialControlChangeRes)) {
/* 59 */       SynActivitySpecialControlChangeRes _o_ = (SynActivitySpecialControlChangeRes)_o1_;
/* 60 */       if (!this.specialcontroldata.equals(_o_.specialcontroldata)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.specialcontroldata.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.specialcontroldata).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SynActivitySpecialControlChangeRes _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.specialcontroldata.compareTo(_o_.specialcontroldata);
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SynActivitySpecialControlChangeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */