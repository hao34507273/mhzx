/*     */ package mzm.gsp.corps;
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
/*     */ public class SInviteCorpsTrs
/*     */   extends __SInviteCorpsTrs__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617475;
/*     */   public long inviter;
/*     */   public Octets name;
/*     */   public Octets corpsname;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617475;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SInviteCorpsTrs()
/*     */   {
/*  36 */     this.name = new Octets();
/*  37 */     this.corpsname = new Octets();
/*     */   }
/*     */   
/*     */   public SInviteCorpsTrs(long _inviter_, Octets _name_, Octets _corpsname_, long _sessionid_) {
/*  41 */     this.inviter = _inviter_;
/*  42 */     this.name = _name_;
/*  43 */     this.corpsname = _corpsname_;
/*  44 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.inviter);
/*  53 */     _os_.marshal(this.name);
/*  54 */     _os_.marshal(this.corpsname);
/*  55 */     _os_.marshal(this.sessionid);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.inviter = _os_.unmarshal_long();
/*  61 */     this.name = _os_.unmarshal_Octets();
/*  62 */     this.corpsname = _os_.unmarshal_Octets();
/*  63 */     this.sessionid = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SInviteCorpsTrs)) {
/*  73 */       SInviteCorpsTrs _o_ = (SInviteCorpsTrs)_o1_;
/*  74 */       if (this.inviter != _o_.inviter) return false;
/*  75 */       if (!this.name.equals(_o_.name)) return false;
/*  76 */       if (!this.corpsname.equals(_o_.corpsname)) return false;
/*  77 */       if (this.sessionid != _o_.sessionid) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.inviter;
/*  86 */     _h_ += this.name.hashCode();
/*  87 */     _h_ += this.corpsname.hashCode();
/*  88 */     _h_ += (int)this.sessionid;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.inviter).append(",");
/*  96 */     _sb_.append("B").append(this.name.size()).append(",");
/*  97 */     _sb_.append("B").append(this.corpsname.size()).append(",");
/*  98 */     _sb_.append(this.sessionid).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SInviteCorpsTrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */