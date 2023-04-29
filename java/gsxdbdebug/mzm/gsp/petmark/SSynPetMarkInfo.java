/*     */ package mzm.gsp.petmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynPetMarkInfo
/*     */   extends __SSynPetMarkInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628503;
/*     */   public HashMap<Long, PetMarkInfo> pet_mark_info_map;
/*     */   public HashMap<Long, Long> pet_mark_equip_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628503;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynPetMarkInfo()
/*     */   {
/*  34 */     this.pet_mark_info_map = new HashMap();
/*  35 */     this.pet_mark_equip_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynPetMarkInfo(HashMap<Long, PetMarkInfo> _pet_mark_info_map_, HashMap<Long, Long> _pet_mark_equip_map_) {
/*  39 */     this.pet_mark_info_map = _pet_mark_info_map_;
/*  40 */     this.pet_mark_equip_map = _pet_mark_equip_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (Map.Entry<Long, PetMarkInfo> _e_ : this.pet_mark_info_map.entrySet()) {
/*  45 */       if (!((PetMarkInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.pet_mark_info_map.size());
/*  52 */     for (Map.Entry<Long, PetMarkInfo> _e_ : this.pet_mark_info_map.entrySet()) {
/*  53 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  54 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  56 */     _os_.compact_uint32(this.pet_mark_equip_map.size());
/*  57 */     for (Map.Entry<Long, Long> _e_ : this.pet_mark_equip_map.entrySet()) {
/*  58 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  59 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       long _k_ = _os_.unmarshal_long();
/*  68 */       PetMarkInfo _v_ = new PetMarkInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.pet_mark_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  72 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  74 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  76 */       long _v_ = _os_.unmarshal_long();
/*  77 */       this.pet_mark_equip_map.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  79 */     if (!_validator_()) {
/*  80 */       throw new VerifyError("validator failed");
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof SSynPetMarkInfo)) {
/*  88 */       SSynPetMarkInfo _o_ = (SSynPetMarkInfo)_o1_;
/*  89 */       if (!this.pet_mark_info_map.equals(_o_.pet_mark_info_map)) return false;
/*  90 */       if (!this.pet_mark_equip_map.equals(_o_.pet_mark_equip_map)) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.pet_mark_info_map.hashCode();
/*  99 */     _h_ += this.pet_mark_equip_map.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.pet_mark_info_map).append(",");
/* 107 */     _sb_.append(this.pet_mark_equip_map).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SSynPetMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */