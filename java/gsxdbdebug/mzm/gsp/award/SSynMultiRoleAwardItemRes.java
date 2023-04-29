/*     */ package mzm.gsp.award;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynMultiRoleAwardItemRes
/*     */   extends __SSynMultiRoleAwardItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12583435;
/*     */   public ArrayList<RoleInfo> roles;
/*     */   public ArrayList<Long> notawardroles;
/*     */   public long awarduuid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12583435;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynMultiRoleAwardItemRes()
/*     */   {
/*  35 */     this.roles = new ArrayList();
/*  36 */     this.notawardroles = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynMultiRoleAwardItemRes(ArrayList<RoleInfo> _roles_, ArrayList<Long> _notawardroles_, long _awarduuid_) {
/*  40 */     this.roles = _roles_;
/*  41 */     this.notawardroles = _notawardroles_;
/*  42 */     this.awarduuid = _awarduuid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (RoleInfo _v_ : this.roles)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.roles.size());
/*  53 */     for (RoleInfo _v_ : this.roles) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.compact_uint32(this.notawardroles.size());
/*  57 */     for (Long _v_ : this.notawardroles) {
/*  58 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  60 */     _os_.marshal(this.awarduuid);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       RoleInfo _v_ = new RoleInfo();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.roles.add(_v_);
/*     */     }
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  72 */       long _v_ = _os_.unmarshal_long();
/*  73 */       this.notawardroles.add(Long.valueOf(_v_));
/*     */     }
/*  75 */     this.awarduuid = _os_.unmarshal_long();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SSynMultiRoleAwardItemRes)) {
/*  85 */       SSynMultiRoleAwardItemRes _o_ = (SSynMultiRoleAwardItemRes)_o1_;
/*  86 */       if (!this.roles.equals(_o_.roles)) return false;
/*  87 */       if (!this.notawardroles.equals(_o_.notawardroles)) return false;
/*  88 */       if (this.awarduuid != _o_.awarduuid) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.roles.hashCode();
/*  97 */     _h_ += this.notawardroles.hashCode();
/*  98 */     _h_ += (int)this.awarduuid;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.roles).append(",");
/* 106 */     _sb_.append(this.notawardroles).append(",");
/* 107 */     _sb_.append(this.awarduuid).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SSynMultiRoleAwardItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */