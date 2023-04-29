/*     */ package mzm.gsp.petmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPetMarkDecomposeAllSuccess
/*     */   extends __SPetMarkDecomposeAllSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628500;
/*     */   public HashMap<Integer, Integer> get_score_map;
/*     */   public ArrayList<Long> cost_pet_mark_ids;
/*     */   public HashMap<Integer, Integer> cost_item_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628500;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetMarkDecomposeAllSuccess()
/*     */   {
/*  35 */     this.get_score_map = new HashMap();
/*  36 */     this.cost_pet_mark_ids = new ArrayList();
/*  37 */     this.cost_item_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SPetMarkDecomposeAllSuccess(HashMap<Integer, Integer> _get_score_map_, ArrayList<Long> _cost_pet_mark_ids_, HashMap<Integer, Integer> _cost_item_map_) {
/*  41 */     this.get_score_map = _get_score_map_;
/*  42 */     this.cost_pet_mark_ids = _cost_pet_mark_ids_;
/*  43 */     this.cost_item_map = _cost_item_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.get_score_map.size());
/*  52 */     for (Map.Entry<Integer, Integer> _e_ : this.get_score_map.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  56 */     _os_.compact_uint32(this.cost_pet_mark_ids.size());
/*  57 */     for (Long _v_ : this.cost_pet_mark_ids) {
/*  58 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  60 */     _os_.compact_uint32(this.cost_item_map.size());
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : this.cost_item_map.entrySet()) {
/*  62 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  63 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  71 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  73 */       int _v_ = _os_.unmarshal_int();
/*  74 */       this.get_score_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  76 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  78 */       long _v_ = _os_.unmarshal_long();
/*  79 */       this.cost_pet_mark_ids.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  85 */       int _v_ = _os_.unmarshal_int();
/*  86 */       this.cost_item_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  88 */     if (!_validator_()) {
/*  89 */       throw new VerifyError("validator failed");
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof SPetMarkDecomposeAllSuccess)) {
/*  97 */       SPetMarkDecomposeAllSuccess _o_ = (SPetMarkDecomposeAllSuccess)_o1_;
/*  98 */       if (!this.get_score_map.equals(_o_.get_score_map)) return false;
/*  99 */       if (!this.cost_pet_mark_ids.equals(_o_.cost_pet_mark_ids)) return false;
/* 100 */       if (!this.cost_item_map.equals(_o_.cost_item_map)) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.get_score_map.hashCode();
/* 109 */     _h_ += this.cost_pet_mark_ids.hashCode();
/* 110 */     _h_ += this.cost_item_map.hashCode();
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.get_score_map).append(",");
/* 118 */     _sb_.append(this.cost_pet_mark_ids).append(",");
/* 119 */     _sb_.append(this.cost_item_map).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkDecomposeAllSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */