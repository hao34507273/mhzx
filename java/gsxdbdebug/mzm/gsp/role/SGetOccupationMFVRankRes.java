/*     */ package mzm.gsp.role;
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
/*     */ 
/*     */ 
/*     */ public class SGetOccupationMFVRankRes
/*     */   extends __SGetOccupationMFVRankRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586030;
/*     */   public int occupationid;
/*     */   public ArrayList<RoleMFVRankData> ranklist;
/*     */   public int myno;
/*     */   public int myvalue;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12586030;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetOccupationMFVRankRes()
/*     */   {
/*  36 */     this.ranklist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetOccupationMFVRankRes(int _occupationid_, ArrayList<RoleMFVRankData> _ranklist_, int _myno_, int _myvalue_) {
/*  40 */     this.occupationid = _occupationid_;
/*  41 */     this.ranklist = _ranklist_;
/*  42 */     this.myno = _myno_;
/*  43 */     this.myvalue = _myvalue_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (RoleMFVRankData _v_ : this.ranklist)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.occupationid);
/*  54 */     _os_.compact_uint32(this.ranklist.size());
/*  55 */     for (RoleMFVRankData _v_ : this.ranklist) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.marshal(this.myno);
/*  59 */     _os_.marshal(this.myvalue);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.occupationid = _os_.unmarshal_int();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       RoleMFVRankData _v_ = new RoleMFVRankData();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.ranklist.add(_v_);
/*     */     }
/*  70 */     this.myno = _os_.unmarshal_int();
/*  71 */     this.myvalue = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetOccupationMFVRankRes)) {
/*  81 */       SGetOccupationMFVRankRes _o_ = (SGetOccupationMFVRankRes)_o1_;
/*  82 */       if (this.occupationid != _o_.occupationid) return false;
/*  83 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/*  84 */       if (this.myno != _o_.myno) return false;
/*  85 */       if (this.myvalue != _o_.myvalue) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.occupationid;
/*  94 */     _h_ += this.ranklist.hashCode();
/*  95 */     _h_ += this.myno;
/*  96 */     _h_ += this.myvalue;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.occupationid).append(",");
/* 104 */     _sb_.append(this.ranklist).append(",");
/* 105 */     _sb_.append(this.myno).append(",");
/* 106 */     _sb_.append(this.myvalue).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SGetOccupationMFVRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */