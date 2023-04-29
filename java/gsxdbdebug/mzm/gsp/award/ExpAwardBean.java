/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ExpAwardBean implements Marshal, Comparable<ExpAwardBean>
/*    */ {
/*    */   public int exptype;
/*    */   public int num;
/*    */   
/*    */   public ExpAwardBean() {}
/*    */   
/*    */   public ExpAwardBean(int _exptype_, int _num_)
/*    */   {
/* 16 */     this.exptype = _exptype_;
/* 17 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.exptype);
/* 26 */     _os_.marshal(this.num);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.exptype = _os_.unmarshal_int();
/* 32 */     this.num = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ExpAwardBean)) {
/* 39 */       ExpAwardBean _o_ = (ExpAwardBean)_o1_;
/* 40 */       if (this.exptype != _o_.exptype) return false;
/* 41 */       if (this.num != _o_.num) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.exptype;
/* 50 */     _h_ += this.num;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.exptype).append(",");
/* 58 */     _sb_.append(this.num).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ExpAwardBean _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.exptype - _o_.exptype;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.num - _o_.num;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\ExpAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */