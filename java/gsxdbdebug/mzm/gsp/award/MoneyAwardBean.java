/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MoneyAwardBean implements Marshal, Comparable<MoneyAwardBean>
/*    */ {
/*    */   public int bigtype;
/*    */   public int littletype;
/*    */   public long num;
/*    */   
/*    */   public MoneyAwardBean() {}
/*    */   
/*    */   public MoneyAwardBean(int _bigtype_, int _littletype_, long _num_)
/*    */   {
/* 17 */     this.bigtype = _bigtype_;
/* 18 */     this.littletype = _littletype_;
/* 19 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.bigtype);
/* 28 */     _os_.marshal(this.littletype);
/* 29 */     _os_.marshal(this.num);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.bigtype = _os_.unmarshal_int();
/* 35 */     this.littletype = _os_.unmarshal_int();
/* 36 */     this.num = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof MoneyAwardBean)) {
/* 43 */       MoneyAwardBean _o_ = (MoneyAwardBean)_o1_;
/* 44 */       if (this.bigtype != _o_.bigtype) return false;
/* 45 */       if (this.littletype != _o_.littletype) return false;
/* 46 */       if (this.num != _o_.num) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.bigtype;
/* 55 */     _h_ += this.littletype;
/* 56 */     _h_ += (int)this.num;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.bigtype).append(",");
/* 64 */     _sb_.append(this.littletype).append(",");
/* 65 */     _sb_.append(this.num).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MoneyAwardBean _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.bigtype - _o_.bigtype;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.littletype - _o_.littletype;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.num - _o_.num);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\MoneyAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */