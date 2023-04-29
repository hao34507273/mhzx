/*     */ package mzm.gsp.blacklist;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class BlackRole
/*     */   implements Marshal
/*     */ {
/*     */   public static final int ST_OFFLINE = 0;
/*     */   public static final int ST_ONLINE = 1;
/*     */   public long roleid;
/*     */   public int level;
/*     */   public String name;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int status;
/*     */   public int avatarid;
/*     */   public int avatar_frame;
/*     */   
/*     */   public BlackRole()
/*     */   {
/*  24 */     this.name = "";
/*     */   }
/*     */   
/*     */   public BlackRole(long _roleid_, int _level_, String _name_, int _menpai_, int _gender_, int _status_, int _avatarid_, int _avatar_frame_) {
/*  28 */     this.roleid = _roleid_;
/*  29 */     this.level = _level_;
/*  30 */     this.name = _name_;
/*  31 */     this.menpai = _menpai_;
/*  32 */     this.gender = _gender_;
/*  33 */     this.status = _status_;
/*  34 */     this.avatarid = _avatarid_;
/*  35 */     this.avatar_frame = _avatar_frame_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.roleid);
/*  44 */     _os_.marshal(this.level);
/*  45 */     _os_.marshal(this.name, "UTF-16LE");
/*  46 */     _os_.marshal(this.menpai);
/*  47 */     _os_.marshal(this.gender);
/*  48 */     _os_.marshal(this.status);
/*  49 */     _os_.marshal(this.avatarid);
/*  50 */     _os_.marshal(this.avatar_frame);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.level = _os_.unmarshal_int();
/*  57 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  58 */     this.menpai = _os_.unmarshal_int();
/*  59 */     this.gender = _os_.unmarshal_int();
/*  60 */     this.status = _os_.unmarshal_int();
/*  61 */     this.avatarid = _os_.unmarshal_int();
/*  62 */     this.avatar_frame = _os_.unmarshal_int();
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof BlackRole)) {
/*  69 */       BlackRole _o_ = (BlackRole)_o1_;
/*  70 */       if (this.roleid != _o_.roleid) return false;
/*  71 */       if (this.level != _o_.level) return false;
/*  72 */       if (!this.name.equals(_o_.name)) return false;
/*  73 */       if (this.menpai != _o_.menpai) return false;
/*  74 */       if (this.gender != _o_.gender) return false;
/*  75 */       if (this.status != _o_.status) return false;
/*  76 */       if (this.avatarid != _o_.avatarid) return false;
/*  77 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += this.level;
/*  87 */     _h_ += this.name.hashCode();
/*  88 */     _h_ += this.menpai;
/*  89 */     _h_ += this.gender;
/*  90 */     _h_ += this.status;
/*  91 */     _h_ += this.avatarid;
/*  92 */     _h_ += this.avatar_frame;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.roleid).append(",");
/* 100 */     _sb_.append(this.level).append(",");
/* 101 */     _sb_.append("T").append(this.name.length()).append(",");
/* 102 */     _sb_.append(this.menpai).append(",");
/* 103 */     _sb_.append(this.gender).append(",");
/* 104 */     _sb_.append(this.status).append(",");
/* 105 */     _sb_.append(this.avatarid).append(",");
/* 106 */     _sb_.append(this.avatar_frame).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\BlackRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */