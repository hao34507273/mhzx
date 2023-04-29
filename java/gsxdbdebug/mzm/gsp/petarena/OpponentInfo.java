/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class OpponentInfo
/*     */   implements Marshal
/*     */ {
/*     */   public static final int MAIL = 1;
/*     */   public static final int FEMAIL = 2;
/*     */   public int rank;
/*     */   public long roleid;
/*     */   public int avatar;
/*     */   public int avatar_frame;
/*     */   public Octets name;
/*     */   public int level;
/*     */   public int occupation;
/*     */   public byte gender;
/*     */   public int score;
/*     */   
/*     */   public OpponentInfo()
/*     */   {
/*  25 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public OpponentInfo(int _rank_, long _roleid_, int _avatar_, int _avatar_frame_, Octets _name_, int _level_, int _occupation_, byte _gender_, int _score_) {
/*  29 */     this.rank = _rank_;
/*  30 */     this.roleid = _roleid_;
/*  31 */     this.avatar = _avatar_;
/*  32 */     this.avatar_frame = _avatar_frame_;
/*  33 */     this.name = _name_;
/*  34 */     this.level = _level_;
/*  35 */     this.occupation = _occupation_;
/*  36 */     this.gender = _gender_;
/*  37 */     this.score = _score_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  45 */     _os_.marshal(this.rank);
/*  46 */     _os_.marshal(this.roleid);
/*  47 */     _os_.marshal(this.avatar);
/*  48 */     _os_.marshal(this.avatar_frame);
/*  49 */     _os_.marshal(this.name);
/*  50 */     _os_.marshal(this.level);
/*  51 */     _os_.marshal(this.occupation);
/*  52 */     _os_.marshal(this.gender);
/*  53 */     _os_.marshal(this.score);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.rank = _os_.unmarshal_int();
/*  59 */     this.roleid = _os_.unmarshal_long();
/*  60 */     this.avatar = _os_.unmarshal_int();
/*  61 */     this.avatar_frame = _os_.unmarshal_int();
/*  62 */     this.name = _os_.unmarshal_Octets();
/*  63 */     this.level = _os_.unmarshal_int();
/*  64 */     this.occupation = _os_.unmarshal_int();
/*  65 */     this.gender = _os_.unmarshal_byte();
/*  66 */     this.score = _os_.unmarshal_int();
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof OpponentInfo)) {
/*  73 */       OpponentInfo _o_ = (OpponentInfo)_o1_;
/*  74 */       if (this.rank != _o_.rank) return false;
/*  75 */       if (this.roleid != _o_.roleid) return false;
/*  76 */       if (this.avatar != _o_.avatar) return false;
/*  77 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/*  78 */       if (!this.name.equals(_o_.name)) return false;
/*  79 */       if (this.level != _o_.level) return false;
/*  80 */       if (this.occupation != _o_.occupation) return false;
/*  81 */       if (this.gender != _o_.gender) return false;
/*  82 */       if (this.score != _o_.score) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.rank;
/*  91 */     _h_ += (int)this.roleid;
/*  92 */     _h_ += this.avatar;
/*  93 */     _h_ += this.avatar_frame;
/*  94 */     _h_ += this.name.hashCode();
/*  95 */     _h_ += this.level;
/*  96 */     _h_ += this.occupation;
/*  97 */     _h_ += this.gender;
/*  98 */     _h_ += this.score;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.rank).append(",");
/* 106 */     _sb_.append(this.roleid).append(",");
/* 107 */     _sb_.append(this.avatar).append(",");
/* 108 */     _sb_.append(this.avatar_frame).append(",");
/* 109 */     _sb_.append("B").append(this.name.size()).append(",");
/* 110 */     _sb_.append(this.level).append(",");
/* 111 */     _sb_.append(this.occupation).append(",");
/* 112 */     _sb_.append(this.gender).append(",");
/* 113 */     _sb_.append(this.score).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\OpponentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */