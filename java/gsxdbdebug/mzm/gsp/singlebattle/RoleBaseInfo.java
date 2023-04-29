/*     */ package mzm.gsp.singlebattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class RoleBaseInfo implements Marshal
/*     */ {
/*     */   public static final int STATE_NORMAL = 1;
/*     */   public static final int STATE_OUTLINE = 2;
/*     */   public static final int STATE_LEAVE = 3;
/*     */   public Octets name;
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public int level;
/*     */   public int avatarid;
/*     */   public int zoneid;
/*     */   public int state;
/*     */   public int num;
/*     */   public int avatarframeid;
/*     */   
/*     */   public RoleBaseInfo()
/*     */   {
/*  24 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public RoleBaseInfo(Octets _name_, int _gender_, int _occupation_, int _level_, int _avatarid_, int _zoneid_, int _state_, int _num_, int _avatarframeid_) {
/*  28 */     this.name = _name_;
/*  29 */     this.gender = _gender_;
/*  30 */     this.occupation = _occupation_;
/*  31 */     this.level = _level_;
/*  32 */     this.avatarid = _avatarid_;
/*  33 */     this.zoneid = _zoneid_;
/*  34 */     this.state = _state_;
/*  35 */     this.num = _num_;
/*  36 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  44 */     _os_.marshal(this.name);
/*  45 */     _os_.marshal(this.gender);
/*  46 */     _os_.marshal(this.occupation);
/*  47 */     _os_.marshal(this.level);
/*  48 */     _os_.marshal(this.avatarid);
/*  49 */     _os_.marshal(this.zoneid);
/*  50 */     _os_.marshal(this.state);
/*  51 */     _os_.marshal(this.num);
/*  52 */     _os_.marshal(this.avatarframeid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     this.name = _os_.unmarshal_Octets();
/*  58 */     this.gender = _os_.unmarshal_int();
/*  59 */     this.occupation = _os_.unmarshal_int();
/*  60 */     this.level = _os_.unmarshal_int();
/*  61 */     this.avatarid = _os_.unmarshal_int();
/*  62 */     this.zoneid = _os_.unmarshal_int();
/*  63 */     this.state = _os_.unmarshal_int();
/*  64 */     this.num = _os_.unmarshal_int();
/*  65 */     this.avatarframeid = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof RoleBaseInfo)) {
/*  72 */       RoleBaseInfo _o_ = (RoleBaseInfo)_o1_;
/*  73 */       if (!this.name.equals(_o_.name)) return false;
/*  74 */       if (this.gender != _o_.gender) return false;
/*  75 */       if (this.occupation != _o_.occupation) return false;
/*  76 */       if (this.level != _o_.level) return false;
/*  77 */       if (this.avatarid != _o_.avatarid) return false;
/*  78 */       if (this.zoneid != _o_.zoneid) return false;
/*  79 */       if (this.state != _o_.state) return false;
/*  80 */       if (this.num != _o_.num) return false;
/*  81 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.name.hashCode();
/*  90 */     _h_ += this.gender;
/*  91 */     _h_ += this.occupation;
/*  92 */     _h_ += this.level;
/*  93 */     _h_ += this.avatarid;
/*  94 */     _h_ += this.zoneid;
/*  95 */     _h_ += this.state;
/*  96 */     _h_ += this.num;
/*  97 */     _h_ += this.avatarframeid;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append("B").append(this.name.size()).append(",");
/* 105 */     _sb_.append(this.gender).append(",");
/* 106 */     _sb_.append(this.occupation).append(",");
/* 107 */     _sb_.append(this.level).append(",");
/* 108 */     _sb_.append(this.avatarid).append(",");
/* 109 */     _sb_.append(this.zoneid).append(",");
/* 110 */     _sb_.append(this.state).append(",");
/* 111 */     _sb_.append(this.num).append(",");
/* 112 */     _sb_.append(this.avatarframeid).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\RoleBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */