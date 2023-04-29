/*     */ package mzm.gsp.qingfu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SApplyOrderIDRep
/*     */   extends __SApplyOrderIDRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588801;
/*     */   public int retcode;
/*     */   public int cfgid;
/*     */   public Octets gameorderid;
/*     */   public Octets ordercallbackurl;
/*     */   public Octets ext;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588801;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SApplyOrderIDRep()
/*     */   {
/*  37 */     this.gameorderid = new Octets();
/*  38 */     this.ordercallbackurl = new Octets();
/*  39 */     this.ext = new Octets();
/*     */   }
/*     */   
/*     */   public SApplyOrderIDRep(int _retcode_, int _cfgid_, Octets _gameorderid_, Octets _ordercallbackurl_, Octets _ext_) {
/*  43 */     this.retcode = _retcode_;
/*  44 */     this.cfgid = _cfgid_;
/*  45 */     this.gameorderid = _gameorderid_;
/*  46 */     this.ordercallbackurl = _ordercallbackurl_;
/*  47 */     this.ext = _ext_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     _os_.marshal(this.cfgid);
/*  57 */     _os_.marshal(this.gameorderid);
/*  58 */     _os_.marshal(this.ordercallbackurl);
/*  59 */     _os_.marshal(this.ext);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.retcode = _os_.unmarshal_int();
/*  65 */     this.cfgid = _os_.unmarshal_int();
/*  66 */     this.gameorderid = _os_.unmarshal_Octets();
/*  67 */     this.ordercallbackurl = _os_.unmarshal_Octets();
/*  68 */     this.ext = _os_.unmarshal_Octets();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SApplyOrderIDRep)) {
/*  78 */       SApplyOrderIDRep _o_ = (SApplyOrderIDRep)_o1_;
/*  79 */       if (this.retcode != _o_.retcode) return false;
/*  80 */       if (this.cfgid != _o_.cfgid) return false;
/*  81 */       if (!this.gameorderid.equals(_o_.gameorderid)) return false;
/*  82 */       if (!this.ordercallbackurl.equals(_o_.ordercallbackurl)) return false;
/*  83 */       if (!this.ext.equals(_o_.ext)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.retcode;
/*  92 */     _h_ += this.cfgid;
/*  93 */     _h_ += this.gameorderid.hashCode();
/*  94 */     _h_ += this.ordercallbackurl.hashCode();
/*  95 */     _h_ += this.ext.hashCode();
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.retcode).append(",");
/* 103 */     _sb_.append(this.cfgid).append(",");
/* 104 */     _sb_.append("B").append(this.gameorderid.size()).append(",");
/* 105 */     _sb_.append("B").append(this.ordercallbackurl.size()).append(",");
/* 106 */     _sb_.append("B").append(this.ext.size()).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SApplyOrderIDRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */