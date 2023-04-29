/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.drawandguess.main.PCAppendLineInfoReq;
/*     */ 
/*     */ 
/*     */ public class CAppendLineInfoReq
/*     */   extends __CAppendLineInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617231;
/*     */   public long sessionid;
/*     */   public int line_id;
/*     */   public ArrayList<PointInfo> point_list;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCAppendLineInfoReq(roleId, this.sessionid, this.line_id, this.point_list));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12617231;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAppendLineInfoReq()
/*     */   {
/*  41 */     this.point_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public CAppendLineInfoReq(long _sessionid_, int _line_id_, ArrayList<PointInfo> _point_list_) {
/*  45 */     this.sessionid = _sessionid_;
/*  46 */     this.line_id = _line_id_;
/*  47 */     this.point_list = _point_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (PointInfo _v_ : this.point_list)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.sessionid);
/*  58 */     _os_.marshal(this.line_id);
/*  59 */     _os_.compact_uint32(this.point_list.size());
/*  60 */     for (PointInfo _v_ : this.point_list) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.sessionid = _os_.unmarshal_long();
/*  68 */     this.line_id = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       PointInfo _v_ = new PointInfo();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.point_list.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof CAppendLineInfoReq)) {
/*  83 */       CAppendLineInfoReq _o_ = (CAppendLineInfoReq)_o1_;
/*  84 */       if (this.sessionid != _o_.sessionid) return false;
/*  85 */       if (this.line_id != _o_.line_id) return false;
/*  86 */       if (!this.point_list.equals(_o_.point_list)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.sessionid;
/*  95 */     _h_ += this.line_id;
/*  96 */     _h_ += this.point_list.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.sessionid).append(",");
/* 104 */     _sb_.append(this.line_id).append(",");
/* 105 */     _sb_.append(this.point_list).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\CAppendLineInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */