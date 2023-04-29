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
/*    */ 
/*    */ public class SSynZheyaoCount
/*    */   extends __SSynZheyaoCount__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587564;
/*    */   public int singlecount;
/*    */   public int doublecount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587564;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynZheyaoCount() {}
/*    */   
/*    */ 
/*    */   public SSynZheyaoCount(int _singlecount_, int _doublecount_)
/*    */   {
/* 37 */     this.singlecount = _singlecount_;
/* 38 */     this.doublecount = _doublecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.singlecount);
/* 47 */     _os_.marshal(this.doublecount);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.singlecount = _os_.unmarshal_int();
/* 53 */     this.doublecount = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynZheyaoCount)) {
/* 63 */       SSynZheyaoCount _o_ = (SSynZheyaoCount)_o1_;
/* 64 */       if (this.singlecount != _o_.singlecount) return false;
/* 65 */       if (this.doublecount != _o_.doublecount) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.singlecount;
/* 74 */     _h_ += this.doublecount;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.singlecount).append(",");
/* 82 */     _sb_.append(this.doublecount).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynZheyaoCount _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.singlecount - _o_.singlecount;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.doublecount - _o_.doublecount;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSynZheyaoCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */