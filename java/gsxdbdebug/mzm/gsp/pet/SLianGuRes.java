/*     */ package mzm.gsp.pet;
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
/*     */ public class SLianGuRes
/*     */   extends __SLianGuRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590605;
/*     */   public long petid;
/*     */   public HashMap<Integer, Integer> aptmap;
/*     */   public int lianguitemleft;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590605;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLianGuRes()
/*     */   {
/*  35 */     this.aptmap = new HashMap();
/*     */   }
/*     */   
/*     */   public SLianGuRes(long _petid_, HashMap<Integer, Integer> _aptmap_, int _lianguitemleft_) {
/*  39 */     this.petid = _petid_;
/*  40 */     this.aptmap = _aptmap_;
/*  41 */     this.lianguitemleft = _lianguitemleft_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.petid);
/*  50 */     _os_.compact_uint32(this.aptmap.size());
/*  51 */     for (Map.Entry<Integer, Integer> _e_ : this.aptmap.entrySet()) {
/*  52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  55 */     _os_.marshal(this.lianguitemleft);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.petid = _os_.unmarshal_long();
/*  61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  63 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  65 */       int _v_ = _os_.unmarshal_int();
/*  66 */       this.aptmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  68 */     this.lianguitemleft = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SLianGuRes)) {
/*  78 */       SLianGuRes _o_ = (SLianGuRes)_o1_;
/*  79 */       if (this.petid != _o_.petid) return false;
/*  80 */       if (!this.aptmap.equals(_o_.aptmap)) return false;
/*  81 */       if (this.lianguitemleft != _o_.lianguitemleft) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.petid;
/*  90 */     _h_ += this.aptmap.hashCode();
/*  91 */     _h_ += this.lianguitemleft;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.petid).append(",");
/*  99 */     _sb_.append(this.aptmap).append(",");
/* 100 */     _sb_.append(this.lianguitemleft).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SLianGuRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */