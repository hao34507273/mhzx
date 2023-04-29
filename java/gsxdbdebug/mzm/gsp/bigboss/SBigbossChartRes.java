/*     */ package mzm.gsp.bigboss;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBigbossChartRes
/*     */   extends __SBigbossChartRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598024;
/*     */   public int startpos;
/*     */   public int num;
/*     */   public int ocp;
/*     */   public int point;
/*     */   public int myrank;
/*     */   public ArrayList<BigbossRankData> ranklist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12598024;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBigbossChartRes()
/*     */   {
/*  36 */     this.ranklist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SBigbossChartRes(int _startpos_, int _num_, int _ocp_, int _point_, int _myrank_, ArrayList<BigbossRankData> _ranklist_) {
/*  40 */     this.startpos = _startpos_;
/*  41 */     this.num = _num_;
/*  42 */     this.ocp = _ocp_;
/*  43 */     this.point = _point_;
/*  44 */     this.myrank = _myrank_;
/*  45 */     this.ranklist = _ranklist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (BigbossRankData _v_ : this.ranklist)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.startpos);
/*  56 */     _os_.marshal(this.num);
/*  57 */     _os_.marshal(this.ocp);
/*  58 */     _os_.marshal(this.point);
/*  59 */     _os_.marshal(this.myrank);
/*  60 */     _os_.compact_uint32(this.ranklist.size());
/*  61 */     for (BigbossRankData _v_ : this.ranklist) {
/*  62 */       _os_.marshal(_v_);
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.startpos = _os_.unmarshal_int();
/*  69 */     this.num = _os_.unmarshal_int();
/*  70 */     this.ocp = _os_.unmarshal_int();
/*  71 */     this.point = _os_.unmarshal_int();
/*  72 */     this.myrank = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  74 */       BigbossRankData _v_ = new BigbossRankData();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.ranklist.add(_v_);
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SBigbossChartRes)) {
/*  87 */       SBigbossChartRes _o_ = (SBigbossChartRes)_o1_;
/*  88 */       if (this.startpos != _o_.startpos) return false;
/*  89 */       if (this.num != _o_.num) return false;
/*  90 */       if (this.ocp != _o_.ocp) return false;
/*  91 */       if (this.point != _o_.point) return false;
/*  92 */       if (this.myrank != _o_.myrank) return false;
/*  93 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.startpos;
/* 102 */     _h_ += this.num;
/* 103 */     _h_ += this.ocp;
/* 104 */     _h_ += this.point;
/* 105 */     _h_ += this.myrank;
/* 106 */     _h_ += this.ranklist.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.startpos).append(",");
/* 114 */     _sb_.append(this.num).append(",");
/* 115 */     _sb_.append(this.ocp).append(",");
/* 116 */     _sb_.append(this.point).append(",");
/* 117 */     _sb_.append(this.myrank).append(",");
/* 118 */     _sb_.append(this.ranklist).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SBigbossChartRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */