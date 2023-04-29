/*     */ package mzm.gsp.gangrace;
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
/*     */ 
/*     */ public class SVotingStatusRes
/*     */   extends __SVotingStatusRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602117;
/*     */   public HashMap<Integer, Integer> myvoteinfo;
/*     */   public HashMap<Integer, Integer> idx2votemoney;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602117;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SVotingStatusRes()
/*     */   {
/*  34 */     this.myvoteinfo = new HashMap();
/*  35 */     this.idx2votemoney = new HashMap();
/*     */   }
/*     */   
/*     */   public SVotingStatusRes(HashMap<Integer, Integer> _myvoteinfo_, HashMap<Integer, Integer> _idx2votemoney_) {
/*  39 */     this.myvoteinfo = _myvoteinfo_;
/*  40 */     this.idx2votemoney = _idx2votemoney_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.myvoteinfo.size());
/*  49 */     for (Map.Entry<Integer, Integer> _e_ : this.myvoteinfo.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  53 */     _os_.compact_uint32(this.idx2votemoney.size());
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : this.idx2votemoney.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  64 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  66 */       int _v_ = _os_.unmarshal_int();
/*  67 */       this.myvoteinfo.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  69 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  71 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  73 */       int _v_ = _os_.unmarshal_int();
/*  74 */       this.idx2votemoney.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SVotingStatusRes)) {
/*  85 */       SVotingStatusRes _o_ = (SVotingStatusRes)_o1_;
/*  86 */       if (!this.myvoteinfo.equals(_o_.myvoteinfo)) return false;
/*  87 */       if (!this.idx2votemoney.equals(_o_.idx2votemoney)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.myvoteinfo.hashCode();
/*  96 */     _h_ += this.idx2votemoney.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.myvoteinfo).append(",");
/* 104 */     _sb_.append(this.idx2votemoney).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\SVotingStatusRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */