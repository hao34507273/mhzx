/*     */ package mzm.gsp.personal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class EditPersonalInfo implements Marshal
/*     */ {
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
/*     */   
/*     */   public EditPersonalInfo()
/*     */   {
/*  26 */     this.sign = new Octets();
/*  27 */     this.birthday = new Birthday();
/*  28 */     this.school = new Octets();
/*  29 */     this.location = new Location();
/*  30 */     this.hobbies = new ArrayList();
/*  31 */     this.photos = new ArrayList();
/*     */   }
/*     */   
/*     */   public EditPersonalInfo(Octets _sign_, int _gender_, int _age_, Birthday _birthday_, int _animalsign_, int _constellation_, int _bloodtype_, int _occupation_, Octets _school_, Location _location_, ArrayList<Integer> _hobbies_, int _headimage_, ArrayList<Integer> _photos_) {
/*  35 */     this.sign = _sign_;
/*  36 */     this.gender = _gender_;
/*  37 */     this.age = _age_;
/*  38 */     this.birthday = _birthday_;
/*  39 */     this.animalsign = _animalsign_;
/*  40 */     this.constellation = _constellation_;
/*  41 */     this.bloodtype = _bloodtype_;
/*  42 */     this.occupation = _occupation_;
/*  43 */     this.school = _school_;
/*  44 */     this.location = _location_;
/*  45 */     this.hobbies = _hobbies_;
/*  46 */     this.headimage = _headimage_;
/*  47 */     this.photos = _photos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     if (!this.birthday._validator_()) return false;
/*  52 */     if (!this.location._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.sign);
/*  58 */     _os_.marshal(this.gender);
/*  59 */     _os_.marshal(this.age);
/*  60 */     _os_.marshal(this.birthday);
/*  61 */     _os_.marshal(this.animalsign);
/*  62 */     _os_.marshal(this.constellation);
/*  63 */     _os_.marshal(this.bloodtype);
/*  64 */     _os_.marshal(this.occupation);
/*  65 */     _os_.marshal(this.school);
/*  66 */     _os_.marshal(this.location);
/*  67 */     _os_.compact_uint32(this.hobbies.size());
/*  68 */     for (Integer _v_ : this.hobbies) {
/*  69 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  71 */     _os_.marshal(this.headimage);
/*  72 */     _os_.compact_uint32(this.photos.size());
/*  73 */     for (Integer _v_ : this.photos) {
/*  74 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  80 */     this.sign = _os_.unmarshal_Octets();
/*  81 */     this.gender = _os_.unmarshal_int();
/*  82 */     this.age = _os_.unmarshal_int();
/*  83 */     this.birthday.unmarshal(_os_);
/*  84 */     this.animalsign = _os_.unmarshal_int();
/*  85 */     this.constellation = _os_.unmarshal_int();
/*  86 */     this.bloodtype = _os_.unmarshal_int();
/*  87 */     this.occupation = _os_.unmarshal_int();
/*  88 */     this.school = _os_.unmarshal_Octets();
/*  89 */     this.location.unmarshal(_os_);
/*  90 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  92 */       int _v_ = _os_.unmarshal_int();
/*  93 */       this.hobbies.add(Integer.valueOf(_v_));
/*     */     }
/*  95 */     this.headimage = _os_.unmarshal_int();
/*  96 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  98 */       int _v_ = _os_.unmarshal_int();
/*  99 */       this.photos.add(Integer.valueOf(_v_));
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 105 */     if (_o1_ == this) return true;
/* 106 */     if ((_o1_ instanceof EditPersonalInfo)) {
/* 107 */       EditPersonalInfo _o_ = (EditPersonalInfo)_o1_;
/* 108 */       if (!this.sign.equals(_o_.sign)) return false;
/* 109 */       if (this.gender != _o_.gender) return false;
/* 110 */       if (this.age != _o_.age) return false;
/* 111 */       if (!this.birthday.equals(_o_.birthday)) return false;
/* 112 */       if (this.animalsign != _o_.animalsign) return false;
/* 113 */       if (this.constellation != _o_.constellation) return false;
/* 114 */       if (this.bloodtype != _o_.bloodtype) return false;
/* 115 */       if (this.occupation != _o_.occupation) return false;
/* 116 */       if (!this.school.equals(_o_.school)) return false;
/* 117 */       if (!this.location.equals(_o_.location)) return false;
/* 118 */       if (!this.hobbies.equals(_o_.hobbies)) return false;
/* 119 */       if (this.headimage != _o_.headimage) return false;
/* 120 */       if (!this.photos.equals(_o_.photos)) return false;
/* 121 */       return true;
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 127 */     int _h_ = 0;
/* 128 */     _h_ += this.sign.hashCode();
/* 129 */     _h_ += this.gender;
/* 130 */     _h_ += this.age;
/* 131 */     _h_ += this.birthday.hashCode();
/* 132 */     _h_ += this.animalsign;
/* 133 */     _h_ += this.constellation;
/* 134 */     _h_ += this.bloodtype;
/* 135 */     _h_ += this.occupation;
/* 136 */     _h_ += this.school.hashCode();
/* 137 */     _h_ += this.location.hashCode();
/* 138 */     _h_ += this.hobbies.hashCode();
/* 139 */     _h_ += this.headimage;
/* 140 */     _h_ += this.photos.hashCode();
/* 141 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 145 */     StringBuilder _sb_ = new StringBuilder();
/* 146 */     _sb_.append("(");
/* 147 */     _sb_.append("B").append(this.sign.size()).append(",");
/* 148 */     _sb_.append(this.gender).append(",");
/* 149 */     _sb_.append(this.age).append(",");
/* 150 */     _sb_.append(this.birthday).append(",");
/* 151 */     _sb_.append(this.animalsign).append(",");
/* 152 */     _sb_.append(this.constellation).append(",");
/* 153 */     _sb_.append(this.bloodtype).append(",");
/* 154 */     _sb_.append(this.occupation).append(",");
/* 155 */     _sb_.append("B").append(this.school.size()).append(",");
/* 156 */     _sb_.append(this.location).append(",");
/* 157 */     _sb_.append(this.hobbies).append(",");
/* 158 */     _sb_.append(this.headimage).append(",");
/* 159 */     _sb_.append(this.photos).append(",");
/* 160 */     _sb_.append(")");
/* 161 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\EditPersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */