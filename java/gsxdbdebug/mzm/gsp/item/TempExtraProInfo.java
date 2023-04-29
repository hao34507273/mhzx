/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class TempExtraProInfo implements Marshal, Comparable<TempExtraProInfo>
/*    */ {
/*    */   public int protype;
/*    */   public int provalue;
/*    */   
/*    */   public TempExtraProInfo() {}
/*    */   
/*    */   public TempExtraProInfo(int _protype_, int _provalue_)
/*    */   {
/* 16 */     this.protype = _protype_;
/* 17 */     this.provalue = _provalue_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.protype);
/* 26 */     _os_.marshal(this.provalue);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.protype = _os_.unmarshal_int();
/* 32 */     this.provalue = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof TempExtraProInfo)) {
/* 39 */       TempExtraProInfo _o_ = (TempExtraProInfo)_o1_;
/* 40 */       if (this.protype != _o_.protype) return false;
/* 41 */       if (this.provalue != _o_.provalue) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.protype;
/* 50 */     _h_ += this.provalue;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.protype).append(",");
/* 58 */     _sb_.append(this.provalue).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(TempExtraProInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.protype - _o_.protype;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.provalue - _o_.provalue;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\TempExtraProInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */