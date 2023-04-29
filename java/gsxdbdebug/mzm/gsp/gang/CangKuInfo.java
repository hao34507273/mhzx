/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CangKuInfo
/*    */   implements Marshal, Comparable<CangKuInfo>
/*    */ {
/*    */   public int level;
/*    */   public int levelupendtime;
/*    */   public int totalfuli;
/*    */   public int avaliablefuli;
/*    */   public int avaliablelihe;
/*    */   
/*    */   public CangKuInfo() {}
/*    */   
/*    */   public CangKuInfo(int _level_, int _levelupendtime_, int _totalfuli_, int _avaliablefuli_, int _avaliablelihe_)
/*    */   {
/* 21 */     this.level = _level_;
/* 22 */     this.levelupendtime = _levelupendtime_;
/* 23 */     this.totalfuli = _totalfuli_;
/* 24 */     this.avaliablefuli = _avaliablefuli_;
/* 25 */     this.avaliablelihe = _avaliablelihe_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.level);
/* 34 */     _os_.marshal(this.levelupendtime);
/* 35 */     _os_.marshal(this.totalfuli);
/* 36 */     _os_.marshal(this.avaliablefuli);
/* 37 */     _os_.marshal(this.avaliablelihe);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.level = _os_.unmarshal_int();
/* 43 */     this.levelupendtime = _os_.unmarshal_int();
/* 44 */     this.totalfuli = _os_.unmarshal_int();
/* 45 */     this.avaliablefuli = _os_.unmarshal_int();
/* 46 */     this.avaliablelihe = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof CangKuInfo)) {
/* 53 */       CangKuInfo _o_ = (CangKuInfo)_o1_;
/* 54 */       if (this.level != _o_.level) return false;
/* 55 */       if (this.levelupendtime != _o_.levelupendtime) return false;
/* 56 */       if (this.totalfuli != _o_.totalfuli) return false;
/* 57 */       if (this.avaliablefuli != _o_.avaliablefuli) return false;
/* 58 */       if (this.avaliablelihe != _o_.avaliablelihe) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.level;
/* 67 */     _h_ += this.levelupendtime;
/* 68 */     _h_ += this.totalfuli;
/* 69 */     _h_ += this.avaliablefuli;
/* 70 */     _h_ += this.avaliablelihe;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.level).append(",");
/* 78 */     _sb_.append(this.levelupendtime).append(",");
/* 79 */     _sb_.append(this.totalfuli).append(",");
/* 80 */     _sb_.append(this.avaliablefuli).append(",");
/* 81 */     _sb_.append(this.avaliablelihe).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CangKuInfo _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.level - _o_.level;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.levelupendtime - _o_.levelupendtime;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.totalfuli - _o_.totalfuli;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.avaliablefuli - _o_.avaliablefuli;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.avaliablelihe - _o_.avaliablelihe;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CangKuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */