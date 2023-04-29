/*     */ package mzm.gsp.xiulian;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.xiulian.main.PCStudySkillReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CStudySkillReq
/*     */   extends __CStudySkillReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589578;
/*     */   public int skillbagid;
/*     */   public int studycount;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCStudySkillReq(roleId, this.skillbagid, this.studycount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12589578;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CStudySkillReq() {}
/*     */   
/*     */ 
/*     */   public CStudySkillReq(int _skillbagid_, int _studycount_)
/*     */   {
/*  43 */     this.skillbagid = _skillbagid_;
/*  44 */     this.studycount = _studycount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.skillbagid);
/*  53 */     _os_.marshal(this.studycount);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.skillbagid = _os_.unmarshal_int();
/*  59 */     this.studycount = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CStudySkillReq)) {
/*  69 */       CStudySkillReq _o_ = (CStudySkillReq)_o1_;
/*  70 */       if (this.skillbagid != _o_.skillbagid) return false;
/*  71 */       if (this.studycount != _o_.studycount) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.skillbagid;
/*  80 */     _h_ += this.studycount;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.skillbagid).append(",");
/*  88 */     _sb_.append(this.studycount).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CStudySkillReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.skillbagid - _o_.skillbagid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.studycount - _o_.studycount;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\CStudySkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */