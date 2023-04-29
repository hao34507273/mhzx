/*     */ package mzm.gsp.paraselene;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class JigsawInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String name;
/*     */   public int sex;
/*     */   public int level;
/*     */   public int occupation;
/*     */   public int ispass;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public JigsawInfo()
/*     */   {
/*  19 */     this.name = "";
/*     */   }
/*     */   
/*     */   public JigsawInfo(long _roleid_, String _name_, int _sex_, int _level_, int _occupation_, int _ispass_, int _avatarid_, int _avatarframeid_) {
/*  23 */     this.roleid = _roleid_;
/*  24 */     this.name = _name_;
/*  25 */     this.sex = _sex_;
/*  26 */     this.level = _level_;
/*  27 */     this.occupation = _occupation_;
/*  28 */     this.ispass = _ispass_;
/*  29 */     this.avatarid = _avatarid_;
/*  30 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  38 */     _os_.marshal(this.roleid);
/*  39 */     _os_.marshal(this.name, "UTF-16LE");
/*  40 */     _os_.marshal(this.sex);
/*  41 */     _os_.marshal(this.level);
/*  42 */     _os_.marshal(this.occupation);
/*  43 */     _os_.marshal(this.ispass);
/*  44 */     _os_.marshal(this.avatarid);
/*  45 */     _os_.marshal(this.avatarframeid);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  50 */     this.roleid = _os_.unmarshal_long();
/*  51 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  52 */     this.sex = _os_.unmarshal_int();
/*  53 */     this.level = _os_.unmarshal_int();
/*  54 */     this.occupation = _os_.unmarshal_int();
/*  55 */     this.ispass = _os_.unmarshal_int();
/*  56 */     this.avatarid = _os_.unmarshal_int();
/*  57 */     this.avatarframeid = _os_.unmarshal_int();
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  62 */     if (_o1_ == this) return true;
/*  63 */     if ((_o1_ instanceof JigsawInfo)) {
/*  64 */       JigsawInfo _o_ = (JigsawInfo)_o1_;
/*  65 */       if (this.roleid != _o_.roleid) return false;
/*  66 */       if (!this.name.equals(_o_.name)) return false;
/*  67 */       if (this.sex != _o_.sex) return false;
/*  68 */       if (this.level != _o_.level) return false;
/*  69 */       if (this.occupation != _o_.occupation) return false;
/*  70 */       if (this.ispass != _o_.ispass) return false;
/*  71 */       if (this.avatarid != _o_.avatarid) return false;
/*  72 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.roleid;
/*  81 */     _h_ += this.name.hashCode();
/*  82 */     _h_ += this.sex;
/*  83 */     _h_ += this.level;
/*  84 */     _h_ += this.occupation;
/*  85 */     _h_ += this.ispass;
/*  86 */     _h_ += this.avatarid;
/*  87 */     _h_ += this.avatarframeid;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.roleid).append(",");
/*  95 */     _sb_.append("T").append(this.name.length()).append(",");
/*  96 */     _sb_.append(this.sex).append(",");
/*  97 */     _sb_.append(this.level).append(",");
/*  98 */     _sb_.append(this.occupation).append(",");
/*  99 */     _sb_.append(this.ispass).append(",");
/* 100 */     _sb_.append(this.avatarid).append(",");
/* 101 */     _sb_.append(this.avatarframeid).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\JigsawInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */