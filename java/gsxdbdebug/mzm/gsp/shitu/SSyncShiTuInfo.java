/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncShiTuInfo
/*     */   extends __SSyncShiTuInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601610;
/*     */   public ShiTuRoleInfoAndModelInfo masterinfo;
/*     */   public ArrayList<ShiTuRoleInfoAndModelInfo> nowapprenticelist;
/*     */   public int totalapprenticenum;
/*     */   public HashSet<Integer> aleardy_awarded_cfg_id_set;
/*     */   public int is_chu_shi_state;
/*     */   public int now_pay_respect_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601610;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncShiTuInfo()
/*     */   {
/*  38 */     this.masterinfo = new ShiTuRoleInfoAndModelInfo();
/*  39 */     this.nowapprenticelist = new ArrayList();
/*  40 */     this.aleardy_awarded_cfg_id_set = new HashSet();
/*     */   }
/*     */   
/*     */   public SSyncShiTuInfo(ShiTuRoleInfoAndModelInfo _masterinfo_, ArrayList<ShiTuRoleInfoAndModelInfo> _nowapprenticelist_, int _totalapprenticenum_, HashSet<Integer> _aleardy_awarded_cfg_id_set_, int _is_chu_shi_state_, int _now_pay_respect_times_) {
/*  44 */     this.masterinfo = _masterinfo_;
/*  45 */     this.nowapprenticelist = _nowapprenticelist_;
/*  46 */     this.totalapprenticenum = _totalapprenticenum_;
/*  47 */     this.aleardy_awarded_cfg_id_set = _aleardy_awarded_cfg_id_set_;
/*  48 */     this.is_chu_shi_state = _is_chu_shi_state_;
/*  49 */     this.now_pay_respect_times = _now_pay_respect_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     if (!this.masterinfo._validator_()) return false;
/*  54 */     for (ShiTuRoleInfoAndModelInfo _v_ : this.nowapprenticelist)
/*  55 */       if (!_v_._validator_()) return false;
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.masterinfo);
/*  61 */     _os_.compact_uint32(this.nowapprenticelist.size());
/*  62 */     for (ShiTuRoleInfoAndModelInfo _v_ : this.nowapprenticelist) {
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     _os_.marshal(this.totalapprenticenum);
/*  66 */     _os_.compact_uint32(this.aleardy_awarded_cfg_id_set.size());
/*  67 */     for (Integer _v_ : this.aleardy_awarded_cfg_id_set) {
/*  68 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  70 */     _os_.marshal(this.is_chu_shi_state);
/*  71 */     _os_.marshal(this.now_pay_respect_times);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.masterinfo.unmarshal(_os_);
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  78 */       ShiTuRoleInfoAndModelInfo _v_ = new ShiTuRoleInfoAndModelInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.nowapprenticelist.add(_v_);
/*     */     }
/*  82 */     this.totalapprenticenum = _os_.unmarshal_int();
/*  83 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  85 */       int _v_ = _os_.unmarshal_int();
/*  86 */       this.aleardy_awarded_cfg_id_set.add(Integer.valueOf(_v_));
/*     */     }
/*  88 */     this.is_chu_shi_state = _os_.unmarshal_int();
/*  89 */     this.now_pay_respect_times = _os_.unmarshal_int();
/*  90 */     if (!_validator_()) {
/*  91 */       throw new VerifyError("validator failed");
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  97 */     if (_o1_ == this) return true;
/*  98 */     if ((_o1_ instanceof SSyncShiTuInfo)) {
/*  99 */       SSyncShiTuInfo _o_ = (SSyncShiTuInfo)_o1_;
/* 100 */       if (!this.masterinfo.equals(_o_.masterinfo)) return false;
/* 101 */       if (!this.nowapprenticelist.equals(_o_.nowapprenticelist)) return false;
/* 102 */       if (this.totalapprenticenum != _o_.totalapprenticenum) return false;
/* 103 */       if (!this.aleardy_awarded_cfg_id_set.equals(_o_.aleardy_awarded_cfg_id_set)) return false;
/* 104 */       if (this.is_chu_shi_state != _o_.is_chu_shi_state) return false;
/* 105 */       if (this.now_pay_respect_times != _o_.now_pay_respect_times) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += this.masterinfo.hashCode();
/* 114 */     _h_ += this.nowapprenticelist.hashCode();
/* 115 */     _h_ += this.totalapprenticenum;
/* 116 */     _h_ += this.aleardy_awarded_cfg_id_set.hashCode();
/* 117 */     _h_ += this.is_chu_shi_state;
/* 118 */     _h_ += this.now_pay_respect_times;
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.masterinfo).append(",");
/* 126 */     _sb_.append(this.nowapprenticelist).append(",");
/* 127 */     _sb_.append(this.totalapprenticenum).append(",");
/* 128 */     _sb_.append(this.aleardy_awarded_cfg_id_set).append(",");
/* 129 */     _sb_.append(this.is_chu_shi_state).append(",");
/* 130 */     _sb_.append(this.now_pay_respect_times).append(",");
/* 131 */     _sb_.append(")");
/* 132 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SSyncShiTuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */