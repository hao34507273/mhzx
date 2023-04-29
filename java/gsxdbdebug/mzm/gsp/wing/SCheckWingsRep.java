/*     */ package mzm.gsp.wing;
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
/*     */ public class SCheckWingsRep
/*     */   extends __SCheckWingsRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596541;
/*     */   public long roleid;
/*     */   public int curlv;
/*     */   public int currank;
/*     */   public int checkwing;
/*     */   public HashMap<Integer, WingCheckData> wings;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596541;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCheckWingsRep()
/*     */   {
/*  37 */     this.wings = new HashMap();
/*     */   }
/*     */   
/*     */   public SCheckWingsRep(long _roleid_, int _curlv_, int _currank_, int _checkwing_, HashMap<Integer, WingCheckData> _wings_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.curlv = _curlv_;
/*  43 */     this.currank = _currank_;
/*  44 */     this.checkwing = _checkwing_;
/*  45 */     this.wings = _wings_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (Map.Entry<Integer, WingCheckData> _e_ : this.wings.entrySet()) {
/*  50 */       if (!((WingCheckData)_e_.getValue())._validator_()) return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.roleid);
/*  57 */     _os_.marshal(this.curlv);
/*  58 */     _os_.marshal(this.currank);
/*  59 */     _os_.marshal(this.checkwing);
/*  60 */     _os_.compact_uint32(this.wings.size());
/*  61 */     for (Map.Entry<Integer, WingCheckData> _e_ : this.wings.entrySet()) {
/*  62 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  63 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.roleid = _os_.unmarshal_long();
/*  70 */     this.curlv = _os_.unmarshal_int();
/*  71 */     this.currank = _os_.unmarshal_int();
/*  72 */     this.checkwing = _os_.unmarshal_int();
/*  73 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  75 */       int _k_ = _os_.unmarshal_int();
/*  76 */       WingCheckData _v_ = new WingCheckData();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.wings.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SCheckWingsRep)) {
/*  89 */       SCheckWingsRep _o_ = (SCheckWingsRep)_o1_;
/*  90 */       if (this.roleid != _o_.roleid) return false;
/*  91 */       if (this.curlv != _o_.curlv) return false;
/*  92 */       if (this.currank != _o_.currank) return false;
/*  93 */       if (this.checkwing != _o_.checkwing) return false;
/*  94 */       if (!this.wings.equals(_o_.wings)) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += (int)this.roleid;
/* 103 */     _h_ += this.curlv;
/* 104 */     _h_ += this.currank;
/* 105 */     _h_ += this.checkwing;
/* 106 */     _h_ += this.wings.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.roleid).append(",");
/* 114 */     _sb_.append(this.curlv).append(",");
/* 115 */     _sb_.append(this.currank).append(",");
/* 116 */     _sb_.append(this.checkwing).append(",");
/* 117 */     _sb_.append(this.wings).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SCheckWingsRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */