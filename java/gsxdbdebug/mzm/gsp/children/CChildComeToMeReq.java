/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.children.main.PCChildComeToMeReq;
/*     */ import mzm.gsp.map.Location;
/*     */ 
/*     */ 
/*     */ public class CChildComeToMeReq
/*     */   extends __CChildComeToMeReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609393;
/*     */   public ArrayList<Location> locations;
/*     */   public long childid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCChildComeToMeReq(roleId, this.childid, this.locations));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12609393;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChildComeToMeReq()
/*     */   {
/*  40 */     this.locations = new ArrayList();
/*     */   }
/*     */   
/*     */   public CChildComeToMeReq(ArrayList<Location> _locations_, long _childid_) {
/*  44 */     this.locations = _locations_;
/*  45 */     this.childid = _childid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (Location _v_ : this.locations)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.compact_uint32(this.locations.size());
/*  56 */     for (Location _v_ : this.locations) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.marshal(this.childid);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       Location _v_ = new Location();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.locations.add(_v_);
/*     */     }
/*  69 */     this.childid = _os_.unmarshal_long();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CChildComeToMeReq)) {
/*  79 */       CChildComeToMeReq _o_ = (CChildComeToMeReq)_o1_;
/*  80 */       if (!this.locations.equals(_o_.locations)) return false;
/*  81 */       if (this.childid != _o_.childid) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.locations.hashCode();
/*  90 */     _h_ += (int)this.childid;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.locations).append(",");
/*  98 */     _sb_.append(this.childid).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildComeToMeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */