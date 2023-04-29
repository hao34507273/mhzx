/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class Applicant
/*     */   implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public int level;
/*     */   public String name;
/*     */   public int occupationid;
/*     */   public int gender;
/*     */   public int avatarid;
/*     */   public int avatar_frame;
/*     */   public long time;
/*     */   public String invitername;
/*     */   
/*     */   public Applicant()
/*     */   {
/*  22 */     this.name = "";
/*  23 */     this.invitername = "";
/*     */   }
/*     */   
/*     */   public Applicant(long _roleid_, int _level_, String _name_, int _occupationid_, int _gender_, int _avatarid_, int _avatar_frame_, long _time_, String _invitername_) {
/*  27 */     this.roleid = _roleid_;
/*  28 */     this.level = _level_;
/*  29 */     this.name = _name_;
/*  30 */     this.occupationid = _occupationid_;
/*  31 */     this.gender = _gender_;
/*  32 */     this.avatarid = _avatarid_;
/*  33 */     this.avatar_frame = _avatar_frame_;
/*  34 */     this.time = _time_;
/*  35 */     this.invitername = _invitername_;
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
/*  46 */     _os_.marshal(this.occupationid);
/*  47 */     _os_.marshal(this.gender);
/*  48 */     _os_.marshal(this.avatarid);
/*  49 */     _os_.marshal(this.avatar_frame);
/*  50 */     _os_.marshal(this.time);
/*  51 */     _os_.marshal(this.invitername, "UTF-16LE");
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.roleid = _os_.unmarshal_long();
/*  57 */     this.level = _os_.unmarshal_int();
/*  58 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  59 */     this.occupationid = _os_.unmarshal_int();
/*  60 */     this.gender = _os_.unmarshal_int();
/*  61 */     this.avatarid = _os_.unmarshal_int();
/*  62 */     this.avatar_frame = _os_.unmarshal_int();
/*  63 */     this.time = _os_.unmarshal_long();
/*  64 */     this.invitername = _os_.unmarshal_String("UTF-16LE");
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof Applicant)) {
/*  71 */       Applicant _o_ = (Applicant)_o1_;
/*  72 */       if (this.roleid != _o_.roleid) return false;
/*  73 */       if (this.level != _o_.level) return false;
/*  74 */       if (!this.name.equals(_o_.name)) return false;
/*  75 */       if (this.occupationid != _o_.occupationid) return false;
/*  76 */       if (this.gender != _o_.gender) return false;
/*  77 */       if (this.avatarid != _o_.avatarid) return false;
/*  78 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/*  79 */       if (this.time != _o_.time) return false;
/*  80 */       if (!this.invitername.equals(_o_.invitername)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.roleid;
/*  89 */     _h_ += this.level;
/*  90 */     _h_ += this.name.hashCode();
/*  91 */     _h_ += this.occupationid;
/*  92 */     _h_ += this.gender;
/*  93 */     _h_ += this.avatarid;
/*  94 */     _h_ += this.avatar_frame;
/*  95 */     _h_ += (int)this.time;
/*  96 */     _h_ += this.invitername.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.roleid).append(",");
/* 104 */     _sb_.append(this.level).append(",");
/* 105 */     _sb_.append("T").append(this.name.length()).append(",");
/* 106 */     _sb_.append(this.occupationid).append(",");
/* 107 */     _sb_.append(this.gender).append(",");
/* 108 */     _sb_.append(this.avatarid).append(",");
/* 109 */     _sb_.append(this.avatar_frame).append(",");
/* 110 */     _sb_.append(this.time).append(",");
/* 111 */     _sb_.append("T").append(this.invitername.length()).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\Applicant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */