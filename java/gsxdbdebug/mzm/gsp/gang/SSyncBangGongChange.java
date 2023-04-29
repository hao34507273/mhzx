/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncBangGongChange
/*     */   extends __SSyncBangGongChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589866;
/*     */   public long roleid;
/*     */   public int banggong;
/*     */   public int historybanggong;
/*     */   public int weekbanggong;
/*     */   public long add_banggong_time;
/*     */   public int weekitem_banggong_count;
/*     */   public long item_banggong_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  28 */     return 12589866;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBangGongChange() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBangGongChange(long _roleid_, int _banggong_, int _historybanggong_, int _weekbanggong_, long _add_banggong_time_, int _weekitem_banggong_count_, long _item_banggong_time_)
/*     */   {
/*  43 */     this.roleid = _roleid_;
/*  44 */     this.banggong = _banggong_;
/*  45 */     this.historybanggong = _historybanggong_;
/*  46 */     this.weekbanggong = _weekbanggong_;
/*  47 */     this.add_banggong_time = _add_banggong_time_;
/*  48 */     this.weekitem_banggong_count = _weekitem_banggong_count_;
/*  49 */     this.item_banggong_time = _item_banggong_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.roleid);
/*  58 */     _os_.marshal(this.banggong);
/*  59 */     _os_.marshal(this.historybanggong);
/*  60 */     _os_.marshal(this.weekbanggong);
/*  61 */     _os_.marshal(this.add_banggong_time);
/*  62 */     _os_.marshal(this.weekitem_banggong_count);
/*  63 */     _os_.marshal(this.item_banggong_time);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.roleid = _os_.unmarshal_long();
/*  69 */     this.banggong = _os_.unmarshal_int();
/*  70 */     this.historybanggong = _os_.unmarshal_int();
/*  71 */     this.weekbanggong = _os_.unmarshal_int();
/*  72 */     this.add_banggong_time = _os_.unmarshal_long();
/*  73 */     this.weekitem_banggong_count = _os_.unmarshal_int();
/*  74 */     this.item_banggong_time = _os_.unmarshal_long();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SSyncBangGongChange)) {
/*  84 */       SSyncBangGongChange _o_ = (SSyncBangGongChange)_o1_;
/*  85 */       if (this.roleid != _o_.roleid) return false;
/*  86 */       if (this.banggong != _o_.banggong) return false;
/*  87 */       if (this.historybanggong != _o_.historybanggong) return false;
/*  88 */       if (this.weekbanggong != _o_.weekbanggong) return false;
/*  89 */       if (this.add_banggong_time != _o_.add_banggong_time) return false;
/*  90 */       if (this.weekitem_banggong_count != _o_.weekitem_banggong_count) return false;
/*  91 */       if (this.item_banggong_time != _o_.item_banggong_time) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += (int)this.roleid;
/* 100 */     _h_ += this.banggong;
/* 101 */     _h_ += this.historybanggong;
/* 102 */     _h_ += this.weekbanggong;
/* 103 */     _h_ += (int)this.add_banggong_time;
/* 104 */     _h_ += this.weekitem_banggong_count;
/* 105 */     _h_ += (int)this.item_banggong_time;
/* 106 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder _sb_ = new StringBuilder();
/* 111 */     _sb_.append("(");
/* 112 */     _sb_.append(this.roleid).append(",");
/* 113 */     _sb_.append(this.banggong).append(",");
/* 114 */     _sb_.append(this.historybanggong).append(",");
/* 115 */     _sb_.append(this.weekbanggong).append(",");
/* 116 */     _sb_.append(this.add_banggong_time).append(",");
/* 117 */     _sb_.append(this.weekitem_banggong_count).append(",");
/* 118 */     _sb_.append(this.item_banggong_time).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncBangGongChange _o_) {
/* 124 */     if (_o_ == this) return 0;
/* 125 */     int _c_ = 0;
/* 126 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.banggong - _o_.banggong;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.historybanggong - _o_.historybanggong;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = this.weekbanggong - _o_.weekbanggong;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     _c_ = Long.signum(this.add_banggong_time - _o_.add_banggong_time);
/* 135 */     if (0 != _c_) return _c_;
/* 136 */     _c_ = this.weekitem_banggong_count - _o_.weekitem_banggong_count;
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     _c_ = Long.signum(this.item_banggong_time - _o_.item_banggong_time);
/* 139 */     if (0 != _c_) return _c_;
/* 140 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncBangGongChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */