/*     */ package mzm.gsp.children;
/*     */ 
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
/*     */ public class SBreedBabyChildEnd
/*     */   extends __SBreedBabyChildEnd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609311;
/*     */   public long child_id;
/*     */   public int operator;
/*     */   public HashMap<Integer, Integer> now_baby_property;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609311;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBreedBabyChildEnd()
/*     */   {
/*  35 */     this.now_baby_property = new HashMap();
/*     */   }
/*     */   
/*     */   public SBreedBabyChildEnd(long _child_id_, int _operator_, HashMap<Integer, Integer> _now_baby_property_) {
/*  39 */     this.child_id = _child_id_;
/*  40 */     this.operator = _operator_;
/*  41 */     this.now_baby_property = _now_baby_property_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.child_id);
/*  50 */     _os_.marshal(this.operator);
/*  51 */     _os_.compact_uint32(this.now_baby_property.size());
/*  52 */     for (Map.Entry<Integer, Integer> _e_ : this.now_baby_property.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.child_id = _os_.unmarshal_long();
/*  61 */     this.operator = _os_.unmarshal_int();
/*  62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  64 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  66 */       int _v_ = _os_.unmarshal_int();
/*  67 */       this.now_baby_property.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SBreedBabyChildEnd)) {
/*  78 */       SBreedBabyChildEnd _o_ = (SBreedBabyChildEnd)_o1_;
/*  79 */       if (this.child_id != _o_.child_id) return false;
/*  80 */       if (this.operator != _o_.operator) return false;
/*  81 */       if (!this.now_baby_property.equals(_o_.now_baby_property)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.child_id;
/*  90 */     _h_ += this.operator;
/*  91 */     _h_ += this.now_baby_property.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.child_id).append(",");
/*  99 */     _sb_.append(this.operator).append(",");
/* 100 */     _sb_.append(this.now_baby_property).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SBreedBabyChildEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */