/*     */ package mzm.gsp.pubdata;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class ModelInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int WEAPON = 1;
/*     */   public static final int WING = 2;
/*     */   public static final int WING_COLOR_ID = 3;
/*     */   public static final int FABAO = 4;
/*     */   public static final int QILING_LEVEL = 5;
/*     */   public static final int SCALE_RATE = 6;
/*     */   public static final int HAIR_COLOR_ID = 7;
/*     */   public static final int CLOTH_COLOR_ID = 8;
/*     */   public static final int PET_SHIPIN = 9;
/*     */   public static final int AIRCRAFT = 10;
/*     */   public static final int OUTLOOK_ID = 11;
/*     */   public static final int COLOR_ID = 12;
/*     */   public static final int EXTERIOR_ID = 13;
/*     */   public static final int FASHION_DRESS_ID = 14;
/*     */   public static final int WEAPON_EFFECT_ID = 15;
/*     */   public static final int QILING_EFFECT_LEVEL = 16;
/*     */   public static final int PET_STAGE_LEVEL = 17;
/*     */   public static final int EXPRESS_PLAY_ACTION = 18;
/*     */   public static final int MOUNTS_ID = 19;
/*     */   public static final int MOUNTS_COLOR_ID = 20;
/*     */   public static final int MOUNTS_RANK = 21;
/*     */   public static final int PET_EXTERIOR_ID = 22;
/*     */   public static final int PET_EXTERIOR_COLOR_ID = 23;
/*     */   public static final int MAGIC_MARK = 24;
/*     */   public static final int CHILDREN_PHASE = 25;
/*     */   public static final int CHILDREN_GENDER = 26;
/*     */   public static final int CHILDREN_FASHION = 27;
/*     */   public static final int CHILDREN_MODEL_ID = 28;
/*     */   public static final int CHILDREN_WEAPON_ID = 29;
/*     */   public static final int FABAO_LINGQI = 30;
/*     */   public static final int WUSHI_ID = 31;
/*     */   public static final int GENDER = 32;
/*     */   public static final int OCCUPATION = 33;
/*     */   public static final int MORAL_VALUE = 34;
/*     */   public static final int CHANGE_MODEL_CARD_CFGID = 35;
/*     */   public static final int CHANGE_MODEL_CARD_LEVEL = 36;
/*     */   public static final int CHANGE_MODEL_CARD_MINI = 37;
/*     */   public static final int AIRCRAFT_COLOR_ID = 38;
/*     */   public static final int PET_MARK_CFG_ID = 39;
/*     */   public int modelid;
/*     */   public String name;
/*     */   public HashMap<Integer, Integer> extramap;
/*     */   
/*     */   public ModelInfo()
/*     */   {
/*  54 */     this.name = "";
/*  55 */     this.extramap = new HashMap();
/*     */   }
/*     */   
/*     */   public ModelInfo(int _modelid_, String _name_, HashMap<Integer, Integer> _extramap_) {
/*  59 */     this.modelid = _modelid_;
/*  60 */     this.name = _name_;
/*  61 */     this.extramap = _extramap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  69 */     _os_.marshal(this.modelid);
/*  70 */     _os_.marshal(this.name, "UTF-16LE");
/*  71 */     _os_.compact_uint32(this.extramap.size());
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : this.extramap.entrySet()) {
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  80 */     this.modelid = _os_.unmarshal_int();
/*  81 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  86 */       int _v_ = _os_.unmarshal_int();
/*  87 */       this.extramap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof ModelInfo)) {
/*  95 */       ModelInfo _o_ = (ModelInfo)_o1_;
/*  96 */       if (this.modelid != _o_.modelid) return false;
/*  97 */       if (!this.name.equals(_o_.name)) return false;
/*  98 */       if (!this.extramap.equals(_o_.extramap)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.modelid;
/* 107 */     _h_ += this.name.hashCode();
/* 108 */     _h_ += this.extramap.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.modelid).append(",");
/* 116 */     _sb_.append("T").append(this.name.length()).append(",");
/* 117 */     _sb_.append(this.extramap).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pubdata\ModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */