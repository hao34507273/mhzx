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
/*     */ 
/*     */ public class SGetRoleMFVRankRes
/*     */   extends __SGetRoleMFVRankRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586025;
/*     */   public ArrayList<RoleMFVRankData> ranklist;
/*     */   public int myno;
/*     */   public int myvalue;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12586025;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRoleMFVRankRes()
/*     */   {
/*  35 */     this.ranklist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetRoleMFVRankRes(ArrayList<RoleMFVRankData> _ranklist_, int _myno_, int _myvalue_) {
/*  39 */     this.ranklist = _ranklist_;
/*  40 */     this.myno = _myno_;
/*  41 */     this.myvalue = _myvalue_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (RoleMFVRankData _v_ : this.ranklist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.ranklist.size());
/*  52 */     for (RoleMFVRankData _v_ : this.ranklist) {
/*  53 */       _os_.marshal(_v_);
/*     */     }
/*  55 */     _os_.marshal(this.myno);
/*  56 */     _os_.marshal(this.myvalue);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       RoleMFVRankData _v_ = new RoleMFVRankData();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.ranklist.add(_v_);
/*     */     }
/*  66 */     this.myno = _os_.unmarshal_int();
/*  67 */     this.myvalue = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SGetRoleMFVRankRes)) {
/*  77 */       SGetRoleMFVRankRes _o_ = (SGetRoleMFVRankRes)_o1_;
/*  78 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/*  79 */       if (this.myno != _o_.myno) return false;
/*  80 */       if (this.myvalue != _o_.myvalue) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.ranklist.hashCode();
/*  89 */     _h_ += this.myno;
/*  90 */     _h_ += this.myvalue;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.ranklist).append(",");
/*  98 */     _sb_.append(this.myno).append(",");
/*  99 */     _sb_.append(this.myvalue).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SGetRoleMFVRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */