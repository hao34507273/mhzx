/*     */ package mzm.gsp.signaward;
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
/*     */ public class SSynAwardedRes
/*     */   extends __SSynAwardedRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593421;
/*     */   public ArrayList<Integer> awardedtimes;
/*     */   public HashMap<Integer, Integer> item2num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12593421;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynAwardedRes()
/*     */   {
/*  32 */     this.awardedtimes = new ArrayList();
/*  33 */     this.item2num = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynAwardedRes(ArrayList<Integer> _awardedtimes_, HashMap<Integer, Integer> _item2num_) {
/*  37 */     this.awardedtimes = _awardedtimes_;
/*  38 */     this.item2num = _item2num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.compact_uint32(this.awardedtimes.size());
/*  47 */     for (Integer _v_ : this.awardedtimes) {
/*  48 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  50 */     _os_.compact_uint32(this.item2num.size());
/*  51 */     for (Map.Entry<Integer, Integer> _e_ : this.item2num.entrySet()) {
/*  52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  61 */       int _v_ = _os_.unmarshal_int();
/*  62 */       this.awardedtimes.add(Integer.valueOf(_v_));
/*     */     }
/*  64 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  66 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  68 */       int _v_ = _os_.unmarshal_int();
/*  69 */       this.item2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SSynAwardedRes)) {
/*  80 */       SSynAwardedRes _o_ = (SSynAwardedRes)_o1_;
/*  81 */       if (!this.awardedtimes.equals(_o_.awardedtimes)) return false;
/*  82 */       if (!this.item2num.equals(_o_.item2num)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.awardedtimes.hashCode();
/*  91 */     _h_ += this.item2num.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.awardedtimes).append(",");
/*  99 */     _sb_.append(this.item2num).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SSynAwardedRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */