/*     */ package mzm.gsp.idip;
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
/*     */ 
/*     */ public class SIdipRoleBanPlayInfo
/*     */   extends __SIdipRoleBanPlayInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601098;
/*     */   public Octets name;
/*     */   public long unbantime;
/*     */   public Octets reason;
/*     */   public int playtype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601098;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SIdipRoleBanPlayInfo()
/*     */   {
/*  36 */     this.name = new Octets();
/*  37 */     this.reason = new Octets();
/*     */   }
/*     */   
/*     */   public SIdipRoleBanPlayInfo(Octets _name_, long _unbantime_, Octets _reason_, int _playtype_) {
/*  41 */     this.name = _name_;
/*  42 */     this.unbantime = _unbantime_;
/*  43 */     this.reason = _reason_;
/*  44 */     this.playtype = _playtype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.name);
/*  53 */     _os_.marshal(this.unbantime);
/*  54 */     _os_.marshal(this.reason);
/*  55 */     _os_.marshal(this.playtype);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.name = _os_.unmarshal_Octets();
/*  61 */     this.unbantime = _os_.unmarshal_long();
/*  62 */     this.reason = _os_.unmarshal_Octets();
/*  63 */     this.playtype = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SIdipRoleBanPlayInfo)) {
/*  73 */       SIdipRoleBanPlayInfo _o_ = (SIdipRoleBanPlayInfo)_o1_;
/*  74 */       if (!this.name.equals(_o_.name)) return false;
/*  75 */       if (this.unbantime != _o_.unbantime) return false;
/*  76 */       if (!this.reason.equals(_o_.reason)) return false;
/*  77 */       if (this.playtype != _o_.playtype) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.name.hashCode();
/*  86 */     _h_ += (int)this.unbantime;
/*  87 */     _h_ += this.reason.hashCode();
/*  88 */     _h_ += this.playtype;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append("B").append(this.name.size()).append(",");
/*  96 */     _sb_.append(this.unbantime).append(",");
/*  97 */     _sb_.append("B").append(this.reason.size()).append(",");
/*  98 */     _sb_.append(this.playtype).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\SIdipRoleBanPlayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */