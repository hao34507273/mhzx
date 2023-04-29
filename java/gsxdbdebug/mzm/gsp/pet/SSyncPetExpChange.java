/*    */ package mzm.gsp.pet;
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
/*    */ public class SSyncPetExpChange
/*    */   extends __SSyncPetExpChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590641;
/*    */   public long petid;
/*    */   public int addexp;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590641;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncPetExpChange() {}
/*    */   
/*    */ 
/*    */   public SSyncPetExpChange(long _petid_, int _addexp_)
/*    */   {
/* 37 */     this.petid = _petid_;
/* 38 */     this.addexp = _addexp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.petid);
/* 47 */     _os_.marshal(this.addexp);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.petid = _os_.unmarshal_long();
/* 53 */     this.addexp = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncPetExpChange)) {
/* 63 */       SSyncPetExpChange _o_ = (SSyncPetExpChange)_o1_;
/* 64 */       if (this.petid != _o_.petid) return false;
/* 65 */       if (this.addexp != _o_.addexp) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.petid;
/* 74 */     _h_ += this.addexp;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.petid).append(",");
/* 82 */     _sb_.append(this.addexp).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncPetExpChange _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.addexp - _o_.addexp;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncPetExpChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */