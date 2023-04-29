/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class NPCModelInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int TITLEID = 0;
/*     */   public static final int APPELLATIONID = 1;
/*     */   public static final int RIDE_ID = 2;
/*     */   public static final int RIDE_COLOR_ID = 3;
/*     */   public static final int NAME = 0;
/*     */   public static final int APPELLATION = 1;
/*     */   public long id;
/*     */   public ModelInfo model;
/*     */   public HashMap<Integer, Integer> int_props;
/*     */   public HashMap<Integer, String> string_props;
/*     */   
/*     */   public NPCModelInfo()
/*     */   {
/*  22 */     this.model = new ModelInfo();
/*  23 */     this.int_props = new HashMap();
/*  24 */     this.string_props = new HashMap();
/*     */   }
/*     */   
/*     */   public NPCModelInfo(long _id_, ModelInfo _model_, HashMap<Integer, Integer> _int_props_, HashMap<Integer, String> _string_props_) {
/*  28 */     this.id = _id_;
/*  29 */     this.model = _model_;
/*  30 */     this.int_props = _int_props_;
/*  31 */     this.string_props = _string_props_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     if (!this.model._validator_()) return false;
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.id);
/*  41 */     _os_.marshal(this.model);
/*  42 */     _os_.compact_uint32(this.int_props.size());
/*  43 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.int_props.entrySet()) {
/*  44 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  45 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  47 */     _os_.compact_uint32(this.string_props.size());
/*  48 */     for (java.util.Map.Entry<Integer, String> _e_ : this.string_props.entrySet()) {
/*  49 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  50 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  56 */     this.id = _os_.unmarshal_long();
/*  57 */     this.model.unmarshal(_os_);
/*  58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  60 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  62 */       int _v_ = _os_.unmarshal_int();
/*  63 */       this.int_props.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  69 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  70 */       this.string_props.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof NPCModelInfo)) {
/*  78 */       NPCModelInfo _o_ = (NPCModelInfo)_o1_;
/*  79 */       if (this.id != _o_.id) return false;
/*  80 */       if (!this.model.equals(_o_.model)) return false;
/*  81 */       if (!this.int_props.equals(_o_.int_props)) return false;
/*  82 */       if (!this.string_props.equals(_o_.string_props)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.id;
/*  91 */     _h_ += this.model.hashCode();
/*  92 */     _h_ += this.int_props.hashCode();
/*  93 */     _h_ += this.string_props.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.id).append(",");
/* 101 */     _sb_.append(this.model).append(",");
/* 102 */     _sb_.append(this.int_props).append(",");
/* 103 */     _sb_.append(this.string_props).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\NPCModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */