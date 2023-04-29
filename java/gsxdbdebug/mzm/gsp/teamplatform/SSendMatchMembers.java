/*     */ package mzm.gsp.teamplatform;
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
/*     */ public class SSendMatchMembers
/*     */   extends __SSendMatchMembers__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593680;
/*     */   public ArrayList<TeamInfo> leadersinfo;
/*     */   public int leadersnum;
/*     */   public int rolesnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12593680;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendMatchMembers()
/*     */   {
/*  35 */     this.leadersinfo = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSendMatchMembers(ArrayList<TeamInfo> _leadersinfo_, int _leadersnum_, int _rolesnum_) {
/*  39 */     this.leadersinfo = _leadersinfo_;
/*  40 */     this.leadersnum = _leadersnum_;
/*  41 */     this.rolesnum = _rolesnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (TeamInfo _v_ : this.leadersinfo)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.leadersinfo.size());
/*  52 */     for (TeamInfo _v_ : this.leadersinfo) {
/*  53 */       _os_.marshal(_v_);
/*     */     }
/*  55 */     _os_.marshal(this.leadersnum);
/*  56 */     _os_.marshal(this.rolesnum);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       TeamInfo _v_ = new TeamInfo();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.leadersinfo.add(_v_);
/*     */     }
/*  66 */     this.leadersnum = _os_.unmarshal_int();
/*  67 */     this.rolesnum = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSendMatchMembers)) {
/*  77 */       SSendMatchMembers _o_ = (SSendMatchMembers)_o1_;
/*  78 */       if (!this.leadersinfo.equals(_o_.leadersinfo)) return false;
/*  79 */       if (this.leadersnum != _o_.leadersnum) return false;
/*  80 */       if (this.rolesnum != _o_.rolesnum) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.leadersinfo.hashCode();
/*  89 */     _h_ += this.leadersnum;
/*  90 */     _h_ += this.rolesnum;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.leadersinfo).append(",");
/*  98 */     _sb_.append(this.leadersnum).append(",");
/*  99 */     _sb_.append(this.rolesnum).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\SSendMatchMembers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */