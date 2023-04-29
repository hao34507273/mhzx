/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class CorpsMember implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public Octets name;
/*     */   public int level;
/*     */   public int occupationid;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public int duty;
/*     */   public int gender;
/*     */   public int jointime;
/*     */   public int offlinetime;
/*     */   
/*     */   public CorpsMember()
/*     */   {
/*  23 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public CorpsMember(long _roleid_, Octets _name_, int _level_, int _occupationid_, int _avatarid_, int _avatarframeid_, int _duty_, int _gender_, int _jointime_, int _offlinetime_) {
/*  27 */     this.roleid = _roleid_;
/*  28 */     this.name = _name_;
/*  29 */     this.level = _level_;
/*  30 */     this.occupationid = _occupationid_;
/*  31 */     this.avatarid = _avatarid_;
/*  32 */     this.avatarframeid = _avatarframeid_;
/*  33 */     this.duty = _duty_;
/*  34 */     this.gender = _gender_;
/*  35 */     this.jointime = _jointime_;
/*  36 */     this.offlinetime = _offlinetime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  44 */     _os_.marshal(this.roleid);
/*  45 */     _os_.marshal(this.name);
/*  46 */     _os_.marshal(this.level);
/*  47 */     _os_.marshal(this.occupationid);
/*  48 */     _os_.marshal(this.avatarid);
/*  49 */     _os_.marshal(this.avatarframeid);
/*  50 */     _os_.marshal(this.duty);
/*  51 */     _os_.marshal(this.gender);
/*  52 */     _os_.marshal(this.jointime);
/*  53 */     _os_.marshal(this.offlinetime);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.roleid = _os_.unmarshal_long();
/*  59 */     this.name = _os_.unmarshal_Octets();
/*  60 */     this.level = _os_.unmarshal_int();
/*  61 */     this.occupationid = _os_.unmarshal_int();
/*  62 */     this.avatarid = _os_.unmarshal_int();
/*  63 */     this.avatarframeid = _os_.unmarshal_int();
/*  64 */     this.duty = _os_.unmarshal_int();
/*  65 */     this.gender = _os_.unmarshal_int();
/*  66 */     this.jointime = _os_.unmarshal_int();
/*  67 */     this.offlinetime = _os_.unmarshal_int();
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CorpsMember)) {
/*  74 */       CorpsMember _o_ = (CorpsMember)_o1_;
/*  75 */       if (this.roleid != _o_.roleid) return false;
/*  76 */       if (!this.name.equals(_o_.name)) return false;
/*  77 */       if (this.level != _o_.level) return false;
/*  78 */       if (this.occupationid != _o_.occupationid) return false;
/*  79 */       if (this.avatarid != _o_.avatarid) return false;
/*  80 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  81 */       if (this.duty != _o_.duty) return false;
/*  82 */       if (this.gender != _o_.gender) return false;
/*  83 */       if (this.jointime != _o_.jointime) return false;
/*  84 */       if (this.offlinetime != _o_.offlinetime) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += (int)this.roleid;
/*  93 */     _h_ += this.name.hashCode();
/*  94 */     _h_ += this.level;
/*  95 */     _h_ += this.occupationid;
/*  96 */     _h_ += this.avatarid;
/*  97 */     _h_ += this.avatarframeid;
/*  98 */     _h_ += this.duty;
/*  99 */     _h_ += this.gender;
/* 100 */     _h_ += this.jointime;
/* 101 */     _h_ += this.offlinetime;
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(this.roleid).append(",");
/* 109 */     _sb_.append("B").append(this.name.size()).append(",");
/* 110 */     _sb_.append(this.level).append(",");
/* 111 */     _sb_.append(this.occupationid).append(",");
/* 112 */     _sb_.append(this.avatarid).append(",");
/* 113 */     _sb_.append(this.avatarframeid).append(",");
/* 114 */     _sb_.append(this.duty).append(",");
/* 115 */     _sb_.append(this.gender).append(",");
/* 116 */     _sb_.append(this.jointime).append(",");
/* 117 */     _sb_.append(this.offlinetime).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */