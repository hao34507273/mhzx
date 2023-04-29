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
/*    */ public class SSyncFuLiInfo
/*    */   extends __SSyncFuLiInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589930;
/*    */   public int totalcount;
/*    */   public int leftcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589930;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncFuLiInfo() {}
/*    */   
/*    */ 
/*    */   public SSyncFuLiInfo(int _totalcount_, int _leftcount_)
/*    */   {
/* 37 */     this.totalcount = _totalcount_;
/* 38 */     this.leftcount = _leftcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.totalcount);
/* 47 */     _os_.marshal(this.leftcount);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.totalcount = _os_.unmarshal_int();
/* 53 */     this.leftcount = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncFuLiInfo)) {
/* 63 */       SSyncFuLiInfo _o_ = (SSyncFuLiInfo)_o1_;
/* 64 */       if (this.totalcount != _o_.totalcount) return false;
/* 65 */       if (this.leftcount != _o_.leftcount) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.totalcount;
/* 74 */     _h_ += this.leftcount;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.totalcount).append(",");
/* 82 */     _sb_.append(this.leftcount).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncFuLiInfo _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.totalcount - _o_.totalcount;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.leftcount - _o_.leftcount;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncFuLiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */