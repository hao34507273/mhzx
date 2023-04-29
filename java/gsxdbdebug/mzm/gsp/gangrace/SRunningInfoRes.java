/*     */ package mzm.gsp.gangrace;
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
/*     */ 
/*     */ public class SRunningInfoRes
/*     */   extends __SRunningInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602123;
/*     */   public ArrayList<RunningInfo> runninginfos;
/*     */   public int begintime;
/*     */   public HashMap<Integer, Integer> ranks;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602123;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRunningInfoRes()
/*     */   {
/*  35 */     this.runninginfos = new ArrayList();
/*  36 */     this.ranks = new HashMap();
/*     */   }
/*     */   
/*     */   public SRunningInfoRes(ArrayList<RunningInfo> _runninginfos_, int _begintime_, HashMap<Integer, Integer> _ranks_) {
/*  40 */     this.runninginfos = _runninginfos_;
/*  41 */     this.begintime = _begintime_;
/*  42 */     this.ranks = _ranks_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (RunningInfo _v_ : this.runninginfos)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.runninginfos.size());
/*  53 */     for (RunningInfo _v_ : this.runninginfos) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.marshal(this.begintime);
/*  57 */     _os_.compact_uint32(this.ranks.size());
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : this.ranks.entrySet()) {
/*  59 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  60 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  67 */       RunningInfo _v_ = new RunningInfo();
/*  68 */       _v_.unmarshal(_os_);
/*  69 */       this.runninginfos.add(_v_);
/*     */     }
/*  71 */     this.begintime = _os_.unmarshal_int();
/*  72 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  74 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  76 */       int _v_ = _os_.unmarshal_int();
/*  77 */       this.ranks.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  79 */     if (!_validator_()) {
/*  80 */       throw new VerifyError("validator failed");
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof SRunningInfoRes)) {
/*  88 */       SRunningInfoRes _o_ = (SRunningInfoRes)_o1_;
/*  89 */       if (!this.runninginfos.equals(_o_.runninginfos)) return false;
/*  90 */       if (this.begintime != _o_.begintime) return false;
/*  91 */       if (!this.ranks.equals(_o_.ranks)) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.runninginfos.hashCode();
/* 100 */     _h_ += this.begintime;
/* 101 */     _h_ += this.ranks.hashCode();
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(this.runninginfos).append(",");
/* 109 */     _sb_.append(this.begintime).append(",");
/* 110 */     _sb_.append(this.ranks).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\SRunningInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */