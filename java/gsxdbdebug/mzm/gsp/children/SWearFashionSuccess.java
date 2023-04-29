/*    */ package mzm.gsp.children;
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
/*    */ public class SWearFashionSuccess
/*    */   extends __SWearFashionSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609358;
/*    */   public long childid;
/*    */   public DressedInfo dressed_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609358;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SWearFashionSuccess()
/*    */   {
/* 34 */     this.dressed_info = new DressedInfo();
/*    */   }
/*    */   
/*    */   public SWearFashionSuccess(long _childid_, DressedInfo _dressed_info_) {
/* 38 */     this.childid = _childid_;
/* 39 */     this.dressed_info = _dressed_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.dressed_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childid);
/* 49 */     _os_.marshal(this.dressed_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childid = _os_.unmarshal_long();
/* 55 */     this.dressed_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SWearFashionSuccess)) {
/* 65 */       SWearFashionSuccess _o_ = (SWearFashionSuccess)_o1_;
/* 66 */       if (this.childid != _o_.childid) return false;
/* 67 */       if (!this.dressed_info.equals(_o_.dressed_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childid;
/* 76 */     _h_ += this.dressed_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childid).append(",");
/* 84 */     _sb_.append(this.dressed_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SWearFashionSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.dressed_info.compareTo(_o_.dressed_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SWearFashionSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */