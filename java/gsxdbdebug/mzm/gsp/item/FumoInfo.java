/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class FumoInfo implements Marshal, Comparable<FumoInfo>
/*    */ {
/*    */   public int protype;
/*    */   public int addvalue;
/*    */   public long timeout;
/*    */   
/*    */   public FumoInfo() {}
/*    */   
/*    */   public FumoInfo(int _protype_, int _addvalue_, long _timeout_)
/*    */   {
/* 17 */     this.protype = _protype_;
/* 18 */     this.addvalue = _addvalue_;
/* 19 */     this.timeout = _timeout_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.protype);
/* 28 */     _os_.marshal(this.addvalue);
/* 29 */     _os_.marshal(this.timeout);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.protype = _os_.unmarshal_int();
/* 35 */     this.addvalue = _os_.unmarshal_int();
/* 36 */     this.timeout = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof FumoInfo)) {
/* 43 */       FumoInfo _o_ = (FumoInfo)_o1_;
/* 44 */       if (this.protype != _o_.protype) return false;
/* 45 */       if (this.addvalue != _o_.addvalue) return false;
/* 46 */       if (this.timeout != _o_.timeout) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.protype;
/* 55 */     _h_ += this.addvalue;
/* 56 */     _h_ += (int)this.timeout;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.protype).append(",");
/* 64 */     _sb_.append(this.addvalue).append(",");
/* 65 */     _sb_.append(this.timeout).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FumoInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.protype - _o_.protype;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.addvalue - _o_.addvalue;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.timeout - _o_.timeout);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\FumoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */