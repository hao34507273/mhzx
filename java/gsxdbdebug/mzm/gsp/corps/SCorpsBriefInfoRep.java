/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
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
/*     */ public class SCorpsBriefInfoRep
/*     */   extends __SCorpsBriefInfoRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617504;
/*     */   public ArrayList<Long> roleids;
/*     */   public HashMap<Long, CorpsBriefInfo> corpsbriefinfos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617504;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SCorpsBriefInfoRep()
/*     */   {
/*  34 */     this.roleids = new ArrayList();
/*  35 */     this.corpsbriefinfos = new HashMap();
/*     */   }
/*     */   
/*     */   public SCorpsBriefInfoRep(ArrayList<Long> _roleids_, HashMap<Long, CorpsBriefInfo> _corpsbriefinfos_) {
/*  39 */     this.roleids = _roleids_;
/*  40 */     this.corpsbriefinfos = _corpsbriefinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (Map.Entry<Long, CorpsBriefInfo> _e_ : this.corpsbriefinfos.entrySet()) {
/*  45 */       if (!((CorpsBriefInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.roleids.size());
/*  52 */     for (Long _v_ : this.roleids) {
/*  53 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  55 */     _os_.compact_uint32(this.corpsbriefinfos.size());
/*  56 */     for (Map.Entry<Long, CorpsBriefInfo> _e_ : this.corpsbriefinfos.entrySet()) {
/*  57 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  58 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  66 */       long _v_ = _os_.unmarshal_long();
/*  67 */       this.roleids.add(Long.valueOf(_v_));
/*     */     }
/*  69 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  71 */       long _k_ = _os_.unmarshal_long();
/*  72 */       CorpsBriefInfo _v_ = new CorpsBriefInfo();
/*  73 */       _v_.unmarshal(_os_);
/*  74 */       this.corpsbriefinfos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SCorpsBriefInfoRep)) {
/*  85 */       SCorpsBriefInfoRep _o_ = (SCorpsBriefInfoRep)_o1_;
/*  86 */       if (!this.roleids.equals(_o_.roleids)) return false;
/*  87 */       if (!this.corpsbriefinfos.equals(_o_.corpsbriefinfos)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.roleids.hashCode();
/*  96 */     _h_ += this.corpsbriefinfos.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.roleids).append(",");
/* 104 */     _sb_.append(this.corpsbriefinfos).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SCorpsBriefInfoRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */