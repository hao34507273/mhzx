/*    */ package mzm.gsp.mourn;
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
/*    */ public class SSynSingleMournInfo
/*    */   extends __SSynSingleMournInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613379;
/*    */   public int mournid;
/*    */   public MTaskInfo mourninfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613379;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynSingleMournInfo()
/*    */   {
/* 34 */     this.mourninfo = new MTaskInfo();
/*    */   }
/*    */   
/*    */   public SSynSingleMournInfo(int _mournid_, MTaskInfo _mourninfo_) {
/* 38 */     this.mournid = _mournid_;
/* 39 */     this.mourninfo = _mourninfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.mourninfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.mournid);
/* 49 */     _os_.marshal(this.mourninfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mournid = _os_.unmarshal_int();
/* 55 */     this.mourninfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynSingleMournInfo)) {
/* 65 */       SSynSingleMournInfo _o_ = (SSynSingleMournInfo)_o1_;
/* 66 */       if (this.mournid != _o_.mournid) return false;
/* 67 */       if (!this.mourninfo.equals(_o_.mourninfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.mournid;
/* 76 */     _h_ += this.mourninfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.mournid).append(",");
/* 84 */     _sb_.append(this.mourninfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynSingleMournInfo _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.mournid - _o_.mournid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.mourninfo.compareTo(_o_.mourninfo);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\SSynSingleMournInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */