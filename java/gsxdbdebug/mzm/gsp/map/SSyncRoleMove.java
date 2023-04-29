/*     */ package mzm.gsp.map;
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
/*     */ public class SSyncRoleMove
/*     */   extends __SSyncRoleMove__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590883;
/*     */   public long roleid;
/*     */   public ArrayList<Location> keypointpath;
/*     */   public int direction;
/*     */   public int mapid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590883;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRoleMove()
/*     */   {
/*  36 */     this.keypointpath = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncRoleMove(long _roleid_, ArrayList<Location> _keypointpath_, int _direction_, int _mapid_) {
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.keypointpath = _keypointpath_;
/*  42 */     this.direction = _direction_;
/*  43 */     this.mapid = _mapid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (Location _v_ : this.keypointpath)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.compact_uint32(this.keypointpath.size());
/*  55 */     for (Location _v_ : this.keypointpath) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.marshal(this.direction);
/*  59 */     _os_.marshal(this.mapid);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.roleid = _os_.unmarshal_long();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       Location _v_ = new Location();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.keypointpath.add(_v_);
/*     */     }
/*  70 */     this.direction = _os_.unmarshal_int();
/*  71 */     this.mapid = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSyncRoleMove)) {
/*  81 */       SSyncRoleMove _o_ = (SSyncRoleMove)_o1_;
/*  82 */       if (this.roleid != _o_.roleid) return false;
/*  83 */       if (!this.keypointpath.equals(_o_.keypointpath)) return false;
/*  84 */       if (this.direction != _o_.direction) return false;
/*  85 */       if (this.mapid != _o_.mapid) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += (int)this.roleid;
/*  94 */     _h_ += this.keypointpath.hashCode();
/*  95 */     _h_ += this.direction;
/*  96 */     _h_ += this.mapid;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.roleid).append(",");
/* 104 */     _sb_.append(this.keypointpath).append(",");
/* 105 */     _sb_.append(this.direction).append(",");
/* 106 */     _sb_.append(this.mapid).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncRoleMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */