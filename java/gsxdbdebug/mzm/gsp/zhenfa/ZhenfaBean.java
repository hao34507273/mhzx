/*    */ package mzm.gsp.zhenfa;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ZhenfaBean
/*    */   implements Marshal, Comparable<ZhenfaBean>
/*    */ {
/*    */   public int zhenfaid;
/*    */   public int level;
/*    */   public int exp;
/*    */   
/*    */   public ZhenfaBean() {}
/*    */   
/*    */   public ZhenfaBean(int _zhenfaid_, int _level_, int _exp_)
/*    */   {
/* 19 */     this.zhenfaid = _zhenfaid_;
/* 20 */     this.level = _level_;
/* 21 */     this.exp = _exp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.zhenfaid);
/* 30 */     _os_.marshal(this.level);
/* 31 */     _os_.marshal(this.exp);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.zhenfaid = _os_.unmarshal_int();
/* 37 */     this.level = _os_.unmarshal_int();
/* 38 */     this.exp = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof ZhenfaBean)) {
/* 45 */       ZhenfaBean _o_ = (ZhenfaBean)_o1_;
/* 46 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 47 */       if (this.level != _o_.level) return false;
/* 48 */       if (this.exp != _o_.exp) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.zhenfaid;
/* 57 */     _h_ += this.level;
/* 58 */     _h_ += this.exp;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.zhenfaid).append(",");
/* 66 */     _sb_.append(this.level).append(",");
/* 67 */     _sb_.append(this.exp).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ZhenfaBean _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.zhenfaid - _o_.zhenfaid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.level - _o_.level;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.exp - _o_.exp;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\ZhenfaBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */