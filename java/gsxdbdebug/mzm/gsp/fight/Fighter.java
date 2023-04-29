/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class Fighter implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int fighter_type;
/*     */   public long uuid;
/*     */   public int cfgid;
/*     */   public String name;
/*     */   public int level;
/*     */   public int occupation;
/*     */   public int gender;
/*     */   public int pos;
/*     */   public ModelInfo model;
/*     */   public FighterStatus status;
/*     */   public HashMap<Integer, SkillData> skilldatas;
/*     */   
/*     */   public Fighter()
/*     */   {
/*  24 */     this.name = "";
/*  25 */     this.model = new ModelInfo();
/*  26 */     this.status = new FighterStatus();
/*  27 */     this.skilldatas = new HashMap();
/*     */   }
/*     */   
/*     */   public Fighter(int _fighter_type_, long _uuid_, int _cfgid_, String _name_, int _level_, int _occupation_, int _gender_, int _pos_, ModelInfo _model_, FighterStatus _status_, HashMap<Integer, SkillData> _skilldatas_) {
/*  31 */     this.fighter_type = _fighter_type_;
/*  32 */     this.uuid = _uuid_;
/*  33 */     this.cfgid = _cfgid_;
/*  34 */     this.name = _name_;
/*  35 */     this.level = _level_;
/*  36 */     this.occupation = _occupation_;
/*  37 */     this.gender = _gender_;
/*  38 */     this.pos = _pos_;
/*  39 */     this.model = _model_;
/*  40 */     this.status = _status_;
/*  41 */     this.skilldatas = _skilldatas_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     if (!this.model._validator_()) return false;
/*  46 */     if (!this.status._validator_()) return false;
/*  47 */     for (Map.Entry<Integer, SkillData> _e_ : this.skilldatas.entrySet()) {
/*  48 */       if (!((SkillData)_e_.getValue())._validator_()) return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.fighter_type);
/*  55 */     _os_.marshal(this.uuid);
/*  56 */     _os_.marshal(this.cfgid);
/*  57 */     _os_.marshal(this.name, "UTF-16LE");
/*  58 */     _os_.marshal(this.level);
/*  59 */     _os_.marshal(this.occupation);
/*  60 */     _os_.marshal(this.gender);
/*  61 */     _os_.marshal(this.pos);
/*  62 */     _os_.marshal(this.model);
/*  63 */     _os_.marshal(this.status);
/*  64 */     _os_.compact_uint32(this.skilldatas.size());
/*  65 */     for (Map.Entry<Integer, SkillData> _e_ : this.skilldatas.entrySet()) {
/*  66 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  67 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  73 */     this.fighter_type = _os_.unmarshal_int();
/*  74 */     this.uuid = _os_.unmarshal_long();
/*  75 */     this.cfgid = _os_.unmarshal_int();
/*  76 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  77 */     this.level = _os_.unmarshal_int();
/*  78 */     this.occupation = _os_.unmarshal_int();
/*  79 */     this.gender = _os_.unmarshal_int();
/*  80 */     this.pos = _os_.unmarshal_int();
/*  81 */     this.model.unmarshal(_os_);
/*  82 */     this.status.unmarshal(_os_);
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       int _k_ = _os_.unmarshal_int();
/*  86 */       SkillData _v_ = new SkillData();
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.skilldatas.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof Fighter)) {
/*  96 */       Fighter _o_ = (Fighter)_o1_;
/*  97 */       if (this.fighter_type != _o_.fighter_type) return false;
/*  98 */       if (this.uuid != _o_.uuid) return false;
/*  99 */       if (this.cfgid != _o_.cfgid) return false;
/* 100 */       if (!this.name.equals(_o_.name)) return false;
/* 101 */       if (this.level != _o_.level) return false;
/* 102 */       if (this.occupation != _o_.occupation) return false;
/* 103 */       if (this.gender != _o_.gender) return false;
/* 104 */       if (this.pos != _o_.pos) return false;
/* 105 */       if (!this.model.equals(_o_.model)) return false;
/* 106 */       if (!this.status.equals(_o_.status)) return false;
/* 107 */       if (!this.skilldatas.equals(_o_.skilldatas)) return false;
/* 108 */       return true;
/*     */     }
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 114 */     int _h_ = 0;
/* 115 */     _h_ += this.fighter_type;
/* 116 */     _h_ += (int)this.uuid;
/* 117 */     _h_ += this.cfgid;
/* 118 */     _h_ += this.name.hashCode();
/* 119 */     _h_ += this.level;
/* 120 */     _h_ += this.occupation;
/* 121 */     _h_ += this.gender;
/* 122 */     _h_ += this.pos;
/* 123 */     _h_ += this.model.hashCode();
/* 124 */     _h_ += this.status.hashCode();
/* 125 */     _h_ += this.skilldatas.hashCode();
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append(this.fighter_type).append(",");
/* 133 */     _sb_.append(this.uuid).append(",");
/* 134 */     _sb_.append(this.cfgid).append(",");
/* 135 */     _sb_.append("T").append(this.name.length()).append(",");
/* 136 */     _sb_.append(this.level).append(",");
/* 137 */     _sb_.append(this.occupation).append(",");
/* 138 */     _sb_.append(this.gender).append(",");
/* 139 */     _sb_.append(this.pos).append(",");
/* 140 */     _sb_.append(this.model).append(",");
/* 141 */     _sb_.append(this.status).append(",");
/* 142 */     _sb_.append(this.skilldatas).append(",");
/* 143 */     _sb_.append(")");
/* 144 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\Fighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */