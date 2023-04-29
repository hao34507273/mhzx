/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class CorpsMemberInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public Octets role_name;
/*     */   public int avatar_id;
/*     */   public int role_level;
/*     */   public int role_fight_value;
/*     */   public ModelInfo role_model_info;
/*     */   public int duty;
/*     */   public int join_time;
/*     */   
/*     */   public CorpsMemberInfo()
/*     */   {
/*  23 */     this.role_name = new Octets();
/*  24 */     this.role_model_info = new ModelInfo();
/*     */   }
/*     */   
/*     */   public CorpsMemberInfo(long _roleid_, int _gender_, int _occupation_, Octets _role_name_, int _avatar_id_, int _role_level_, int _role_fight_value_, ModelInfo _role_model_info_, int _duty_, int _join_time_) {
/*  28 */     this.roleid = _roleid_;
/*  29 */     this.gender = _gender_;
/*  30 */     this.occupation = _occupation_;
/*  31 */     this.role_name = _role_name_;
/*  32 */     this.avatar_id = _avatar_id_;
/*  33 */     this.role_level = _role_level_;
/*  34 */     this.role_fight_value = _role_fight_value_;
/*  35 */     this.role_model_info = _role_model_info_;
/*  36 */     this.duty = _duty_;
/*  37 */     this.join_time = _join_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     if (!this.role_model_info._validator_()) return false;
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.roleid);
/*  47 */     _os_.marshal(this.gender);
/*  48 */     _os_.marshal(this.occupation);
/*  49 */     _os_.marshal(this.role_name);
/*  50 */     _os_.marshal(this.avatar_id);
/*  51 */     _os_.marshal(this.role_level);
/*  52 */     _os_.marshal(this.role_fight_value);
/*  53 */     _os_.marshal(this.role_model_info);
/*  54 */     _os_.marshal(this.duty);
/*  55 */     _os_.marshal(this.join_time);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  60 */     this.roleid = _os_.unmarshal_long();
/*  61 */     this.gender = _os_.unmarshal_int();
/*  62 */     this.occupation = _os_.unmarshal_int();
/*  63 */     this.role_name = _os_.unmarshal_Octets();
/*  64 */     this.avatar_id = _os_.unmarshal_int();
/*  65 */     this.role_level = _os_.unmarshal_int();
/*  66 */     this.role_fight_value = _os_.unmarshal_int();
/*  67 */     this.role_model_info.unmarshal(_os_);
/*  68 */     this.duty = _os_.unmarshal_int();
/*  69 */     this.join_time = _os_.unmarshal_int();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CorpsMemberInfo)) {
/*  76 */       CorpsMemberInfo _o_ = (CorpsMemberInfo)_o1_;
/*  77 */       if (this.roleid != _o_.roleid) return false;
/*  78 */       if (this.gender != _o_.gender) return false;
/*  79 */       if (this.occupation != _o_.occupation) return false;
/*  80 */       if (!this.role_name.equals(_o_.role_name)) return false;
/*  81 */       if (this.avatar_id != _o_.avatar_id) return false;
/*  82 */       if (this.role_level != _o_.role_level) return false;
/*  83 */       if (this.role_fight_value != _o_.role_fight_value) return false;
/*  84 */       if (!this.role_model_info.equals(_o_.role_model_info)) return false;
/*  85 */       if (this.duty != _o_.duty) return false;
/*  86 */       if (this.join_time != _o_.join_time) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.roleid;
/*  95 */     _h_ += this.gender;
/*  96 */     _h_ += this.occupation;
/*  97 */     _h_ += this.role_name.hashCode();
/*  98 */     _h_ += this.avatar_id;
/*  99 */     _h_ += this.role_level;
/* 100 */     _h_ += this.role_fight_value;
/* 101 */     _h_ += this.role_model_info.hashCode();
/* 102 */     _h_ += this.duty;
/* 103 */     _h_ += this.join_time;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.roleid).append(",");
/* 111 */     _sb_.append(this.gender).append(",");
/* 112 */     _sb_.append(this.occupation).append(",");
/* 113 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 114 */     _sb_.append(this.avatar_id).append(",");
/* 115 */     _sb_.append(this.role_level).append(",");
/* 116 */     _sb_.append(this.role_fight_value).append(",");
/* 117 */     _sb_.append(this.role_model_info).append(",");
/* 118 */     _sb_.append(this.duty).append(",");
/* 119 */     _sb_.append(this.join_time).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CorpsMemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */