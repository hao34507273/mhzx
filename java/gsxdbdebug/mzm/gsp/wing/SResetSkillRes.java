/*     */ package mzm.gsp.wing;
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
/*     */ public class SResetSkillRes
/*     */   extends __SResetSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596514;
/*     */   public int index;
/*     */   public int skillindex;
/*     */   public int mainskillid;
/*     */   public HashMap<Integer, Integer> index2subskillid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596514;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SResetSkillRes()
/*     */   {
/*  36 */     this.index2subskillid = new HashMap();
/*     */   }
/*     */   
/*     */   public SResetSkillRes(int _index_, int _skillindex_, int _mainskillid_, HashMap<Integer, Integer> _index2subskillid_) {
/*  40 */     this.index = _index_;
/*  41 */     this.skillindex = _skillindex_;
/*  42 */     this.mainskillid = _mainskillid_;
/*  43 */     this.index2subskillid = _index2subskillid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.index);
/*  52 */     _os_.marshal(this.skillindex);
/*  53 */     _os_.marshal(this.mainskillid);
/*  54 */     _os_.compact_uint32(this.index2subskillid.size());
/*  55 */     for (Map.Entry<Integer, Integer> _e_ : this.index2subskillid.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.index = _os_.unmarshal_int();
/*  64 */     this.skillindex = _os_.unmarshal_int();
/*  65 */     this.mainskillid = _os_.unmarshal_int();
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.index2subskillid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SResetSkillRes)) {
/*  82 */       SResetSkillRes _o_ = (SResetSkillRes)_o1_;
/*  83 */       if (this.index != _o_.index) return false;
/*  84 */       if (this.skillindex != _o_.skillindex) return false;
/*  85 */       if (this.mainskillid != _o_.mainskillid) return false;
/*  86 */       if (!this.index2subskillid.equals(_o_.index2subskillid)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.index;
/*  95 */     _h_ += this.skillindex;
/*  96 */     _h_ += this.mainskillid;
/*  97 */     _h_ += this.index2subskillid.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.index).append(",");
/* 105 */     _sb_.append(this.skillindex).append(",");
/* 106 */     _sb_.append(this.mainskillid).append(",");
/* 107 */     _sb_.append(this.index2subskillid).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SResetSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */