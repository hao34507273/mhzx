/*     */ package mzm.gsp.personal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class PersonalInfo implements Marshal
/*     */ {
/*     */   public Octets openid;
/*     */   public Octets rolename;
/*     */   public Octets sign;
/*     */   public int gender;
/*     */   public int age;
/*     */   public Birthday birthday;
/*     */   public int animalsign;
/*     */   public int constellation;
/*     */   public int bloodtype;
/*     */   public int occupation;
/*     */   public Octets school;
/*     */   public Location location;
/*     */   public ArrayList<Integer> hobbies;
/*     */   public int headimage;
/*     */   public ArrayList<Integer> photos;
/*     */   public int praisenum;
/*     */   public int praise;
/*     */   public long onlineseconds;
/*     */   public Octets figure_url;
/*     */   public int avatar_frame;
/*     */   
/*     */   public PersonalInfo()
/*     */   {
/*  33 */     this.openid = new Octets();
/*  34 */     this.rolename = new Octets();
/*  35 */     this.sign = new Octets();
/*  36 */     this.birthday = new Birthday();
/*  37 */     this.school = new Octets();
/*  38 */     this.location = new Location();
/*  39 */     this.hobbies = new ArrayList();
/*  40 */     this.photos = new ArrayList();
/*  41 */     this.figure_url = new Octets();
/*     */   }
/*     */   
/*     */   public PersonalInfo(Octets _openid_, Octets _rolename_, Octets _sign_, int _gender_, int _age_, Birthday _birthday_, int _animalsign_, int _constellation_, int _bloodtype_, int _occupation_, Octets _school_, Location _location_, ArrayList<Integer> _hobbies_, int _headimage_, ArrayList<Integer> _photos_, int _praisenum_, int _praise_, long _onlineseconds_, Octets _figure_url_, int _avatar_frame_) {
/*  45 */     this.openid = _openid_;
/*  46 */     this.rolename = _rolename_;
/*  47 */     this.sign = _sign_;
/*  48 */     this.gender = _gender_;
/*  49 */     this.age = _age_;
/*  50 */     this.birthday = _birthday_;
/*  51 */     this.animalsign = _animalsign_;
/*  52 */     this.constellation = _constellation_;
/*  53 */     this.bloodtype = _bloodtype_;
/*  54 */     this.occupation = _occupation_;
/*  55 */     this.school = _school_;
/*  56 */     this.location = _location_;
/*  57 */     this.hobbies = _hobbies_;
/*  58 */     this.headimage = _headimage_;
/*  59 */     this.photos = _photos_;
/*  60 */     this.praisenum = _praisenum_;
/*  61 */     this.praise = _praise_;
/*  62 */     this.onlineseconds = _onlineseconds_;
/*  63 */     this.figure_url = _figure_url_;
/*  64 */     this.avatar_frame = _avatar_frame_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  68 */     if (!this.birthday._validator_()) return false;
/*  69 */     if (!this.location._validator_()) return false;
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  74 */     _os_.marshal(this.openid);
/*  75 */     _os_.marshal(this.rolename);
/*  76 */     _os_.marshal(this.sign);
/*  77 */     _os_.marshal(this.gender);
/*  78 */     _os_.marshal(this.age);
/*  79 */     _os_.marshal(this.birthday);
/*  80 */     _os_.marshal(this.animalsign);
/*  81 */     _os_.marshal(this.constellation);
/*  82 */     _os_.marshal(this.bloodtype);
/*  83 */     _os_.marshal(this.occupation);
/*  84 */     _os_.marshal(this.school);
/*  85 */     _os_.marshal(this.location);
/*  86 */     _os_.compact_uint32(this.hobbies.size());
/*  87 */     for (Integer _v_ : this.hobbies) {
/*  88 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  90 */     _os_.marshal(this.headimage);
/*  91 */     _os_.compact_uint32(this.photos.size());
/*  92 */     for (Integer _v_ : this.photos) {
/*  93 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  95 */     _os_.marshal(this.praisenum);
/*  96 */     _os_.marshal(this.praise);
/*  97 */     _os_.marshal(this.onlineseconds);
/*  98 */     _os_.marshal(this.figure_url);
/*  99 */     _os_.marshal(this.avatar_frame);
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 104 */     this.openid = _os_.unmarshal_Octets();
/* 105 */     this.rolename = _os_.unmarshal_Octets();
/* 106 */     this.sign = _os_.unmarshal_Octets();
/* 107 */     this.gender = _os_.unmarshal_int();
/* 108 */     this.age = _os_.unmarshal_int();
/* 109 */     this.birthday.unmarshal(_os_);
/* 110 */     this.animalsign = _os_.unmarshal_int();
/* 111 */     this.constellation = _os_.unmarshal_int();
/* 112 */     this.bloodtype = _os_.unmarshal_int();
/* 113 */     this.occupation = _os_.unmarshal_int();
/* 114 */     this.school = _os_.unmarshal_Octets();
/* 115 */     this.location.unmarshal(_os_);
/* 116 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 118 */       int _v_ = _os_.unmarshal_int();
/* 119 */       this.hobbies.add(Integer.valueOf(_v_));
/*     */     }
/* 121 */     this.headimage = _os_.unmarshal_int();
/* 122 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 124 */       int _v_ = _os_.unmarshal_int();
/* 125 */       this.photos.add(Integer.valueOf(_v_));
/*     */     }
/* 127 */     this.praisenum = _os_.unmarshal_int();
/* 128 */     this.praise = _os_.unmarshal_int();
/* 129 */     this.onlineseconds = _os_.unmarshal_long();
/* 130 */     this.figure_url = _os_.unmarshal_Octets();
/* 131 */     this.avatar_frame = _os_.unmarshal_int();
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 136 */     if (_o1_ == this) return true;
/* 137 */     if ((_o1_ instanceof PersonalInfo)) {
/* 138 */       PersonalInfo _o_ = (PersonalInfo)_o1_;
/* 139 */       if (!this.openid.equals(_o_.openid)) return false;
/* 140 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 141 */       if (!this.sign.equals(_o_.sign)) return false;
/* 142 */       if (this.gender != _o_.gender) return false;
/* 143 */       if (this.age != _o_.age) return false;
/* 144 */       if (!this.birthday.equals(_o_.birthday)) return false;
/* 145 */       if (this.animalsign != _o_.animalsign) return false;
/* 146 */       if (this.constellation != _o_.constellation) return false;
/* 147 */       if (this.bloodtype != _o_.bloodtype) return false;
/* 148 */       if (this.occupation != _o_.occupation) return false;
/* 149 */       if (!this.school.equals(_o_.school)) return false;
/* 150 */       if (!this.location.equals(_o_.location)) return false;
/* 151 */       if (!this.hobbies.equals(_o_.hobbies)) return false;
/* 152 */       if (this.headimage != _o_.headimage) return false;
/* 153 */       if (!this.photos.equals(_o_.photos)) return false;
/* 154 */       if (this.praisenum != _o_.praisenum) return false;
/* 155 */       if (this.praise != _o_.praise) return false;
/* 156 */       if (this.onlineseconds != _o_.onlineseconds) return false;
/* 157 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 158 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/* 159 */       return true;
/*     */     }
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 165 */     int _h_ = 0;
/* 166 */     _h_ += this.openid.hashCode();
/* 167 */     _h_ += this.rolename.hashCode();
/* 168 */     _h_ += this.sign.hashCode();
/* 169 */     _h_ += this.gender;
/* 170 */     _h_ += this.age;
/* 171 */     _h_ += this.birthday.hashCode();
/* 172 */     _h_ += this.animalsign;
/* 173 */     _h_ += this.constellation;
/* 174 */     _h_ += this.bloodtype;
/* 175 */     _h_ += this.occupation;
/* 176 */     _h_ += this.school.hashCode();
/* 177 */     _h_ += this.location.hashCode();
/* 178 */     _h_ += this.hobbies.hashCode();
/* 179 */     _h_ += this.headimage;
/* 180 */     _h_ += this.photos.hashCode();
/* 181 */     _h_ += this.praisenum;
/* 182 */     _h_ += this.praise;
/* 183 */     _h_ += (int)this.onlineseconds;
/* 184 */     _h_ += this.figure_url.hashCode();
/* 185 */     _h_ += this.avatar_frame;
/* 186 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 190 */     StringBuilder _sb_ = new StringBuilder();
/* 191 */     _sb_.append("(");
/* 192 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 193 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 194 */     _sb_.append("B").append(this.sign.size()).append(",");
/* 195 */     _sb_.append(this.gender).append(",");
/* 196 */     _sb_.append(this.age).append(",");
/* 197 */     _sb_.append(this.birthday).append(",");
/* 198 */     _sb_.append(this.animalsign).append(",");
/* 199 */     _sb_.append(this.constellation).append(",");
/* 200 */     _sb_.append(this.bloodtype).append(",");
/* 201 */     _sb_.append(this.occupation).append(",");
/* 202 */     _sb_.append("B").append(this.school.size()).append(",");
/* 203 */     _sb_.append(this.location).append(",");
/* 204 */     _sb_.append(this.hobbies).append(",");
/* 205 */     _sb_.append(this.headimage).append(",");
/* 206 */     _sb_.append(this.photos).append(",");
/* 207 */     _sb_.append(this.praisenum).append(",");
/* 208 */     _sb_.append(this.praise).append(",");
/* 209 */     _sb_.append(this.onlineseconds).append(",");
/* 210 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 211 */     _sb_.append(this.avatar_frame).append(",");
/* 212 */     _sb_.append(")");
/* 213 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\PersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */