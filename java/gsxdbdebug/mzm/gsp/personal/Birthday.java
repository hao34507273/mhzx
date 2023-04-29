/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class Birthday
/*    */   implements Marshal, Comparable<Birthday>
/*    */ {
/*    */   public int month;
/*    */   public int day;
/*    */   
/*    */   public Birthday() {}
/*    */   
/*    */   public Birthday(int _month_, int _day_)
/*    */   {
/* 18 */     this.month = _month_;
/* 19 */     this.day = _day_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.month);
/* 28 */     _os_.marshal(this.day);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.month = _os_.unmarshal_int();
/* 34 */     this.day = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof Birthday)) {
/* 41 */       Birthday _o_ = (Birthday)_o1_;
/* 42 */       if (this.month != _o_.month) return false;
/* 43 */       if (this.day != _o_.day) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.month;
/* 52 */     _h_ += this.day;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.month).append(",");
/* 60 */     _sb_.append(this.day).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Birthday _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.month - _o_.month;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.day - _o_.day;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\Birthday.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */