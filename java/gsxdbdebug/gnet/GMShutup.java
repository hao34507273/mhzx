/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GMShutup
/*     */   extends __GMShutup__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 356;
/*     */   public Octets gmuserid;
/*     */   public int localsid;
/*     */   public Octets dstuserid;
/*     */   public int forbid_time;
/*     */   public Octets reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 356;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GMShutup()
/*     */   {
/*  35 */     this.gmuserid = new Octets();
/*  36 */     this.dstuserid = new Octets();
/*  37 */     this.reason = new Octets();
/*     */   }
/*     */   
/*     */   public GMShutup(Octets _gmuserid_, int _localsid_, Octets _dstuserid_, int _forbid_time_, Octets _reason_) {
/*  41 */     this.gmuserid = _gmuserid_;
/*  42 */     this.localsid = _localsid_;
/*  43 */     this.dstuserid = _dstuserid_;
/*  44 */     this.forbid_time = _forbid_time_;
/*  45 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.gmuserid);
/*  54 */     _os_.marshal(this.localsid);
/*  55 */     _os_.marshal(this.dstuserid);
/*  56 */     _os_.marshal(this.forbid_time);
/*  57 */     _os_.marshal(this.reason);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.gmuserid = _os_.unmarshal_Octets();
/*  63 */     this.localsid = _os_.unmarshal_int();
/*  64 */     this.dstuserid = _os_.unmarshal_Octets();
/*  65 */     this.forbid_time = _os_.unmarshal_int();
/*  66 */     this.reason = _os_.unmarshal_Octets();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof GMShutup)) {
/*  76 */       GMShutup _o_ = (GMShutup)_o1_;
/*  77 */       if (!this.gmuserid.equals(_o_.gmuserid)) return false;
/*  78 */       if (this.localsid != _o_.localsid) return false;
/*  79 */       if (!this.dstuserid.equals(_o_.dstuserid)) return false;
/*  80 */       if (this.forbid_time != _o_.forbid_time) return false;
/*  81 */       if (!this.reason.equals(_o_.reason)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.gmuserid.hashCode();
/*  90 */     _h_ += this.localsid;
/*  91 */     _h_ += this.dstuserid.hashCode();
/*  92 */     _h_ += this.forbid_time;
/*  93 */     _h_ += this.reason.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append("B").append(this.gmuserid.size()).append(",");
/* 101 */     _sb_.append(this.localsid).append(",");
/* 102 */     _sb_.append("B").append(this.dstuserid.size()).append(",");
/* 103 */     _sb_.append(this.forbid_time).append(",");
/* 104 */     _sb_.append("B").append(this.reason.size()).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GMShutup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */