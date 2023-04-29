/*     */ package mzm.gsp.addiction;
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
/*     */ public class SReportOnlineTimeSuccess
/*     */   extends __SReportOnlineTimeSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12608003;
/*     */   public static final int ONLINE_TIME = 1;
/*     */   public static final int TOTAL_ONLINE_TIME = 2;
/*     */   public byte remind;
/*     */   public int remind_type;
/*     */   public int online_time;
/*     */   public int left_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12608003;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReportOnlineTimeSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReportOnlineTimeSuccess(byte _remind_, int _remind_type_, int _online_time_, int _left_time_)
/*     */   {
/*  42 */     this.remind = _remind_;
/*  43 */     this.remind_type = _remind_type_;
/*  44 */     this.online_time = _online_time_;
/*  45 */     this.left_time = _left_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.remind);
/*  54 */     _os_.marshal(this.remind_type);
/*  55 */     _os_.marshal(this.online_time);
/*  56 */     _os_.marshal(this.left_time);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.remind = _os_.unmarshal_byte();
/*  62 */     this.remind_type = _os_.unmarshal_int();
/*  63 */     this.online_time = _os_.unmarshal_int();
/*  64 */     this.left_time = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SReportOnlineTimeSuccess)) {
/*  74 */       SReportOnlineTimeSuccess _o_ = (SReportOnlineTimeSuccess)_o1_;
/*  75 */       if (this.remind != _o_.remind) return false;
/*  76 */       if (this.remind_type != _o_.remind_type) return false;
/*  77 */       if (this.online_time != _o_.online_time) return false;
/*  78 */       if (this.left_time != _o_.left_time) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.remind;
/*  87 */     _h_ += this.remind_type;
/*  88 */     _h_ += this.online_time;
/*  89 */     _h_ += this.left_time;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.remind).append(",");
/*  97 */     _sb_.append(this.remind_type).append(",");
/*  98 */     _sb_.append(this.online_time).append(",");
/*  99 */     _sb_.append(this.left_time).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SReportOnlineTimeSuccess _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.remind - _o_.remind;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.remind_type - _o_.remind_type;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.online_time - _o_.online_time;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.left_time - _o_.left_time;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\SReportOnlineTimeSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */