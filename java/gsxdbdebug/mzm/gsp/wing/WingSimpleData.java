/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class WingSimpleData implements Marshal, Comparable<WingSimpleData>
/*    */ {
/*    */   public int curlv;
/*    */   public int currank;
/*    */   public int checkwing;
/*    */   
/*    */   public WingSimpleData() {}
/*    */   
/*    */   public WingSimpleData(int _curlv_, int _currank_, int _checkwing_)
/*    */   {
/* 17 */     this.curlv = _curlv_;
/* 18 */     this.currank = _currank_;
/* 19 */     this.checkwing = _checkwing_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.curlv);
/* 28 */     _os_.marshal(this.currank);
/* 29 */     _os_.marshal(this.checkwing);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.curlv = _os_.unmarshal_int();
/* 35 */     this.currank = _os_.unmarshal_int();
/* 36 */     this.checkwing = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof WingSimpleData)) {
/* 43 */       WingSimpleData _o_ = (WingSimpleData)_o1_;
/* 44 */       if (this.curlv != _o_.curlv) return false;
/* 45 */       if (this.currank != _o_.currank) return false;
/* 46 */       if (this.checkwing != _o_.checkwing) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.curlv;
/* 55 */     _h_ += this.currank;
/* 56 */     _h_ += this.checkwing;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.curlv).append(",");
/* 64 */     _sb_.append(this.currank).append(",");
/* 65 */     _sb_.append(this.checkwing).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(WingSimpleData _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.curlv - _o_.curlv;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.currank - _o_.currank;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.checkwing - _o_.checkwing;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\WingSimpleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */