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
/*    */ public class SSingleInfoRes
/*    */   extends __SSingleInfoRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591376;
/*    */   public int second;
/*    */   public int suctimes;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591376;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSingleInfoRes() {}
/*    */   
/*    */ 
/*    */   public SSingleInfoRes(int _second_, int _suctimes_)
/*    */   {
/* 37 */     this.second = _second_;
/* 38 */     this.suctimes = _suctimes_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.second);
/* 47 */     _os_.marshal(this.suctimes);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.second = _os_.unmarshal_int();
/* 53 */     this.suctimes = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSingleInfoRes)) {
/* 63 */       SSingleInfoRes _o_ = (SSingleInfoRes)_o1_;
/* 64 */       if (this.second != _o_.second) return false;
/* 65 */       if (this.suctimes != _o_.suctimes) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.second;
/* 74 */     _h_ += this.suctimes;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.second).append(",");
/* 82 */     _sb_.append(this.suctimes).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSingleInfoRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.second - _o_.second;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.suctimes - _o_.suctimes;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SSingleInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */