/*     */ package mzm.gsp.paraselene;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class WordQuestionInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String name;
/*     */   public int sex;
/*     */   public int level;
/*     */   public int occupation;
/*     */   public int rightnum;
/*     */   public int totalnum;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   
/*     */   public WordQuestionInfo()
/*     */   {
/*  20 */     this.name = "";
/*     */   }
/*     */   
/*     */   public WordQuestionInfo(long _roleid_, String _name_, int _sex_, int _level_, int _occupation_, int _rightnum_, int _totalnum_, int _avatarid_, int _avatarframeid_) {
/*  24 */     this.roleid = _roleid_;
/*  25 */     this.name = _name_;
/*  26 */     this.sex = _sex_;
/*  27 */     this.level = _level_;
/*  28 */     this.occupation = _occupation_;
/*  29 */     this.rightnum = _rightnum_;
/*  30 */     this.totalnum = _totalnum_;
/*  31 */     this.avatarid = _avatarid_;
/*  32 */     this.avatarframeid = _avatarframeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.roleid);
/*  41 */     _os_.marshal(this.name, "UTF-16LE");
/*  42 */     _os_.marshal(this.sex);
/*  43 */     _os_.marshal(this.level);
/*  44 */     _os_.marshal(this.occupation);
/*  45 */     _os_.marshal(this.rightnum);
/*  46 */     _os_.marshal(this.totalnum);
/*  47 */     _os_.marshal(this.avatarid);
/*  48 */     _os_.marshal(this.avatarframeid);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  53 */     this.roleid = _os_.unmarshal_long();
/*  54 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  55 */     this.sex = _os_.unmarshal_int();
/*  56 */     this.level = _os_.unmarshal_int();
/*  57 */     this.occupation = _os_.unmarshal_int();
/*  58 */     this.rightnum = _os_.unmarshal_int();
/*  59 */     this.totalnum = _os_.unmarshal_int();
/*  60 */     this.avatarid = _os_.unmarshal_int();
/*  61 */     this.avatarframeid = _os_.unmarshal_int();
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof WordQuestionInfo)) {
/*  68 */       WordQuestionInfo _o_ = (WordQuestionInfo)_o1_;
/*  69 */       if (this.roleid != _o_.roleid) return false;
/*  70 */       if (!this.name.equals(_o_.name)) return false;
/*  71 */       if (this.sex != _o_.sex) return false;
/*  72 */       if (this.level != _o_.level) return false;
/*  73 */       if (this.occupation != _o_.occupation) return false;
/*  74 */       if (this.rightnum != _o_.rightnum) return false;
/*  75 */       if (this.totalnum != _o_.totalnum) return false;
/*  76 */       if (this.avatarid != _o_.avatarid) return false;
/*  77 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += this.name.hashCode();
/*  87 */     _h_ += this.sex;
/*  88 */     _h_ += this.level;
/*  89 */     _h_ += this.occupation;
/*  90 */     _h_ += this.rightnum;
/*  91 */     _h_ += this.totalnum;
/*  92 */     _h_ += this.avatarid;
/*  93 */     _h_ += this.avatarframeid;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.roleid).append(",");
/* 101 */     _sb_.append("T").append(this.name.length()).append(",");
/* 102 */     _sb_.append(this.sex).append(",");
/* 103 */     _sb_.append(this.level).append(",");
/* 104 */     _sb_.append(this.occupation).append(",");
/* 105 */     _sb_.append(this.rightnum).append(",");
/* 106 */     _sb_.append(this.totalnum).append(",");
/* 107 */     _sb_.append(this.avatarid).append(",");
/* 108 */     _sb_.append(this.avatarframeid).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\WordQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */