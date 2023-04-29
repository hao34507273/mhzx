/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class QQVipInfo implements Marshal, Comparable<QQVipInfo>
/*    */ {
/*    */   public int vip_flag;
/*    */   public byte is_vip;
/*    */   public byte is_year;
/*    */   public byte is_luxury;
/*    */   public int level;
/*    */   
/*    */   public QQVipInfo()
/*    */   {
/* 16 */     this.vip_flag = 1;
/*    */   }
/*    */   
/*    */   public QQVipInfo(int _vip_flag_, byte _is_vip_, byte _is_year_, byte _is_luxury_, int _level_) {
/* 20 */     this.vip_flag = _vip_flag_;
/* 21 */     this.is_vip = _is_vip_;
/* 22 */     this.is_year = _is_year_;
/* 23 */     this.is_luxury = _is_luxury_;
/* 24 */     this.level = _level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.vip_flag);
/* 33 */     _os_.marshal(this.is_vip);
/* 34 */     _os_.marshal(this.is_year);
/* 35 */     _os_.marshal(this.is_luxury);
/* 36 */     _os_.marshal(this.level);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.vip_flag = _os_.unmarshal_int();
/* 42 */     this.is_vip = _os_.unmarshal_byte();
/* 43 */     this.is_year = _os_.unmarshal_byte();
/* 44 */     this.is_luxury = _os_.unmarshal_byte();
/* 45 */     this.level = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof QQVipInfo)) {
/* 52 */       QQVipInfo _o_ = (QQVipInfo)_o1_;
/* 53 */       if (this.vip_flag != _o_.vip_flag) return false;
/* 54 */       if (this.is_vip != _o_.is_vip) return false;
/* 55 */       if (this.is_year != _o_.is_year) return false;
/* 56 */       if (this.is_luxury != _o_.is_luxury) return false;
/* 57 */       if (this.level != _o_.level) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.vip_flag;
/* 66 */     _h_ += this.is_vip;
/* 67 */     _h_ += this.is_year;
/* 68 */     _h_ += this.is_luxury;
/* 69 */     _h_ += this.level;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.vip_flag).append(",");
/* 77 */     _sb_.append(this.is_vip).append(",");
/* 78 */     _sb_.append(this.is_year).append(",");
/* 79 */     _sb_.append(this.is_luxury).append(",");
/* 80 */     _sb_.append(this.level).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(QQVipInfo _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.vip_flag - _o_.vip_flag;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.is_vip - _o_.is_vip;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.is_year - _o_.is_year;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.is_luxury - _o_.is_luxury;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.level - _o_.level;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\QQVipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */