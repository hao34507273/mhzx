/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class RoleVitalityInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public Octets name;
/*     */   public int level;
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public int fight;
/*     */   public int zoneid;
/*     */   public int vitality;
/*     */   public long update_time;
/*     */   
/*     */   public RoleVitalityInfo()
/*     */   {
/*  20 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public RoleVitalityInfo(long _roleid_, Octets _name_, int _level_, int _gender_, int _occupation_, int _fight_, int _zoneid_, int _vitality_, long _update_time_) {
/*  24 */     this.roleid = _roleid_;
/*  25 */     this.name = _name_;
/*  26 */     this.level = _level_;
/*  27 */     this.gender = _gender_;
/*  28 */     this.occupation = _occupation_;
/*  29 */     this.fight = _fight_;
/*  30 */     this.zoneid = _zoneid_;
/*  31 */     this.vitality = _vitality_;
/*  32 */     this.update_time = _update_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.roleid);
/*  41 */     _os_.marshal(this.name);
/*  42 */     _os_.marshal(this.level);
/*  43 */     _os_.marshal(this.gender);
/*  44 */     _os_.marshal(this.occupation);
/*  45 */     _os_.marshal(this.fight);
/*  46 */     _os_.marshal(this.zoneid);
/*  47 */     _os_.marshal(this.vitality);
/*  48 */     _os_.marshal(this.update_time);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  53 */     this.roleid = _os_.unmarshal_long();
/*  54 */     this.name = _os_.unmarshal_Octets();
/*  55 */     this.level = _os_.unmarshal_int();
/*  56 */     this.gender = _os_.unmarshal_int();
/*  57 */     this.occupation = _os_.unmarshal_int();
/*  58 */     this.fight = _os_.unmarshal_int();
/*  59 */     this.zoneid = _os_.unmarshal_int();
/*  60 */     this.vitality = _os_.unmarshal_int();
/*  61 */     this.update_time = _os_.unmarshal_long();
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof RoleVitalityInfo)) {
/*  68 */       RoleVitalityInfo _o_ = (RoleVitalityInfo)_o1_;
/*  69 */       if (this.roleid != _o_.roleid) return false;
/*  70 */       if (!this.name.equals(_o_.name)) return false;
/*  71 */       if (this.level != _o_.level) return false;
/*  72 */       if (this.gender != _o_.gender) return false;
/*  73 */       if (this.occupation != _o_.occupation) return false;
/*  74 */       if (this.fight != _o_.fight) return false;
/*  75 */       if (this.zoneid != _o_.zoneid) return false;
/*  76 */       if (this.vitality != _o_.vitality) return false;
/*  77 */       if (this.update_time != _o_.update_time) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += this.name.hashCode();
/*  87 */     _h_ += this.level;
/*  88 */     _h_ += this.gender;
/*  89 */     _h_ += this.occupation;
/*  90 */     _h_ += this.fight;
/*  91 */     _h_ += this.zoneid;
/*  92 */     _h_ += this.vitality;
/*  93 */     _h_ += (int)this.update_time;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.roleid).append(",");
/* 101 */     _sb_.append("B").append(this.name.size()).append(",");
/* 102 */     _sb_.append(this.level).append(",");
/* 103 */     _sb_.append(this.gender).append(",");
/* 104 */     _sb_.append(this.occupation).append(",");
/* 105 */     _sb_.append(this.fight).append(",");
/* 106 */     _sb_.append(this.zoneid).append(",");
/* 107 */     _sb_.append(this.vitality).append(",");
/* 108 */     _sb_.append(this.update_time).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\RoleVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */