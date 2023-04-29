/*     */ package mzm.gsp.mourn;
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
/*     */ public class SSynMournInfo
/*     */   extends __SSynMournInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613383;
/*     */   public HashMap<Integer, MTaskInfo> mourninfos;
/*     */   public int questiontaskstate;
/*     */   public ArrayList<Integer> sort;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613383;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynMournInfo()
/*     */   {
/*  35 */     this.mourninfos = new HashMap();
/*  36 */     this.sort = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynMournInfo(HashMap<Integer, MTaskInfo> _mourninfos_, int _questiontaskstate_, ArrayList<Integer> _sort_) {
/*  40 */     this.mourninfos = _mourninfos_;
/*  41 */     this.questiontaskstate = _questiontaskstate_;
/*  42 */     this.sort = _sort_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Integer, MTaskInfo> _e_ : this.mourninfos.entrySet()) {
/*  47 */       if (!((MTaskInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.compact_uint32(this.mourninfos.size());
/*  54 */     for (Map.Entry<Integer, MTaskInfo> _e_ : this.mourninfos.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  58 */     _os_.marshal(this.questiontaskstate);
/*  59 */     _os_.compact_uint32(this.sort.size());
/*  60 */     for (Integer _v_ : this.sort) {
/*  61 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*  70 */       MTaskInfo _v_ = new MTaskInfo();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.mourninfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  74 */     this.questiontaskstate = _os_.unmarshal_int();
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  77 */       int _v_ = _os_.unmarshal_int();
/*  78 */       this.sort.add(Integer.valueOf(_v_));
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SSynMournInfo)) {
/*  89 */       SSynMournInfo _o_ = (SSynMournInfo)_o1_;
/*  90 */       if (!this.mourninfos.equals(_o_.mourninfos)) return false;
/*  91 */       if (this.questiontaskstate != _o_.questiontaskstate) return false;
/*  92 */       if (!this.sort.equals(_o_.sort)) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.mourninfos.hashCode();
/* 101 */     _h_ += this.questiontaskstate;
/* 102 */     _h_ += this.sort.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.mourninfos).append(",");
/* 110 */     _sb_.append(this.questiontaskstate).append(",");
/* 111 */     _sb_.append(this.sort).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\SSynMournInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */