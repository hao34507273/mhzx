/*     */ package mzm.gsp.marriage;
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
/*     */ public class SSynMarriageInfo
/*     */   extends __SSynMarriageInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12599815;
/*     */   public RoleInfo roleinfo;
/*     */   public int marrrytimesec;
/*     */   public int marriagetitleid;
/*     */   public long roleid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12599815;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynMarriageInfo()
/*     */   {
/*  36 */     this.roleinfo = new RoleInfo();
/*     */   }
/*     */   
/*     */   public SSynMarriageInfo(RoleInfo _roleinfo_, int _marrrytimesec_, int _marriagetitleid_, long _roleid_) {
/*  40 */     this.roleinfo = _roleinfo_;
/*  41 */     this.marrrytimesec = _marrrytimesec_;
/*  42 */     this.marriagetitleid = _marriagetitleid_;
/*  43 */     this.roleid = _roleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.roleinfo._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleinfo);
/*  53 */     _os_.marshal(this.marrrytimesec);
/*  54 */     _os_.marshal(this.marriagetitleid);
/*  55 */     _os_.marshal(this.roleid);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.roleinfo.unmarshal(_os_);
/*  61 */     this.marrrytimesec = _os_.unmarshal_int();
/*  62 */     this.marriagetitleid = _os_.unmarshal_int();
/*  63 */     this.roleid = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SSynMarriageInfo)) {
/*  73 */       SSynMarriageInfo _o_ = (SSynMarriageInfo)_o1_;
/*  74 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  75 */       if (this.marrrytimesec != _o_.marrrytimesec) return false;
/*  76 */       if (this.marriagetitleid != _o_.marriagetitleid) return false;
/*  77 */       if (this.roleid != _o_.roleid) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.roleinfo.hashCode();
/*  86 */     _h_ += this.marrrytimesec;
/*  87 */     _h_ += this.marriagetitleid;
/*  88 */     _h_ += (int)this.roleid;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.roleinfo).append(",");
/*  96 */     _sb_.append(this.marrrytimesec).append(",");
/*  97 */     _sb_.append(this.marriagetitleid).append(",");
/*  98 */     _sb_.append(this.roleid).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SSynMarriageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */