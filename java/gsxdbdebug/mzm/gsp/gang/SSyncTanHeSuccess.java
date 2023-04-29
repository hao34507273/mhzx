/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ public class SSyncTanHeSuccess
/*    */   extends __SSyncTanHeSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589844;
/*    */   public long tanheid;
/*    */   public long bangzhuid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589844;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncTanHeSuccess() {}
/*    */   
/*    */ 
/*    */   public SSyncTanHeSuccess(long _tanheid_, long _bangzhuid_)
/*    */   {
/* 38 */     this.tanheid = _tanheid_;
/* 39 */     this.bangzhuid = _bangzhuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.tanheid);
/* 48 */     _os_.marshal(this.bangzhuid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.tanheid = _os_.unmarshal_long();
/* 54 */     this.bangzhuid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSyncTanHeSuccess)) {
/* 64 */       SSyncTanHeSuccess _o_ = (SSyncTanHeSuccess)_o1_;
/* 65 */       if (this.tanheid != _o_.tanheid) return false;
/* 66 */       if (this.bangzhuid != _o_.bangzhuid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.tanheid;
/* 75 */     _h_ += (int)this.bangzhuid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.tanheid).append(",");
/* 83 */     _sb_.append(this.bangzhuid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncTanHeSuccess _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.tanheid - _o_.tanheid);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = Long.signum(this.bangzhuid - _o_.bangzhuid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncTanHeSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */