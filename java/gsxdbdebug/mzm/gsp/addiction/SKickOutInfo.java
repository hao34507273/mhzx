/*     */ package mzm.gsp.addiction;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SKickOutInfo
/*     */   extends __SKickOutInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12608005;
/*     */   public static final int ONLINE_TIME = 1;
/*     */   public static final int TOTAL_ONLINE_TIME = 2;
/*     */   public static final int SPILL_ONLINE_TIME = 3;
/*     */   public int reason;
/*     */   public int identity;
/*     */   public int kickout_type;
/*     */   public int total_online_time;
/*     */   public int online_time;
/*     */   public int rest_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12608005;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SKickOutInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SKickOutInfo(int _reason_, int _identity_, int _kickout_type_, int _total_online_time_, int _online_time_, int _rest_time_)
/*     */   {
/*  45 */     this.reason = _reason_;
/*  46 */     this.identity = _identity_;
/*  47 */     this.kickout_type = _kickout_type_;
/*  48 */     this.total_online_time = _total_online_time_;
/*  49 */     this.online_time = _online_time_;
/*  50 */     this.rest_time = _rest_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.reason);
/*  59 */     _os_.marshal(this.identity);
/*  60 */     _os_.marshal(this.kickout_type);
/*  61 */     _os_.marshal(this.total_online_time);
/*  62 */     _os_.marshal(this.online_time);
/*  63 */     _os_.marshal(this.rest_time);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.reason = _os_.unmarshal_int();
/*  69 */     this.identity = _os_.unmarshal_int();
/*  70 */     this.kickout_type = _os_.unmarshal_int();
/*  71 */     this.total_online_time = _os_.unmarshal_int();
/*  72 */     this.online_time = _os_.unmarshal_int();
/*  73 */     this.rest_time = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SKickOutInfo)) {
/*  83 */       SKickOutInfo _o_ = (SKickOutInfo)_o1_;
/*  84 */       if (this.reason != _o_.reason) return false;
/*  85 */       if (this.identity != _o_.identity) return false;
/*  86 */       if (this.kickout_type != _o_.kickout_type) return false;
/*  87 */       if (this.total_online_time != _o_.total_online_time) return false;
/*  88 */       if (this.online_time != _o_.online_time) return false;
/*  89 */       if (this.rest_time != _o_.rest_time) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.reason;
/*  98 */     _h_ += this.identity;
/*  99 */     _h_ += this.kickout_type;
/* 100 */     _h_ += this.total_online_time;
/* 101 */     _h_ += this.online_time;
/* 102 */     _h_ += this.rest_time;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.reason).append(",");
/* 110 */     _sb_.append(this.identity).append(",");
/* 111 */     _sb_.append(this.kickout_type).append(",");
/* 112 */     _sb_.append(this.total_online_time).append(",");
/* 113 */     _sb_.append(this.online_time).append(",");
/* 114 */     _sb_.append(this.rest_time).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SKickOutInfo _o_) {
/* 120 */     if (_o_ == this) return 0;
/* 121 */     int _c_ = 0;
/* 122 */     _c_ = this.reason - _o_.reason;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.identity - _o_.identity;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.kickout_type - _o_.kickout_type;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.total_online_time - _o_.total_online_time;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.online_time - _o_.online_time;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = this.rest_time - _o_.rest_time;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\SKickOutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */