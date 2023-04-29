/*     */ package mzm.gsp.instance;
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
/*     */ public class SSynAwardItemInfo
/*     */   extends __SSynAwardItemInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591375;
/*     */   public long awarduuid;
/*     */   public int itemid;
/*     */   public ArrayList<RoleInfo> roles;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12591375;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynAwardItemInfo()
/*     */   {
/*  35 */     this.roles = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynAwardItemInfo(long _awarduuid_, int _itemid_, ArrayList<RoleInfo> _roles_) {
/*  39 */     this.awarduuid = _awarduuid_;
/*  40 */     this.itemid = _itemid_;
/*  41 */     this.roles = _roles_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (RoleInfo _v_ : this.roles)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.awarduuid);
/*  52 */     _os_.marshal(this.itemid);
/*  53 */     _os_.compact_uint32(this.roles.size());
/*  54 */     for (RoleInfo _v_ : this.roles) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.awarduuid = _os_.unmarshal_long();
/*  62 */     this.itemid = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       RoleInfo _v_ = new RoleInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.roles.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSynAwardItemInfo)) {
/*  77 */       SSynAwardItemInfo _o_ = (SSynAwardItemInfo)_o1_;
/*  78 */       if (this.awarduuid != _o_.awarduuid) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
/*  80 */       if (!this.roles.equals(_o_.roles)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.awarduuid;
/*  89 */     _h_ += this.itemid;
/*  90 */     _h_ += this.roles.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.awarduuid).append(",");
/*  98 */     _sb_.append(this.itemid).append(",");
/*  99 */     _sb_.append(this.roles).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SSynAwardItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */