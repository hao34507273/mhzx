/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class QQVipInfo implements Marshal, Comparable<QQVipInfo>
/*     */ {
/*     */   public int vip_flag;
/*     */   public byte is_vip;
/*     */   public byte is_year;
/*     */   public byte is_luxury;
/*     */   public int level;
/*     */   public int expire_timestamp;
/*     */   
/*     */   public QQVipInfo()
/*     */   {
/*  17 */     this.vip_flag = 1;
/*     */   }
/*     */   
/*     */   public QQVipInfo(int _vip_flag_, byte _is_vip_, byte _is_year_, byte _is_luxury_, int _level_, int _expire_timestamp_) {
/*  21 */     this.vip_flag = _vip_flag_;
/*  22 */     this.is_vip = _is_vip_;
/*  23 */     this.is_year = _is_year_;
/*  24 */     this.is_luxury = _is_luxury_;
/*  25 */     this.level = _level_;
/*  26 */     this.expire_timestamp = _expire_timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  30 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  34 */     _os_.marshal(this.vip_flag);
/*  35 */     _os_.marshal(this.is_vip);
/*  36 */     _os_.marshal(this.is_year);
/*  37 */     _os_.marshal(this.is_luxury);
/*  38 */     _os_.marshal(this.level);
/*  39 */     _os_.marshal(this.expire_timestamp);
/*  40 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  44 */     this.vip_flag = _os_.unmarshal_int();
/*  45 */     this.is_vip = _os_.unmarshal_byte();
/*  46 */     this.is_year = _os_.unmarshal_byte();
/*  47 */     this.is_luxury = _os_.unmarshal_byte();
/*  48 */     this.level = _os_.unmarshal_int();
/*  49 */     this.expire_timestamp = _os_.unmarshal_int();
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  54 */     if (_o1_ == this) return true;
/*  55 */     if ((_o1_ instanceof QQVipInfo)) {
/*  56 */       QQVipInfo _o_ = (QQVipInfo)_o1_;
/*  57 */       if (this.vip_flag != _o_.vip_flag) return false;
/*  58 */       if (this.is_vip != _o_.is_vip) return false;
/*  59 */       if (this.is_year != _o_.is_year) return false;
/*  60 */       if (this.is_luxury != _o_.is_luxury) return false;
/*  61 */       if (this.level != _o_.level) return false;
/*  62 */       if (this.expire_timestamp != _o_.expire_timestamp) return false;
/*  63 */       return true;
/*     */     }
/*  65 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  69 */     int _h_ = 0;
/*  70 */     _h_ += this.vip_flag;
/*  71 */     _h_ += this.is_vip;
/*  72 */     _h_ += this.is_year;
/*  73 */     _h_ += this.is_luxury;
/*  74 */     _h_ += this.level;
/*  75 */     _h_ += this.expire_timestamp;
/*  76 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  80 */     StringBuilder _sb_ = new StringBuilder();
/*  81 */     _sb_.append("(");
/*  82 */     _sb_.append(this.vip_flag).append(",");
/*  83 */     _sb_.append(this.is_vip).append(",");
/*  84 */     _sb_.append(this.is_year).append(",");
/*  85 */     _sb_.append(this.is_luxury).append(",");
/*  86 */     _sb_.append(this.level).append(",");
/*  87 */     _sb_.append(this.expire_timestamp).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(QQVipInfo _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.vip_flag - _o_.vip_flag;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.is_vip - _o_.is_vip;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.is_year - _o_.is_year;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.is_luxury - _o_.is_luxury;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.level - _o_.level;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.expire_timestamp - _o_.expire_timestamp;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\QQVipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */