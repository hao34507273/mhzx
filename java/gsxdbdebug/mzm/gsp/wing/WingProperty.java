/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class WingProperty implements Marshal, Comparable<WingProperty>
/*    */ {
/*    */   public int propertytype;
/*    */   public int propertyvalue;
/*    */   public int propertyphase;
/*    */   
/*    */   public WingProperty() {}
/*    */   
/*    */   public WingProperty(int _propertytype_, int _propertyvalue_, int _propertyphase_)
/*    */   {
/* 17 */     this.propertytype = _propertytype_;
/* 18 */     this.propertyvalue = _propertyvalue_;
/* 19 */     this.propertyphase = _propertyphase_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.propertytype);
/* 28 */     _os_.marshal(this.propertyvalue);
/* 29 */     _os_.marshal(this.propertyphase);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.propertytype = _os_.unmarshal_int();
/* 35 */     this.propertyvalue = _os_.unmarshal_int();
/* 36 */     this.propertyphase = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof WingProperty)) {
/* 43 */       WingProperty _o_ = (WingProperty)_o1_;
/* 44 */       if (this.propertytype != _o_.propertytype) return false;
/* 45 */       if (this.propertyvalue != _o_.propertyvalue) return false;
/* 46 */       if (this.propertyphase != _o_.propertyphase) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.propertytype;
/* 55 */     _h_ += this.propertyvalue;
/* 56 */     _h_ += this.propertyphase;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.propertytype).append(",");
/* 64 */     _sb_.append(this.propertyvalue).append(",");
/* 65 */     _sb_.append(this.propertyphase).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(WingProperty _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.propertytype - _o_.propertytype;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.propertyvalue - _o_.propertyvalue;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.propertyphase - _o_.propertyphase;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\WingProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */