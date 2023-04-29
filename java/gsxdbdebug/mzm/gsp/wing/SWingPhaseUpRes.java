/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SWingPhaseUpRes
/*     */   extends __SWingPhaseUpRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596483;
/*     */   public int index;
/*     */   public int hasskill;
/*     */   public int mainskillid;
/*     */   public ArrayList<Integer> subskillids;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12596483;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWingPhaseUpRes()
/*     */   {
/*  34 */     this.subskillids = new ArrayList();
/*     */   }
/*     */   
/*     */   public SWingPhaseUpRes(int _index_, int _hasskill_, int _mainskillid_, ArrayList<Integer> _subskillids_) {
/*  38 */     this.index = _index_;
/*  39 */     this.hasskill = _hasskill_;
/*  40 */     this.mainskillid = _mainskillid_;
/*  41 */     this.subskillids = _subskillids_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.index);
/*  50 */     _os_.marshal(this.hasskill);
/*  51 */     _os_.marshal(this.mainskillid);
/*  52 */     _os_.compact_uint32(this.subskillids.size());
/*  53 */     for (Integer _v_ : this.subskillids) {
/*  54 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.index = _os_.unmarshal_int();
/*  61 */     this.hasskill = _os_.unmarshal_int();
/*  62 */     this.mainskillid = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  65 */       int _v_ = _os_.unmarshal_int();
/*  66 */       this.subskillids.add(Integer.valueOf(_v_));
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SWingPhaseUpRes)) {
/*  77 */       SWingPhaseUpRes _o_ = (SWingPhaseUpRes)_o1_;
/*  78 */       if (this.index != _o_.index) return false;
/*  79 */       if (this.hasskill != _o_.hasskill) return false;
/*  80 */       if (this.mainskillid != _o_.mainskillid) return false;
/*  81 */       if (!this.subskillids.equals(_o_.subskillids)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.index;
/*  90 */     _h_ += this.hasskill;
/*  91 */     _h_ += this.mainskillid;
/*  92 */     _h_ += this.subskillids.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.index).append(",");
/* 100 */     _sb_.append(this.hasskill).append(",");
/* 101 */     _sb_.append(this.mainskillid).append(",");
/* 102 */     _sb_.append(this.subskillids).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SWingPhaseUpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */