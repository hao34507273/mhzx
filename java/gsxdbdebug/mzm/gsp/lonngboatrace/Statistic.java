/*    */ package mzm.gsp.lonngboatrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class Statistic implements Marshal, Comparable<Statistic>
/*    */ {
/*    */   public int right;
/*    */   public int wrong;
/*    */   
/*    */   public Statistic() {}
/*    */   
/*    */   public Statistic(int _right_, int _wrong_)
/*    */   {
/* 16 */     this.right = _right_;
/* 17 */     this.wrong = _wrong_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.right);
/* 26 */     _os_.marshal(this.wrong);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.right = _os_.unmarshal_int();
/* 32 */     this.wrong = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof Statistic)) {
/* 39 */       Statistic _o_ = (Statistic)_o1_;
/* 40 */       if (this.right != _o_.right) return false;
/* 41 */       if (this.wrong != _o_.wrong) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.right;
/* 50 */     _h_ += this.wrong;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.right).append(",");
/* 58 */     _sb_.append(this.wrong).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(Statistic _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.right - _o_.right;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.wrong - _o_.wrong;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\Statistic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */