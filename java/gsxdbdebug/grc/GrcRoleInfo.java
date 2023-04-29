/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GrcRoleInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public Octets rolename;
/*     */   public int level;
/*     */   public byte gender;
/*     */   public int occupation;
/*     */   public int avatarid;
/*     */   public int avatar_frameid;
/*     */   public int fighting_capacity;
/*     */   public byte platform;
/*     */   public int zoneid;
/*     */   public Octets extra_info;
/*     */   
/*     */   public GrcRoleInfo()
/*     */   {
/*  22 */     this.rolename = new Octets();
/*  23 */     this.extra_info = new Octets();
/*     */   }
/*     */   
/*     */   public GrcRoleInfo(long _roleid_, Octets _rolename_, int _level_, byte _gender_, int _occupation_, int _avatarid_, int _avatar_frameid_, int _fighting_capacity_, byte _platform_, int _zoneid_, Octets _extra_info_) {
/*  27 */     this.roleid = _roleid_;
/*  28 */     this.rolename = _rolename_;
/*  29 */     this.level = _level_;
/*  30 */     this.gender = _gender_;
/*  31 */     this.occupation = _occupation_;
/*  32 */     this.avatarid = _avatarid_;
/*  33 */     this.avatar_frameid = _avatar_frameid_;
/*  34 */     this.fighting_capacity = _fighting_capacity_;
/*  35 */     this.platform = _platform_;
/*  36 */     this.zoneid = _zoneid_;
/*  37 */     this.extra_info = _extra_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  45 */     _os_.marshal(this.roleid);
/*  46 */     _os_.marshal(this.rolename);
/*  47 */     _os_.marshal(this.level);
/*  48 */     _os_.marshal(this.gender);
/*  49 */     _os_.marshal(this.occupation);
/*  50 */     _os_.marshal(this.avatarid);
/*  51 */     _os_.marshal(this.avatar_frameid);
/*  52 */     _os_.marshal(this.fighting_capacity);
/*  53 */     _os_.marshal(this.platform);
/*  54 */     _os_.marshal(this.zoneid);
/*  55 */     _os_.marshal(this.extra_info);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  60 */     this.roleid = _os_.unmarshal_long();
/*  61 */     this.rolename = _os_.unmarshal_Octets();
/*  62 */     this.level = _os_.unmarshal_int();
/*  63 */     this.gender = _os_.unmarshal_byte();
/*  64 */     this.occupation = _os_.unmarshal_int();
/*  65 */     this.avatarid = _os_.unmarshal_int();
/*  66 */     this.avatar_frameid = _os_.unmarshal_int();
/*  67 */     this.fighting_capacity = _os_.unmarshal_int();
/*  68 */     this.platform = _os_.unmarshal_byte();
/*  69 */     this.zoneid = _os_.unmarshal_int();
/*  70 */     this.extra_info = _os_.unmarshal_Octets();
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof GrcRoleInfo)) {
/*  77 */       GrcRoleInfo _o_ = (GrcRoleInfo)_o1_;
/*  78 */       if (this.roleid != _o_.roleid) return false;
/*  79 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  80 */       if (this.level != _o_.level) return false;
/*  81 */       if (this.gender != _o_.gender) return false;
/*  82 */       if (this.occupation != _o_.occupation) return false;
/*  83 */       if (this.avatarid != _o_.avatarid) return false;
/*  84 */       if (this.avatar_frameid != _o_.avatar_frameid) return false;
/*  85 */       if (this.fighting_capacity != _o_.fighting_capacity) return false;
/*  86 */       if (this.platform != _o_.platform) return false;
/*  87 */       if (this.zoneid != _o_.zoneid) return false;
/*  88 */       if (!this.extra_info.equals(_o_.extra_info)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += (int)this.roleid;
/*  97 */     _h_ += this.rolename.hashCode();
/*  98 */     _h_ += this.level;
/*  99 */     _h_ += this.gender;
/* 100 */     _h_ += this.occupation;
/* 101 */     _h_ += this.avatarid;
/* 102 */     _h_ += this.avatar_frameid;
/* 103 */     _h_ += this.fighting_capacity;
/* 104 */     _h_ += this.platform;
/* 105 */     _h_ += this.zoneid;
/* 106 */     _h_ += this.extra_info.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.roleid).append(",");
/* 114 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 115 */     _sb_.append(this.level).append(",");
/* 116 */     _sb_.append(this.gender).append(",");
/* 117 */     _sb_.append(this.occupation).append(",");
/* 118 */     _sb_.append(this.avatarid).append(",");
/* 119 */     _sb_.append(this.avatar_frameid).append(",");
/* 120 */     _sb_.append(this.fighting_capacity).append(",");
/* 121 */     _sb_.append(this.platform).append(",");
/* 122 */     _sb_.append(this.zoneid).append(",");
/* 123 */     _sb_.append("B").append(this.extra_info.size()).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */