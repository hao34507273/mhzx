/*     */ package mzm.gsp.superequipment;
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
/*     */ 
/*     */ 
/*     */ public class SUpgradeWuShiSuccess
/*     */   extends __SUpgradeWuShiSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618775;
/*     */   public int wushicfgid;
/*     */   public int lastwushicfgid;
/*     */   public int fragmentcount;
/*     */   public int isactivate;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618775;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUpgradeWuShiSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUpgradeWuShiSuccess(int _wushicfgid_, int _lastwushicfgid_, int _fragmentcount_, int _isactivate_)
/*     */   {
/*  39 */     this.wushicfgid = _wushicfgid_;
/*  40 */     this.lastwushicfgid = _lastwushicfgid_;
/*  41 */     this.fragmentcount = _fragmentcount_;
/*  42 */     this.isactivate = _isactivate_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.wushicfgid);
/*  51 */     _os_.marshal(this.lastwushicfgid);
/*  52 */     _os_.marshal(this.fragmentcount);
/*  53 */     _os_.marshal(this.isactivate);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.wushicfgid = _os_.unmarshal_int();
/*  59 */     this.lastwushicfgid = _os_.unmarshal_int();
/*  60 */     this.fragmentcount = _os_.unmarshal_int();
/*  61 */     this.isactivate = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SUpgradeWuShiSuccess)) {
/*  71 */       SUpgradeWuShiSuccess _o_ = (SUpgradeWuShiSuccess)_o1_;
/*  72 */       if (this.wushicfgid != _o_.wushicfgid) return false;
/*  73 */       if (this.lastwushicfgid != _o_.lastwushicfgid) return false;
/*  74 */       if (this.fragmentcount != _o_.fragmentcount) return false;
/*  75 */       if (this.isactivate != _o_.isactivate) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.wushicfgid;
/*  84 */     _h_ += this.lastwushicfgid;
/*  85 */     _h_ += this.fragmentcount;
/*  86 */     _h_ += this.isactivate;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.wushicfgid).append(",");
/*  94 */     _sb_.append(this.lastwushicfgid).append(",");
/*  95 */     _sb_.append(this.fragmentcount).append(",");
/*  96 */     _sb_.append(this.isactivate).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUpgradeWuShiSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.wushicfgid - _o_.wushicfgid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.lastwushicfgid - _o_.lastwushicfgid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.fragmentcount - _o_.fragmentcount;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.isactivate - _o_.isactivate;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SUpgradeWuShiSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */