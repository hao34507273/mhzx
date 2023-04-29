/*     */ package mzm.gsp.personal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class AdvertInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public long advertid;
/*     */   public int adverttype;
/*     */   public int headimage;
/*     */   public Octets headimageurl;
/*     */   public int realgender;
/*     */   public Octets name;
/*     */   public int gender;
/*     */   public int occupationid;
/*     */   public int level;
/*     */   public Octets content;
/*     */   public int avatar_frameid;
/*     */   
/*     */   public AdvertInfo()
/*     */   {
/*  25 */     this.headimageurl = new Octets();
/*  26 */     this.name = new Octets();
/*  27 */     this.content = new Octets();
/*     */   }
/*     */   
/*     */   public AdvertInfo(long _roleid_, long _advertid_, int _adverttype_, int _headimage_, Octets _headimageurl_, int _realgender_, Octets _name_, int _gender_, int _occupationid_, int _level_, Octets _content_, int _avatar_frameid_) {
/*  31 */     this.roleid = _roleid_;
/*  32 */     this.advertid = _advertid_;
/*  33 */     this.adverttype = _adverttype_;
/*  34 */     this.headimage = _headimage_;
/*  35 */     this.headimageurl = _headimageurl_;
/*  36 */     this.realgender = _realgender_;
/*  37 */     this.name = _name_;
/*  38 */     this.gender = _gender_;
/*  39 */     this.occupationid = _occupationid_;
/*  40 */     this.level = _level_;
/*  41 */     this.content = _content_;
/*  42 */     this.avatar_frameid = _avatar_frameid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.roleid);
/*  51 */     _os_.marshal(this.advertid);
/*  52 */     _os_.marshal(this.adverttype);
/*  53 */     _os_.marshal(this.headimage);
/*  54 */     _os_.marshal(this.headimageurl);
/*  55 */     _os_.marshal(this.realgender);
/*  56 */     _os_.marshal(this.name);
/*  57 */     _os_.marshal(this.gender);
/*  58 */     _os_.marshal(this.occupationid);
/*  59 */     _os_.marshal(this.level);
/*  60 */     _os_.marshal(this.content);
/*  61 */     _os_.marshal(this.avatar_frameid);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.roleid = _os_.unmarshal_long();
/*  67 */     this.advertid = _os_.unmarshal_long();
/*  68 */     this.adverttype = _os_.unmarshal_int();
/*  69 */     this.headimage = _os_.unmarshal_int();
/*  70 */     this.headimageurl = _os_.unmarshal_Octets();
/*  71 */     this.realgender = _os_.unmarshal_int();
/*  72 */     this.name = _os_.unmarshal_Octets();
/*  73 */     this.gender = _os_.unmarshal_int();
/*  74 */     this.occupationid = _os_.unmarshal_int();
/*  75 */     this.level = _os_.unmarshal_int();
/*  76 */     this.content = _os_.unmarshal_Octets();
/*  77 */     this.avatar_frameid = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof AdvertInfo)) {
/*  84 */       AdvertInfo _o_ = (AdvertInfo)_o1_;
/*  85 */       if (this.roleid != _o_.roleid) return false;
/*  86 */       if (this.advertid != _o_.advertid) return false;
/*  87 */       if (this.adverttype != _o_.adverttype) return false;
/*  88 */       if (this.headimage != _o_.headimage) return false;
/*  89 */       if (!this.headimageurl.equals(_o_.headimageurl)) return false;
/*  90 */       if (this.realgender != _o_.realgender) return false;
/*  91 */       if (!this.name.equals(_o_.name)) return false;
/*  92 */       if (this.gender != _o_.gender) return false;
/*  93 */       if (this.occupationid != _o_.occupationid) return false;
/*  94 */       if (this.level != _o_.level) return false;
/*  95 */       if (!this.content.equals(_o_.content)) return false;
/*  96 */       if (this.avatar_frameid != _o_.avatar_frameid) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += (int)this.roleid;
/* 105 */     _h_ += (int)this.advertid;
/* 106 */     _h_ += this.adverttype;
/* 107 */     _h_ += this.headimage;
/* 108 */     _h_ += this.headimageurl.hashCode();
/* 109 */     _h_ += this.realgender;
/* 110 */     _h_ += this.name.hashCode();
/* 111 */     _h_ += this.gender;
/* 112 */     _h_ += this.occupationid;
/* 113 */     _h_ += this.level;
/* 114 */     _h_ += this.content.hashCode();
/* 115 */     _h_ += this.avatar_frameid;
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.roleid).append(",");
/* 123 */     _sb_.append(this.advertid).append(",");
/* 124 */     _sb_.append(this.adverttype).append(",");
/* 125 */     _sb_.append(this.headimage).append(",");
/* 126 */     _sb_.append("B").append(this.headimageurl.size()).append(",");
/* 127 */     _sb_.append(this.realgender).append(",");
/* 128 */     _sb_.append("B").append(this.name.size()).append(",");
/* 129 */     _sb_.append(this.gender).append(",");
/* 130 */     _sb_.append(this.occupationid).append(",");
/* 131 */     _sb_.append(this.level).append(",");
/* 132 */     _sb_.append("B").append(this.content.size()).append(",");
/* 133 */     _sb_.append(this.avatar_frameid).append(",");
/* 134 */     _sb_.append(")");
/* 135 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\AdvertInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */