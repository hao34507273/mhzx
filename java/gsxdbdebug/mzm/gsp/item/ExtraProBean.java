/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ExtraProBean implements Marshal, Comparable<ExtraProBean>
/*    */ {
/*    */   public int protype;
/*    */   public int provalue;
/*    */   public int islock;
/*    */   
/*    */   public ExtraProBean() {}
/*    */   
/*    */   public ExtraProBean(int _protype_, int _provalue_, int _islock_)
/*    */   {
/* 17 */     this.protype = _protype_;
/* 18 */     this.provalue = _provalue_;
/* 19 */     this.islock = _islock_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.protype);
/* 28 */     _os_.marshal(this.provalue);
/* 29 */     _os_.marshal(this.islock);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.protype = _os_.unmarshal_int();
/* 35 */     this.provalue = _os_.unmarshal_int();
/* 36 */     this.islock = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof ExtraProBean)) {
/* 43 */       ExtraProBean _o_ = (ExtraProBean)_o1_;
/* 44 */       if (this.protype != _o_.protype) return false;
/* 45 */       if (this.provalue != _o_.provalue) return false;
/* 46 */       if (this.islock != _o_.islock) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.protype;
/* 55 */     _h_ += this.provalue;
/* 56 */     _h_ += this.islock;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.protype).append(",");
/* 64 */     _sb_.append(this.provalue).append(",");
/* 65 */     _sb_.append(this.islock).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ExtraProBean _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.protype - _o_.protype;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.provalue - _o_.provalue;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.islock - _o_.islock;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\ExtraProBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */