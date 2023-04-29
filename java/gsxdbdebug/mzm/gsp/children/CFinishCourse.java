/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.childhood.PCFinishCourse;
/*     */ 
/*     */ 
/*     */ public class CFinishCourse
/*     */   extends __CFinishCourse__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609301;
/*     */   public long childid;
/*     */   public int course_type;
/*     */   public long client_yuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCFinishCourse(roleId, this.childid, this.course_type, this.client_yuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12609301;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CFinishCourse() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CFinishCourse(long _childid_, int _course_type_, long _client_yuanbao_)
/*     */   {
/*  43 */     this.childid = _childid_;
/*  44 */     this.course_type = _course_type_;
/*  45 */     this.client_yuanbao = _client_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.childid);
/*  54 */     _os_.marshal(this.course_type);
/*  55 */     _os_.marshal(this.client_yuanbao);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.childid = _os_.unmarshal_long();
/*  61 */     this.course_type = _os_.unmarshal_int();
/*  62 */     this.client_yuanbao = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CFinishCourse)) {
/*  72 */       CFinishCourse _o_ = (CFinishCourse)_o1_;
/*  73 */       if (this.childid != _o_.childid) return false;
/*  74 */       if (this.course_type != _o_.course_type) return false;
/*  75 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.childid;
/*  84 */     _h_ += this.course_type;
/*  85 */     _h_ += (int)this.client_yuanbao;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.childid).append(",");
/*  93 */     _sb_.append(this.course_type).append(",");
/*  94 */     _sb_.append(this.client_yuanbao).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFinishCourse _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.course_type - _o_.course_type;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CFinishCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */