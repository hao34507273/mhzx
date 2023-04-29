/*     */ package mzm.gsp.item;
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
/*     */ public class SItemCompoundAllRes
/*     */   extends __SItemCompoundAllRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584875;
/*     */   public HashMap<Integer, Integer> compounditemid2num;
/*     */   public HashMap<Integer, Integer> costitemid2num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584875;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SItemCompoundAllRes()
/*     */   {
/*  32 */     this.compounditemid2num = new HashMap();
/*  33 */     this.costitemid2num = new HashMap();
/*     */   }
/*     */   
/*     */   public SItemCompoundAllRes(HashMap<Integer, Integer> _compounditemid2num_, HashMap<Integer, Integer> _costitemid2num_) {
/*  37 */     this.compounditemid2num = _compounditemid2num_;
/*  38 */     this.costitemid2num = _costitemid2num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.compact_uint32(this.compounditemid2num.size());
/*  47 */     for (Map.Entry<Integer, Integer> _e_ : this.compounditemid2num.entrySet()) {
/*  48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  51 */     _os_.compact_uint32(this.costitemid2num.size());
/*  52 */     for (Map.Entry<Integer, Integer> _e_ : this.costitemid2num.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  62 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  64 */       int _v_ = _os_.unmarshal_int();
/*  65 */       this.compounditemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.costitemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SItemCompoundAllRes)) {
/*  83 */       SItemCompoundAllRes _o_ = (SItemCompoundAllRes)_o1_;
/*  84 */       if (!this.compounditemid2num.equals(_o_.compounditemid2num)) return false;
/*  85 */       if (!this.costitemid2num.equals(_o_.costitemid2num)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.compounditemid2num.hashCode();
/*  94 */     _h_ += this.costitemid2num.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.compounditemid2num).append(",");
/* 102 */     _sb_.append(this.costitemid2num).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SItemCompoundAllRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */