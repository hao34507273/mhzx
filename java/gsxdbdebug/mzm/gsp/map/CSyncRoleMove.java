/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.map.main.PCSyncRoleMove;
/*     */ 
/*     */ 
/*     */ public class CSyncRoleMove
/*     */   extends __CSyncRoleMove__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590889;
/*     */   public ArrayList<Location> keypointpath;
/*     */   public int mapid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     gnet.link.Role role = Onlines.getInstance().find(this);
/*  20 */     if (role == null)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     long roleid = role.getRoleid();
/*  25 */     mzm.gsp.Role.addRoleProcedure(roleid, new PCSyncRoleMove(roleid, this.mapid, this.keypointpath));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12590889;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CSyncRoleMove()
/*     */   {
/*  40 */     this.keypointpath = new ArrayList();
/*     */   }
/*     */   
/*     */   public CSyncRoleMove(ArrayList<Location> _keypointpath_, int _mapid_) {
/*  44 */     this.keypointpath = _keypointpath_;
/*  45 */     this.mapid = _mapid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (Location _v_ : this.keypointpath)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.compact_uint32(this.keypointpath.size());
/*  56 */     for (Location _v_ : this.keypointpath) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.marshal(this.mapid);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       Location _v_ = new Location();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.keypointpath.add(_v_);
/*     */     }
/*  69 */     this.mapid = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CSyncRoleMove)) {
/*  79 */       CSyncRoleMove _o_ = (CSyncRoleMove)_o1_;
/*  80 */       if (!this.keypointpath.equals(_o_.keypointpath)) return false;
/*  81 */       if (this.mapid != _o_.mapid) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.keypointpath.hashCode();
/*  90 */     _h_ += this.mapid;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.keypointpath).append(",");
/*  98 */     _sb_.append(this.mapid).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CSyncRoleMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */