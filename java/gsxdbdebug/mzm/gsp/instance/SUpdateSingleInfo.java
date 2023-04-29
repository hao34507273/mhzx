/*    */ package mzm.gsp.instance;
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
/*    */ public class SUpdateSingleInfo
/*    */   extends __SUpdateSingleInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591370;
/*    */   public SingleInfo singleinfo;
/*    */   public int failtime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591370;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUpdateSingleInfo()
/*    */   {
/* 34 */     this.singleinfo = new SingleInfo();
/*    */   }
/*    */   
/*    */   public SUpdateSingleInfo(SingleInfo _singleinfo_, int _failtime_) {
/* 38 */     this.singleinfo = _singleinfo_;
/* 39 */     this.failtime = _failtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.singleinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.singleinfo);
/* 49 */     _os_.marshal(this.failtime);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.singleinfo.unmarshal(_os_);
/* 55 */     this.failtime = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SUpdateSingleInfo)) {
/* 65 */       SUpdateSingleInfo _o_ = (SUpdateSingleInfo)_o1_;
/* 66 */       if (!this.singleinfo.equals(_o_.singleinfo)) return false;
/* 67 */       if (this.failtime != _o_.failtime) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.singleinfo.hashCode();
/* 76 */     _h_ += this.failtime;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.singleinfo).append(",");
/* 84 */     _sb_.append(this.failtime).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUpdateSingleInfo _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.singleinfo.compareTo(_o_.singleinfo);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.failtime - _o_.failtime;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SUpdateSingleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */