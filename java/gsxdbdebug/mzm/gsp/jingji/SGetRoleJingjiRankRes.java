/*     */ package mzm.gsp.jingji;
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
/*     */ public class SGetRoleJingjiRankRes
/*     */   extends __SGetRoleJingjiRankRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595727;
/*     */   public int point;
/*     */   public int myrank;
/*     */   public ArrayList<RoleJingjiRankData> ranklist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595727;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRoleJingjiRankRes()
/*     */   {
/*  35 */     this.ranklist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetRoleJingjiRankRes(int _point_, int _myrank_, ArrayList<RoleJingjiRankData> _ranklist_) {
/*  39 */     this.point = _point_;
/*  40 */     this.myrank = _myrank_;
/*  41 */     this.ranklist = _ranklist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (RoleJingjiRankData _v_ : this.ranklist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.point);
/*  52 */     _os_.marshal(this.myrank);
/*  53 */     _os_.compact_uint32(this.ranklist.size());
/*  54 */     for (RoleJingjiRankData _v_ : this.ranklist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.point = _os_.unmarshal_int();
/*  62 */     this.myrank = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       RoleJingjiRankData _v_ = new RoleJingjiRankData();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.ranklist.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SGetRoleJingjiRankRes)) {
/*  77 */       SGetRoleJingjiRankRes _o_ = (SGetRoleJingjiRankRes)_o1_;
/*  78 */       if (this.point != _o_.point) return false;
/*  79 */       if (this.myrank != _o_.myrank) return false;
/*  80 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.point;
/*  89 */     _h_ += this.myrank;
/*  90 */     _h_ += this.ranklist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.point).append(",");
/*  98 */     _sb_.append(this.myrank).append(",");
/*  99 */     _sb_.append(this.ranklist).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\SGetRoleJingjiRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */