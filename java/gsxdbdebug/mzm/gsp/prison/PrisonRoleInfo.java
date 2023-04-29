/*     */ package mzm.gsp.prison;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class PrisonRoleInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public Octets name;
/*     */   public int avatarid;
/*     */   public int gender;
/*     */   public int menpai;
/*     */   public int level;
/*     */   public long endtimestamp;
/*     */   public int avatarframeid;
/*     */   
/*     */   public PrisonRoleInfo()
/*     */   {
/*  21 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public PrisonRoleInfo(long _roleid_, Octets _name_, int _avatarid_, int _gender_, int _menpai_, int _level_, long _endtimestamp_, int _avatarframeid_) {
/*  25 */     this.roleid = _roleid_;
/*  26 */     this.name = _name_;
/*  27 */     this.avatarid = _avatarid_;
/*  28 */     this.gender = _gender_;
/*  29 */     this.menpai = _menpai_;
/*  30 */     this.level = _level_;
/*  31 */     this.endtimestamp = _endtimestamp_;
/*  32 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.roleid);
/*  41 */     _os_.marshal(this.name);
/*  42 */     _os_.marshal(this.avatarid);
/*  43 */     _os_.marshal(this.gender);
/*  44 */     _os_.marshal(this.menpai);
/*  45 */     _os_.marshal(this.level);
/*  46 */     _os_.marshal(this.endtimestamp);
/*  47 */     _os_.marshal(this.avatarframeid);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  52 */     this.roleid = _os_.unmarshal_long();
/*  53 */     this.name = _os_.unmarshal_Octets();
/*  54 */     this.avatarid = _os_.unmarshal_int();
/*  55 */     this.gender = _os_.unmarshal_int();
/*  56 */     this.menpai = _os_.unmarshal_int();
/*  57 */     this.level = _os_.unmarshal_int();
/*  58 */     this.endtimestamp = _os_.unmarshal_long();
/*  59 */     this.avatarframeid = _os_.unmarshal_int();
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  64 */     if (_o1_ == this) return true;
/*  65 */     if ((_o1_ instanceof PrisonRoleInfo)) {
/*  66 */       PrisonRoleInfo _o_ = (PrisonRoleInfo)_o1_;
/*  67 */       if (this.roleid != _o_.roleid) return false;
/*  68 */       if (!this.name.equals(_o_.name)) return false;
/*  69 */       if (this.avatarid != _o_.avatarid) return false;
/*  70 */       if (this.gender != _o_.gender) return false;
/*  71 */       if (this.menpai != _o_.menpai) return false;
/*  72 */       if (this.level != _o_.level) return false;
/*  73 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/*  74 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.roleid;
/*  83 */     _h_ += this.name.hashCode();
/*  84 */     _h_ += this.avatarid;
/*  85 */     _h_ += this.gender;
/*  86 */     _h_ += this.menpai;
/*  87 */     _h_ += this.level;
/*  88 */     _h_ += (int)this.endtimestamp;
/*  89 */     _h_ += this.avatarframeid;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.roleid).append(",");
/*  97 */     _sb_.append("B").append(this.name.size()).append(",");
/*  98 */     _sb_.append(this.avatarid).append(",");
/*  99 */     _sb_.append(this.gender).append(",");
/* 100 */     _sb_.append(this.menpai).append(",");
/* 101 */     _sb_.append(this.level).append(",");
/* 102 */     _sb_.append(this.endtimestamp).append(",");
/* 103 */     _sb_.append(this.avatarframeid).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\PrisonRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */