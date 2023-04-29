/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class SSyncRoleModelChange extends __SSyncRoleModelChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590859;
/*     */   public static final int PET_MODEL_ID = 0;
/*     */   public static final int WEAPON_MODEL_ID = 1;
/*     */   public static final int WEAPON_EFFECT_ID = 2;
/*     */   public static final int WING_ID = 3;
/*     */   public static final int ROLE_MODEL_ID = 4;
/*     */   public static final int ROLE_COLOR_ID = 5;
/*     */   public static final int MOUNTS_ID = 6;
/*     */   public static final int ROLE_VELOCITY = 7;
/*     */   public static final int FABAO_MODEL_ID = 8;
/*     */   public static final int TITLEID = 9;
/*     */   public static final int APPELLATIONID = 10;
/*     */   public static final int QILING_LEVEL = 11;
/*     */   public static final int PET_COLOR_ID = 12;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590859;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int MOUNTS_COLOR_ID = 13;
/*     */   
/*     */   public static final int HUSONG_FOLLOW_MONSTER_ID = 14;
/*     */   
/*     */   public static final int MAP_APP_COLOR_ID = 15;
/*     */   
/*     */   public static final int ROLE_HAIR_COLOR_ID = 16;
/*     */   
/*     */   public static final int ROLE_CLOTH_COLOR_ID = 17;
/*     */   
/*     */   public static final int PET_SHIPIN = 18;
/*     */   
/*     */   public static final int WING_COLOR_ID = 19;
/*     */   
/*     */   public static final int AIRCRAFT_ID = 20;
/*     */   
/*     */   public static final int EXTERIOR_ID = 21;
/*     */   
/*     */   public static final int HUSONG_COUPLE_FLY_NPC_CFG_ID = 22;
/*     */   
/*     */   public static final int GENDER = 23;
/*     */   
/*     */   public static final int FASHION_DRESS_ID = 24;
/*     */   
/*     */   public static final int QILING_EFFECT_LEVEL = 25;
/*     */   
/*     */   public static final int PET_STAGE_LEVEL = 26;
/*     */   public static final int MOUNTS_RANK = 27;
/*     */   public static final int PET_EXTERIOR_ID = 28;
/*     */   public static final int PET_EXTERIOR_COLOR_ID = 29;
/*     */   public static final int MAGIC_MARK = 30;
/*     */   public static final int CHILDREN_PHASE = 31;
/*     */   public static final int CHILDREN_GENDER = 32;
/*     */   public static final int CHILDREN_FASHION = 33;
/*     */   public static final int CHILDREN_MODEL_ID = 34;
/*     */   public static final int CHILDREN_WEAPON_ID = 35;
/*     */   public static final int FABAO_LINGQI_MODEL_ID = 36;
/*     */   public static final int WUSHI_ID = 37;
/*     */   public static final int MORAL_VALUE = 38;
/*     */   public static final int CHANGE_MODEL_CARD_CFGID = 39;
/*     */   public static final int CHANGE_MODEL_CARD_LEVEL = 40;
/*     */   public static final int CHANGE_MODEL_CARD_MINI = 41;
/*     */   public static final int AIRCRAFT_COLOR_ID = 42;
/*     */   public static final int OUTLOOK_ID = 43;
/*     */   public static final int PET_MARK_CFG_ID = 44;
/*     */   public static final int PET_NAME = 0;
/*     */   public static final int APPELLATION = 1;
/*     */   public static final int MAP_APP_TEXT = 2;
/*     */   public static final int CHILDREN_NAME = 3;
/*     */   public static final int PET_ID = 0;
/*     */   public static final int CHILDREN_ID = 1;
/*     */   public long roleid;
/*     */   public HashMap<Integer, Integer> intpropmap;
/*     */   public HashMap<Integer, String> stringpropmap;
/*     */   public HashMap<Integer, Long> longpropmap;
/*     */   public SSyncRoleModelChange()
/*     */   {
/*  88 */     this.intpropmap = new HashMap();
/*  89 */     this.stringpropmap = new HashMap();
/*  90 */     this.longpropmap = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncRoleModelChange(long _roleid_, HashMap<Integer, Integer> _intpropmap_, HashMap<Integer, String> _stringpropmap_, HashMap<Integer, Long> _longpropmap_) {
/*  94 */     this.roleid = _roleid_;
/*  95 */     this.intpropmap = _intpropmap_;
/*  96 */     this.stringpropmap = _stringpropmap_;
/*  97 */     this.longpropmap = _longpropmap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 105 */     _os_.marshal(this.roleid);
/* 106 */     _os_.compact_uint32(this.intpropmap.size());
/* 107 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.intpropmap.entrySet()) {
/* 108 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 109 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 111 */     _os_.compact_uint32(this.stringpropmap.size());
/* 112 */     for (java.util.Map.Entry<Integer, String> _e_ : this.stringpropmap.entrySet()) {
/* 113 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 114 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/* 116 */     _os_.compact_uint32(this.longpropmap.size());
/* 117 */     for (java.util.Map.Entry<Integer, Long> _e_ : this.longpropmap.entrySet()) {
/* 118 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 119 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 125 */     this.roleid = _os_.unmarshal_long();
/* 126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 128 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 130 */       int _v_ = _os_.unmarshal_int();
/* 131 */       this.intpropmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 133 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 135 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 137 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 138 */       this.stringpropmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 140 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 142 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 144 */       long _v_ = _os_.unmarshal_long();
/* 145 */       this.longpropmap.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/* 147 */     if (!_validator_()) {
/* 148 */       throw new VerifyError("validator failed");
/*     */     }
/* 150 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 154 */     if (_o1_ == this) return true;
/* 155 */     if ((_o1_ instanceof SSyncRoleModelChange)) {
/* 156 */       SSyncRoleModelChange _o_ = (SSyncRoleModelChange)_o1_;
/* 157 */       if (this.roleid != _o_.roleid) return false;
/* 158 */       if (!this.intpropmap.equals(_o_.intpropmap)) return false;
/* 159 */       if (!this.stringpropmap.equals(_o_.stringpropmap)) return false;
/* 160 */       if (!this.longpropmap.equals(_o_.longpropmap)) return false;
/* 161 */       return true;
/*     */     }
/* 163 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 167 */     int _h_ = 0;
/* 168 */     _h_ += (int)this.roleid;
/* 169 */     _h_ += this.intpropmap.hashCode();
/* 170 */     _h_ += this.stringpropmap.hashCode();
/* 171 */     _h_ += this.longpropmap.hashCode();
/* 172 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder _sb_ = new StringBuilder();
/* 177 */     _sb_.append("(");
/* 178 */     _sb_.append(this.roleid).append(",");
/* 179 */     _sb_.append(this.intpropmap).append(",");
/* 180 */     _sb_.append(this.stringpropmap).append(",");
/* 181 */     _sb_.append(this.longpropmap).append(",");
/* 182 */     _sb_.append(")");
/* 183 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncRoleModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */