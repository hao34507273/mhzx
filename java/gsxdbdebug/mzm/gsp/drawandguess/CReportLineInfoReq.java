/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.drawandguess.main.PCReportLineInfoReq;
/*     */ 
/*     */ public class CReportLineInfoReq extends __CReportLineInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617241;
/*     */   public long sessionid;
/*     */   public int line_id;
/*     */   public byte color;
/*     */   public byte size;
/*     */   public ArrayList<PointInfo> point_list;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCReportLineInfoReq(roleId, this.sessionid, new DrawLineInfo(this.line_id, -1, this.color, this.size, this.point_list)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12617241;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CReportLineInfoReq()
/*     */   {
/*  43 */     this.point_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public CReportLineInfoReq(long _sessionid_, int _line_id_, byte _color_, byte _size_, ArrayList<PointInfo> _point_list_) {
/*  47 */     this.sessionid = _sessionid_;
/*  48 */     this.line_id = _line_id_;
/*  49 */     this.color = _color_;
/*  50 */     this.size = _size_;
/*  51 */     this.point_list = _point_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     for (PointInfo _v_ : this.point_list)
/*  56 */       if (!_v_._validator_()) return false;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.sessionid);
/*  62 */     _os_.marshal(this.line_id);
/*  63 */     _os_.marshal(this.color);
/*  64 */     _os_.marshal(this.size);
/*  65 */     _os_.compact_uint32(this.point_list.size());
/*  66 */     for (PointInfo _v_ : this.point_list) {
/*  67 */       _os_.marshal(_v_);
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     this.sessionid = _os_.unmarshal_long();
/*  74 */     this.line_id = _os_.unmarshal_int();
/*  75 */     this.color = _os_.unmarshal_byte();
/*  76 */     this.size = _os_.unmarshal_byte();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  78 */       PointInfo _v_ = new PointInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.point_list.add(_v_);
/*     */     }
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof CReportLineInfoReq)) {
/*  91 */       CReportLineInfoReq _o_ = (CReportLineInfoReq)_o1_;
/*  92 */       if (this.sessionid != _o_.sessionid) return false;
/*  93 */       if (this.line_id != _o_.line_id) return false;
/*  94 */       if (this.color != _o_.color) return false;
/*  95 */       if (this.size != _o_.size) return false;
/*  96 */       if (!this.point_list.equals(_o_.point_list)) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += (int)this.sessionid;
/* 105 */     _h_ += this.line_id;
/* 106 */     _h_ += this.color;
/* 107 */     _h_ += this.size;
/* 108 */     _h_ += this.point_list.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.sessionid).append(",");
/* 116 */     _sb_.append(this.line_id).append(",");
/* 117 */     _sb_.append(this.color).append(",");
/* 118 */     _sb_.append(this.size).append(",");
/* 119 */     _sb_.append(this.point_list).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\CReportLineInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */