/*     */ package mzm.gsp.breakegg;
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
/*     */ public class SSynInviteInfo
/*     */   extends __SSynInviteInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623368;
/*     */   public RoleInfo inviter_info;
/*     */   public int invite_type;
/*     */   public long session_id;
/*     */   public Octets extro_info;
/*     */   public long end_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623368;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynInviteInfo()
/*     */   {
/*  37 */     this.inviter_info = new RoleInfo();
/*  38 */     this.extro_info = new Octets();
/*     */   }
/*     */   
/*     */   public SSynInviteInfo(RoleInfo _inviter_info_, int _invite_type_, long _session_id_, Octets _extro_info_, long _end_time_) {
/*  42 */     this.inviter_info = _inviter_info_;
/*  43 */     this.invite_type = _invite_type_;
/*  44 */     this.session_id = _session_id_;
/*  45 */     this.extro_info = _extro_info_;
/*  46 */     this.end_time = _end_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.inviter_info._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.inviter_info);
/*  56 */     _os_.marshal(this.invite_type);
/*  57 */     _os_.marshal(this.session_id);
/*  58 */     _os_.marshal(this.extro_info);
/*  59 */     _os_.marshal(this.end_time);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.inviter_info.unmarshal(_os_);
/*  65 */     this.invite_type = _os_.unmarshal_int();
/*  66 */     this.session_id = _os_.unmarshal_long();
/*  67 */     this.extro_info = _os_.unmarshal_Octets();
/*  68 */     this.end_time = _os_.unmarshal_long();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SSynInviteInfo)) {
/*  78 */       SSynInviteInfo _o_ = (SSynInviteInfo)_o1_;
/*  79 */       if (!this.inviter_info.equals(_o_.inviter_info)) return false;
/*  80 */       if (this.invite_type != _o_.invite_type) return false;
/*  81 */       if (this.session_id != _o_.session_id) return false;
/*  82 */       if (!this.extro_info.equals(_o_.extro_info)) return false;
/*  83 */       if (this.end_time != _o_.end_time) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.inviter_info.hashCode();
/*  92 */     _h_ += this.invite_type;
/*  93 */     _h_ += (int)this.session_id;
/*  94 */     _h_ += this.extro_info.hashCode();
/*  95 */     _h_ += (int)this.end_time;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.inviter_info).append(",");
/* 103 */     _sb_.append(this.invite_type).append(",");
/* 104 */     _sb_.append(this.session_id).append(",");
/* 105 */     _sb_.append("B").append(this.extro_info.size()).append(",");
/* 106 */     _sb_.append(this.end_time).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SSynInviteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */