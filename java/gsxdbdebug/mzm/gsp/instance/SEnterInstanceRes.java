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
/*    */ public class SEnterInstanceRes
/*    */   extends __SEnterInstanceRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591366;
/*    */   public int instancetype;
/*    */   public int instancecfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591366;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SEnterInstanceRes() {}
/*    */   
/*    */ 
/*    */   public SEnterInstanceRes(int _instancetype_, int _instancecfgid_)
/*    */   {
/* 37 */     this.instancetype = _instancetype_;
/* 38 */     this.instancecfgid = _instancecfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.instancetype);
/* 47 */     _os_.marshal(this.instancecfgid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.instancetype = _os_.unmarshal_int();
/* 53 */     this.instancecfgid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SEnterInstanceRes)) {
/* 63 */       SEnterInstanceRes _o_ = (SEnterInstanceRes)_o1_;
/* 64 */       if (this.instancetype != _o_.instancetype) return false;
/* 65 */       if (this.instancecfgid != _o_.instancecfgid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.instancetype;
/* 74 */     _h_ += this.instancecfgid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.instancetype).append(",");
/* 82 */     _sb_.append(this.instancecfgid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEnterInstanceRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.instancetype - _o_.instancetype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.instancecfgid - _o_.instancecfgid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SEnterInstanceRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */