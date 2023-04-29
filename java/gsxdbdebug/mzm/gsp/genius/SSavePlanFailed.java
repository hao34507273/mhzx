/*     */ package mzm.gsp.genius;
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
/*     */ public class SSavePlanFailed
/*     */   extends __SSavePlanFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613891;
/*     */   public static final int ERROR_POINT_NOT_ENOUGH = -1;
/*     */   public int genius_series_id;
/*     */   public HashMap<Integer, Integer> genius_skills;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613891;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSavePlanFailed()
/*     */   {
/*  37 */     this.genius_skills = new HashMap();
/*     */   }
/*     */   
/*     */   public SSavePlanFailed(int _genius_series_id_, HashMap<Integer, Integer> _genius_skills_, int _retcode_) {
/*  41 */     this.genius_series_id = _genius_series_id_;
/*  42 */     this.genius_skills = _genius_skills_;
/*  43 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.genius_series_id);
/*  52 */     _os_.compact_uint32(this.genius_skills.size());
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : this.genius_skills.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     _os_.marshal(this.retcode);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.genius_series_id = _os_.unmarshal_int();
/*  63 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  65 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.genius_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  70 */     this.retcode = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SSavePlanFailed)) {
/*  80 */       SSavePlanFailed _o_ = (SSavePlanFailed)_o1_;
/*  81 */       if (this.genius_series_id != _o_.genius_series_id) return false;
/*  82 */       if (!this.genius_skills.equals(_o_.genius_skills)) return false;
/*  83 */       if (this.retcode != _o_.retcode) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.genius_series_id;
/*  92 */     _h_ += this.genius_skills.hashCode();
/*  93 */     _h_ += this.retcode;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.genius_series_id).append(",");
/* 101 */     _sb_.append(this.genius_skills).append(",");
/* 102 */     _sb_.append(this.retcode).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\SSavePlanFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */