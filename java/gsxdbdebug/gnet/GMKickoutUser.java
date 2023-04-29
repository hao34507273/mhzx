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
/*     */ 
/*     */ 
/*     */ public class GMKickoutUser
/*     */   extends __GMKickoutUser__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 354;
/*     */   public Octets gmuserid;
/*     */   public int localsid;
/*     */   public Octets kickuserid;
/*     */   public int forbid_time;
/*     */   public Octets reason;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 354;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GMKickoutUser()
/*     */   {
/*  37 */     this.gmuserid = new Octets();
/*  38 */     this.kickuserid = new Octets();
/*  39 */     this.forbid_time = 600;
/*  40 */     this.reason = new Octets();
/*     */   }
/*     */   
/*     */   public GMKickoutUser(Octets _gmuserid_, int _localsid_, Octets _kickuserid_, int _forbid_time_, Octets _reason_) {
/*  44 */     this.gmuserid = _gmuserid_;
/*  45 */     this.localsid = _localsid_;
/*  46 */     this.kickuserid = _kickuserid_;
/*  47 */     this.forbid_time = _forbid_time_;
/*  48 */     this.reason = _reason_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.gmuserid);
/*  57 */     _os_.marshal(this.localsid);
/*  58 */     _os_.marshal(this.kickuserid);
/*  59 */     _os_.marshal(this.forbid_time);
/*  60 */     _os_.marshal(this.reason);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.gmuserid = _os_.unmarshal_Octets();
/*  66 */     this.localsid = _os_.unmarshal_int();
/*  67 */     this.kickuserid = _os_.unmarshal_Octets();
/*  68 */     this.forbid_time = _os_.unmarshal_int();
/*  69 */     this.reason = _os_.unmarshal_Octets();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof GMKickoutUser)) {
/*  79 */       GMKickoutUser _o_ = (GMKickoutUser)_o1_;
/*  80 */       if (!this.gmuserid.equals(_o_.gmuserid)) return false;
/*  81 */       if (this.localsid != _o_.localsid) return false;
/*  82 */       if (!this.kickuserid.equals(_o_.kickuserid)) return false;
/*  83 */       if (this.forbid_time != _o_.forbid_time) return false;
/*  84 */       if (!this.reason.equals(_o_.reason)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.gmuserid.hashCode();
/*  93 */     _h_ += this.localsid;
/*  94 */     _h_ += this.kickuserid.hashCode();
/*  95 */     _h_ += this.forbid_time;
/*  96 */     _h_ += this.reason.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append("B").append(this.gmuserid.size()).append(",");
/* 104 */     _sb_.append(this.localsid).append(",");
/* 105 */     _sb_.append("B").append(this.kickuserid.size()).append(",");
/* 106 */     _sb_.append(this.forbid_time).append(",");
/* 107 */     _sb_.append("B").append(this.reason.size()).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GMKickoutUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */