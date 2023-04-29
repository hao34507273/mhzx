/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class RoleSelectionFinalInfo implements Marshal
/*     */ {
/*     */   public Octets userid;
/*     */   public long roleid;
/*     */   public Octets rolename;
/*     */   public int level;
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public int avatarid;
/*     */   
/*     */   public RoleSelectionFinalInfo()
/*     */   {
/*  20 */     this.userid = new Octets();
/*  21 */     this.roleid = 0L;
/*  22 */     this.rolename = new Octets();
/*  23 */     this.level = 0;
/*  24 */     this.gender = 0;
/*  25 */     this.occupation = 0;
/*     */   }
/*     */   
/*     */   public RoleSelectionFinalInfo(Octets _userid_, long _roleid_, Octets _rolename_, int _level_, int _gender_, int _occupation_, int _avatarid_) {
/*  29 */     this.userid = _userid_;
/*  30 */     this.roleid = _roleid_;
/*  31 */     this.rolename = _rolename_;
/*  32 */     this.level = _level_;
/*  33 */     this.gender = _gender_;
/*  34 */     this.occupation = _occupation_;
/*  35 */     this.avatarid = _avatarid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.userid);
/*  44 */     _os_.marshal(this.roleid);
/*  45 */     _os_.marshal(this.rolename);
/*  46 */     _os_.marshal(this.level);
/*  47 */     _os_.marshal(this.gender);
/*  48 */     _os_.marshal(this.occupation);
/*  49 */     _os_.marshal(this.avatarid);
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  54 */     this.userid = _os_.unmarshal_Octets();
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.rolename = _os_.unmarshal_Octets();
/*  57 */     this.level = _os_.unmarshal_int();
/*  58 */     this.gender = _os_.unmarshal_int();
/*  59 */     this.occupation = _os_.unmarshal_int();
/*  60 */     this.avatarid = _os_.unmarshal_int();
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof RoleSelectionFinalInfo)) {
/*  67 */       RoleSelectionFinalInfo _o_ = (RoleSelectionFinalInfo)_o1_;
/*  68 */       if (!this.userid.equals(_o_.userid)) return false;
/*  69 */       if (this.roleid != _o_.roleid) return false;
/*  70 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  71 */       if (this.level != _o_.level) return false;
/*  72 */       if (this.gender != _o_.gender) return false;
/*  73 */       if (this.occupation != _o_.occupation) return false;
/*  74 */       if (this.avatarid != _o_.avatarid) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.userid.hashCode();
/*  83 */     _h_ += (int)this.roleid;
/*  84 */     _h_ += this.rolename.hashCode();
/*  85 */     _h_ += this.level;
/*  86 */     _h_ += this.gender;
/*  87 */     _h_ += this.occupation;
/*  88 */     _h_ += this.avatarid;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append("B").append(this.userid.size()).append(",");
/*  96 */     _sb_.append(this.roleid).append(",");
/*  97 */     _sb_.append("B").append(this.rolename.size()).append(",");
/*  98 */     _sb_.append(this.level).append(",");
/*  99 */     _sb_.append(this.gender).append(",");
/* 100 */     _sb_.append(this.occupation).append(",");
/* 101 */     _sb_.append(this.avatarid).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoleSelectionFinalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */